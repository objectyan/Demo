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

public final class CarlifeFeatureConfigListProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfigList_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfigList_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeFeatureConfigListProto.access$802(paramAnonymousFileDescriptor);
        CarlifeFeatureConfigListProto.access$002((Descriptors.Descriptor)CarlifeFeatureConfigListProto.getDescriptor().getMessageTypes().get(0));
        CarlifeFeatureConfigListProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeFeatureConfigListProto.internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfigList_descriptor, new String[] { "Cnt", "FeatureConfig" }, CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.class, CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor localFileDescriptor = CarlifeFeatureConfigProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n#CarlifeFeatureConfigListProto.proto\022\032com.baidu.carlife.protobuf\032\037CarlifeFeatureConfigProto.proto\"p\n\030CarlifeFeatureConfigList\022\013\n\003cnt\030\001 \002(\005\022G\n\rfeatureConfig\030\002 \003(\01320.com.baidu.carlife.protobuf.CarlifeFeatureConfig" }, new Descriptors.FileDescriptor[] { localFileDescriptor }, local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeFeatureConfigList
    extends GeneratedMessage
  {
    public static final int CNT_FIELD_NUMBER = 1;
    public static final int FEATURECONFIG_FIELD_NUMBER = 2;
    private static final CarlifeFeatureConfigList defaultInstance = new CarlifeFeatureConfigList();
    private int cnt_ = 0;
    private List<CarlifeFeatureConfigProto.CarlifeFeatureConfig> featureConfig_ = Collections.emptyList();
    private boolean hasCnt;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeFeatureConfigListProto.getDescriptor();
      CarlifeFeatureConfigListProto.internalForceInit();
    }
    
    public static CarlifeFeatureConfigList getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeFeatureConfigListProto.internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfigList_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeFeatureConfigList paramCarlifeFeatureConfigList)
    {
      return newBuilder().mergeFrom(paramCarlifeFeatureConfigList);
    }
    
    public static CarlifeFeatureConfigList parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeFeatureConfigList parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCnt()
    {
      return this.cnt_;
    }
    
    public CarlifeFeatureConfigList getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public CarlifeFeatureConfigProto.CarlifeFeatureConfig getFeatureConfig(int paramInt)
    {
      return (CarlifeFeatureConfigProto.CarlifeFeatureConfig)this.featureConfig_.get(paramInt);
    }
    
    public int getFeatureConfigCount()
    {
      return this.featureConfig_.size();
    }
    
    public List<CarlifeFeatureConfigProto.CarlifeFeatureConfig> getFeatureConfigList()
    {
      return this.featureConfig_;
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
      Iterator localIterator = getFeatureConfigList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(2, (CarlifeFeatureConfigProto.CarlifeFeatureConfig)localIterator.next());
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
      return CarlifeFeatureConfigListProto.internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfigList_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasCnt) {
        return false;
      }
      Iterator localIterator = getFeatureConfigList().iterator();
      while (localIterator.hasNext()) {
        if (!((CarlifeFeatureConfigProto.CarlifeFeatureConfig)localIterator.next()).isInitialized()) {
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
      Iterator localIterator = getFeatureConfigList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (CarlifeFeatureConfigProto.CarlifeFeatureConfig)localIterator.next());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeFeatureConfigListProto.CarlifeFeatureConfigList result;
      
      private CarlifeFeatureConfigListProto.CarlifeFeatureConfigList buildParsed()
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
        localBuilder.result = new CarlifeFeatureConfigListProto.CarlifeFeatureConfigList(null);
        return localBuilder;
      }
      
      public Builder addAllFeatureConfig(Iterable<? extends CarlifeFeatureConfigProto.CarlifeFeatureConfig> paramIterable)
      {
        if (this.result.featureConfig_.isEmpty()) {
          CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$502(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.featureConfig_);
        return this;
      }
      
      public Builder addFeatureConfig(CarlifeFeatureConfigProto.CarlifeFeatureConfig.Builder paramBuilder)
      {
        if (this.result.featureConfig_.isEmpty()) {
          CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$502(this.result, new ArrayList());
        }
        this.result.featureConfig_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addFeatureConfig(CarlifeFeatureConfigProto.CarlifeFeatureConfig paramCarlifeFeatureConfig)
      {
        if (paramCarlifeFeatureConfig == null) {
          throw new NullPointerException();
        }
        if (this.result.featureConfig_.isEmpty()) {
          CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$502(this.result, new ArrayList());
        }
        this.result.featureConfig_.add(paramCarlifeFeatureConfig);
        return this;
      }
      
      public CarlifeFeatureConfigListProto.CarlifeFeatureConfigList build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeFeatureConfigListProto.CarlifeFeatureConfigList buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.featureConfig_ != Collections.EMPTY_LIST) {
          CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$502(this.result, Collections.unmodifiableList(this.result.featureConfig_));
        }
        CarlifeFeatureConfigListProto.CarlifeFeatureConfigList localCarlifeFeatureConfigList = this.result;
        this.result = null;
        return localCarlifeFeatureConfigList;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeFeatureConfigListProto.CarlifeFeatureConfigList(null);
        return this;
      }
      
      public Builder clearCnt()
      {
        CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$602(this.result, false);
        CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$702(this.result, 0);
        return this;
      }
      
      public Builder clearFeatureConfig()
      {
        CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$502(this.result, Collections.emptyList());
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
      
      public CarlifeFeatureConfigListProto.CarlifeFeatureConfigList getDefaultInstanceForType()
      {
        return CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.getDescriptor();
      }
      
      public CarlifeFeatureConfigProto.CarlifeFeatureConfig getFeatureConfig(int paramInt)
      {
        return this.result.getFeatureConfig(paramInt);
      }
      
      public int getFeatureConfigCount()
      {
        return this.result.getFeatureConfigCount();
      }
      
      public List<CarlifeFeatureConfigProto.CarlifeFeatureConfig> getFeatureConfigList()
      {
        return Collections.unmodifiableList(this.result.featureConfig_);
      }
      
      public boolean hasCnt()
      {
        return this.result.hasCnt();
      }
      
      protected CarlifeFeatureConfigListProto.CarlifeFeatureConfigList internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeFeatureConfigListProto.CarlifeFeatureConfigList paramCarlifeFeatureConfigList)
      {
        if (paramCarlifeFeatureConfigList == CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeFeatureConfigList.hasCnt()) {
          setCnt(paramCarlifeFeatureConfigList.getCnt());
        }
        if (!paramCarlifeFeatureConfigList.featureConfig_.isEmpty())
        {
          if (this.result.featureConfig_.isEmpty()) {
            CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$502(this.result, new ArrayList());
          }
          this.result.featureConfig_.addAll(paramCarlifeFeatureConfigList.featureConfig_);
        }
        mergeUnknownFields(paramCarlifeFeatureConfigList.getUnknownFields());
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
            CarlifeFeatureConfigProto.CarlifeFeatureConfig.Builder localBuilder1 = CarlifeFeatureConfigProto.CarlifeFeatureConfig.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addFeatureConfig(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeFeatureConfigListProto.CarlifeFeatureConfigList)) {
          return mergeFrom((CarlifeFeatureConfigListProto.CarlifeFeatureConfigList)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCnt(int paramInt)
      {
        CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$602(this.result, true);
        CarlifeFeatureConfigListProto.CarlifeFeatureConfigList.access$702(this.result, paramInt);
        return this;
      }
      
      public Builder setFeatureConfig(int paramInt, CarlifeFeatureConfigProto.CarlifeFeatureConfig.Builder paramBuilder)
      {
        this.result.featureConfig_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setFeatureConfig(int paramInt, CarlifeFeatureConfigProto.CarlifeFeatureConfig paramCarlifeFeatureConfig)
      {
        if (paramCarlifeFeatureConfig == null) {
          throw new NullPointerException();
        }
        this.result.featureConfig_.set(paramInt, paramCarlifeFeatureConfig);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeFeatureConfigListProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */