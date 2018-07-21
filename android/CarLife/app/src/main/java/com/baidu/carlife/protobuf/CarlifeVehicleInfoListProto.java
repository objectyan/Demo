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

public final class CarlifeVehicleInfoListProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfoList_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfoList_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeVehicleInfoListProto.access$802(paramAnonymousFileDescriptor);
        CarlifeVehicleInfoListProto.access$002((Descriptors.Descriptor)CarlifeVehicleInfoListProto.getDescriptor().getMessageTypes().get(0));
        CarlifeVehicleInfoListProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeVehicleInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfoList_descriptor, new String[] { "Cnt", "VehicleInfo" }, CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.class, CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor localFileDescriptor = CarlifeVehicleInfoProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!CarlifeVehicleInfoListProto.proto\022\032com.baidu.carlife.protobuf\032\035CarlifeVehicleInfoProto.proto\"j\n\026CarlifeVehicleInfoList\022\013\n\003cnt\030\001 \002(\005\022C\n\013vehicleInfo\030\002 \003(\0132..com.baidu.carlife.protobuf.CarlifeVehicleInfo" }, new Descriptors.FileDescriptor[] { localFileDescriptor }, local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeVehicleInfoList
    extends GeneratedMessage
  {
    public static final int CNT_FIELD_NUMBER = 1;
    public static final int VEHICLEINFO_FIELD_NUMBER = 2;
    private static final CarlifeVehicleInfoList defaultInstance = new CarlifeVehicleInfoList();
    private int cnt_ = 0;
    private boolean hasCnt;
    private int memoizedSerializedSize = -1;
    private List<CarlifeVehicleInfoProto.CarlifeVehicleInfo> vehicleInfo_ = Collections.emptyList();
    
    static
    {
      CarlifeVehicleInfoListProto.getDescriptor();
      CarlifeVehicleInfoListProto.internalForceInit();
    }
    
    public static CarlifeVehicleInfoList getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeVehicleInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfoList_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeVehicleInfoList paramCarlifeVehicleInfoList)
    {
      return newBuilder().mergeFrom(paramCarlifeVehicleInfoList);
    }
    
    public static CarlifeVehicleInfoList parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeVehicleInfoList parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getCnt()
    {
      return this.cnt_;
    }
    
    public CarlifeVehicleInfoList getDefaultInstanceForType()
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
      Iterator localIterator = getVehicleInfoList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(2, (CarlifeVehicleInfoProto.CarlifeVehicleInfo)localIterator.next());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public CarlifeVehicleInfoProto.CarlifeVehicleInfo getVehicleInfo(int paramInt)
    {
      return (CarlifeVehicleInfoProto.CarlifeVehicleInfo)this.vehicleInfo_.get(paramInt);
    }
    
    public int getVehicleInfoCount()
    {
      return this.vehicleInfo_.size();
    }
    
    public List<CarlifeVehicleInfoProto.CarlifeVehicleInfo> getVehicleInfoList()
    {
      return this.vehicleInfo_;
    }
    
    public boolean hasCnt()
    {
      return this.hasCnt;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeVehicleInfoListProto.internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfoList_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasCnt) {
        return false;
      }
      Iterator localIterator = getVehicleInfoList().iterator();
      while (localIterator.hasNext()) {
        if (!((CarlifeVehicleInfoProto.CarlifeVehicleInfo)localIterator.next()).isInitialized()) {
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
      Iterator localIterator = getVehicleInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (CarlifeVehicleInfoProto.CarlifeVehicleInfo)localIterator.next());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeVehicleInfoListProto.CarlifeVehicleInfoList result;
      
      private CarlifeVehicleInfoListProto.CarlifeVehicleInfoList buildParsed()
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
        localBuilder.result = new CarlifeVehicleInfoListProto.CarlifeVehicleInfoList(null);
        return localBuilder;
      }
      
      public Builder addAllVehicleInfo(Iterable<? extends CarlifeVehicleInfoProto.CarlifeVehicleInfo> paramIterable)
      {
        if (this.result.vehicleInfo_.isEmpty()) {
          CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$502(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.vehicleInfo_);
        return this;
      }
      
      public Builder addVehicleInfo(CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder paramBuilder)
      {
        if (this.result.vehicleInfo_.isEmpty()) {
          CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$502(this.result, new ArrayList());
        }
        this.result.vehicleInfo_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addVehicleInfo(CarlifeVehicleInfoProto.CarlifeVehicleInfo paramCarlifeVehicleInfo)
      {
        if (paramCarlifeVehicleInfo == null) {
          throw new NullPointerException();
        }
        if (this.result.vehicleInfo_.isEmpty()) {
          CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$502(this.result, new ArrayList());
        }
        this.result.vehicleInfo_.add(paramCarlifeVehicleInfo);
        return this;
      }
      
      public CarlifeVehicleInfoListProto.CarlifeVehicleInfoList build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeVehicleInfoListProto.CarlifeVehicleInfoList buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.vehicleInfo_ != Collections.EMPTY_LIST) {
          CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$502(this.result, Collections.unmodifiableList(this.result.vehicleInfo_));
        }
        CarlifeVehicleInfoListProto.CarlifeVehicleInfoList localCarlifeVehicleInfoList = this.result;
        this.result = null;
        return localCarlifeVehicleInfoList;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeVehicleInfoListProto.CarlifeVehicleInfoList(null);
        return this;
      }
      
      public Builder clearCnt()
      {
        CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$602(this.result, false);
        CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$702(this.result, 0);
        return this;
      }
      
      public Builder clearVehicleInfo()
      {
        CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$502(this.result, Collections.emptyList());
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
      
      public CarlifeVehicleInfoListProto.CarlifeVehicleInfoList getDefaultInstanceForType()
      {
        return CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.getDescriptor();
      }
      
      public CarlifeVehicleInfoProto.CarlifeVehicleInfo getVehicleInfo(int paramInt)
      {
        return this.result.getVehicleInfo(paramInt);
      }
      
      public int getVehicleInfoCount()
      {
        return this.result.getVehicleInfoCount();
      }
      
      public List<CarlifeVehicleInfoProto.CarlifeVehicleInfo> getVehicleInfoList()
      {
        return Collections.unmodifiableList(this.result.vehicleInfo_);
      }
      
      public boolean hasCnt()
      {
        return this.result.hasCnt();
      }
      
      protected CarlifeVehicleInfoListProto.CarlifeVehicleInfoList internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeVehicleInfoListProto.CarlifeVehicleInfoList paramCarlifeVehicleInfoList)
      {
        if (paramCarlifeVehicleInfoList == CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeVehicleInfoList.hasCnt()) {
          setCnt(paramCarlifeVehicleInfoList.getCnt());
        }
        if (!paramCarlifeVehicleInfoList.vehicleInfo_.isEmpty())
        {
          if (this.result.vehicleInfo_.isEmpty()) {
            CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$502(this.result, new ArrayList());
          }
          this.result.vehicleInfo_.addAll(paramCarlifeVehicleInfoList.vehicleInfo_);
        }
        mergeUnknownFields(paramCarlifeVehicleInfoList.getUnknownFields());
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
            CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder localBuilder1 = CarlifeVehicleInfoProto.CarlifeVehicleInfo.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addVehicleInfo(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeVehicleInfoListProto.CarlifeVehicleInfoList)) {
          return mergeFrom((CarlifeVehicleInfoListProto.CarlifeVehicleInfoList)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCnt(int paramInt)
      {
        CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$602(this.result, true);
        CarlifeVehicleInfoListProto.CarlifeVehicleInfoList.access$702(this.result, paramInt);
        return this;
      }
      
      public Builder setVehicleInfo(int paramInt, CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder paramBuilder)
      {
        this.result.vehicleInfo_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setVehicleInfo(int paramInt, CarlifeVehicleInfoProto.CarlifeVehicleInfo paramCarlifeVehicleInfo)
      {
        if (paramCarlifeVehicleInfo == null) {
          throw new NullPointerException();
        }
        this.result.vehicleInfo_.set(paramInt, paramCarlifeVehicleInfo);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeVehicleInfoListProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */