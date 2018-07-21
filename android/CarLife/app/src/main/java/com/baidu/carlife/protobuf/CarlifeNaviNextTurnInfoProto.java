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

public final class CarlifeNaviNextTurnInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeNaviNextTurnInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeNaviNextTurnInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeNaviNextTurnInfoProto.access$1702(paramAnonymousFileDescriptor);
        CarlifeNaviNextTurnInfoProto.access$002((Descriptors.Descriptor)CarlifeNaviNextTurnInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeNaviNextTurnInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeNaviNextTurnInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeNaviNextTurnInfo_descriptor, new String[] { "Action", "NextTurn", "RoadName", "TotalDistance", "RemainDistance", "TurnIconData" }, CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.class, CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\"CarlifeNaviNextTurnInfoProto.proto\022\032com.baidu.carlife.protobuf\"\001\n\027CarlifeNaviNextTurnInfo\022\016\n\006action\030\001 \002(\005\022\020\n\bnextTurn\030\002 \002(\005\022\020\n\broadName\030\003 \002(\t\022\025\n\rtotalDistance\030\004 \002(\005\022\026\n\016remainDistance\030\005 \002(\005\022\024\n\fturnIconData\030\006 \002(\f" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeNaviNextTurnInfo
    extends GeneratedMessage
  {
    public static final int ACTION_FIELD_NUMBER = 1;
    public static final int NEXTTURN_FIELD_NUMBER = 2;
    public static final int REMAINDISTANCE_FIELD_NUMBER = 5;
    public static final int ROADNAME_FIELD_NUMBER = 3;
    public static final int TOTALDISTANCE_FIELD_NUMBER = 4;
    public static final int TURNICONDATA_FIELD_NUMBER = 6;
    private static final CarlifeNaviNextTurnInfo defaultInstance = new CarlifeNaviNextTurnInfo();
    private int action_ = 0;
    private boolean hasAction;
    private boolean hasNextTurn;
    private boolean hasRemainDistance;
    private boolean hasRoadName;
    private boolean hasTotalDistance;
    private boolean hasTurnIconData;
    private int memoizedSerializedSize = -1;
    private int nextTurn_ = 0;
    private int remainDistance_ = 0;
    private String roadName_ = "";
    private int totalDistance_ = 0;
    private ByteString turnIconData_ = ByteString.EMPTY;
    
    static
    {
      CarlifeNaviNextTurnInfoProto.getDescriptor();
      CarlifeNaviNextTurnInfoProto.internalForceInit();
    }
    
    public static CarlifeNaviNextTurnInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeNaviNextTurnInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeNaviNextTurnInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeNaviNextTurnInfo paramCarlifeNaviNextTurnInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeNaviNextTurnInfo);
    }
    
    public static CarlifeNaviNextTurnInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeNaviNextTurnInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getAction()
    {
      return this.action_;
    }
    
    public CarlifeNaviNextTurnInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getNextTurn()
    {
      return this.nextTurn_;
    }
    
    public int getRemainDistance()
    {
      return this.remainDistance_;
    }
    
    public String getRoadName()
    {
      return this.roadName_;
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
      if (hasNextTurn()) {
        i = j + CodedOutputStream.computeInt32Size(2, getNextTurn());
      }
      j = i;
      if (hasRoadName()) {
        j = i + CodedOutputStream.computeStringSize(3, getRoadName());
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
      if (hasTurnIconData()) {
        i = j + CodedOutputStream.computeBytesSize(6, getTurnIconData());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getTotalDistance()
    {
      return this.totalDistance_;
    }
    
    public ByteString getTurnIconData()
    {
      return this.turnIconData_;
    }
    
    public boolean hasAction()
    {
      return this.hasAction;
    }
    
    public boolean hasNextTurn()
    {
      return this.hasNextTurn;
    }
    
    public boolean hasRemainDistance()
    {
      return this.hasRemainDistance;
    }
    
    public boolean hasRoadName()
    {
      return this.hasRoadName;
    }
    
    public boolean hasTotalDistance()
    {
      return this.hasTotalDistance;
    }
    
    public boolean hasTurnIconData()
    {
      return this.hasTurnIconData;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeNaviNextTurnInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeNaviNextTurnInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasAction) {}
      while ((!this.hasNextTurn) || (!this.hasRoadName) || (!this.hasTotalDistance) || (!this.hasRemainDistance) || (!this.hasTurnIconData)) {
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
      if (hasNextTurn()) {
        paramCodedOutputStream.writeInt32(2, getNextTurn());
      }
      if (hasRoadName()) {
        paramCodedOutputStream.writeString(3, getRoadName());
      }
      if (hasTotalDistance()) {
        paramCodedOutputStream.writeInt32(4, getTotalDistance());
      }
      if (hasRemainDistance()) {
        paramCodedOutputStream.writeInt32(5, getRemainDistance());
      }
      if (hasTurnIconData()) {
        paramCodedOutputStream.writeBytes(6, getTurnIconData());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo result;
      
      private CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo buildParsed()
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
        localBuilder.result = new CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo(null);
        return localBuilder;
      }
      
      public CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo localCarlifeNaviNextTurnInfo = this.result;
        this.result = null;
        return localCarlifeNaviNextTurnInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo(null);
        return this;
      }
      
      public Builder clearAction()
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$502(this.result, false);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearNextTurn()
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$702(this.result, false);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearRemainDistance()
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1302(this.result, false);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1402(this.result, 0);
        return this;
      }
      
      public Builder clearRoadName()
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$902(this.result, false);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1002(this.result, CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.getDefaultInstance().getRoadName());
        return this;
      }
      
      public Builder clearTotalDistance()
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1102(this.result, false);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1202(this.result, 0);
        return this;
      }
      
      public Builder clearTurnIconData()
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1502(this.result, false);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1602(this.result, CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.getDefaultInstance().getTurnIconData());
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
      
      public CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo getDefaultInstanceForType()
      {
        return CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.getDescriptor();
      }
      
      public int getNextTurn()
      {
        return this.result.getNextTurn();
      }
      
      public int getRemainDistance()
      {
        return this.result.getRemainDistance();
      }
      
      public String getRoadName()
      {
        return this.result.getRoadName();
      }
      
      public int getTotalDistance()
      {
        return this.result.getTotalDistance();
      }
      
      public ByteString getTurnIconData()
      {
        return this.result.getTurnIconData();
      }
      
      public boolean hasAction()
      {
        return this.result.hasAction();
      }
      
      public boolean hasNextTurn()
      {
        return this.result.hasNextTurn();
      }
      
      public boolean hasRemainDistance()
      {
        return this.result.hasRemainDistance();
      }
      
      public boolean hasRoadName()
      {
        return this.result.hasRoadName();
      }
      
      public boolean hasTotalDistance()
      {
        return this.result.hasTotalDistance();
      }
      
      public boolean hasTurnIconData()
      {
        return this.result.hasTurnIconData();
      }
      
      protected CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo paramCarlifeNaviNextTurnInfo)
      {
        if (paramCarlifeNaviNextTurnInfo == CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeNaviNextTurnInfo.hasAction()) {
          setAction(paramCarlifeNaviNextTurnInfo.getAction());
        }
        if (paramCarlifeNaviNextTurnInfo.hasNextTurn()) {
          setNextTurn(paramCarlifeNaviNextTurnInfo.getNextTurn());
        }
        if (paramCarlifeNaviNextTurnInfo.hasRoadName()) {
          setRoadName(paramCarlifeNaviNextTurnInfo.getRoadName());
        }
        if (paramCarlifeNaviNextTurnInfo.hasTotalDistance()) {
          setTotalDistance(paramCarlifeNaviNextTurnInfo.getTotalDistance());
        }
        if (paramCarlifeNaviNextTurnInfo.hasRemainDistance()) {
          setRemainDistance(paramCarlifeNaviNextTurnInfo.getRemainDistance());
        }
        if (paramCarlifeNaviNextTurnInfo.hasTurnIconData()) {
          setTurnIconData(paramCarlifeNaviNextTurnInfo.getTurnIconData());
        }
        mergeUnknownFields(paramCarlifeNaviNextTurnInfo.getUnknownFields());
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
            setNextTurn(paramCodedInputStream.readInt32());
            break;
          case 26: 
            setRoadName(paramCodedInputStream.readString());
            break;
          case 32: 
            setTotalDistance(paramCodedInputStream.readInt32());
            break;
          case 40: 
            setRemainDistance(paramCodedInputStream.readInt32());
            break;
          case 50: 
            setTurnIconData(paramCodedInputStream.readBytes());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo)) {
          return mergeFrom((CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAction(int paramInt)
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$502(this.result, true);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setNextTurn(int paramInt)
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$702(this.result, true);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setRemainDistance(int paramInt)
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1302(this.result, true);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1402(this.result, paramInt);
        return this;
      }
      
      public Builder setRoadName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$902(this.result, true);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1002(this.result, paramString);
        return this;
      }
      
      public Builder setTotalDistance(int paramInt)
      {
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1102(this.result, true);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1202(this.result, paramInt);
        return this;
      }
      
      public Builder setTurnIconData(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1502(this.result, true);
        CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.access$1602(this.result, paramByteString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeNaviNextTurnInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */