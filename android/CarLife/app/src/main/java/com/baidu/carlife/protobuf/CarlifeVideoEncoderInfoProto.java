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

public final class CarlifeVideoEncoderInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeVideoEncoderInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeVideoEncoderInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeVideoEncoderInfoProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeVideoEncoderInfoProto.access$002((Descriptors.Descriptor)CarlifeVideoEncoderInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeVideoEncoderInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeVideoEncoderInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeVideoEncoderInfo_descriptor, new String[] { "Width", "Height", "FrameRate" }, CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.class, CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\"CarlifeVideoEncoderInfoProto.proto\022\032com.baidu.carlife.protobuf\"K\n\027CarlifeVideoEncoderInfo\022\r\n\005width\030\001 \002(\005\022\016\n\006height\030\002 \002(\005\022\021\n\tframeRate\030\003 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeVideoEncoderInfo
    extends GeneratedMessage
  {
    public static final int FRAMERATE_FIELD_NUMBER = 3;
    public static final int HEIGHT_FIELD_NUMBER = 2;
    public static final int WIDTH_FIELD_NUMBER = 1;
    private static final CarlifeVideoEncoderInfo defaultInstance = new CarlifeVideoEncoderInfo();
    private int frameRate_ = 0;
    private boolean hasFrameRate;
    private boolean hasHeight;
    private boolean hasWidth;
    private int height_ = 0;
    private int memoizedSerializedSize = -1;
    private int width_ = 0;
    
    static
    {
      CarlifeVideoEncoderInfoProto.getDescriptor();
      CarlifeVideoEncoderInfoProto.internalForceInit();
    }
    
    public static CarlifeVideoEncoderInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeVideoEncoderInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeVideoEncoderInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeVideoEncoderInfo paramCarlifeVideoEncoderInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeVideoEncoderInfo);
    }
    
    public static CarlifeVideoEncoderInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeVideoEncoderInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeVideoEncoderInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getFrameRate()
    {
      return this.frameRate_;
    }
    
    public int getHeight()
    {
      return this.height_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasWidth()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getWidth());
      }
      i = j;
      if (hasHeight()) {
        i = j + CodedOutputStream.computeInt32Size(2, getHeight());
      }
      j = i;
      if (hasFrameRate()) {
        j = i + CodedOutputStream.computeInt32Size(3, getFrameRate());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getWidth()
    {
      return this.width_;
    }
    
    public boolean hasFrameRate()
    {
      return this.hasFrameRate;
    }
    
    public boolean hasHeight()
    {
      return this.hasHeight;
    }
    
    public boolean hasWidth()
    {
      return this.hasWidth;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeVideoEncoderInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeVideoEncoderInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasWidth) {}
      while ((!this.hasHeight) || (!this.hasFrameRate)) {
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
      if (hasWidth()) {
        paramCodedOutputStream.writeInt32(1, getWidth());
      }
      if (hasHeight()) {
        paramCodedOutputStream.writeInt32(2, getHeight());
      }
      if (hasFrameRate()) {
        paramCodedOutputStream.writeInt32(3, getFrameRate());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo result;
      
      private CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo buildParsed()
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
        localBuilder.result = new CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo(null);
        return localBuilder;
      }
      
      public CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo localCarlifeVideoEncoderInfo = this.result;
        this.result = null;
        return localCarlifeVideoEncoderInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo(null);
        return this;
      }
      
      public Builder clearFrameRate()
      {
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$902(this.result, false);
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearHeight()
      {
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$702(this.result, false);
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearWidth()
      {
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$502(this.result, false);
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo getDefaultInstanceForType()
      {
        return CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.getDescriptor();
      }
      
      public int getFrameRate()
      {
        return this.result.getFrameRate();
      }
      
      public int getHeight()
      {
        return this.result.getHeight();
      }
      
      public int getWidth()
      {
        return this.result.getWidth();
      }
      
      public boolean hasFrameRate()
      {
        return this.result.hasFrameRate();
      }
      
      public boolean hasHeight()
      {
        return this.result.hasHeight();
      }
      
      public boolean hasWidth()
      {
        return this.result.hasWidth();
      }
      
      protected CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo paramCarlifeVideoEncoderInfo)
      {
        if (paramCarlifeVideoEncoderInfo == CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeVideoEncoderInfo.hasWidth()) {
          setWidth(paramCarlifeVideoEncoderInfo.getWidth());
        }
        if (paramCarlifeVideoEncoderInfo.hasHeight()) {
          setHeight(paramCarlifeVideoEncoderInfo.getHeight());
        }
        if (paramCarlifeVideoEncoderInfo.hasFrameRate()) {
          setFrameRate(paramCarlifeVideoEncoderInfo.getFrameRate());
        }
        mergeUnknownFields(paramCarlifeVideoEncoderInfo.getUnknownFields());
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
            setWidth(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setHeight(paramCodedInputStream.readInt32());
            break;
          case 24: 
            setFrameRate(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo)) {
          return mergeFrom((CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setFrameRate(int paramInt)
      {
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$902(this.result, true);
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setHeight(int paramInt)
      {
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$702(this.result, true);
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setWidth(int paramInt)
      {
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$502(this.result, true);
        CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeVideoEncoderInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */