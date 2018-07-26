package com.baidu.carlife.protobuf;

import com.baidu.carlife.core.C1253f;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class CarlifeDeviceInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeDeviceInfo_descriptor */
    private static Descriptor f6613xcc463fae;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeDeviceInfo_fieldAccessorTable */
    private static FieldAccessorTable f6614xe789d82c;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeDeviceInfoProto$1 */
    static class C20601 implements InternalDescriptorAssigner {
        C20601() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeDeviceInfoProto.descriptor = root;
            CarlifeDeviceInfoProto.f6613xcc463fae = (Descriptor) CarlifeDeviceInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeDeviceInfoProto.f6614xe789d82c = new FieldAccessorTable(CarlifeDeviceInfoProto.f6613xcc463fae, new String[]{"Os", "Board", "Bootloader", "Brand", "CpuAbi", "CpuAbi2", "Device", "Display", "Fingerprint", "Hardware", "Host", "Cid", "Manufacturer", "Model", "Product", "Serial", "Codename", "Incremental", "Release", "Sdk", "SdkInt", "Token", "Btaddress", "Carlifeversion"}, CarlifeDeviceInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeDeviceInfo extends GeneratedMessage {
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
        private String board_;
        private String bootloader_;
        private String brand_;
        private String btaddress_;
        private String carlifeversion_;
        private String cid_;
        private String codename_;
        private String cpuAbi2_;
        private String cpuAbi_;
        private String device_;
        private String display_;
        private String fingerprint_;
        private String hardware_;
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
        private String host_;
        private String incremental_;
        private String manufacturer_;
        private int memoizedSerializedSize;
        private String model_;
        private String os_;
        private String product_;
        private String release_;
        private int sdkInt_;
        private String sdk_;
        private String serial_;
        private String token_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeDeviceInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeDeviceInfo();
                return builder;
            }

            protected CarlifeDeviceInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeDeviceInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeDeviceInfo.getDescriptor();
            }

            public CarlifeDeviceInfo getDefaultInstanceForType() {
                return CarlifeDeviceInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeDeviceInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeDeviceInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeDeviceInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeDeviceInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeDeviceInfo) {
                    return mergeFrom((CarlifeDeviceInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeDeviceInfo other) {
                if (other != CarlifeDeviceInfo.getDefaultInstance()) {
                    if (other.hasOs()) {
                        setOs(other.getOs());
                    }
                    if (other.hasBoard()) {
                        setBoard(other.getBoard());
                    }
                    if (other.hasBootloader()) {
                        setBootloader(other.getBootloader());
                    }
                    if (other.hasBrand()) {
                        setBrand(other.getBrand());
                    }
                    if (other.hasCpuAbi()) {
                        setCpuAbi(other.getCpuAbi());
                    }
                    if (other.hasCpuAbi2()) {
                        setCpuAbi2(other.getCpuAbi2());
                    }
                    if (other.hasDevice()) {
                        setDevice(other.getDevice());
                    }
                    if (other.hasDisplay()) {
                        setDisplay(other.getDisplay());
                    }
                    if (other.hasFingerprint()) {
                        setFingerprint(other.getFingerprint());
                    }
                    if (other.hasHardware()) {
                        setHardware(other.getHardware());
                    }
                    if (other.hasHost()) {
                        setHost(other.getHost());
                    }
                    if (other.hasCid()) {
                        setCid(other.getCid());
                    }
                    if (other.hasManufacturer()) {
                        setManufacturer(other.getManufacturer());
                    }
                    if (other.hasModel()) {
                        setModel(other.getModel());
                    }
                    if (other.hasProduct()) {
                        setProduct(other.getProduct());
                    }
                    if (other.hasSerial()) {
                        setSerial(other.getSerial());
                    }
                    if (other.hasCodename()) {
                        setCodename(other.getCodename());
                    }
                    if (other.hasIncremental()) {
                        setIncremental(other.getIncremental());
                    }
                    if (other.hasRelease()) {
                        setRelease(other.getRelease());
                    }
                    if (other.hasSdk()) {
                        setSdk(other.getSdk());
                    }
                    if (other.hasSdkInt()) {
                        setSdkInt(other.getSdkInt());
                    }
                    if (other.hasToken()) {
                        setToken(other.getToken());
                    }
                    if (other.hasBtaddress()) {
                        setBtaddress(other.getBtaddress());
                    }
                    if (other.hasCarlifeversion()) {
                        setCarlifeversion(other.getCarlifeversion());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            break;
                        case 10:
                            setOs(input.readString());
                            continue;
                        case 18:
                            setBoard(input.readString());
                            continue;
                        case 26:
                            setBootloader(input.readString());
                            continue;
                        case 34:
                            setBrand(input.readString());
                            continue;
                        case 42:
                            setCpuAbi(input.readString());
                            continue;
                        case 50:
                            setCpuAbi2(input.readString());
                            continue;
                        case 58:
                            setDevice(input.readString());
                            continue;
                        case 66:
                            setDisplay(input.readString());
                            continue;
                        case 74:
                            setFingerprint(input.readString());
                            continue;
                        case 82:
                            setHardware(input.readString());
                            continue;
                        case 90:
                            setHost(input.readString());
                            continue;
                        case 98:
                            setCid(input.readString());
                            continue;
                        case 106:
                            setManufacturer(input.readString());
                            continue;
                        case 114:
                            setModel(input.readString());
                            continue;
                        case C1253f.df /*122*/:
                            setProduct(input.readString());
                            continue;
                        case 130:
                            setSerial(input.readString());
                            continue;
                        case 138:
                            setCodename(input.readString());
                            continue;
                        case 146:
                            setIncremental(input.readString());
                            continue;
                        case 154:
                            setRelease(input.readString());
                            continue;
                        case 162:
                            setSdk(input.readString());
                            continue;
                        case 168:
                            setSdkInt(input.readInt32());
                            continue;
                        case 178:
                            setToken(input.readString());
                            continue;
                        case 186:
                            setBtaddress(input.readString());
                            continue;
                        case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                            setCarlifeversion(input.readString());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasOs() {
                return this.result.hasOs();
            }

            public String getOs() {
                return this.result.getOs();
            }

            public Builder setOs(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOs = true;
                this.result.os_ = value;
                return this;
            }

            public Builder clearOs() {
                this.result.hasOs = false;
                this.result.os_ = CarlifeDeviceInfo.getDefaultInstance().getOs();
                return this;
            }

            public boolean hasBoard() {
                return this.result.hasBoard();
            }

            public String getBoard() {
                return this.result.getBoard();
            }

            public Builder setBoard(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasBoard = true;
                this.result.board_ = value;
                return this;
            }

            public Builder clearBoard() {
                this.result.hasBoard = false;
                this.result.board_ = CarlifeDeviceInfo.getDefaultInstance().getBoard();
                return this;
            }

            public boolean hasBootloader() {
                return this.result.hasBootloader();
            }

            public String getBootloader() {
                return this.result.getBootloader();
            }

            public Builder setBootloader(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasBootloader = true;
                this.result.bootloader_ = value;
                return this;
            }

            public Builder clearBootloader() {
                this.result.hasBootloader = false;
                this.result.bootloader_ = CarlifeDeviceInfo.getDefaultInstance().getBootloader();
                return this;
            }

            public boolean hasBrand() {
                return this.result.hasBrand();
            }

            public String getBrand() {
                return this.result.getBrand();
            }

            public Builder setBrand(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasBrand = true;
                this.result.brand_ = value;
                return this;
            }

            public Builder clearBrand() {
                this.result.hasBrand = false;
                this.result.brand_ = CarlifeDeviceInfo.getDefaultInstance().getBrand();
                return this;
            }

            public boolean hasCpuAbi() {
                return this.result.hasCpuAbi();
            }

            public String getCpuAbi() {
                return this.result.getCpuAbi();
            }

            public Builder setCpuAbi(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasCpuAbi = true;
                this.result.cpuAbi_ = value;
                return this;
            }

            public Builder clearCpuAbi() {
                this.result.hasCpuAbi = false;
                this.result.cpuAbi_ = CarlifeDeviceInfo.getDefaultInstance().getCpuAbi();
                return this;
            }

            public boolean hasCpuAbi2() {
                return this.result.hasCpuAbi2();
            }

            public String getCpuAbi2() {
                return this.result.getCpuAbi2();
            }

            public Builder setCpuAbi2(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasCpuAbi2 = true;
                this.result.cpuAbi2_ = value;
                return this;
            }

            public Builder clearCpuAbi2() {
                this.result.hasCpuAbi2 = false;
                this.result.cpuAbi2_ = CarlifeDeviceInfo.getDefaultInstance().getCpuAbi2();
                return this;
            }

            public boolean hasDevice() {
                return this.result.hasDevice();
            }

            public String getDevice() {
                return this.result.getDevice();
            }

            public Builder setDevice(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasDevice = true;
                this.result.device_ = value;
                return this;
            }

            public Builder clearDevice() {
                this.result.hasDevice = false;
                this.result.device_ = CarlifeDeviceInfo.getDefaultInstance().getDevice();
                return this;
            }

            public boolean hasDisplay() {
                return this.result.hasDisplay();
            }

            public String getDisplay() {
                return this.result.getDisplay();
            }

            public Builder setDisplay(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasDisplay = true;
                this.result.display_ = value;
                return this;
            }

            public Builder clearDisplay() {
                this.result.hasDisplay = false;
                this.result.display_ = CarlifeDeviceInfo.getDefaultInstance().getDisplay();
                return this;
            }

            public boolean hasFingerprint() {
                return this.result.hasFingerprint();
            }

            public String getFingerprint() {
                return this.result.getFingerprint();
            }

            public Builder setFingerprint(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasFingerprint = true;
                this.result.fingerprint_ = value;
                return this;
            }

            public Builder clearFingerprint() {
                this.result.hasFingerprint = false;
                this.result.fingerprint_ = CarlifeDeviceInfo.getDefaultInstance().getFingerprint();
                return this;
            }

            public boolean hasHardware() {
                return this.result.hasHardware();
            }

            public String getHardware() {
                return this.result.getHardware();
            }

            public Builder setHardware(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasHardware = true;
                this.result.hardware_ = value;
                return this;
            }

            public Builder clearHardware() {
                this.result.hasHardware = false;
                this.result.hardware_ = CarlifeDeviceInfo.getDefaultInstance().getHardware();
                return this;
            }

            public boolean hasHost() {
                return this.result.hasHost();
            }

            public String getHost() {
                return this.result.getHost();
            }

            public Builder setHost(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasHost = true;
                this.result.host_ = value;
                return this;
            }

            public Builder clearHost() {
                this.result.hasHost = false;
                this.result.host_ = CarlifeDeviceInfo.getDefaultInstance().getHost();
                return this;
            }

            public boolean hasCid() {
                return this.result.hasCid();
            }

            public String getCid() {
                return this.result.getCid();
            }

            public Builder setCid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasCid = true;
                this.result.cid_ = value;
                return this;
            }

            public Builder clearCid() {
                this.result.hasCid = false;
                this.result.cid_ = CarlifeDeviceInfo.getDefaultInstance().getCid();
                return this;
            }

            public boolean hasManufacturer() {
                return this.result.hasManufacturer();
            }

            public String getManufacturer() {
                return this.result.getManufacturer();
            }

            public Builder setManufacturer(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasManufacturer = true;
                this.result.manufacturer_ = value;
                return this;
            }

            public Builder clearManufacturer() {
                this.result.hasManufacturer = false;
                this.result.manufacturer_ = CarlifeDeviceInfo.getDefaultInstance().getManufacturer();
                return this;
            }

            public boolean hasModel() {
                return this.result.hasModel();
            }

            public String getModel() {
                return this.result.getModel();
            }

            public Builder setModel(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasModel = true;
                this.result.model_ = value;
                return this;
            }

            public Builder clearModel() {
                this.result.hasModel = false;
                this.result.model_ = CarlifeDeviceInfo.getDefaultInstance().getModel();
                return this;
            }

            public boolean hasProduct() {
                return this.result.hasProduct();
            }

            public String getProduct() {
                return this.result.getProduct();
            }

            public Builder setProduct(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasProduct = true;
                this.result.product_ = value;
                return this;
            }

            public Builder clearProduct() {
                this.result.hasProduct = false;
                this.result.product_ = CarlifeDeviceInfo.getDefaultInstance().getProduct();
                return this;
            }

            public boolean hasSerial() {
                return this.result.hasSerial();
            }

            public String getSerial() {
                return this.result.getSerial();
            }

            public Builder setSerial(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasSerial = true;
                this.result.serial_ = value;
                return this;
            }

            public Builder clearSerial() {
                this.result.hasSerial = false;
                this.result.serial_ = CarlifeDeviceInfo.getDefaultInstance().getSerial();
                return this;
            }

            public boolean hasCodename() {
                return this.result.hasCodename();
            }

            public String getCodename() {
                return this.result.getCodename();
            }

            public Builder setCodename(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasCodename = true;
                this.result.codename_ = value;
                return this;
            }

            public Builder clearCodename() {
                this.result.hasCodename = false;
                this.result.codename_ = CarlifeDeviceInfo.getDefaultInstance().getCodename();
                return this;
            }

            public boolean hasIncremental() {
                return this.result.hasIncremental();
            }

            public String getIncremental() {
                return this.result.getIncremental();
            }

            public Builder setIncremental(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasIncremental = true;
                this.result.incremental_ = value;
                return this;
            }

            public Builder clearIncremental() {
                this.result.hasIncremental = false;
                this.result.incremental_ = CarlifeDeviceInfo.getDefaultInstance().getIncremental();
                return this;
            }

            public boolean hasRelease() {
                return this.result.hasRelease();
            }

            public String getRelease() {
                return this.result.getRelease();
            }

            public Builder setRelease(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasRelease = true;
                this.result.release_ = value;
                return this;
            }

            public Builder clearRelease() {
                this.result.hasRelease = false;
                this.result.release_ = CarlifeDeviceInfo.getDefaultInstance().getRelease();
                return this;
            }

            public boolean hasSdk() {
                return this.result.hasSdk();
            }

            public String getSdk() {
                return this.result.getSdk();
            }

            public Builder setSdk(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasSdk = true;
                this.result.sdk_ = value;
                return this;
            }

            public Builder clearSdk() {
                this.result.hasSdk = false;
                this.result.sdk_ = CarlifeDeviceInfo.getDefaultInstance().getSdk();
                return this;
            }

            public boolean hasSdkInt() {
                return this.result.hasSdkInt();
            }

            public int getSdkInt() {
                return this.result.getSdkInt();
            }

            public Builder setSdkInt(int value) {
                this.result.hasSdkInt = true;
                this.result.sdkInt_ = value;
                return this;
            }

            public Builder clearSdkInt() {
                this.result.hasSdkInt = false;
                this.result.sdkInt_ = 0;
                return this;
            }

            public boolean hasToken() {
                return this.result.hasToken();
            }

            public String getToken() {
                return this.result.getToken();
            }

            public Builder setToken(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasToken = true;
                this.result.token_ = value;
                return this;
            }

            public Builder clearToken() {
                this.result.hasToken = false;
                this.result.token_ = CarlifeDeviceInfo.getDefaultInstance().getToken();
                return this;
            }

            public boolean hasBtaddress() {
                return this.result.hasBtaddress();
            }

            public String getBtaddress() {
                return this.result.getBtaddress();
            }

            public Builder setBtaddress(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasBtaddress = true;
                this.result.btaddress_ = value;
                return this;
            }

            public Builder clearBtaddress() {
                this.result.hasBtaddress = false;
                this.result.btaddress_ = CarlifeDeviceInfo.getDefaultInstance().getBtaddress();
                return this;
            }

            public boolean hasCarlifeversion() {
                return this.result.hasCarlifeversion();
            }

            public String getCarlifeversion() {
                return this.result.getCarlifeversion();
            }

            public Builder setCarlifeversion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasCarlifeversion = true;
                this.result.carlifeversion_ = value;
                return this;
            }

            public Builder clearCarlifeversion() {
                this.result.hasCarlifeversion = false;
                this.result.carlifeversion_ = CarlifeDeviceInfo.getDefaultInstance().getCarlifeversion();
                return this;
            }
        }

        private CarlifeDeviceInfo() {
            this.os_ = "";
            this.board_ = "";
            this.bootloader_ = "";
            this.brand_ = "";
            this.cpuAbi_ = "";
            this.cpuAbi2_ = "";
            this.device_ = "";
            this.display_ = "";
            this.fingerprint_ = "";
            this.hardware_ = "";
            this.host_ = "";
            this.cid_ = "";
            this.manufacturer_ = "";
            this.model_ = "";
            this.product_ = "";
            this.serial_ = "";
            this.codename_ = "";
            this.incremental_ = "";
            this.release_ = "";
            this.sdk_ = "";
            this.sdkInt_ = 0;
            this.token_ = "";
            this.btaddress_ = "";
            this.carlifeversion_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeDeviceInfoProto.getDescriptor();
            CarlifeDeviceInfoProto.internalForceInit();
        }

        public static CarlifeDeviceInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeDeviceInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeDeviceInfoProto.f6613xcc463fae;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeDeviceInfoProto.f6614xe789d82c;
        }

        public boolean hasOs() {
            return this.hasOs;
        }

        public String getOs() {
            return this.os_;
        }

        public boolean hasBoard() {
            return this.hasBoard;
        }

        public String getBoard() {
            return this.board_;
        }

        public boolean hasBootloader() {
            return this.hasBootloader;
        }

        public String getBootloader() {
            return this.bootloader_;
        }

        public boolean hasBrand() {
            return this.hasBrand;
        }

        public String getBrand() {
            return this.brand_;
        }

        public boolean hasCpuAbi() {
            return this.hasCpuAbi;
        }

        public String getCpuAbi() {
            return this.cpuAbi_;
        }

        public boolean hasCpuAbi2() {
            return this.hasCpuAbi2;
        }

        public String getCpuAbi2() {
            return this.cpuAbi2_;
        }

        public boolean hasDevice() {
            return this.hasDevice;
        }

        public String getDevice() {
            return this.device_;
        }

        public boolean hasDisplay() {
            return this.hasDisplay;
        }

        public String getDisplay() {
            return this.display_;
        }

        public boolean hasFingerprint() {
            return this.hasFingerprint;
        }

        public String getFingerprint() {
            return this.fingerprint_;
        }

        public boolean hasHardware() {
            return this.hasHardware;
        }

        public String getHardware() {
            return this.hardware_;
        }

        public boolean hasHost() {
            return this.hasHost;
        }

        public String getHost() {
            return this.host_;
        }

        public boolean hasCid() {
            return this.hasCid;
        }

        public String getCid() {
            return this.cid_;
        }

        public boolean hasManufacturer() {
            return this.hasManufacturer;
        }

        public String getManufacturer() {
            return this.manufacturer_;
        }

        public boolean hasModel() {
            return this.hasModel;
        }

        public String getModel() {
            return this.model_;
        }

        public boolean hasProduct() {
            return this.hasProduct;
        }

        public String getProduct() {
            return this.product_;
        }

        public boolean hasSerial() {
            return this.hasSerial;
        }

        public String getSerial() {
            return this.serial_;
        }

        public boolean hasCodename() {
            return this.hasCodename;
        }

        public String getCodename() {
            return this.codename_;
        }

        public boolean hasIncremental() {
            return this.hasIncremental;
        }

        public String getIncremental() {
            return this.incremental_;
        }

        public boolean hasRelease() {
            return this.hasRelease;
        }

        public String getRelease() {
            return this.release_;
        }

        public boolean hasSdk() {
            return this.hasSdk;
        }

        public String getSdk() {
            return this.sdk_;
        }

        public boolean hasSdkInt() {
            return this.hasSdkInt;
        }

        public int getSdkInt() {
            return this.sdkInt_;
        }

        public boolean hasToken() {
            return this.hasToken;
        }

        public String getToken() {
            return this.token_;
        }

        public boolean hasBtaddress() {
            return this.hasBtaddress;
        }

        public String getBtaddress() {
            return this.btaddress_;
        }

        public boolean hasCarlifeversion() {
            return this.hasCarlifeversion;
        }

        public String getCarlifeversion() {
            return this.carlifeversion_;
        }

        public final boolean isInitialized() {
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasOs()) {
                output.writeString(1, getOs());
            }
            if (hasBoard()) {
                output.writeString(2, getBoard());
            }
            if (hasBootloader()) {
                output.writeString(3, getBootloader());
            }
            if (hasBrand()) {
                output.writeString(4, getBrand());
            }
            if (hasCpuAbi()) {
                output.writeString(5, getCpuAbi());
            }
            if (hasCpuAbi2()) {
                output.writeString(6, getCpuAbi2());
            }
            if (hasDevice()) {
                output.writeString(7, getDevice());
            }
            if (hasDisplay()) {
                output.writeString(8, getDisplay());
            }
            if (hasFingerprint()) {
                output.writeString(9, getFingerprint());
            }
            if (hasHardware()) {
                output.writeString(10, getHardware());
            }
            if (hasHost()) {
                output.writeString(11, getHost());
            }
            if (hasCid()) {
                output.writeString(12, getCid());
            }
            if (hasManufacturer()) {
                output.writeString(13, getManufacturer());
            }
            if (hasModel()) {
                output.writeString(14, getModel());
            }
            if (hasProduct()) {
                output.writeString(15, getProduct());
            }
            if (hasSerial()) {
                output.writeString(16, getSerial());
            }
            if (hasCodename()) {
                output.writeString(17, getCodename());
            }
            if (hasIncremental()) {
                output.writeString(18, getIncremental());
            }
            if (hasRelease()) {
                output.writeString(19, getRelease());
            }
            if (hasSdk()) {
                output.writeString(20, getSdk());
            }
            if (hasSdkInt()) {
                output.writeInt32(21, getSdkInt());
            }
            if (hasToken()) {
                output.writeString(22, getToken());
            }
            if (hasBtaddress()) {
                output.writeString(23, getBtaddress());
            }
            if (hasCarlifeversion()) {
                output.writeString(24, getCarlifeversion());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasOs()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getOs());
            }
            if (hasBoard()) {
                size += CodedOutputStream.computeStringSize(2, getBoard());
            }
            if (hasBootloader()) {
                size += CodedOutputStream.computeStringSize(3, getBootloader());
            }
            if (hasBrand()) {
                size += CodedOutputStream.computeStringSize(4, getBrand());
            }
            if (hasCpuAbi()) {
                size += CodedOutputStream.computeStringSize(5, getCpuAbi());
            }
            if (hasCpuAbi2()) {
                size += CodedOutputStream.computeStringSize(6, getCpuAbi2());
            }
            if (hasDevice()) {
                size += CodedOutputStream.computeStringSize(7, getDevice());
            }
            if (hasDisplay()) {
                size += CodedOutputStream.computeStringSize(8, getDisplay());
            }
            if (hasFingerprint()) {
                size += CodedOutputStream.computeStringSize(9, getFingerprint());
            }
            if (hasHardware()) {
                size += CodedOutputStream.computeStringSize(10, getHardware());
            }
            if (hasHost()) {
                size += CodedOutputStream.computeStringSize(11, getHost());
            }
            if (hasCid()) {
                size += CodedOutputStream.computeStringSize(12, getCid());
            }
            if (hasManufacturer()) {
                size += CodedOutputStream.computeStringSize(13, getManufacturer());
            }
            if (hasModel()) {
                size += CodedOutputStream.computeStringSize(14, getModel());
            }
            if (hasProduct()) {
                size += CodedOutputStream.computeStringSize(15, getProduct());
            }
            if (hasSerial()) {
                size += CodedOutputStream.computeStringSize(16, getSerial());
            }
            if (hasCodename()) {
                size += CodedOutputStream.computeStringSize(17, getCodename());
            }
            if (hasIncremental()) {
                size += CodedOutputStream.computeStringSize(18, getIncremental());
            }
            if (hasRelease()) {
                size += CodedOutputStream.computeStringSize(19, getRelease());
            }
            if (hasSdk()) {
                size += CodedOutputStream.computeStringSize(20, getSdk());
            }
            if (hasSdkInt()) {
                size += CodedOutputStream.computeInt32Size(21, getSdkInt());
            }
            if (hasToken()) {
                size += CodedOutputStream.computeStringSize(22, getToken());
            }
            if (hasBtaddress()) {
                size += CodedOutputStream.computeStringSize(23, getBtaddress());
            }
            if (hasCarlifeversion()) {
                size += CodedOutputStream.computeStringSize(24, getCarlifeversion());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeDeviceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeDeviceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeDeviceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeDeviceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeDeviceInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeDeviceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeDeviceInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeDeviceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeDeviceInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeDeviceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeDeviceInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeDeviceInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cCarlifeDeviceInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"­\u0003\n\u0011CarlifeDeviceInfo\u0012\n\n\u0002os\u0018\u0001 \u0001(\t\u0012\r\n\u0005board\u0018\u0002 \u0001(\t\u0012\u0012\n\nbootloader\u0018\u0003 \u0001(\t\u0012\r\n\u0005brand\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007cpu_abi\u0018\u0005 \u0001(\t\u0012\u0010\n\bcpu_abi2\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006device\u0018\u0007 \u0001(\t\u0012\u000f\n\u0007display\u0018\b \u0001(\t\u0012\u0013\n\u000bfingerprint\u0018\t \u0001(\t\u0012\u0010\n\bhardware\u0018\n \u0001(\t\u0012\f\n\u0004host\u0018\u000b \u0001(\t\u0012\u000b\n\u0003cid\u0018\f \u0001(\t\u0012\u0014\n\fmanufacturer\u0018\r \u0001(\t\u0012\r\n\u0005model\u0018\u000e \u0001(\t\u0012\u000f\n\u0007product\u0018\u000f \u0001(\t\u0012\u000e\n\u0006serial\u0018\u0010 \u0001(\t\u0012\u0010\n\bcodename\u0018\u0011 \u0001(\t\u0012\u0013\n\u000bincremental\u0018\u0012 \u0001(\t\u0012\u000f\n\u0007release\u0018\u0013 \u0001", "(\t\u0012\u000b\n\u0003sdk\u0018\u0014 \u0001(\t\u0012\u000f\n\u0007sdk_int\u0018\u0015 \u0001(\u0005\u0012\r\n\u0005token\u0018\u0016 \u0001(\t\u0012\u0011\n\tbtaddress\u0018\u0017 \u0001(\t\u0012\u0016\n\u000ecarlifeversion\u0018\u0018 \u0001(\t"}, new FileDescriptor[0], new C20601());
    }

    public static void internalForceInit() {
    }
}
