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

public final class CarlifeCarHardKeyCodeProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeCarHardKeyCode_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeCarHardKeyCode_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeCarHardKeyCodeProto.access$702(paramAnonymousFileDescriptor);
        CarlifeCarHardKeyCodeProto.access$002((Descriptors.Descriptor)CarlifeCarHardKeyCodeProto.getDescriptor().getMessageTypes().get(0));
        CarlifeCarHardKeyCodeProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeCarHardKeyCodeProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarHardKeyCode_descriptor, new String[] { "Keycode" }, CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.class, CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n CarlifeCarHardKeyCodeProto.proto\022\032com.baidu.carlife.protobuf\"(\n\025CarlifeCarHardKeyCode\022\017\n\007keycode\030\001 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeCarHardKeyCode
    extends GeneratedMessage
  {
    public static final int KEYCODE_FIELD_NUMBER = 1;
    private static final CarlifeCarHardKeyCode defaultInstance = new CarlifeCarHardKeyCode();
    private boolean hasKeycode;
    private int keycode_ = 0;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeCarHardKeyCodeProto.getDescriptor();
      CarlifeCarHardKeyCodeProto.internalForceInit();
    }
    
    public static CarlifeCarHardKeyCode getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeCarHardKeyCodeProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarHardKeyCode_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeCarHardKeyCode paramCarlifeCarHardKeyCode)
    {
      return newBuilder().mergeFrom(paramCarlifeCarHardKeyCode);
    }
    
    public static CarlifeCarHardKeyCode parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeCarHardKeyCode parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeCarHardKeyCode getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getKeycode()
    {
      return this.keycode_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasKeycode()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getKeycode());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasKeycode()
    {
      return this.hasKeycode;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeCarHardKeyCodeProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarHardKeyCode_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasKeycode;
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
      if (hasKeycode()) {
        paramCodedOutputStream.writeInt32(1, getKeycode());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode result;
      
      private CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode buildParsed()
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
        localBuilder.result = new CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode(null);
        return localBuilder;
      }
      
      public CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode localCarlifeCarHardKeyCode = this.result;
        this.result = null;
        return localCarlifeCarHardKeyCode;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode(null);
        return this;
      }
      
      public Builder clearKeycode()
      {
        CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.access$502(this.result, false);
        CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode getDefaultInstanceForType()
      {
        return CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.getDescriptor();
      }
      
      public int getKeycode()
      {
        return this.result.getKeycode();
      }
      
      public boolean hasKeycode()
      {
        return this.result.hasKeycode();
      }
      
      protected CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode paramCarlifeCarHardKeyCode)
      {
        if (paramCarlifeCarHardKeyCode == CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeCarHardKeyCode.hasKeycode()) {
          setKeycode(paramCarlifeCarHardKeyCode.getKeycode());
        }
        mergeUnknownFields(paramCarlifeCarHardKeyCode.getUnknownFields());
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
            setKeycode(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode)) {
          return mergeFrom((CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setKeycode(int paramInt)
      {
        CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.access$502(this.result, true);
        CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeCarHardKeyCodeProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */