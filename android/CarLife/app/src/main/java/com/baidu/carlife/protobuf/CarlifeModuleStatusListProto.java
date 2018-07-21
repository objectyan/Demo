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

public final class CarlifeModuleStatusListProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatusList_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatusList_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeModuleStatusListProto.access$802(paramAnonymousFileDescriptor);
        CarlifeModuleStatusListProto.access$002((Descriptors.Descriptor)CarlifeModuleStatusListProto.getDescriptor().getMessageTypes().get(0));
        CarlifeModuleStatusListProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeModuleStatusListProto.internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatusList_descriptor, new String[] { "Cnt", "ModuleStatus" }, CarlifeModuleStatusListProto.CarlifeModuleStatusList.class, CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor localFileDescriptor = CarlifeModuleStatusProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\"CarlifeModuleStatusListProto.proto\022\032com.baidu.carlife.protobuf\032\036CarlifeModuleStatusProto.proto\"m\n\027CarlifeModuleStatusList\022\013\n\003cnt\030\001 \002(\005\022E\n\fmoduleStatus\030\002 \003(\0132/.com.baidu.carlife.protobuf.CarlifeModuleStatus" }, new Descriptors.FileDescriptor[] { localFileDescriptor }, local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeModuleStatusList
    extends GeneratedMessage
  {
    public static final int CNT_FIELD_NUMBER = 1;
    public static final int MODULESTATUS_FIELD_NUMBER = 2;
    private static final CarlifeModuleStatusList defaultInstance = new CarlifeModuleStatusList();
    private int cnt_ = 0;
    private boolean hasCnt;
    private int memoizedSerializedSize = -1;
    private List<CarlifeModuleStatusProto.CarlifeModuleStatus> moduleStatus_ = Collections.emptyList();
    
    static
    {
      CarlifeModuleStatusListProto.getDescriptor();
      CarlifeModuleStatusListProto.internalForceInit();
    }
    
    public static CarlifeModuleStatusList getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeModuleStatusListProto.internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatusList_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeModuleStatusList paramCarlifeModuleStatusList)
    {
      return newBuilder().mergeFrom(paramCarlifeModuleStatusList);
    }
    
    public static CarlifeModuleStatusList parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeModuleStatusList parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCnt()
    {
      return this.cnt_;
    }
    
    public CarlifeModuleStatusList getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public CarlifeModuleStatusProto.CarlifeModuleStatus getModuleStatus(int paramInt)
    {
      return (CarlifeModuleStatusProto.CarlifeModuleStatus)this.moduleStatus_.get(paramInt);
    }
    
    public int getModuleStatusCount()
    {
      return this.moduleStatus_.size();
    }
    
    public List<CarlifeModuleStatusProto.CarlifeModuleStatus> getModuleStatusList()
    {
      return this.moduleStatus_;
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
      Iterator localIterator = getModuleStatusList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(2, (CarlifeModuleStatusProto.CarlifeModuleStatus)localIterator.next());
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
      return CarlifeModuleStatusListProto.internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatusList_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasCnt) {
        return false;
      }
      Iterator localIterator = getModuleStatusList().iterator();
      while (localIterator.hasNext()) {
        if (!((CarlifeModuleStatusProto.CarlifeModuleStatus)localIterator.next()).isInitialized()) {
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
      Iterator localIterator = getModuleStatusList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (CarlifeModuleStatusProto.CarlifeModuleStatus)localIterator.next());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeModuleStatusListProto.CarlifeModuleStatusList result;
      
      private CarlifeModuleStatusListProto.CarlifeModuleStatusList buildParsed()
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
        localBuilder.result = new CarlifeModuleStatusListProto.CarlifeModuleStatusList(null);
        return localBuilder;
      }
      
      public Builder addAllModuleStatus(Iterable<? extends CarlifeModuleStatusProto.CarlifeModuleStatus> paramIterable)
      {
        if (this.result.moduleStatus_.isEmpty()) {
          CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$502(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.moduleStatus_);
        return this;
      }
      
      public Builder addModuleStatus(CarlifeModuleStatusProto.CarlifeModuleStatus.Builder paramBuilder)
      {
        if (this.result.moduleStatus_.isEmpty()) {
          CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$502(this.result, new ArrayList());
        }
        this.result.moduleStatus_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addModuleStatus(CarlifeModuleStatusProto.CarlifeModuleStatus paramCarlifeModuleStatus)
      {
        if (paramCarlifeModuleStatus == null) {
          throw new NullPointerException();
        }
        if (this.result.moduleStatus_.isEmpty()) {
          CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$502(this.result, new ArrayList());
        }
        this.result.moduleStatus_.add(paramCarlifeModuleStatus);
        return this;
      }
      
      public CarlifeModuleStatusListProto.CarlifeModuleStatusList build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeModuleStatusListProto.CarlifeModuleStatusList buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.moduleStatus_ != Collections.EMPTY_LIST) {
          CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$502(this.result, Collections.unmodifiableList(this.result.moduleStatus_));
        }
        CarlifeModuleStatusListProto.CarlifeModuleStatusList localCarlifeModuleStatusList = this.result;
        this.result = null;
        return localCarlifeModuleStatusList;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeModuleStatusListProto.CarlifeModuleStatusList(null);
        return this;
      }
      
      public Builder clearCnt()
      {
        CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$602(this.result, false);
        CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$702(this.result, 0);
        return this;
      }
      
      public Builder clearModuleStatus()
      {
        CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$502(this.result, Collections.emptyList());
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
      
      public CarlifeModuleStatusListProto.CarlifeModuleStatusList getDefaultInstanceForType()
      {
        return CarlifeModuleStatusListProto.CarlifeModuleStatusList.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeModuleStatusListProto.CarlifeModuleStatusList.getDescriptor();
      }
      
      public CarlifeModuleStatusProto.CarlifeModuleStatus getModuleStatus(int paramInt)
      {
        return this.result.getModuleStatus(paramInt);
      }
      
      public int getModuleStatusCount()
      {
        return this.result.getModuleStatusCount();
      }
      
      public List<CarlifeModuleStatusProto.CarlifeModuleStatus> getModuleStatusList()
      {
        return Collections.unmodifiableList(this.result.moduleStatus_);
      }
      
      public boolean hasCnt()
      {
        return this.result.hasCnt();
      }
      
      protected CarlifeModuleStatusListProto.CarlifeModuleStatusList internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeModuleStatusListProto.CarlifeModuleStatusList paramCarlifeModuleStatusList)
      {
        if (paramCarlifeModuleStatusList == CarlifeModuleStatusListProto.CarlifeModuleStatusList.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeModuleStatusList.hasCnt()) {
          setCnt(paramCarlifeModuleStatusList.getCnt());
        }
        if (!paramCarlifeModuleStatusList.moduleStatus_.isEmpty())
        {
          if (this.result.moduleStatus_.isEmpty()) {
            CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$502(this.result, new ArrayList());
          }
          this.result.moduleStatus_.addAll(paramCarlifeModuleStatusList.moduleStatus_);
        }
        mergeUnknownFields(paramCarlifeModuleStatusList.getUnknownFields());
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
            CarlifeModuleStatusProto.CarlifeModuleStatus.Builder localBuilder1 = CarlifeModuleStatusProto.CarlifeModuleStatus.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addModuleStatus(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeModuleStatusListProto.CarlifeModuleStatusList)) {
          return mergeFrom((CarlifeModuleStatusListProto.CarlifeModuleStatusList)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCnt(int paramInt)
      {
        CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$602(this.result, true);
        CarlifeModuleStatusListProto.CarlifeModuleStatusList.access$702(this.result, paramInt);
        return this;
      }
      
      public Builder setModuleStatus(int paramInt, CarlifeModuleStatusProto.CarlifeModuleStatus.Builder paramBuilder)
      {
        this.result.moduleStatus_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setModuleStatus(int paramInt, CarlifeModuleStatusProto.CarlifeModuleStatus paramCarlifeModuleStatus)
      {
        if (paramCarlifeModuleStatus == null) {
          throw new NullPointerException();
        }
        this.result.moduleStatus_.set(paramInt, paramCarlifeModuleStatus);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeModuleStatusListProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */