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

public final class CarlifeBTPairInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTPairInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTPairInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTPairInfoProto.access$1902(paramAnonymousFileDescriptor);
        CarlifeBTPairInfoProto.access$002((Descriptors.Descriptor)CarlifeBTPairInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTPairInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTPairInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTPairInfo_descriptor, new String[] { "Address", "PassKey", "Hash", "Randomizer", "Uuid", "Name", "Status" }, CarlifeBTPairInfoProto.CarlifeBTPairInfo.class, CarlifeBTPairInfoProto.CarlifeBTPairInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\034CarlifeBTPairInfoProto.proto\022\032com.baidu.carlife.protobuf\"\001\n\021CarlifeBTPairInfo\022\017\n\007address\030\001 \002(\t\022\017\n\007passKey\030\002 \001(\t\022\f\n\004hash\030\003 \001(\t\022\022\n\nrandomizer\030\004 \001(\t\022\f\n\004uuid\030\005 \002(\t\022\f\n\004name\030\006 \002(\t\022\016\n\006status\030\007 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTPairInfo
    extends GeneratedMessage
  {
    public static final int ADDRESS_FIELD_NUMBER = 1;
    public static final int HASH_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 6;
    public static final int PASSKEY_FIELD_NUMBER = 2;
    public static final int RANDOMIZER_FIELD_NUMBER = 4;
    public static final int STATUS_FIELD_NUMBER = 7;
    public static final int UUID_FIELD_NUMBER = 5;
    private static final CarlifeBTPairInfo defaultInstance = new CarlifeBTPairInfo();
    private String address_ = "";
    private boolean hasAddress;
    private boolean hasHash;
    private boolean hasName;
    private boolean hasPassKey;
    private boolean hasRandomizer;
    private boolean hasStatus;
    private boolean hasUuid;
    private String hash_ = "";
    private int memoizedSerializedSize = -1;
    private String name_ = "";
    private String passKey_ = "";
    private String randomizer_ = "";
    private int status_ = 0;
    private String uuid_ = "";
    
    static
    {
      CarlifeBTPairInfoProto.getDescriptor();
      CarlifeBTPairInfoProto.internalForceInit();
    }
    
    public static CarlifeBTPairInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTPairInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTPairInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTPairInfo paramCarlifeBTPairInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeBTPairInfo);
    }
    
    public static CarlifeBTPairInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTPairInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAddress()
    {
      return this.address_;
    }
    
    public CarlifeBTPairInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getHash()
    {
      return this.hash_;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public String getPassKey()
    {
      return this.passKey_;
    }
    
    public String getRandomizer()
    {
      return this.randomizer_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasAddress()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getAddress());
      }
      i = j;
      if (hasPassKey()) {
        i = j + CodedOutputStream.computeStringSize(2, getPassKey());
      }
      j = i;
      if (hasHash()) {
        j = i + CodedOutputStream.computeStringSize(3, getHash());
      }
      i = j;
      if (hasRandomizer()) {
        i = j + CodedOutputStream.computeStringSize(4, getRandomizer());
      }
      j = i;
      if (hasUuid()) {
        j = i + CodedOutputStream.computeStringSize(5, getUuid());
      }
      i = j;
      if (hasName()) {
        i = j + CodedOutputStream.computeStringSize(6, getName());
      }
      j = i;
      if (hasStatus()) {
        j = i + CodedOutputStream.computeInt32Size(7, getStatus());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getStatus()
    {
      return this.status_;
    }
    
    public String getUuid()
    {
      return this.uuid_;
    }
    
    public boolean hasAddress()
    {
      return this.hasAddress;
    }
    
    public boolean hasHash()
    {
      return this.hasHash;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasPassKey()
    {
      return this.hasPassKey;
    }
    
    public boolean hasRandomizer()
    {
      return this.hasRandomizer;
    }
    
    public boolean hasStatus()
    {
      return this.hasStatus;
    }
    
    public boolean hasUuid()
    {
      return this.hasUuid;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTPairInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTPairInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasAddress) {}
      while ((!this.hasUuid) || (!this.hasName) || (!this.hasStatus)) {
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
      if (hasAddress()) {
        paramCodedOutputStream.writeString(1, getAddress());
      }
      if (hasPassKey()) {
        paramCodedOutputStream.writeString(2, getPassKey());
      }
      if (hasHash()) {
        paramCodedOutputStream.writeString(3, getHash());
      }
      if (hasRandomizer()) {
        paramCodedOutputStream.writeString(4, getRandomizer());
      }
      if (hasUuid()) {
        paramCodedOutputStream.writeString(5, getUuid());
      }
      if (hasName()) {
        paramCodedOutputStream.writeString(6, getName());
      }
      if (hasStatus()) {
        paramCodedOutputStream.writeInt32(7, getStatus());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTPairInfoProto.CarlifeBTPairInfo result;
      
      private CarlifeBTPairInfoProto.CarlifeBTPairInfo buildParsed()
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
        localBuilder.result = new CarlifeBTPairInfoProto.CarlifeBTPairInfo(null);
        return localBuilder;
      }
      
      public CarlifeBTPairInfoProto.CarlifeBTPairInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTPairInfoProto.CarlifeBTPairInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTPairInfoProto.CarlifeBTPairInfo localCarlifeBTPairInfo = this.result;
        this.result = null;
        return localCarlifeBTPairInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTPairInfoProto.CarlifeBTPairInfo(null);
        return this;
      }
      
      public Builder clearAddress()
      {
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$502(this.result, false);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$602(this.result, CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDefaultInstance().getAddress());
        return this;
      }
      
      public Builder clearHash()
      {
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$902(this.result, false);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1002(this.result, CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDefaultInstance().getHash());
        return this;
      }
      
      public Builder clearName()
      {
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1502(this.result, false);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1602(this.result, CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearPassKey()
      {
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$702(this.result, false);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$802(this.result, CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDefaultInstance().getPassKey());
        return this;
      }
      
      public Builder clearRandomizer()
      {
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1102(this.result, false);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1202(this.result, CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDefaultInstance().getRandomizer());
        return this;
      }
      
      public Builder clearStatus()
      {
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1702(this.result, false);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1802(this.result, 0);
        return this;
      }
      
      public Builder clearUuid()
      {
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1302(this.result, false);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1402(this.result, CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDefaultInstance().getUuid());
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
      
      public CarlifeBTPairInfoProto.CarlifeBTPairInfo getDefaultInstanceForType()
      {
        return CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDescriptor();
      }
      
      public String getHash()
      {
        return this.result.getHash();
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public String getPassKey()
      {
        return this.result.getPassKey();
      }
      
      public String getRandomizer()
      {
        return this.result.getRandomizer();
      }
      
      public int getStatus()
      {
        return this.result.getStatus();
      }
      
      public String getUuid()
      {
        return this.result.getUuid();
      }
      
      public boolean hasAddress()
      {
        return this.result.hasAddress();
      }
      
      public boolean hasHash()
      {
        return this.result.hasHash();
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasPassKey()
      {
        return this.result.hasPassKey();
      }
      
      public boolean hasRandomizer()
      {
        return this.result.hasRandomizer();
      }
      
      public boolean hasStatus()
      {
        return this.result.hasStatus();
      }
      
      public boolean hasUuid()
      {
        return this.result.hasUuid();
      }
      
      protected CarlifeBTPairInfoProto.CarlifeBTPairInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTPairInfoProto.CarlifeBTPairInfo paramCarlifeBTPairInfo)
      {
        if (paramCarlifeBTPairInfo == CarlifeBTPairInfoProto.CarlifeBTPairInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTPairInfo.hasAddress()) {
          setAddress(paramCarlifeBTPairInfo.getAddress());
        }
        if (paramCarlifeBTPairInfo.hasPassKey()) {
          setPassKey(paramCarlifeBTPairInfo.getPassKey());
        }
        if (paramCarlifeBTPairInfo.hasHash()) {
          setHash(paramCarlifeBTPairInfo.getHash());
        }
        if (paramCarlifeBTPairInfo.hasRandomizer()) {
          setRandomizer(paramCarlifeBTPairInfo.getRandomizer());
        }
        if (paramCarlifeBTPairInfo.hasUuid()) {
          setUuid(paramCarlifeBTPairInfo.getUuid());
        }
        if (paramCarlifeBTPairInfo.hasName()) {
          setName(paramCarlifeBTPairInfo.getName());
        }
        if (paramCarlifeBTPairInfo.hasStatus()) {
          setStatus(paramCarlifeBTPairInfo.getStatus());
        }
        mergeUnknownFields(paramCarlifeBTPairInfo.getUnknownFields());
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
          case 10: 
            setAddress(paramCodedInputStream.readString());
            break;
          case 18: 
            setPassKey(paramCodedInputStream.readString());
            break;
          case 26: 
            setHash(paramCodedInputStream.readString());
            break;
          case 34: 
            setRandomizer(paramCodedInputStream.readString());
            break;
          case 42: 
            setUuid(paramCodedInputStream.readString());
            break;
          case 50: 
            setName(paramCodedInputStream.readString());
            break;
          case 56: 
            setStatus(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTPairInfoProto.CarlifeBTPairInfo)) {
          return mergeFrom((CarlifeBTPairInfoProto.CarlifeBTPairInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAddress(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$502(this.result, true);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$602(this.result, paramString);
        return this;
      }
      
      public Builder setHash(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$902(this.result, true);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1002(this.result, paramString);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1502(this.result, true);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1602(this.result, paramString);
        return this;
      }
      
      public Builder setPassKey(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$702(this.result, true);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$802(this.result, paramString);
        return this;
      }
      
      public Builder setRandomizer(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1102(this.result, true);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1202(this.result, paramString);
        return this;
      }
      
      public Builder setStatus(int paramInt)
      {
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1702(this.result, true);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1802(this.result, paramInt);
        return this;
      }
      
      public Builder setUuid(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1302(this.result, true);
        CarlifeBTPairInfoProto.CarlifeBTPairInfo.access$1402(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTPairInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */