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

public final class CarlifeStatisticsInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeStatisticsInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeStatisticsInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeStatisticsInfoProto.access$2102(paramAnonymousFileDescriptor);
        CarlifeStatisticsInfoProto.access$002((Descriptors.Descriptor)CarlifeStatisticsInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeStatisticsInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeStatisticsInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeStatisticsInfo_descriptor, new String[] { "Cuid", "VersionName", "VersionCode", "Channel", "ConnectCount", "ConnectSuccessCount", "ConnectTime", "CrashLog" }, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.class, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n CarlifeStatisticsInfoProto.proto\022\032com.baidu.carlife.protobuf\"º\001\n\025CarlifeStatisticsInfo\022\f\n\004cuid\030\001 \002(\t\022\023\n\013versionName\030\002 \002(\t\022\023\n\013versionCode\030\003 \002(\005\022\017\n\007channel\030\004 \002(\t\022\024\n\fconnectCount\030\005 \002(\005\022\033\n\023connectSuccessCount\030\006 \002(\005\022\023\n\013connectTime\030\007 \002(\005\022\020\n\bcrashLog\030\b \001(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeStatisticsInfo
    extends GeneratedMessage
  {
    public static final int CHANNEL_FIELD_NUMBER = 4;
    public static final int CONNECTCOUNT_FIELD_NUMBER = 5;
    public static final int CONNECTSUCCESSCOUNT_FIELD_NUMBER = 6;
    public static final int CONNECTTIME_FIELD_NUMBER = 7;
    public static final int CRASHLOG_FIELD_NUMBER = 8;
    public static final int CUID_FIELD_NUMBER = 1;
    public static final int VERSIONCODE_FIELD_NUMBER = 3;
    public static final int VERSIONNAME_FIELD_NUMBER = 2;
    private static final CarlifeStatisticsInfo defaultInstance = new CarlifeStatisticsInfo();
    private String channel_ = "";
    private int connectCount_ = 0;
    private int connectSuccessCount_ = 0;
    private int connectTime_ = 0;
    private String crashLog_ = "";
    private String cuid_ = "";
    private boolean hasChannel;
    private boolean hasConnectCount;
    private boolean hasConnectSuccessCount;
    private boolean hasConnectTime;
    private boolean hasCrashLog;
    private boolean hasCuid;
    private boolean hasVersionCode;
    private boolean hasVersionName;
    private int memoizedSerializedSize = -1;
    private int versionCode_ = 0;
    private String versionName_ = "";
    
    static
    {
      CarlifeStatisticsInfoProto.getDescriptor();
      CarlifeStatisticsInfoProto.internalForceInit();
    }
    
    public static CarlifeStatisticsInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeStatisticsInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeStatisticsInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeStatisticsInfo paramCarlifeStatisticsInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeStatisticsInfo);
    }
    
    public static CarlifeStatisticsInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeStatisticsInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getChannel()
    {
      return this.channel_;
    }
    
    public int getConnectCount()
    {
      return this.connectCount_;
    }
    
    public int getConnectSuccessCount()
    {
      return this.connectSuccessCount_;
    }
    
    public int getConnectTime()
    {
      return this.connectTime_;
    }
    
    public String getCrashLog()
    {
      return this.crashLog_;
    }
    
    public String getCuid()
    {
      return this.cuid_;
    }
    
    public CarlifeStatisticsInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasCuid()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getCuid());
      }
      i = j;
      if (hasVersionName()) {
        i = j + CodedOutputStream.computeStringSize(2, getVersionName());
      }
      j = i;
      if (hasVersionCode()) {
        j = i + CodedOutputStream.computeInt32Size(3, getVersionCode());
      }
      i = j;
      if (hasChannel()) {
        i = j + CodedOutputStream.computeStringSize(4, getChannel());
      }
      j = i;
      if (hasConnectCount()) {
        j = i + CodedOutputStream.computeInt32Size(5, getConnectCount());
      }
      i = j;
      if (hasConnectSuccessCount()) {
        i = j + CodedOutputStream.computeInt32Size(6, getConnectSuccessCount());
      }
      j = i;
      if (hasConnectTime()) {
        j = i + CodedOutputStream.computeInt32Size(7, getConnectTime());
      }
      i = j;
      if (hasCrashLog()) {
        i = j + CodedOutputStream.computeStringSize(8, getCrashLog());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getVersionCode()
    {
      return this.versionCode_;
    }
    
    public String getVersionName()
    {
      return this.versionName_;
    }
    
    public boolean hasChannel()
    {
      return this.hasChannel;
    }
    
    public boolean hasConnectCount()
    {
      return this.hasConnectCount;
    }
    
    public boolean hasConnectSuccessCount()
    {
      return this.hasConnectSuccessCount;
    }
    
    public boolean hasConnectTime()
    {
      return this.hasConnectTime;
    }
    
    public boolean hasCrashLog()
    {
      return this.hasCrashLog;
    }
    
    public boolean hasCuid()
    {
      return this.hasCuid;
    }
    
    public boolean hasVersionCode()
    {
      return this.hasVersionCode;
    }
    
    public boolean hasVersionName()
    {
      return this.hasVersionName;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeStatisticsInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeStatisticsInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasCuid) {}
      while ((!this.hasVersionName) || (!this.hasVersionCode) || (!this.hasChannel) || (!this.hasConnectCount) || (!this.hasConnectSuccessCount) || (!this.hasConnectTime)) {
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
      if (hasCuid()) {
        paramCodedOutputStream.writeString(1, getCuid());
      }
      if (hasVersionName()) {
        paramCodedOutputStream.writeString(2, getVersionName());
      }
      if (hasVersionCode()) {
        paramCodedOutputStream.writeInt32(3, getVersionCode());
      }
      if (hasChannel()) {
        paramCodedOutputStream.writeString(4, getChannel());
      }
      if (hasConnectCount()) {
        paramCodedOutputStream.writeInt32(5, getConnectCount());
      }
      if (hasConnectSuccessCount()) {
        paramCodedOutputStream.writeInt32(6, getConnectSuccessCount());
      }
      if (hasConnectTime()) {
        paramCodedOutputStream.writeInt32(7, getConnectTime());
      }
      if (hasCrashLog()) {
        paramCodedOutputStream.writeString(8, getCrashLog());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeStatisticsInfoProto.CarlifeStatisticsInfo result;
      
      private CarlifeStatisticsInfoProto.CarlifeStatisticsInfo buildParsed()
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
        localBuilder.result = new CarlifeStatisticsInfoProto.CarlifeStatisticsInfo(null);
        return localBuilder;
      }
      
      public CarlifeStatisticsInfoProto.CarlifeStatisticsInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeStatisticsInfoProto.CarlifeStatisticsInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo localCarlifeStatisticsInfo = this.result;
        this.result = null;
        return localCarlifeStatisticsInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeStatisticsInfoProto.CarlifeStatisticsInfo(null);
        return this;
      }
      
      public Builder clearChannel()
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1102(this.result, false);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1202(this.result, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.getDefaultInstance().getChannel());
        return this;
      }
      
      public Builder clearConnectCount()
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1302(this.result, false);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1402(this.result, 0);
        return this;
      }
      
      public Builder clearConnectSuccessCount()
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1502(this.result, false);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1602(this.result, 0);
        return this;
      }
      
      public Builder clearConnectTime()
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1702(this.result, false);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1802(this.result, 0);
        return this;
      }
      
      public Builder clearCrashLog()
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1902(this.result, false);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$2002(this.result, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.getDefaultInstance().getCrashLog());
        return this;
      }
      
      public Builder clearCuid()
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$502(this.result, false);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$602(this.result, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.getDefaultInstance().getCuid());
        return this;
      }
      
      public Builder clearVersionCode()
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$902(this.result, false);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearVersionName()
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$702(this.result, false);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$802(this.result, CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.getDefaultInstance().getVersionName());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public String getChannel()
      {
        return this.result.getChannel();
      }
      
      public int getConnectCount()
      {
        return this.result.getConnectCount();
      }
      
      public int getConnectSuccessCount()
      {
        return this.result.getConnectSuccessCount();
      }
      
      public int getConnectTime()
      {
        return this.result.getConnectTime();
      }
      
      public String getCrashLog()
      {
        return this.result.getCrashLog();
      }
      
      public String getCuid()
      {
        return this.result.getCuid();
      }
      
      public CarlifeStatisticsInfoProto.CarlifeStatisticsInfo getDefaultInstanceForType()
      {
        return CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.getDescriptor();
      }
      
      public int getVersionCode()
      {
        return this.result.getVersionCode();
      }
      
      public String getVersionName()
      {
        return this.result.getVersionName();
      }
      
      public boolean hasChannel()
      {
        return this.result.hasChannel();
      }
      
      public boolean hasConnectCount()
      {
        return this.result.hasConnectCount();
      }
      
      public boolean hasConnectSuccessCount()
      {
        return this.result.hasConnectSuccessCount();
      }
      
      public boolean hasConnectTime()
      {
        return this.result.hasConnectTime();
      }
      
      public boolean hasCrashLog()
      {
        return this.result.hasCrashLog();
      }
      
      public boolean hasCuid()
      {
        return this.result.hasCuid();
      }
      
      public boolean hasVersionCode()
      {
        return this.result.hasVersionCode();
      }
      
      public boolean hasVersionName()
      {
        return this.result.hasVersionName();
      }
      
      protected CarlifeStatisticsInfoProto.CarlifeStatisticsInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeStatisticsInfoProto.CarlifeStatisticsInfo paramCarlifeStatisticsInfo)
      {
        if (paramCarlifeStatisticsInfo == CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeStatisticsInfo.hasCuid()) {
          setCuid(paramCarlifeStatisticsInfo.getCuid());
        }
        if (paramCarlifeStatisticsInfo.hasVersionName()) {
          setVersionName(paramCarlifeStatisticsInfo.getVersionName());
        }
        if (paramCarlifeStatisticsInfo.hasVersionCode()) {
          setVersionCode(paramCarlifeStatisticsInfo.getVersionCode());
        }
        if (paramCarlifeStatisticsInfo.hasChannel()) {
          setChannel(paramCarlifeStatisticsInfo.getChannel());
        }
        if (paramCarlifeStatisticsInfo.hasConnectCount()) {
          setConnectCount(paramCarlifeStatisticsInfo.getConnectCount());
        }
        if (paramCarlifeStatisticsInfo.hasConnectSuccessCount()) {
          setConnectSuccessCount(paramCarlifeStatisticsInfo.getConnectSuccessCount());
        }
        if (paramCarlifeStatisticsInfo.hasConnectTime()) {
          setConnectTime(paramCarlifeStatisticsInfo.getConnectTime());
        }
        if (paramCarlifeStatisticsInfo.hasCrashLog()) {
          setCrashLog(paramCarlifeStatisticsInfo.getCrashLog());
        }
        mergeUnknownFields(paramCarlifeStatisticsInfo.getUnknownFields());
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
            setCuid(paramCodedInputStream.readString());
            break;
          case 18: 
            setVersionName(paramCodedInputStream.readString());
            break;
          case 24: 
            setVersionCode(paramCodedInputStream.readInt32());
            break;
          case 34: 
            setChannel(paramCodedInputStream.readString());
            break;
          case 40: 
            setConnectCount(paramCodedInputStream.readInt32());
            break;
          case 48: 
            setConnectSuccessCount(paramCodedInputStream.readInt32());
            break;
          case 56: 
            setConnectTime(paramCodedInputStream.readInt32());
            break;
          case 66: 
            setCrashLog(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)) {
          return mergeFrom((CarlifeStatisticsInfoProto.CarlifeStatisticsInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setChannel(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1102(this.result, true);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1202(this.result, paramString);
        return this;
      }
      
      public Builder setConnectCount(int paramInt)
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1302(this.result, true);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1402(this.result, paramInt);
        return this;
      }
      
      public Builder setConnectSuccessCount(int paramInt)
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1502(this.result, true);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1602(this.result, paramInt);
        return this;
      }
      
      public Builder setConnectTime(int paramInt)
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1702(this.result, true);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1802(this.result, paramInt);
        return this;
      }
      
      public Builder setCrashLog(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1902(this.result, true);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$2002(this.result, paramString);
        return this;
      }
      
      public Builder setCuid(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$502(this.result, true);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$602(this.result, paramString);
        return this;
      }
      
      public Builder setVersionCode(int paramInt)
      {
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$902(this.result, true);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setVersionName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$702(this.result, true);
        CarlifeStatisticsInfoProto.CarlifeStatisticsInfo.access$802(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeStatisticsInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */