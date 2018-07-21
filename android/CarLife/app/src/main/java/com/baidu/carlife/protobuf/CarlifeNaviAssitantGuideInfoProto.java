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

public final class CarlifeNaviAssitantGuideInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeNaviAssitantGuideInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeNaviAssitantGuideInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeNaviAssitantGuideInfoProto.access$1702(paramAnonymousFileDescriptor);
        CarlifeNaviAssitantGuideInfoProto.access$002((Descriptors.Descriptor)CarlifeNaviAssitantGuideInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeNaviAssitantGuideInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeNaviAssitantGuideInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeNaviAssitantGuideInfo_descriptor, new String[] { "Action", "AssistantType", "TrafficSignType", "TotalDistance", "RemainDistance", "CameraSpeed" }, CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.class, CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n'CarlifeNaviAssitantGuideInfoProto.proto\022\032com.baidu.carlife.protobuf\"¢\001\n\034CarlifeNaviAssitantGuideInfo\022\016\n\006action\030\001 \002(\005\022\025\n\rassistantType\030\002 \002(\005\022\027\n\017trafficSignType\030\003 \002(\005\022\025\n\rtotalDistance\030\004 \002(\005\022\026\n\016remainDistance\030\005 \002(\005\022\023\n\013cameraSpeed\030\006 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeNaviAssitantGuideInfo
    extends GeneratedMessage
  {
    public static final int ACTION_FIELD_NUMBER = 1;
    public static final int ASSISTANTTYPE_FIELD_NUMBER = 2;
    public static final int CAMERASPEED_FIELD_NUMBER = 6;
    public static final int REMAINDISTANCE_FIELD_NUMBER = 5;
    public static final int TOTALDISTANCE_FIELD_NUMBER = 4;
    public static final int TRAFFICSIGNTYPE_FIELD_NUMBER = 3;
    private static final CarlifeNaviAssitantGuideInfo defaultInstance = new CarlifeNaviAssitantGuideInfo();
    private int action_ = 0;
    private int assistantType_ = 0;
    private int cameraSpeed_ = 0;
    private boolean hasAction;
    private boolean hasAssistantType;
    private boolean hasCameraSpeed;
    private boolean hasRemainDistance;
    private boolean hasTotalDistance;
    private boolean hasTrafficSignType;
    private int memoizedSerializedSize = -1;
    private int remainDistance_ = 0;
    private int totalDistance_ = 0;
    private int trafficSignType_ = 0;
    
    static
    {
      CarlifeNaviAssitantGuideInfoProto.getDescriptor();
      CarlifeNaviAssitantGuideInfoProto.internalForceInit();
    }
    
    public static CarlifeNaviAssitantGuideInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeNaviAssitantGuideInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeNaviAssitantGuideInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeNaviAssitantGuideInfo paramCarlifeNaviAssitantGuideInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeNaviAssitantGuideInfo);
    }
    
    public static CarlifeNaviAssitantGuideInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeNaviAssitantGuideInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getAction()
    {
      return this.action_;
    }
    
    public int getAssistantType()
    {
      return this.assistantType_;
    }
    
    public int getCameraSpeed()
    {
      return this.cameraSpeed_;
    }
    
    public CarlifeNaviAssitantGuideInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getRemainDistance()
    {
      return this.remainDistance_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasAction()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getAction());
      }
      i = j;
      if (hasAssistantType()) {
        i = j + CodedOutputStream.computeInt32Size(2, getAssistantType());
      }
      j = i;
      if (hasTrafficSignType()) {
        j = i + CodedOutputStream.computeInt32Size(3, getTrafficSignType());
      }
      i = j;
      if (hasTotalDistance()) {
        i = j + CodedOutputStream.computeInt32Size(4, getTotalDistance());
      }
      j = i;
      if (hasRemainDistance()) {
        j = i + CodedOutputStream.computeInt32Size(5, getRemainDistance());
      }
      i = j;
      if (hasCameraSpeed()) {
        i = j + CodedOutputStream.computeInt32Size(6, getCameraSpeed());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getTotalDistance()
    {
      return this.totalDistance_;
    }
    
    public int getTrafficSignType()
    {
      return this.trafficSignType_;
    }
    
    public boolean hasAction()
    {
      return this.hasAction;
    }
    
    public boolean hasAssistantType()
    {
      return this.hasAssistantType;
    }
    
    public boolean hasCameraSpeed()
    {
      return this.hasCameraSpeed;
    }
    
    public boolean hasRemainDistance()
    {
      return this.hasRemainDistance;
    }
    
    public boolean hasTotalDistance()
    {
      return this.hasTotalDistance;
    }
    
    public boolean hasTrafficSignType()
    {
      return this.hasTrafficSignType;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeNaviAssitantGuideInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeNaviAssitantGuideInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasAction) {}
      while ((!this.hasAssistantType) || (!this.hasTrafficSignType) || (!this.hasTotalDistance) || (!this.hasRemainDistance) || (!this.hasCameraSpeed)) {
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
      if (hasAction()) {
        paramCodedOutputStream.writeInt32(1, getAction());
      }
      if (hasAssistantType()) {
        paramCodedOutputStream.writeInt32(2, getAssistantType());
      }
      if (hasTrafficSignType()) {
        paramCodedOutputStream.writeInt32(3, getTrafficSignType());
      }
      if (hasTotalDistance()) {
        paramCodedOutputStream.writeInt32(4, getTotalDistance());
      }
      if (hasRemainDistance()) {
        paramCodedOutputStream.writeInt32(5, getRemainDistance());
      }
      if (hasCameraSpeed()) {
        paramCodedOutputStream.writeInt32(6, getCameraSpeed());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo result;
      
      private CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo buildParsed()
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
        localBuilder.result = new CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo(null);
        return localBuilder;
      }
      
      public CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo localCarlifeNaviAssitantGuideInfo = this.result;
        this.result = null;
        return localCarlifeNaviAssitantGuideInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo(null);
        return this;
      }
      
      public Builder clearAction()
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$502(this.result, false);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearAssistantType()
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$702(this.result, false);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearCameraSpeed()
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1502(this.result, false);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1602(this.result, 0);
        return this;
      }
      
      public Builder clearRemainDistance()
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1302(this.result, false);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1402(this.result, 0);
        return this;
      }
      
      public Builder clearTotalDistance()
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1102(this.result, false);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1202(this.result, 0);
        return this;
      }
      
      public Builder clearTrafficSignType()
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$902(this.result, false);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getAction()
      {
        return this.result.getAction();
      }
      
      public int getAssistantType()
      {
        return this.result.getAssistantType();
      }
      
      public int getCameraSpeed()
      {
        return this.result.getCameraSpeed();
      }
      
      public CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo getDefaultInstanceForType()
      {
        return CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.getDescriptor();
      }
      
      public int getRemainDistance()
      {
        return this.result.getRemainDistance();
      }
      
      public int getTotalDistance()
      {
        return this.result.getTotalDistance();
      }
      
      public int getTrafficSignType()
      {
        return this.result.getTrafficSignType();
      }
      
      public boolean hasAction()
      {
        return this.result.hasAction();
      }
      
      public boolean hasAssistantType()
      {
        return this.result.hasAssistantType();
      }
      
      public boolean hasCameraSpeed()
      {
        return this.result.hasCameraSpeed();
      }
      
      public boolean hasRemainDistance()
      {
        return this.result.hasRemainDistance();
      }
      
      public boolean hasTotalDistance()
      {
        return this.result.hasTotalDistance();
      }
      
      public boolean hasTrafficSignType()
      {
        return this.result.hasTrafficSignType();
      }
      
      protected CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo paramCarlifeNaviAssitantGuideInfo)
      {
        if (paramCarlifeNaviAssitantGuideInfo == CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeNaviAssitantGuideInfo.hasAction()) {
          setAction(paramCarlifeNaviAssitantGuideInfo.getAction());
        }
        if (paramCarlifeNaviAssitantGuideInfo.hasAssistantType()) {
          setAssistantType(paramCarlifeNaviAssitantGuideInfo.getAssistantType());
        }
        if (paramCarlifeNaviAssitantGuideInfo.hasTrafficSignType()) {
          setTrafficSignType(paramCarlifeNaviAssitantGuideInfo.getTrafficSignType());
        }
        if (paramCarlifeNaviAssitantGuideInfo.hasTotalDistance()) {
          setTotalDistance(paramCarlifeNaviAssitantGuideInfo.getTotalDistance());
        }
        if (paramCarlifeNaviAssitantGuideInfo.hasRemainDistance()) {
          setRemainDistance(paramCarlifeNaviAssitantGuideInfo.getRemainDistance());
        }
        if (paramCarlifeNaviAssitantGuideInfo.hasCameraSpeed()) {
          setCameraSpeed(paramCarlifeNaviAssitantGuideInfo.getCameraSpeed());
        }
        mergeUnknownFields(paramCarlifeNaviAssitantGuideInfo.getUnknownFields());
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
            setAction(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setAssistantType(paramCodedInputStream.readInt32());
            break;
          case 24: 
            setTrafficSignType(paramCodedInputStream.readInt32());
            break;
          case 32: 
            setTotalDistance(paramCodedInputStream.readInt32());
            break;
          case 40: 
            setRemainDistance(paramCodedInputStream.readInt32());
            break;
          case 48: 
            setCameraSpeed(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo)) {
          return mergeFrom((CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAction(int paramInt)
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$502(this.result, true);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setAssistantType(int paramInt)
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$702(this.result, true);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setCameraSpeed(int paramInt)
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1502(this.result, true);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1602(this.result, paramInt);
        return this;
      }
      
      public Builder setRemainDistance(int paramInt)
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1302(this.result, true);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1402(this.result, paramInt);
        return this;
      }
      
      public Builder setTotalDistance(int paramInt)
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1102(this.result, true);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1202(this.result, paramInt);
        return this;
      }
      
      public Builder setTrafficSignType(int paramInt)
      {
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$902(this.result, true);
        CarlifeNaviAssitantGuideInfoProto.CarlifeNaviAssitantGuideInfo.access$1002(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeNaviAssitantGuideInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */