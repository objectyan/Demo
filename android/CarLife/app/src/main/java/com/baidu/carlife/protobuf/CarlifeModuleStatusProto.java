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

public final class CarlifeModuleStatusProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatus_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatus_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeModuleStatusProto.access$902(paramAnonymousFileDescriptor);
        CarlifeModuleStatusProto.access$002((Descriptors.Descriptor)CarlifeModuleStatusProto.getDescriptor().getMessageTypes().get(0));
        CarlifeModuleStatusProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeModuleStatusProto.internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatus_descriptor, new String[] { "ModuleID", "StatusID" }, CarlifeModuleStatusProto.CarlifeModuleStatus.class, CarlifeModuleStatusProto.CarlifeModuleStatus.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\036CarlifeModuleStatusProto.proto\022\032com.baidu.carlife.protobuf\"9\n\023CarlifeModuleStatus\022\020\n\bmoduleID\030\001 \002(\005\022\020\n\bstatusID\030\002 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeModuleStatus
    extends GeneratedMessage
  {
    public static final int MODULEID_FIELD_NUMBER = 1;
    public static final int STATUSID_FIELD_NUMBER = 2;
    private static final CarlifeModuleStatus defaultInstance = new CarlifeModuleStatus();
    private boolean hasModuleID;
    private boolean hasStatusID;
    private int memoizedSerializedSize = -1;
    private int moduleID_ = 0;
    private int statusID_ = 0;
    
    static
    {
      CarlifeModuleStatusProto.getDescriptor();
      CarlifeModuleStatusProto.internalForceInit();
    }
    
    public static CarlifeModuleStatus getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeModuleStatusProto.internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatus_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeModuleStatus paramCarlifeModuleStatus)
    {
      return newBuilder().mergeFrom(paramCarlifeModuleStatus);
    }
    
    public static CarlifeModuleStatus parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeModuleStatus parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeModuleStatus parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeModuleStatus parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeModuleStatus parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeModuleStatus parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeModuleStatus parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeModuleStatus parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeModuleStatus parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeModuleStatus parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeModuleStatus getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getModuleID()
    {
      return this.moduleID_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasModuleID()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getModuleID());
      }
      int j = i;
      if (hasStatusID()) {
        j = i + CodedOutputStream.computeInt32Size(2, getStatusID());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getStatusID()
    {
      return this.statusID_;
    }
    
    public boolean hasModuleID()
    {
      return this.hasModuleID;
    }
    
    public boolean hasStatusID()
    {
      return this.hasStatusID;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeModuleStatusProto.internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatus_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasModuleID) {}
      while (!this.hasStatusID) {
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
      if (hasModuleID()) {
        paramCodedOutputStream.writeInt32(1, getModuleID());
      }
      if (hasStatusID()) {
        paramCodedOutputStream.writeInt32(2, getStatusID());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeModuleStatusProto.CarlifeModuleStatus result;
      
      private CarlifeModuleStatusProto.CarlifeModuleStatus buildParsed()
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
        localBuilder.result = new CarlifeModuleStatusProto.CarlifeModuleStatus(null);
        return localBuilder;
      }
      
      public CarlifeModuleStatusProto.CarlifeModuleStatus build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeModuleStatusProto.CarlifeModuleStatus buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeModuleStatusProto.CarlifeModuleStatus localCarlifeModuleStatus = this.result;
        this.result = null;
        return localCarlifeModuleStatus;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeModuleStatusProto.CarlifeModuleStatus(null);
        return this;
      }
      
      public Builder clearModuleID()
      {
        CarlifeModuleStatusProto.CarlifeModuleStatus.access$502(this.result, false);
        CarlifeModuleStatusProto.CarlifeModuleStatus.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearStatusID()
      {
        CarlifeModuleStatusProto.CarlifeModuleStatus.access$702(this.result, false);
        CarlifeModuleStatusProto.CarlifeModuleStatus.access$802(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeModuleStatusProto.CarlifeModuleStatus getDefaultInstanceForType()
      {
        return CarlifeModuleStatusProto.CarlifeModuleStatus.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeModuleStatusProto.CarlifeModuleStatus.getDescriptor();
      }
      
      public int getModuleID()
      {
        return this.result.getModuleID();
      }
      
      public int getStatusID()
      {
        return this.result.getStatusID();
      }
      
      public boolean hasModuleID()
      {
        return this.result.hasModuleID();
      }
      
      public boolean hasStatusID()
      {
        return this.result.hasStatusID();
      }
      
      protected CarlifeModuleStatusProto.CarlifeModuleStatus internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeModuleStatusProto.CarlifeModuleStatus paramCarlifeModuleStatus)
      {
        if (paramCarlifeModuleStatus == CarlifeModuleStatusProto.CarlifeModuleStatus.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeModuleStatus.hasModuleID()) {
          setModuleID(paramCarlifeModuleStatus.getModuleID());
        }
        if (paramCarlifeModuleStatus.hasStatusID()) {
          setStatusID(paramCarlifeModuleStatus.getStatusID());
        }
        mergeUnknownFields(paramCarlifeModuleStatus.getUnknownFields());
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
            setModuleID(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setStatusID(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeModuleStatusProto.CarlifeModuleStatus)) {
          return mergeFrom((CarlifeModuleStatusProto.CarlifeModuleStatus)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setModuleID(int paramInt)
      {
        CarlifeModuleStatusProto.CarlifeModuleStatus.access$502(this.result, true);
        CarlifeModuleStatusProto.CarlifeModuleStatus.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setStatusID(int paramInt)
      {
        CarlifeModuleStatusProto.CarlifeModuleStatus.access$702(this.result, true);
        CarlifeModuleStatusProto.CarlifeModuleStatus.access$802(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeModuleStatusProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */