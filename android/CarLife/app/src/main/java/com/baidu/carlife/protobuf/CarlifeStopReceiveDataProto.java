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

public final class CarlifeStopReceiveDataProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_CarlifeStopReceiveData_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_CarlifeStopReceiveData_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeStopReceiveDataProto.access$902(paramAnonymousFileDescriptor);
        CarlifeStopReceiveDataProto.access$002((Descriptors.Descriptor)CarlifeStopReceiveDataProto.getDescriptor().getMessageTypes().get(0));
        CarlifeStopReceiveDataProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeStopReceiveDataProto.internal_static_CarlifeStopReceiveData_descriptor, new String[] { "FileId", "Reason" }, CarlifeStopReceiveDataProto.CarlifeStopReceiveData.class, CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!CarlifeStopReceiveDataProto.proto\"\001\n\026CarlifeStopReceiveData\022\016\n\006fileId\030\001 \002(\005\0224\n\006reason\030\002 \001(\0162\036.CarlifeStopReceiveData.Reason:\004None\"0\n\006Reason\022\b\n\004None\020\000\022\017\n\013FileExisted\020\001\022\013\n\007NoSpace\020\002B\034\n\032com.baidu.carlife.protobuf" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeStopReceiveData
    extends GeneratedMessage
  {
    public static final int FILEID_FIELD_NUMBER = 1;
    public static final int REASON_FIELD_NUMBER = 2;
    private static final CarlifeStopReceiveData defaultInstance = new CarlifeStopReceiveData();
    private int fileId_ = 0;
    private boolean hasFileId;
    private boolean hasReason;
    private int memoizedSerializedSize = -1;
    private Reason reason_ = Reason.None;
    
    static
    {
      CarlifeStopReceiveDataProto.getDescriptor();
      CarlifeStopReceiveDataProto.internalForceInit();
    }
    
    public static CarlifeStopReceiveData getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeStopReceiveDataProto.internal_static_CarlifeStopReceiveData_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeStopReceiveData paramCarlifeStopReceiveData)
    {
      return newBuilder().mergeFrom(paramCarlifeStopReceiveData);
    }
    
    public static CarlifeStopReceiveData parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeStopReceiveData parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeStopReceiveData getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getFileId()
    {
      return this.fileId_;
    }
    
    public Reason getReason()
    {
      return this.reason_;
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
      int j = i;
      if (hasReason()) {
        j = i + CodedOutputStream.computeEnumSize(2, getReason().getNumber());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasFileId()
    {
      return this.hasFileId;
    }
    
    public boolean hasReason()
    {
      return this.hasReason;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeStopReceiveDataProto.internal_static_CarlifeStopReceiveData_fieldAccessorTable;
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
      if (hasReason()) {
        paramCodedOutputStream.writeEnum(2, getReason().getNumber());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeStopReceiveDataProto.CarlifeStopReceiveData result;
      
      private CarlifeStopReceiveDataProto.CarlifeStopReceiveData buildParsed()
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
        localBuilder.result = new CarlifeStopReceiveDataProto.CarlifeStopReceiveData(null);
        return localBuilder;
      }
      
      public CarlifeStopReceiveDataProto.CarlifeStopReceiveData build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeStopReceiveDataProto.CarlifeStopReceiveData buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData localCarlifeStopReceiveData = this.result;
        this.result = null;
        return localCarlifeStopReceiveData;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeStopReceiveDataProto.CarlifeStopReceiveData(null);
        return this;
      }
      
      public Builder clearFileId()
      {
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData.access$502(this.result, false);
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearReason()
      {
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData.access$702(this.result, false);
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData.access$802(this.result, CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason.None);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeStopReceiveDataProto.CarlifeStopReceiveData getDefaultInstanceForType()
      {
        return CarlifeStopReceiveDataProto.CarlifeStopReceiveData.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeStopReceiveDataProto.CarlifeStopReceiveData.getDescriptor();
      }
      
      public int getFileId()
      {
        return this.result.getFileId();
      }
      
      public CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason getReason()
      {
        return this.result.getReason();
      }
      
      public boolean hasFileId()
      {
        return this.result.hasFileId();
      }
      
      public boolean hasReason()
      {
        return this.result.hasReason();
      }
      
      protected CarlifeStopReceiveDataProto.CarlifeStopReceiveData internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeStopReceiveDataProto.CarlifeStopReceiveData paramCarlifeStopReceiveData)
      {
        if (paramCarlifeStopReceiveData == CarlifeStopReceiveDataProto.CarlifeStopReceiveData.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeStopReceiveData.hasFileId()) {
          setFileId(paramCarlifeStopReceiveData.getFileId());
        }
        if (paramCarlifeStopReceiveData.hasReason()) {
          setReason(paramCarlifeStopReceiveData.getReason());
        }
        mergeUnknownFields(paramCarlifeStopReceiveData.getUnknownFields());
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
            CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason localReason = CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason.valueOf(i);
            if (localReason == null) {
              localBuilder.mergeVarintField(2, i);
            } else {
              setReason(localReason);
            }
            break;
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeStopReceiveDataProto.CarlifeStopReceiveData)) {
          return mergeFrom((CarlifeStopReceiveDataProto.CarlifeStopReceiveData)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setFileId(int paramInt)
      {
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData.access$502(this.result, true);
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setReason(CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason paramReason)
      {
        if (paramReason == null) {
          throw new NullPointerException();
        }
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData.access$702(this.result, true);
        CarlifeStopReceiveDataProto.CarlifeStopReceiveData.access$802(this.result, paramReason);
        return this;
      }
    }
    
    public static enum Reason
      implements ProtocolMessageEnum
    {
      private static final Reason[] VALUES;
      private static Internal.EnumLiteMap<Reason> internalValueMap;
      private final int index;
      private final int value;
      
      static
      {
        FileExisted = new Reason("FileExisted", 1, 1, 1);
        NoSpace = new Reason("NoSpace", 2, 2, 2);
        $VALUES = new Reason[] { None, FileExisted, NoSpace };
        internalValueMap = new Internal.EnumLiteMap()
        {
          public CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason findValueByNumber(int paramAnonymousInt)
          {
            return CarlifeStopReceiveDataProto.CarlifeStopReceiveData.Reason.valueOf(paramAnonymousInt);
          }
        };
        VALUES = new Reason[] { None, FileExisted, NoSpace };
        CarlifeStopReceiveDataProto.getDescriptor();
      }
      
      private Reason(int paramInt1, int paramInt2)
      {
        this.index = paramInt1;
        this.value = paramInt2;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor()
      {
        return (Descriptors.EnumDescriptor)CarlifeStopReceiveDataProto.CarlifeStopReceiveData.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<Reason> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      public static Reason valueOf(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return None;
        case 1: 
          return FileExisted;
        }
        return NoSpace;
      }
      
      public static Reason valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeStopReceiveDataProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */