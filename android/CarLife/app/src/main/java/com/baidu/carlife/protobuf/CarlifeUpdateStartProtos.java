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

public final class CarlifeUpdateStartProtos
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_carlife_protobuf_CarlifeUpdateStart_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_carlife_protobuf_CarlifeUpdateStart_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeUpdateStartProtos.access$702(paramAnonymousFileDescriptor);
        CarlifeUpdateStartProtos.access$002((Descriptors.Descriptor)CarlifeUpdateStartProtos.getDescriptor().getMessageTypes().get(0));
        CarlifeUpdateStartProtos.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeUpdateStartProtos.internal_static_carlife_protobuf_CarlifeUpdateStart_descriptor, new String[] { "SupportFlag" }, CarlifeUpdateStartProtos.CarlifeUpdateStart.class, CarlifeUpdateStartProtos.CarlifeUpdateStart.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\fustart.proto\022\020carlife.protobuf\")\n\022CarlifeUpdateStart\022\023\n\013supportFlag\030\001 \002(\bB6\n\032com.baidu.carlife.protobufB\030CarlifeUpdateStartProtos" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeUpdateStart
    extends GeneratedMessage
  {
    public static final int SUPPORTFLAG_FIELD_NUMBER = 1;
    private static final CarlifeUpdateStart defaultInstance = new CarlifeUpdateStart();
    private boolean hasSupportFlag;
    private int memoizedSerializedSize = -1;
    private boolean supportFlag_ = false;
    
    static
    {
      CarlifeUpdateStartProtos.getDescriptor();
      CarlifeUpdateStartProtos.internalForceInit();
    }
    
    public static CarlifeUpdateStart getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeUpdateStartProtos.internal_static_carlife_protobuf_CarlifeUpdateStart_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeUpdateStart paramCarlifeUpdateStart)
    {
      return newBuilder().mergeFrom(paramCarlifeUpdateStart);
    }
    
    public static CarlifeUpdateStart parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeUpdateStart parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeUpdateStart parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeUpdateStart parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeUpdateStart parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeUpdateStart parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeUpdateStart parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeUpdateStart parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeUpdateStart parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeUpdateStart parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeUpdateStart getDefaultInstanceForType()
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
      if (hasSupportFlag()) {
        i = 0 + CodedOutputStream.computeBoolSize(1, getSupportFlag());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean getSupportFlag()
    {
      return this.supportFlag_;
    }
    
    public boolean hasSupportFlag()
    {
      return this.hasSupportFlag;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeUpdateStartProtos.internal_static_carlife_protobuf_CarlifeUpdateStart_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasSupportFlag;
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
      if (hasSupportFlag()) {
        paramCodedOutputStream.writeBool(1, getSupportFlag());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeUpdateStartProtos.CarlifeUpdateStart result;
      
      private CarlifeUpdateStartProtos.CarlifeUpdateStart buildParsed()
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
        localBuilder.result = new CarlifeUpdateStartProtos.CarlifeUpdateStart(null);
        return localBuilder;
      }
      
      public CarlifeUpdateStartProtos.CarlifeUpdateStart build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeUpdateStartProtos.CarlifeUpdateStart buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeUpdateStartProtos.CarlifeUpdateStart localCarlifeUpdateStart = this.result;
        this.result = null;
        return localCarlifeUpdateStart;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeUpdateStartProtos.CarlifeUpdateStart(null);
        return this;
      }
      
      public Builder clearSupportFlag()
      {
        CarlifeUpdateStartProtos.CarlifeUpdateStart.access$502(this.result, false);
        CarlifeUpdateStartProtos.CarlifeUpdateStart.access$602(this.result, false);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeUpdateStartProtos.CarlifeUpdateStart getDefaultInstanceForType()
      {
        return CarlifeUpdateStartProtos.CarlifeUpdateStart.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeUpdateStartProtos.CarlifeUpdateStart.getDescriptor();
      }
      
      public boolean getSupportFlag()
      {
        return this.result.getSupportFlag();
      }
      
      public boolean hasSupportFlag()
      {
        return this.result.hasSupportFlag();
      }
      
      protected CarlifeUpdateStartProtos.CarlifeUpdateStart internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeUpdateStartProtos.CarlifeUpdateStart paramCarlifeUpdateStart)
      {
        if (paramCarlifeUpdateStart == CarlifeUpdateStartProtos.CarlifeUpdateStart.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeUpdateStart.hasSupportFlag()) {
          setSupportFlag(paramCarlifeUpdateStart.getSupportFlag());
        }
        mergeUnknownFields(paramCarlifeUpdateStart.getUnknownFields());
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
            setSupportFlag(paramCodedInputStream.readBool());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeUpdateStartProtos.CarlifeUpdateStart)) {
          return mergeFrom((CarlifeUpdateStartProtos.CarlifeUpdateStart)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setSupportFlag(boolean paramBoolean)
      {
        CarlifeUpdateStartProtos.CarlifeUpdateStart.access$502(this.result, true);
        CarlifeUpdateStartProtos.CarlifeUpdateStart.access$602(this.result, paramBoolean);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeUpdateStartProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */