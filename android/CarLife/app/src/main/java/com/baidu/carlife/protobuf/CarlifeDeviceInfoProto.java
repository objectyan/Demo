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

public final class CarlifeDeviceInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeDeviceInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeDeviceInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeDeviceInfoProto.access$5302(paramAnonymousFileDescriptor);
        CarlifeDeviceInfoProto.access$002((Descriptors.Descriptor)CarlifeDeviceInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeDeviceInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeDeviceInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeDeviceInfo_descriptor, new String[] { "Os", "Board", "Bootloader", "Brand", "CpuAbi", "CpuAbi2", "Device", "Display", "Fingerprint", "Hardware", "Host", "Cid", "Manufacturer", "Model", "Product", "Serial", "Codename", "Incremental", "Release", "Sdk", "SdkInt", "Token", "Btaddress", "Carlifeversion" }, CarlifeDeviceInfoProto.CarlifeDeviceInfo.class, CarlifeDeviceInfoProto.CarlifeDeviceInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\034CarlifeDeviceInfoProto.proto\022\032com.baidu.carlife.protobuf\"­\003\n\021CarlifeDeviceInfo\022\n\n\002os\030\001 \001(\t\022\r\n\005board\030\002 \001(\t\022\022\n\nbootloader\030\003 \001(\t\022\r\n\005brand\030\004 \001(\t\022\017\n\007cpu_abi\030\005 \001(\t\022\020\n\bcpu_abi2\030\006 \001(\t\022\016\n\006device\030\007 \001(\t\022\017\n\007display\030\b \001(\t\022\023\n\013fingerprint\030\t \001(\t\022\020\n\bhardware\030\n \001(\t\022\f\n\004host\030\013 \001(\t\022\013\n\003cid\030\f \001(\t\022\024\n\fmanufacturer\030\r \001(\t\022\r\n\005model\030\016 \001(\t\022\017\n\007product\030\017 \001(\t\022\016\n\006serial\030\020 \001(\t\022\020\n\bcodename\030\021 \001(\t\022\023\n\013incremental\030\022 \001(\t\022\017\n\007release\030\023 \001", "(\t\022\013\n\003sdk\030\024 \001(\t\022\017\n\007sdk_int\030\025 \001(\005\022\r\n\005token\030\026 \001(\t\022\021\n\tbtaddress\030\027 \001(\t\022\026\n\016carlifeversion\030\030 \001(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeDeviceInfo
    extends GeneratedMessage
  {
    public static final int BOARD_FIELD_NUMBER = 2;
    public static final int BOOTLOADER_FIELD_NUMBER = 3;
    public static final int BRAND_FIELD_NUMBER = 4;
    public static final int BTADDRESS_FIELD_NUMBER = 23;
    public static final int CARLIFEVERSION_FIELD_NUMBER = 24;
    public static final int CID_FIELD_NUMBER = 12;
    public static final int CODENAME_FIELD_NUMBER = 17;
    public static final int CPU_ABI2_FIELD_NUMBER = 6;
    public static final int CPU_ABI_FIELD_NUMBER = 5;
    public static final int DEVICE_FIELD_NUMBER = 7;
    public static final int DISPLAY_FIELD_NUMBER = 8;
    public static final int FINGERPRINT_FIELD_NUMBER = 9;
    public static final int HARDWARE_FIELD_NUMBER = 10;
    public static final int HOST_FIELD_NUMBER = 11;
    public static final int INCREMENTAL_FIELD_NUMBER = 18;
    public static final int MANUFACTURER_FIELD_NUMBER = 13;
    public static final int MODEL_FIELD_NUMBER = 14;
    public static final int OS_FIELD_NUMBER = 1;
    public static final int PRODUCT_FIELD_NUMBER = 15;
    public static final int RELEASE_FIELD_NUMBER = 19;
    public static final int SDK_FIELD_NUMBER = 20;
    public static final int SDK_INT_FIELD_NUMBER = 21;
    public static final int SERIAL_FIELD_NUMBER = 16;
    public static final int TOKEN_FIELD_NUMBER = 22;
    private static final CarlifeDeviceInfo defaultInstance = new CarlifeDeviceInfo();
    private String board_ = "";
    private String bootloader_ = "";
    private String brand_ = "";
    private String btaddress_ = "";
    private String carlifeversion_ = "";
    private String cid_ = "";
    private String codename_ = "";
    private String cpuAbi2_ = "";
    private String cpuAbi_ = "";
    private String device_ = "";
    private String display_ = "";
    private String fingerprint_ = "";
    private String hardware_ = "";
    private boolean hasBoard;
    private boolean hasBootloader;
    private boolean hasBrand;
    private boolean hasBtaddress;
    private boolean hasCarlifeversion;
    private boolean hasCid;
    private boolean hasCodename;
    private boolean hasCpuAbi;
    private boolean hasCpuAbi2;
    private boolean hasDevice;
    private boolean hasDisplay;
    private boolean hasFingerprint;
    private boolean hasHardware;
    private boolean hasHost;
    private boolean hasIncremental;
    private boolean hasManufacturer;
    private boolean hasModel;
    private boolean hasOs;
    private boolean hasProduct;
    private boolean hasRelease;
    private boolean hasSdk;
    private boolean hasSdkInt;
    private boolean hasSerial;
    private boolean hasToken;
    private String host_ = "";
    private String incremental_ = "";
    private String manufacturer_ = "";
    private int memoizedSerializedSize = -1;
    private String model_ = "";
    private String os_ = "";
    private String product_ = "";
    private String release_ = "";
    private int sdkInt_ = 0;
    private String sdk_ = "";
    private String serial_ = "";
    private String token_ = "";
    
    static
    {
      CarlifeDeviceInfoProto.getDescriptor();
      CarlifeDeviceInfoProto.internalForceInit();
    }
    
    public static CarlifeDeviceInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeDeviceInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeDeviceInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeDeviceInfo paramCarlifeDeviceInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeDeviceInfo);
    }
    
    public static CarlifeDeviceInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeDeviceInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getBoard()
    {
      return this.board_;
    }
    
    public String getBootloader()
    {
      return this.bootloader_;
    }
    
    public String getBrand()
    {
      return this.brand_;
    }
    
    public String getBtaddress()
    {
      return this.btaddress_;
    }
    
    public String getCarlifeversion()
    {
      return this.carlifeversion_;
    }
    
    public String getCid()
    {
      return this.cid_;
    }
    
    public String getCodename()
    {
      return this.codename_;
    }
    
    public String getCpuAbi()
    {
      return this.cpuAbi_;
    }
    
    public String getCpuAbi2()
    {
      return this.cpuAbi2_;
    }
    
    public CarlifeDeviceInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getDevice()
    {
      return this.device_;
    }
    
    public String getDisplay()
    {
      return this.display_;
    }
    
    public String getFingerprint()
    {
      return this.fingerprint_;
    }
    
    public String getHardware()
    {
      return this.hardware_;
    }
    
    public String getHost()
    {
      return this.host_;
    }
    
    public String getIncremental()
    {
      return this.incremental_;
    }
    
    public String getManufacturer()
    {
      return this.manufacturer_;
    }
    
    public String getModel()
    {
      return this.model_;
    }
    
    public String getOs()
    {
      return this.os_;
    }
    
    public String getProduct()
    {
      return this.product_;
    }
    
    public String getRelease()
    {
      return this.release_;
    }
    
    public String getSdk()
    {
      return this.sdk_;
    }
    
    public int getSdkInt()
    {
      return this.sdkInt_;
    }
    
    public String getSerial()
    {
      return this.serial_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasOs()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getOs());
      }
      i = j;
      if (hasBoard()) {
        i = j + CodedOutputStream.computeStringSize(2, getBoard());
      }
      j = i;
      if (hasBootloader()) {
        j = i + CodedOutputStream.computeStringSize(3, getBootloader());
      }
      i = j;
      if (hasBrand()) {
        i = j + CodedOutputStream.computeStringSize(4, getBrand());
      }
      j = i;
      if (hasCpuAbi()) {
        j = i + CodedOutputStream.computeStringSize(5, getCpuAbi());
      }
      i = j;
      if (hasCpuAbi2()) {
        i = j + CodedOutputStream.computeStringSize(6, getCpuAbi2());
      }
      j = i;
      if (hasDevice()) {
        j = i + CodedOutputStream.computeStringSize(7, getDevice());
      }
      i = j;
      if (hasDisplay()) {
        i = j + CodedOutputStream.computeStringSize(8, getDisplay());
      }
      j = i;
      if (hasFingerprint()) {
        j = i + CodedOutputStream.computeStringSize(9, getFingerprint());
      }
      i = j;
      if (hasHardware()) {
        i = j + CodedOutputStream.computeStringSize(10, getHardware());
      }
      j = i;
      if (hasHost()) {
        j = i + CodedOutputStream.computeStringSize(11, getHost());
      }
      i = j;
      if (hasCid()) {
        i = j + CodedOutputStream.computeStringSize(12, getCid());
      }
      j = i;
      if (hasManufacturer()) {
        j = i + CodedOutputStream.computeStringSize(13, getManufacturer());
      }
      i = j;
      if (hasModel()) {
        i = j + CodedOutputStream.computeStringSize(14, getModel());
      }
      j = i;
      if (hasProduct()) {
        j = i + CodedOutputStream.computeStringSize(15, getProduct());
      }
      i = j;
      if (hasSerial()) {
        i = j + CodedOutputStream.computeStringSize(16, getSerial());
      }
      j = i;
      if (hasCodename()) {
        j = i + CodedOutputStream.computeStringSize(17, getCodename());
      }
      i = j;
      if (hasIncremental()) {
        i = j + CodedOutputStream.computeStringSize(18, getIncremental());
      }
      j = i;
      if (hasRelease()) {
        j = i + CodedOutputStream.computeStringSize(19, getRelease());
      }
      i = j;
      if (hasSdk()) {
        i = j + CodedOutputStream.computeStringSize(20, getSdk());
      }
      j = i;
      if (hasSdkInt()) {
        j = i + CodedOutputStream.computeInt32Size(21, getSdkInt());
      }
      i = j;
      if (hasToken()) {
        i = j + CodedOutputStream.computeStringSize(22, getToken());
      }
      j = i;
      if (hasBtaddress()) {
        j = i + CodedOutputStream.computeStringSize(23, getBtaddress());
      }
      i = j;
      if (hasCarlifeversion()) {
        i = j + CodedOutputStream.computeStringSize(24, getCarlifeversion());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getToken()
    {
      return this.token_;
    }
    
    public boolean hasBoard()
    {
      return this.hasBoard;
    }
    
    public boolean hasBootloader()
    {
      return this.hasBootloader;
    }
    
    public boolean hasBrand()
    {
      return this.hasBrand;
    }
    
    public boolean hasBtaddress()
    {
      return this.hasBtaddress;
    }
    
    public boolean hasCarlifeversion()
    {
      return this.hasCarlifeversion;
    }
    
    public boolean hasCid()
    {
      return this.hasCid;
    }
    
    public boolean hasCodename()
    {
      return this.hasCodename;
    }
    
    public boolean hasCpuAbi()
    {
      return this.hasCpuAbi;
    }
    
    public boolean hasCpuAbi2()
    {
      return this.hasCpuAbi2;
    }
    
    public boolean hasDevice()
    {
      return this.hasDevice;
    }
    
    public boolean hasDisplay()
    {
      return this.hasDisplay;
    }
    
    public boolean hasFingerprint()
    {
      return this.hasFingerprint;
    }
    
    public boolean hasHardware()
    {
      return this.hasHardware;
    }
    
    public boolean hasHost()
    {
      return this.hasHost;
    }
    
    public boolean hasIncremental()
    {
      return this.hasIncremental;
    }
    
    public boolean hasManufacturer()
    {
      return this.hasManufacturer;
    }
    
    public boolean hasModel()
    {
      return this.hasModel;
    }
    
    public boolean hasOs()
    {
      return this.hasOs;
    }
    
    public boolean hasProduct()
    {
      return this.hasProduct;
    }
    
    public boolean hasRelease()
    {
      return this.hasRelease;
    }
    
    public boolean hasSdk()
    {
      return this.hasSdk;
    }
    
    public boolean hasSdkInt()
    {
      return this.hasSdkInt;
    }
    
    public boolean hasSerial()
    {
      return this.hasSerial;
    }
    
    public boolean hasToken()
    {
      return this.hasToken;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeDeviceInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeDeviceInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
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
      if (hasOs()) {
        paramCodedOutputStream.writeString(1, getOs());
      }
      if (hasBoard()) {
        paramCodedOutputStream.writeString(2, getBoard());
      }
      if (hasBootloader()) {
        paramCodedOutputStream.writeString(3, getBootloader());
      }
      if (hasBrand()) {
        paramCodedOutputStream.writeString(4, getBrand());
      }
      if (hasCpuAbi()) {
        paramCodedOutputStream.writeString(5, getCpuAbi());
      }
      if (hasCpuAbi2()) {
        paramCodedOutputStream.writeString(6, getCpuAbi2());
      }
      if (hasDevice()) {
        paramCodedOutputStream.writeString(7, getDevice());
      }
      if (hasDisplay()) {
        paramCodedOutputStream.writeString(8, getDisplay());
      }
      if (hasFingerprint()) {
        paramCodedOutputStream.writeString(9, getFingerprint());
      }
      if (hasHardware()) {
        paramCodedOutputStream.writeString(10, getHardware());
      }
      if (hasHost()) {
        paramCodedOutputStream.writeString(11, getHost());
      }
      if (hasCid()) {
        paramCodedOutputStream.writeString(12, getCid());
      }
      if (hasManufacturer()) {
        paramCodedOutputStream.writeString(13, getManufacturer());
      }
      if (hasModel()) {
        paramCodedOutputStream.writeString(14, getModel());
      }
      if (hasProduct()) {
        paramCodedOutputStream.writeString(15, getProduct());
      }
      if (hasSerial()) {
        paramCodedOutputStream.writeString(16, getSerial());
      }
      if (hasCodename()) {
        paramCodedOutputStream.writeString(17, getCodename());
      }
      if (hasIncremental()) {
        paramCodedOutputStream.writeString(18, getIncremental());
      }
      if (hasRelease()) {
        paramCodedOutputStream.writeString(19, getRelease());
      }
      if (hasSdk()) {
        paramCodedOutputStream.writeString(20, getSdk());
      }
      if (hasSdkInt()) {
        paramCodedOutputStream.writeInt32(21, getSdkInt());
      }
      if (hasToken()) {
        paramCodedOutputStream.writeString(22, getToken());
      }
      if (hasBtaddress()) {
        paramCodedOutputStream.writeString(23, getBtaddress());
      }
      if (hasCarlifeversion()) {
        paramCodedOutputStream.writeString(24, getCarlifeversion());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeDeviceInfoProto.CarlifeDeviceInfo result;
      
      private CarlifeDeviceInfoProto.CarlifeDeviceInfo buildParsed()
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
        localBuilder.result = new CarlifeDeviceInfoProto.CarlifeDeviceInfo(null);
        return localBuilder;
      }
      
      public CarlifeDeviceInfoProto.CarlifeDeviceInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeDeviceInfoProto.CarlifeDeviceInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo localCarlifeDeviceInfo = this.result;
        this.result = null;
        return localCarlifeDeviceInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeDeviceInfoProto.CarlifeDeviceInfo(null);
        return this;
      }
      
      public Builder clearBoard()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$702(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$802(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getBoard());
        return this;
      }
      
      public Builder clearBootloader()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$902(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1002(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getBootloader());
        return this;
      }
      
      public Builder clearBrand()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1102(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1202(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getBrand());
        return this;
      }
      
      public Builder clearBtaddress()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4902(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$5002(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getBtaddress());
        return this;
      }
      
      public Builder clearCarlifeversion()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$5102(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$5202(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getCarlifeversion());
        return this;
      }
      
      public Builder clearCid()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2702(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2802(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getCid());
        return this;
      }
      
      public Builder clearCodename()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3702(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3802(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getCodename());
        return this;
      }
      
      public Builder clearCpuAbi()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1302(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1402(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getCpuAbi());
        return this;
      }
      
      public Builder clearCpuAbi2()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1502(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1602(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getCpuAbi2());
        return this;
      }
      
      public Builder clearDevice()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1702(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1802(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getDevice());
        return this;
      }
      
      public Builder clearDisplay()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1902(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2002(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getDisplay());
        return this;
      }
      
      public Builder clearFingerprint()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2102(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2202(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getFingerprint());
        return this;
      }
      
      public Builder clearHardware()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2302(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2402(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getHardware());
        return this;
      }
      
      public Builder clearHost()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2502(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2602(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getHost());
        return this;
      }
      
      public Builder clearIncremental()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3902(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4002(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getIncremental());
        return this;
      }
      
      public Builder clearManufacturer()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2902(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3002(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getManufacturer());
        return this;
      }
      
      public Builder clearModel()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3102(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3202(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getModel());
        return this;
      }
      
      public Builder clearOs()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$502(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$602(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getOs());
        return this;
      }
      
      public Builder clearProduct()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3302(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3402(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getProduct());
        return this;
      }
      
      public Builder clearRelease()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4102(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4202(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getRelease());
        return this;
      }
      
      public Builder clearSdk()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4302(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4402(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getSdk());
        return this;
      }
      
      public Builder clearSdkInt()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4502(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4602(this.result, 0);
        return this;
      }
      
      public Builder clearSerial()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3502(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3602(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getSerial());
        return this;
      }
      
      public Builder clearToken()
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4702(this.result, false);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4802(this.result, CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance().getToken());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public String getBoard()
      {
        return this.result.getBoard();
      }
      
      public String getBootloader()
      {
        return this.result.getBootloader();
      }
      
      public String getBrand()
      {
        return this.result.getBrand();
      }
      
      public String getBtaddress()
      {
        return this.result.getBtaddress();
      }
      
      public String getCarlifeversion()
      {
        return this.result.getCarlifeversion();
      }
      
      public String getCid()
      {
        return this.result.getCid();
      }
      
      public String getCodename()
      {
        return this.result.getCodename();
      }
      
      public String getCpuAbi()
      {
        return this.result.getCpuAbi();
      }
      
      public String getCpuAbi2()
      {
        return this.result.getCpuAbi2();
      }
      
      public CarlifeDeviceInfoProto.CarlifeDeviceInfo getDefaultInstanceForType()
      {
        return CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDescriptor();
      }
      
      public String getDevice()
      {
        return this.result.getDevice();
      }
      
      public String getDisplay()
      {
        return this.result.getDisplay();
      }
      
      public String getFingerprint()
      {
        return this.result.getFingerprint();
      }
      
      public String getHardware()
      {
        return this.result.getHardware();
      }
      
      public String getHost()
      {
        return this.result.getHost();
      }
      
      public String getIncremental()
      {
        return this.result.getIncremental();
      }
      
      public String getManufacturer()
      {
        return this.result.getManufacturer();
      }
      
      public String getModel()
      {
        return this.result.getModel();
      }
      
      public String getOs()
      {
        return this.result.getOs();
      }
      
      public String getProduct()
      {
        return this.result.getProduct();
      }
      
      public String getRelease()
      {
        return this.result.getRelease();
      }
      
      public String getSdk()
      {
        return this.result.getSdk();
      }
      
      public int getSdkInt()
      {
        return this.result.getSdkInt();
      }
      
      public String getSerial()
      {
        return this.result.getSerial();
      }
      
      public String getToken()
      {
        return this.result.getToken();
      }
      
      public boolean hasBoard()
      {
        return this.result.hasBoard();
      }
      
      public boolean hasBootloader()
      {
        return this.result.hasBootloader();
      }
      
      public boolean hasBrand()
      {
        return this.result.hasBrand();
      }
      
      public boolean hasBtaddress()
      {
        return this.result.hasBtaddress();
      }
      
      public boolean hasCarlifeversion()
      {
        return this.result.hasCarlifeversion();
      }
      
      public boolean hasCid()
      {
        return this.result.hasCid();
      }
      
      public boolean hasCodename()
      {
        return this.result.hasCodename();
      }
      
      public boolean hasCpuAbi()
      {
        return this.result.hasCpuAbi();
      }
      
      public boolean hasCpuAbi2()
      {
        return this.result.hasCpuAbi2();
      }
      
      public boolean hasDevice()
      {
        return this.result.hasDevice();
      }
      
      public boolean hasDisplay()
      {
        return this.result.hasDisplay();
      }
      
      public boolean hasFingerprint()
      {
        return this.result.hasFingerprint();
      }
      
      public boolean hasHardware()
      {
        return this.result.hasHardware();
      }
      
      public boolean hasHost()
      {
        return this.result.hasHost();
      }
      
      public boolean hasIncremental()
      {
        return this.result.hasIncremental();
      }
      
      public boolean hasManufacturer()
      {
        return this.result.hasManufacturer();
      }
      
      public boolean hasModel()
      {
        return this.result.hasModel();
      }
      
      public boolean hasOs()
      {
        return this.result.hasOs();
      }
      
      public boolean hasProduct()
      {
        return this.result.hasProduct();
      }
      
      public boolean hasRelease()
      {
        return this.result.hasRelease();
      }
      
      public boolean hasSdk()
      {
        return this.result.hasSdk();
      }
      
      public boolean hasSdkInt()
      {
        return this.result.hasSdkInt();
      }
      
      public boolean hasSerial()
      {
        return this.result.hasSerial();
      }
      
      public boolean hasToken()
      {
        return this.result.hasToken();
      }
      
      protected CarlifeDeviceInfoProto.CarlifeDeviceInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeDeviceInfoProto.CarlifeDeviceInfo paramCarlifeDeviceInfo)
      {
        if (paramCarlifeDeviceInfo == CarlifeDeviceInfoProto.CarlifeDeviceInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeDeviceInfo.hasOs()) {
          setOs(paramCarlifeDeviceInfo.getOs());
        }
        if (paramCarlifeDeviceInfo.hasBoard()) {
          setBoard(paramCarlifeDeviceInfo.getBoard());
        }
        if (paramCarlifeDeviceInfo.hasBootloader()) {
          setBootloader(paramCarlifeDeviceInfo.getBootloader());
        }
        if (paramCarlifeDeviceInfo.hasBrand()) {
          setBrand(paramCarlifeDeviceInfo.getBrand());
        }
        if (paramCarlifeDeviceInfo.hasCpuAbi()) {
          setCpuAbi(paramCarlifeDeviceInfo.getCpuAbi());
        }
        if (paramCarlifeDeviceInfo.hasCpuAbi2()) {
          setCpuAbi2(paramCarlifeDeviceInfo.getCpuAbi2());
        }
        if (paramCarlifeDeviceInfo.hasDevice()) {
          setDevice(paramCarlifeDeviceInfo.getDevice());
        }
        if (paramCarlifeDeviceInfo.hasDisplay()) {
          setDisplay(paramCarlifeDeviceInfo.getDisplay());
        }
        if (paramCarlifeDeviceInfo.hasFingerprint()) {
          setFingerprint(paramCarlifeDeviceInfo.getFingerprint());
        }
        if (paramCarlifeDeviceInfo.hasHardware()) {
          setHardware(paramCarlifeDeviceInfo.getHardware());
        }
        if (paramCarlifeDeviceInfo.hasHost()) {
          setHost(paramCarlifeDeviceInfo.getHost());
        }
        if (paramCarlifeDeviceInfo.hasCid()) {
          setCid(paramCarlifeDeviceInfo.getCid());
        }
        if (paramCarlifeDeviceInfo.hasManufacturer()) {
          setManufacturer(paramCarlifeDeviceInfo.getManufacturer());
        }
        if (paramCarlifeDeviceInfo.hasModel()) {
          setModel(paramCarlifeDeviceInfo.getModel());
        }
        if (paramCarlifeDeviceInfo.hasProduct()) {
          setProduct(paramCarlifeDeviceInfo.getProduct());
        }
        if (paramCarlifeDeviceInfo.hasSerial()) {
          setSerial(paramCarlifeDeviceInfo.getSerial());
        }
        if (paramCarlifeDeviceInfo.hasCodename()) {
          setCodename(paramCarlifeDeviceInfo.getCodename());
        }
        if (paramCarlifeDeviceInfo.hasIncremental()) {
          setIncremental(paramCarlifeDeviceInfo.getIncremental());
        }
        if (paramCarlifeDeviceInfo.hasRelease()) {
          setRelease(paramCarlifeDeviceInfo.getRelease());
        }
        if (paramCarlifeDeviceInfo.hasSdk()) {
          setSdk(paramCarlifeDeviceInfo.getSdk());
        }
        if (paramCarlifeDeviceInfo.hasSdkInt()) {
          setSdkInt(paramCarlifeDeviceInfo.getSdkInt());
        }
        if (paramCarlifeDeviceInfo.hasToken()) {
          setToken(paramCarlifeDeviceInfo.getToken());
        }
        if (paramCarlifeDeviceInfo.hasBtaddress()) {
          setBtaddress(paramCarlifeDeviceInfo.getBtaddress());
        }
        if (paramCarlifeDeviceInfo.hasCarlifeversion()) {
          setCarlifeversion(paramCarlifeDeviceInfo.getCarlifeversion());
        }
        mergeUnknownFields(paramCarlifeDeviceInfo.getUnknownFields());
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
            setOs(paramCodedInputStream.readString());
            break;
          case 18: 
            setBoard(paramCodedInputStream.readString());
            break;
          case 26: 
            setBootloader(paramCodedInputStream.readString());
            break;
          case 34: 
            setBrand(paramCodedInputStream.readString());
            break;
          case 42: 
            setCpuAbi(paramCodedInputStream.readString());
            break;
          case 50: 
            setCpuAbi2(paramCodedInputStream.readString());
            break;
          case 58: 
            setDevice(paramCodedInputStream.readString());
            break;
          case 66: 
            setDisplay(paramCodedInputStream.readString());
            break;
          case 74: 
            setFingerprint(paramCodedInputStream.readString());
            break;
          case 82: 
            setHardware(paramCodedInputStream.readString());
            break;
          case 90: 
            setHost(paramCodedInputStream.readString());
            break;
          case 98: 
            setCid(paramCodedInputStream.readString());
            break;
          case 106: 
            setManufacturer(paramCodedInputStream.readString());
            break;
          case 114: 
            setModel(paramCodedInputStream.readString());
            break;
          case 122: 
            setProduct(paramCodedInputStream.readString());
            break;
          case 130: 
            setSerial(paramCodedInputStream.readString());
            break;
          case 138: 
            setCodename(paramCodedInputStream.readString());
            break;
          case 146: 
            setIncremental(paramCodedInputStream.readString());
            break;
          case 154: 
            setRelease(paramCodedInputStream.readString());
            break;
          case 162: 
            setSdk(paramCodedInputStream.readString());
            break;
          case 168: 
            setSdkInt(paramCodedInputStream.readInt32());
            break;
          case 178: 
            setToken(paramCodedInputStream.readString());
            break;
          case 186: 
            setBtaddress(paramCodedInputStream.readString());
            break;
          case 194: 
            setCarlifeversion(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeDeviceInfoProto.CarlifeDeviceInfo)) {
          return mergeFrom((CarlifeDeviceInfoProto.CarlifeDeviceInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setBoard(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$702(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$802(this.result, paramString);
        return this;
      }
      
      public Builder setBootloader(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$902(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1002(this.result, paramString);
        return this;
      }
      
      public Builder setBrand(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1102(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1202(this.result, paramString);
        return this;
      }
      
      public Builder setBtaddress(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4902(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$5002(this.result, paramString);
        return this;
      }
      
      public Builder setCarlifeversion(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$5102(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$5202(this.result, paramString);
        return this;
      }
      
      public Builder setCid(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2702(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2802(this.result, paramString);
        return this;
      }
      
      public Builder setCodename(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3702(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3802(this.result, paramString);
        return this;
      }
      
      public Builder setCpuAbi(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1302(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1402(this.result, paramString);
        return this;
      }
      
      public Builder setCpuAbi2(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1502(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1602(this.result, paramString);
        return this;
      }
      
      public Builder setDevice(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1702(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1802(this.result, paramString);
        return this;
      }
      
      public Builder setDisplay(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$1902(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2002(this.result, paramString);
        return this;
      }
      
      public Builder setFingerprint(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2102(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2202(this.result, paramString);
        return this;
      }
      
      public Builder setHardware(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2302(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2402(this.result, paramString);
        return this;
      }
      
      public Builder setHost(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2502(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2602(this.result, paramString);
        return this;
      }
      
      public Builder setIncremental(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3902(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4002(this.result, paramString);
        return this;
      }
      
      public Builder setManufacturer(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$2902(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3002(this.result, paramString);
        return this;
      }
      
      public Builder setModel(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3102(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3202(this.result, paramString);
        return this;
      }
      
      public Builder setOs(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$502(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$602(this.result, paramString);
        return this;
      }
      
      public Builder setProduct(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3302(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3402(this.result, paramString);
        return this;
      }
      
      public Builder setRelease(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4102(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4202(this.result, paramString);
        return this;
      }
      
      public Builder setSdk(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4302(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4402(this.result, paramString);
        return this;
      }
      
      public Builder setSdkInt(int paramInt)
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4502(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4602(this.result, paramInt);
        return this;
      }
      
      public Builder setSerial(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3502(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$3602(this.result, paramString);
        return this;
      }
      
      public Builder setToken(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4702(this.result, true);
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.access$4802(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeDeviceInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */