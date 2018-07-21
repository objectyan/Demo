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

public final class CarlifeProtocolVersionMatchStatusProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersionMatchStatus_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersionMatchStatus_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeProtocolVersionMatchStatusProto.access$702(paramAnonymousFileDescriptor);
        CarlifeProtocolVersionMatchStatusProto.access$002((Descriptors.Descriptor)CarlifeProtocolVersionMatchStatusProto.getDescriptor().getMessageTypes().get(0));
        CarlifeProtocolVersionMatchStatusProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeProtocolVersionMatchStatusProto.internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersionMatchStatus_descriptor, new String[] { "MatchStatus" }, CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.class, CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n,CarlifeProtocolVersionMatchStatusProto.proto\022\032com.baidu.carlife.protobuf\"8\n!CarlifeProtocolVersionMatchStatus\022\023\n\013matchStatus\030\001 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeProtocolVersionMatchStatus
    extends GeneratedMessage
  {
    public static final int MATCHSTATUS_FIELD_NUMBER = 1;
    private static final CarlifeProtocolVersionMatchStatus defaultInstance = new CarlifeProtocolVersionMatchStatus();
    private boolean hasMatchStatus;
    private int matchStatus_ = 0;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeProtocolVersionMatchStatusProto.getDescriptor();
      CarlifeProtocolVersionMatchStatusProto.internalForceInit();
    }
    
    public static CarlifeProtocolVersionMatchStatus getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeProtocolVersionMatchStatusProto.internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersionMatchStatus_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeProtocolVersionMatchStatus paramCarlifeProtocolVersionMatchStatus)
    {
      return newBuilder().mergeFrom(paramCarlifeProtocolVersionMatchStatus);
    }
    
    public static CarlifeProtocolVersionMatchStatus parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeProtocolVersionMatchStatus parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeProtocolVersionMatchStatus getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getMatchStatus()
    {
      return this.matchStatus_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasMatchStatus()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getMatchStatus());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasMatchStatus()
    {
      return this.hasMatchStatus;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeProtocolVersionMatchStatusProto.internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersionMatchStatus_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasMatchStatus;
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
      if (hasMatchStatus()) {
        paramCodedOutputStream.writeInt32(1, getMatchStatus());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus result;
      
      private CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus buildParsed()
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
        localBuilder.result = new CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus(null);
        return localBuilder;
      }
      
      public CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus localCarlifeProtocolVersionMatchStatus = this.result;
        this.result = null;
        return localCarlifeProtocolVersionMatchStatus;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus(null);
        return this;
      }
      
      public Builder clearMatchStatus()
      {
        CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.access$502(this.result, false);
        CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus getDefaultInstanceForType()
      {
        return CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.getDescriptor();
      }
      
      public int getMatchStatus()
      {
        return this.result.getMatchStatus();
      }
      
      public boolean hasMatchStatus()
      {
        return this.result.hasMatchStatus();
      }
      
      protected CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus paramCarlifeProtocolVersionMatchStatus)
      {
        if (paramCarlifeProtocolVersionMatchStatus == CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeProtocolVersionMatchStatus.hasMatchStatus()) {
          setMatchStatus(paramCarlifeProtocolVersionMatchStatus.getMatchStatus());
        }
        mergeUnknownFields(paramCarlifeProtocolVersionMatchStatus.getUnknownFields());
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
            setMatchStatus(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus)) {
          return mergeFrom((CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setMatchStatus(int paramInt)
      {
        CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.access$502(this.result, true);
        CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeProtocolVersionMatchStatusProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */