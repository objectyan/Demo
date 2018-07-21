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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CarlifeSubscribeMobileCarLifeInfoListProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfoList_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfoList_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeSubscribeMobileCarLifeInfoListProto.access$802(paramAnonymousFileDescriptor);
        CarlifeSubscribeMobileCarLifeInfoListProto.access$002((Descriptors.Descriptor)CarlifeSubscribeMobileCarLifeInfoListProto.getDescriptor().getMessageTypes().get(0));
        CarlifeSubscribeMobileCarLifeInfoListProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeSubscribeMobileCarLifeInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfoList_descriptor, new String[] { "Cnt", "SubscribemobileCarLifeInfo" }, CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.class, CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor localFileDescriptor = CarlifeSubscribeMobileCarLifeInfoProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n0CarlifeSubscribeMobileCarLifeInfoListProto.proto\022\032com.baidu.carlife.protobuf\032,CarlifeSubscribeMobileCarLifeInfoProto.proto\"\001\n%CarlifeSubscribeMobileCarLifeInfoList\022\013\n\003cnt\030\001 \002(\005\022a\n\032subscribemobileCarLifeInfo\030\002 \003(\0132=.com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfo" }, new Descriptors.FileDescriptor[] { localFileDescriptor }, local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeSubscribeMobileCarLifeInfoList
    extends GeneratedMessage
  {
    public static final int CNT_FIELD_NUMBER = 1;
    public static final int SUBSCRIBEMOBILECARLIFEINFO_FIELD_NUMBER = 2;
    private static final CarlifeSubscribeMobileCarLifeInfoList defaultInstance = new CarlifeSubscribeMobileCarLifeInfoList();
    private int cnt_ = 0;
    private boolean hasCnt;
    private int memoizedSerializedSize = -1;
    private List<CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo> subscribemobileCarLifeInfo_ = Collections.emptyList();
    
    static
    {
      CarlifeSubscribeMobileCarLifeInfoListProto.getDescriptor();
      CarlifeSubscribeMobileCarLifeInfoListProto.internalForceInit();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeSubscribeMobileCarLifeInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfoList_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeSubscribeMobileCarLifeInfoList paramCarlifeSubscribeMobileCarLifeInfoList)
    {
      return newBuilder().mergeFrom(paramCarlifeSubscribeMobileCarLifeInfoList);
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCnt()
    {
      return this.cnt_;
    }
    
    public CarlifeSubscribeMobileCarLifeInfoList getDefaultInstanceForType()
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
      if (hasCnt()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getCnt());
      }
      Iterator localIterator = getSubscribemobileCarLifeInfoList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(2, (CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo)localIterator.next());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo getSubscribemobileCarLifeInfo(int paramInt)
    {
      return (CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo)this.subscribemobileCarLifeInfo_.get(paramInt);
    }
    
    public int getSubscribemobileCarLifeInfoCount()
    {
      return this.subscribemobileCarLifeInfo_.size();
    }
    
    public List<CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo> getSubscribemobileCarLifeInfoList()
    {
      return this.subscribemobileCarLifeInfo_;
    }
    
    public boolean hasCnt()
    {
      return this.hasCnt;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeSubscribeMobileCarLifeInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfoList_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasCnt) {
        return false;
      }
      Iterator localIterator = getSubscribemobileCarLifeInfoList().iterator();
      while (localIterator.hasNext()) {
        if (!((CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo)localIterator.next()).isInitialized()) {
          return false;
        }
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
      if (hasCnt()) {
        paramCodedOutputStream.writeInt32(1, getCnt());
      }
      Iterator localIterator = getSubscribemobileCarLifeInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo)localIterator.next());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList result;
      
      private CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList buildParsed()
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
        localBuilder.result = new CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList(null);
        return localBuilder;
      }
      
      public Builder addAllSubscribemobileCarLifeInfo(Iterable<? extends CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo> paramIterable)
      {
        if (this.result.subscribemobileCarLifeInfo_.isEmpty()) {
          CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$502(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.subscribemobileCarLifeInfo_);
        return this;
      }
      
      public Builder addSubscribemobileCarLifeInfo(CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder paramBuilder)
      {
        if (this.result.subscribemobileCarLifeInfo_.isEmpty()) {
          CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$502(this.result, new ArrayList());
        }
        this.result.subscribemobileCarLifeInfo_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addSubscribemobileCarLifeInfo(CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo paramCarlifeSubscribeMobileCarLifeInfo)
      {
        if (paramCarlifeSubscribeMobileCarLifeInfo == null) {
          throw new NullPointerException();
        }
        if (this.result.subscribemobileCarLifeInfo_.isEmpty()) {
          CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$502(this.result, new ArrayList());
        }
        this.result.subscribemobileCarLifeInfo_.add(paramCarlifeSubscribeMobileCarLifeInfo);
        return this;
      }
      
      public CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.subscribemobileCarLifeInfo_ != Collections.EMPTY_LIST) {
          CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$502(this.result, Collections.unmodifiableList(this.result.subscribemobileCarLifeInfo_));
        }
        CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList localCarlifeSubscribeMobileCarLifeInfoList = this.result;
        this.result = null;
        return localCarlifeSubscribeMobileCarLifeInfoList;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList(null);
        return this;
      }
      
      public Builder clearCnt()
      {
        CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$602(this.result, false);
        CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$702(this.result, 0);
        return this;
      }
      
      public Builder clearSubscribemobileCarLifeInfo()
      {
        CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$502(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getCnt()
      {
        return this.result.getCnt();
      }
      
      public CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList getDefaultInstanceForType()
      {
        return CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.getDescriptor();
      }
      
      public CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo getSubscribemobileCarLifeInfo(int paramInt)
      {
        return this.result.getSubscribemobileCarLifeInfo(paramInt);
      }
      
      public int getSubscribemobileCarLifeInfoCount()
      {
        return this.result.getSubscribemobileCarLifeInfoCount();
      }
      
      public List<CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo> getSubscribemobileCarLifeInfoList()
      {
        return Collections.unmodifiableList(this.result.subscribemobileCarLifeInfo_);
      }
      
      public boolean hasCnt()
      {
        return this.result.hasCnt();
      }
      
      protected CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList paramCarlifeSubscribeMobileCarLifeInfoList)
      {
        if (paramCarlifeSubscribeMobileCarLifeInfoList == CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeSubscribeMobileCarLifeInfoList.hasCnt()) {
          setCnt(paramCarlifeSubscribeMobileCarLifeInfoList.getCnt());
        }
        if (!paramCarlifeSubscribeMobileCarLifeInfoList.subscribemobileCarLifeInfo_.isEmpty())
        {
          if (this.result.subscribemobileCarLifeInfo_.isEmpty()) {
            CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$502(this.result, new ArrayList());
          }
          this.result.subscribemobileCarLifeInfo_.addAll(paramCarlifeSubscribeMobileCarLifeInfoList.subscribemobileCarLifeInfo_);
        }
        mergeUnknownFields(paramCarlifeSubscribeMobileCarLifeInfoList.getUnknownFields());
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
            setCnt(paramCodedInputStream.readInt32());
            break;
          case 18: 
            CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder localBuilder1 = CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addSubscribemobileCarLifeInfo(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList)) {
          return mergeFrom((CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCnt(int paramInt)
      {
        CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$602(this.result, true);
        CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.access$702(this.result, paramInt);
        return this;
      }
      
      public Builder setSubscribemobileCarLifeInfo(int paramInt, CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder paramBuilder)
      {
        this.result.subscribemobileCarLifeInfo_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setSubscribemobileCarLifeInfo(int paramInt, CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo paramCarlifeSubscribeMobileCarLifeInfo)
      {
        if (paramCarlifeSubscribeMobileCarLifeInfo == null) {
          throw new NullPointerException();
        }
        this.result.subscribemobileCarLifeInfo_.set(paramInt, paramCarlifeSubscribeMobileCarLifeInfo);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeSubscribeMobileCarLifeInfoListProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */