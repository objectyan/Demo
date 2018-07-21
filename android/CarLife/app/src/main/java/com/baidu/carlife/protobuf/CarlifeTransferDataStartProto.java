package com.baidu.carlife.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class CarlifeTransferDataStartProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_CarlifeTransferDataStart_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_CarlifeTransferDataStart_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTransferDataStartProto.access$1302(paramAnonymousFileDescriptor);
        CarlifeTransferDataStartProto.access$002((Descriptors.Descriptor)CarlifeTransferDataStartProto.getDescriptor().getMessageTypes().get(0));
        CarlifeTransferDataStartProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTransferDataStartProto.internal_static_CarlifeTransferDataStart_descriptor, new String[] { "FileId", "DataType", "DataLen", "DataName" }, CarlifeTransferDataStartProto.CarlifeTransferDataStart.class, CarlifeTransferDataStartProto.CarlifeTransferDataStart.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n#CarlifeTransferDataStartProto.proto\"¿\001\n\030CarlifeTransferDataStart\022\016\n\006fileId\030\001 \002(\005\0224\n\bdataType\030\002 \002(\0162\".CarlifeTransferDataStart.DataType\022\017\n\007dataLen\030\003 \002(\005\022\020\n\bdataName\030\004 \002(\t\":\n\bDataType\022\f\n\bFirmware\020\000\022\t\n\005Photo\020\001\022\t\n\005Video\020\002\022\n\n\006QRcode\020\003B\034\n\032com.baidu.carlife.protobuf" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTransferDataStart
    extends GeneratedMessage
  {
    public static final int DATALEN_FIELD_NUMBER = 3;
    public static final int DATANAME_FIELD_NUMBER = 4;
    public static final int DATATYPE_FIELD_NUMBER = 2;
    public static final int FILEID_FIELD_NUMBER = 1;
    private static final CarlifeTransferDataStart defaultInstance = new CarlifeTransferDataStart();
    private int dataLen_ = 0;
    private String dataName_ = "";
    private DataType dataType_ = DataType.Firmware;
    private int fileId_ = 0;
    private boolean hasDataLen;
    private boolean hasDataName;
    private boolean hasDataType;
    private boolean hasFileId;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeTransferDataStartProto.getDescriptor();
      CarlifeTransferDataStartProto.internalForceInit();
    }
    
    public static CarlifeTransferDataStart getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTransferDataStartProto.internal_static_CarlifeTransferDataStart_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTransferDataStart paramCarlifeTransferDataStart)
    {
      return newBuilder().mergeFrom(paramCarlifeTransferDataStart);
    }
    
    public static CarlifeTransferDataStart parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTransferDataStart parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getDataLen()
    {
      return this.dataLen_;
    }
    
    public String getDataName()
    {
      return this.dataName_;
    }
    
    public DataType getDataType()
    {
      return this.dataType_;
    }
    
    public CarlifeTransferDataStart getDefaultInstanceForType()
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
      int j = 0;
      if (hasFileId()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getFileId());
      }
      i = j;
      if (hasDataType()) {
        i = j + CodedOutputStream.computeEnumSize(2, getDataType().getNumber());
      }
      j = i;
      if (hasDataLen()) {
        j = i + CodedOutputStream.computeInt32Size(3, getDataLen());
      }
      i = j;
      if (hasDataName()) {
        i = j + CodedOutputStream.computeStringSize(4, getDataName());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasDataLen()
    {
      return this.hasDataLen;
    }
    
    public boolean hasDataName()
    {
      return this.hasDataName;
    }
    
    public boolean hasDataType()
    {
      return this.hasDataType;
    }
    
    public boolean hasFileId()
    {
      return this.hasFileId;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTransferDataStartProto.internal_static_CarlifeTransferDataStart_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasFileId) {}
      while ((!this.hasDataType) || (!this.hasDataLen) || (!this.hasDataName)) {
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
      if (hasDataType()) {
        paramCodedOutputStream.writeEnum(2, getDataType().getNumber());
      }
      if (hasDataLen()) {
        paramCodedOutputStream.writeInt32(3, getDataLen());
      }
      if (hasDataName()) {
        paramCodedOutputStream.writeString(4, getDataName());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTransferDataStartProto.CarlifeTransferDataStart result;
      
      private CarlifeTransferDataStartProto.CarlifeTransferDataStart buildParsed()
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
        localBuilder.result = new CarlifeTransferDataStartProto.CarlifeTransferDataStart(null);
        return localBuilder;
      }
      
      public CarlifeTransferDataStartProto.CarlifeTransferDataStart build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTransferDataStartProto.CarlifeTransferDataStart buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTransferDataStartProto.CarlifeTransferDataStart localCarlifeTransferDataStart = this.result;
        this.result = null;
        return localCarlifeTransferDataStart;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTransferDataStartProto.CarlifeTransferDataStart(null);
        return this;
      }
      
      public Builder clearDataLen()
      {
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$902(this.result, false);
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearDataName()
      {
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$1102(this.result, false);
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$1202(this.result, CarlifeTransferDataStartProto.CarlifeTransferDataStart.getDefaultInstance().getDataName());
        return this;
      }
      
      public Builder clearDataType()
      {
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$702(this.result, false);
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$802(this.result, CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.Firmware);
        return this;
      }
      
      public Builder clearFileId()
      {
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$502(this.result, false);
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getDataLen()
      {
        return this.result.getDataLen();
      }
      
      public String getDataName()
      {
        return this.result.getDataName();
      }
      
      public CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType getDataType()
      {
        return this.result.getDataType();
      }
      
      public CarlifeTransferDataStartProto.CarlifeTransferDataStart getDefaultInstanceForType()
      {
        return CarlifeTransferDataStartProto.CarlifeTransferDataStart.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTransferDataStartProto.CarlifeTransferDataStart.getDescriptor();
      }
      
      public int getFileId()
      {
        return this.result.getFileId();
      }
      
      public boolean hasDataLen()
      {
        return this.result.hasDataLen();
      }
      
      public boolean hasDataName()
      {
        return this.result.hasDataName();
      }
      
      public boolean hasDataType()
      {
        return this.result.hasDataType();
      }
      
      public boolean hasFileId()
      {
        return this.result.hasFileId();
      }
      
      protected CarlifeTransferDataStartProto.CarlifeTransferDataStart internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTransferDataStartProto.CarlifeTransferDataStart paramCarlifeTransferDataStart)
      {
        if (paramCarlifeTransferDataStart == CarlifeTransferDataStartProto.CarlifeTransferDataStart.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTransferDataStart.hasFileId()) {
          setFileId(paramCarlifeTransferDataStart.getFileId());
        }
        if (paramCarlifeTransferDataStart.hasDataType()) {
          setDataType(paramCarlifeTransferDataStart.getDataType());
        }
        if (paramCarlifeTransferDataStart.hasDataLen()) {
          setDataLen(paramCarlifeTransferDataStart.getDataLen());
        }
        if (paramCarlifeTransferDataStart.hasDataName()) {
          setDataName(paramCarlifeTransferDataStart.getDataName());
        }
        mergeUnknownFields(paramCarlifeTransferDataStart.getUnknownFields());
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
          case 16: 
            i = paramCodedInputStream.readEnum();
            CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType localDataType = CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.valueOf(i);
            if (localDataType == null) {
              localBuilder.mergeVarintField(2, i);
            } else {
              setDataType(localDataType);
            }
            break;
          case 24: 
            setDataLen(paramCodedInputStream.readInt32());
            break;
          case 34: 
            setDataName(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTransferDataStartProto.CarlifeTransferDataStart)) {
          return mergeFrom((CarlifeTransferDataStartProto.CarlifeTransferDataStart)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setDataLen(int paramInt)
      {
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$902(this.result, true);
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setDataName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$1102(this.result, true);
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$1202(this.result, paramString);
        return this;
      }
      
      public Builder setDataType(CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType paramDataType)
      {
        if (paramDataType == null) {
          throw new NullPointerException();
        }
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$702(this.result, true);
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$802(this.result, paramDataType);
        return this;
      }
      
      public Builder setFileId(int paramInt)
      {
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$502(this.result, true);
        CarlifeTransferDataStartProto.CarlifeTransferDataStart.access$602(this.result, paramInt);
        return this;
      }
    }
    
    public static enum DataType
      implements ProtocolMessageEnum
    {
      private static final DataType[] VALUES;
      private static Internal.EnumLiteMap<DataType> internalValueMap;
      private final int index;
      private final int value;
      
      static
      {
        QRcode = new DataType("QRcode", 3, 3, 3);
        $VALUES = new DataType[] { Firmware, Photo, Video, QRcode };
        internalValueMap = new Internal.EnumLiteMap()
        {
          public CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType findValueByNumber(int paramAnonymousInt)
          {
            return CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.valueOf(paramAnonymousInt);
          }
        };
        VALUES = new DataType[] { Firmware, Photo, Video, QRcode };
        CarlifeTransferDataStartProto.getDescriptor();
      }
      
      private DataType(int paramInt1, int paramInt2)
      {
        this.index = paramInt1;
        this.value = paramInt2;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor()
      {
        return (Descriptors.EnumDescriptor)CarlifeTransferDataStartProto.CarlifeTransferDataStart.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<DataType> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      public static DataType valueOf(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return Firmware;
        case 1: 
          return Photo;
        case 2: 
          return Video;
        }
        return QRcode;
      }
      
      public static DataType valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
      {
        if (paramEnumValueDescriptor.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[paramEnumValueDescriptor.getIndex()];
      }
      
      public final Descriptors.EnumDescriptor getDescriptorForType()
      {
        return getDescriptor();
      }
      
      public final int getNumber()
      {
        return this.value;
      }
      
      public final Descriptors.EnumValueDescriptor getValueDescriptor()
      {
        return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(this.index);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTransferDataStartProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */