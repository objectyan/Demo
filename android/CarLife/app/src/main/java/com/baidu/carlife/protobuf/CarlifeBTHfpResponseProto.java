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

public final class CarlifeBTHfpResponseProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpResponse_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpResponse_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTHfpResponseProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeBTHfpResponseProto.access$002((Descriptors.Descriptor)CarlifeBTHfpResponseProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTHfpResponseProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTHfpResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpResponse_descriptor, new String[] { "Status", "Cmd", "DtmfCode" }, CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.class, CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\037CarlifeBTHfpResponseProto.proto\022\032com.baidu.carlife.protobuf\"E\n\024CarlifeBTHfpResponse\022\016\n\006status\030\001 \002(\005\022\013\n\003cmd\030\002 \002(\005\022\020\n\bdtmfCode\030\003 \001(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTHfpResponse
    extends GeneratedMessage
  {
    public static final int CMD_FIELD_NUMBER = 2;
    public static final int DTMFCODE_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 1;
    private static final CarlifeBTHfpResponse defaultInstance = new CarlifeBTHfpResponse();
    private int cmd_ = 0;
    private int dtmfCode_ = 0;
    private boolean hasCmd;
    private boolean hasDtmfCode;
    private boolean hasStatus;
    private int memoizedSerializedSize = -1;
    private int status_ = 0;
    
    static
    {
      CarlifeBTHfpResponseProto.getDescriptor();
      CarlifeBTHfpResponseProto.internalForceInit();
    }
    
    public static CarlifeBTHfpResponse getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTHfpResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpResponse_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTHfpResponse paramCarlifeBTHfpResponse)
    {
      return newBuilder().mergeFrom(paramCarlifeBTHfpResponse);
    }
    
    public static CarlifeBTHfpResponse parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTHfpResponse parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCmd()
    {
      return this.cmd_;
    }
    
    public CarlifeBTHfpResponse getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getDtmfCode()
    {
      return this.dtmfCode_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasStatus()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getStatus());
      }
      i = j;
      if (hasCmd()) {
        i = j + CodedOutputStream.computeInt32Size(2, getCmd());
      }
      j = i;
      if (hasDtmfCode()) {
        j = i + CodedOutputStream.computeInt32Size(3, getDtmfCode());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getStatus()
    {
      return this.status_;
    }
    
    public boolean hasCmd()
    {
      return this.hasCmd;
    }
    
    public boolean hasDtmfCode()
    {
      return this.hasDtmfCode;
    }
    
    public boolean hasStatus()
    {
      return this.hasStatus;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTHfpResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpResponse_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasStatus) {}
      while (!this.hasCmd) {
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
      if (hasStatus()) {
        paramCodedOutputStream.writeInt32(1, getStatus());
      }
      if (hasCmd()) {
        paramCodedOutputStream.writeInt32(2, getCmd());
      }
      if (hasDtmfCode()) {
        paramCodedOutputStream.writeInt32(3, getDtmfCode());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTHfpResponseProto.CarlifeBTHfpResponse result;
      
      private CarlifeBTHfpResponseProto.CarlifeBTHfpResponse buildParsed()
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
        localBuilder.result = new CarlifeBTHfpResponseProto.CarlifeBTHfpResponse(null);
        return localBuilder;
      }
      
      public CarlifeBTHfpResponseProto.CarlifeBTHfpResponse build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTHfpResponseProto.CarlifeBTHfpResponse buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse localCarlifeBTHfpResponse = this.result;
        this.result = null;
        return localCarlifeBTHfpResponse;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTHfpResponseProto.CarlifeBTHfpResponse(null);
        return this;
      }
      
      public Builder clearCmd()
      {
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$702(this.result, false);
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearDtmfCode()
      {
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$902(this.result, false);
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearStatus()
      {
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$502(this.result, false);
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getCmd()
      {
        return this.result.getCmd();
      }
      
      public CarlifeBTHfpResponseProto.CarlifeBTHfpResponse getDefaultInstanceForType()
      {
        return CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.getDescriptor();
      }
      
      public int getDtmfCode()
      {
        return this.result.getDtmfCode();
      }
      
      public int getStatus()
      {
        return this.result.getStatus();
      }
      
      public boolean hasCmd()
      {
        return this.result.hasCmd();
      }
      
      public boolean hasDtmfCode()
      {
        return this.result.hasDtmfCode();
      }
      
      public boolean hasStatus()
      {
        return this.result.hasStatus();
      }
      
      protected CarlifeBTHfpResponseProto.CarlifeBTHfpResponse internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTHfpResponseProto.CarlifeBTHfpResponse paramCarlifeBTHfpResponse)
      {
        if (paramCarlifeBTHfpResponse == CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTHfpResponse.hasStatus()) {
          setStatus(paramCarlifeBTHfpResponse.getStatus());
        }
        if (paramCarlifeBTHfpResponse.hasCmd()) {
          setCmd(paramCarlifeBTHfpResponse.getCmd());
        }
        if (paramCarlifeBTHfpResponse.hasDtmfCode()) {
          setDtmfCode(paramCarlifeBTHfpResponse.getDtmfCode());
        }
        mergeUnknownFields(paramCarlifeBTHfpResponse.getUnknownFields());
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
            setStatus(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setCmd(paramCodedInputStream.readInt32());
            break;
          case 24: 
            setDtmfCode(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTHfpResponseProto.CarlifeBTHfpResponse)) {
          return mergeFrom((CarlifeBTHfpResponseProto.CarlifeBTHfpResponse)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCmd(int paramInt)
      {
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$702(this.result, true);
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setDtmfCode(int paramInt)
      {
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$902(this.result, true);
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setStatus(int paramInt)
      {
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$502(this.result, true);
        CarlifeBTHfpResponseProto.CarlifeBTHfpResponse.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTHfpResponseProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */