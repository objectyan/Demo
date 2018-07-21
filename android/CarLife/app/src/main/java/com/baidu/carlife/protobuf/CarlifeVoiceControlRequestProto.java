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

public final class CarlifeVoiceControlRequestProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeVoiceControlRequest_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeVoiceControlRequest_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeVoiceControlRequestProto.access$902(paramAnonymousFileDescriptor);
        CarlifeVoiceControlRequestProto.access$002((Descriptors.Descriptor)CarlifeVoiceControlRequestProto.getDescriptor().getMessageTypes().get(0));
        CarlifeVoiceControlRequestProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeVoiceControlRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeVoiceControlRequest_descriptor, new String[] { "Command", "Opt" }, CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.class, CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n%CarlifeVoiceControlRequestProto.proto\022\032com.baidu.carlife.protobuf\":\n\032CarlifeVoiceControlRequest\022\017\n\007command\030\001 \002(\005\022\013\n\003opt\030\002 \001(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeVoiceControlRequest
    extends GeneratedMessage
  {
    public static final int COMMAND_FIELD_NUMBER = 1;
    public static final int OPT_FIELD_NUMBER = 2;
    private static final CarlifeVoiceControlRequest defaultInstance = new CarlifeVoiceControlRequest();
    private int command_ = 0;
    private boolean hasCommand;
    private boolean hasOpt;
    private int memoizedSerializedSize = -1;
    private int opt_ = 0;
    
    static
    {
      CarlifeVoiceControlRequestProto.getDescriptor();
      CarlifeVoiceControlRequestProto.internalForceInit();
    }
    
    public static CarlifeVoiceControlRequest getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeVoiceControlRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeVoiceControlRequest_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeVoiceControlRequest paramCarlifeVoiceControlRequest)
    {
      return newBuilder().mergeFrom(paramCarlifeVoiceControlRequest);
    }
    
    public static CarlifeVoiceControlRequest parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeVoiceControlRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCommand()
    {
      return this.command_;
    }
    
    public CarlifeVoiceControlRequest getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getOpt()
    {
      return this.opt_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasCommand()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getCommand());
      }
      int j = i;
      if (hasOpt()) {
        j = i + CodedOutputStream.computeInt32Size(2, getOpt());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCommand()
    {
      return this.hasCommand;
    }
    
    public boolean hasOpt()
    {
      return this.hasOpt;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeVoiceControlRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeVoiceControlRequest_fieldAccessorTable;
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
      if (hasOpt()) {
        paramCodedOutputStream.writeInt32(2, getOpt());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest result;
      
      private CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest buildParsed()
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
        localBuilder.result = new CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest(null);
        return localBuilder;
      }
      
      public CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest localCarlifeVoiceControlRequest = this.result;
        this.result = null;
        return localCarlifeVoiceControlRequest;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest(null);
        return this;
      }
      
      public Builder clearCommand()
      {
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.access$502(this.result, false);
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearOpt()
      {
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.access$702(this.result, false);
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.access$802(this.result, 0);
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
      
      public CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest getDefaultInstanceForType()
      {
        return CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.getDescriptor();
      }
      
      public int getOpt()
      {
        return this.result.getOpt();
      }
      
      public boolean hasCommand()
      {
        return this.result.hasCommand();
      }
      
      public boolean hasOpt()
      {
        return this.result.hasOpt();
      }
      
      protected CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest paramCarlifeVoiceControlRequest)
      {
        if (paramCarlifeVoiceControlRequest == CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeVoiceControlRequest.hasCommand()) {
          setCommand(paramCarlifeVoiceControlRequest.getCommand());
        }
        if (paramCarlifeVoiceControlRequest.hasOpt()) {
          setOpt(paramCarlifeVoiceControlRequest.getOpt());
        }
        mergeUnknownFields(paramCarlifeVoiceControlRequest.getUnknownFields());
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
          case 16: 
            setOpt(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest)) {
          return mergeFrom((CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCommand(int paramInt)
      {
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.access$502(this.result, true);
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setOpt(int paramInt)
      {
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.access$702(this.result, true);
        CarlifeVoiceControlRequestProto.CarlifeVoiceControlRequest.access$802(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeVoiceControlRequestProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */