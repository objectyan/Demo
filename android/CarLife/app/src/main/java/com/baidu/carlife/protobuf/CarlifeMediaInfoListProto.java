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

public final class CarlifeMediaInfoListProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfoList_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfoList_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeMediaInfoListProto.access$802(paramAnonymousFileDescriptor);
        CarlifeMediaInfoListProto.access$002((Descriptors.Descriptor)CarlifeMediaInfoListProto.getDescriptor().getMessageTypes().get(0));
        CarlifeMediaInfoListProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeMediaInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfoList_descriptor, new String[] { "Cnt", "MediaInfo" }, CarlifeMediaInfoListProto.CarlifeMediaInfoList.class, CarlifeMediaInfoListProto.CarlifeMediaInfoList.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor localFileDescriptor = CarlifeMediaInfoProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\037CarlifeMediaInfoListProto.proto\022\032com.baidu.carlife.protobuf\032\033CarlifeMediaInfoProto.proto\"d\n\024CarlifeMediaInfoList\022\013\n\003cnt\030\001 \002(\005\022?\n\tmediaInfo\030\002 \003(\0132,.com.baidu.carlife.protobuf.CarlifeMediaInfo" }, new Descriptors.FileDescriptor[] { localFileDescriptor }, local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeMediaInfoList
    extends GeneratedMessage
  {
    public static final int CNT_FIELD_NUMBER = 1;
    public static final int MEDIAINFO_FIELD_NUMBER = 2;
    private static final CarlifeMediaInfoList defaultInstance = new CarlifeMediaInfoList();
    private int cnt_ = 0;
    private boolean hasCnt;
    private List<CarlifeMediaInfoProto.CarlifeMediaInfo> mediaInfo_ = Collections.emptyList();
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeMediaInfoListProto.getDescriptor();
      CarlifeMediaInfoListProto.internalForceInit();
    }
    
    public static CarlifeMediaInfoList getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeMediaInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfoList_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeMediaInfoList paramCarlifeMediaInfoList)
    {
      return newBuilder().mergeFrom(paramCarlifeMediaInfoList);
    }
    
    public static CarlifeMediaInfoList parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeMediaInfoList parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCnt()
    {
      return this.cnt_;
    }
    
    public CarlifeMediaInfoList getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public CarlifeMediaInfoProto.CarlifeMediaInfo getMediaInfo(int paramInt)
    {
      return (CarlifeMediaInfoProto.CarlifeMediaInfo)this.mediaInfo_.get(paramInt);
    }
    
    public int getMediaInfoCount()
    {
      return this.mediaInfo_.size();
    }
    
    public List<CarlifeMediaInfoProto.CarlifeMediaInfo> getMediaInfoList()
    {
      return this.mediaInfo_;
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
      Iterator localIterator = getMediaInfoList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(2, (CarlifeMediaInfoProto.CarlifeMediaInfo)localIterator.next());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasCnt()
    {
      return this.hasCnt;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeMediaInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfoList_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasCnt) {
        return false;
      }
      Iterator localIterator = getMediaInfoList().iterator();
      while (localIterator.hasNext()) {
        if (!((CarlifeMediaInfoProto.CarlifeMediaInfo)localIterator.next()).isInitialized()) {
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
      Iterator localIterator = getMediaInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (CarlifeMediaInfoProto.CarlifeMediaInfo)localIterator.next());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeMediaInfoListProto.CarlifeMediaInfoList result;
      
      private CarlifeMediaInfoListProto.CarlifeMediaInfoList buildParsed()
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
        localBuilder.result = new CarlifeMediaInfoListProto.CarlifeMediaInfoList(null);
        return localBuilder;
      }
      
      public Builder addAllMediaInfo(Iterable<? extends CarlifeMediaInfoProto.CarlifeMediaInfo> paramIterable)
      {
        if (this.result.mediaInfo_.isEmpty()) {
          CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$502(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.mediaInfo_);
        return this;
      }
      
      public Builder addMediaInfo(CarlifeMediaInfoProto.CarlifeMediaInfo.Builder paramBuilder)
      {
        if (this.result.mediaInfo_.isEmpty()) {
          CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$502(this.result, new ArrayList());
        }
        this.result.mediaInfo_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addMediaInfo(CarlifeMediaInfoProto.CarlifeMediaInfo paramCarlifeMediaInfo)
      {
        if (paramCarlifeMediaInfo == null) {
          throw new NullPointerException();
        }
        if (this.result.mediaInfo_.isEmpty()) {
          CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$502(this.result, new ArrayList());
        }
        this.result.mediaInfo_.add(paramCarlifeMediaInfo);
        return this;
      }
      
      public CarlifeMediaInfoListProto.CarlifeMediaInfoList build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeMediaInfoListProto.CarlifeMediaInfoList buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.mediaInfo_ != Collections.EMPTY_LIST) {
          CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$502(this.result, Collections.unmodifiableList(this.result.mediaInfo_));
        }
        CarlifeMediaInfoListProto.CarlifeMediaInfoList localCarlifeMediaInfoList = this.result;
        this.result = null;
        return localCarlifeMediaInfoList;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeMediaInfoListProto.CarlifeMediaInfoList(null);
        return this;
      }
      
      public Builder clearCnt()
      {
        CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$602(this.result, false);
        CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$702(this.result, 0);
        return this;
      }
      
      public Builder clearMediaInfo()
      {
        CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$502(this.result, Collections.emptyList());
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
      
      public CarlifeMediaInfoListProto.CarlifeMediaInfoList getDefaultInstanceForType()
      {
        return CarlifeMediaInfoListProto.CarlifeMediaInfoList.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeMediaInfoListProto.CarlifeMediaInfoList.getDescriptor();
      }
      
      public CarlifeMediaInfoProto.CarlifeMediaInfo getMediaInfo(int paramInt)
      {
        return this.result.getMediaInfo(paramInt);
      }
      
      public int getMediaInfoCount()
      {
        return this.result.getMediaInfoCount();
      }
      
      public List<CarlifeMediaInfoProto.CarlifeMediaInfo> getMediaInfoList()
      {
        return Collections.unmodifiableList(this.result.mediaInfo_);
      }
      
      public boolean hasCnt()
      {
        return this.result.hasCnt();
      }
      
      protected CarlifeMediaInfoListProto.CarlifeMediaInfoList internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeMediaInfoListProto.CarlifeMediaInfoList paramCarlifeMediaInfoList)
      {
        if (paramCarlifeMediaInfoList == CarlifeMediaInfoListProto.CarlifeMediaInfoList.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeMediaInfoList.hasCnt()) {
          setCnt(paramCarlifeMediaInfoList.getCnt());
        }
        if (!paramCarlifeMediaInfoList.mediaInfo_.isEmpty())
        {
          if (this.result.mediaInfo_.isEmpty()) {
            CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$502(this.result, new ArrayList());
          }
          this.result.mediaInfo_.addAll(paramCarlifeMediaInfoList.mediaInfo_);
        }
        mergeUnknownFields(paramCarlifeMediaInfoList.getUnknownFields());
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
            CarlifeMediaInfoProto.CarlifeMediaInfo.Builder localBuilder1 = CarlifeMediaInfoProto.CarlifeMediaInfo.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addMediaInfo(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeMediaInfoListProto.CarlifeMediaInfoList)) {
          return mergeFrom((CarlifeMediaInfoListProto.CarlifeMediaInfoList)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCnt(int paramInt)
      {
        CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$602(this.result, true);
        CarlifeMediaInfoListProto.CarlifeMediaInfoList.access$702(this.result, paramInt);
        return this;
      }
      
      public Builder setMediaInfo(int paramInt, CarlifeMediaInfoProto.CarlifeMediaInfo.Builder paramBuilder)
      {
        this.result.mediaInfo_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setMediaInfo(int paramInt, CarlifeMediaInfoProto.CarlifeMediaInfo paramCarlifeMediaInfo)
      {
        if (paramCarlifeMediaInfo == null) {
          throw new NullPointerException();
        }
        this.result.mediaInfo_.set(paramInt, paramCarlifeMediaInfo);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeMediaInfoListProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */