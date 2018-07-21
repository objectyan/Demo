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

public final class CarlifeBTHfpIndicationProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpIndication_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpIndication_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTHfpIndicationProto.access$1302(paramAnonymousFileDescriptor);
        CarlifeBTHfpIndicationProto.access$002((Descriptors.Descriptor)CarlifeBTHfpIndicationProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTHfpIndicationProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTHfpIndicationProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpIndication_descriptor, new String[] { "State", "PhoneNum", "PhoneName", "Address" }, CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.class, CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!CarlifeBTHfpIndicationProto.proto\022\032com.baidu.carlife.protobuf\"]\n\026CarlifeBTHfpIndication\022\r\n\005state\030\001 \002(\005\022\020\n\bphoneNum\030\002 \001(\t\022\021\n\tphoneName\030\003 \001(\t\022\017\n\007address\030\004 \001(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTHfpIndication
    extends GeneratedMessage
  {
    public static final int ADDRESS_FIELD_NUMBER = 4;
    public static final int PHONENAME_FIELD_NUMBER = 3;
    public static final int PHONENUM_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 1;
    private static final CarlifeBTHfpIndication defaultInstance = new CarlifeBTHfpIndication();
    private String address_ = "";
    private boolean hasAddress;
    private boolean hasPhoneName;
    private boolean hasPhoneNum;
    private boolean hasState;
    private int memoizedSerializedSize = -1;
    private String phoneName_ = "";
    private String phoneNum_ = "";
    private int state_ = 0;
    
    static
    {
      CarlifeBTHfpIndicationProto.getDescriptor();
      CarlifeBTHfpIndicationProto.internalForceInit();
    }
    
    public static CarlifeBTHfpIndication getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTHfpIndicationProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpIndication_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTHfpIndication paramCarlifeBTHfpIndication)
    {
      return newBuilder().mergeFrom(paramCarlifeBTHfpIndication);
    }
    
    public static CarlifeBTHfpIndication parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTHfpIndication parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAddress()
    {
      return this.address_;
    }
    
    public CarlifeBTHfpIndication getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getPhoneName()
    {
      return this.phoneName_;
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
      if (hasState()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getState());
      }
      i = j;
      if (hasPhoneNum()) {
        i = j + CodedOutputStream.computeStringSize(2, getPhoneNum());
      }
      j = i;
      if (hasPhoneName()) {
        j = i + CodedOutputStream.computeStringSize(3, getPhoneName());
      }
      i = j;
      if (hasAddress()) {
        i = j + CodedOutputStream.computeStringSize(4, getAddress());
      }
      i += getUnknownFields().getSerializedSize();
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
    
    public boolean hasPhoneName()
    {
      return this.hasPhoneName;
    }
    
    public boolean hasPhoneNum()
    {
      return this.hasPhoneNum;
    }
    
    public boolean hasState()
    {
      return this.hasState;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTHfpIndicationProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpIndication_fieldAccessorTable;
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
      if (hasPhoneNum()) {
        paramCodedOutputStream.writeString(2, getPhoneNum());
      }
      if (hasPhoneName()) {
        paramCodedOutputStream.writeString(3, getPhoneName());
      }
      if (hasAddress()) {
        paramCodedOutputStream.writeString(4, getAddress());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication result;
      
      private CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication buildParsed()
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
        localBuilder.result = new CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication(null);
        return localBuilder;
      }
      
      public CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication localCarlifeBTHfpIndication = this.result;
        this.result = null;
        return localCarlifeBTHfpIndication;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication(null);
        return this;
      }
      
      public Builder clearAddress()
      {
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$1102(this.result, false);
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$1202(this.result, CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.getDefaultInstance().getAddress());
        return this;
      }
      
      public Builder clearPhoneName()
      {
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$902(this.result, false);
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$1002(this.result, CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.getDefaultInstance().getPhoneName());
        return this;
      }
      
      public Builder clearPhoneNum()
      {
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$702(this.result, false);
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$802(this.result, CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.getDefaultInstance().getPhoneNum());
        return this;
      }
      
      public Builder clearState()
      {
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$502(this.result, false);
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$602(this.result, 0);
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
      
      public CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication getDefaultInstanceForType()
      {
        return CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.getDescriptor();
      }
      
      public String getPhoneName()
      {
        return this.result.getPhoneName();
      }
      
      public String getPhoneNum()
      {
        return this.result.getPhoneNum();
      }
      
      public int getState()
      {
        return this.result.getState();
      }
      
      public boolean hasAddress()
      {
        return this.result.hasAddress();
      }
      
      public boolean hasPhoneName()
      {
        return this.result.hasPhoneName();
      }
      
      public boolean hasPhoneNum()
      {
        return this.result.hasPhoneNum();
      }
      
      public boolean hasState()
      {
        return this.result.hasState();
      }
      
      protected CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication paramCarlifeBTHfpIndication)
      {
        if (paramCarlifeBTHfpIndication == CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTHfpIndication.hasState()) {
          setState(paramCarlifeBTHfpIndication.getState());
        }
        if (paramCarlifeBTHfpIndication.hasPhoneNum()) {
          setPhoneNum(paramCarlifeBTHfpIndication.getPhoneNum());
        }
        if (paramCarlifeBTHfpIndication.hasPhoneName()) {
          setPhoneName(paramCarlifeBTHfpIndication.getPhoneName());
        }
        if (paramCarlifeBTHfpIndication.hasAddress()) {
          setAddress(paramCarlifeBTHfpIndication.getAddress());
        }
        mergeUnknownFields(paramCarlifeBTHfpIndication.getUnknownFields());
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
            setPhoneNum(paramCodedInputStream.readString());
            break;
          case 26: 
            setPhoneName(paramCodedInputStream.readString());
            break;
          case 34: 
            setAddress(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication)) {
          return mergeFrom((CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAddress(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$1102(this.result, true);
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$1202(this.result, paramString);
        return this;
      }
      
      public Builder setPhoneName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$902(this.result, true);
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$1002(this.result, paramString);
        return this;
      }
      
      public Builder setPhoneNum(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$702(this.result, true);
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$802(this.result, paramString);
        return this;
      }
      
      public Builder setState(int paramInt)
      {
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$502(this.result, true);
        CarlifeBTHfpIndicationProto.CarlifeBTHfpIndication.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTHfpIndicationProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */