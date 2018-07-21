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

public final class CarlifeBTHfpConnectionProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpConnection_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpConnection_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTHfpConnectionProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeBTHfpConnectionProto.access$002((Descriptors.Descriptor)CarlifeBTHfpConnectionProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTHfpConnectionProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTHfpConnectionProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpConnection_descriptor, new String[] { "State", "Address", "Name" }, CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.class, CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!CarlifeBTHfpConnectionProto.proto\022\032com.baidu.carlife.protobuf\"F\n\026CarlifeBTHfpConnection\022\r\n\005state\030\001 \002(\005\022\017\n\007address\030\002 \001(\t\022\f\n\004name\030\003 \001(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTHfpConnection
    extends GeneratedMessage
  {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int STATE_FIELD_NUMBER = 1;
    private static final CarlifeBTHfpConnection defaultInstance = new CarlifeBTHfpConnection();
    private String address_ = "";
    private boolean hasAddress;
    private boolean hasName;
    private boolean hasState;
    private int memoizedSerializedSize = -1;
    private String name_ = "";
    private int state_ = 0;
    
    static
    {
      CarlifeBTHfpConnectionProto.getDescriptor();
      CarlifeBTHfpConnectionProto.internalForceInit();
    }
    
    public static CarlifeBTHfpConnection getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTHfpConnectionProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpConnection_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTHfpConnection paramCarlifeBTHfpConnection)
    {
      return newBuilder().mergeFrom(paramCarlifeBTHfpConnection);
    }
    
    public static CarlifeBTHfpConnection parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTHfpConnection parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAddress()
    {
      return this.address_;
    }
    
    public CarlifeBTHfpConnection getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasState()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getState());
      }
      i = j;
      if (hasAddress()) {
        i = j + CodedOutputStream.computeStringSize(2, getAddress());
      }
      j = i;
      if (hasName()) {
        j = i + CodedOutputStream.computeStringSize(3, getName());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getState()
    {
      return this.state_;
    }
    
    public boolean hasAddress()
    {
      return this.hasAddress;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasState()
    {
      return this.hasState;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTHfpConnectionProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpConnection_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasState;
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
      if (hasState()) {
        paramCodedOutputStream.writeInt32(1, getState());
      }
      if (hasAddress()) {
        paramCodedOutputStream.writeString(2, getAddress());
      }
      if (hasName()) {
        paramCodedOutputStream.writeString(3, getName());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection result;
      
      private CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection buildParsed()
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
        localBuilder.result = new CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection(null);
        return localBuilder;
      }
      
      public CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection localCarlifeBTHfpConnection = this.result;
        this.result = null;
        return localCarlifeBTHfpConnection;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection(null);
        return this;
      }
      
      public Builder clearAddress()
      {
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$702(this.result, false);
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$802(this.result, CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.getDefaultInstance().getAddress());
        return this;
      }
      
      public Builder clearName()
      {
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$902(this.result, false);
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$1002(this.result, CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearState()
      {
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$502(this.result, false);
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public String getAddress()
      {
        return this.result.getAddress();
      }
      
      public CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection getDefaultInstanceForType()
      {
        return CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.getDescriptor();
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public int getState()
      {
        return this.result.getState();
      }
      
      public boolean hasAddress()
      {
        return this.result.hasAddress();
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasState()
      {
        return this.result.hasState();
      }
      
      protected CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection paramCarlifeBTHfpConnection)
      {
        if (paramCarlifeBTHfpConnection == CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTHfpConnection.hasState()) {
          setState(paramCarlifeBTHfpConnection.getState());
        }
        if (paramCarlifeBTHfpConnection.hasAddress()) {
          setAddress(paramCarlifeBTHfpConnection.getAddress());
        }
        if (paramCarlifeBTHfpConnection.hasName()) {
          setName(paramCarlifeBTHfpConnection.getName());
        }
        mergeUnknownFields(paramCarlifeBTHfpConnection.getUnknownFields());
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
            setState(paramCodedInputStream.readInt32());
            break;
          case 18: 
            setAddress(paramCodedInputStream.readString());
            break;
          case 26: 
            setName(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection)) {
          return mergeFrom((CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAddress(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$702(this.result, true);
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$802(this.result, paramString);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$902(this.result, true);
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$1002(this.result, paramString);
        return this;
      }
      
      public Builder setState(int paramInt)
      {
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$502(this.result, true);
        CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTHfpConnectionProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */