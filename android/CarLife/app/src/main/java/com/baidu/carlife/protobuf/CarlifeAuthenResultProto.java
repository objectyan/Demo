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

public final class CarlifeAuthenResultProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResult_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResult_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeAuthenResultProto.access$702(paramAnonymousFileDescriptor);
        CarlifeAuthenResultProto.access$002((Descriptors.Descriptor)CarlifeAuthenResultProto.getDescriptor().getMessageTypes().get(0));
        CarlifeAuthenResultProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeAuthenResultProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResult_descriptor, new String[] { "AuthenResult" }, CarlifeAuthenResultProto.CarlifeAuthenResult.class, CarlifeAuthenResultProto.CarlifeAuthenResult.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\036CarlifeAuthenResultProto.proto\022\032com.baidu.carlife.protobuf\"+\n\023CarlifeAuthenResult\022\024\n\fauthenResult\030\001 \002(\b" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeAuthenResult
    extends GeneratedMessage
  {
    public static final int AUTHENRESULT_FIELD_NUMBER = 1;
    private static final CarlifeAuthenResult defaultInstance = new CarlifeAuthenResult();
    private boolean authenResult_ = false;
    private boolean hasAuthenResult;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeAuthenResultProto.getDescriptor();
      CarlifeAuthenResultProto.internalForceInit();
    }
    
    public static CarlifeAuthenResult getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeAuthenResultProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResult_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeAuthenResult paramCarlifeAuthenResult)
    {
      return newBuilder().mergeFrom(paramCarlifeAuthenResult);
    }
    
    public static CarlifeAuthenResult parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenResult parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenResult parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeAuthenResult parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenResult parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenResult parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeAuthenResult parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenResult parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenResult parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeAuthenResult parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public boolean getAuthenResult()
    {
      return this.authenResult_;
    }
    
    public CarlifeAuthenResult getDefaultInstanceForType()
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
      if (hasAuthenResult()) {
        i = 0 + CodedOutputStream.computeBoolSize(1, getAuthenResult());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAuthenResult()
    {
      return this.hasAuthenResult;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeAuthenResultProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResult_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasAuthenResult;
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
      if (hasAuthenResult()) {
        paramCodedOutputStream.writeBool(1, getAuthenResult());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeAuthenResultProto.CarlifeAuthenResult result;
      
      private CarlifeAuthenResultProto.CarlifeAuthenResult buildParsed()
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
        localBuilder.result = new CarlifeAuthenResultProto.CarlifeAuthenResult(null);
        return localBuilder;
      }
      
      public CarlifeAuthenResultProto.CarlifeAuthenResult build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeAuthenResultProto.CarlifeAuthenResult buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeAuthenResultProto.CarlifeAuthenResult localCarlifeAuthenResult = this.result;
        this.result = null;
        return localCarlifeAuthenResult;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeAuthenResultProto.CarlifeAuthenResult(null);
        return this;
      }
      
      public Builder clearAuthenResult()
      {
        CarlifeAuthenResultProto.CarlifeAuthenResult.access$502(this.result, false);
        CarlifeAuthenResultProto.CarlifeAuthenResult.access$602(this.result, false);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public boolean getAuthenResult()
      {
        return this.result.getAuthenResult();
      }
      
      public CarlifeAuthenResultProto.CarlifeAuthenResult getDefaultInstanceForType()
      {
        return CarlifeAuthenResultProto.CarlifeAuthenResult.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeAuthenResultProto.CarlifeAuthenResult.getDescriptor();
      }
      
      public boolean hasAuthenResult()
      {
        return this.result.hasAuthenResult();
      }
      
      protected CarlifeAuthenResultProto.CarlifeAuthenResult internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeAuthenResultProto.CarlifeAuthenResult paramCarlifeAuthenResult)
      {
        if (paramCarlifeAuthenResult == CarlifeAuthenResultProto.CarlifeAuthenResult.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeAuthenResult.hasAuthenResult()) {
          setAuthenResult(paramCarlifeAuthenResult.getAuthenResult());
        }
        mergeUnknownFields(paramCarlifeAuthenResult.getUnknownFields());
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
            setAuthenResult(paramCodedInputStream.readBool());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeAuthenResultProto.CarlifeAuthenResult)) {
          return mergeFrom((CarlifeAuthenResultProto.CarlifeAuthenResult)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAuthenResult(boolean paramBoolean)
      {
        CarlifeAuthenResultProto.CarlifeAuthenResult.access$502(this.result, true);
        CarlifeAuthenResultProto.CarlifeAuthenResult.access$602(this.result, paramBoolean);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeAuthenResultProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */