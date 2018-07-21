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

public final class CarlifeCarGpsProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeCarGps_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeCarGps_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeCarGpsProto.access$5502(paramAnonymousFileDescriptor);
        CarlifeCarGpsProto.access$002((Descriptors.Descriptor)CarlifeCarGpsProto.getDescriptor().getMessageTypes().get(0));
        CarlifeCarGpsProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeCarGpsProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarGps_descriptor, new String[] { "AntennaState", "SignalQuality", "Latitude", "Longitude", "Height", "Speed", "Heading", "Year", "Month", "Day", "Hrs", "Min", "Sec", "Fix", "Hdop", "Pdop", "Vdop", "SatsUsed", "SatsVisible", "HorPosError", "VertPosError", "NorthSpeed", "EastSpeed", "VertSpeed", "TimeStamp" }, CarlifeCarGpsProto.CarlifeCarGps.class, CarlifeCarGpsProto.CarlifeCarGps.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\030CarlifeCarGpsProto.proto\022\032com.baidu.carlife.protobuf\"¸\003\n\rCarlifeCarGps\022\024\n\fantennaState\030\001 \002(\r\022\025\n\rsignalQuality\030\002 \002(\r\022\020\n\blatitude\030\003 \002(\005\022\021\n\tlongitude\030\004 \002(\005\022\016\n\006height\030\005 \002(\005\022\r\n\005speed\030\006 \002(\r\022\017\n\007heading\030\007 \002(\r\022\f\n\004year\030\b \002(\r\022\r\n\005month\030\t \002(\r\022\013\n\003day\030\n \002(\r\022\013\n\003hrs\030\013 \002(\r\022\013\n\003min\030\f \002(\r\022\013\n\003sec\030\r \002(\r\022\013\n\003fix\030\016 \002(\r\022\f\n\004hdop\030\017 \002(\r\022\f\n\004pdop\030\020 \002(\r\022\f\n\004vdop\030\021 \002(\r\022\020\n\bsatsUsed\030\022 \002(\r\022\023\n\013satsVisible\030\023 \002(\r\022\023\n\013horPosError\030\024 \002(\r\022\024", "\n\fvertPosError\030\025 \002(\r\022\022\n\nnorthSpeed\030\026 \002(\005\022\021\n\teastSpeed\030\027 \002(\005\022\021\n\tvertSpeed\030\030 \002(\005\022\021\n\ttimeStamp\030\031 \001(\004" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeCarGps
    extends GeneratedMessage
  {
    public static final int ANTENNASTATE_FIELD_NUMBER = 1;
    public static final int DAY_FIELD_NUMBER = 10;
    public static final int EASTSPEED_FIELD_NUMBER = 23;
    public static final int FIX_FIELD_NUMBER = 14;
    public static final int HDOP_FIELD_NUMBER = 15;
    public static final int HEADING_FIELD_NUMBER = 7;
    public static final int HEIGHT_FIELD_NUMBER = 5;
    public static final int HORPOSERROR_FIELD_NUMBER = 20;
    public static final int HRS_FIELD_NUMBER = 11;
    public static final int LATITUDE_FIELD_NUMBER = 3;
    public static final int LONGITUDE_FIELD_NUMBER = 4;
    public static final int MIN_FIELD_NUMBER = 12;
    public static final int MONTH_FIELD_NUMBER = 9;
    public static final int NORTHSPEED_FIELD_NUMBER = 22;
    public static final int PDOP_FIELD_NUMBER = 16;
    public static final int SATSUSED_FIELD_NUMBER = 18;
    public static final int SATSVISIBLE_FIELD_NUMBER = 19;
    public static final int SEC_FIELD_NUMBER = 13;
    public static final int SIGNALQUALITY_FIELD_NUMBER = 2;
    public static final int SPEED_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 25;
    public static final int VDOP_FIELD_NUMBER = 17;
    public static final int VERTPOSERROR_FIELD_NUMBER = 21;
    public static final int VERTSPEED_FIELD_NUMBER = 24;
    public static final int YEAR_FIELD_NUMBER = 8;
    private static final CarlifeCarGps defaultInstance = new CarlifeCarGps();
    private int antennaState_ = 0;
    private int day_ = 0;
    private int eastSpeed_ = 0;
    private int fix_ = 0;
    private boolean hasAntennaState;
    private boolean hasDay;
    private boolean hasEastSpeed;
    private boolean hasFix;
    private boolean hasHdop;
    private boolean hasHeading;
    private boolean hasHeight;
    private boolean hasHorPosError;
    private boolean hasHrs;
    private boolean hasLatitude;
    private boolean hasLongitude;
    private boolean hasMin;
    private boolean hasMonth;
    private boolean hasNorthSpeed;
    private boolean hasPdop;
    private boolean hasSatsUsed;
    private boolean hasSatsVisible;
    private boolean hasSec;
    private boolean hasSignalQuality;
    private boolean hasSpeed;
    private boolean hasTimeStamp;
    private boolean hasVdop;
    private boolean hasVertPosError;
    private boolean hasVertSpeed;
    private boolean hasYear;
    private int hdop_ = 0;
    private int heading_ = 0;
    private int height_ = 0;
    private int horPosError_ = 0;
    private int hrs_ = 0;
    private int latitude_ = 0;
    private int longitude_ = 0;
    private int memoizedSerializedSize = -1;
    private int min_ = 0;
    private int month_ = 0;
    private int northSpeed_ = 0;
    private int pdop_ = 0;
    private int satsUsed_ = 0;
    private int satsVisible_ = 0;
    private int sec_ = 0;
    private int signalQuality_ = 0;
    private int speed_ = 0;
    private long timeStamp_ = 0L;
    private int vdop_ = 0;
    private int vertPosError_ = 0;
    private int vertSpeed_ = 0;
    private int year_ = 0;
    
    static
    {
      CarlifeCarGpsProto.getDescriptor();
      CarlifeCarGpsProto.internalForceInit();
    }
    
    public static CarlifeCarGps getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeCarGpsProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarGps_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeCarGps paramCarlifeCarGps)
    {
      return newBuilder().mergeFrom(paramCarlifeCarGps);
    }
    
    public static CarlifeCarGps parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeCarGps parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarGps parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeCarGps parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarGps parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeCarGps parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeCarGps parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeCarGps parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarGps parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeCarGps parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getAntennaState()
    {
      return this.antennaState_;
    }
    
    public int getDay()
    {
      return this.day_;
    }
    
    public CarlifeCarGps getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getEastSpeed()
    {
      return this.eastSpeed_;
    }
    
    public int getFix()
    {
      return this.fix_;
    }
    
    public int getHdop()
    {
      return this.hdop_;
    }
    
    public int getHeading()
    {
      return this.heading_;
    }
    
    public int getHeight()
    {
      return this.height_;
    }
    
    public int getHorPosError()
    {
      return this.horPosError_;
    }
    
    public int getHrs()
    {
      return this.hrs_;
    }
    
    public int getLatitude()
    {
      return this.latitude_;
    }
    
    public int getLongitude()
    {
      return this.longitude_;
    }
    
    public int getMin()
    {
      return this.min_;
    }
    
    public int getMonth()
    {
      return this.month_;
    }
    
    public int getNorthSpeed()
    {
      return this.northSpeed_;
    }
    
    public int getPdop()
    {
      return this.pdop_;
    }
    
    public int getSatsUsed()
    {
      return this.satsUsed_;
    }
    
    public int getSatsVisible()
    {
      return this.satsVisible_;
    }
    
    public int getSec()
    {
      return this.sec_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasAntennaState()) {
        j = 0 + CodedOutputStream.computeUInt32Size(1, getAntennaState());
      }
      i = j;
      if (hasSignalQuality()) {
        i = j + CodedOutputStream.computeUInt32Size(2, getSignalQuality());
      }
      j = i;
      if (hasLatitude()) {
        j = i + CodedOutputStream.computeInt32Size(3, getLatitude());
      }
      i = j;
      if (hasLongitude()) {
        i = j + CodedOutputStream.computeInt32Size(4, getLongitude());
      }
      j = i;
      if (hasHeight()) {
        j = i + CodedOutputStream.computeInt32Size(5, getHeight());
      }
      i = j;
      if (hasSpeed()) {
        i = j + CodedOutputStream.computeUInt32Size(6, getSpeed());
      }
      j = i;
      if (hasHeading()) {
        j = i + CodedOutputStream.computeUInt32Size(7, getHeading());
      }
      i = j;
      if (hasYear()) {
        i = j + CodedOutputStream.computeUInt32Size(8, getYear());
      }
      j = i;
      if (hasMonth()) {
        j = i + CodedOutputStream.computeUInt32Size(9, getMonth());
      }
      i = j;
      if (hasDay()) {
        i = j + CodedOutputStream.computeUInt32Size(10, getDay());
      }
      j = i;
      if (hasHrs()) {
        j = i + CodedOutputStream.computeUInt32Size(11, getHrs());
      }
      i = j;
      if (hasMin()) {
        i = j + CodedOutputStream.computeUInt32Size(12, getMin());
      }
      j = i;
      if (hasSec()) {
        j = i + CodedOutputStream.computeUInt32Size(13, getSec());
      }
      i = j;
      if (hasFix()) {
        i = j + CodedOutputStream.computeUInt32Size(14, getFix());
      }
      j = i;
      if (hasHdop()) {
        j = i + CodedOutputStream.computeUInt32Size(15, getHdop());
      }
      i = j;
      if (hasPdop()) {
        i = j + CodedOutputStream.computeUInt32Size(16, getPdop());
      }
      j = i;
      if (hasVdop()) {
        j = i + CodedOutputStream.computeUInt32Size(17, getVdop());
      }
      i = j;
      if (hasSatsUsed()) {
        i = j + CodedOutputStream.computeUInt32Size(18, getSatsUsed());
      }
      j = i;
      if (hasSatsVisible()) {
        j = i + CodedOutputStream.computeUInt32Size(19, getSatsVisible());
      }
      i = j;
      if (hasHorPosError()) {
        i = j + CodedOutputStream.computeUInt32Size(20, getHorPosError());
      }
      j = i;
      if (hasVertPosError()) {
        j = i + CodedOutputStream.computeUInt32Size(21, getVertPosError());
      }
      i = j;
      if (hasNorthSpeed()) {
        i = j + CodedOutputStream.computeInt32Size(22, getNorthSpeed());
      }
      j = i;
      if (hasEastSpeed()) {
        j = i + CodedOutputStream.computeInt32Size(23, getEastSpeed());
      }
      i = j;
      if (hasVertSpeed()) {
        i = j + CodedOutputStream.computeInt32Size(24, getVertSpeed());
      }
      j = i;
      if (hasTimeStamp()) {
        j = i + CodedOutputStream.computeUInt64Size(25, getTimeStamp());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getSignalQuality()
    {
      return this.signalQuality_;
    }
    
    public int getSpeed()
    {
      return this.speed_;
    }
    
    public long getTimeStamp()
    {
      return this.timeStamp_;
    }
    
    public int getVdop()
    {
      return this.vdop_;
    }
    
    public int getVertPosError()
    {
      return this.vertPosError_;
    }
    
    public int getVertSpeed()
    {
      return this.vertSpeed_;
    }
    
    public int getYear()
    {
      return this.year_;
    }
    
    public boolean hasAntennaState()
    {
      return this.hasAntennaState;
    }
    
    public boolean hasDay()
    {
      return this.hasDay;
    }
    
    public boolean hasEastSpeed()
    {
      return this.hasEastSpeed;
    }
    
    public boolean hasFix()
    {
      return this.hasFix;
    }
    
    public boolean hasHdop()
    {
      return this.hasHdop;
    }
    
    public boolean hasHeading()
    {
      return this.hasHeading;
    }
    
    public boolean hasHeight()
    {
      return this.hasHeight;
    }
    
    public boolean hasHorPosError()
    {
      return this.hasHorPosError;
    }
    
    public boolean hasHrs()
    {
      return this.hasHrs;
    }
    
    public boolean hasLatitude()
    {
      return this.hasLatitude;
    }
    
    public boolean hasLongitude()
    {
      return this.hasLongitude;
    }
    
    public boolean hasMin()
    {
      return this.hasMin;
    }
    
    public boolean hasMonth()
    {
      return this.hasMonth;
    }
    
    public boolean hasNorthSpeed()
    {
      return this.hasNorthSpeed;
    }
    
    public boolean hasPdop()
    {
      return this.hasPdop;
    }
    
    public boolean hasSatsUsed()
    {
      return this.hasSatsUsed;
    }
    
    public boolean hasSatsVisible()
    {
      return this.hasSatsVisible;
    }
    
    public boolean hasSec()
    {
      return this.hasSec;
    }
    
    public boolean hasSignalQuality()
    {
      return this.hasSignalQuality;
    }
    
    public boolean hasSpeed()
    {
      return this.hasSpeed;
    }
    
    public boolean hasTimeStamp()
    {
      return this.hasTimeStamp;
    }
    
    public boolean hasVdop()
    {
      return this.hasVdop;
    }
    
    public boolean hasVertPosError()
    {
      return this.hasVertPosError;
    }
    
    public boolean hasVertSpeed()
    {
      return this.hasVertSpeed;
    }
    
    public boolean hasYear()
    {
      return this.hasYear;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeCarGpsProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarGps_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasAntennaState) {}
      while ((!this.hasSignalQuality) || (!this.hasLatitude) || (!this.hasLongitude) || (!this.hasHeight) || (!this.hasSpeed) || (!this.hasHeading) || (!this.hasYear) || (!this.hasMonth) || (!this.hasDay) || (!this.hasHrs) || (!this.hasMin) || (!this.hasSec) || (!this.hasFix) || (!this.hasHdop) || (!this.hasPdop) || (!this.hasVdop) || (!this.hasSatsUsed) || (!this.hasSatsVisible) || (!this.hasHorPosError) || (!this.hasVertPosError) || (!this.hasNorthSpeed) || (!this.hasEastSpeed) || (!this.hasVertSpeed)) {
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
      if (hasAntennaState()) {
        paramCodedOutputStream.writeUInt32(1, getAntennaState());
      }
      if (hasSignalQuality()) {
        paramCodedOutputStream.writeUInt32(2, getSignalQuality());
      }
      if (hasLatitude()) {
        paramCodedOutputStream.writeInt32(3, getLatitude());
      }
      if (hasLongitude()) {
        paramCodedOutputStream.writeInt32(4, getLongitude());
      }
      if (hasHeight()) {
        paramCodedOutputStream.writeInt32(5, getHeight());
      }
      if (hasSpeed()) {
        paramCodedOutputStream.writeUInt32(6, getSpeed());
      }
      if (hasHeading()) {
        paramCodedOutputStream.writeUInt32(7, getHeading());
      }
      if (hasYear()) {
        paramCodedOutputStream.writeUInt32(8, getYear());
      }
      if (hasMonth()) {
        paramCodedOutputStream.writeUInt32(9, getMonth());
      }
      if (hasDay()) {
        paramCodedOutputStream.writeUInt32(10, getDay());
      }
      if (hasHrs()) {
        paramCodedOutputStream.writeUInt32(11, getHrs());
      }
      if (hasMin()) {
        paramCodedOutputStream.writeUInt32(12, getMin());
      }
      if (hasSec()) {
        paramCodedOutputStream.writeUInt32(13, getSec());
      }
      if (hasFix()) {
        paramCodedOutputStream.writeUInt32(14, getFix());
      }
      if (hasHdop()) {
        paramCodedOutputStream.writeUInt32(15, getHdop());
      }
      if (hasPdop()) {
        paramCodedOutputStream.writeUInt32(16, getPdop());
      }
      if (hasVdop()) {
        paramCodedOutputStream.writeUInt32(17, getVdop());
      }
      if (hasSatsUsed()) {
        paramCodedOutputStream.writeUInt32(18, getSatsUsed());
      }
      if (hasSatsVisible()) {
        paramCodedOutputStream.writeUInt32(19, getSatsVisible());
      }
      if (hasHorPosError()) {
        paramCodedOutputStream.writeUInt32(20, getHorPosError());
      }
      if (hasVertPosError()) {
        paramCodedOutputStream.writeUInt32(21, getVertPosError());
      }
      if (hasNorthSpeed()) {
        paramCodedOutputStream.writeInt32(22, getNorthSpeed());
      }
      if (hasEastSpeed()) {
        paramCodedOutputStream.writeInt32(23, getEastSpeed());
      }
      if (hasVertSpeed()) {
        paramCodedOutputStream.writeInt32(24, getVertSpeed());
      }
      if (hasTimeStamp()) {
        paramCodedOutputStream.writeUInt64(25, getTimeStamp());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeCarGpsProto.CarlifeCarGps result;
      
      private CarlifeCarGpsProto.CarlifeCarGps buildParsed()
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
        localBuilder.result = new CarlifeCarGpsProto.CarlifeCarGps(null);
        return localBuilder;
      }
      
      public CarlifeCarGpsProto.CarlifeCarGps build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeCarGpsProto.CarlifeCarGps buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeCarGpsProto.CarlifeCarGps localCarlifeCarGps = this.result;
        this.result = null;
        return localCarlifeCarGps;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeCarGpsProto.CarlifeCarGps(null);
        return this;
      }
      
      public Builder clearAntennaState()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$502(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearDay()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2302(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$2402(this.result, 0);
        return this;
      }
      
      public Builder clearEastSpeed()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4902(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$5002(this.result, 0);
        return this;
      }
      
      public Builder clearFix()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3102(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$3202(this.result, 0);
        return this;
      }
      
      public Builder clearHdop()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3302(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$3402(this.result, 0);
        return this;
      }
      
      public Builder clearHeading()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1702(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$1802(this.result, 0);
        return this;
      }
      
      public Builder clearHeight()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1302(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$1402(this.result, 0);
        return this;
      }
      
      public Builder clearHorPosError()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4302(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$4402(this.result, 0);
        return this;
      }
      
      public Builder clearHrs()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2502(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$2602(this.result, 0);
        return this;
      }
      
      public Builder clearLatitude()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$902(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearLongitude()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1102(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$1202(this.result, 0);
        return this;
      }
      
      public Builder clearMin()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2702(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$2802(this.result, 0);
        return this;
      }
      
      public Builder clearMonth()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2102(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$2202(this.result, 0);
        return this;
      }
      
      public Builder clearNorthSpeed()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4702(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$4802(this.result, 0);
        return this;
      }
      
      public Builder clearPdop()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3502(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$3602(this.result, 0);
        return this;
      }
      
      public Builder clearSatsUsed()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3902(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$4002(this.result, 0);
        return this;
      }
      
      public Builder clearSatsVisible()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4102(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$4202(this.result, 0);
        return this;
      }
      
      public Builder clearSec()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2902(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$3002(this.result, 0);
        return this;
      }
      
      public Builder clearSignalQuality()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$702(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearSpeed()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1502(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$1602(this.result, 0);
        return this;
      }
      
      public Builder clearTimeStamp()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$5302(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$5402(this.result, 0L);
        return this;
      }
      
      public Builder clearVdop()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3702(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$3802(this.result, 0);
        return this;
      }
      
      public Builder clearVertPosError()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4502(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$4602(this.result, 0);
        return this;
      }
      
      public Builder clearVertSpeed()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$5102(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$5202(this.result, 0);
        return this;
      }
      
      public Builder clearYear()
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1902(this.result, false);
        CarlifeCarGpsProto.CarlifeCarGps.access$2002(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getAntennaState()
      {
        return this.result.getAntennaState();
      }
      
      public int getDay()
      {
        return this.result.getDay();
      }
      
      public CarlifeCarGpsProto.CarlifeCarGps getDefaultInstanceForType()
      {
        return CarlifeCarGpsProto.CarlifeCarGps.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeCarGpsProto.CarlifeCarGps.getDescriptor();
      }
      
      public int getEastSpeed()
      {
        return this.result.getEastSpeed();
      }
      
      public int getFix()
      {
        return this.result.getFix();
      }
      
      public int getHdop()
      {
        return this.result.getHdop();
      }
      
      public int getHeading()
      {
        return this.result.getHeading();
      }
      
      public int getHeight()
      {
        return this.result.getHeight();
      }
      
      public int getHorPosError()
      {
        return this.result.getHorPosError();
      }
      
      public int getHrs()
      {
        return this.result.getHrs();
      }
      
      public int getLatitude()
      {
        return this.result.getLatitude();
      }
      
      public int getLongitude()
      {
        return this.result.getLongitude();
      }
      
      public int getMin()
      {
        return this.result.getMin();
      }
      
      public int getMonth()
      {
        return this.result.getMonth();
      }
      
      public int getNorthSpeed()
      {
        return this.result.getNorthSpeed();
      }
      
      public int getPdop()
      {
        return this.result.getPdop();
      }
      
      public int getSatsUsed()
      {
        return this.result.getSatsUsed();
      }
      
      public int getSatsVisible()
      {
        return this.result.getSatsVisible();
      }
      
      public int getSec()
      {
        return this.result.getSec();
      }
      
      public int getSignalQuality()
      {
        return this.result.getSignalQuality();
      }
      
      public int getSpeed()
      {
        return this.result.getSpeed();
      }
      
      public long getTimeStamp()
      {
        return this.result.getTimeStamp();
      }
      
      public int getVdop()
      {
        return this.result.getVdop();
      }
      
      public int getVertPosError()
      {
        return this.result.getVertPosError();
      }
      
      public int getVertSpeed()
      {
        return this.result.getVertSpeed();
      }
      
      public int getYear()
      {
        return this.result.getYear();
      }
      
      public boolean hasAntennaState()
      {
        return this.result.hasAntennaState();
      }
      
      public boolean hasDay()
      {
        return this.result.hasDay();
      }
      
      public boolean hasEastSpeed()
      {
        return this.result.hasEastSpeed();
      }
      
      public boolean hasFix()
      {
        return this.result.hasFix();
      }
      
      public boolean hasHdop()
      {
        return this.result.hasHdop();
      }
      
      public boolean hasHeading()
      {
        return this.result.hasHeading();
      }
      
      public boolean hasHeight()
      {
        return this.result.hasHeight();
      }
      
      public boolean hasHorPosError()
      {
        return this.result.hasHorPosError();
      }
      
      public boolean hasHrs()
      {
        return this.result.hasHrs();
      }
      
      public boolean hasLatitude()
      {
        return this.result.hasLatitude();
      }
      
      public boolean hasLongitude()
      {
        return this.result.hasLongitude();
      }
      
      public boolean hasMin()
      {
        return this.result.hasMin();
      }
      
      public boolean hasMonth()
      {
        return this.result.hasMonth();
      }
      
      public boolean hasNorthSpeed()
      {
        return this.result.hasNorthSpeed();
      }
      
      public boolean hasPdop()
      {
        return this.result.hasPdop();
      }
      
      public boolean hasSatsUsed()
      {
        return this.result.hasSatsUsed();
      }
      
      public boolean hasSatsVisible()
      {
        return this.result.hasSatsVisible();
      }
      
      public boolean hasSec()
      {
        return this.result.hasSec();
      }
      
      public boolean hasSignalQuality()
      {
        return this.result.hasSignalQuality();
      }
      
      public boolean hasSpeed()
      {
        return this.result.hasSpeed();
      }
      
      public boolean hasTimeStamp()
      {
        return this.result.hasTimeStamp();
      }
      
      public boolean hasVdop()
      {
        return this.result.hasVdop();
      }
      
      public boolean hasVertPosError()
      {
        return this.result.hasVertPosError();
      }
      
      public boolean hasVertSpeed()
      {
        return this.result.hasVertSpeed();
      }
      
      public boolean hasYear()
      {
        return this.result.hasYear();
      }
      
      protected CarlifeCarGpsProto.CarlifeCarGps internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeCarGpsProto.CarlifeCarGps paramCarlifeCarGps)
      {
        if (paramCarlifeCarGps == CarlifeCarGpsProto.CarlifeCarGps.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeCarGps.hasAntennaState()) {
          setAntennaState(paramCarlifeCarGps.getAntennaState());
        }
        if (paramCarlifeCarGps.hasSignalQuality()) {
          setSignalQuality(paramCarlifeCarGps.getSignalQuality());
        }
        if (paramCarlifeCarGps.hasLatitude()) {
          setLatitude(paramCarlifeCarGps.getLatitude());
        }
        if (paramCarlifeCarGps.hasLongitude()) {
          setLongitude(paramCarlifeCarGps.getLongitude());
        }
        if (paramCarlifeCarGps.hasHeight()) {
          setHeight(paramCarlifeCarGps.getHeight());
        }
        if (paramCarlifeCarGps.hasSpeed()) {
          setSpeed(paramCarlifeCarGps.getSpeed());
        }
        if (paramCarlifeCarGps.hasHeading()) {
          setHeading(paramCarlifeCarGps.getHeading());
        }
        if (paramCarlifeCarGps.hasYear()) {
          setYear(paramCarlifeCarGps.getYear());
        }
        if (paramCarlifeCarGps.hasMonth()) {
          setMonth(paramCarlifeCarGps.getMonth());
        }
        if (paramCarlifeCarGps.hasDay()) {
          setDay(paramCarlifeCarGps.getDay());
        }
        if (paramCarlifeCarGps.hasHrs()) {
          setHrs(paramCarlifeCarGps.getHrs());
        }
        if (paramCarlifeCarGps.hasMin()) {
          setMin(paramCarlifeCarGps.getMin());
        }
        if (paramCarlifeCarGps.hasSec()) {
          setSec(paramCarlifeCarGps.getSec());
        }
        if (paramCarlifeCarGps.hasFix()) {
          setFix(paramCarlifeCarGps.getFix());
        }
        if (paramCarlifeCarGps.hasHdop()) {
          setHdop(paramCarlifeCarGps.getHdop());
        }
        if (paramCarlifeCarGps.hasPdop()) {
          setPdop(paramCarlifeCarGps.getPdop());
        }
        if (paramCarlifeCarGps.hasVdop()) {
          setVdop(paramCarlifeCarGps.getVdop());
        }
        if (paramCarlifeCarGps.hasSatsUsed()) {
          setSatsUsed(paramCarlifeCarGps.getSatsUsed());
        }
        if (paramCarlifeCarGps.hasSatsVisible()) {
          setSatsVisible(paramCarlifeCarGps.getSatsVisible());
        }
        if (paramCarlifeCarGps.hasHorPosError()) {
          setHorPosError(paramCarlifeCarGps.getHorPosError());
        }
        if (paramCarlifeCarGps.hasVertPosError()) {
          setVertPosError(paramCarlifeCarGps.getVertPosError());
        }
        if (paramCarlifeCarGps.hasNorthSpeed()) {
          setNorthSpeed(paramCarlifeCarGps.getNorthSpeed());
        }
        if (paramCarlifeCarGps.hasEastSpeed()) {
          setEastSpeed(paramCarlifeCarGps.getEastSpeed());
        }
        if (paramCarlifeCarGps.hasVertSpeed()) {
          setVertSpeed(paramCarlifeCarGps.getVertSpeed());
        }
        if (paramCarlifeCarGps.hasTimeStamp()) {
          setTimeStamp(paramCarlifeCarGps.getTimeStamp());
        }
        mergeUnknownFields(paramCarlifeCarGps.getUnknownFields());
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
            setAntennaState(paramCodedInputStream.readUInt32());
            break;
          case 16: 
            setSignalQuality(paramCodedInputStream.readUInt32());
            break;
          case 24: 
            setLatitude(paramCodedInputStream.readInt32());
            break;
          case 32: 
            setLongitude(paramCodedInputStream.readInt32());
            break;
          case 40: 
            setHeight(paramCodedInputStream.readInt32());
            break;
          case 48: 
            setSpeed(paramCodedInputStream.readUInt32());
            break;
          case 56: 
            setHeading(paramCodedInputStream.readUInt32());
            break;
          case 64: 
            setYear(paramCodedInputStream.readUInt32());
            break;
          case 72: 
            setMonth(paramCodedInputStream.readUInt32());
            break;
          case 80: 
            setDay(paramCodedInputStream.readUInt32());
            break;
          case 88: 
            setHrs(paramCodedInputStream.readUInt32());
            break;
          case 96: 
            setMin(paramCodedInputStream.readUInt32());
            break;
          case 104: 
            setSec(paramCodedInputStream.readUInt32());
            break;
          case 112: 
            setFix(paramCodedInputStream.readUInt32());
            break;
          case 120: 
            setHdop(paramCodedInputStream.readUInt32());
            break;
          case 128: 
            setPdop(paramCodedInputStream.readUInt32());
            break;
          case 136: 
            setVdop(paramCodedInputStream.readUInt32());
            break;
          case 144: 
            setSatsUsed(paramCodedInputStream.readUInt32());
            break;
          case 152: 
            setSatsVisible(paramCodedInputStream.readUInt32());
            break;
          case 160: 
            setHorPosError(paramCodedInputStream.readUInt32());
            break;
          case 168: 
            setVertPosError(paramCodedInputStream.readUInt32());
            break;
          case 176: 
            setNorthSpeed(paramCodedInputStream.readInt32());
            break;
          case 184: 
            setEastSpeed(paramCodedInputStream.readInt32());
            break;
          case 192: 
            setVertSpeed(paramCodedInputStream.readInt32());
            break;
          case 200: 
            setTimeStamp(paramCodedInputStream.readUInt64());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeCarGpsProto.CarlifeCarGps)) {
          return mergeFrom((CarlifeCarGpsProto.CarlifeCarGps)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAntennaState(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$502(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setDay(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2302(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$2402(this.result, paramInt);
        return this;
      }
      
      public Builder setEastSpeed(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4902(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$5002(this.result, paramInt);
        return this;
      }
      
      public Builder setFix(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3102(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$3202(this.result, paramInt);
        return this;
      }
      
      public Builder setHdop(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3302(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$3402(this.result, paramInt);
        return this;
      }
      
      public Builder setHeading(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1702(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$1802(this.result, paramInt);
        return this;
      }
      
      public Builder setHeight(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1302(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$1402(this.result, paramInt);
        return this;
      }
      
      public Builder setHorPosError(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4302(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$4402(this.result, paramInt);
        return this;
      }
      
      public Builder setHrs(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2502(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$2602(this.result, paramInt);
        return this;
      }
      
      public Builder setLatitude(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$902(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setLongitude(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1102(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$1202(this.result, paramInt);
        return this;
      }
      
      public Builder setMin(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2702(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$2802(this.result, paramInt);
        return this;
      }
      
      public Builder setMonth(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2102(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$2202(this.result, paramInt);
        return this;
      }
      
      public Builder setNorthSpeed(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4702(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$4802(this.result, paramInt);
        return this;
      }
      
      public Builder setPdop(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3502(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$3602(this.result, paramInt);
        return this;
      }
      
      public Builder setSatsUsed(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3902(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$4002(this.result, paramInt);
        return this;
      }
      
      public Builder setSatsVisible(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4102(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$4202(this.result, paramInt);
        return this;
      }
      
      public Builder setSec(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$2902(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$3002(this.result, paramInt);
        return this;
      }
      
      public Builder setSignalQuality(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$702(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setSpeed(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1502(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$1602(this.result, paramInt);
        return this;
      }
      
      public Builder setTimeStamp(long paramLong)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$5302(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$5402(this.result, paramLong);
        return this;
      }
      
      public Builder setVdop(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$3702(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$3802(this.result, paramInt);
        return this;
      }
      
      public Builder setVertPosError(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$4502(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$4602(this.result, paramInt);
        return this;
      }
      
      public Builder setVertSpeed(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$5102(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$5202(this.result, paramInt);
        return this;
      }
      
      public Builder setYear(int paramInt)
      {
        CarlifeCarGpsProto.CarlifeCarGps.access$1902(this.result, true);
        CarlifeCarGpsProto.CarlifeCarGps.access$2002(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeCarGpsProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */