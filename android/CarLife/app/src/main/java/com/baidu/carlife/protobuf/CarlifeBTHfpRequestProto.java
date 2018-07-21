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

public final class CarlifeBTHfpRequestProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpRequest_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpRequest_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTHfpRequestProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeBTHfpRequestProto.access$002((Descriptors.Descriptor)CarlifeBTHfpRequestProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTHfpRequestProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTHfpRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpRequest_descriptor, new String[] { "Command", "PhoneNum", "DtmfCode" }, CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.class, CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\036CarlifeBTHfpRequestProto.proto\022\032com.baidu.carlife.protobuf\"J\n\023CarlifeBTHfpRequest\022\017\n\007command\030\001 \002(\005\022\020\n\bphoneNum\030\002 \001(\t\022\020\n\bdtmfCode\030\003 \001(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTHfpRequest
    extends GeneratedMessage
  {
    public static final int COMMAND_FIELD_NUMBER = 1;
    public static final int DTMFCODE_FIELD_NUMBER = 3;
    public static final int PHONENUM_FIELD_NUMBER = 2;
    private static final CarlifeBTHfpRequest defaultInstance = new CarlifeBTHfpRequest();
    private int command_ = 0;
    private int dtmfCode_ = 0;
    private boolean hasCommand;
    private boolean hasDtmfCode;
    private boolean hasPhoneNum;
    private int memoizedSerializedSize = -1;
    private String phoneNum_ = "";
    
    static
    {
      CarlifeBTHfpRequestProto.getDescriptor();
      CarlifeBTHfpRequestProto.internalForceInit();
    }
    
    public static CarlifeBTHfpRequest getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTHfpRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpRequest_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTHfpRequest paramCarlifeBTHfpRequest)
    {
      return newBuilder().mergeFrom(paramCarlifeBTHfpRequest);
    }
    
    public static CarlifeBTHfpRequest parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTHfpRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCommand()
    {
      return this.command_;
    }
    
    public CarlifeBTHfpRequest getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getDtmfCode()
    {
      return this.dtmfCode_;
    }
    
    public String getPhoneNum()
    {
      return this.phoneNum_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasCommand()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getCommand());
      }
      i = j;
      if (hasPhoneNum()) {
        i = j + CodedOutputStream.computeStringSize(2, getPhoneNum());
      }
      j = i;
      if (hasDtmfCode()) {
        j = i + CodedOutputStream.computeInt32Size(3, getDtmfCode());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCommand()
    {
      return this.hasCommand;
    }
    
    public boolean hasDtmfCode()
    {
      return this.hasDtmfCode;
    }
    
    public boolean hasPhoneNum()
    {
      return this.hasPhoneNum;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTHfpRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpRequest_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasCommand;
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
      if (hasCommand()) {
        paramCodedOutputStream.writeInt32(1, getCommand());
      }
      if (hasPhoneNum()) {
        paramCodedOutputStream.writeString(2, getPhoneNum());
      }
      if (hasDtmfCode()) {
        paramCodedOutputStream.writeInt32(3, getDtmfCode());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTHfpRequestProto.CarlifeBTHfpRequest result;
      
      private CarlifeBTHfpRequestProto.CarlifeBTHfpRequest buildParsed()
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
        localBuilder.result = new CarlifeBTHfpRequestProto.CarlifeBTHfpRequest(null);
        return localBuilder;
      }
      
      public CarlifeBTHfpRequestProto.CarlifeBTHfpRequest build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTHfpRequestProto.CarlifeBTHfpRequest buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest localCarlifeBTHfpRequest = this.result;
        this.result = null;
        return localCarlifeBTHfpRequest;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTHfpRequestProto.CarlifeBTHfpRequest(null);
        return this;
      }
      
      public Builder clearCommand()
      {
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$502(this.result, false);
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearDtmfCode()
      {
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$902(this.result, false);
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearPhoneNum()
      {
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$702(this.result, false);
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$802(this.result, CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.getDefaultInstance().getPhoneNum());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getCommand()
      {
        return this.result.getCommand();
      }
      
      public CarlifeBTHfpRequestProto.CarlifeBTHfpRequest getDefaultInstanceForType()
      {
        return CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.getDescriptor();
      }
      
      public int getDtmfCode()
      {
        return this.result.getDtmfCode();
      }
      
      public String getPhoneNum()
      {
        return this.result.getPhoneNum();
      }
      
      public boolean hasCommand()
      {
        return this.result.hasCommand();
      }
      
      public boolean hasDtmfCode()
      {
        return this.result.hasDtmfCode();
      }
      
      public boolean hasPhoneNum()
      {
        return this.result.hasPhoneNum();
      }
      
      protected CarlifeBTHfpRequestProto.CarlifeBTHfpRequest internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTHfpRequestProto.CarlifeBTHfpRequest paramCarlifeBTHfpRequest)
      {
        if (paramCarlifeBTHfpRequest == CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTHfpRequest.hasCommand()) {
          setCommand(paramCarlifeBTHfpRequest.getCommand());
        }
        if (paramCarlifeBTHfpRequest.hasPhoneNum()) {
          setPhoneNum(paramCarlifeBTHfpRequest.getPhoneNum());
        }
        if (paramCarlifeBTHfpRequest.hasDtmfCode()) {
          setDtmfCode(paramCarlifeBTHfpRequest.getDtmfCode());
        }
        mergeUnknownFields(paramCarlifeBTHfpRequest.getUnknownFields());
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
            setCommand(paramCodedInputStream.readInt32());
            break;
          case 18: 
            setPhoneNum(paramCodedInputStream.readString());
            break;
          case 24: 
            setDtmfCode(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTHfpRequestProto.CarlifeBTHfpRequest)) {
          return mergeFrom((CarlifeBTHfpRequestProto.CarlifeBTHfpRequest)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCommand(int paramInt)
      {
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$502(this.result, true);
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setDtmfCode(int paramInt)
      {
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$902(this.result, true);
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setPhoneNum(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$702(this.result, true);
        CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.access$802(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTHfpRequestProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */