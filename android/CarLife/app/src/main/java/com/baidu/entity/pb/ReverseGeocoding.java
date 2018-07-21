package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ReverseGeocoding
  extends MessageMicro
{
  public static final int ADDRESS_DETAIL_FIELD_NUMBER = 6;
  public static final int ADDRESS_FIELD_NUMBER = 1;
  public static final int AREA_FIELD_NUMBER = 13;
  public static final int BUILDID_FIELD_NUMBER = 3;
  public static final int BUSINESS_FIELD_NUMBER = 7;
  public static final int FLOOR_FIELD_NUMBER = 2;
  public static final int NEARBY_FIELD_NUMBER = 11;
  public static final int PANO_FIELD_NUMBER = 4;
  public static final int POINT_FIELD_NUMBER = 9;
  public static final int POI_DESC_FIELD_NUMBER = 8;
  public static final int STREETSCAPEID_FIELD_NUMBER = 5;
  public static final int SURROUND_POI_FIELD_NUMBER = 10;
  public static final int TAIL_BAR_TEXT_FIELD_NUMBER = 12;
  private boolean a;
  private String b = "";
  private boolean c;
  private String d = "";
  private boolean e;
  private String f = "";
  private boolean g;
  private int h = 0;
  private boolean i;
  private String j = "";
  private boolean k;
  private AddressDetail l = null;
  private boolean m;
  private String n = "";
  private boolean o;
  private String p = "";
  private boolean q;
  private Point r = null;
  private List<SurroundPoi> s = Collections.emptyList();
  private boolean t;
  private String u = "";
  private boolean v;
  private String w = "";
  private boolean x;
  private String y = "";
  private int z = -1;
  
  public static ReverseGeocoding parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new ReverseGeocoding().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static ReverseGeocoding parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (ReverseGeocoding)new ReverseGeocoding().mergeFrom(paramArrayOfByte);
  }
  
  public ReverseGeocoding addSurroundPoi(SurroundPoi paramSurroundPoi)
  {
    if (paramSurroundPoi == null) {
      return this;
    }
    if (this.s.isEmpty()) {
      this.s = new ArrayList();
    }
    this.s.add(paramSurroundPoi);
    return this;
  }
  
  public final ReverseGeocoding clear()
  {
    clearAddress();
    clearFloor();
    clearBuildId();
    clearPano();
    clearStreetScapeID();
    clearAddressDetail();
    clearBusiness();
    clearPoiDesc();
    clearPoint();
    clearSurroundPoi();
    clearNearby();
    clearTailBarText();
    clearArea();
    this.z = -1;
    return this;
  }
  
  public ReverseGeocoding clearAddress()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public ReverseGeocoding clearAddressDetail()
  {
    this.k = false;
    this.l = null;
    return this;
  }
  
  public ReverseGeocoding clearArea()
  {
    this.x = false;
    this.y = "";
    return this;
  }
  
  public ReverseGeocoding clearBuildId()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public ReverseGeocoding clearBusiness()
  {
    this.m = false;
    this.n = "";
    return this;
  }
  
  public ReverseGeocoding clearFloor()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public ReverseGeocoding clearNearby()
  {
    this.t = false;
    this.u = "";
    return this;
  }
  
  public ReverseGeocoding clearPano()
  {
    this.g = false;
    this.h = 0;
    return this;
  }
  
  public ReverseGeocoding clearPoiDesc()
  {
    this.o = false;
    this.p = "";
    return this;
  }
  
  public ReverseGeocoding clearPoint()
  {
    this.q = false;
    this.r = null;
    return this;
  }
  
  public ReverseGeocoding clearStreetScapeID()
  {
    this.i = false;
    this.j = "";
    return this;
  }
  
  public ReverseGeocoding clearSurroundPoi()
  {
    this.s = Collections.emptyList();
    return this;
  }
  
  public ReverseGeocoding clearTailBarText()
  {
    this.v = false;
    this.w = "";
    return this;
  }
  
  public String getAddress()
  {
    return this.b;
  }
  
  public AddressDetail getAddressDetail()
  {
    return this.l;
  }
  
  public String getArea()
  {
    return this.y;
  }
  
  public String getBuildId()
  {
    return this.f;
  }
  
  public String getBusiness()
  {
    return this.n;
  }
  
  public int getCachedSize()
  {
    if (this.z < 0) {
      getSerializedSize();
    }
    return this.z;
  }
  
  public String getFloor()
  {
    return this.d;
  }
  
  public String getNearby()
  {
    return this.u;
  }
  
  public int getPano()
  {
    return this.h;
  }
  
  public String getPoiDesc()
  {
    return this.p;
  }
  
  public Point getPoint()
  {
    return this.r;
  }
  
  public int getSerializedSize()
  {
    int i2 = 0;
    if (hasAddress()) {
      i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getAddress());
    }
    int i1 = i2;
    if (hasFloor()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getFloor());
    }
    i2 = i1;
    if (hasBuildId()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getBuildId());
    }
    i1 = i2;
    if (hasPano()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getPano());
    }
    i2 = i1;
    if (hasStreetScapeID()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getStreetScapeID());
    }
    i1 = i2;
    if (hasAddressDetail()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(6, getAddressDetail());
    }
    i2 = i1;
    if (hasBusiness()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getBusiness());
    }
    i1 = i2;
    if (hasPoiDesc()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getPoiDesc());
    }
    i2 = i1;
    if (hasPoint()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(9, getPoint());
    }
    Iterator localIterator = getSurroundPoiList().iterator();
    while (localIterator.hasNext()) {
      i2 = CodedOutputStreamMicro.computeMessageSize(10, (SurroundPoi)localIterator.next()) + i2;
    }
    i1 = i2;
    if (hasNearby()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(11, getNearby());
    }
    i2 = i1;
    if (hasTailBarText()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(12, getTailBarText());
    }
    i1 = i2;
    if (hasArea()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(13, getArea());
    }
    this.z = i1;
    return i1;
  }
  
  public String getStreetScapeID()
  {
    return this.j;
  }
  
  public SurroundPoi getSurroundPoi(int paramInt)
  {
    return (SurroundPoi)this.s.get(paramInt);
  }
  
  public int getSurroundPoiCount()
  {
    return this.s.size();
  }
  
  public List<SurroundPoi> getSurroundPoiList()
  {
    return this.s;
  }
  
  public String getTailBarText()
  {
    return this.w;
  }
  
  public boolean hasAddress()
  {
    return this.a;
  }
  
  public boolean hasAddressDetail()
  {
    return this.k;
  }
  
  public boolean hasArea()
  {
    return this.x;
  }
  
  public boolean hasBuildId()
  {
    return this.e;
  }
  
  public boolean hasBusiness()
  {
    return this.m;
  }
  
  public boolean hasFloor()
  {
    return this.c;
  }
  
  public boolean hasNearby()
  {
    return this.t;
  }
  
  public boolean hasPano()
  {
    return this.g;
  }
  
  public boolean hasPoiDesc()
  {
    return this.o;
  }
  
  public boolean hasPoint()
  {
    return this.q;
  }
  
  public boolean hasStreetScapeID()
  {
    return this.i;
  }
  
  public boolean hasTailBarText()
  {
    return this.v;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public ReverseGeocoding mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i1 = paramCodedInputStreamMicro.readTag();
      Object localObject;
      switch (i1)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
        break;
      case 0: 
        return this;
      case 10: 
        setAddress(paramCodedInputStreamMicro.readString());
        break;
      case 18: 
        setFloor(paramCodedInputStreamMicro.readString());
        break;
      case 26: 
        setBuildId(paramCodedInputStreamMicro.readString());
        break;
      case 32: 
        setPano(paramCodedInputStreamMicro.readInt32());
        break;
      case 42: 
        setStreetScapeID(paramCodedInputStreamMicro.readString());
        break;
      case 50: 
        localObject = new AddressDetail();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setAddressDetail((AddressDetail)localObject);
        break;
      case 58: 
        setBusiness(paramCodedInputStreamMicro.readString());
        break;
      case 66: 
        setPoiDesc(paramCodedInputStreamMicro.readString());
        break;
      case 74: 
        localObject = new Point();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setPoint((Point)localObject);
        break;
      case 82: 
        localObject = new SurroundPoi();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addSurroundPoi((SurroundPoi)localObject);
        break;
      case 90: 
        setNearby(paramCodedInputStreamMicro.readString());
        break;
      case 98: 
        setTailBarText(paramCodedInputStreamMicro.readString());
        break;
      case 106: 
        setArea(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public ReverseGeocoding setAddress(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public ReverseGeocoding setAddressDetail(AddressDetail paramAddressDetail)
  {
    if (paramAddressDetail == null) {
      return clearAddressDetail();
    }
    this.k = true;
    this.l = paramAddressDetail;
    return this;
  }
  
  public ReverseGeocoding setArea(String paramString)
  {
    this.x = true;
    this.y = paramString;
    return this;
  }
  
  public ReverseGeocoding setBuildId(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public ReverseGeocoding setBusiness(String paramString)
  {
    this.m = true;
    this.n = paramString;
    return this;
  }
  
  public ReverseGeocoding setFloor(String paramString)
  {
    this.c = true;
    this.d = paramString;
    return this;
  }
  
  public ReverseGeocoding setNearby(String paramString)
  {
    this.t = true;
    this.u = paramString;
    return this;
  }
  
  public ReverseGeocoding setPano(int paramInt)
  {
    this.g = true;
    this.h = paramInt;
    return this;
  }
  
  public ReverseGeocoding setPoiDesc(String paramString)
  {
    this.o = true;
    this.p = paramString;
    return this;
  }
  
  public ReverseGeocoding setPoint(Point paramPoint)
  {
    if (paramPoint == null) {
      return clearPoint();
    }
    this.q = true;
    this.r = paramPoint;
    return this;
  }
  
  public ReverseGeocoding setStreetScapeID(String paramString)
  {
    this.i = true;
    this.j = paramString;
    return this;
  }
  
  public ReverseGeocoding setSurroundPoi(int paramInt, SurroundPoi paramSurroundPoi)
  {
    if (paramSurroundPoi == null) {
      return this;
    }
    this.s.set(paramInt, paramSurroundPoi);
    return this;
  }
  
  public ReverseGeocoding setTailBarText(String paramString)
  {
    this.v = true;
    this.w = paramString;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasAddress()) {
      paramCodedOutputStreamMicro.writeString(1, getAddress());
    }
    if (hasFloor()) {
      paramCodedOutputStreamMicro.writeString(2, getFloor());
    }
    if (hasBuildId()) {
      paramCodedOutputStreamMicro.writeString(3, getBuildId());
    }
    if (hasPano()) {
      paramCodedOutputStreamMicro.writeInt32(4, getPano());
    }
    if (hasStreetScapeID()) {
      paramCodedOutputStreamMicro.writeString(5, getStreetScapeID());
    }
    if (hasAddressDetail()) {
      paramCodedOutputStreamMicro.writeMessage(6, getAddressDetail());
    }
    if (hasBusiness()) {
      paramCodedOutputStreamMicro.writeString(7, getBusiness());
    }
    if (hasPoiDesc()) {
      paramCodedOutputStreamMicro.writeString(8, getPoiDesc());
    }
    if (hasPoint()) {
      paramCodedOutputStreamMicro.writeMessage(9, getPoint());
    }
    Iterator localIterator = getSurroundPoiList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(10, (SurroundPoi)localIterator.next());
    }
    if (hasNearby()) {
      paramCodedOutputStreamMicro.writeString(11, getNearby());
    }
    if (hasTailBarText()) {
      paramCodedOutputStreamMicro.writeString(12, getTailBarText());
    }
    if (hasArea()) {
      paramCodedOutputStreamMicro.writeString(13, getArea());
    }
  }
  
  public static final class AddressDetail
    extends MessageMicro
  {
    public static final int CITY_CODE_FIELD_NUMBER = 2;
    public static final int CITY_FIELD_NUMBER = 1;
    public static final int COUNTRY_CODE_FIELD_NUMBER = 4;
    public static final int COUNTRY_FIELD_NUMBER = 3;
    public static final int DISTRICT_FIELD_NUMBER = 5;
    public static final int PROVINCE_FIELD_NUMBER = 6;
    public static final int STREET_FIELD_NUMBER = 7;
    public static final int STREET_NUMBER_FIELD_NUMBER = 8;
    private boolean a;
    private String b = "";
    private boolean c;
    private int d = 0;
    private boolean e;
    private String f = "";
    private boolean g;
    private int h = 0;
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private boolean m;
    private String n = "";
    private boolean o;
    private String p = "";
    private int q = -1;
    
    public static AddressDetail parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new AddressDetail().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static AddressDetail parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (AddressDetail)new AddressDetail().mergeFrom(paramArrayOfByte);
    }
    
    public final AddressDetail clear()
    {
      clearCity();
      clearCityCode();
      clearCountry();
      clearCountryCode();
      clearDistrict();
      clearProvince();
      clearStreet();
      clearStreetNumber();
      this.q = -1;
      return this;
    }
    
    public AddressDetail clearCity()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public AddressDetail clearCityCode()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public AddressDetail clearCountry()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public AddressDetail clearCountryCode()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public AddressDetail clearDistrict()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public AddressDetail clearProvince()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public AddressDetail clearStreet()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public AddressDetail clearStreetNumber()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.q < 0) {
        getSerializedSize();
      }
      return this.q;
    }
    
    public String getCity()
    {
      return this.b;
    }
    
    public int getCityCode()
    {
      return this.d;
    }
    
    public String getCountry()
    {
      return this.f;
    }
    
    public int getCountryCode()
    {
      return this.h;
    }
    
    public String getDistrict()
    {
      return this.j;
    }
    
    public String getProvince()
    {
      return this.l;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasCity()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCity());
      }
      int i1 = i2;
      if (hasCityCode()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getCityCode());
      }
      i2 = i1;
      if (hasCountry()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getCountry());
      }
      i1 = i2;
      if (hasCountryCode()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getCountryCode());
      }
      i2 = i1;
      if (hasDistrict()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getDistrict());
      }
      i1 = i2;
      if (hasProvince()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getProvince());
      }
      i2 = i1;
      if (hasStreet()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getStreet());
      }
      i1 = i2;
      if (hasStreetNumber()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getStreetNumber());
      }
      this.q = i1;
      return i1;
    }
    
    public String getStreet()
    {
      return this.n;
    }
    
    public String getStreetNumber()
    {
      return this.p;
    }
    
    public boolean hasCity()
    {
      return this.a;
    }
    
    public boolean hasCityCode()
    {
      return this.c;
    }
    
    public boolean hasCountry()
    {
      return this.e;
    }
    
    public boolean hasCountryCode()
    {
      return this.g;
    }
    
    public boolean hasDistrict()
    {
      return this.i;
    }
    
    public boolean hasProvince()
    {
      return this.k;
    }
    
    public boolean hasStreet()
    {
      return this.m;
    }
    
    public boolean hasStreetNumber()
    {
      return this.o;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public AddressDetail mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setCity(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setCityCode(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setCountry(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setCountryCode(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setDistrict(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setProvince(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setStreet(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setStreetNumber(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public AddressDetail setCity(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public AddressDetail setCityCode(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public AddressDetail setCountry(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public AddressDetail setCountryCode(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public AddressDetail setDistrict(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public AddressDetail setProvince(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public AddressDetail setStreet(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public AddressDetail setStreetNumber(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCity()) {
        paramCodedOutputStreamMicro.writeString(1, getCity());
      }
      if (hasCityCode()) {
        paramCodedOutputStreamMicro.writeInt32(2, getCityCode());
      }
      if (hasCountry()) {
        paramCodedOutputStreamMicro.writeString(3, getCountry());
      }
      if (hasCountryCode()) {
        paramCodedOutputStreamMicro.writeInt32(4, getCountryCode());
      }
      if (hasDistrict()) {
        paramCodedOutputStreamMicro.writeString(5, getDistrict());
      }
      if (hasProvince()) {
        paramCodedOutputStreamMicro.writeString(6, getProvince());
      }
      if (hasStreet()) {
        paramCodedOutputStreamMicro.writeString(7, getStreet());
      }
      if (hasStreetNumber()) {
        paramCodedOutputStreamMicro.writeString(8, getStreetNumber());
      }
    }
  }
  
  public static final class SurroundPoi
    extends MessageMicro
  {
    public static final int ADDR_FIELD_NUMBER = 1;
    public static final int BUILDINGID_FIELD_NUMBER = 7;
    public static final int DISTANCE_FIELD_NUMBER = 10;
    public static final int FLOORID_FIELD_NUMBER = 6;
    public static final int INDOORPANO_FIELD_NUMBER = 9;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int PANO_FIELD_NUMBER = 8;
    public static final int POINT_FIELD_NUMBER = 2;
    public static final int TAG_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private Point d = null;
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private boolean m;
    private String n = "";
    private boolean o;
    private int p = 0;
    private boolean q;
    private String r = "";
    private boolean s;
    private double t = 0.0D;
    private int u = -1;
    
    public static SurroundPoi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SurroundPoi().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SurroundPoi parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SurroundPoi)new SurroundPoi().mergeFrom(paramArrayOfByte);
    }
    
    public final SurroundPoi clear()
    {
      clearAddr();
      clearPoint();
      clearUid();
      clearName();
      clearTag();
      clearFloorId();
      clearBuildingId();
      clearPano();
      clearIndoorPano();
      clearDistance();
      this.u = -1;
      return this;
    }
    
    public SurroundPoi clearAddr()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public SurroundPoi clearBuildingId()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public SurroundPoi clearDistance()
    {
      this.s = false;
      this.t = 0.0D;
      return this;
    }
    
    public SurroundPoi clearFloorId()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public SurroundPoi clearIndoorPano()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public SurroundPoi clearName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public SurroundPoi clearPano()
    {
      this.o = false;
      this.p = 0;
      return this;
    }
    
    public SurroundPoi clearPoint()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public SurroundPoi clearTag()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public SurroundPoi clearUid()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public String getAddr()
    {
      return this.b;
    }
    
    public String getBuildingId()
    {
      return this.n;
    }
    
    public int getCachedSize()
    {
      if (this.u < 0) {
        getSerializedSize();
      }
      return this.u;
    }
    
    public double getDistance()
    {
      return this.t;
    }
    
    public String getFloorId()
    {
      return this.l;
    }
    
    public String getIndoorPano()
    {
      return this.r;
    }
    
    public String getName()
    {
      return this.h;
    }
    
    public int getPano()
    {
      return this.p;
    }
    
    public Point getPoint()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasAddr()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getAddr());
      }
      int i1 = i2;
      if (hasPoint()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(2, getPoint());
      }
      i2 = i1;
      if (hasUid()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getUid());
      }
      i1 = i2;
      if (hasName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getName());
      }
      i2 = i1;
      if (hasTag()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getTag());
      }
      i1 = i2;
      if (hasFloorId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getFloorId());
      }
      i2 = i1;
      if (hasBuildingId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getBuildingId());
      }
      i1 = i2;
      if (hasPano()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getPano());
      }
      i2 = i1;
      if (hasIndoorPano()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getIndoorPano());
      }
      i1 = i2;
      if (hasDistance()) {
        i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(10, getDistance());
      }
      this.u = i1;
      return i1;
    }
    
    public String getTag()
    {
      return this.j;
    }
    
    public String getUid()
    {
      return this.f;
    }
    
    public boolean hasAddr()
    {
      return this.a;
    }
    
    public boolean hasBuildingId()
    {
      return this.m;
    }
    
    public boolean hasDistance()
    {
      return this.s;
    }
    
    public boolean hasFloorId()
    {
      return this.k;
    }
    
    public boolean hasIndoorPano()
    {
      return this.q;
    }
    
    public boolean hasName()
    {
      return this.g;
    }
    
    public boolean hasPano()
    {
      return this.o;
    }
    
    public boolean hasPoint()
    {
      return this.c;
    }
    
    public boolean hasTag()
    {
      return this.i;
    }
    
    public boolean hasUid()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SurroundPoi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setAddr(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          Point localPoint = new Point();
          paramCodedInputStreamMicro.readMessage(localPoint);
          setPoint(localPoint);
          break;
        case 26: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setTag(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setFloorId(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setBuildingId(paramCodedInputStreamMicro.readString());
          break;
        case 64: 
          setPano(paramCodedInputStreamMicro.readInt32());
          break;
        case 74: 
          setIndoorPano(paramCodedInputStreamMicro.readString());
          break;
        case 81: 
          setDistance(paramCodedInputStreamMicro.readDouble());
        }
      }
    }
    
    public SurroundPoi setAddr(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public SurroundPoi setBuildingId(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public SurroundPoi setDistance(double paramDouble)
    {
      this.s = true;
      this.t = paramDouble;
      return this;
    }
    
    public SurroundPoi setFloorId(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public SurroundPoi setIndoorPano(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public SurroundPoi setName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public SurroundPoi setPano(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public SurroundPoi setPoint(Point paramPoint)
    {
      if (paramPoint == null) {
        return clearPoint();
      }
      this.c = true;
      this.d = paramPoint;
      return this;
    }
    
    public SurroundPoi setTag(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public SurroundPoi setUid(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAddr()) {
        paramCodedOutputStreamMicro.writeString(1, getAddr());
      }
      if (hasPoint()) {
        paramCodedOutputStreamMicro.writeMessage(2, getPoint());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(3, getUid());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(4, getName());
      }
      if (hasTag()) {
        paramCodedOutputStreamMicro.writeString(5, getTag());
      }
      if (hasFloorId()) {
        paramCodedOutputStreamMicro.writeString(6, getFloorId());
      }
      if (hasBuildingId()) {
        paramCodedOutputStreamMicro.writeString(7, getBuildingId());
      }
      if (hasPano()) {
        paramCodedOutputStreamMicro.writeInt32(8, getPano());
      }
      if (hasIndoorPano()) {
        paramCodedOutputStreamMicro.writeString(9, getIndoorPano());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeDouble(10, getDistance());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/ReverseGeocoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */