package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Inf
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int CURRENT_CITY_FIELD_NUMBER = 3;
  public static final int OFFLINE_FIELD_NUMBER = 4;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Content d = null;
  private boolean e;
  private CurrentCity f = null;
  private boolean g;
  private int h = 0;
  private int i = -1;
  
  public static Inf parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Inf().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Inf parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Inf)new Inf().mergeFrom(paramArrayOfByte);
  }
  
  public final Inf clear()
  {
    clearOption();
    clearContent();
    clearCurrentCity();
    clearOffline();
    this.i = -1;
    return this;
  }
  
  public Inf clearContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Inf clearCurrentCity()
  {
    this.e = false;
    this.f = null;
    return this;
  }
  
  public Inf clearOffline()
  {
    this.g = false;
    this.h = 0;
    return this;
  }
  
  public Inf clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.i < 0) {
      getSerializedSize();
    }
    return this.i;
  }
  
  public Content getContent()
  {
    return this.d;
  }
  
  public CurrentCity getCurrentCity()
  {
    return this.f;
  }
  
  public int getOffline()
  {
    return this.h;
  }
  
  public Option getOption()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int k = 0;
    if (hasOption()) {
      k = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    int j = k;
    if (hasContent()) {
      j = k + CodedOutputStreamMicro.computeMessageSize(2, getContent());
    }
    k = j;
    if (hasCurrentCity()) {
      k = j + CodedOutputStreamMicro.computeMessageSize(3, getCurrentCity());
    }
    j = k;
    if (hasOffline()) {
      j = k + CodedOutputStreamMicro.computeInt32Size(4, getOffline());
    }
    this.i = j;
    return j;
  }
  
  public boolean hasContent()
  {
    return this.c;
  }
  
  public boolean hasCurrentCity()
  {
    return this.e;
  }
  
  public boolean hasOffline()
  {
    return this.g;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Inf mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int j = paramCodedInputStreamMicro.readTag();
      Object localObject;
      switch (j)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
        break;
      case 0: 
        return this;
      case 10: 
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 18: 
        localObject = new Content();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setContent((Content)localObject);
        break;
      case 26: 
        localObject = new CurrentCity();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setCurrentCity((CurrentCity)localObject);
        break;
      case 32: 
        setOffline(paramCodedInputStreamMicro.readInt32());
      }
    }
  }
  
  public Inf setContent(Content paramContent)
  {
    if (paramContent == null) {
      return clearContent();
    }
    this.c = true;
    this.d = paramContent;
    return this;
  }
  
  public Inf setCurrentCity(CurrentCity paramCurrentCity)
  {
    if (paramCurrentCity == null) {
      return clearCurrentCity();
    }
    this.e = true;
    this.f = paramCurrentCity;
    return this;
  }
  
  public Inf setOffline(int paramInt)
  {
    this.g = true;
    this.h = paramInt;
    return this;
  }
  
  public Inf setOption(Option paramOption)
  {
    if (paramOption == null) {
      return clearOption();
    }
    this.a = true;
    this.b = paramOption;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasOption()) {
      paramCodedOutputStreamMicro.writeMessage(1, getOption());
    }
    if (hasContent()) {
      paramCodedOutputStreamMicro.writeMessage(2, getContent());
    }
    if (hasCurrentCity()) {
      paramCodedOutputStreamMicro.writeMessage(3, getCurrentCity());
    }
    if (hasOffline()) {
      paramCodedOutputStreamMicro.writeInt32(4, getOffline());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int ADDR_FIELD_NUMBER = 1;
    public static final int ALIAS_FIELD_NUMBER = 18;
    public static final int AOI_FIELD_NUMBER = 19;
    public static final int AREA_FIELD_NUMBER = 14;
    public static final int BAR_TEMPLATE_FIELD_NUMBER = 46;
    public static final int BLINFO_FIELD_NUMBER = 17;
    public static final int BUTTON_FIELD_NUMBER = 42;
    public static final int CITY_ID_FIELD_NUMBER = 2;
    public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 38;
    public static final int CP_FIELD_NUMBER = 20;
    public static final int DETAIL_FIELD_NUMBER = 21;
    public static final int DYNAMICCLICK_FIELD_NUMBER = 45;
    public static final int EXT_FIELD_NUMBER = 3;
    public static final int EXT_TYPE_FIELD_NUMBER = 4;
    public static final int GEO_FIELD_NUMBER = 5;
    public static final int HEAD_ICON_FIELD_NUMBER = 50;
    public static final int HEAT_MAP_FIELD_NUMBER = 33;
    public static final int ICON_ID_FIELD_NUMBER = 40;
    public static final int INDOOR_FLOOR_FIELD_NUMBER = 36;
    public static final int INDOOR_OVER_LOOKING_FIELD_NUMBER = 51;
    public static final int INDOOR_PANO_FIELD_NUMBER = 22;
    public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 37;
    public static final int ISMODIFIED_FIELD_NUMBER = 44;
    public static final int NAME_FIELD_NUMBER = 6;
    public static final int NEW_CATALOG_ID_FIELD_NUMBER = 23;
    public static final int ORIGIN_ID_FIELD_NUMBER = 24;
    public static final int OTHER_STATIONS_FIELD_NUMBER = 39;
    public static final int PANO_FIELD_NUMBER = 25;
    public static final int PHONE_FIELD_NUMBER = 15;
    public static final int PHOTO_LIST_FIELD_NUMBER = 49;
    public static final int POITYPE_FIELD_NUMBER = 7;
    public static final int POI_TYPE_TEXT_FIELD_NUMBER = 32;
    public static final int PRIMARY_UID_FIELD_NUMBER = 8;
    public static final int RP_DES_FIELD_NUMBER = 26;
    public static final int RP_DES_TYPE_FIELD_NUMBER = 9;
    public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 31;
    public static final int SERVICE_TAG_FIELD_NUMBER = 48;
    public static final int STATION_NUM_FIELD_NUMBER = 41;
    public static final int STATUS_FIELD_NUMBER = 10;
    public static final int STD_TAG_FIELD_NUMBER = 47;
    public static final int STORAGE_SRC_FIELD_NUMBER = 11;
    public static final int STREET_ID_FIELD_NUMBER = 27;
    public static final int SUSPECTED_FLAG_FIELD_NUMBER = 12;
    public static final int TAG_FIELD_NUMBER = 28;
    public static final int TEL_FIELD_NUMBER = 29;
    public static final int TY_FIELD_NUMBER = 30;
    public static final int UID_FIELD_NUMBER = 13;
    public static final int VISTA_FIELD_NUMBER = 16;
    private String A = "";
    private boolean B;
    private int C = 0;
    private boolean D;
    private String E = "";
    private boolean F;
    private int G = 0;
    private boolean H;
    private String I = "";
    private boolean J;
    private String K = "";
    private List<String> L = Collections.emptyList();
    private boolean M;
    private String N = "";
    private boolean O;
    private String P = "";
    private boolean Q;
    private int R = 0;
    private boolean S;
    private String T = "";
    private boolean U;
    private String V = "";
    private boolean W;
    private int X = 0;
    private boolean Y;
    private String Z = "";
    private boolean a;
    private int aA = 0;
    private boolean aB;
    private ByteStringMicro aC = ByteStringMicro.EMPTY;
    private boolean aD;
    private ByteStringMicro aE = ByteStringMicro.EMPTY;
    private boolean aF;
    private String aG = "";
    private boolean aH;
    private String aI = "";
    private boolean aJ;
    private String aK = "";
    private boolean aL;
    private HeadIcon aM = null;
    private boolean aN;
    private int aO = 0;
    private int aP = -1;
    private boolean aa;
    private String ab = "";
    private boolean ac;
    private String ad = "";
    private boolean ae;
    private String af = "";
    private boolean ag;
    private int ah = 0;
    private boolean ai;
    private int aj = 0;
    private boolean ak;
    private String al = "";
    private boolean am;
    private String an = "";
    private boolean ao;
    private String ap = "";
    private boolean aq;
    private ByteStringMicro ar = ByteStringMicro.EMPTY;
    private List<OtherStations> as = Collections.emptyList();
    private boolean at;
    private int au = 0;
    private boolean av;
    private String aw = "";
    private boolean ax;
    private Button ay = null;
    private boolean az;
    private Ext b = null;
    private List<Blinfo> c = Collections.emptyList();
    private boolean d;
    private OriginId e = null;
    private boolean f;
    private HeatMap g = null;
    private boolean h;
    private String i = "";
    private boolean j;
    private int k = 0;
    private boolean l;
    private int m = 0;
    private boolean n;
    private String o = "";
    private boolean p;
    private String q = "";
    private boolean r;
    private int s = 0;
    private boolean t;
    private String u = "";
    private boolean v;
    private int w = 0;
    private boolean x;
    private int y = 0;
    private boolean z;
    
    public static Content parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Content().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Content parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Content)new Content().mergeFrom(paramArrayOfByte);
    }
    
    public Content addAlias(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.L.isEmpty()) {
        this.L = new ArrayList();
      }
      this.L.add(paramString);
      return this;
    }
    
    public Content addBlinfo(Blinfo paramBlinfo)
    {
      if (paramBlinfo == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramBlinfo);
      return this;
    }
    
    public Content addOtherStations(OtherStations paramOtherStations)
    {
      if (paramOtherStations == null) {
        return this;
      }
      if (this.as.isEmpty()) {
        this.as = new ArrayList();
      }
      this.as.add(paramOtherStations);
      return this;
    }
    
    public final Content clear()
    {
      clearExt();
      clearBlinfo();
      clearOriginId();
      clearHeatMap();
      clearAddr();
      clearCityId();
      clearExtType();
      clearGeo();
      clearName();
      clearPoiType();
      clearPrimaryUid();
      clearRpDesType();
      clearStatus();
      clearStorageSrc();
      clearSuspectedFlag();
      clearUid();
      clearArea();
      clearPhone();
      clearVista();
      clearAlias();
      clearAoi();
      clearCp();
      clearDetail();
      clearIndoorPano();
      clearNewCatalogId();
      clearPano();
      clearRpDes();
      clearStreetId();
      clearTag();
      clearTel();
      clearTy();
      clearRtbusUpdateTime();
      clearPoiTypeText();
      clearIndoorFloor();
      clearIndoorParentUid();
      clearCloudTemplate();
      clearOtherStations();
      clearIconId();
      clearStationNum();
      clearButton();
      clearIsmodified();
      clearDynamicclick();
      clearBarTemplate();
      clearStdTag();
      clearServiceTag();
      clearPhotoList();
      clearHeadIcon();
      clearIndoorOverLooking();
      this.aP = -1;
      return this;
    }
    
    public Content clearAddr()
    {
      this.h = false;
      this.i = "";
      return this;
    }
    
    public Content clearAlias()
    {
      this.L = Collections.emptyList();
      return this;
    }
    
    public Content clearAoi()
    {
      this.M = false;
      this.N = "";
      return this;
    }
    
    public Content clearArea()
    {
      this.F = false;
      this.G = 0;
      return this;
    }
    
    public Content clearBarTemplate()
    {
      this.aD = false;
      this.aE = ByteStringMicro.EMPTY;
      return this;
    }
    
    public Content clearBlinfo()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public Content clearButton()
    {
      this.ax = false;
      this.ay = null;
      return this;
    }
    
    public Content clearCityId()
    {
      this.j = false;
      this.k = 0;
      return this;
    }
    
    public Content clearCloudTemplate()
    {
      this.aq = false;
      this.ar = ByteStringMicro.EMPTY;
      return this;
    }
    
    public Content clearCp()
    {
      this.O = false;
      this.P = "";
      return this;
    }
    
    public Content clearDetail()
    {
      this.Q = false;
      this.R = 0;
      return this;
    }
    
    public Content clearDynamicclick()
    {
      this.aB = false;
      this.aC = ByteStringMicro.EMPTY;
      return this;
    }
    
    public Content clearExt()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public Content clearExtType()
    {
      this.l = false;
      this.m = 0;
      return this;
    }
    
    public Content clearGeo()
    {
      this.n = false;
      this.o = "";
      return this;
    }
    
    public Content clearHeadIcon()
    {
      this.aL = false;
      this.aM = null;
      return this;
    }
    
    public Content clearHeatMap()
    {
      this.f = false;
      this.g = null;
      return this;
    }
    
    public Content clearIconId()
    {
      this.at = false;
      this.au = 0;
      return this;
    }
    
    public Content clearIndoorFloor()
    {
      this.am = false;
      this.an = "";
      return this;
    }
    
    public Content clearIndoorOverLooking()
    {
      this.aN = false;
      this.aO = 0;
      return this;
    }
    
    public Content clearIndoorPano()
    {
      this.S = false;
      this.T = "";
      return this;
    }
    
    public Content clearIndoorParentUid()
    {
      this.ao = false;
      this.ap = "";
      return this;
    }
    
    public Content clearIsmodified()
    {
      this.az = false;
      this.aA = 0;
      return this;
    }
    
    public Content clearName()
    {
      this.p = false;
      this.q = "";
      return this;
    }
    
    public Content clearNewCatalogId()
    {
      this.U = false;
      this.V = "";
      return this;
    }
    
    public Content clearOriginId()
    {
      this.d = false;
      this.e = null;
      return this;
    }
    
    public Content clearOtherStations()
    {
      this.as = Collections.emptyList();
      return this;
    }
    
    public Content clearPano()
    {
      this.W = false;
      this.X = 0;
      return this;
    }
    
    public Content clearPhone()
    {
      this.H = false;
      this.I = "";
      return this;
    }
    
    public Content clearPhotoList()
    {
      this.aJ = false;
      this.aK = "";
      return this;
    }
    
    public Content clearPoiType()
    {
      this.r = false;
      this.s = 0;
      return this;
    }
    
    public Content clearPoiTypeText()
    {
      this.ak = false;
      this.al = "";
      return this;
    }
    
    public Content clearPrimaryUid()
    {
      this.t = false;
      this.u = "";
      return this;
    }
    
    public Content clearRpDes()
    {
      this.Y = false;
      this.Z = "";
      return this;
    }
    
    public Content clearRpDesType()
    {
      this.v = false;
      this.w = 0;
      return this;
    }
    
    public Content clearRtbusUpdateTime()
    {
      this.ai = false;
      this.aj = 0;
      return this;
    }
    
    public Content clearServiceTag()
    {
      this.aH = false;
      this.aI = "";
      return this;
    }
    
    public Content clearStationNum()
    {
      this.av = false;
      this.aw = "";
      return this;
    }
    
    public Content clearStatus()
    {
      this.x = false;
      this.y = 0;
      return this;
    }
    
    public Content clearStdTag()
    {
      this.aF = false;
      this.aG = "";
      return this;
    }
    
    public Content clearStorageSrc()
    {
      this.z = false;
      this.A = "";
      return this;
    }
    
    public Content clearStreetId()
    {
      this.aa = false;
      this.ab = "";
      return this;
    }
    
    public Content clearSuspectedFlag()
    {
      this.B = false;
      this.C = 0;
      return this;
    }
    
    public Content clearTag()
    {
      this.ac = false;
      this.ad = "";
      return this;
    }
    
    public Content clearTel()
    {
      this.ae = false;
      this.af = "";
      return this;
    }
    
    public Content clearTy()
    {
      this.ag = false;
      this.ah = 0;
      return this;
    }
    
    public Content clearUid()
    {
      this.D = false;
      this.E = "";
      return this;
    }
    
    public Content clearVista()
    {
      this.J = false;
      this.K = "";
      return this;
    }
    
    public String getAddr()
    {
      return this.i;
    }
    
    public String getAlias(int paramInt)
    {
      return (String)this.L.get(paramInt);
    }
    
    public int getAliasCount()
    {
      return this.L.size();
    }
    
    public List<String> getAliasList()
    {
      return this.L;
    }
    
    public String getAoi()
    {
      return this.N;
    }
    
    public int getArea()
    {
      return this.G;
    }
    
    public ByteStringMicro getBarTemplate()
    {
      return this.aE;
    }
    
    public Blinfo getBlinfo(int paramInt)
    {
      return (Blinfo)this.c.get(paramInt);
    }
    
    public int getBlinfoCount()
    {
      return this.c.size();
    }
    
    public List<Blinfo> getBlinfoList()
    {
      return this.c;
    }
    
    public Button getButton()
    {
      return this.ay;
    }
    
    public int getCachedSize()
    {
      if (this.aP < 0) {
        getSerializedSize();
      }
      return this.aP;
    }
    
    public int getCityId()
    {
      return this.k;
    }
    
    public ByteStringMicro getCloudTemplate()
    {
      return this.ar;
    }
    
    public String getCp()
    {
      return this.P;
    }
    
    public int getDetail()
    {
      return this.R;
    }
    
    public ByteStringMicro getDynamicclick()
    {
      return this.aC;
    }
    
    public Ext getExt()
    {
      return this.b;
    }
    
    public int getExtType()
    {
      return this.m;
    }
    
    public String getGeo()
    {
      return this.o;
    }
    
    public HeadIcon getHeadIcon()
    {
      return this.aM;
    }
    
    public HeatMap getHeatMap()
    {
      return this.g;
    }
    
    public int getIconId()
    {
      return this.au;
    }
    
    public String getIndoorFloor()
    {
      return this.an;
    }
    
    public int getIndoorOverLooking()
    {
      return this.aO;
    }
    
    public String getIndoorPano()
    {
      return this.T;
    }
    
    public String getIndoorParentUid()
    {
      return this.ap;
    }
    
    public int getIsmodified()
    {
      return this.aA;
    }
    
    public String getName()
    {
      return this.q;
    }
    
    public String getNewCatalogId()
    {
      return this.V;
    }
    
    public OriginId getOriginId()
    {
      return this.e;
    }
    
    public OtherStations getOtherStations(int paramInt)
    {
      return (OtherStations)this.as.get(paramInt);
    }
    
    public int getOtherStationsCount()
    {
      return this.as.size();
    }
    
    public List<OtherStations> getOtherStationsList()
    {
      return this.as;
    }
    
    public int getPano()
    {
      return this.X;
    }
    
    public String getPhone()
    {
      return this.I;
    }
    
    public String getPhotoList()
    {
      return this.aK;
    }
    
    public int getPoiType()
    {
      return this.s;
    }
    
    public String getPoiTypeText()
    {
      return this.al;
    }
    
    public String getPrimaryUid()
    {
      return this.u;
    }
    
    public String getRpDes()
    {
      return this.Z;
    }
    
    public int getRpDesType()
    {
      return this.w;
    }
    
    public int getRtbusUpdateTime()
    {
      return this.aj;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasAddr()) {}
      for (int i2 = CodedOutputStreamMicro.computeStringSize(1, getAddr()) + 0;; i2 = 0)
      {
        int i1 = i2;
        if (hasCityId()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getCityId());
        }
        i2 = i1;
        if (hasExt()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(3, getExt());
        }
        i1 = i2;
        if (hasExtType()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getExtType());
        }
        i2 = i1;
        if (hasGeo()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getGeo());
        }
        i1 = i2;
        if (hasName()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getName());
        }
        i2 = i1;
        if (hasPoiType()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getPoiType());
        }
        i1 = i2;
        if (hasPrimaryUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getPrimaryUid());
        }
        i2 = i1;
        if (hasRpDesType()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getRpDesType());
        }
        i1 = i2;
        if (hasStatus()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getStatus());
        }
        i2 = i1;
        if (hasStorageSrc()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getStorageSrc());
        }
        i1 = i2;
        if (hasSuspectedFlag()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getSuspectedFlag());
        }
        i2 = i1;
        if (hasUid()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getUid());
        }
        i1 = i2;
        if (hasArea()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(14, getArea());
        }
        i2 = i1;
        if (hasPhone()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getPhone());
        }
        i1 = i2;
        if (hasVista()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getVista());
        }
        Iterator localIterator = getBlinfoList().iterator();
        while (localIterator.hasNext()) {
          i1 = CodedOutputStreamMicro.computeMessageSize(17, (Blinfo)localIterator.next()) + i1;
        }
        localIterator = getAliasList().iterator();
        i2 = i3;
        while (localIterator.hasNext()) {
          i2 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
        }
        i2 = i1 + i2 + getAliasList().size() * 2;
        i1 = i2;
        if (hasAoi()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(19, getAoi());
        }
        i2 = i1;
        if (hasCp()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(20, getCp());
        }
        i1 = i2;
        if (hasDetail()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(21, getDetail());
        }
        i2 = i1;
        if (hasIndoorPano()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(22, getIndoorPano());
        }
        i1 = i2;
        if (hasNewCatalogId()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(23, getNewCatalogId());
        }
        i2 = i1;
        if (hasOriginId()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(24, getOriginId());
        }
        i1 = i2;
        if (hasPano()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(25, getPano());
        }
        i2 = i1;
        if (hasRpDes()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(26, getRpDes());
        }
        i1 = i2;
        if (hasStreetId()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(27, getStreetId());
        }
        i2 = i1;
        if (hasTag()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(28, getTag());
        }
        i1 = i2;
        if (hasTel()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(29, getTel());
        }
        i2 = i1;
        if (hasTy()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(30, getTy());
        }
        i1 = i2;
        if (hasRtbusUpdateTime()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(31, getRtbusUpdateTime());
        }
        i2 = i1;
        if (hasPoiTypeText()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(32, getPoiTypeText());
        }
        i1 = i2;
        if (hasHeatMap()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(33, getHeatMap());
        }
        i2 = i1;
        if (hasIndoorFloor()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(36, getIndoorFloor());
        }
        i1 = i2;
        if (hasIndoorParentUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(37, getIndoorParentUid());
        }
        i2 = i1;
        if (hasCloudTemplate()) {
          i2 = i1 + CodedOutputStreamMicro.computeBytesSize(38, getCloudTemplate());
        }
        localIterator = getOtherStationsList().iterator();
        while (localIterator.hasNext()) {
          i2 = CodedOutputStreamMicro.computeMessageSize(39, (OtherStations)localIterator.next()) + i2;
        }
        i1 = i2;
        if (hasIconId()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(40, getIconId());
        }
        i2 = i1;
        if (hasStationNum()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(41, getStationNum());
        }
        i1 = i2;
        if (hasButton()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(42, getButton());
        }
        i2 = i1;
        if (hasIsmodified()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(44, getIsmodified());
        }
        i1 = i2;
        if (hasDynamicclick()) {
          i1 = i2 + CodedOutputStreamMicro.computeBytesSize(45, getDynamicclick());
        }
        i2 = i1;
        if (hasBarTemplate()) {
          i2 = i1 + CodedOutputStreamMicro.computeBytesSize(46, getBarTemplate());
        }
        i1 = i2;
        if (hasStdTag()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(47, getStdTag());
        }
        i2 = i1;
        if (hasServiceTag()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(48, getServiceTag());
        }
        i1 = i2;
        if (hasPhotoList()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(49, getPhotoList());
        }
        i2 = i1;
        if (hasHeadIcon()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(50, getHeadIcon());
        }
        i1 = i2;
        if (hasIndoorOverLooking()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(51, getIndoorOverLooking());
        }
        this.aP = i1;
        return i1;
      }
    }
    
    public String getServiceTag()
    {
      return this.aI;
    }
    
    public String getStationNum()
    {
      return this.aw;
    }
    
    public int getStatus()
    {
      return this.y;
    }
    
    public String getStdTag()
    {
      return this.aG;
    }
    
    public String getStorageSrc()
    {
      return this.A;
    }
    
    public String getStreetId()
    {
      return this.ab;
    }
    
    public int getSuspectedFlag()
    {
      return this.C;
    }
    
    public String getTag()
    {
      return this.ad;
    }
    
    public String getTel()
    {
      return this.af;
    }
    
    public int getTy()
    {
      return this.ah;
    }
    
    public String getUid()
    {
      return this.E;
    }
    
    public String getVista()
    {
      return this.K;
    }
    
    public boolean hasAddr()
    {
      return this.h;
    }
    
    public boolean hasAoi()
    {
      return this.M;
    }
    
    public boolean hasArea()
    {
      return this.F;
    }
    
    public boolean hasBarTemplate()
    {
      return this.aD;
    }
    
    public boolean hasButton()
    {
      return this.ax;
    }
    
    public boolean hasCityId()
    {
      return this.j;
    }
    
    public boolean hasCloudTemplate()
    {
      return this.aq;
    }
    
    public boolean hasCp()
    {
      return this.O;
    }
    
    public boolean hasDetail()
    {
      return this.Q;
    }
    
    public boolean hasDynamicclick()
    {
      return this.aB;
    }
    
    public boolean hasExt()
    {
      return this.a;
    }
    
    public boolean hasExtType()
    {
      return this.l;
    }
    
    public boolean hasGeo()
    {
      return this.n;
    }
    
    public boolean hasHeadIcon()
    {
      return this.aL;
    }
    
    public boolean hasHeatMap()
    {
      return this.f;
    }
    
    public boolean hasIconId()
    {
      return this.at;
    }
    
    public boolean hasIndoorFloor()
    {
      return this.am;
    }
    
    public boolean hasIndoorOverLooking()
    {
      return this.aN;
    }
    
    public boolean hasIndoorPano()
    {
      return this.S;
    }
    
    public boolean hasIndoorParentUid()
    {
      return this.ao;
    }
    
    public boolean hasIsmodified()
    {
      return this.az;
    }
    
    public boolean hasName()
    {
      return this.p;
    }
    
    public boolean hasNewCatalogId()
    {
      return this.U;
    }
    
    public boolean hasOriginId()
    {
      return this.d;
    }
    
    public boolean hasPano()
    {
      return this.W;
    }
    
    public boolean hasPhone()
    {
      return this.H;
    }
    
    public boolean hasPhotoList()
    {
      return this.aJ;
    }
    
    public boolean hasPoiType()
    {
      return this.r;
    }
    
    public boolean hasPoiTypeText()
    {
      return this.ak;
    }
    
    public boolean hasPrimaryUid()
    {
      return this.t;
    }
    
    public boolean hasRpDes()
    {
      return this.Y;
    }
    
    public boolean hasRpDesType()
    {
      return this.v;
    }
    
    public boolean hasRtbusUpdateTime()
    {
      return this.ai;
    }
    
    public boolean hasServiceTag()
    {
      return this.aH;
    }
    
    public boolean hasStationNum()
    {
      return this.av;
    }
    
    public boolean hasStatus()
    {
      return this.x;
    }
    
    public boolean hasStdTag()
    {
      return this.aF;
    }
    
    public boolean hasStorageSrc()
    {
      return this.z;
    }
    
    public boolean hasStreetId()
    {
      return this.aa;
    }
    
    public boolean hasSuspectedFlag()
    {
      return this.B;
    }
    
    public boolean hasTag()
    {
      return this.ac;
    }
    
    public boolean hasTel()
    {
      return this.ae;
    }
    
    public boolean hasTy()
    {
      return this.ag;
    }
    
    public boolean hasUid()
    {
      return this.D;
    }
    
    public boolean hasVista()
    {
      return this.J;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Content mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setAddr(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setCityId(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          localObject = new Ext();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setExt((Ext)localObject);
          break;
        case 32: 
          setExtType(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setGeo(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 56: 
          setPoiType(paramCodedInputStreamMicro.readInt32());
          break;
        case 66: 
          setPrimaryUid(paramCodedInputStreamMicro.readString());
          break;
        case 72: 
          setRpDesType(paramCodedInputStreamMicro.readInt32());
          break;
        case 80: 
          setStatus(paramCodedInputStreamMicro.readInt32());
          break;
        case 90: 
          setStorageSrc(paramCodedInputStreamMicro.readString());
          break;
        case 96: 
          setSuspectedFlag(paramCodedInputStreamMicro.readInt32());
          break;
        case 106: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 112: 
          setArea(paramCodedInputStreamMicro.readInt32());
          break;
        case 122: 
          setPhone(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setVista(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          localObject = new Blinfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addBlinfo((Blinfo)localObject);
          break;
        case 146: 
          addAlias(paramCodedInputStreamMicro.readString());
          break;
        case 154: 
          setAoi(paramCodedInputStreamMicro.readString());
          break;
        case 162: 
          setCp(paramCodedInputStreamMicro.readString());
          break;
        case 168: 
          setDetail(paramCodedInputStreamMicro.readInt32());
          break;
        case 178: 
          setIndoorPano(paramCodedInputStreamMicro.readString());
          break;
        case 186: 
          setNewCatalogId(paramCodedInputStreamMicro.readString());
          break;
        case 194: 
          localObject = new OriginId();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setOriginId((OriginId)localObject);
          break;
        case 200: 
          setPano(paramCodedInputStreamMicro.readInt32());
          break;
        case 210: 
          setRpDes(paramCodedInputStreamMicro.readString());
          break;
        case 218: 
          setStreetId(paramCodedInputStreamMicro.readString());
          break;
        case 226: 
          setTag(paramCodedInputStreamMicro.readString());
          break;
        case 234: 
          setTel(paramCodedInputStreamMicro.readString());
          break;
        case 240: 
          setTy(paramCodedInputStreamMicro.readInt32());
          break;
        case 248: 
          setRtbusUpdateTime(paramCodedInputStreamMicro.readInt32());
          break;
        case 258: 
          setPoiTypeText(paramCodedInputStreamMicro.readString());
          break;
        case 266: 
          localObject = new HeatMap();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setHeatMap((HeatMap)localObject);
          break;
        case 290: 
          setIndoorFloor(paramCodedInputStreamMicro.readString());
          break;
        case 298: 
          setIndoorParentUid(paramCodedInputStreamMicro.readString());
          break;
        case 306: 
          setCloudTemplate(paramCodedInputStreamMicro.readBytes());
          break;
        case 314: 
          localObject = new OtherStations();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addOtherStations((OtherStations)localObject);
          break;
        case 320: 
          setIconId(paramCodedInputStreamMicro.readInt32());
          break;
        case 330: 
          setStationNum(paramCodedInputStreamMicro.readString());
          break;
        case 338: 
          localObject = new Button();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setButton((Button)localObject);
          break;
        case 352: 
          setIsmodified(paramCodedInputStreamMicro.readInt32());
          break;
        case 362: 
          setDynamicclick(paramCodedInputStreamMicro.readBytes());
          break;
        case 370: 
          setBarTemplate(paramCodedInputStreamMicro.readBytes());
          break;
        case 378: 
          setStdTag(paramCodedInputStreamMicro.readString());
          break;
        case 386: 
          setServiceTag(paramCodedInputStreamMicro.readString());
          break;
        case 394: 
          setPhotoList(paramCodedInputStreamMicro.readString());
          break;
        case 402: 
          localObject = new HeadIcon();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setHeadIcon((HeadIcon)localObject);
          break;
        case 408: 
          setIndoorOverLooking(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Content setAddr(String paramString)
    {
      this.h = true;
      this.i = paramString;
      return this;
    }
    
    public Content setAlias(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.L.set(paramInt, paramString);
      return this;
    }
    
    public Content setAoi(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }
    
    public Content setArea(int paramInt)
    {
      this.F = true;
      this.G = paramInt;
      return this;
    }
    
    public Content setBarTemplate(ByteStringMicro paramByteStringMicro)
    {
      this.aD = true;
      this.aE = paramByteStringMicro;
      return this;
    }
    
    public Content setBlinfo(int paramInt, Blinfo paramBlinfo)
    {
      if (paramBlinfo == null) {
        return this;
      }
      this.c.set(paramInt, paramBlinfo);
      return this;
    }
    
    public Content setButton(Button paramButton)
    {
      if (paramButton == null) {
        return clearButton();
      }
      this.ax = true;
      this.ay = paramButton;
      return this;
    }
    
    public Content setCityId(int paramInt)
    {
      this.j = true;
      this.k = paramInt;
      return this;
    }
    
    public Content setCloudTemplate(ByteStringMicro paramByteStringMicro)
    {
      this.aq = true;
      this.ar = paramByteStringMicro;
      return this;
    }
    
    public Content setCp(String paramString)
    {
      this.O = true;
      this.P = paramString;
      return this;
    }
    
    public Content setDetail(int paramInt)
    {
      this.Q = true;
      this.R = paramInt;
      return this;
    }
    
    public Content setDynamicclick(ByteStringMicro paramByteStringMicro)
    {
      this.aB = true;
      this.aC = paramByteStringMicro;
      return this;
    }
    
    public Content setExt(Ext paramExt)
    {
      if (paramExt == null) {
        return clearExt();
      }
      this.a = true;
      this.b = paramExt;
      return this;
    }
    
    public Content setExtType(int paramInt)
    {
      this.l = true;
      this.m = paramInt;
      return this;
    }
    
    public Content setGeo(String paramString)
    {
      this.n = true;
      this.o = paramString;
      return this;
    }
    
    public Content setHeadIcon(HeadIcon paramHeadIcon)
    {
      if (paramHeadIcon == null) {
        return clearHeadIcon();
      }
      this.aL = true;
      this.aM = paramHeadIcon;
      return this;
    }
    
    public Content setHeatMap(HeatMap paramHeatMap)
    {
      if (paramHeatMap == null) {
        return clearHeatMap();
      }
      this.f = true;
      this.g = paramHeatMap;
      return this;
    }
    
    public Content setIconId(int paramInt)
    {
      this.at = true;
      this.au = paramInt;
      return this;
    }
    
    public Content setIndoorFloor(String paramString)
    {
      this.am = true;
      this.an = paramString;
      return this;
    }
    
    public Content setIndoorOverLooking(int paramInt)
    {
      this.aN = true;
      this.aO = paramInt;
      return this;
    }
    
    public Content setIndoorPano(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }
    
    public Content setIndoorParentUid(String paramString)
    {
      this.ao = true;
      this.ap = paramString;
      return this;
    }
    
    public Content setIsmodified(int paramInt)
    {
      this.az = true;
      this.aA = paramInt;
      return this;
    }
    
    public Content setName(String paramString)
    {
      this.p = true;
      this.q = paramString;
      return this;
    }
    
    public Content setNewCatalogId(String paramString)
    {
      this.U = true;
      this.V = paramString;
      return this;
    }
    
    public Content setOriginId(OriginId paramOriginId)
    {
      if (paramOriginId == null) {
        return clearOriginId();
      }
      this.d = true;
      this.e = paramOriginId;
      return this;
    }
    
    public Content setOtherStations(int paramInt, OtherStations paramOtherStations)
    {
      if (paramOtherStations == null) {
        return this;
      }
      this.as.set(paramInt, paramOtherStations);
      return this;
    }
    
    public Content setPano(int paramInt)
    {
      this.W = true;
      this.X = paramInt;
      return this;
    }
    
    public Content setPhone(String paramString)
    {
      this.H = true;
      this.I = paramString;
      return this;
    }
    
    public Content setPhotoList(String paramString)
    {
      this.aJ = true;
      this.aK = paramString;
      return this;
    }
    
    public Content setPoiType(int paramInt)
    {
      this.r = true;
      this.s = paramInt;
      return this;
    }
    
    public Content setPoiTypeText(String paramString)
    {
      this.ak = true;
      this.al = paramString;
      return this;
    }
    
    public Content setPrimaryUid(String paramString)
    {
      this.t = true;
      this.u = paramString;
      return this;
    }
    
    public Content setRpDes(String paramString)
    {
      this.Y = true;
      this.Z = paramString;
      return this;
    }
    
    public Content setRpDesType(int paramInt)
    {
      this.v = true;
      this.w = paramInt;
      return this;
    }
    
    public Content setRtbusUpdateTime(int paramInt)
    {
      this.ai = true;
      this.aj = paramInt;
      return this;
    }
    
    public Content setServiceTag(String paramString)
    {
      this.aH = true;
      this.aI = paramString;
      return this;
    }
    
    public Content setStationNum(String paramString)
    {
      this.av = true;
      this.aw = paramString;
      return this;
    }
    
    public Content setStatus(int paramInt)
    {
      this.x = true;
      this.y = paramInt;
      return this;
    }
    
    public Content setStdTag(String paramString)
    {
      this.aF = true;
      this.aG = paramString;
      return this;
    }
    
    public Content setStorageSrc(String paramString)
    {
      this.z = true;
      this.A = paramString;
      return this;
    }
    
    public Content setStreetId(String paramString)
    {
      this.aa = true;
      this.ab = paramString;
      return this;
    }
    
    public Content setSuspectedFlag(int paramInt)
    {
      this.B = true;
      this.C = paramInt;
      return this;
    }
    
    public Content setTag(String paramString)
    {
      this.ac = true;
      this.ad = paramString;
      return this;
    }
    
    public Content setTel(String paramString)
    {
      this.ae = true;
      this.af = paramString;
      return this;
    }
    
    public Content setTy(int paramInt)
    {
      this.ag = true;
      this.ah = paramInt;
      return this;
    }
    
    public Content setUid(String paramString)
    {
      this.D = true;
      this.E = paramString;
      return this;
    }
    
    public Content setVista(String paramString)
    {
      this.J = true;
      this.K = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAddr()) {
        paramCodedOutputStreamMicro.writeString(1, getAddr());
      }
      if (hasCityId()) {
        paramCodedOutputStreamMicro.writeInt32(2, getCityId());
      }
      if (hasExt()) {
        paramCodedOutputStreamMicro.writeMessage(3, getExt());
      }
      if (hasExtType()) {
        paramCodedOutputStreamMicro.writeInt32(4, getExtType());
      }
      if (hasGeo()) {
        paramCodedOutputStreamMicro.writeString(5, getGeo());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(6, getName());
      }
      if (hasPoiType()) {
        paramCodedOutputStreamMicro.writeInt32(7, getPoiType());
      }
      if (hasPrimaryUid()) {
        paramCodedOutputStreamMicro.writeString(8, getPrimaryUid());
      }
      if (hasRpDesType()) {
        paramCodedOutputStreamMicro.writeInt32(9, getRpDesType());
      }
      if (hasStatus()) {
        paramCodedOutputStreamMicro.writeInt32(10, getStatus());
      }
      if (hasStorageSrc()) {
        paramCodedOutputStreamMicro.writeString(11, getStorageSrc());
      }
      if (hasSuspectedFlag()) {
        paramCodedOutputStreamMicro.writeInt32(12, getSuspectedFlag());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(13, getUid());
      }
      if (hasArea()) {
        paramCodedOutputStreamMicro.writeInt32(14, getArea());
      }
      if (hasPhone()) {
        paramCodedOutputStreamMicro.writeString(15, getPhone());
      }
      if (hasVista()) {
        paramCodedOutputStreamMicro.writeString(16, getVista());
      }
      Iterator localIterator = getBlinfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(17, (Blinfo)localIterator.next());
      }
      localIterator = getAliasList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(18, (String)localIterator.next());
      }
      if (hasAoi()) {
        paramCodedOutputStreamMicro.writeString(19, getAoi());
      }
      if (hasCp()) {
        paramCodedOutputStreamMicro.writeString(20, getCp());
      }
      if (hasDetail()) {
        paramCodedOutputStreamMicro.writeInt32(21, getDetail());
      }
      if (hasIndoorPano()) {
        paramCodedOutputStreamMicro.writeString(22, getIndoorPano());
      }
      if (hasNewCatalogId()) {
        paramCodedOutputStreamMicro.writeString(23, getNewCatalogId());
      }
      if (hasOriginId()) {
        paramCodedOutputStreamMicro.writeMessage(24, getOriginId());
      }
      if (hasPano()) {
        paramCodedOutputStreamMicro.writeInt32(25, getPano());
      }
      if (hasRpDes()) {
        paramCodedOutputStreamMicro.writeString(26, getRpDes());
      }
      if (hasStreetId()) {
        paramCodedOutputStreamMicro.writeString(27, getStreetId());
      }
      if (hasTag()) {
        paramCodedOutputStreamMicro.writeString(28, getTag());
      }
      if (hasTel()) {
        paramCodedOutputStreamMicro.writeString(29, getTel());
      }
      if (hasTy()) {
        paramCodedOutputStreamMicro.writeInt32(30, getTy());
      }
      if (hasRtbusUpdateTime()) {
        paramCodedOutputStreamMicro.writeInt32(31, getRtbusUpdateTime());
      }
      if (hasPoiTypeText()) {
        paramCodedOutputStreamMicro.writeString(32, getPoiTypeText());
      }
      if (hasHeatMap()) {
        paramCodedOutputStreamMicro.writeMessage(33, getHeatMap());
      }
      if (hasIndoorFloor()) {
        paramCodedOutputStreamMicro.writeString(36, getIndoorFloor());
      }
      if (hasIndoorParentUid()) {
        paramCodedOutputStreamMicro.writeString(37, getIndoorParentUid());
      }
      if (hasCloudTemplate()) {
        paramCodedOutputStreamMicro.writeBytes(38, getCloudTemplate());
      }
      localIterator = getOtherStationsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(39, (OtherStations)localIterator.next());
      }
      if (hasIconId()) {
        paramCodedOutputStreamMicro.writeInt32(40, getIconId());
      }
      if (hasStationNum()) {
        paramCodedOutputStreamMicro.writeString(41, getStationNum());
      }
      if (hasButton()) {
        paramCodedOutputStreamMicro.writeMessage(42, getButton());
      }
      if (hasIsmodified()) {
        paramCodedOutputStreamMicro.writeInt32(44, getIsmodified());
      }
      if (hasDynamicclick()) {
        paramCodedOutputStreamMicro.writeBytes(45, getDynamicclick());
      }
      if (hasBarTemplate()) {
        paramCodedOutputStreamMicro.writeBytes(46, getBarTemplate());
      }
      if (hasStdTag()) {
        paramCodedOutputStreamMicro.writeString(47, getStdTag());
      }
      if (hasServiceTag()) {
        paramCodedOutputStreamMicro.writeString(48, getServiceTag());
      }
      if (hasPhotoList()) {
        paramCodedOutputStreamMicro.writeString(49, getPhotoList());
      }
      if (hasHeadIcon()) {
        paramCodedOutputStreamMicro.writeMessage(50, getHeadIcon());
      }
      if (hasIndoorOverLooking()) {
        paramCodedOutputStreamMicro.writeInt32(51, getIndoorOverLooking());
      }
    }
    
    public static final class Blinfo
      extends MessageMicro
    {
      public static final int ADDR_FIELD_NUMBER = 1;
      public static final int ICON_ID_FIELD_NUMBER = 7;
      public static final int NAME_FIELD_NUMBER = 2;
      public static final int NEXT_STATION_FIELD_NUMBER = 6;
      public static final int PAIR_UID_FIELD_NUMBER = 5;
      public static final int RT_INFO_FIELD_NUMBER = 3;
      public static final int SON_UID_FIELD_NUMBER = 8;
      public static final int UID_FIELD_NUMBER = 4;
      private boolean a;
      private RtInfo b = null;
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private boolean i;
      private String j = "";
      private boolean k;
      private String l = "";
      private boolean m;
      private int n = 0;
      private boolean o;
      private String p = "";
      private int q = -1;
      
      public static Blinfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Blinfo().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Blinfo parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Blinfo)new Blinfo().mergeFrom(paramArrayOfByte);
      }
      
      public final Blinfo clear()
      {
        clearRtInfo();
        clearAddr();
        clearName();
        clearUid();
        clearPairUid();
        clearNextStation();
        clearIconId();
        clearSonUid();
        this.q = -1;
        return this;
      }
      
      public Blinfo clearAddr()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Blinfo clearIconId()
      {
        this.m = false;
        this.n = 0;
        return this;
      }
      
      public Blinfo clearName()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Blinfo clearNextStation()
      {
        this.k = false;
        this.l = "";
        return this;
      }
      
      public Blinfo clearPairUid()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public Blinfo clearRtInfo()
      {
        this.a = false;
        this.b = null;
        return this;
      }
      
      public Blinfo clearSonUid()
      {
        this.o = false;
        this.p = "";
        return this;
      }
      
      public Blinfo clearUid()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public String getAddr()
      {
        return this.d;
      }
      
      public int getCachedSize()
      {
        if (this.q < 0) {
          getSerializedSize();
        }
        return this.q;
      }
      
      public int getIconId()
      {
        return this.n;
      }
      
      public String getName()
      {
        return this.f;
      }
      
      public String getNextStation()
      {
        return this.l;
      }
      
      public String getPairUid()
      {
        return this.j;
      }
      
      public RtInfo getRtInfo()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasAddr()) {
          i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getAddr());
        }
        int i1 = i2;
        if (hasName()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
        }
        i2 = i1;
        if (hasRtInfo()) {
          i2 = i1 + CodedOutputStreamMicro.computeMessageSize(3, getRtInfo());
        }
        i1 = i2;
        if (hasUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getUid());
        }
        i2 = i1;
        if (hasPairUid()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getPairUid());
        }
        i1 = i2;
        if (hasNextStation()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getNextStation());
        }
        i2 = i1;
        if (hasIconId()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getIconId());
        }
        i1 = i2;
        if (hasSonUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getSonUid());
        }
        this.q = i1;
        return i1;
      }
      
      public String getSonUid()
      {
        return this.p;
      }
      
      public String getUid()
      {
        return this.h;
      }
      
      public boolean hasAddr()
      {
        return this.c;
      }
      
      public boolean hasIconId()
      {
        return this.m;
      }
      
      public boolean hasName()
      {
        return this.e;
      }
      
      public boolean hasNextStation()
      {
        return this.k;
      }
      
      public boolean hasPairUid()
      {
        return this.i;
      }
      
      public boolean hasRtInfo()
      {
        return this.a;
      }
      
      public boolean hasSonUid()
      {
        return this.o;
      }
      
      public boolean hasUid()
      {
        return this.g;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Blinfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setName(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            RtInfo localRtInfo = new RtInfo();
            paramCodedInputStreamMicro.readMessage(localRtInfo);
            setRtInfo(localRtInfo);
            break;
          case 34: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            setPairUid(paramCodedInputStreamMicro.readString());
            break;
          case 50: 
            setNextStation(paramCodedInputStreamMicro.readString());
            break;
          case 56: 
            setIconId(paramCodedInputStreamMicro.readInt32());
            break;
          case 66: 
            setSonUid(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Blinfo setAddr(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Blinfo setIconId(int paramInt)
      {
        this.m = true;
        this.n = paramInt;
        return this;
      }
      
      public Blinfo setName(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Blinfo setNextStation(String paramString)
      {
        this.k = true;
        this.l = paramString;
        return this;
      }
      
      public Blinfo setPairUid(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public Blinfo setRtInfo(RtInfo paramRtInfo)
      {
        if (paramRtInfo == null) {
          return clearRtInfo();
        }
        this.a = true;
        this.b = paramRtInfo;
        return this;
      }
      
      public Blinfo setSonUid(String paramString)
      {
        this.o = true;
        this.p = paramString;
        return this;
      }
      
      public Blinfo setUid(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasAddr()) {
          paramCodedOutputStreamMicro.writeString(1, getAddr());
        }
        if (hasName()) {
          paramCodedOutputStreamMicro.writeString(2, getName());
        }
        if (hasRtInfo()) {
          paramCodedOutputStreamMicro.writeMessage(3, getRtInfo());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(4, getUid());
        }
        if (hasPairUid()) {
          paramCodedOutputStreamMicro.writeString(5, getPairUid());
        }
        if (hasNextStation()) {
          paramCodedOutputStreamMicro.writeString(6, getNextStation());
        }
        if (hasIconId()) {
          paramCodedOutputStreamMicro.writeInt32(7, getIconId());
        }
        if (hasSonUid()) {
          paramCodedOutputStreamMicro.writeString(8, getSonUid());
        }
      }
      
      public static final class RtInfo
        extends MessageMicro
      {
        public static final int NEXT_VEHICLE_FIELD_NUMBER = 1;
        public static final int TIP_RTBUS_FIELD_NUMBER = 2;
        private boolean a;
        private NextVehicle b = null;
        private boolean c;
        private String d = "";
        private int e = -1;
        
        public static RtInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new RtInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static RtInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (RtInfo)new RtInfo().mergeFrom(paramArrayOfByte);
        }
        
        public final RtInfo clear()
        {
          clearNextVehicle();
          clearTipRtbus();
          this.e = -1;
          return this;
        }
        
        public RtInfo clearNextVehicle()
        {
          this.a = false;
          this.b = null;
          return this;
        }
        
        public RtInfo clearTipRtbus()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.e < 0) {
            getSerializedSize();
          }
          return this.e;
        }
        
        public NextVehicle getNextVehicle()
        {
          return this.b;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasNextVehicle()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getNextVehicle());
          }
          int j = i;
          if (hasTipRtbus()) {
            j = i + CodedOutputStreamMicro.computeStringSize(2, getTipRtbus());
          }
          this.e = j;
          return j;
        }
        
        public String getTipRtbus()
        {
          return this.d;
        }
        
        public boolean hasNextVehicle()
        {
          return this.a;
        }
        
        public boolean hasTipRtbus()
        {
          return this.c;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public RtInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          for (;;)
          {
            int i = paramCodedInputStreamMicro.readTag();
            switch (i)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
              break;
            case 0: 
              return this;
            case 10: 
              NextVehicle localNextVehicle = new NextVehicle();
              paramCodedInputStreamMicro.readMessage(localNextVehicle);
              setNextVehicle(localNextVehicle);
              break;
            case 18: 
              setTipRtbus(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public RtInfo setNextVehicle(NextVehicle paramNextVehicle)
        {
          if (paramNextVehicle == null) {
            return clearNextVehicle();
          }
          this.a = true;
          this.b = paramNextVehicle;
          return this;
        }
        
        public RtInfo setTipRtbus(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasNextVehicle()) {
            paramCodedOutputStreamMicro.writeMessage(1, getNextVehicle());
          }
          if (hasTipRtbus()) {
            paramCodedOutputStreamMicro.writeString(2, getTipRtbus());
          }
        }
        
        public static final class NextVehicle
          extends MessageMicro
        {
          public static final int REMAIN_DIST_FIELD_NUMBER = 1;
          public static final int REMAIN_STOPS_FIELD_NUMBER = 2;
          public static final int REMAIN_TIME_FIELD_NUMBER = 3;
          private boolean a;
          private int b = 0;
          private boolean c;
          private int d = 0;
          private boolean e;
          private int f = 0;
          private int g = -1;
          
          public static NextVehicle parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new NextVehicle().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static NextVehicle parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (NextVehicle)new NextVehicle().mergeFrom(paramArrayOfByte);
          }
          
          public final NextVehicle clear()
          {
            clearRemainDist();
            clearRemainStops();
            clearRemainTime();
            this.g = -1;
            return this;
          }
          
          public NextVehicle clearRemainDist()
          {
            this.a = false;
            this.b = 0;
            return this;
          }
          
          public NextVehicle clearRemainStops()
          {
            this.c = false;
            this.d = 0;
            return this;
          }
          
          public NextVehicle clearRemainTime()
          {
            this.e = false;
            this.f = 0;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.g < 0) {
              getSerializedSize();
            }
            return this.g;
          }
          
          public int getRemainDist()
          {
            return this.b;
          }
          
          public int getRemainStops()
          {
            return this.d;
          }
          
          public int getRemainTime()
          {
            return this.f;
          }
          
          public int getSerializedSize()
          {
            int j = 0;
            if (hasRemainDist()) {
              j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getRemainDist());
            }
            int i = j;
            if (hasRemainStops()) {
              i = j + CodedOutputStreamMicro.computeInt32Size(2, getRemainStops());
            }
            j = i;
            if (hasRemainTime()) {
              j = i + CodedOutputStreamMicro.computeInt32Size(3, getRemainTime());
            }
            this.g = j;
            return j;
          }
          
          public boolean hasRemainDist()
          {
            return this.a;
          }
          
          public boolean hasRemainStops()
          {
            return this.c;
          }
          
          public boolean hasRemainTime()
          {
            return this.e;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public NextVehicle mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 8: 
                setRemainDist(paramCodedInputStreamMicro.readInt32());
                break;
              case 16: 
                setRemainStops(paramCodedInputStreamMicro.readInt32());
                break;
              case 24: 
                setRemainTime(paramCodedInputStreamMicro.readInt32());
              }
            }
          }
          
          public NextVehicle setRemainDist(int paramInt)
          {
            this.a = true;
            this.b = paramInt;
            return this;
          }
          
          public NextVehicle setRemainStops(int paramInt)
          {
            this.c = true;
            this.d = paramInt;
            return this;
          }
          
          public NextVehicle setRemainTime(int paramInt)
          {
            this.e = true;
            this.f = paramInt;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasRemainDist()) {
              paramCodedOutputStreamMicro.writeInt32(1, getRemainDist());
            }
            if (hasRemainStops()) {
              paramCodedOutputStreamMicro.writeInt32(2, getRemainStops());
            }
            if (hasRemainTime()) {
              paramCodedOutputStreamMicro.writeInt32(3, getRemainTime());
            }
          }
        }
      }
    }
    
    public static final class Button
      extends MessageMicro
    {
      public static final int CONTENT_FIELD_NUMBER = 1;
      public static final int ICON_URL_FIELD_NUMBER = 4;
      public static final int TITLE_FIELD_NUMBER = 2;
      public static final int TYPE_FIELD_NUMBER = 3;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private int i = -1;
      
      public static Button parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Button().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Button parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Button)new Button().mergeFrom(paramArrayOfByte);
      }
      
      public final Button clear()
      {
        clearContent();
        clearTitle();
        clearType();
        clearIconUrl();
        this.i = -1;
        return this;
      }
      
      public Button clearContent()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Button clearIconUrl()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Button clearTitle()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Button clearType()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public String getContent()
      {
        return this.b;
      }
      
      public String getIconUrl()
      {
        return this.h;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasContent()) {
          k = 0 + CodedOutputStreamMicro.computeStringSize(1, getContent());
        }
        int j = k;
        if (hasTitle()) {
          j = k + CodedOutputStreamMicro.computeStringSize(2, getTitle());
        }
        k = j;
        if (hasType()) {
          k = j + CodedOutputStreamMicro.computeStringSize(3, getType());
        }
        j = k;
        if (hasIconUrl()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getIconUrl());
        }
        this.i = j;
        return j;
      }
      
      public String getTitle()
      {
        return this.d;
      }
      
      public String getType()
      {
        return this.f;
      }
      
      public boolean hasContent()
      {
        return this.a;
      }
      
      public boolean hasIconUrl()
      {
        return this.g;
      }
      
      public boolean hasTitle()
      {
        return this.c;
      }
      
      public boolean hasType()
      {
        return this.e;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Button mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int j = paramCodedInputStreamMicro.readTag();
          switch (j)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setContent(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setTitle(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setType(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setIconUrl(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Button setContent(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Button setIconUrl(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Button setTitle(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Button setType(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasContent()) {
          paramCodedOutputStreamMicro.writeString(1, getContent());
        }
        if (hasTitle()) {
          paramCodedOutputStreamMicro.writeString(2, getTitle());
        }
        if (hasType()) {
          paramCodedOutputStreamMicro.writeString(3, getType());
        }
        if (hasIconUrl()) {
          paramCodedOutputStreamMicro.writeString(4, getIconUrl());
        }
      }
    }
    
    public static final class Ext
      extends MessageMicro
    {
      public static final int DETAIL_INFO_FIELD_NUMBER = 1;
      public static final int EXT_TYPE_FIELD_NUMBER = 7;
      public static final int IMAGE_FIELD_NUMBER = 5;
      public static final int LINE_INFO_FIELD_NUMBER = 6;
      public static final int REVIEW_FIELD_NUMBER = 2;
      public static final int RICH_INFO_FIELD_NUMBER = 3;
      public static final int SRC_NAME_FIELD_NUMBER = 4;
      private boolean a;
      private DetailInfo b = null;
      private List<Review> c = Collections.emptyList();
      private boolean d;
      private RichInfo e = null;
      private boolean f;
      private Image g = null;
      private List<LineInfo> h = Collections.emptyList();
      private boolean i;
      private String j = "";
      private boolean k;
      private int l = 0;
      private int m = -1;
      
      public static Ext parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Ext().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Ext parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Ext)new Ext().mergeFrom(paramArrayOfByte);
      }
      
      public Ext addLineInfo(LineInfo paramLineInfo)
      {
        if (paramLineInfo == null) {
          return this;
        }
        if (this.h.isEmpty()) {
          this.h = new ArrayList();
        }
        this.h.add(paramLineInfo);
        return this;
      }
      
      public Ext addReview(Review paramReview)
      {
        if (paramReview == null) {
          return this;
        }
        if (this.c.isEmpty()) {
          this.c = new ArrayList();
        }
        this.c.add(paramReview);
        return this;
      }
      
      public final Ext clear()
      {
        clearDetailInfo();
        clearReview();
        clearRichInfo();
        clearImage();
        clearLineInfo();
        clearSrcName();
        clearExtType();
        this.m = -1;
        return this;
      }
      
      public Ext clearDetailInfo()
      {
        this.a = false;
        this.b = null;
        return this;
      }
      
      public Ext clearExtType()
      {
        this.k = false;
        this.l = 0;
        return this;
      }
      
      public Ext clearImage()
      {
        this.f = false;
        this.g = null;
        return this;
      }
      
      public Ext clearLineInfo()
      {
        this.h = Collections.emptyList();
        return this;
      }
      
      public Ext clearReview()
      {
        this.c = Collections.emptyList();
        return this;
      }
      
      public Ext clearRichInfo()
      {
        this.d = false;
        this.e = null;
        return this;
      }
      
      public Ext clearSrcName()
      {
        this.i = false;
        this.j = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.m < 0) {
          getSerializedSize();
        }
        return this.m;
      }
      
      public DetailInfo getDetailInfo()
      {
        return this.b;
      }
      
      public int getExtType()
      {
        return this.l;
      }
      
      public Image getImage()
      {
        return this.g;
      }
      
      public LineInfo getLineInfo(int paramInt)
      {
        return (LineInfo)this.h.get(paramInt);
      }
      
      public int getLineInfoCount()
      {
        return this.h.size();
      }
      
      public List<LineInfo> getLineInfoList()
      {
        return this.h;
      }
      
      public Review getReview(int paramInt)
      {
        return (Review)this.c.get(paramInt);
      }
      
      public int getReviewCount()
      {
        return this.c.size();
      }
      
      public List<Review> getReviewList()
      {
        return this.c;
      }
      
      public RichInfo getRichInfo()
      {
        return this.e;
      }
      
      public int getSerializedSize()
      {
        int n = 0;
        if (hasDetailInfo()) {
          n = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDetailInfo());
        }
        Iterator localIterator = getReviewList().iterator();
        for (int i1 = n; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(2, (Review)localIterator.next()) + i1) {}
        n = i1;
        if (hasRichInfo()) {
          n = i1 + CodedOutputStreamMicro.computeMessageSize(3, getRichInfo());
        }
        i1 = n;
        if (hasSrcName()) {
          i1 = n + CodedOutputStreamMicro.computeStringSize(4, getSrcName());
        }
        n = i1;
        if (hasImage()) {
          n = i1 + CodedOutputStreamMicro.computeMessageSize(5, getImage());
        }
        localIterator = getLineInfoList().iterator();
        while (localIterator.hasNext()) {
          n += CodedOutputStreamMicro.computeMessageSize(6, (LineInfo)localIterator.next());
        }
        i1 = n;
        if (hasExtType()) {
          i1 = n + CodedOutputStreamMicro.computeInt32Size(7, getExtType());
        }
        this.m = i1;
        return i1;
      }
      
      public String getSrcName()
      {
        return this.j;
      }
      
      public boolean hasDetailInfo()
      {
        return this.a;
      }
      
      public boolean hasExtType()
      {
        return this.k;
      }
      
      public boolean hasImage()
      {
        return this.f;
      }
      
      public boolean hasRichInfo()
      {
        return this.d;
      }
      
      public boolean hasSrcName()
      {
        return this.i;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Ext mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int n = paramCodedInputStreamMicro.readTag();
          Object localObject;
          switch (n)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
            break;
          case 0: 
            return this;
          case 10: 
            localObject = new DetailInfo();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setDetailInfo((DetailInfo)localObject);
            break;
          case 18: 
            localObject = new Review();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addReview((Review)localObject);
            break;
          case 26: 
            localObject = new RichInfo();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setRichInfo((RichInfo)localObject);
            break;
          case 34: 
            setSrcName(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            localObject = new Image();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setImage((Image)localObject);
            break;
          case 50: 
            localObject = new LineInfo();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            addLineInfo((LineInfo)localObject);
            break;
          case 56: 
            setExtType(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public Ext setDetailInfo(DetailInfo paramDetailInfo)
      {
        if (paramDetailInfo == null) {
          return clearDetailInfo();
        }
        this.a = true;
        this.b = paramDetailInfo;
        return this;
      }
      
      public Ext setExtType(int paramInt)
      {
        this.k = true;
        this.l = paramInt;
        return this;
      }
      
      public Ext setImage(Image paramImage)
      {
        if (paramImage == null) {
          return clearImage();
        }
        this.f = true;
        this.g = paramImage;
        return this;
      }
      
      public Ext setLineInfo(int paramInt, LineInfo paramLineInfo)
      {
        if (paramLineInfo == null) {
          return this;
        }
        this.h.set(paramInt, paramLineInfo);
        return this;
      }
      
      public Ext setReview(int paramInt, Review paramReview)
      {
        if (paramReview == null) {
          return this;
        }
        this.c.set(paramInt, paramReview);
        return this;
      }
      
      public Ext setRichInfo(RichInfo paramRichInfo)
      {
        if (paramRichInfo == null) {
          return clearRichInfo();
        }
        this.d = true;
        this.e = paramRichInfo;
        return this;
      }
      
      public Ext setSrcName(String paramString)
      {
        this.i = true;
        this.j = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasDetailInfo()) {
          paramCodedOutputStreamMicro.writeMessage(1, getDetailInfo());
        }
        Iterator localIterator = getReviewList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(2, (Review)localIterator.next());
        }
        if (hasRichInfo()) {
          paramCodedOutputStreamMicro.writeMessage(3, getRichInfo());
        }
        if (hasSrcName()) {
          paramCodedOutputStreamMicro.writeString(4, getSrcName());
        }
        if (hasImage()) {
          paramCodedOutputStreamMicro.writeMessage(5, getImage());
        }
        localIterator = getLineInfoList().iterator();
        while (localIterator.hasNext()) {
          paramCodedOutputStreamMicro.writeMessage(6, (LineInfo)localIterator.next());
        }
        if (hasExtType()) {
          paramCodedOutputStreamMicro.writeInt32(7, getExtType());
        }
      }
      
      public static final class DetailInfo
        extends MessageMicro
      {
        public static final int ALLCARDEXTENSION_FIELD_NUMBER = 66;
        public static final int AREAID_FIELD_NUMBER = 1;
        public static final int BID_FIELD_NUMBER = 2;
        public static final int BOOK_INFO_FIELD_NUMBER = 61;
        public static final int CHECKIN_NUM_FIELD_NUMBER = 3;
        public static final int COLLECT_NUM_FIELD_NUMBER = 4;
        public static final int COMMENT_NUM_FIELD_NUMBER = 5;
        public static final int FACILITY_RATING_FIELD_NUMBER = 6;
        public static final int FLAG_FIELD_NUMBER = 53;
        public static final int FROM_PDS_FIELD_NUMBER = 7;
        public static final int GROUPON_FIELD_NUMBER = 8;
        public static final int GROUPON_FLAG_FIELD_NUMBER = 54;
        public static final int GROUPON_NUM_FIELD_NUMBER = 9;
        public static final int GROUPON_TOTAL_FIELD_NUMBER = 55;
        public static final int GUIDE_FIELD_NUMBER = 58;
        public static final int HOTEL_ORI_INFO_FIELD_NUMBER = 10;
        public static final int HYGIENE_RATING_FIELD_NUMBER = 11;
        public static final int IMAGE_FIELD_NUMBER = 12;
        public static final int IMAGE_FROM_FIELD_NUMBER = 13;
        public static final int IMAGE_NUM_FIELD_NUMBER = 14;
        public static final int IS_GWJ_FIELD_NUMBER = 56;
        public static final int LATEST_NUM_FIELD_NUMBER = 15;
        public static final int LBC_BUSINESS_VIP_FIELD_NUMBER = 62;
        public static final int LINK_FIELD_NUMBER = 16;
        public static final int MBC_FIELD_NUMBER = 65;
        public static final int MEISHIPAIHAO_FIELD_NUMBER = 59;
        public static final int MINING_LOW_PRICE_FLAG_FIELD_NUMBER = 17;
        public static final int NAME_FIELD_NUMBER = 18;
        public static final int NEW_CATALOG_ID_FIELD_NUMBER = 19;
        public static final int ORIGIN_PRICE_FIELD_NUMBER = 20;
        public static final int OTA_INFO_FIELD_NUMBER = 21;
        public static final int OTA_URL_FIELD_NUMBER = 22;
        public static final int OVERALL_RATING_FIELD_NUMBER = 23;
        public static final int PC_BOOKABLE_FIELD_NUMBER = 24;
        public static final int PC_REALTIME_PRICE_FIELD_NUMBER = 25;
        public static final int PHONE_FIELD_NUMBER = 26;
        public static final int POINT_FIELD_NUMBER = 27;
        public static final int POI_ADDRESS_FIELD_NUMBER = 28;
        public static final int PREMIUM_FLAG_FIELD_NUMBER = 29;
        public static final int PRICE_FIELD_NUMBER = 30;
        public static final int PRICE_TEXT_FIELD_NUMBER = 57;
        public static final int RECOMMAND_INDEX_FIELD_NUMBER = 32;
        public static final int REC_REASON_FIELD_NUMBER = 31;
        public static final int REVIEW_FLAG_FIELD_NUMBER = 33;
        public static final int SERVICE_RATING_FIELD_NUMBER = 34;
        public static final int SHORT_COMM_FIELD_NUMBER = 35;
        public static final int SPECIAL_SERVICE_FIELD_NUMBER = 36;
        public static final int STATUS_FIELD_NUMBER = 38;
        public static final int STORAGE_SRC_FIELD_NUMBER = 39;
        public static final int S_TIME_FIELD_NUMBER = 37;
        public static final int TAG_FIELD_NUMBER = 40;
        public static final int TONIGHT_PRICE_FIELD_NUMBER = 41;
        public static final int TONIGHT_SALE_FLAG_FIELD_NUMBER = 42;
        public static final int TOPLIST_FIELD_NUMBER = 44;
        public static final int TOTAL_NUM_FIELD_NUMBER = 43;
        public static final int UPPERLEFTCORNER_FIELD_NUMBER = 64;
        public static final int VALIDATE_FIELD_NUMBER = 63;
        public static final int WAP_BOOKABLE_FIELD_NUMBER = 45;
        public static final int WISE_FULLROOM_FIELD_NUMBER = 46;
        public static final int WISE_HOTEL_TYPE_FIELD_NUMBER = 47;
        public static final int WISE_HOTEL_TYPE_NAME_FIELD_NUMBER = 48;
        public static final int WISE_LOW_PRICE_FIELD_NUMBER = 49;
        public static final int WISE_PRICE_FIELD_NUMBER = 50;
        public static final int WISE_REALTIME_PRICE_FIELD_NUMBER = 51;
        public static final int WISE_REALTIME_PRICE_FLAG_FIELD_NUMBER = 52;
        private String A = "";
        private boolean B;
        private String C = "";
        private boolean D;
        private String E = "";
        private boolean F;
        private String G = "";
        private boolean H;
        private String I = "";
        private boolean J;
        private String K = "";
        private boolean L;
        private String M = "";
        private boolean N;
        private String O = "";
        private boolean P;
        private String Q = "";
        private boolean R;
        private String S = "";
        private boolean T;
        private String U = "";
        private boolean V;
        private String W = "";
        private boolean X;
        private String Y = "";
        private boolean Z;
        private List<Groupon> a = Collections.emptyList();
        private String aA = "";
        private boolean aB;
        private String aC = "";
        private boolean aD;
        private String aE = "";
        private boolean aF;
        private String aG = "";
        private boolean aH;
        private String aI = "";
        private boolean aJ;
        private String aK = "";
        private boolean aL;
        private String aM = "";
        private boolean aN;
        private String aO = "";
        private boolean aP;
        private String aQ = "";
        private boolean aR;
        private String aS = "";
        private boolean aT;
        private String aU = "";
        private List<String> aV = Collections.emptyList();
        private boolean aW;
        private int aX = 0;
        private boolean aY;
        private int aZ = 0;
        private String aa = "";
        private boolean ab;
        private int ac = 0;
        private boolean ad;
        private String ae = "";
        private boolean af;
        private String ag = "";
        private boolean ah;
        private String ai = "";
        private boolean aj;
        private int ak = 0;
        private boolean al;
        private String am = "";
        private boolean an;
        private String ao = "";
        private boolean ap;
        private String aq = "";
        private boolean ar;
        private int as = 0;
        private boolean at;
        private String au = "";
        private boolean av;
        private String aw = "";
        private boolean ax;
        private String ay = "";
        private boolean az;
        private List<HotelOriInfo> b = Collections.emptyList();
        private boolean ba;
        private int bb = 0;
        private boolean bc;
        private String bd = "";
        private boolean be;
        private String bf = "";
        private boolean bg;
        private Meishipaihao bh = null;
        private boolean bi;
        private BookInfo bj = null;
        private boolean bk;
        private LbcBusinessVip bl = null;
        private boolean bm;
        private String bn = "";
        private boolean bo;
        private Upperleftcorner bp = null;
        private boolean bq;
        private Mbc br = null;
        private boolean bs;
        private Allcardextension bt = null;
        private int bu = -1;
        private List<Link> c = Collections.emptyList();
        private List<OtaInfo> d = Collections.emptyList();
        private List<OtaUrl> e = Collections.emptyList();
        private boolean f;
        private Point g = null;
        private boolean h;
        private Toplist i = null;
        private boolean j;
        private int k = 0;
        private boolean l;
        private String m = "";
        private boolean n;
        private String o = "";
        private boolean p;
        private String q = "";
        private boolean r;
        private String s = "";
        private boolean t;
        private String u = "";
        private boolean v;
        private String w = "";
        private boolean x;
        private int y = 0;
        private boolean z;
        
        public static DetailInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new DetailInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static DetailInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (DetailInfo)new DetailInfo().mergeFrom(paramArrayOfByte);
        }
        
        public DetailInfo addFlag(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          if (this.aV.isEmpty()) {
            this.aV = new ArrayList();
          }
          this.aV.add(paramString);
          return this;
        }
        
        public DetailInfo addGroupon(Groupon paramGroupon)
        {
          if (paramGroupon == null) {
            return this;
          }
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(paramGroupon);
          return this;
        }
        
        public DetailInfo addHotelOriInfo(HotelOriInfo paramHotelOriInfo)
        {
          if (paramHotelOriInfo == null) {
            return this;
          }
          if (this.b.isEmpty()) {
            this.b = new ArrayList();
          }
          this.b.add(paramHotelOriInfo);
          return this;
        }
        
        public DetailInfo addLink(Link paramLink)
        {
          if (paramLink == null) {
            return this;
          }
          if (this.c.isEmpty()) {
            this.c = new ArrayList();
          }
          this.c.add(paramLink);
          return this;
        }
        
        public DetailInfo addOtaInfo(OtaInfo paramOtaInfo)
        {
          if (paramOtaInfo == null) {
            return this;
          }
          if (this.d.isEmpty()) {
            this.d = new ArrayList();
          }
          this.d.add(paramOtaInfo);
          return this;
        }
        
        public DetailInfo addOtaUrl(OtaUrl paramOtaUrl)
        {
          if (paramOtaUrl == null) {
            return this;
          }
          if (this.e.isEmpty()) {
            this.e = new ArrayList();
          }
          this.e.add(paramOtaUrl);
          return this;
        }
        
        public final DetailInfo clear()
        {
          clearGroupon();
          clearHotelOriInfo();
          clearLink();
          clearOtaInfo();
          clearOtaUrl();
          clearPoint();
          clearToplist();
          clearAreaid();
          clearBid();
          clearCheckinNum();
          clearCollectNum();
          clearCommentNum();
          clearFacilityRating();
          clearFromPds();
          clearGrouponNum();
          clearHygieneRating();
          clearImage();
          clearImageFrom();
          clearImageNum();
          clearLatestNum();
          clearMiningLowPriceFlag();
          clearName();
          clearNewCatalogId();
          clearOriginPrice();
          clearOverallRating();
          clearPcBookable();
          clearPcRealtimePrice();
          clearPhone();
          clearPoiAddress();
          clearPremiumFlag();
          clearPrice();
          clearRecReason();
          clearRecommandIndex();
          clearReviewFlag();
          clearServiceRating();
          clearShortComm();
          clearSpecialService();
          clearSTime();
          clearStatus();
          clearStorageSrc();
          clearTag();
          clearTonightPrice();
          clearTonightSaleFlag();
          clearTotalNum();
          clearWapBookable();
          clearWiseFullroom();
          clearWiseHotelType();
          clearWiseHotelTypeName();
          clearWiseLowPrice();
          clearWisePrice();
          clearWiseRealtimePrice();
          clearWiseRealtimePriceFlag();
          clearFlag();
          clearGrouponFlag();
          clearGrouponTotal();
          clearIsGwj();
          clearPriceText();
          clearGuide();
          clearMeishipaihao();
          clearBookInfo();
          clearLbcBusinessVip();
          clearValidate();
          clearUpperleftcorner();
          clearMbc();
          clearAllcardextension();
          this.bu = -1;
          return this;
        }
        
        public DetailInfo clearAllcardextension()
        {
          this.bs = false;
          this.bt = null;
          return this;
        }
        
        public DetailInfo clearAreaid()
        {
          this.j = false;
          this.k = 0;
          return this;
        }
        
        public DetailInfo clearBid()
        {
          this.l = false;
          this.m = "";
          return this;
        }
        
        public DetailInfo clearBookInfo()
        {
          this.bi = false;
          this.bj = null;
          return this;
        }
        
        public DetailInfo clearCheckinNum()
        {
          this.n = false;
          this.o = "";
          return this;
        }
        
        public DetailInfo clearCollectNum()
        {
          this.p = false;
          this.q = "";
          return this;
        }
        
        public DetailInfo clearCommentNum()
        {
          this.r = false;
          this.s = "";
          return this;
        }
        
        public DetailInfo clearFacilityRating()
        {
          this.t = false;
          this.u = "";
          return this;
        }
        
        public DetailInfo clearFlag()
        {
          this.aV = Collections.emptyList();
          return this;
        }
        
        public DetailInfo clearFromPds()
        {
          this.v = false;
          this.w = "";
          return this;
        }
        
        public DetailInfo clearGroupon()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public DetailInfo clearGrouponFlag()
        {
          this.aW = false;
          this.aX = 0;
          return this;
        }
        
        public DetailInfo clearGrouponNum()
        {
          this.x = false;
          this.y = 0;
          return this;
        }
        
        public DetailInfo clearGrouponTotal()
        {
          this.aY = false;
          this.aZ = 0;
          return this;
        }
        
        public DetailInfo clearGuide()
        {
          this.be = false;
          this.bf = "";
          return this;
        }
        
        public DetailInfo clearHotelOriInfo()
        {
          this.b = Collections.emptyList();
          return this;
        }
        
        public DetailInfo clearHygieneRating()
        {
          this.z = false;
          this.A = "";
          return this;
        }
        
        public DetailInfo clearImage()
        {
          this.B = false;
          this.C = "";
          return this;
        }
        
        public DetailInfo clearImageFrom()
        {
          this.D = false;
          this.E = "";
          return this;
        }
        
        public DetailInfo clearImageNum()
        {
          this.F = false;
          this.G = "";
          return this;
        }
        
        public DetailInfo clearIsGwj()
        {
          this.ba = false;
          this.bb = 0;
          return this;
        }
        
        public DetailInfo clearLatestNum()
        {
          this.H = false;
          this.I = "";
          return this;
        }
        
        public DetailInfo clearLbcBusinessVip()
        {
          this.bk = false;
          this.bl = null;
          return this;
        }
        
        public DetailInfo clearLink()
        {
          this.c = Collections.emptyList();
          return this;
        }
        
        public DetailInfo clearMbc()
        {
          this.bq = false;
          this.br = null;
          return this;
        }
        
        public DetailInfo clearMeishipaihao()
        {
          this.bg = false;
          this.bh = null;
          return this;
        }
        
        public DetailInfo clearMiningLowPriceFlag()
        {
          this.J = false;
          this.K = "";
          return this;
        }
        
        public DetailInfo clearName()
        {
          this.L = false;
          this.M = "";
          return this;
        }
        
        public DetailInfo clearNewCatalogId()
        {
          this.N = false;
          this.O = "";
          return this;
        }
        
        public DetailInfo clearOriginPrice()
        {
          this.P = false;
          this.Q = "";
          return this;
        }
        
        public DetailInfo clearOtaInfo()
        {
          this.d = Collections.emptyList();
          return this;
        }
        
        public DetailInfo clearOtaUrl()
        {
          this.e = Collections.emptyList();
          return this;
        }
        
        public DetailInfo clearOverallRating()
        {
          this.R = false;
          this.S = "";
          return this;
        }
        
        public DetailInfo clearPcBookable()
        {
          this.T = false;
          this.U = "";
          return this;
        }
        
        public DetailInfo clearPcRealtimePrice()
        {
          this.V = false;
          this.W = "";
          return this;
        }
        
        public DetailInfo clearPhone()
        {
          this.X = false;
          this.Y = "";
          return this;
        }
        
        public DetailInfo clearPoiAddress()
        {
          this.Z = false;
          this.aa = "";
          return this;
        }
        
        public DetailInfo clearPoint()
        {
          this.f = false;
          this.g = null;
          return this;
        }
        
        public DetailInfo clearPremiumFlag()
        {
          this.ab = false;
          this.ac = 0;
          return this;
        }
        
        public DetailInfo clearPrice()
        {
          this.ad = false;
          this.ae = "";
          return this;
        }
        
        public DetailInfo clearPriceText()
        {
          this.bc = false;
          this.bd = "";
          return this;
        }
        
        public DetailInfo clearRecReason()
        {
          this.af = false;
          this.ag = "";
          return this;
        }
        
        public DetailInfo clearRecommandIndex()
        {
          this.ah = false;
          this.ai = "";
          return this;
        }
        
        public DetailInfo clearReviewFlag()
        {
          this.aj = false;
          this.ak = 0;
          return this;
        }
        
        public DetailInfo clearSTime()
        {
          this.ar = false;
          this.as = 0;
          return this;
        }
        
        public DetailInfo clearServiceRating()
        {
          this.al = false;
          this.am = "";
          return this;
        }
        
        public DetailInfo clearShortComm()
        {
          this.an = false;
          this.ao = "";
          return this;
        }
        
        public DetailInfo clearSpecialService()
        {
          this.ap = false;
          this.aq = "";
          return this;
        }
        
        public DetailInfo clearStatus()
        {
          this.at = false;
          this.au = "";
          return this;
        }
        
        public DetailInfo clearStorageSrc()
        {
          this.av = false;
          this.aw = "";
          return this;
        }
        
        public DetailInfo clearTag()
        {
          this.ax = false;
          this.ay = "";
          return this;
        }
        
        public DetailInfo clearTonightPrice()
        {
          this.az = false;
          this.aA = "";
          return this;
        }
        
        public DetailInfo clearTonightSaleFlag()
        {
          this.aB = false;
          this.aC = "";
          return this;
        }
        
        public DetailInfo clearToplist()
        {
          this.h = false;
          this.i = null;
          return this;
        }
        
        public DetailInfo clearTotalNum()
        {
          this.aD = false;
          this.aE = "";
          return this;
        }
        
        public DetailInfo clearUpperleftcorner()
        {
          this.bo = false;
          this.bp = null;
          return this;
        }
        
        public DetailInfo clearValidate()
        {
          this.bm = false;
          this.bn = "";
          return this;
        }
        
        public DetailInfo clearWapBookable()
        {
          this.aF = false;
          this.aG = "";
          return this;
        }
        
        public DetailInfo clearWiseFullroom()
        {
          this.aH = false;
          this.aI = "";
          return this;
        }
        
        public DetailInfo clearWiseHotelType()
        {
          this.aJ = false;
          this.aK = "";
          return this;
        }
        
        public DetailInfo clearWiseHotelTypeName()
        {
          this.aL = false;
          this.aM = "";
          return this;
        }
        
        public DetailInfo clearWiseLowPrice()
        {
          this.aN = false;
          this.aO = "";
          return this;
        }
        
        public DetailInfo clearWisePrice()
        {
          this.aP = false;
          this.aQ = "";
          return this;
        }
        
        public DetailInfo clearWiseRealtimePrice()
        {
          this.aR = false;
          this.aS = "";
          return this;
        }
        
        public DetailInfo clearWiseRealtimePriceFlag()
        {
          this.aT = false;
          this.aU = "";
          return this;
        }
        
        public Allcardextension getAllcardextension()
        {
          return this.bt;
        }
        
        public int getAreaid()
        {
          return this.k;
        }
        
        public String getBid()
        {
          return this.m;
        }
        
        public BookInfo getBookInfo()
        {
          return this.bj;
        }
        
        public int getCachedSize()
        {
          if (this.bu < 0) {
            getSerializedSize();
          }
          return this.bu;
        }
        
        public String getCheckinNum()
        {
          return this.o;
        }
        
        public String getCollectNum()
        {
          return this.q;
        }
        
        public String getCommentNum()
        {
          return this.s;
        }
        
        public String getFacilityRating()
        {
          return this.u;
        }
        
        public String getFlag(int paramInt)
        {
          return (String)this.aV.get(paramInt);
        }
        
        public int getFlagCount()
        {
          return this.aV.size();
        }
        
        public List<String> getFlagList()
        {
          return this.aV;
        }
        
        public String getFromPds()
        {
          return this.w;
        }
        
        public Groupon getGroupon(int paramInt)
        {
          return (Groupon)this.a.get(paramInt);
        }
        
        public int getGrouponCount()
        {
          return this.a.size();
        }
        
        public int getGrouponFlag()
        {
          return this.aX;
        }
        
        public List<Groupon> getGrouponList()
        {
          return this.a;
        }
        
        public int getGrouponNum()
        {
          return this.y;
        }
        
        public int getGrouponTotal()
        {
          return this.aZ;
        }
        
        public String getGuide()
        {
          return this.bf;
        }
        
        public HotelOriInfo getHotelOriInfo(int paramInt)
        {
          return (HotelOriInfo)this.b.get(paramInt);
        }
        
        public int getHotelOriInfoCount()
        {
          return this.b.size();
        }
        
        public List<HotelOriInfo> getHotelOriInfoList()
        {
          return this.b;
        }
        
        public String getHygieneRating()
        {
          return this.A;
        }
        
        public String getImage()
        {
          return this.C;
        }
        
        public String getImageFrom()
        {
          return this.E;
        }
        
        public String getImageNum()
        {
          return this.G;
        }
        
        public int getIsGwj()
        {
          return this.bb;
        }
        
        public String getLatestNum()
        {
          return this.I;
        }
        
        public LbcBusinessVip getLbcBusinessVip()
        {
          return this.bl;
        }
        
        public Link getLink(int paramInt)
        {
          return (Link)this.c.get(paramInt);
        }
        
        public int getLinkCount()
        {
          return this.c.size();
        }
        
        public List<Link> getLinkList()
        {
          return this.c;
        }
        
        public Mbc getMbc()
        {
          return this.br;
        }
        
        public Meishipaihao getMeishipaihao()
        {
          return this.bh;
        }
        
        public String getMiningLowPriceFlag()
        {
          return this.K;
        }
        
        public String getName()
        {
          return this.M;
        }
        
        public String getNewCatalogId()
        {
          return this.O;
        }
        
        public String getOriginPrice()
        {
          return this.Q;
        }
        
        public OtaInfo getOtaInfo(int paramInt)
        {
          return (OtaInfo)this.d.get(paramInt);
        }
        
        public int getOtaInfoCount()
        {
          return this.d.size();
        }
        
        public List<OtaInfo> getOtaInfoList()
        {
          return this.d;
        }
        
        public OtaUrl getOtaUrl(int paramInt)
        {
          return (OtaUrl)this.e.get(paramInt);
        }
        
        public int getOtaUrlCount()
        {
          return this.e.size();
        }
        
        public List<OtaUrl> getOtaUrlList()
        {
          return this.e;
        }
        
        public String getOverallRating()
        {
          return this.S;
        }
        
        public String getPcBookable()
        {
          return this.U;
        }
        
        public String getPcRealtimePrice()
        {
          return this.W;
        }
        
        public String getPhone()
        {
          return this.Y;
        }
        
        public String getPoiAddress()
        {
          return this.aa;
        }
        
        public Point getPoint()
        {
          return this.g;
        }
        
        public int getPremiumFlag()
        {
          return this.ac;
        }
        
        public String getPrice()
        {
          return this.ae;
        }
        
        public String getPriceText()
        {
          return this.bd;
        }
        
        public String getRecReason()
        {
          return this.ag;
        }
        
        public String getRecommandIndex()
        {
          return this.ai;
        }
        
        public int getReviewFlag()
        {
          return this.ak;
        }
        
        public int getSTime()
        {
          return this.as;
        }
        
        public int getSerializedSize()
        {
          int i3 = 0;
          if (hasAreaid()) {}
          for (int i2 = CodedOutputStreamMicro.computeInt32Size(1, getAreaid()) + 0;; i2 = 0)
          {
            int i1 = i2;
            if (hasBid()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getBid());
            }
            i2 = i1;
            if (hasCheckinNum()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getCheckinNum());
            }
            i1 = i2;
            if (hasCollectNum()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getCollectNum());
            }
            i2 = i1;
            if (hasCommentNum()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getCommentNum());
            }
            i1 = i2;
            if (hasFacilityRating()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getFacilityRating());
            }
            i2 = i1;
            if (hasFromPds()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getFromPds());
            }
            Iterator localIterator = getGrouponList().iterator();
            for (i1 = i2; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(8, (Groupon)localIterator.next()) + i1) {}
            i2 = i1;
            if (hasGrouponNum()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getGrouponNum());
            }
            localIterator = getHotelOriInfoList().iterator();
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeMessageSize(10, (HotelOriInfo)localIterator.next());
            }
            i1 = i2;
            if (hasHygieneRating()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(11, getHygieneRating());
            }
            i2 = i1;
            if (hasImage()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(12, getImage());
            }
            i1 = i2;
            if (hasImageFrom()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(13, getImageFrom());
            }
            i2 = i1;
            if (hasImageNum()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(14, getImageNum());
            }
            i1 = i2;
            if (hasLatestNum()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(15, getLatestNum());
            }
            localIterator = getLinkList().iterator();
            i2 = i1;
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeMessageSize(16, (Link)localIterator.next());
            }
            i1 = i2;
            if (hasMiningLowPriceFlag()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(17, getMiningLowPriceFlag());
            }
            i2 = i1;
            if (hasName()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(18, getName());
            }
            i1 = i2;
            if (hasNewCatalogId()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(19, getNewCatalogId());
            }
            i2 = i1;
            if (hasOriginPrice()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(20, getOriginPrice());
            }
            localIterator = getOtaInfoList().iterator();
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeMessageSize(21, (OtaInfo)localIterator.next());
            }
            localIterator = getOtaUrlList().iterator();
            while (localIterator.hasNext()) {
              i2 += CodedOutputStreamMicro.computeMessageSize(22, (OtaUrl)localIterator.next());
            }
            i1 = i2;
            if (hasOverallRating()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(23, getOverallRating());
            }
            i2 = i1;
            if (hasPcBookable()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(24, getPcBookable());
            }
            i1 = i2;
            if (hasPcRealtimePrice()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(25, getPcRealtimePrice());
            }
            i2 = i1;
            if (hasPhone()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(26, getPhone());
            }
            i1 = i2;
            if (hasPoint()) {
              i1 = i2 + CodedOutputStreamMicro.computeMessageSize(27, getPoint());
            }
            i2 = i1;
            if (hasPoiAddress()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(28, getPoiAddress());
            }
            i1 = i2;
            if (hasPremiumFlag()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(29, getPremiumFlag());
            }
            i2 = i1;
            if (hasPrice()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(30, getPrice());
            }
            i1 = i2;
            if (hasRecReason()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(31, getRecReason());
            }
            i2 = i1;
            if (hasRecommandIndex()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(32, getRecommandIndex());
            }
            i1 = i2;
            if (hasReviewFlag()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(33, getReviewFlag());
            }
            i2 = i1;
            if (hasServiceRating()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(34, getServiceRating());
            }
            i1 = i2;
            if (hasShortComm()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(35, getShortComm());
            }
            i2 = i1;
            if (hasSpecialService()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(36, getSpecialService());
            }
            i1 = i2;
            if (hasSTime()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(37, getSTime());
            }
            i2 = i1;
            if (hasStatus()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(38, getStatus());
            }
            i1 = i2;
            if (hasStorageSrc()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(39, getStorageSrc());
            }
            i2 = i1;
            if (hasTag()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(40, getTag());
            }
            i1 = i2;
            if (hasTonightPrice()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(41, getTonightPrice());
            }
            i2 = i1;
            if (hasTonightSaleFlag()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(42, getTonightSaleFlag());
            }
            i1 = i2;
            if (hasTotalNum()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(43, getTotalNum());
            }
            i2 = i1;
            if (hasToplist()) {
              i2 = i1 + CodedOutputStreamMicro.computeMessageSize(44, getToplist());
            }
            i1 = i2;
            if (hasWapBookable()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(45, getWapBookable());
            }
            i2 = i1;
            if (hasWiseFullroom()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(46, getWiseFullroom());
            }
            i1 = i2;
            if (hasWiseHotelType()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(47, getWiseHotelType());
            }
            i2 = i1;
            if (hasWiseHotelTypeName()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(48, getWiseHotelTypeName());
            }
            i1 = i2;
            if (hasWiseLowPrice()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(49, getWiseLowPrice());
            }
            i2 = i1;
            if (hasWisePrice()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(50, getWisePrice());
            }
            i1 = i2;
            if (hasWiseRealtimePrice()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(51, getWiseRealtimePrice());
            }
            i2 = i1;
            if (hasWiseRealtimePriceFlag()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(52, getWiseRealtimePriceFlag());
            }
            localIterator = getFlagList().iterator();
            i1 = i3;
            while (localIterator.hasNext()) {
              i1 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
            }
            i2 = i2 + i1 + getFlagList().size() * 2;
            i1 = i2;
            if (hasGrouponFlag()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(54, getGrouponFlag());
            }
            i2 = i1;
            if (hasGrouponTotal()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(55, getGrouponTotal());
            }
            i1 = i2;
            if (hasIsGwj()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(56, getIsGwj());
            }
            i2 = i1;
            if (hasPriceText()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(57, getPriceText());
            }
            i1 = i2;
            if (hasGuide()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(58, getGuide());
            }
            i2 = i1;
            if (hasMeishipaihao()) {
              i2 = i1 + CodedOutputStreamMicro.computeMessageSize(59, getMeishipaihao());
            }
            i1 = i2;
            if (hasBookInfo()) {
              i1 = i2 + CodedOutputStreamMicro.computeMessageSize(61, getBookInfo());
            }
            i2 = i1;
            if (hasLbcBusinessVip()) {
              i2 = i1 + CodedOutputStreamMicro.computeMessageSize(62, getLbcBusinessVip());
            }
            i1 = i2;
            if (hasValidate()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(63, getValidate());
            }
            i2 = i1;
            if (hasUpperleftcorner()) {
              i2 = i1 + CodedOutputStreamMicro.computeMessageSize(64, getUpperleftcorner());
            }
            i1 = i2;
            if (hasMbc()) {
              i1 = i2 + CodedOutputStreamMicro.computeMessageSize(65, getMbc());
            }
            i2 = i1;
            if (hasAllcardextension()) {
              i2 = i1 + CodedOutputStreamMicro.computeMessageSize(66, getAllcardextension());
            }
            this.bu = i2;
            return i2;
          }
        }
        
        public String getServiceRating()
        {
          return this.am;
        }
        
        public String getShortComm()
        {
          return this.ao;
        }
        
        public String getSpecialService()
        {
          return this.aq;
        }
        
        public String getStatus()
        {
          return this.au;
        }
        
        public String getStorageSrc()
        {
          return this.aw;
        }
        
        public String getTag()
        {
          return this.ay;
        }
        
        public String getTonightPrice()
        {
          return this.aA;
        }
        
        public String getTonightSaleFlag()
        {
          return this.aC;
        }
        
        public Toplist getToplist()
        {
          return this.i;
        }
        
        public String getTotalNum()
        {
          return this.aE;
        }
        
        public Upperleftcorner getUpperleftcorner()
        {
          return this.bp;
        }
        
        public String getValidate()
        {
          return this.bn;
        }
        
        public String getWapBookable()
        {
          return this.aG;
        }
        
        public String getWiseFullroom()
        {
          return this.aI;
        }
        
        public String getWiseHotelType()
        {
          return this.aK;
        }
        
        public String getWiseHotelTypeName()
        {
          return this.aM;
        }
        
        public String getWiseLowPrice()
        {
          return this.aO;
        }
        
        public String getWisePrice()
        {
          return this.aQ;
        }
        
        public String getWiseRealtimePrice()
        {
          return this.aS;
        }
        
        public String getWiseRealtimePriceFlag()
        {
          return this.aU;
        }
        
        public boolean hasAllcardextension()
        {
          return this.bs;
        }
        
        public boolean hasAreaid()
        {
          return this.j;
        }
        
        public boolean hasBid()
        {
          return this.l;
        }
        
        public boolean hasBookInfo()
        {
          return this.bi;
        }
        
        public boolean hasCheckinNum()
        {
          return this.n;
        }
        
        public boolean hasCollectNum()
        {
          return this.p;
        }
        
        public boolean hasCommentNum()
        {
          return this.r;
        }
        
        public boolean hasFacilityRating()
        {
          return this.t;
        }
        
        public boolean hasFromPds()
        {
          return this.v;
        }
        
        public boolean hasGrouponFlag()
        {
          return this.aW;
        }
        
        public boolean hasGrouponNum()
        {
          return this.x;
        }
        
        public boolean hasGrouponTotal()
        {
          return this.aY;
        }
        
        public boolean hasGuide()
        {
          return this.be;
        }
        
        public boolean hasHygieneRating()
        {
          return this.z;
        }
        
        public boolean hasImage()
        {
          return this.B;
        }
        
        public boolean hasImageFrom()
        {
          return this.D;
        }
        
        public boolean hasImageNum()
        {
          return this.F;
        }
        
        public boolean hasIsGwj()
        {
          return this.ba;
        }
        
        public boolean hasLatestNum()
        {
          return this.H;
        }
        
        public boolean hasLbcBusinessVip()
        {
          return this.bk;
        }
        
        public boolean hasMbc()
        {
          return this.bq;
        }
        
        public boolean hasMeishipaihao()
        {
          return this.bg;
        }
        
        public boolean hasMiningLowPriceFlag()
        {
          return this.J;
        }
        
        public boolean hasName()
        {
          return this.L;
        }
        
        public boolean hasNewCatalogId()
        {
          return this.N;
        }
        
        public boolean hasOriginPrice()
        {
          return this.P;
        }
        
        public boolean hasOverallRating()
        {
          return this.R;
        }
        
        public boolean hasPcBookable()
        {
          return this.T;
        }
        
        public boolean hasPcRealtimePrice()
        {
          return this.V;
        }
        
        public boolean hasPhone()
        {
          return this.X;
        }
        
        public boolean hasPoiAddress()
        {
          return this.Z;
        }
        
        public boolean hasPoint()
        {
          return this.f;
        }
        
        public boolean hasPremiumFlag()
        {
          return this.ab;
        }
        
        public boolean hasPrice()
        {
          return this.ad;
        }
        
        public boolean hasPriceText()
        {
          return this.bc;
        }
        
        public boolean hasRecReason()
        {
          return this.af;
        }
        
        public boolean hasRecommandIndex()
        {
          return this.ah;
        }
        
        public boolean hasReviewFlag()
        {
          return this.aj;
        }
        
        public boolean hasSTime()
        {
          return this.ar;
        }
        
        public boolean hasServiceRating()
        {
          return this.al;
        }
        
        public boolean hasShortComm()
        {
          return this.an;
        }
        
        public boolean hasSpecialService()
        {
          return this.ap;
        }
        
        public boolean hasStatus()
        {
          return this.at;
        }
        
        public boolean hasStorageSrc()
        {
          return this.av;
        }
        
        public boolean hasTag()
        {
          return this.ax;
        }
        
        public boolean hasTonightPrice()
        {
          return this.az;
        }
        
        public boolean hasTonightSaleFlag()
        {
          return this.aB;
        }
        
        public boolean hasToplist()
        {
          return this.h;
        }
        
        public boolean hasTotalNum()
        {
          return this.aD;
        }
        
        public boolean hasUpperleftcorner()
        {
          return this.bo;
        }
        
        public boolean hasValidate()
        {
          return this.bm;
        }
        
        public boolean hasWapBookable()
        {
          return this.aF;
        }
        
        public boolean hasWiseFullroom()
        {
          return this.aH;
        }
        
        public boolean hasWiseHotelType()
        {
          return this.aJ;
        }
        
        public boolean hasWiseHotelTypeName()
        {
          return this.aL;
        }
        
        public boolean hasWiseLowPrice()
        {
          return this.aN;
        }
        
        public boolean hasWisePrice()
        {
          return this.aP;
        }
        
        public boolean hasWiseRealtimePrice()
        {
          return this.aR;
        }
        
        public boolean hasWiseRealtimePriceFlag()
        {
          return this.aT;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public DetailInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            case 8: 
              setAreaid(paramCodedInputStreamMicro.readInt32());
              break;
            case 18: 
              setBid(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              setCheckinNum(paramCodedInputStreamMicro.readString());
              break;
            case 34: 
              setCollectNum(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              setCommentNum(paramCodedInputStreamMicro.readString());
              break;
            case 50: 
              setFacilityRating(paramCodedInputStreamMicro.readString());
              break;
            case 58: 
              setFromPds(paramCodedInputStreamMicro.readString());
              break;
            case 66: 
              localObject = new Groupon();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addGroupon((Groupon)localObject);
              break;
            case 72: 
              setGrouponNum(paramCodedInputStreamMicro.readInt32());
              break;
            case 82: 
              localObject = new HotelOriInfo();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addHotelOriInfo((HotelOriInfo)localObject);
              break;
            case 90: 
              setHygieneRating(paramCodedInputStreamMicro.readString());
              break;
            case 98: 
              setImage(paramCodedInputStreamMicro.readString());
              break;
            case 106: 
              setImageFrom(paramCodedInputStreamMicro.readString());
              break;
            case 114: 
              setImageNum(paramCodedInputStreamMicro.readString());
              break;
            case 122: 
              setLatestNum(paramCodedInputStreamMicro.readString());
              break;
            case 130: 
              localObject = new Link();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addLink((Link)localObject);
              break;
            case 138: 
              setMiningLowPriceFlag(paramCodedInputStreamMicro.readString());
              break;
            case 146: 
              setName(paramCodedInputStreamMicro.readString());
              break;
            case 154: 
              setNewCatalogId(paramCodedInputStreamMicro.readString());
              break;
            case 162: 
              setOriginPrice(paramCodedInputStreamMicro.readString());
              break;
            case 170: 
              localObject = new OtaInfo();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addOtaInfo((OtaInfo)localObject);
              break;
            case 178: 
              localObject = new OtaUrl();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addOtaUrl((OtaUrl)localObject);
              break;
            case 186: 
              setOverallRating(paramCodedInputStreamMicro.readString());
              break;
            case 194: 
              setPcBookable(paramCodedInputStreamMicro.readString());
              break;
            case 202: 
              setPcRealtimePrice(paramCodedInputStreamMicro.readString());
              break;
            case 210: 
              setPhone(paramCodedInputStreamMicro.readString());
              break;
            case 218: 
              localObject = new Point();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setPoint((Point)localObject);
              break;
            case 226: 
              setPoiAddress(paramCodedInputStreamMicro.readString());
              break;
            case 232: 
              setPremiumFlag(paramCodedInputStreamMicro.readInt32());
              break;
            case 242: 
              setPrice(paramCodedInputStreamMicro.readString());
              break;
            case 250: 
              setRecReason(paramCodedInputStreamMicro.readString());
              break;
            case 258: 
              setRecommandIndex(paramCodedInputStreamMicro.readString());
              break;
            case 264: 
              setReviewFlag(paramCodedInputStreamMicro.readInt32());
              break;
            case 274: 
              setServiceRating(paramCodedInputStreamMicro.readString());
              break;
            case 282: 
              setShortComm(paramCodedInputStreamMicro.readString());
              break;
            case 290: 
              setSpecialService(paramCodedInputStreamMicro.readString());
              break;
            case 296: 
              setSTime(paramCodedInputStreamMicro.readInt32());
              break;
            case 306: 
              setStatus(paramCodedInputStreamMicro.readString());
              break;
            case 314: 
              setStorageSrc(paramCodedInputStreamMicro.readString());
              break;
            case 322: 
              setTag(paramCodedInputStreamMicro.readString());
              break;
            case 330: 
              setTonightPrice(paramCodedInputStreamMicro.readString());
              break;
            case 338: 
              setTonightSaleFlag(paramCodedInputStreamMicro.readString());
              break;
            case 346: 
              setTotalNum(paramCodedInputStreamMicro.readString());
              break;
            case 354: 
              localObject = new Toplist();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setToplist((Toplist)localObject);
              break;
            case 362: 
              setWapBookable(paramCodedInputStreamMicro.readString());
              break;
            case 370: 
              setWiseFullroom(paramCodedInputStreamMicro.readString());
              break;
            case 378: 
              setWiseHotelType(paramCodedInputStreamMicro.readString());
              break;
            case 386: 
              setWiseHotelTypeName(paramCodedInputStreamMicro.readString());
              break;
            case 394: 
              setWiseLowPrice(paramCodedInputStreamMicro.readString());
              break;
            case 402: 
              setWisePrice(paramCodedInputStreamMicro.readString());
              break;
            case 410: 
              setWiseRealtimePrice(paramCodedInputStreamMicro.readString());
              break;
            case 418: 
              setWiseRealtimePriceFlag(paramCodedInputStreamMicro.readString());
              break;
            case 426: 
              addFlag(paramCodedInputStreamMicro.readString());
              break;
            case 432: 
              setGrouponFlag(paramCodedInputStreamMicro.readInt32());
              break;
            case 440: 
              setGrouponTotal(paramCodedInputStreamMicro.readInt32());
              break;
            case 448: 
              setIsGwj(paramCodedInputStreamMicro.readInt32());
              break;
            case 458: 
              setPriceText(paramCodedInputStreamMicro.readString());
              break;
            case 466: 
              setGuide(paramCodedInputStreamMicro.readString());
              break;
            case 474: 
              localObject = new Meishipaihao();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setMeishipaihao((Meishipaihao)localObject);
              break;
            case 490: 
              localObject = new BookInfo();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setBookInfo((BookInfo)localObject);
              break;
            case 498: 
              localObject = new LbcBusinessVip();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setLbcBusinessVip((LbcBusinessVip)localObject);
              break;
            case 506: 
              setValidate(paramCodedInputStreamMicro.readString());
              break;
            case 514: 
              localObject = new Upperleftcorner();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setUpperleftcorner((Upperleftcorner)localObject);
              break;
            case 522: 
              localObject = new Mbc();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setMbc((Mbc)localObject);
              break;
            case 530: 
              localObject = new Allcardextension();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              setAllcardextension((Allcardextension)localObject);
            }
          }
        }
        
        public DetailInfo setAllcardextension(Allcardextension paramAllcardextension)
        {
          if (paramAllcardextension == null) {
            return clearAllcardextension();
          }
          this.bs = true;
          this.bt = paramAllcardextension;
          return this;
        }
        
        public DetailInfo setAreaid(int paramInt)
        {
          this.j = true;
          this.k = paramInt;
          return this;
        }
        
        public DetailInfo setBid(String paramString)
        {
          this.l = true;
          this.m = paramString;
          return this;
        }
        
        public DetailInfo setBookInfo(BookInfo paramBookInfo)
        {
          if (paramBookInfo == null) {
            return clearBookInfo();
          }
          this.bi = true;
          this.bj = paramBookInfo;
          return this;
        }
        
        public DetailInfo setCheckinNum(String paramString)
        {
          this.n = true;
          this.o = paramString;
          return this;
        }
        
        public DetailInfo setCollectNum(String paramString)
        {
          this.p = true;
          this.q = paramString;
          return this;
        }
        
        public DetailInfo setCommentNum(String paramString)
        {
          this.r = true;
          this.s = paramString;
          return this;
        }
        
        public DetailInfo setFacilityRating(String paramString)
        {
          this.t = true;
          this.u = paramString;
          return this;
        }
        
        public DetailInfo setFlag(int paramInt, String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.aV.set(paramInt, paramString);
          return this;
        }
        
        public DetailInfo setFromPds(String paramString)
        {
          this.v = true;
          this.w = paramString;
          return this;
        }
        
        public DetailInfo setGroupon(int paramInt, Groupon paramGroupon)
        {
          if (paramGroupon == null) {
            return this;
          }
          this.a.set(paramInt, paramGroupon);
          return this;
        }
        
        public DetailInfo setGrouponFlag(int paramInt)
        {
          this.aW = true;
          this.aX = paramInt;
          return this;
        }
        
        public DetailInfo setGrouponNum(int paramInt)
        {
          this.x = true;
          this.y = paramInt;
          return this;
        }
        
        public DetailInfo setGrouponTotal(int paramInt)
        {
          this.aY = true;
          this.aZ = paramInt;
          return this;
        }
        
        public DetailInfo setGuide(String paramString)
        {
          this.be = true;
          this.bf = paramString;
          return this;
        }
        
        public DetailInfo setHotelOriInfo(int paramInt, HotelOriInfo paramHotelOriInfo)
        {
          if (paramHotelOriInfo == null) {
            return this;
          }
          this.b.set(paramInt, paramHotelOriInfo);
          return this;
        }
        
        public DetailInfo setHygieneRating(String paramString)
        {
          this.z = true;
          this.A = paramString;
          return this;
        }
        
        public DetailInfo setImage(String paramString)
        {
          this.B = true;
          this.C = paramString;
          return this;
        }
        
        public DetailInfo setImageFrom(String paramString)
        {
          this.D = true;
          this.E = paramString;
          return this;
        }
        
        public DetailInfo setImageNum(String paramString)
        {
          this.F = true;
          this.G = paramString;
          return this;
        }
        
        public DetailInfo setIsGwj(int paramInt)
        {
          this.ba = true;
          this.bb = paramInt;
          return this;
        }
        
        public DetailInfo setLatestNum(String paramString)
        {
          this.H = true;
          this.I = paramString;
          return this;
        }
        
        public DetailInfo setLbcBusinessVip(LbcBusinessVip paramLbcBusinessVip)
        {
          if (paramLbcBusinessVip == null) {
            return clearLbcBusinessVip();
          }
          this.bk = true;
          this.bl = paramLbcBusinessVip;
          return this;
        }
        
        public DetailInfo setLink(int paramInt, Link paramLink)
        {
          if (paramLink == null) {
            return this;
          }
          this.c.set(paramInt, paramLink);
          return this;
        }
        
        public DetailInfo setMbc(Mbc paramMbc)
        {
          if (paramMbc == null) {
            return clearMbc();
          }
          this.bq = true;
          this.br = paramMbc;
          return this;
        }
        
        public DetailInfo setMeishipaihao(Meishipaihao paramMeishipaihao)
        {
          if (paramMeishipaihao == null) {
            return clearMeishipaihao();
          }
          this.bg = true;
          this.bh = paramMeishipaihao;
          return this;
        }
        
        public DetailInfo setMiningLowPriceFlag(String paramString)
        {
          this.J = true;
          this.K = paramString;
          return this;
        }
        
        public DetailInfo setName(String paramString)
        {
          this.L = true;
          this.M = paramString;
          return this;
        }
        
        public DetailInfo setNewCatalogId(String paramString)
        {
          this.N = true;
          this.O = paramString;
          return this;
        }
        
        public DetailInfo setOriginPrice(String paramString)
        {
          this.P = true;
          this.Q = paramString;
          return this;
        }
        
        public DetailInfo setOtaInfo(int paramInt, OtaInfo paramOtaInfo)
        {
          if (paramOtaInfo == null) {
            return this;
          }
          this.d.set(paramInt, paramOtaInfo);
          return this;
        }
        
        public DetailInfo setOtaUrl(int paramInt, OtaUrl paramOtaUrl)
        {
          if (paramOtaUrl == null) {
            return this;
          }
          this.e.set(paramInt, paramOtaUrl);
          return this;
        }
        
        public DetailInfo setOverallRating(String paramString)
        {
          this.R = true;
          this.S = paramString;
          return this;
        }
        
        public DetailInfo setPcBookable(String paramString)
        {
          this.T = true;
          this.U = paramString;
          return this;
        }
        
        public DetailInfo setPcRealtimePrice(String paramString)
        {
          this.V = true;
          this.W = paramString;
          return this;
        }
        
        public DetailInfo setPhone(String paramString)
        {
          this.X = true;
          this.Y = paramString;
          return this;
        }
        
        public DetailInfo setPoiAddress(String paramString)
        {
          this.Z = true;
          this.aa = paramString;
          return this;
        }
        
        public DetailInfo setPoint(Point paramPoint)
        {
          if (paramPoint == null) {
            return clearPoint();
          }
          this.f = true;
          this.g = paramPoint;
          return this;
        }
        
        public DetailInfo setPremiumFlag(int paramInt)
        {
          this.ab = true;
          this.ac = paramInt;
          return this;
        }
        
        public DetailInfo setPrice(String paramString)
        {
          this.ad = true;
          this.ae = paramString;
          return this;
        }
        
        public DetailInfo setPriceText(String paramString)
        {
          this.bc = true;
          this.bd = paramString;
          return this;
        }
        
        public DetailInfo setRecReason(String paramString)
        {
          this.af = true;
          this.ag = paramString;
          return this;
        }
        
        public DetailInfo setRecommandIndex(String paramString)
        {
          this.ah = true;
          this.ai = paramString;
          return this;
        }
        
        public DetailInfo setReviewFlag(int paramInt)
        {
          this.aj = true;
          this.ak = paramInt;
          return this;
        }
        
        public DetailInfo setSTime(int paramInt)
        {
          this.ar = true;
          this.as = paramInt;
          return this;
        }
        
        public DetailInfo setServiceRating(String paramString)
        {
          this.al = true;
          this.am = paramString;
          return this;
        }
        
        public DetailInfo setShortComm(String paramString)
        {
          this.an = true;
          this.ao = paramString;
          return this;
        }
        
        public DetailInfo setSpecialService(String paramString)
        {
          this.ap = true;
          this.aq = paramString;
          return this;
        }
        
        public DetailInfo setStatus(String paramString)
        {
          this.at = true;
          this.au = paramString;
          return this;
        }
        
        public DetailInfo setStorageSrc(String paramString)
        {
          this.av = true;
          this.aw = paramString;
          return this;
        }
        
        public DetailInfo setTag(String paramString)
        {
          this.ax = true;
          this.ay = paramString;
          return this;
        }
        
        public DetailInfo setTonightPrice(String paramString)
        {
          this.az = true;
          this.aA = paramString;
          return this;
        }
        
        public DetailInfo setTonightSaleFlag(String paramString)
        {
          this.aB = true;
          this.aC = paramString;
          return this;
        }
        
        public DetailInfo setToplist(Toplist paramToplist)
        {
          if (paramToplist == null) {
            return clearToplist();
          }
          this.h = true;
          this.i = paramToplist;
          return this;
        }
        
        public DetailInfo setTotalNum(String paramString)
        {
          this.aD = true;
          this.aE = paramString;
          return this;
        }
        
        public DetailInfo setUpperleftcorner(Upperleftcorner paramUpperleftcorner)
        {
          if (paramUpperleftcorner == null) {
            return clearUpperleftcorner();
          }
          this.bo = true;
          this.bp = paramUpperleftcorner;
          return this;
        }
        
        public DetailInfo setValidate(String paramString)
        {
          this.bm = true;
          this.bn = paramString;
          return this;
        }
        
        public DetailInfo setWapBookable(String paramString)
        {
          this.aF = true;
          this.aG = paramString;
          return this;
        }
        
        public DetailInfo setWiseFullroom(String paramString)
        {
          this.aH = true;
          this.aI = paramString;
          return this;
        }
        
        public DetailInfo setWiseHotelType(String paramString)
        {
          this.aJ = true;
          this.aK = paramString;
          return this;
        }
        
        public DetailInfo setWiseHotelTypeName(String paramString)
        {
          this.aL = true;
          this.aM = paramString;
          return this;
        }
        
        public DetailInfo setWiseLowPrice(String paramString)
        {
          this.aN = true;
          this.aO = paramString;
          return this;
        }
        
        public DetailInfo setWisePrice(String paramString)
        {
          this.aP = true;
          this.aQ = paramString;
          return this;
        }
        
        public DetailInfo setWiseRealtimePrice(String paramString)
        {
          this.aR = true;
          this.aS = paramString;
          return this;
        }
        
        public DetailInfo setWiseRealtimePriceFlag(String paramString)
        {
          this.aT = true;
          this.aU = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasAreaid()) {
            paramCodedOutputStreamMicro.writeInt32(1, getAreaid());
          }
          if (hasBid()) {
            paramCodedOutputStreamMicro.writeString(2, getBid());
          }
          if (hasCheckinNum()) {
            paramCodedOutputStreamMicro.writeString(3, getCheckinNum());
          }
          if (hasCollectNum()) {
            paramCodedOutputStreamMicro.writeString(4, getCollectNum());
          }
          if (hasCommentNum()) {
            paramCodedOutputStreamMicro.writeString(5, getCommentNum());
          }
          if (hasFacilityRating()) {
            paramCodedOutputStreamMicro.writeString(6, getFacilityRating());
          }
          if (hasFromPds()) {
            paramCodedOutputStreamMicro.writeString(7, getFromPds());
          }
          Iterator localIterator = getGrouponList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(8, (Groupon)localIterator.next());
          }
          if (hasGrouponNum()) {
            paramCodedOutputStreamMicro.writeInt32(9, getGrouponNum());
          }
          localIterator = getHotelOriInfoList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(10, (HotelOriInfo)localIterator.next());
          }
          if (hasHygieneRating()) {
            paramCodedOutputStreamMicro.writeString(11, getHygieneRating());
          }
          if (hasImage()) {
            paramCodedOutputStreamMicro.writeString(12, getImage());
          }
          if (hasImageFrom()) {
            paramCodedOutputStreamMicro.writeString(13, getImageFrom());
          }
          if (hasImageNum()) {
            paramCodedOutputStreamMicro.writeString(14, getImageNum());
          }
          if (hasLatestNum()) {
            paramCodedOutputStreamMicro.writeString(15, getLatestNum());
          }
          localIterator = getLinkList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(16, (Link)localIterator.next());
          }
          if (hasMiningLowPriceFlag()) {
            paramCodedOutputStreamMicro.writeString(17, getMiningLowPriceFlag());
          }
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(18, getName());
          }
          if (hasNewCatalogId()) {
            paramCodedOutputStreamMicro.writeString(19, getNewCatalogId());
          }
          if (hasOriginPrice()) {
            paramCodedOutputStreamMicro.writeString(20, getOriginPrice());
          }
          localIterator = getOtaInfoList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(21, (OtaInfo)localIterator.next());
          }
          localIterator = getOtaUrlList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(22, (OtaUrl)localIterator.next());
          }
          if (hasOverallRating()) {
            paramCodedOutputStreamMicro.writeString(23, getOverallRating());
          }
          if (hasPcBookable()) {
            paramCodedOutputStreamMicro.writeString(24, getPcBookable());
          }
          if (hasPcRealtimePrice()) {
            paramCodedOutputStreamMicro.writeString(25, getPcRealtimePrice());
          }
          if (hasPhone()) {
            paramCodedOutputStreamMicro.writeString(26, getPhone());
          }
          if (hasPoint()) {
            paramCodedOutputStreamMicro.writeMessage(27, getPoint());
          }
          if (hasPoiAddress()) {
            paramCodedOutputStreamMicro.writeString(28, getPoiAddress());
          }
          if (hasPremiumFlag()) {
            paramCodedOutputStreamMicro.writeInt32(29, getPremiumFlag());
          }
          if (hasPrice()) {
            paramCodedOutputStreamMicro.writeString(30, getPrice());
          }
          if (hasRecReason()) {
            paramCodedOutputStreamMicro.writeString(31, getRecReason());
          }
          if (hasRecommandIndex()) {
            paramCodedOutputStreamMicro.writeString(32, getRecommandIndex());
          }
          if (hasReviewFlag()) {
            paramCodedOutputStreamMicro.writeInt32(33, getReviewFlag());
          }
          if (hasServiceRating()) {
            paramCodedOutputStreamMicro.writeString(34, getServiceRating());
          }
          if (hasShortComm()) {
            paramCodedOutputStreamMicro.writeString(35, getShortComm());
          }
          if (hasSpecialService()) {
            paramCodedOutputStreamMicro.writeString(36, getSpecialService());
          }
          if (hasSTime()) {
            paramCodedOutputStreamMicro.writeInt32(37, getSTime());
          }
          if (hasStatus()) {
            paramCodedOutputStreamMicro.writeString(38, getStatus());
          }
          if (hasStorageSrc()) {
            paramCodedOutputStreamMicro.writeString(39, getStorageSrc());
          }
          if (hasTag()) {
            paramCodedOutputStreamMicro.writeString(40, getTag());
          }
          if (hasTonightPrice()) {
            paramCodedOutputStreamMicro.writeString(41, getTonightPrice());
          }
          if (hasTonightSaleFlag()) {
            paramCodedOutputStreamMicro.writeString(42, getTonightSaleFlag());
          }
          if (hasTotalNum()) {
            paramCodedOutputStreamMicro.writeString(43, getTotalNum());
          }
          if (hasToplist()) {
            paramCodedOutputStreamMicro.writeMessage(44, getToplist());
          }
          if (hasWapBookable()) {
            paramCodedOutputStreamMicro.writeString(45, getWapBookable());
          }
          if (hasWiseFullroom()) {
            paramCodedOutputStreamMicro.writeString(46, getWiseFullroom());
          }
          if (hasWiseHotelType()) {
            paramCodedOutputStreamMicro.writeString(47, getWiseHotelType());
          }
          if (hasWiseHotelTypeName()) {
            paramCodedOutputStreamMicro.writeString(48, getWiseHotelTypeName());
          }
          if (hasWiseLowPrice()) {
            paramCodedOutputStreamMicro.writeString(49, getWiseLowPrice());
          }
          if (hasWisePrice()) {
            paramCodedOutputStreamMicro.writeString(50, getWisePrice());
          }
          if (hasWiseRealtimePrice()) {
            paramCodedOutputStreamMicro.writeString(51, getWiseRealtimePrice());
          }
          if (hasWiseRealtimePriceFlag()) {
            paramCodedOutputStreamMicro.writeString(52, getWiseRealtimePriceFlag());
          }
          localIterator = getFlagList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeString(53, (String)localIterator.next());
          }
          if (hasGrouponFlag()) {
            paramCodedOutputStreamMicro.writeInt32(54, getGrouponFlag());
          }
          if (hasGrouponTotal()) {
            paramCodedOutputStreamMicro.writeInt32(55, getGrouponTotal());
          }
          if (hasIsGwj()) {
            paramCodedOutputStreamMicro.writeInt32(56, getIsGwj());
          }
          if (hasPriceText()) {
            paramCodedOutputStreamMicro.writeString(57, getPriceText());
          }
          if (hasGuide()) {
            paramCodedOutputStreamMicro.writeString(58, getGuide());
          }
          if (hasMeishipaihao()) {
            paramCodedOutputStreamMicro.writeMessage(59, getMeishipaihao());
          }
          if (hasBookInfo()) {
            paramCodedOutputStreamMicro.writeMessage(61, getBookInfo());
          }
          if (hasLbcBusinessVip()) {
            paramCodedOutputStreamMicro.writeMessage(62, getLbcBusinessVip());
          }
          if (hasValidate()) {
            paramCodedOutputStreamMicro.writeString(63, getValidate());
          }
          if (hasUpperleftcorner()) {
            paramCodedOutputStreamMicro.writeMessage(64, getUpperleftcorner());
          }
          if (hasMbc()) {
            paramCodedOutputStreamMicro.writeMessage(65, getMbc());
          }
          if (hasAllcardextension()) {
            paramCodedOutputStreamMicro.writeMessage(66, getAllcardextension());
          }
        }
        
        public static final class Allcardextension
          extends MessageMicro
        {
          public static final int IMAGE_URL_FIELD_NUMBER = 1;
          public static final int LANDING_URL_FIELD_NUMBER = 2;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private int e = -1;
          
          public static Allcardextension parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Allcardextension().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Allcardextension parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Allcardextension)new Allcardextension().mergeFrom(paramArrayOfByte);
          }
          
          public final Allcardextension clear()
          {
            clearImageUrl();
            clearLandingUrl();
            this.e = -1;
            return this;
          }
          
          public Allcardextension clearImageUrl()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Allcardextension clearLandingUrl()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.e < 0) {
              getSerializedSize();
            }
            return this.e;
          }
          
          public String getImageUrl()
          {
            return this.b;
          }
          
          public String getLandingUrl()
          {
            return this.d;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasImageUrl()) {
              i = 0 + CodedOutputStreamMicro.computeStringSize(1, getImageUrl());
            }
            int j = i;
            if (hasLandingUrl()) {
              j = i + CodedOutputStreamMicro.computeStringSize(2, getLandingUrl());
            }
            this.e = j;
            return j;
          }
          
          public boolean hasImageUrl()
          {
            return this.a;
          }
          
          public boolean hasLandingUrl()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Allcardextension mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 10: 
                setImageUrl(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setLandingUrl(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Allcardextension setImageUrl(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Allcardextension setLandingUrl(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasImageUrl()) {
              paramCodedOutputStreamMicro.writeString(1, getImageUrl());
            }
            if (hasLandingUrl()) {
              paramCodedOutputStreamMicro.writeString(2, getLandingUrl());
            }
          }
        }
        
        public static final class BookInfo
          extends MessageMicro
        {
          public static final int COMS_FIELD_NUMBER = 3;
          public static final int TEL_FIELD_NUMBER = 1;
          public static final int WEB_FIELD_NUMBER = 2;
          private boolean a;
          private Tel b = null;
          private boolean c;
          private Web d = null;
          private boolean e;
          private Coms f = null;
          private int g = -1;
          
          public static BookInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new BookInfo().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static BookInfo parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (BookInfo)new BookInfo().mergeFrom(paramArrayOfByte);
          }
          
          public final BookInfo clear()
          {
            clearTel();
            clearWeb();
            clearComs();
            this.g = -1;
            return this;
          }
          
          public BookInfo clearComs()
          {
            this.e = false;
            this.f = null;
            return this;
          }
          
          public BookInfo clearTel()
          {
            this.a = false;
            this.b = null;
            return this;
          }
          
          public BookInfo clearWeb()
          {
            this.c = false;
            this.d = null;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.g < 0) {
              getSerializedSize();
            }
            return this.g;
          }
          
          public Coms getComs()
          {
            return this.f;
          }
          
          public int getSerializedSize()
          {
            int j = 0;
            if (hasTel()) {
              j = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTel());
            }
            int i = j;
            if (hasWeb()) {
              i = j + CodedOutputStreamMicro.computeMessageSize(2, getWeb());
            }
            j = i;
            if (hasComs()) {
              j = i + CodedOutputStreamMicro.computeMessageSize(3, getComs());
            }
            this.g = j;
            return j;
          }
          
          public Tel getTel()
          {
            return this.b;
          }
          
          public Web getWeb()
          {
            return this.d;
          }
          
          public boolean hasComs()
          {
            return this.e;
          }
          
          public boolean hasTel()
          {
            return this.a;
          }
          
          public boolean hasWeb()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public BookInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              Object localObject;
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 10: 
                localObject = new Tel();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                setTel((Tel)localObject);
                break;
              case 18: 
                localObject = new Web();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                setWeb((Web)localObject);
                break;
              case 26: 
                localObject = new Coms();
                paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
                setComs((Coms)localObject);
              }
            }
          }
          
          public BookInfo setComs(Coms paramComs)
          {
            if (paramComs == null) {
              return clearComs();
            }
            this.e = true;
            this.f = paramComs;
            return this;
          }
          
          public BookInfo setTel(Tel paramTel)
          {
            if (paramTel == null) {
              return clearTel();
            }
            this.a = true;
            this.b = paramTel;
            return this;
          }
          
          public BookInfo setWeb(Web paramWeb)
          {
            if (paramWeb == null) {
              return clearWeb();
            }
            this.c = true;
            this.d = paramWeb;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasTel()) {
              paramCodedOutputStreamMicro.writeMessage(1, getTel());
            }
            if (hasWeb()) {
              paramCodedOutputStreamMicro.writeMessage(2, getWeb());
            }
            if (hasComs()) {
              paramCodedOutputStreamMicro.writeMessage(3, getComs());
            }
          }
          
          public static final class Coms
            extends MessageMicro
          {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int TITLE_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 3;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
            private boolean e;
            private String f = "";
            private int g = -1;
            
            public static Coms parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Coms().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Coms parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Coms)new Coms().mergeFrom(paramArrayOfByte);
            }
            
            public final Coms clear()
            {
              clearContent();
              clearTitle();
              clearType();
              this.g = -1;
              return this;
            }
            
            public Coms clearContent()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public Coms clearTitle()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public Coms clearType()
            {
              this.e = false;
              this.f = "";
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.g < 0) {
                getSerializedSize();
              }
              return this.g;
            }
            
            public String getContent()
            {
              return this.b;
            }
            
            public int getSerializedSize()
            {
              int j = 0;
              if (hasContent()) {
                j = 0 + CodedOutputStreamMicro.computeStringSize(1, getContent());
              }
              int i = j;
              if (hasTitle()) {
                i = j + CodedOutputStreamMicro.computeStringSize(2, getTitle());
              }
              j = i;
              if (hasType()) {
                j = i + CodedOutputStreamMicro.computeStringSize(3, getType());
              }
              this.g = j;
              return j;
            }
            
            public String getTitle()
            {
              return this.d;
            }
            
            public String getType()
            {
              return this.f;
            }
            
            public boolean hasContent()
            {
              return this.a;
            }
            
            public boolean hasTitle()
            {
              return this.c;
            }
            
            public boolean hasType()
            {
              return this.e;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Coms mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              for (;;)
              {
                int i = paramCodedInputStreamMicro.readTag();
                switch (i)
                {
                default: 
                  if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                  break;
                case 0: 
                  return this;
                case 10: 
                  setContent(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setTitle(paramCodedInputStreamMicro.readString());
                  break;
                case 26: 
                  setType(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public Coms setContent(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public Coms setTitle(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public Coms setType(String paramString)
            {
              this.e = true;
              this.f = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasContent()) {
                paramCodedOutputStreamMicro.writeString(1, getContent());
              }
              if (hasTitle()) {
                paramCodedOutputStreamMicro.writeString(2, getTitle());
              }
              if (hasType()) {
                paramCodedOutputStreamMicro.writeString(3, getType());
              }
            }
          }
          
          public static final class Tel
            extends MessageMicro
          {
            public static final int CONTENT_FIELD_NUMBER = 2;
            public static final int TITLE_FIELD_NUMBER = 1;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
            private int e = -1;
            
            public static Tel parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Tel().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Tel parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Tel)new Tel().mergeFrom(paramArrayOfByte);
            }
            
            public final Tel clear()
            {
              clearTitle();
              clearContent();
              this.e = -1;
              return this;
            }
            
            public Tel clearContent()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public Tel clearTitle()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.e < 0) {
                getSerializedSize();
              }
              return this.e;
            }
            
            public String getContent()
            {
              return this.d;
            }
            
            public int getSerializedSize()
            {
              int i = 0;
              if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
              }
              int j = i;
              if (hasContent()) {
                j = i + CodedOutputStreamMicro.computeStringSize(2, getContent());
              }
              this.e = j;
              return j;
            }
            
            public String getTitle()
            {
              return this.b;
            }
            
            public boolean hasContent()
            {
              return this.c;
            }
            
            public boolean hasTitle()
            {
              return this.a;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Tel mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              for (;;)
              {
                int i = paramCodedInputStreamMicro.readTag();
                switch (i)
                {
                default: 
                  if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                  break;
                case 0: 
                  return this;
                case 10: 
                  setTitle(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setContent(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public Tel setContent(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public Tel setTitle(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasTitle()) {
                paramCodedOutputStreamMicro.writeString(1, getTitle());
              }
              if (hasContent()) {
                paramCodedOutputStreamMicro.writeString(2, getContent());
              }
            }
          }
          
          public static final class Web
            extends MessageMicro
          {
            public static final int CONTENT_FIELD_NUMBER = 2;
            public static final int TITLE_FIELD_NUMBER = 1;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
            private int e = -1;
            
            public static Web parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Web().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Web parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Web)new Web().mergeFrom(paramArrayOfByte);
            }
            
            public final Web clear()
            {
              clearTitle();
              clearContent();
              this.e = -1;
              return this;
            }
            
            public Web clearContent()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public Web clearTitle()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.e < 0) {
                getSerializedSize();
              }
              return this.e;
            }
            
            public String getContent()
            {
              return this.d;
            }
            
            public int getSerializedSize()
            {
              int i = 0;
              if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
              }
              int j = i;
              if (hasContent()) {
                j = i + CodedOutputStreamMicro.computeStringSize(2, getContent());
              }
              this.e = j;
              return j;
            }
            
            public String getTitle()
            {
              return this.b;
            }
            
            public boolean hasContent()
            {
              return this.c;
            }
            
            public boolean hasTitle()
            {
              return this.a;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Web mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              for (;;)
              {
                int i = paramCodedInputStreamMicro.readTag();
                switch (i)
                {
                default: 
                  if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                  break;
                case 0: 
                  return this;
                case 10: 
                  setTitle(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setContent(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public Web setContent(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public Web setTitle(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasTitle()) {
                paramCodedOutputStreamMicro.writeString(1, getTitle());
              }
              if (hasContent()) {
                paramCodedOutputStreamMicro.writeString(2, getContent());
              }
            }
          }
        }
        
        public static final class Groupon
          extends MessageMicro
        {
          public static final int CN_NAME_FIELD_NUMBER = 8;
          public static final int GROUPON_END_FIELD_NUMBER = 13;
          public static final int GROUPON_ID_FIELD_NUMBER = 6;
          public static final int GROUPON_IMAGE_FIELD_NUMBER = 10;
          public static final int GROUPON_NUM_FIELD_NUMBER = 3;
          public static final int GROUPON_PRICE_FIELD_NUMBER = 4;
          public static final int GROUPON_REBATE_FIELD_NUMBER = 11;
          public static final int GROUPON_SITE_FIELD_NUMBER = 12;
          public static final int GROUPON_START_FIELD_NUMBER = 1;
          public static final int GROUPON_TITLE_FIELD_NUMBER = 14;
          public static final int GROUPON_TYPE_FIELD_NUMBER = 5;
          public static final int GROUPON_URL_MOBILE_FIELD_NUMBER = 7;
          public static final int GROUPON_URL_PC_FIELD_NUMBER = 9;
          public static final int GROUPON_WEBAPP_URL_FIELD_NUMBER = 15;
          public static final int REGULAR_PRICE_FIELD_NUMBER = 2;
          private boolean A;
          private String B = "";
          private boolean C;
          private String D = "";
          private int E = -1;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private boolean g;
          private String h = "";
          private boolean i;
          private String j = "";
          private boolean k;
          private int l = 0;
          private boolean m;
          private String n = "";
          private boolean o;
          private String p = "";
          private boolean q;
          private String r = "";
          private boolean s;
          private String t = "";
          private boolean u;
          private String v = "";
          private boolean w;
          private String x = "";
          private boolean y;
          private String z = "";
          
          public static Groupon parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Groupon().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Groupon parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Groupon)new Groupon().mergeFrom(paramArrayOfByte);
          }
          
          public final Groupon clear()
          {
            clearGrouponStart();
            clearRegularPrice();
            clearGrouponNum();
            clearGrouponPrice();
            clearGrouponType();
            clearGrouponId();
            clearGrouponUrlMobile();
            clearCnName();
            clearGrouponUrlPc();
            clearGrouponImage();
            clearGrouponRebate();
            clearGrouponSite();
            clearGrouponEnd();
            clearGrouponTitle();
            clearGrouponWebappUrl();
            this.E = -1;
            return this;
          }
          
          public Groupon clearCnName()
          {
            this.o = false;
            this.p = "";
            return this;
          }
          
          public Groupon clearGrouponEnd()
          {
            this.y = false;
            this.z = "";
            return this;
          }
          
          public Groupon clearGrouponId()
          {
            this.k = false;
            this.l = 0;
            return this;
          }
          
          public Groupon clearGrouponImage()
          {
            this.s = false;
            this.t = "";
            return this;
          }
          
          public Groupon clearGrouponNum()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public Groupon clearGrouponPrice()
          {
            this.g = false;
            this.h = "";
            return this;
          }
          
          public Groupon clearGrouponRebate()
          {
            this.u = false;
            this.v = "";
            return this;
          }
          
          public Groupon clearGrouponSite()
          {
            this.w = false;
            this.x = "";
            return this;
          }
          
          public Groupon clearGrouponStart()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Groupon clearGrouponTitle()
          {
            this.A = false;
            this.B = "";
            return this;
          }
          
          public Groupon clearGrouponType()
          {
            this.i = false;
            this.j = "";
            return this;
          }
          
          public Groupon clearGrouponUrlMobile()
          {
            this.m = false;
            this.n = "";
            return this;
          }
          
          public Groupon clearGrouponUrlPc()
          {
            this.q = false;
            this.r = "";
            return this;
          }
          
          public Groupon clearGrouponWebappUrl()
          {
            this.C = false;
            this.D = "";
            return this;
          }
          
          public Groupon clearRegularPrice()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.E < 0) {
              getSerializedSize();
            }
            return this.E;
          }
          
          public String getCnName()
          {
            return this.p;
          }
          
          public String getGrouponEnd()
          {
            return this.z;
          }
          
          public int getGrouponId()
          {
            return this.l;
          }
          
          public String getGrouponImage()
          {
            return this.t;
          }
          
          public String getGrouponNum()
          {
            return this.f;
          }
          
          public String getGrouponPrice()
          {
            return this.h;
          }
          
          public String getGrouponRebate()
          {
            return this.v;
          }
          
          public String getGrouponSite()
          {
            return this.x;
          }
          
          public String getGrouponStart()
          {
            return this.b;
          }
          
          public String getGrouponTitle()
          {
            return this.B;
          }
          
          public String getGrouponType()
          {
            return this.j;
          }
          
          public String getGrouponUrlMobile()
          {
            return this.n;
          }
          
          public String getGrouponUrlPc()
          {
            return this.r;
          }
          
          public String getGrouponWebappUrl()
          {
            return this.D;
          }
          
          public String getRegularPrice()
          {
            return this.d;
          }
          
          public int getSerializedSize()
          {
            int i2 = 0;
            if (hasGrouponStart()) {
              i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getGrouponStart());
            }
            int i1 = i2;
            if (hasRegularPrice()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getRegularPrice());
            }
            i2 = i1;
            if (hasGrouponNum()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getGrouponNum());
            }
            i1 = i2;
            if (hasGrouponPrice()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getGrouponPrice());
            }
            i2 = i1;
            if (hasGrouponType()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getGrouponType());
            }
            i1 = i2;
            if (hasGrouponId()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getGrouponId());
            }
            i2 = i1;
            if (hasGrouponUrlMobile()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getGrouponUrlMobile());
            }
            i1 = i2;
            if (hasCnName()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getCnName());
            }
            i2 = i1;
            if (hasGrouponUrlPc()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getGrouponUrlPc());
            }
            i1 = i2;
            if (hasGrouponImage()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getGrouponImage());
            }
            i2 = i1;
            if (hasGrouponRebate()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getGrouponRebate());
            }
            i1 = i2;
            if (hasGrouponSite()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getGrouponSite());
            }
            i2 = i1;
            if (hasGrouponEnd()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getGrouponEnd());
            }
            i1 = i2;
            if (hasGrouponTitle()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getGrouponTitle());
            }
            i2 = i1;
            if (hasGrouponWebappUrl()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getGrouponWebappUrl());
            }
            this.E = i2;
            return i2;
          }
          
          public boolean hasCnName()
          {
            return this.o;
          }
          
          public boolean hasGrouponEnd()
          {
            return this.y;
          }
          
          public boolean hasGrouponId()
          {
            return this.k;
          }
          
          public boolean hasGrouponImage()
          {
            return this.s;
          }
          
          public boolean hasGrouponNum()
          {
            return this.e;
          }
          
          public boolean hasGrouponPrice()
          {
            return this.g;
          }
          
          public boolean hasGrouponRebate()
          {
            return this.u;
          }
          
          public boolean hasGrouponSite()
          {
            return this.w;
          }
          
          public boolean hasGrouponStart()
          {
            return this.a;
          }
          
          public boolean hasGrouponTitle()
          {
            return this.A;
          }
          
          public boolean hasGrouponType()
          {
            return this.i;
          }
          
          public boolean hasGrouponUrlMobile()
          {
            return this.m;
          }
          
          public boolean hasGrouponUrlPc()
          {
            return this.q;
          }
          
          public boolean hasGrouponWebappUrl()
          {
            return this.C;
          }
          
          public boolean hasRegularPrice()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Groupon mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setGrouponStart(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setRegularPrice(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setGrouponNum(paramCodedInputStreamMicro.readString());
                break;
              case 34: 
                setGrouponPrice(paramCodedInputStreamMicro.readString());
                break;
              case 42: 
                setGrouponType(paramCodedInputStreamMicro.readString());
                break;
              case 48: 
                setGrouponId(paramCodedInputStreamMicro.readInt32());
                break;
              case 58: 
                setGrouponUrlMobile(paramCodedInputStreamMicro.readString());
                break;
              case 66: 
                setCnName(paramCodedInputStreamMicro.readString());
                break;
              case 74: 
                setGrouponUrlPc(paramCodedInputStreamMicro.readString());
                break;
              case 82: 
                setGrouponImage(paramCodedInputStreamMicro.readString());
                break;
              case 90: 
                setGrouponRebate(paramCodedInputStreamMicro.readString());
                break;
              case 98: 
                setGrouponSite(paramCodedInputStreamMicro.readString());
                break;
              case 106: 
                setGrouponEnd(paramCodedInputStreamMicro.readString());
                break;
              case 114: 
                setGrouponTitle(paramCodedInputStreamMicro.readString());
                break;
              case 122: 
                setGrouponWebappUrl(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Groupon setCnName(String paramString)
          {
            this.o = true;
            this.p = paramString;
            return this;
          }
          
          public Groupon setGrouponEnd(String paramString)
          {
            this.y = true;
            this.z = paramString;
            return this;
          }
          
          public Groupon setGrouponId(int paramInt)
          {
            this.k = true;
            this.l = paramInt;
            return this;
          }
          
          public Groupon setGrouponImage(String paramString)
          {
            this.s = true;
            this.t = paramString;
            return this;
          }
          
          public Groupon setGrouponNum(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public Groupon setGrouponPrice(String paramString)
          {
            this.g = true;
            this.h = paramString;
            return this;
          }
          
          public Groupon setGrouponRebate(String paramString)
          {
            this.u = true;
            this.v = paramString;
            return this;
          }
          
          public Groupon setGrouponSite(String paramString)
          {
            this.w = true;
            this.x = paramString;
            return this;
          }
          
          public Groupon setGrouponStart(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Groupon setGrouponTitle(String paramString)
          {
            this.A = true;
            this.B = paramString;
            return this;
          }
          
          public Groupon setGrouponType(String paramString)
          {
            this.i = true;
            this.j = paramString;
            return this;
          }
          
          public Groupon setGrouponUrlMobile(String paramString)
          {
            this.m = true;
            this.n = paramString;
            return this;
          }
          
          public Groupon setGrouponUrlPc(String paramString)
          {
            this.q = true;
            this.r = paramString;
            return this;
          }
          
          public Groupon setGrouponWebappUrl(String paramString)
          {
            this.C = true;
            this.D = paramString;
            return this;
          }
          
          public Groupon setRegularPrice(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasGrouponStart()) {
              paramCodedOutputStreamMicro.writeString(1, getGrouponStart());
            }
            if (hasRegularPrice()) {
              paramCodedOutputStreamMicro.writeString(2, getRegularPrice());
            }
            if (hasGrouponNum()) {
              paramCodedOutputStreamMicro.writeString(3, getGrouponNum());
            }
            if (hasGrouponPrice()) {
              paramCodedOutputStreamMicro.writeString(4, getGrouponPrice());
            }
            if (hasGrouponType()) {
              paramCodedOutputStreamMicro.writeString(5, getGrouponType());
            }
            if (hasGrouponId()) {
              paramCodedOutputStreamMicro.writeInt32(6, getGrouponId());
            }
            if (hasGrouponUrlMobile()) {
              paramCodedOutputStreamMicro.writeString(7, getGrouponUrlMobile());
            }
            if (hasCnName()) {
              paramCodedOutputStreamMicro.writeString(8, getCnName());
            }
            if (hasGrouponUrlPc()) {
              paramCodedOutputStreamMicro.writeString(9, getGrouponUrlPc());
            }
            if (hasGrouponImage()) {
              paramCodedOutputStreamMicro.writeString(10, getGrouponImage());
            }
            if (hasGrouponRebate()) {
              paramCodedOutputStreamMicro.writeString(11, getGrouponRebate());
            }
            if (hasGrouponSite()) {
              paramCodedOutputStreamMicro.writeString(12, getGrouponSite());
            }
            if (hasGrouponEnd()) {
              paramCodedOutputStreamMicro.writeString(13, getGrouponEnd());
            }
            if (hasGrouponTitle()) {
              paramCodedOutputStreamMicro.writeString(14, getGrouponTitle());
            }
            if (hasGrouponWebappUrl()) {
              paramCodedOutputStreamMicro.writeString(15, getGrouponWebappUrl());
            }
          }
        }
        
        public static final class HotelOriInfo
          extends MessageMicro
        {
          public static final int HOTEL_FLAG_FIELD_NUMBER = 3;
          public static final int HOTEL_ID_FIELD_NUMBER = 2;
          public static final int SRC_FIELD_NUMBER = 1;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private int g = -1;
          
          public static HotelOriInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new HotelOriInfo().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static HotelOriInfo parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (HotelOriInfo)new HotelOriInfo().mergeFrom(paramArrayOfByte);
          }
          
          public final HotelOriInfo clear()
          {
            clearSrc();
            clearHotelId();
            clearHotelFlag();
            this.g = -1;
            return this;
          }
          
          public HotelOriInfo clearHotelFlag()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public HotelOriInfo clearHotelId()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public HotelOriInfo clearSrc()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.g < 0) {
              getSerializedSize();
            }
            return this.g;
          }
          
          public String getHotelFlag()
          {
            return this.f;
          }
          
          public String getHotelId()
          {
            return this.d;
          }
          
          public int getSerializedSize()
          {
            int j = 0;
            if (hasSrc()) {
              j = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrc());
            }
            int i = j;
            if (hasHotelId()) {
              i = j + CodedOutputStreamMicro.computeStringSize(2, getHotelId());
            }
            j = i;
            if (hasHotelFlag()) {
              j = i + CodedOutputStreamMicro.computeStringSize(3, getHotelFlag());
            }
            this.g = j;
            return j;
          }
          
          public String getSrc()
          {
            return this.b;
          }
          
          public boolean hasHotelFlag()
          {
            return this.e;
          }
          
          public boolean hasHotelId()
          {
            return this.c;
          }
          
          public boolean hasSrc()
          {
            return this.a;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public HotelOriInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 10: 
                setSrc(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setHotelId(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setHotelFlag(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public HotelOriInfo setHotelFlag(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public HotelOriInfo setHotelId(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public HotelOriInfo setSrc(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasSrc()) {
              paramCodedOutputStreamMicro.writeString(1, getSrc());
            }
            if (hasHotelId()) {
              paramCodedOutputStreamMicro.writeString(2, getHotelId());
            }
            if (hasHotelFlag()) {
              paramCodedOutputStreamMicro.writeString(3, getHotelFlag());
            }
          }
        }
        
        public static final class LbcBusinessVip
          extends MessageMicro
        {
          public static final int AMOUNT_FIELD_NUMBER = 3;
          public static final int COMMENT_FIELD_NUMBER = 2;
          public static final int LISTS_FIELD_NUMBER = 4;
          public static final int TYPE_FIELD_NUMBER = 1;
          private boolean a;
          private int b = 0;
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private boolean g;
          private String h = "";
          private int i = -1;
          
          public static LbcBusinessVip parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new LbcBusinessVip().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static LbcBusinessVip parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (LbcBusinessVip)new LbcBusinessVip().mergeFrom(paramArrayOfByte);
          }
          
          public final LbcBusinessVip clear()
          {
            clearType();
            clearComment();
            clearAmount();
            clearLists();
            this.i = -1;
            return this;
          }
          
          public LbcBusinessVip clearAmount()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public LbcBusinessVip clearComment()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public LbcBusinessVip clearLists()
          {
            this.g = false;
            this.h = "";
            return this;
          }
          
          public LbcBusinessVip clearType()
          {
            this.a = false;
            this.b = 0;
            return this;
          }
          
          public String getAmount()
          {
            return this.f;
          }
          
          public int getCachedSize()
          {
            if (this.i < 0) {
              getSerializedSize();
            }
            return this.i;
          }
          
          public String getComment()
          {
            return this.d;
          }
          
          public String getLists()
          {
            return this.h;
          }
          
          public int getSerializedSize()
          {
            int k = 0;
            if (hasType()) {
              k = 0 + CodedOutputStreamMicro.computeInt32Size(1, getType());
            }
            int j = k;
            if (hasComment()) {
              j = k + CodedOutputStreamMicro.computeStringSize(2, getComment());
            }
            k = j;
            if (hasAmount()) {
              k = j + CodedOutputStreamMicro.computeStringSize(3, getAmount());
            }
            j = k;
            if (hasLists()) {
              j = k + CodedOutputStreamMicro.computeStringSize(4, getLists());
            }
            this.i = j;
            return j;
          }
          
          public int getType()
          {
            return this.b;
          }
          
          public boolean hasAmount()
          {
            return this.e;
          }
          
          public boolean hasComment()
          {
            return this.c;
          }
          
          public boolean hasLists()
          {
            return this.g;
          }
          
          public boolean hasType()
          {
            return this.a;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public LbcBusinessVip mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int j = paramCodedInputStreamMicro.readTag();
              switch (j)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
                break;
              case 0: 
                return this;
              case 8: 
                setType(paramCodedInputStreamMicro.readInt32());
                break;
              case 18: 
                setComment(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setAmount(paramCodedInputStreamMicro.readString());
                break;
              case 34: 
                setLists(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public LbcBusinessVip setAmount(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public LbcBusinessVip setComment(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public LbcBusinessVip setLists(String paramString)
          {
            this.g = true;
            this.h = paramString;
            return this;
          }
          
          public LbcBusinessVip setType(int paramInt)
          {
            this.a = true;
            this.b = paramInt;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasType()) {
              paramCodedOutputStreamMicro.writeInt32(1, getType());
            }
            if (hasComment()) {
              paramCodedOutputStreamMicro.writeString(2, getComment());
            }
            if (hasAmount()) {
              paramCodedOutputStreamMicro.writeString(3, getAmount());
            }
            if (hasLists()) {
              paramCodedOutputStreamMicro.writeString(4, getLists());
            }
          }
        }
        
        public static final class Link
          extends MessageMicro
        {
          public static final int CN_NAME_FIELD_NUMBER = 4;
          public static final int NAME_FIELD_NUMBER = 5;
          public static final int SRC_FIELD_NUMBER = 1;
          public static final int URL_FIELD_NUMBER = 2;
          public static final int URL_MOBILEPHONE_FIELD_NUMBER = 3;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private boolean g;
          private String h = "";
          private boolean i;
          private String j = "";
          private int k = -1;
          
          public static Link parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Link().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Link parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Link)new Link().mergeFrom(paramArrayOfByte);
          }
          
          public final Link clear()
          {
            clearSrc();
            clearUrl();
            clearUrlMobilephone();
            clearCnName();
            clearName();
            this.k = -1;
            return this;
          }
          
          public Link clearCnName()
          {
            this.g = false;
            this.h = "";
            return this;
          }
          
          public Link clearName()
          {
            this.i = false;
            this.j = "";
            return this;
          }
          
          public Link clearSrc()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Link clearUrl()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public Link clearUrlMobilephone()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.k < 0) {
              getSerializedSize();
            }
            return this.k;
          }
          
          public String getCnName()
          {
            return this.h;
          }
          
          public String getName()
          {
            return this.j;
          }
          
          public int getSerializedSize()
          {
            int n = 0;
            if (hasSrc()) {
              n = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrc());
            }
            int m = n;
            if (hasUrl()) {
              m = n + CodedOutputStreamMicro.computeStringSize(2, getUrl());
            }
            n = m;
            if (hasUrlMobilephone()) {
              n = m + CodedOutputStreamMicro.computeStringSize(3, getUrlMobilephone());
            }
            m = n;
            if (hasCnName()) {
              m = n + CodedOutputStreamMicro.computeStringSize(4, getCnName());
            }
            n = m;
            if (hasName()) {
              n = m + CodedOutputStreamMicro.computeStringSize(5, getName());
            }
            this.k = n;
            return n;
          }
          
          public String getSrc()
          {
            return this.b;
          }
          
          public String getUrl()
          {
            return this.d;
          }
          
          public String getUrlMobilephone()
          {
            return this.f;
          }
          
          public boolean hasCnName()
          {
            return this.g;
          }
          
          public boolean hasName()
          {
            return this.i;
          }
          
          public boolean hasSrc()
          {
            return this.a;
          }
          
          public boolean hasUrl()
          {
            return this.c;
          }
          
          public boolean hasUrlMobilephone()
          {
            return this.e;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Link mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int m = paramCodedInputStreamMicro.readTag();
              switch (m)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
                break;
              case 0: 
                return this;
              case 10: 
                setSrc(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setUrl(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setUrlMobilephone(paramCodedInputStreamMicro.readString());
                break;
              case 34: 
                setCnName(paramCodedInputStreamMicro.readString());
                break;
              case 42: 
                setName(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Link setCnName(String paramString)
          {
            this.g = true;
            this.h = paramString;
            return this;
          }
          
          public Link setName(String paramString)
          {
            this.i = true;
            this.j = paramString;
            return this;
          }
          
          public Link setSrc(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Link setUrl(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public Link setUrlMobilephone(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasSrc()) {
              paramCodedOutputStreamMicro.writeString(1, getSrc());
            }
            if (hasUrl()) {
              paramCodedOutputStreamMicro.writeString(2, getUrl());
            }
            if (hasUrlMobilephone()) {
              paramCodedOutputStreamMicro.writeString(3, getUrlMobilephone());
            }
            if (hasCnName()) {
              paramCodedOutputStreamMicro.writeString(4, getCnName());
            }
            if (hasName()) {
              paramCodedOutputStreamMicro.writeString(5, getName());
            }
          }
        }
        
        public static final class Mbc
          extends MessageMicro
        {
          public static final int MARKV_FIELD_NUMBER = 1;
          private boolean a;
          private String b = "";
          private int c = -1;
          
          public static Mbc parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Mbc().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Mbc parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Mbc)new Mbc().mergeFrom(paramArrayOfByte);
          }
          
          public final Mbc clear()
          {
            clearMarkv();
            this.c = -1;
            return this;
          }
          
          public Mbc clearMarkv()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.c < 0) {
              getSerializedSize();
            }
            return this.c;
          }
          
          public String getMarkv()
          {
            return this.b;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasMarkv()) {
              i = 0 + CodedOutputStreamMicro.computeStringSize(1, getMarkv());
            }
            this.c = i;
            return i;
          }
          
          public boolean hasMarkv()
          {
            return this.a;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Mbc mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 10: 
                setMarkv(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Mbc setMarkv(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasMarkv()) {
              paramCodedOutputStreamMicro.writeString(1, getMarkv());
            }
          }
        }
        
        public static final class Meishipaihao
          extends MessageMicro
        {
          public static final int IS_OK_FIELD_NUMBER = 1;
          public static final int MAIN_FIELD_NUMBER = 2;
          private boolean a;
          private int b = 0;
          private boolean c;
          private Main d = null;
          private int e = -1;
          
          public static Meishipaihao parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Meishipaihao().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Meishipaihao parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Meishipaihao)new Meishipaihao().mergeFrom(paramArrayOfByte);
          }
          
          public final Meishipaihao clear()
          {
            clearIsOk();
            clearMain();
            this.e = -1;
            return this;
          }
          
          public Meishipaihao clearIsOk()
          {
            this.a = false;
            this.b = 0;
            return this;
          }
          
          public Meishipaihao clearMain()
          {
            this.c = false;
            this.d = null;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.e < 0) {
              getSerializedSize();
            }
            return this.e;
          }
          
          public int getIsOk()
          {
            return this.b;
          }
          
          public Main getMain()
          {
            return this.d;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasIsOk()) {
              i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsOk());
            }
            int j = i;
            if (hasMain()) {
              j = i + CodedOutputStreamMicro.computeMessageSize(2, getMain());
            }
            this.e = j;
            return j;
          }
          
          public boolean hasIsOk()
          {
            return this.a;
          }
          
          public boolean hasMain()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Meishipaihao mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 8: 
                setIsOk(paramCodedInputStreamMicro.readInt32());
                break;
              case 18: 
                Main localMain = new Main();
                paramCodedInputStreamMicro.readMessage(localMain);
                setMain(localMain);
              }
            }
          }
          
          public Meishipaihao setIsOk(int paramInt)
          {
            this.a = true;
            this.b = paramInt;
            return this;
          }
          
          public Meishipaihao setMain(Main paramMain)
          {
            if (paramMain == null) {
              return clearMain();
            }
            this.c = true;
            this.d = paramMain;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasIsOk()) {
              paramCodedOutputStreamMicro.writeInt32(1, getIsOk());
            }
            if (hasMain()) {
              paramCodedOutputStreamMicro.writeMessage(2, getMain());
            }
          }
          
          public static final class Main
            extends MessageMicro
          {
            public static final int THIRD_FROM_FIELD_NUMBER = 1;
            public static final int THIRD_ID_FIELD_NUMBER = 2;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
            private int e = -1;
            
            public static Main parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Main().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Main parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Main)new Main().mergeFrom(paramArrayOfByte);
            }
            
            public final Main clear()
            {
              clearThirdFrom();
              clearThirdId();
              this.e = -1;
              return this;
            }
            
            public Main clearThirdFrom()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public Main clearThirdId()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.e < 0) {
                getSerializedSize();
              }
              return this.e;
            }
            
            public int getSerializedSize()
            {
              int i = 0;
              if (hasThirdFrom()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThirdFrom());
              }
              int j = i;
              if (hasThirdId()) {
                j = i + CodedOutputStreamMicro.computeStringSize(2, getThirdId());
              }
              this.e = j;
              return j;
            }
            
            public String getThirdFrom()
            {
              return this.b;
            }
            
            public String getThirdId()
            {
              return this.d;
            }
            
            public boolean hasThirdFrom()
            {
              return this.a;
            }
            
            public boolean hasThirdId()
            {
              return this.c;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Main mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              for (;;)
              {
                int i = paramCodedInputStreamMicro.readTag();
                switch (i)
                {
                default: 
                  if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                  break;
                case 0: 
                  return this;
                case 10: 
                  setThirdFrom(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setThirdId(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public Main setThirdFrom(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public Main setThirdId(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasThirdFrom()) {
                paramCodedOutputStreamMicro.writeString(1, getThirdFrom());
              }
              if (hasThirdId()) {
                paramCodedOutputStreamMicro.writeString(2, getThirdId());
              }
            }
          }
        }
        
        public static final class OtaInfo
          extends MessageMicro
        {
          public static final int EN_NAME_FIELD_NUMBER = 1;
          public static final int OTA_PHONE_FIELD_NUMBER = 2;
          public static final int OTA_TIPS_FIELD_NUMBER = 3;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private int g = -1;
          
          public static OtaInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new OtaInfo().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static OtaInfo parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (OtaInfo)new OtaInfo().mergeFrom(paramArrayOfByte);
          }
          
          public final OtaInfo clear()
          {
            clearEnName();
            clearOtaPhone();
            clearOtaTips();
            this.g = -1;
            return this;
          }
          
          public OtaInfo clearEnName()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public OtaInfo clearOtaPhone()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public OtaInfo clearOtaTips()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.g < 0) {
              getSerializedSize();
            }
            return this.g;
          }
          
          public String getEnName()
          {
            return this.b;
          }
          
          public String getOtaPhone()
          {
            return this.d;
          }
          
          public String getOtaTips()
          {
            return this.f;
          }
          
          public int getSerializedSize()
          {
            int j = 0;
            if (hasEnName()) {
              j = 0 + CodedOutputStreamMicro.computeStringSize(1, getEnName());
            }
            int i = j;
            if (hasOtaPhone()) {
              i = j + CodedOutputStreamMicro.computeStringSize(2, getOtaPhone());
            }
            j = i;
            if (hasOtaTips()) {
              j = i + CodedOutputStreamMicro.computeStringSize(3, getOtaTips());
            }
            this.g = j;
            return j;
          }
          
          public boolean hasEnName()
          {
            return this.a;
          }
          
          public boolean hasOtaPhone()
          {
            return this.c;
          }
          
          public boolean hasOtaTips()
          {
            return this.e;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public OtaInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 10: 
                setEnName(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setOtaPhone(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setOtaTips(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public OtaInfo setEnName(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public OtaInfo setOtaPhone(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public OtaInfo setOtaTips(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasEnName()) {
              paramCodedOutputStreamMicro.writeString(1, getEnName());
            }
            if (hasOtaPhone()) {
              paramCodedOutputStreamMicro.writeString(2, getOtaPhone());
            }
            if (hasOtaTips()) {
              paramCodedOutputStreamMicro.writeString(3, getOtaTips());
            }
          }
        }
        
        public static final class OtaUrl
          extends MessageMicro
        {
          public static final int SRC_FIELD_NUMBER = 1;
          public static final int URL_FIELD_NUMBER = 2;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private int e = -1;
          
          public static OtaUrl parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new OtaUrl().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static OtaUrl parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (OtaUrl)new OtaUrl().mergeFrom(paramArrayOfByte);
          }
          
          public final OtaUrl clear()
          {
            clearSrc();
            clearUrl();
            this.e = -1;
            return this;
          }
          
          public OtaUrl clearSrc()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public OtaUrl clearUrl()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.e < 0) {
              getSerializedSize();
            }
            return this.e;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasSrc()) {
              i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrc());
            }
            int j = i;
            if (hasUrl()) {
              j = i + CodedOutputStreamMicro.computeStringSize(2, getUrl());
            }
            this.e = j;
            return j;
          }
          
          public String getSrc()
          {
            return this.b;
          }
          
          public String getUrl()
          {
            return this.d;
          }
          
          public boolean hasSrc()
          {
            return this.a;
          }
          
          public boolean hasUrl()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public OtaUrl mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 10: 
                setSrc(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setUrl(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public OtaUrl setSrc(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public OtaUrl setUrl(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasSrc()) {
              paramCodedOutputStreamMicro.writeString(1, getSrc());
            }
            if (hasUrl()) {
              paramCodedOutputStreamMicro.writeString(2, getUrl());
            }
          }
        }
        
        public static final class Point
          extends MessageMicro
        {
          public static final int X_FIELD_NUMBER = 1;
          public static final int Y_FIELD_NUMBER = 2;
          private boolean a;
          private double b = 0.0D;
          private boolean c;
          private double d = 0.0D;
          private int e = -1;
          
          public static Point parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Point().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Point parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Point)new Point().mergeFrom(paramArrayOfByte);
          }
          
          public final Point clear()
          {
            clearX();
            clearY();
            this.e = -1;
            return this;
          }
          
          public Point clearX()
          {
            this.a = false;
            this.b = 0.0D;
            return this;
          }
          
          public Point clearY()
          {
            this.c = false;
            this.d = 0.0D;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.e < 0) {
              getSerializedSize();
            }
            return this.e;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasX()) {
              i = 0 + CodedOutputStreamMicro.computeDoubleSize(1, getX());
            }
            int j = i;
            if (hasY()) {
              j = i + CodedOutputStreamMicro.computeDoubleSize(2, getY());
            }
            this.e = j;
            return j;
          }
          
          public double getX()
          {
            return this.b;
          }
          
          public double getY()
          {
            return this.d;
          }
          
          public boolean hasX()
          {
            return this.a;
          }
          
          public boolean hasY()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Point mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 9: 
                setX(paramCodedInputStreamMicro.readDouble());
                break;
              case 17: 
                setY(paramCodedInputStreamMicro.readDouble());
              }
            }
          }
          
          public Point setX(double paramDouble)
          {
            this.a = true;
            this.b = paramDouble;
            return this;
          }
          
          public Point setY(double paramDouble)
          {
            this.c = true;
            this.d = paramDouble;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasX()) {
              paramCodedOutputStreamMicro.writeDouble(1, getX());
            }
            if (hasY()) {
              paramCodedOutputStreamMicro.writeDouble(2, getY());
            }
          }
        }
        
        public static final class Toplist
          extends MessageMicro
        {
          public static final int TOP_FIELD_NUMBER = 1;
          private boolean a;
          private Top b = null;
          private int c = -1;
          
          public static Toplist parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Toplist().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Toplist parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Toplist)new Toplist().mergeFrom(paramArrayOfByte);
          }
          
          public final Toplist clear()
          {
            clearTop();
            this.c = -1;
            return this;
          }
          
          public Toplist clearTop()
          {
            this.a = false;
            this.b = null;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.c < 0) {
              getSerializedSize();
            }
            return this.c;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasTop()) {
              i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getTop());
            }
            this.c = i;
            return i;
          }
          
          public Top getTop()
          {
            return this.b;
          }
          
          public boolean hasTop()
          {
            return this.a;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Toplist mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 10: 
                Top localTop = new Top();
                paramCodedInputStreamMicro.readMessage(localTop);
                setTop(localTop);
              }
            }
          }
          
          public Toplist setTop(Top paramTop)
          {
            if (paramTop == null) {
              return clearTop();
            }
            this.a = true;
            this.b = paramTop;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasTop()) {
              paramCodedOutputStreamMicro.writeMessage(1, getTop());
            }
          }
          
          public static final class Top
            extends MessageMicro
          {
            public static final int COMMENT_NUM_FIELD_NUMBER = 9;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int OVERALL_RATING_FIELD_NUMBER = 8;
            public static final int RANK_FIELD_NUMBER = 5;
            public static final int REGION_FIELD_NUMBER = 3;
            public static final int TAG_FIELD_NUMBER = 4;
            public static final int TITLE_FIELD_NUMBER = 6;
            public static final int UID_FIELD_NUMBER = 1;
            public static final int WEEK_VISIT_FIELD_NUMBER = 7;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
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
            private String p = "";
            private boolean q;
            private String r = "";
            private int s = -1;
            
            public static Top parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Top().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Top parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Top)new Top().mergeFrom(paramArrayOfByte);
            }
            
            public final Top clear()
            {
              clearUid();
              clearName();
              clearRegion();
              clearTag();
              clearRank();
              clearTitle();
              clearWeekVisit();
              clearOverallRating();
              clearCommentNum();
              this.s = -1;
              return this;
            }
            
            public Top clearCommentNum()
            {
              this.q = false;
              this.r = "";
              return this;
            }
            
            public Top clearName()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public Top clearOverallRating()
            {
              this.o = false;
              this.p = "";
              return this;
            }
            
            public Top clearRank()
            {
              this.i = false;
              this.j = "";
              return this;
            }
            
            public Top clearRegion()
            {
              this.e = false;
              this.f = "";
              return this;
            }
            
            public Top clearTag()
            {
              this.g = false;
              this.h = "";
              return this;
            }
            
            public Top clearTitle()
            {
              this.k = false;
              this.l = "";
              return this;
            }
            
            public Top clearUid()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public Top clearWeekVisit()
            {
              this.m = false;
              this.n = "";
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.s < 0) {
                getSerializedSize();
              }
              return this.s;
            }
            
            public String getCommentNum()
            {
              return this.r;
            }
            
            public String getName()
            {
              return this.d;
            }
            
            public String getOverallRating()
            {
              return this.p;
            }
            
            public String getRank()
            {
              return this.j;
            }
            
            public String getRegion()
            {
              return this.f;
            }
            
            public int getSerializedSize()
            {
              int i2 = 0;
              if (hasUid()) {
                i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
              }
              int i1 = i2;
              if (hasName()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
              }
              i2 = i1;
              if (hasRegion()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getRegion());
              }
              i1 = i2;
              if (hasTag()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getTag());
              }
              i2 = i1;
              if (hasRank()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getRank());
              }
              i1 = i2;
              if (hasTitle()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getTitle());
              }
              i2 = i1;
              if (hasWeekVisit()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getWeekVisit());
              }
              i1 = i2;
              if (hasOverallRating()) {
                i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getOverallRating());
              }
              i2 = i1;
              if (hasCommentNum()) {
                i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getCommentNum());
              }
              this.s = i2;
              return i2;
            }
            
            public String getTag()
            {
              return this.h;
            }
            
            public String getTitle()
            {
              return this.l;
            }
            
            public String getUid()
            {
              return this.b;
            }
            
            public String getWeekVisit()
            {
              return this.n;
            }
            
            public boolean hasCommentNum()
            {
              return this.q;
            }
            
            public boolean hasName()
            {
              return this.c;
            }
            
            public boolean hasOverallRating()
            {
              return this.o;
            }
            
            public boolean hasRank()
            {
              return this.i;
            }
            
            public boolean hasRegion()
            {
              return this.e;
            }
            
            public boolean hasTag()
            {
              return this.g;
            }
            
            public boolean hasTitle()
            {
              return this.k;
            }
            
            public boolean hasUid()
            {
              return this.a;
            }
            
            public boolean hasWeekVisit()
            {
              return this.m;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Top mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                  setUid(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setName(paramCodedInputStreamMicro.readString());
                  break;
                case 26: 
                  setRegion(paramCodedInputStreamMicro.readString());
                  break;
                case 34: 
                  setTag(paramCodedInputStreamMicro.readString());
                  break;
                case 42: 
                  setRank(paramCodedInputStreamMicro.readString());
                  break;
                case 50: 
                  setTitle(paramCodedInputStreamMicro.readString());
                  break;
                case 58: 
                  setWeekVisit(paramCodedInputStreamMicro.readString());
                  break;
                case 66: 
                  setOverallRating(paramCodedInputStreamMicro.readString());
                  break;
                case 74: 
                  setCommentNum(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public Top setCommentNum(String paramString)
            {
              this.q = true;
              this.r = paramString;
              return this;
            }
            
            public Top setName(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public Top setOverallRating(String paramString)
            {
              this.o = true;
              this.p = paramString;
              return this;
            }
            
            public Top setRank(String paramString)
            {
              this.i = true;
              this.j = paramString;
              return this;
            }
            
            public Top setRegion(String paramString)
            {
              this.e = true;
              this.f = paramString;
              return this;
            }
            
            public Top setTag(String paramString)
            {
              this.g = true;
              this.h = paramString;
              return this;
            }
            
            public Top setTitle(String paramString)
            {
              this.k = true;
              this.l = paramString;
              return this;
            }
            
            public Top setUid(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public Top setWeekVisit(String paramString)
            {
              this.m = true;
              this.n = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasUid()) {
                paramCodedOutputStreamMicro.writeString(1, getUid());
              }
              if (hasName()) {
                paramCodedOutputStreamMicro.writeString(2, getName());
              }
              if (hasRegion()) {
                paramCodedOutputStreamMicro.writeString(3, getRegion());
              }
              if (hasTag()) {
                paramCodedOutputStreamMicro.writeString(4, getTag());
              }
              if (hasRank()) {
                paramCodedOutputStreamMicro.writeString(5, getRank());
              }
              if (hasTitle()) {
                paramCodedOutputStreamMicro.writeString(6, getTitle());
              }
              if (hasWeekVisit()) {
                paramCodedOutputStreamMicro.writeString(7, getWeekVisit());
              }
              if (hasOverallRating()) {
                paramCodedOutputStreamMicro.writeString(8, getOverallRating());
              }
              if (hasCommentNum()) {
                paramCodedOutputStreamMicro.writeString(9, getCommentNum());
              }
            }
          }
        }
        
        public static final class Upperleftcorner
          extends MessageMicro
        {
          public static final int RESOURCE_ID_FIELD_NUMBER = 1;
          public static final int RESOURCE_URL_FIELD_NUMBER = 2;
          private boolean a;
          private int b = 0;
          private boolean c;
          private String d = "";
          private int e = -1;
          
          public static Upperleftcorner parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Upperleftcorner().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Upperleftcorner parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Upperleftcorner)new Upperleftcorner().mergeFrom(paramArrayOfByte);
          }
          
          public final Upperleftcorner clear()
          {
            clearResourceId();
            clearResourceUrl();
            this.e = -1;
            return this;
          }
          
          public Upperleftcorner clearResourceId()
          {
            this.a = false;
            this.b = 0;
            return this;
          }
          
          public Upperleftcorner clearResourceUrl()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.e < 0) {
              getSerializedSize();
            }
            return this.e;
          }
          
          public int getResourceId()
          {
            return this.b;
          }
          
          public String getResourceUrl()
          {
            return this.d;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasResourceId()) {
              i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getResourceId());
            }
            int j = i;
            if (hasResourceUrl()) {
              j = i + CodedOutputStreamMicro.computeStringSize(2, getResourceUrl());
            }
            this.e = j;
            return j;
          }
          
          public boolean hasResourceId()
          {
            return this.a;
          }
          
          public boolean hasResourceUrl()
          {
            return this.c;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Upperleftcorner mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 8: 
                setResourceId(paramCodedInputStreamMicro.readInt32());
                break;
              case 18: 
                setResourceUrl(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Upperleftcorner setResourceId(int paramInt)
          {
            this.a = true;
            this.b = paramInt;
            return this;
          }
          
          public Upperleftcorner setResourceUrl(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasResourceId()) {
              paramCodedOutputStreamMicro.writeInt32(1, getResourceId());
            }
            if (hasResourceUrl()) {
              paramCodedOutputStreamMicro.writeString(2, getResourceUrl());
            }
          }
        }
      }
      
      public static final class Image
        extends MessageMicro
      {
        public static final int RECOMMEND_FIELD_NUMBER = 1;
        public static final int TOP_FIELD_NUMBER = 2;
        private List<Recommend> a = Collections.emptyList();
        private List<Top> b = Collections.emptyList();
        private int c = -1;
        
        public static Image parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Image().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Image parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Image)new Image().mergeFrom(paramArrayOfByte);
        }
        
        public Image addRecommend(Recommend paramRecommend)
        {
          if (paramRecommend == null) {
            return this;
          }
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(paramRecommend);
          return this;
        }
        
        public Image addTop(Top paramTop)
        {
          if (paramTop == null) {
            return this;
          }
          if (this.b.isEmpty()) {
            this.b = new ArrayList();
          }
          this.b.add(paramTop);
          return this;
        }
        
        public final Image clear()
        {
          clearRecommend();
          clearTop();
          this.c = -1;
          return this;
        }
        
        public Image clearRecommend()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public Image clearTop()
        {
          this.b = Collections.emptyList();
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.c < 0) {
            getSerializedSize();
          }
          return this.c;
        }
        
        public Recommend getRecommend(int paramInt)
        {
          return (Recommend)this.a.get(paramInt);
        }
        
        public int getRecommendCount()
        {
          return this.a.size();
        }
        
        public List<Recommend> getRecommendList()
        {
          return this.a;
        }
        
        public int getSerializedSize()
        {
          Iterator localIterator = getRecommendList().iterator();
          for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (Recommend)localIterator.next()) + i) {}
          localIterator = getTopList().iterator();
          while (localIterator.hasNext()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, (Top)localIterator.next());
          }
          this.c = i;
          return i;
        }
        
        public Top getTop(int paramInt)
        {
          return (Top)this.b.get(paramInt);
        }
        
        public int getTopCount()
        {
          return this.b.size();
        }
        
        public List<Top> getTopList()
        {
          return this.b;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Image mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          for (;;)
          {
            int i = paramCodedInputStreamMicro.readTag();
            Object localObject;
            switch (i)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
              break;
            case 0: 
              return this;
            case 10: 
              localObject = new Recommend();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addRecommend((Recommend)localObject);
              break;
            case 18: 
              localObject = new Top();
              paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
              addTop((Top)localObject);
            }
          }
        }
        
        public Image setRecommend(int paramInt, Recommend paramRecommend)
        {
          if (paramRecommend == null) {
            return this;
          }
          this.a.set(paramInt, paramRecommend);
          return this;
        }
        
        public Image setTop(int paramInt, Top paramTop)
        {
          if (paramTop == null) {
            return this;
          }
          this.b.set(paramInt, paramTop);
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getRecommendList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(1, (Recommend)localIterator.next());
          }
          localIterator = getTopList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(2, (Top)localIterator.next());
          }
        }
        
        public static final class Recommend
          extends MessageMicro
        {
          public static final int CN_NAME_FIELD_NUMBER = 1;
          public static final int IMGURL_BAK_FIELD_NUMBER = 2;
          public static final int IMGURL_FIELD_NUMBER = 3;
          public static final int LINK_FIELD_NUMBER = 5;
          public static final int LINK_MOBILEPHONE_FIELD_NUMBER = 4;
          public static final int NAME_FIELD_NUMBER = 6;
          public static final int PHOTOID_FIELD_NUMBER = 7;
          public static final int PHOTO_NUM_FIELD_NUMBER = 8;
          public static final int PHOTO_PAGEVIEW_FIELD_NUMBER = 9;
          public static final int PRIORITY_FIELD_NUMBER = 10;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private boolean g;
          private String h = "";
          private boolean i;
          private String j = "";
          private boolean k;
          private String l = "";
          private boolean m;
          private int n = 0;
          private boolean o;
          private int p = 0;
          private boolean q;
          private int r = 0;
          private boolean s;
          private double t = 0.0D;
          private int u = -1;
          
          public static Recommend parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Recommend().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Recommend parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Recommend)new Recommend().mergeFrom(paramArrayOfByte);
          }
          
          public final Recommend clear()
          {
            clearCnName();
            clearImgUrlBak();
            clearImgUrl();
            clearLinkMobilephone();
            clearLink();
            clearName();
            clearPhotoid();
            clearPhotoNum();
            clearPhotoPageview();
            clearPriority();
            this.u = -1;
            return this;
          }
          
          public Recommend clearCnName()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Recommend clearImgUrl()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public Recommend clearImgUrlBak()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public Recommend clearLink()
          {
            this.i = false;
            this.j = "";
            return this;
          }
          
          public Recommend clearLinkMobilephone()
          {
            this.g = false;
            this.h = "";
            return this;
          }
          
          public Recommend clearName()
          {
            this.k = false;
            this.l = "";
            return this;
          }
          
          public Recommend clearPhotoNum()
          {
            this.o = false;
            this.p = 0;
            return this;
          }
          
          public Recommend clearPhotoPageview()
          {
            this.q = false;
            this.r = 0;
            return this;
          }
          
          public Recommend clearPhotoid()
          {
            this.m = false;
            this.n = 0;
            return this;
          }
          
          public Recommend clearPriority()
          {
            this.s = false;
            this.t = 0.0D;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.u < 0) {
              getSerializedSize();
            }
            return this.u;
          }
          
          public String getCnName()
          {
            return this.b;
          }
          
          public String getImgUrl()
          {
            return this.f;
          }
          
          public String getImgUrlBak()
          {
            return this.d;
          }
          
          public String getLink()
          {
            return this.j;
          }
          
          public String getLinkMobilephone()
          {
            return this.h;
          }
          
          public String getName()
          {
            return this.l;
          }
          
          public int getPhotoNum()
          {
            return this.p;
          }
          
          public int getPhotoPageview()
          {
            return this.r;
          }
          
          public int getPhotoid()
          {
            return this.n;
          }
          
          public double getPriority()
          {
            return this.t;
          }
          
          public int getSerializedSize()
          {
            int i2 = 0;
            if (hasCnName()) {
              i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
            }
            int i1 = i2;
            if (hasImgUrlBak()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getImgUrlBak());
            }
            i2 = i1;
            if (hasImgUrl()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getImgUrl());
            }
            i1 = i2;
            if (hasLinkMobilephone()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getLinkMobilephone());
            }
            i2 = i1;
            if (hasLink()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getLink());
            }
            i1 = i2;
            if (hasName()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getName());
            }
            i2 = i1;
            if (hasPhotoid()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getPhotoid());
            }
            i1 = i2;
            if (hasPhotoNum()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getPhotoNum());
            }
            i2 = i1;
            if (hasPhotoPageview()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getPhotoPageview());
            }
            i1 = i2;
            if (hasPriority()) {
              i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(10, getPriority());
            }
            this.u = i1;
            return i1;
          }
          
          public boolean hasCnName()
          {
            return this.a;
          }
          
          public boolean hasImgUrl()
          {
            return this.e;
          }
          
          public boolean hasImgUrlBak()
          {
            return this.c;
          }
          
          public boolean hasLink()
          {
            return this.i;
          }
          
          public boolean hasLinkMobilephone()
          {
            return this.g;
          }
          
          public boolean hasName()
          {
            return this.k;
          }
          
          public boolean hasPhotoNum()
          {
            return this.o;
          }
          
          public boolean hasPhotoPageview()
          {
            return this.q;
          }
          
          public boolean hasPhotoid()
          {
            return this.m;
          }
          
          public boolean hasPriority()
          {
            return this.s;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Recommend mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setCnName(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setImgUrlBak(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setImgUrl(paramCodedInputStreamMicro.readString());
                break;
              case 34: 
                setLinkMobilephone(paramCodedInputStreamMicro.readString());
                break;
              case 42: 
                setLink(paramCodedInputStreamMicro.readString());
                break;
              case 50: 
                setName(paramCodedInputStreamMicro.readString());
                break;
              case 56: 
                setPhotoid(paramCodedInputStreamMicro.readInt32());
                break;
              case 64: 
                setPhotoNum(paramCodedInputStreamMicro.readInt32());
                break;
              case 72: 
                setPhotoPageview(paramCodedInputStreamMicro.readInt32());
                break;
              case 81: 
                setPriority(paramCodedInputStreamMicro.readDouble());
              }
            }
          }
          
          public Recommend setCnName(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Recommend setImgUrl(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public Recommend setImgUrlBak(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public Recommend setLink(String paramString)
          {
            this.i = true;
            this.j = paramString;
            return this;
          }
          
          public Recommend setLinkMobilephone(String paramString)
          {
            this.g = true;
            this.h = paramString;
            return this;
          }
          
          public Recommend setName(String paramString)
          {
            this.k = true;
            this.l = paramString;
            return this;
          }
          
          public Recommend setPhotoNum(int paramInt)
          {
            this.o = true;
            this.p = paramInt;
            return this;
          }
          
          public Recommend setPhotoPageview(int paramInt)
          {
            this.q = true;
            this.r = paramInt;
            return this;
          }
          
          public Recommend setPhotoid(int paramInt)
          {
            this.m = true;
            this.n = paramInt;
            return this;
          }
          
          public Recommend setPriority(double paramDouble)
          {
            this.s = true;
            this.t = paramDouble;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasCnName()) {
              paramCodedOutputStreamMicro.writeString(1, getCnName());
            }
            if (hasImgUrlBak()) {
              paramCodedOutputStreamMicro.writeString(2, getImgUrlBak());
            }
            if (hasImgUrl()) {
              paramCodedOutputStreamMicro.writeString(3, getImgUrl());
            }
            if (hasLinkMobilephone()) {
              paramCodedOutputStreamMicro.writeString(4, getLinkMobilephone());
            }
            if (hasLink()) {
              paramCodedOutputStreamMicro.writeString(5, getLink());
            }
            if (hasName()) {
              paramCodedOutputStreamMicro.writeString(6, getName());
            }
            if (hasPhotoid()) {
              paramCodedOutputStreamMicro.writeInt32(7, getPhotoid());
            }
            if (hasPhotoNum()) {
              paramCodedOutputStreamMicro.writeInt32(8, getPhotoNum());
            }
            if (hasPhotoPageview()) {
              paramCodedOutputStreamMicro.writeInt32(9, getPhotoPageview());
            }
            if (hasPriority()) {
              paramCodedOutputStreamMicro.writeDouble(10, getPriority());
            }
          }
        }
        
        public static final class Top
          extends MessageMicro
        {
          public static final int CN_NAME_FIELD_NUMBER = 1;
          public static final int IMGURL_BAK_FIELD_NUMBER = 2;
          public static final int IMGURL_FIELD_NUMBER = 3;
          public static final int LINK_FIELD_NUMBER = 5;
          public static final int LINK_MOBILEPHONE_FIELD_NUMBER = 4;
          public static final int NAME_FIELD_NUMBER = 6;
          public static final int PHOTOID_FIELD_NUMBER = 7;
          public static final int PHOTO_NUM_FIELD_NUMBER = 8;
          public static final int PHOTO_PAGEVIEW_FIELD_NUMBER = 9;
          public static final int PRIORITY_FIELD_NUMBER = 10;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private boolean g;
          private String h = "";
          private boolean i;
          private String j = "";
          private boolean k;
          private String l = "";
          private boolean m;
          private int n = 0;
          private boolean o;
          private int p = 0;
          private boolean q;
          private int r = 0;
          private boolean s;
          private double t = 0.0D;
          private int u = -1;
          
          public static Top parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Top().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Top parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Top)new Top().mergeFrom(paramArrayOfByte);
          }
          
          public final Top clear()
          {
            clearCnName();
            clearImgUrlBak();
            clearImgUrl();
            clearLinkMobilephone();
            clearLink();
            clearName();
            clearPhotoid();
            clearPhotoNum();
            clearPhotoPageview();
            clearPriority();
            this.u = -1;
            return this;
          }
          
          public Top clearCnName()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Top clearImgUrl()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public Top clearImgUrlBak()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public Top clearLink()
          {
            this.i = false;
            this.j = "";
            return this;
          }
          
          public Top clearLinkMobilephone()
          {
            this.g = false;
            this.h = "";
            return this;
          }
          
          public Top clearName()
          {
            this.k = false;
            this.l = "";
            return this;
          }
          
          public Top clearPhotoNum()
          {
            this.o = false;
            this.p = 0;
            return this;
          }
          
          public Top clearPhotoPageview()
          {
            this.q = false;
            this.r = 0;
            return this;
          }
          
          public Top clearPhotoid()
          {
            this.m = false;
            this.n = 0;
            return this;
          }
          
          public Top clearPriority()
          {
            this.s = false;
            this.t = 0.0D;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.u < 0) {
              getSerializedSize();
            }
            return this.u;
          }
          
          public String getCnName()
          {
            return this.b;
          }
          
          public String getImgUrl()
          {
            return this.f;
          }
          
          public String getImgUrlBak()
          {
            return this.d;
          }
          
          public String getLink()
          {
            return this.j;
          }
          
          public String getLinkMobilephone()
          {
            return this.h;
          }
          
          public String getName()
          {
            return this.l;
          }
          
          public int getPhotoNum()
          {
            return this.p;
          }
          
          public int getPhotoPageview()
          {
            return this.r;
          }
          
          public int getPhotoid()
          {
            return this.n;
          }
          
          public double getPriority()
          {
            return this.t;
          }
          
          public int getSerializedSize()
          {
            int i2 = 0;
            if (hasCnName()) {
              i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
            }
            int i1 = i2;
            if (hasImgUrlBak()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getImgUrlBak());
            }
            i2 = i1;
            if (hasImgUrl()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getImgUrl());
            }
            i1 = i2;
            if (hasLinkMobilephone()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getLinkMobilephone());
            }
            i2 = i1;
            if (hasLink()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getLink());
            }
            i1 = i2;
            if (hasName()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getName());
            }
            i2 = i1;
            if (hasPhotoid()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getPhotoid());
            }
            i1 = i2;
            if (hasPhotoNum()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getPhotoNum());
            }
            i2 = i1;
            if (hasPhotoPageview()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getPhotoPageview());
            }
            i1 = i2;
            if (hasPriority()) {
              i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(10, getPriority());
            }
            this.u = i1;
            return i1;
          }
          
          public boolean hasCnName()
          {
            return this.a;
          }
          
          public boolean hasImgUrl()
          {
            return this.e;
          }
          
          public boolean hasImgUrlBak()
          {
            return this.c;
          }
          
          public boolean hasLink()
          {
            return this.i;
          }
          
          public boolean hasLinkMobilephone()
          {
            return this.g;
          }
          
          public boolean hasName()
          {
            return this.k;
          }
          
          public boolean hasPhotoNum()
          {
            return this.o;
          }
          
          public boolean hasPhotoPageview()
          {
            return this.q;
          }
          
          public boolean hasPhotoid()
          {
            return this.m;
          }
          
          public boolean hasPriority()
          {
            return this.s;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Top mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setCnName(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setImgUrlBak(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setImgUrl(paramCodedInputStreamMicro.readString());
                break;
              case 34: 
                setLinkMobilephone(paramCodedInputStreamMicro.readString());
                break;
              case 42: 
                setLink(paramCodedInputStreamMicro.readString());
                break;
              case 50: 
                setName(paramCodedInputStreamMicro.readString());
                break;
              case 56: 
                setPhotoid(paramCodedInputStreamMicro.readInt32());
                break;
              case 64: 
                setPhotoNum(paramCodedInputStreamMicro.readInt32());
                break;
              case 72: 
                setPhotoPageview(paramCodedInputStreamMicro.readInt32());
                break;
              case 81: 
                setPriority(paramCodedInputStreamMicro.readDouble());
              }
            }
          }
          
          public Top setCnName(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Top setImgUrl(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public Top setImgUrlBak(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public Top setLink(String paramString)
          {
            this.i = true;
            this.j = paramString;
            return this;
          }
          
          public Top setLinkMobilephone(String paramString)
          {
            this.g = true;
            this.h = paramString;
            return this;
          }
          
          public Top setName(String paramString)
          {
            this.k = true;
            this.l = paramString;
            return this;
          }
          
          public Top setPhotoNum(int paramInt)
          {
            this.o = true;
            this.p = paramInt;
            return this;
          }
          
          public Top setPhotoPageview(int paramInt)
          {
            this.q = true;
            this.r = paramInt;
            return this;
          }
          
          public Top setPhotoid(int paramInt)
          {
            this.m = true;
            this.n = paramInt;
            return this;
          }
          
          public Top setPriority(double paramDouble)
          {
            this.s = true;
            this.t = paramDouble;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasCnName()) {
              paramCodedOutputStreamMicro.writeString(1, getCnName());
            }
            if (hasImgUrlBak()) {
              paramCodedOutputStreamMicro.writeString(2, getImgUrlBak());
            }
            if (hasImgUrl()) {
              paramCodedOutputStreamMicro.writeString(3, getImgUrl());
            }
            if (hasLinkMobilephone()) {
              paramCodedOutputStreamMicro.writeString(4, getLinkMobilephone());
            }
            if (hasLink()) {
              paramCodedOutputStreamMicro.writeString(5, getLink());
            }
            if (hasName()) {
              paramCodedOutputStreamMicro.writeString(6, getName());
            }
            if (hasPhotoid()) {
              paramCodedOutputStreamMicro.writeInt32(7, getPhotoid());
            }
            if (hasPhotoNum()) {
              paramCodedOutputStreamMicro.writeInt32(8, getPhotoNum());
            }
            if (hasPhotoPageview()) {
              paramCodedOutputStreamMicro.writeInt32(9, getPhotoPageview());
            }
            if (hasPriority()) {
              paramCodedOutputStreamMicro.writeDouble(10, getPriority());
            }
          }
        }
      }
      
      public static final class LineInfo
        extends MessageMicro
      {
        public static final int ABB_FIELD_NUMBER = 1;
        public static final int CLR_FIELD_NUMBER = 2;
        public static final int FIRST_TIME_FIELD_NUMBER = 3;
        public static final int LAST_TIME_FIELD_NUMBER = 4;
        public static final int LINE_TIME_FIELD_NUMBER = 5;
        public static final int TERMINALS_FIELD_NUMBER = 6;
        public static final int UID_FIELD_NUMBER = 7;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
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
        private int o = -1;
        
        public static LineInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new LineInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static LineInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (LineInfo)new LineInfo().mergeFrom(paramArrayOfByte);
        }
        
        public final LineInfo clear()
        {
          clearAbb();
          clearClr();
          clearFirstTime();
          clearLastTime();
          clearLineTime();
          clearTerminals();
          clearUid();
          this.o = -1;
          return this;
        }
        
        public LineInfo clearAbb()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public LineInfo clearClr()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public LineInfo clearFirstTime()
        {
          this.e = false;
          this.f = "";
          return this;
        }
        
        public LineInfo clearLastTime()
        {
          this.g = false;
          this.h = "";
          return this;
        }
        
        public LineInfo clearLineTime()
        {
          this.i = false;
          this.j = "";
          return this;
        }
        
        public LineInfo clearTerminals()
        {
          this.k = false;
          this.l = "";
          return this;
        }
        
        public LineInfo clearUid()
        {
          this.m = false;
          this.n = "";
          return this;
        }
        
        public String getAbb()
        {
          return this.b;
        }
        
        public int getCachedSize()
        {
          if (this.o < 0) {
            getSerializedSize();
          }
          return this.o;
        }
        
        public String getClr()
        {
          return this.d;
        }
        
        public String getFirstTime()
        {
          return this.f;
        }
        
        public String getLastTime()
        {
          return this.h;
        }
        
        public String getLineTime()
        {
          return this.j;
        }
        
        public int getSerializedSize()
        {
          int i2 = 0;
          if (hasAbb()) {
            i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getAbb());
          }
          int i1 = i2;
          if (hasClr()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getClr());
          }
          i2 = i1;
          if (hasFirstTime()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getFirstTime());
          }
          i1 = i2;
          if (hasLastTime()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getLastTime());
          }
          i2 = i1;
          if (hasLineTime()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getLineTime());
          }
          i1 = i2;
          if (hasTerminals()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getTerminals());
          }
          i2 = i1;
          if (hasUid()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getUid());
          }
          this.o = i2;
          return i2;
        }
        
        public String getTerminals()
        {
          return this.l;
        }
        
        public String getUid()
        {
          return this.n;
        }
        
        public boolean hasAbb()
        {
          return this.a;
        }
        
        public boolean hasClr()
        {
          return this.c;
        }
        
        public boolean hasFirstTime()
        {
          return this.e;
        }
        
        public boolean hasLastTime()
        {
          return this.g;
        }
        
        public boolean hasLineTime()
        {
          return this.i;
        }
        
        public boolean hasTerminals()
        {
          return this.k;
        }
        
        public boolean hasUid()
        {
          return this.m;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public LineInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setAbb(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setClr(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              setFirstTime(paramCodedInputStreamMicro.readString());
              break;
            case 34: 
              setLastTime(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              setLineTime(paramCodedInputStreamMicro.readString());
              break;
            case 50: 
              setTerminals(paramCodedInputStreamMicro.readString());
              break;
            case 58: 
              setUid(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public LineInfo setAbb(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public LineInfo setClr(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public LineInfo setFirstTime(String paramString)
        {
          this.e = true;
          this.f = paramString;
          return this;
        }
        
        public LineInfo setLastTime(String paramString)
        {
          this.g = true;
          this.h = paramString;
          return this;
        }
        
        public LineInfo setLineTime(String paramString)
        {
          this.i = true;
          this.j = paramString;
          return this;
        }
        
        public LineInfo setTerminals(String paramString)
        {
          this.k = true;
          this.l = paramString;
          return this;
        }
        
        public LineInfo setUid(String paramString)
        {
          this.m = true;
          this.n = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasAbb()) {
            paramCodedOutputStreamMicro.writeString(1, getAbb());
          }
          if (hasClr()) {
            paramCodedOutputStreamMicro.writeString(2, getClr());
          }
          if (hasFirstTime()) {
            paramCodedOutputStreamMicro.writeString(3, getFirstTime());
          }
          if (hasLastTime()) {
            paramCodedOutputStreamMicro.writeString(4, getLastTime());
          }
          if (hasLineTime()) {
            paramCodedOutputStreamMicro.writeString(5, getLineTime());
          }
          if (hasTerminals()) {
            paramCodedOutputStreamMicro.writeString(6, getTerminals());
          }
          if (hasUid()) {
            paramCodedOutputStreamMicro.writeString(7, getUid());
          }
        }
      }
      
      public static final class Review
        extends MessageMicro
      {
        public static final int CN_NAME_FIELD_NUMBER = 1;
        public static final int CONTENT_FIELD_NUMBER = 8;
        public static final int DATE_FIELD_NUMBER = 9;
        public static final int ENVIRONMENT_RATING_FIELD_NUMBER = 10;
        public static final int FROM_FIELD_NUMBER = 2;
        public static final int INFO_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int ONE_URL_FIELD_NUMBER = 12;
        public static final int ONE_URL_MOBILE_FIELD_NUMBER = 11;
        public static final int OVERALL_RATING_FIELD_NUMBER = 13;
        public static final int PRICE_FIELD_NUMBER = 14;
        public static final int PRIORITY_FIELD_NUMBER = 15;
        public static final int REVIEW_NUM_FIELD_NUMBER = 7;
        public static final int SERVICE_RATING_FIELD_NUMBER = 16;
        public static final int TASTE_RATING_FIELD_NUMBER = 17;
        public static final int TIME_STAMP_FIELD_NUMBER = 18;
        public static final int URL_FIELD_NUMBER = 6;
        public static final int URL_MOBILEPHONE_FIELD_NUMBER = 5;
        public static final int USER_LOGO_FIELD_NUMBER = 19;
        public static final int USER_NAME_FIELD_NUMBER = 20;
        private String A = "";
        private boolean B;
        private int C = 0;
        private boolean D;
        private String E = "";
        private boolean F;
        private String G = "";
        private boolean H;
        private String I = "";
        private boolean J;
        private String K = "";
        private boolean L;
        private String M = "";
        private int N = -1;
        private List<Info> a = Collections.emptyList();
        private boolean b;
        private String c = "";
        private boolean d;
        private String e = "";
        private boolean f;
        private String g = "";
        private boolean h;
        private String i = "";
        private boolean j;
        private String k = "";
        private boolean l;
        private String m = "";
        private boolean n;
        private String o = "";
        private boolean p;
        private String q = "";
        private boolean r;
        private String s = "";
        private boolean t;
        private String u = "";
        private boolean v;
        private String w = "";
        private boolean x;
        private String y = "";
        private boolean z;
        
        public static Review parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Review().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Review parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Review)new Review().mergeFrom(paramArrayOfByte);
        }
        
        public Review addInfo(Info paramInfo)
        {
          if (paramInfo == null) {
            return this;
          }
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(paramInfo);
          return this;
        }
        
        public final Review clear()
        {
          clearInfo();
          clearCnName();
          clearFrom();
          clearName();
          clearUrlMobilephone();
          clearUrl();
          clearReviewNum();
          clearContent();
          clearDate();
          clearEnvironmentRating();
          clearOneUrlMobile();
          clearOneUrl();
          clearOverallRating();
          clearPrice();
          clearPriority();
          clearServiceRating();
          clearTasteRating();
          clearTimeStamp();
          clearUserLogo();
          clearUserName();
          this.N = -1;
          return this;
        }
        
        public Review clearCnName()
        {
          this.b = false;
          this.c = "";
          return this;
        }
        
        public Review clearContent()
        {
          this.n = false;
          this.o = "";
          return this;
        }
        
        public Review clearDate()
        {
          this.p = false;
          this.q = "";
          return this;
        }
        
        public Review clearEnvironmentRating()
        {
          this.r = false;
          this.s = "";
          return this;
        }
        
        public Review clearFrom()
        {
          this.d = false;
          this.e = "";
          return this;
        }
        
        public Review clearInfo()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public Review clearName()
        {
          this.f = false;
          this.g = "";
          return this;
        }
        
        public Review clearOneUrl()
        {
          this.v = false;
          this.w = "";
          return this;
        }
        
        public Review clearOneUrlMobile()
        {
          this.t = false;
          this.u = "";
          return this;
        }
        
        public Review clearOverallRating()
        {
          this.x = false;
          this.y = "";
          return this;
        }
        
        public Review clearPrice()
        {
          this.z = false;
          this.A = "";
          return this;
        }
        
        public Review clearPriority()
        {
          this.B = false;
          this.C = 0;
          return this;
        }
        
        public Review clearReviewNum()
        {
          this.l = false;
          this.m = "";
          return this;
        }
        
        public Review clearServiceRating()
        {
          this.D = false;
          this.E = "";
          return this;
        }
        
        public Review clearTasteRating()
        {
          this.F = false;
          this.G = "";
          return this;
        }
        
        public Review clearTimeStamp()
        {
          this.H = false;
          this.I = "";
          return this;
        }
        
        public Review clearUrl()
        {
          this.j = false;
          this.k = "";
          return this;
        }
        
        public Review clearUrlMobilephone()
        {
          this.h = false;
          this.i = "";
          return this;
        }
        
        public Review clearUserLogo()
        {
          this.J = false;
          this.K = "";
          return this;
        }
        
        public Review clearUserName()
        {
          this.L = false;
          this.M = "";
          return this;
        }
        
        public int getCachedSize()
        {
          if (this.N < 0) {
            getSerializedSize();
          }
          return this.N;
        }
        
        public String getCnName()
        {
          return this.c;
        }
        
        public String getContent()
        {
          return this.o;
        }
        
        public String getDate()
        {
          return this.q;
        }
        
        public String getEnvironmentRating()
        {
          return this.s;
        }
        
        public String getFrom()
        {
          return this.e;
        }
        
        public Info getInfo(int paramInt)
        {
          return (Info)this.a.get(paramInt);
        }
        
        public int getInfoCount()
        {
          return this.a.size();
        }
        
        public List<Info> getInfoList()
        {
          return this.a;
        }
        
        public String getName()
        {
          return this.g;
        }
        
        public String getOneUrl()
        {
          return this.w;
        }
        
        public String getOneUrlMobile()
        {
          return this.u;
        }
        
        public String getOverallRating()
        {
          return this.y;
        }
        
        public String getPrice()
        {
          return this.A;
        }
        
        public int getPriority()
        {
          return this.C;
        }
        
        public String getReviewNum()
        {
          return this.m;
        }
        
        public int getSerializedSize()
        {
          int i1 = 0;
          if (hasCnName()) {
            i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
          }
          int i2 = i1;
          if (hasFrom()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(2, getFrom());
          }
          Iterator localIterator = getInfoList().iterator();
          while (localIterator.hasNext()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, (Info)localIterator.next()) + i2;
          }
          i1 = i2;
          if (hasName()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getName());
          }
          i2 = i1;
          if (hasUrlMobilephone()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getUrlMobilephone());
          }
          i1 = i2;
          if (hasUrl()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getUrl());
          }
          i2 = i1;
          if (hasReviewNum()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getReviewNum());
          }
          i1 = i2;
          if (hasContent()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getContent());
          }
          i2 = i1;
          if (hasDate()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getDate());
          }
          i1 = i2;
          if (hasEnvironmentRating()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getEnvironmentRating());
          }
          i2 = i1;
          if (hasOneUrlMobile()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getOneUrlMobile());
          }
          i1 = i2;
          if (hasOneUrl()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getOneUrl());
          }
          i2 = i1;
          if (hasOverallRating()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getOverallRating());
          }
          i1 = i2;
          if (hasPrice()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getPrice());
          }
          i2 = i1;
          if (hasPriority()) {
            i2 = i1 + CodedOutputStreamMicro.computeInt32Size(15, getPriority());
          }
          i1 = i2;
          if (hasServiceRating()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getServiceRating());
          }
          i2 = i1;
          if (hasTasteRating()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getTasteRating());
          }
          i1 = i2;
          if (hasTimeStamp()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getTimeStamp());
          }
          i2 = i1;
          if (hasUserLogo()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(19, getUserLogo());
          }
          i1 = i2;
          if (hasUserName()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(20, getUserName());
          }
          this.N = i1;
          return i1;
        }
        
        public String getServiceRating()
        {
          return this.E;
        }
        
        public String getTasteRating()
        {
          return this.G;
        }
        
        public String getTimeStamp()
        {
          return this.I;
        }
        
        public String getUrl()
        {
          return this.k;
        }
        
        public String getUrlMobilephone()
        {
          return this.i;
        }
        
        public String getUserLogo()
        {
          return this.K;
        }
        
        public String getUserName()
        {
          return this.M;
        }
        
        public boolean hasCnName()
        {
          return this.b;
        }
        
        public boolean hasContent()
        {
          return this.n;
        }
        
        public boolean hasDate()
        {
          return this.p;
        }
        
        public boolean hasEnvironmentRating()
        {
          return this.r;
        }
        
        public boolean hasFrom()
        {
          return this.d;
        }
        
        public boolean hasName()
        {
          return this.f;
        }
        
        public boolean hasOneUrl()
        {
          return this.v;
        }
        
        public boolean hasOneUrlMobile()
        {
          return this.t;
        }
        
        public boolean hasOverallRating()
        {
          return this.x;
        }
        
        public boolean hasPrice()
        {
          return this.z;
        }
        
        public boolean hasPriority()
        {
          return this.B;
        }
        
        public boolean hasReviewNum()
        {
          return this.l;
        }
        
        public boolean hasServiceRating()
        {
          return this.D;
        }
        
        public boolean hasTasteRating()
        {
          return this.F;
        }
        
        public boolean hasTimeStamp()
        {
          return this.H;
        }
        
        public boolean hasUrl()
        {
          return this.j;
        }
        
        public boolean hasUrlMobilephone()
        {
          return this.h;
        }
        
        public boolean hasUserLogo()
        {
          return this.J;
        }
        
        public boolean hasUserName()
        {
          return this.L;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Review mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setCnName(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setFrom(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              Info localInfo = new Info();
              paramCodedInputStreamMicro.readMessage(localInfo);
              addInfo(localInfo);
              break;
            case 34: 
              setName(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              setUrlMobilephone(paramCodedInputStreamMicro.readString());
              break;
            case 50: 
              setUrl(paramCodedInputStreamMicro.readString());
              break;
            case 58: 
              setReviewNum(paramCodedInputStreamMicro.readString());
              break;
            case 66: 
              setContent(paramCodedInputStreamMicro.readString());
              break;
            case 74: 
              setDate(paramCodedInputStreamMicro.readString());
              break;
            case 82: 
              setEnvironmentRating(paramCodedInputStreamMicro.readString());
              break;
            case 90: 
              setOneUrlMobile(paramCodedInputStreamMicro.readString());
              break;
            case 98: 
              setOneUrl(paramCodedInputStreamMicro.readString());
              break;
            case 106: 
              setOverallRating(paramCodedInputStreamMicro.readString());
              break;
            case 114: 
              setPrice(paramCodedInputStreamMicro.readString());
              break;
            case 120: 
              setPriority(paramCodedInputStreamMicro.readInt32());
              break;
            case 130: 
              setServiceRating(paramCodedInputStreamMicro.readString());
              break;
            case 138: 
              setTasteRating(paramCodedInputStreamMicro.readString());
              break;
            case 146: 
              setTimeStamp(paramCodedInputStreamMicro.readString());
              break;
            case 154: 
              setUserLogo(paramCodedInputStreamMicro.readString());
              break;
            case 162: 
              setUserName(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Review setCnName(String paramString)
        {
          this.b = true;
          this.c = paramString;
          return this;
        }
        
        public Review setContent(String paramString)
        {
          this.n = true;
          this.o = paramString;
          return this;
        }
        
        public Review setDate(String paramString)
        {
          this.p = true;
          this.q = paramString;
          return this;
        }
        
        public Review setEnvironmentRating(String paramString)
        {
          this.r = true;
          this.s = paramString;
          return this;
        }
        
        public Review setFrom(String paramString)
        {
          this.d = true;
          this.e = paramString;
          return this;
        }
        
        public Review setInfo(int paramInt, Info paramInfo)
        {
          if (paramInfo == null) {
            return this;
          }
          this.a.set(paramInt, paramInfo);
          return this;
        }
        
        public Review setName(String paramString)
        {
          this.f = true;
          this.g = paramString;
          return this;
        }
        
        public Review setOneUrl(String paramString)
        {
          this.v = true;
          this.w = paramString;
          return this;
        }
        
        public Review setOneUrlMobile(String paramString)
        {
          this.t = true;
          this.u = paramString;
          return this;
        }
        
        public Review setOverallRating(String paramString)
        {
          this.x = true;
          this.y = paramString;
          return this;
        }
        
        public Review setPrice(String paramString)
        {
          this.z = true;
          this.A = paramString;
          return this;
        }
        
        public Review setPriority(int paramInt)
        {
          this.B = true;
          this.C = paramInt;
          return this;
        }
        
        public Review setReviewNum(String paramString)
        {
          this.l = true;
          this.m = paramString;
          return this;
        }
        
        public Review setServiceRating(String paramString)
        {
          this.D = true;
          this.E = paramString;
          return this;
        }
        
        public Review setTasteRating(String paramString)
        {
          this.F = true;
          this.G = paramString;
          return this;
        }
        
        public Review setTimeStamp(String paramString)
        {
          this.H = true;
          this.I = paramString;
          return this;
        }
        
        public Review setUrl(String paramString)
        {
          this.j = true;
          this.k = paramString;
          return this;
        }
        
        public Review setUrlMobilephone(String paramString)
        {
          this.h = true;
          this.i = paramString;
          return this;
        }
        
        public Review setUserLogo(String paramString)
        {
          this.J = true;
          this.K = paramString;
          return this;
        }
        
        public Review setUserName(String paramString)
        {
          this.L = true;
          this.M = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasCnName()) {
            paramCodedOutputStreamMicro.writeString(1, getCnName());
          }
          if (hasFrom()) {
            paramCodedOutputStreamMicro.writeString(2, getFrom());
          }
          Iterator localIterator = getInfoList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(3, (Info)localIterator.next());
          }
          if (hasName()) {
            paramCodedOutputStreamMicro.writeString(4, getName());
          }
          if (hasUrlMobilephone()) {
            paramCodedOutputStreamMicro.writeString(5, getUrlMobilephone());
          }
          if (hasUrl()) {
            paramCodedOutputStreamMicro.writeString(6, getUrl());
          }
          if (hasReviewNum()) {
            paramCodedOutputStreamMicro.writeString(7, getReviewNum());
          }
          if (hasContent()) {
            paramCodedOutputStreamMicro.writeString(8, getContent());
          }
          if (hasDate()) {
            paramCodedOutputStreamMicro.writeString(9, getDate());
          }
          if (hasEnvironmentRating()) {
            paramCodedOutputStreamMicro.writeString(10, getEnvironmentRating());
          }
          if (hasOneUrlMobile()) {
            paramCodedOutputStreamMicro.writeString(11, getOneUrlMobile());
          }
          if (hasOneUrl()) {
            paramCodedOutputStreamMicro.writeString(12, getOneUrl());
          }
          if (hasOverallRating()) {
            paramCodedOutputStreamMicro.writeString(13, getOverallRating());
          }
          if (hasPrice()) {
            paramCodedOutputStreamMicro.writeString(14, getPrice());
          }
          if (hasPriority()) {
            paramCodedOutputStreamMicro.writeInt32(15, getPriority());
          }
          if (hasServiceRating()) {
            paramCodedOutputStreamMicro.writeString(16, getServiceRating());
          }
          if (hasTasteRating()) {
            paramCodedOutputStreamMicro.writeString(17, getTasteRating());
          }
          if (hasTimeStamp()) {
            paramCodedOutputStreamMicro.writeString(18, getTimeStamp());
          }
          if (hasUserLogo()) {
            paramCodedOutputStreamMicro.writeString(19, getUserLogo());
          }
          if (hasUserName()) {
            paramCodedOutputStreamMicro.writeString(20, getUserName());
          }
        }
        
        public static final class Info
          extends MessageMicro
        {
          public static final int CONTENT_FIELD_NUMBER = 2;
          public static final int DATE_FIELD_NUMBER = 3;
          public static final int NAME_FIELD_NUMBER = 9;
          public static final int NICK_USER_RECOMMEND_FIELD_NUMBER = 4;
          public static final int ONE_URL_FIELD_NUMBER = 1;
          public static final int OVERALL_RATING_FIELD_NUMBER = 8;
          public static final int PRICE_FIELD_NUMBER = 7;
          public static final int USER_LOGO_FIELD_NUMBER = 6;
          public static final int USER_NAME_FIELD_NUMBER = 5;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private boolean g;
          private String h = "";
          private boolean i;
          private String j = "";
          private boolean k;
          private String l = "";
          private boolean m;
          private int n = 0;
          private boolean o;
          private int p = 0;
          private boolean q;
          private String r = "";
          private int s = -1;
          
          public static Info parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Info().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Info parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Info)new Info().mergeFrom(paramArrayOfByte);
          }
          
          public final Info clear()
          {
            clearOneUrl();
            clearContent();
            clearDate();
            clearNickUserRecommend();
            clearUserName();
            clearUserLogo();
            clearPrice();
            clearOverallRating();
            clearName();
            this.s = -1;
            return this;
          }
          
          public Info clearContent()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public Info clearDate()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public Info clearName()
          {
            this.q = false;
            this.r = "";
            return this;
          }
          
          public Info clearNickUserRecommend()
          {
            this.g = false;
            this.h = "";
            return this;
          }
          
          public Info clearOneUrl()
          {
            this.a = false;
            this.b = "";
            return this;
          }
          
          public Info clearOverallRating()
          {
            this.o = false;
            this.p = 0;
            return this;
          }
          
          public Info clearPrice()
          {
            this.m = false;
            this.n = 0;
            return this;
          }
          
          public Info clearUserLogo()
          {
            this.k = false;
            this.l = "";
            return this;
          }
          
          public Info clearUserName()
          {
            this.i = false;
            this.j = "";
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.s < 0) {
              getSerializedSize();
            }
            return this.s;
          }
          
          public String getContent()
          {
            return this.d;
          }
          
          public String getDate()
          {
            return this.f;
          }
          
          public String getName()
          {
            return this.r;
          }
          
          public String getNickUserRecommend()
          {
            return this.h;
          }
          
          public String getOneUrl()
          {
            return this.b;
          }
          
          public int getOverallRating()
          {
            return this.p;
          }
          
          public int getPrice()
          {
            return this.n;
          }
          
          public int getSerializedSize()
          {
            int i2 = 0;
            if (hasOneUrl()) {
              i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getOneUrl());
            }
            int i1 = i2;
            if (hasContent()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getContent());
            }
            i2 = i1;
            if (hasDate()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getDate());
            }
            i1 = i2;
            if (hasNickUserRecommend()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getNickUserRecommend());
            }
            i2 = i1;
            if (hasUserName()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getUserName());
            }
            i1 = i2;
            if (hasUserLogo()) {
              i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getUserLogo());
            }
            i2 = i1;
            if (hasPrice()) {
              i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getPrice());
            }
            i1 = i2;
            if (hasOverallRating()) {
              i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getOverallRating());
            }
            i2 = i1;
            if (hasName()) {
              i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getName());
            }
            this.s = i2;
            return i2;
          }
          
          public String getUserLogo()
          {
            return this.l;
          }
          
          public String getUserName()
          {
            return this.j;
          }
          
          public boolean hasContent()
          {
            return this.c;
          }
          
          public boolean hasDate()
          {
            return this.e;
          }
          
          public boolean hasName()
          {
            return this.q;
          }
          
          public boolean hasNickUserRecommend()
          {
            return this.g;
          }
          
          public boolean hasOneUrl()
          {
            return this.a;
          }
          
          public boolean hasOverallRating()
          {
            return this.o;
          }
          
          public boolean hasPrice()
          {
            return this.m;
          }
          
          public boolean hasUserLogo()
          {
            return this.k;
          }
          
          public boolean hasUserName()
          {
            return this.i;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Info mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setOneUrl(paramCodedInputStreamMicro.readString());
                break;
              case 18: 
                setContent(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setDate(paramCodedInputStreamMicro.readString());
                break;
              case 34: 
                setNickUserRecommend(paramCodedInputStreamMicro.readString());
                break;
              case 42: 
                setUserName(paramCodedInputStreamMicro.readString());
                break;
              case 50: 
                setUserLogo(paramCodedInputStreamMicro.readString());
                break;
              case 56: 
                setPrice(paramCodedInputStreamMicro.readInt32());
                break;
              case 64: 
                setOverallRating(paramCodedInputStreamMicro.readInt32());
                break;
              case 74: 
                setName(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Info setContent(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public Info setDate(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public Info setName(String paramString)
          {
            this.q = true;
            this.r = paramString;
            return this;
          }
          
          public Info setNickUserRecommend(String paramString)
          {
            this.g = true;
            this.h = paramString;
            return this;
          }
          
          public Info setOneUrl(String paramString)
          {
            this.a = true;
            this.b = paramString;
            return this;
          }
          
          public Info setOverallRating(int paramInt)
          {
            this.o = true;
            this.p = paramInt;
            return this;
          }
          
          public Info setPrice(int paramInt)
          {
            this.m = true;
            this.n = paramInt;
            return this;
          }
          
          public Info setUserLogo(String paramString)
          {
            this.k = true;
            this.l = paramString;
            return this;
          }
          
          public Info setUserName(String paramString)
          {
            this.i = true;
            this.j = paramString;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasOneUrl()) {
              paramCodedOutputStreamMicro.writeString(1, getOneUrl());
            }
            if (hasContent()) {
              paramCodedOutputStreamMicro.writeString(2, getContent());
            }
            if (hasDate()) {
              paramCodedOutputStreamMicro.writeString(3, getDate());
            }
            if (hasNickUserRecommend()) {
              paramCodedOutputStreamMicro.writeString(4, getNickUserRecommend());
            }
            if (hasUserName()) {
              paramCodedOutputStreamMicro.writeString(5, getUserName());
            }
            if (hasUserLogo()) {
              paramCodedOutputStreamMicro.writeString(6, getUserLogo());
            }
            if (hasPrice()) {
              paramCodedOutputStreamMicro.writeInt32(7, getPrice());
            }
            if (hasOverallRating()) {
              paramCodedOutputStreamMicro.writeInt32(8, getOverallRating());
            }
            if (hasName()) {
              paramCodedOutputStreamMicro.writeString(9, getName());
            }
          }
        }
      }
      
      public static final class RichInfo
        extends MessageMicro
      {
        public static final int ALIAS_FIELD_NUMBER = 13;
        public static final int ATMOSPHERE_FIELD_NUMBER = 15;
        public static final int BRAND_FIELD_NUMBER = 4;
        public static final int CATEGORY_FIELD_NUMBER = 3;
        public static final int COMMENT_NO_NUM_FIELD_NUMBER = 2;
        public static final int COMMENT_YES_NUM_FIELD_NUMBER = 1;
        public static final int DESCRIPTION_CN_NAME_FIELD_NUMBER = 16;
        public static final int DESCRIPTION_FIELD_NUMBER = 6;
        public static final int DESCRIPTION_NAME_FIELD_NUMBER = 17;
        public static final int DESCRIPTION_URL_FIELD_NUMBER = 19;
        public static final int DESCRIPTION_URL_MOBILE_FIELD_NUMBER = 18;
        public static final int ENVIRONMENT_EXTERIOR_FIELD_NUMBER = 8;
        public static final int HOTEL_FACILITY_FIELD_NUMBER = 10;
        public static final int HOTEL_SERVICE_FIELD_NUMBER = 11;
        public static final int INNER_FACILITY_FIELD_NUMBER = 9;
        public static final int LEVEL_FIELD_NUMBER = 5;
        public static final int MORE_REVIEWS_FIELD_NUMBER = 20;
        public static final int PAYMENT_TYPE_FIELD_NUMBER = 12;
        public static final int SHOP_HOURS_FIELD_NUMBER = 7;
        private String A = "";
        private boolean B;
        private String C = "";
        private boolean D;
        private String E = "";
        private boolean F;
        private String G = "";
        private boolean H;
        private String I = "";
        private boolean J;
        private String K = "";
        private int L = -1;
        private List<MoreReviews> a = Collections.emptyList();
        private boolean b;
        private String c = "";
        private boolean d;
        private String e = "";
        private boolean f;
        private String g = "";
        private boolean h;
        private String i = "";
        private boolean j;
        private String k = "";
        private boolean l;
        private String m = "";
        private boolean n;
        private String o = "";
        private boolean p;
        private String q = "";
        private boolean r;
        private String s = "";
        private boolean t;
        private String u = "";
        private boolean v;
        private String w = "";
        private boolean x;
        private String y = "";
        private boolean z;
        
        public static RichInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new RichInfo().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static RichInfo parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (RichInfo)new RichInfo().mergeFrom(paramArrayOfByte);
        }
        
        public RichInfo addMoreReviews(MoreReviews paramMoreReviews)
        {
          if (paramMoreReviews == null) {
            return this;
          }
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(paramMoreReviews);
          return this;
        }
        
        public final RichInfo clear()
        {
          clearMoreReviews();
          clearCommentYesNum();
          clearCommentNoNum();
          clearCategory();
          clearBrand();
          clearLevel();
          clearDescription();
          clearShopHours();
          clearEnvironmentExterior();
          clearInnerFacility();
          clearHotelFacility();
          clearHotelService();
          clearPaymentType();
          clearAlias();
          clearAtmosphere();
          clearDescriptionCnName();
          clearDescriptionName();
          clearDescriptionUrlMobile();
          clearDescriptionUrl();
          this.L = -1;
          return this;
        }
        
        public RichInfo clearAlias()
        {
          this.z = false;
          this.A = "";
          return this;
        }
        
        public RichInfo clearAtmosphere()
        {
          this.B = false;
          this.C = "";
          return this;
        }
        
        public RichInfo clearBrand()
        {
          this.h = false;
          this.i = "";
          return this;
        }
        
        public RichInfo clearCategory()
        {
          this.f = false;
          this.g = "";
          return this;
        }
        
        public RichInfo clearCommentNoNum()
        {
          this.d = false;
          this.e = "";
          return this;
        }
        
        public RichInfo clearCommentYesNum()
        {
          this.b = false;
          this.c = "";
          return this;
        }
        
        public RichInfo clearDescription()
        {
          this.l = false;
          this.m = "";
          return this;
        }
        
        public RichInfo clearDescriptionCnName()
        {
          this.D = false;
          this.E = "";
          return this;
        }
        
        public RichInfo clearDescriptionName()
        {
          this.F = false;
          this.G = "";
          return this;
        }
        
        public RichInfo clearDescriptionUrl()
        {
          this.J = false;
          this.K = "";
          return this;
        }
        
        public RichInfo clearDescriptionUrlMobile()
        {
          this.H = false;
          this.I = "";
          return this;
        }
        
        public RichInfo clearEnvironmentExterior()
        {
          this.p = false;
          this.q = "";
          return this;
        }
        
        public RichInfo clearHotelFacility()
        {
          this.t = false;
          this.u = "";
          return this;
        }
        
        public RichInfo clearHotelService()
        {
          this.v = false;
          this.w = "";
          return this;
        }
        
        public RichInfo clearInnerFacility()
        {
          this.r = false;
          this.s = "";
          return this;
        }
        
        public RichInfo clearLevel()
        {
          this.j = false;
          this.k = "";
          return this;
        }
        
        public RichInfo clearMoreReviews()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public RichInfo clearPaymentType()
        {
          this.x = false;
          this.y = "";
          return this;
        }
        
        public RichInfo clearShopHours()
        {
          this.n = false;
          this.o = "";
          return this;
        }
        
        public String getAlias()
        {
          return this.A;
        }
        
        public String getAtmosphere()
        {
          return this.C;
        }
        
        public String getBrand()
        {
          return this.i;
        }
        
        public int getCachedSize()
        {
          if (this.L < 0) {
            getSerializedSize();
          }
          return this.L;
        }
        
        public String getCategory()
        {
          return this.g;
        }
        
        public String getCommentNoNum()
        {
          return this.e;
        }
        
        public String getCommentYesNum()
        {
          return this.c;
        }
        
        public String getDescription()
        {
          return this.m;
        }
        
        public String getDescriptionCnName()
        {
          return this.E;
        }
        
        public String getDescriptionName()
        {
          return this.G;
        }
        
        public String getDescriptionUrl()
        {
          return this.K;
        }
        
        public String getDescriptionUrlMobile()
        {
          return this.I;
        }
        
        public String getEnvironmentExterior()
        {
          return this.q;
        }
        
        public String getHotelFacility()
        {
          return this.u;
        }
        
        public String getHotelService()
        {
          return this.w;
        }
        
        public String getInnerFacility()
        {
          return this.s;
        }
        
        public String getLevel()
        {
          return this.k;
        }
        
        public MoreReviews getMoreReviews(int paramInt)
        {
          return (MoreReviews)this.a.get(paramInt);
        }
        
        public int getMoreReviewsCount()
        {
          return this.a.size();
        }
        
        public List<MoreReviews> getMoreReviewsList()
        {
          return this.a;
        }
        
        public String getPaymentType()
        {
          return this.y;
        }
        
        public int getSerializedSize()
        {
          int i2 = 0;
          if (hasCommentYesNum()) {
            i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCommentYesNum());
          }
          int i1 = i2;
          if (hasCommentNoNum()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getCommentNoNum());
          }
          i2 = i1;
          if (hasCategory()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getCategory());
          }
          i1 = i2;
          if (hasBrand()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getBrand());
          }
          i2 = i1;
          if (hasLevel()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getLevel());
          }
          i1 = i2;
          if (hasDescription()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getDescription());
          }
          i2 = i1;
          if (hasShopHours()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getShopHours());
          }
          i1 = i2;
          if (hasEnvironmentExterior()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getEnvironmentExterior());
          }
          i2 = i1;
          if (hasInnerFacility()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getInnerFacility());
          }
          i1 = i2;
          if (hasHotelFacility()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getHotelFacility());
          }
          i2 = i1;
          if (hasHotelService()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getHotelService());
          }
          i1 = i2;
          if (hasPaymentType()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getPaymentType());
          }
          i2 = i1;
          if (hasAlias()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getAlias());
          }
          i1 = i2;
          if (hasAtmosphere()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(15, getAtmosphere());
          }
          i2 = i1;
          if (hasDescriptionCnName()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(16, getDescriptionCnName());
          }
          i1 = i2;
          if (hasDescriptionName()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(17, getDescriptionName());
          }
          i2 = i1;
          if (hasDescriptionUrlMobile()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(18, getDescriptionUrlMobile());
          }
          i1 = i2;
          if (hasDescriptionUrl()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(19, getDescriptionUrl());
          }
          Iterator localIterator = getMoreReviewsList().iterator();
          while (localIterator.hasNext()) {
            i1 = CodedOutputStreamMicro.computeMessageSize(20, (MoreReviews)localIterator.next()) + i1;
          }
          this.L = i1;
          return i1;
        }
        
        public String getShopHours()
        {
          return this.o;
        }
        
        public boolean hasAlias()
        {
          return this.z;
        }
        
        public boolean hasAtmosphere()
        {
          return this.B;
        }
        
        public boolean hasBrand()
        {
          return this.h;
        }
        
        public boolean hasCategory()
        {
          return this.f;
        }
        
        public boolean hasCommentNoNum()
        {
          return this.d;
        }
        
        public boolean hasCommentYesNum()
        {
          return this.b;
        }
        
        public boolean hasDescription()
        {
          return this.l;
        }
        
        public boolean hasDescriptionCnName()
        {
          return this.D;
        }
        
        public boolean hasDescriptionName()
        {
          return this.F;
        }
        
        public boolean hasDescriptionUrl()
        {
          return this.J;
        }
        
        public boolean hasDescriptionUrlMobile()
        {
          return this.H;
        }
        
        public boolean hasEnvironmentExterior()
        {
          return this.p;
        }
        
        public boolean hasHotelFacility()
        {
          return this.t;
        }
        
        public boolean hasHotelService()
        {
          return this.v;
        }
        
        public boolean hasInnerFacility()
        {
          return this.r;
        }
        
        public boolean hasLevel()
        {
          return this.j;
        }
        
        public boolean hasPaymentType()
        {
          return this.x;
        }
        
        public boolean hasShopHours()
        {
          return this.n;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public RichInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setCommentYesNum(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setCommentNoNum(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              setCategory(paramCodedInputStreamMicro.readString());
              break;
            case 34: 
              setBrand(paramCodedInputStreamMicro.readString());
              break;
            case 42: 
              setLevel(paramCodedInputStreamMicro.readString());
              break;
            case 50: 
              setDescription(paramCodedInputStreamMicro.readString());
              break;
            case 58: 
              setShopHours(paramCodedInputStreamMicro.readString());
              break;
            case 66: 
              setEnvironmentExterior(paramCodedInputStreamMicro.readString());
              break;
            case 74: 
              setInnerFacility(paramCodedInputStreamMicro.readString());
              break;
            case 82: 
              setHotelFacility(paramCodedInputStreamMicro.readString());
              break;
            case 90: 
              setHotelService(paramCodedInputStreamMicro.readString());
              break;
            case 98: 
              setPaymentType(paramCodedInputStreamMicro.readString());
              break;
            case 106: 
              setAlias(paramCodedInputStreamMicro.readString());
              break;
            case 122: 
              setAtmosphere(paramCodedInputStreamMicro.readString());
              break;
            case 130: 
              setDescriptionCnName(paramCodedInputStreamMicro.readString());
              break;
            case 138: 
              setDescriptionName(paramCodedInputStreamMicro.readString());
              break;
            case 146: 
              setDescriptionUrlMobile(paramCodedInputStreamMicro.readString());
              break;
            case 154: 
              setDescriptionUrl(paramCodedInputStreamMicro.readString());
              break;
            case 162: 
              MoreReviews localMoreReviews = new MoreReviews();
              paramCodedInputStreamMicro.readMessage(localMoreReviews);
              addMoreReviews(localMoreReviews);
            }
          }
        }
        
        public RichInfo setAlias(String paramString)
        {
          this.z = true;
          this.A = paramString;
          return this;
        }
        
        public RichInfo setAtmosphere(String paramString)
        {
          this.B = true;
          this.C = paramString;
          return this;
        }
        
        public RichInfo setBrand(String paramString)
        {
          this.h = true;
          this.i = paramString;
          return this;
        }
        
        public RichInfo setCategory(String paramString)
        {
          this.f = true;
          this.g = paramString;
          return this;
        }
        
        public RichInfo setCommentNoNum(String paramString)
        {
          this.d = true;
          this.e = paramString;
          return this;
        }
        
        public RichInfo setCommentYesNum(String paramString)
        {
          this.b = true;
          this.c = paramString;
          return this;
        }
        
        public RichInfo setDescription(String paramString)
        {
          this.l = true;
          this.m = paramString;
          return this;
        }
        
        public RichInfo setDescriptionCnName(String paramString)
        {
          this.D = true;
          this.E = paramString;
          return this;
        }
        
        public RichInfo setDescriptionName(String paramString)
        {
          this.F = true;
          this.G = paramString;
          return this;
        }
        
        public RichInfo setDescriptionUrl(String paramString)
        {
          this.J = true;
          this.K = paramString;
          return this;
        }
        
        public RichInfo setDescriptionUrlMobile(String paramString)
        {
          this.H = true;
          this.I = paramString;
          return this;
        }
        
        public RichInfo setEnvironmentExterior(String paramString)
        {
          this.p = true;
          this.q = paramString;
          return this;
        }
        
        public RichInfo setHotelFacility(String paramString)
        {
          this.t = true;
          this.u = paramString;
          return this;
        }
        
        public RichInfo setHotelService(String paramString)
        {
          this.v = true;
          this.w = paramString;
          return this;
        }
        
        public RichInfo setInnerFacility(String paramString)
        {
          this.r = true;
          this.s = paramString;
          return this;
        }
        
        public RichInfo setLevel(String paramString)
        {
          this.j = true;
          this.k = paramString;
          return this;
        }
        
        public RichInfo setMoreReviews(int paramInt, MoreReviews paramMoreReviews)
        {
          if (paramMoreReviews == null) {
            return this;
          }
          this.a.set(paramInt, paramMoreReviews);
          return this;
        }
        
        public RichInfo setPaymentType(String paramString)
        {
          this.x = true;
          this.y = paramString;
          return this;
        }
        
        public RichInfo setShopHours(String paramString)
        {
          this.n = true;
          this.o = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasCommentYesNum()) {
            paramCodedOutputStreamMicro.writeString(1, getCommentYesNum());
          }
          if (hasCommentNoNum()) {
            paramCodedOutputStreamMicro.writeString(2, getCommentNoNum());
          }
          if (hasCategory()) {
            paramCodedOutputStreamMicro.writeString(3, getCategory());
          }
          if (hasBrand()) {
            paramCodedOutputStreamMicro.writeString(4, getBrand());
          }
          if (hasLevel()) {
            paramCodedOutputStreamMicro.writeString(5, getLevel());
          }
          if (hasDescription()) {
            paramCodedOutputStreamMicro.writeString(6, getDescription());
          }
          if (hasShopHours()) {
            paramCodedOutputStreamMicro.writeString(7, getShopHours());
          }
          if (hasEnvironmentExterior()) {
            paramCodedOutputStreamMicro.writeString(8, getEnvironmentExterior());
          }
          if (hasInnerFacility()) {
            paramCodedOutputStreamMicro.writeString(9, getInnerFacility());
          }
          if (hasHotelFacility()) {
            paramCodedOutputStreamMicro.writeString(10, getHotelFacility());
          }
          if (hasHotelService()) {
            paramCodedOutputStreamMicro.writeString(11, getHotelService());
          }
          if (hasPaymentType()) {
            paramCodedOutputStreamMicro.writeString(12, getPaymentType());
          }
          if (hasAlias()) {
            paramCodedOutputStreamMicro.writeString(13, getAlias());
          }
          if (hasAtmosphere()) {
            paramCodedOutputStreamMicro.writeString(15, getAtmosphere());
          }
          if (hasDescriptionCnName()) {
            paramCodedOutputStreamMicro.writeString(16, getDescriptionCnName());
          }
          if (hasDescriptionName()) {
            paramCodedOutputStreamMicro.writeString(17, getDescriptionName());
          }
          if (hasDescriptionUrlMobile()) {
            paramCodedOutputStreamMicro.writeString(18, getDescriptionUrlMobile());
          }
          if (hasDescriptionUrl()) {
            paramCodedOutputStreamMicro.writeString(19, getDescriptionUrl());
          }
          Iterator localIterator = getMoreReviewsList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(20, (MoreReviews)localIterator.next());
          }
        }
        
        public static final class MoreReviews
          extends MessageMicro
        {
          public static final int DIANPING_FIELD_NUMBER = 1;
          private boolean a;
          private Dianping b = null;
          private int c = -1;
          
          public static MoreReviews parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new MoreReviews().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static MoreReviews parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (MoreReviews)new MoreReviews().mergeFrom(paramArrayOfByte);
          }
          
          public final MoreReviews clear()
          {
            clearDianping();
            this.c = -1;
            return this;
          }
          
          public MoreReviews clearDianping()
          {
            this.a = false;
            this.b = null;
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.c < 0) {
              getSerializedSize();
            }
            return this.c;
          }
          
          public Dianping getDianping()
          {
            return this.b;
          }
          
          public int getSerializedSize()
          {
            int i = 0;
            if (hasDianping()) {
              i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDianping());
            }
            this.c = i;
            return i;
          }
          
          public boolean hasDianping()
          {
            return this.a;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public MoreReviews mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 10: 
                Dianping localDianping = new Dianping();
                paramCodedInputStreamMicro.readMessage(localDianping);
                setDianping(localDianping);
              }
            }
          }
          
          public MoreReviews setDianping(Dianping paramDianping)
          {
            if (paramDianping == null) {
              return clearDianping();
            }
            this.a = true;
            this.b = paramDianping;
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            if (hasDianping()) {
              paramCodedOutputStreamMicro.writeMessage(1, getDianping());
            }
          }
          
          public static final class Dianping
            extends MessageMicro
          {
            public static final int CN_NAME_FIELD_NUMBER = 1;
            public static final int COMMENT_URL_FIELD_NUMBER = 3;
            public static final int COMMENT_URL_MOBILE_FIELD_NUMBER = 2;
            public static final int COUNT_FIELD_NUMBER = 4;
            private boolean a;
            private String b = "";
            private boolean c;
            private String d = "";
            private boolean e;
            private String f = "";
            private boolean g;
            private String h = "";
            private int i = -1;
            
            public static Dianping parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              return new Dianping().mergeFrom(paramCodedInputStreamMicro);
            }
            
            public static Dianping parseFrom(byte[] paramArrayOfByte)
              throws InvalidProtocolBufferMicroException
            {
              return (Dianping)new Dianping().mergeFrom(paramArrayOfByte);
            }
            
            public final Dianping clear()
            {
              clearCnName();
              clearCommentUrlMobile();
              clearCommentUrl();
              clearCount();
              this.i = -1;
              return this;
            }
            
            public Dianping clearCnName()
            {
              this.a = false;
              this.b = "";
              return this;
            }
            
            public Dianping clearCommentUrl()
            {
              this.e = false;
              this.f = "";
              return this;
            }
            
            public Dianping clearCommentUrlMobile()
            {
              this.c = false;
              this.d = "";
              return this;
            }
            
            public Dianping clearCount()
            {
              this.g = false;
              this.h = "";
              return this;
            }
            
            public int getCachedSize()
            {
              if (this.i < 0) {
                getSerializedSize();
              }
              return this.i;
            }
            
            public String getCnName()
            {
              return this.b;
            }
            
            public String getCommentUrl()
            {
              return this.f;
            }
            
            public String getCommentUrlMobile()
            {
              return this.d;
            }
            
            public String getCount()
            {
              return this.h;
            }
            
            public int getSerializedSize()
            {
              int k = 0;
              if (hasCnName()) {
                k = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
              }
              int j = k;
              if (hasCommentUrlMobile()) {
                j = k + CodedOutputStreamMicro.computeStringSize(2, getCommentUrlMobile());
              }
              k = j;
              if (hasCommentUrl()) {
                k = j + CodedOutputStreamMicro.computeStringSize(3, getCommentUrl());
              }
              j = k;
              if (hasCount()) {
                j = k + CodedOutputStreamMicro.computeStringSize(4, getCount());
              }
              this.i = j;
              return j;
            }
            
            public boolean hasCnName()
            {
              return this.a;
            }
            
            public boolean hasCommentUrl()
            {
              return this.e;
            }
            
            public boolean hasCommentUrlMobile()
            {
              return this.c;
            }
            
            public boolean hasCount()
            {
              return this.g;
            }
            
            public final boolean isInitialized()
            {
              return true;
            }
            
            public Dianping mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
              throws IOException
            {
              for (;;)
              {
                int j = paramCodedInputStreamMicro.readTag();
                switch (j)
                {
                default: 
                  if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
                  break;
                case 0: 
                  return this;
                case 10: 
                  setCnName(paramCodedInputStreamMicro.readString());
                  break;
                case 18: 
                  setCommentUrlMobile(paramCodedInputStreamMicro.readString());
                  break;
                case 26: 
                  setCommentUrl(paramCodedInputStreamMicro.readString());
                  break;
                case 34: 
                  setCount(paramCodedInputStreamMicro.readString());
                }
              }
            }
            
            public Dianping setCnName(String paramString)
            {
              this.a = true;
              this.b = paramString;
              return this;
            }
            
            public Dianping setCommentUrl(String paramString)
            {
              this.e = true;
              this.f = paramString;
              return this;
            }
            
            public Dianping setCommentUrlMobile(String paramString)
            {
              this.c = true;
              this.d = paramString;
              return this;
            }
            
            public Dianping setCount(String paramString)
            {
              this.g = true;
              this.h = paramString;
              return this;
            }
            
            public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
              throws IOException
            {
              if (hasCnName()) {
                paramCodedOutputStreamMicro.writeString(1, getCnName());
              }
              if (hasCommentUrlMobile()) {
                paramCodedOutputStreamMicro.writeString(2, getCommentUrlMobile());
              }
              if (hasCommentUrl()) {
                paramCodedOutputStreamMicro.writeString(3, getCommentUrl());
              }
              if (hasCount()) {
                paramCodedOutputStreamMicro.writeString(4, getCount());
              }
            }
          }
        }
      }
    }
    
    public static final class HeadIcon
      extends MessageMicro
    {
      public static final int LINKS_FIELD_NUMBER = 3;
      public static final int PID_FIELD_NUMBER = 4;
      public static final int TYPE_FIELD_NUMBER = 2;
      public static final int URL_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private int d = 0;
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private int i = -1;
      
      public static HeadIcon parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new HeadIcon().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static HeadIcon parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (HeadIcon)new HeadIcon().mergeFrom(paramArrayOfByte);
      }
      
      public final HeadIcon clear()
      {
        clearUrl();
        clearType();
        clearLinks();
        clearPid();
        this.i = -1;
        return this;
      }
      
      public HeadIcon clearLinks()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public HeadIcon clearPid()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public HeadIcon clearType()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public HeadIcon clearUrl()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public String getLinks()
      {
        return this.f;
      }
      
      public String getPid()
      {
        return this.h;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasUrl()) {
          k = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
        }
        int j = k;
        if (hasType()) {
          j = k + CodedOutputStreamMicro.computeInt32Size(2, getType());
        }
        k = j;
        if (hasLinks()) {
          k = j + CodedOutputStreamMicro.computeStringSize(3, getLinks());
        }
        j = k;
        if (hasPid()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getPid());
        }
        this.i = j;
        return j;
      }
      
      public int getType()
      {
        return this.d;
      }
      
      public String getUrl()
      {
        return this.b;
      }
      
      public boolean hasLinks()
      {
        return this.e;
      }
      
      public boolean hasPid()
      {
        return this.g;
      }
      
      public boolean hasType()
      {
        return this.c;
      }
      
      public boolean hasUrl()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public HeadIcon mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int j = paramCodedInputStreamMicro.readTag();
          switch (j)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, j)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setUrl(paramCodedInputStreamMicro.readString());
            break;
          case 16: 
            setType(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            setLinks(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setPid(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public HeadIcon setLinks(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public HeadIcon setPid(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public HeadIcon setType(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public HeadIcon setUrl(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasUrl()) {
          paramCodedOutputStreamMicro.writeString(1, getUrl());
        }
        if (hasType()) {
          paramCodedOutputStreamMicro.writeInt32(2, getType());
        }
        if (hasLinks()) {
          paramCodedOutputStreamMicro.writeString(3, getLinks());
        }
        if (hasPid()) {
          paramCodedOutputStreamMicro.writeString(4, getPid());
        }
      }
    }
    
    public static final class HeatMap
      extends MessageMicro
    {
      public static final int POINTS_FIELD_NUMBER = 2;
      public static final int RANKSTR_FIELD_NUMBER = 1;
      public static final int TYPE_FIELD_NUMBER = 3;
      private boolean a;
      private Points b = null;
      private boolean c;
      private String d = "";
      private boolean e;
      private int f = 0;
      private int g = -1;
      
      public static HeatMap parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new HeatMap().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static HeatMap parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (HeatMap)new HeatMap().mergeFrom(paramArrayOfByte);
      }
      
      public final HeatMap clear()
      {
        clearPoints();
        clearRankstr();
        clearType();
        this.g = -1;
        return this;
      }
      
      public HeatMap clearPoints()
      {
        this.a = false;
        this.b = null;
        return this;
      }
      
      public HeatMap clearRankstr()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public HeatMap clearType()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.g < 0) {
          getSerializedSize();
        }
        return this.g;
      }
      
      public Points getPoints()
      {
        return this.b;
      }
      
      public String getRankstr()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        if (hasRankstr()) {
          j = 0 + CodedOutputStreamMicro.computeStringSize(1, getRankstr());
        }
        int i = j;
        if (hasPoints()) {
          i = j + CodedOutputStreamMicro.computeMessageSize(2, getPoints());
        }
        j = i;
        if (hasType()) {
          j = i + CodedOutputStreamMicro.computeInt32Size(3, getType());
        }
        this.g = j;
        return j;
      }
      
      public int getType()
      {
        return this.f;
      }
      
      public boolean hasPoints()
      {
        return this.a;
      }
      
      public boolean hasRankstr()
      {
        return this.c;
      }
      
      public boolean hasType()
      {
        return this.e;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public HeatMap mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int i = paramCodedInputStreamMicro.readTag();
          switch (i)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setRankstr(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            Points localPoints = new Points();
            paramCodedInputStreamMicro.readMessage(localPoints);
            setPoints(localPoints);
            break;
          case 24: 
            setType(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public HeatMap setPoints(Points paramPoints)
      {
        if (paramPoints == null) {
          return clearPoints();
        }
        this.a = true;
        this.b = paramPoints;
        return this;
      }
      
      public HeatMap setRankstr(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public HeatMap setType(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasRankstr()) {
          paramCodedOutputStreamMicro.writeString(1, getRankstr());
        }
        if (hasPoints()) {
          paramCodedOutputStreamMicro.writeMessage(2, getPoints());
        }
        if (hasType()) {
          paramCodedOutputStreamMicro.writeInt32(3, getType());
        }
      }
      
      public static final class Points
        extends MessageMicro
      {
        public static final int BOUND_FIELD_NUMBER = 1;
        public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 2;
        private List<Integer> a = Collections.emptyList();
        private boolean b;
        private int c = 0;
        private List<GeoElements> d = Collections.emptyList();
        private int e = -1;
        
        public static Points parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Points().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Points parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Points)new Points().mergeFrom(paramArrayOfByte);
        }
        
        public Points addBound(int paramInt)
        {
          if (this.a.isEmpty()) {
            this.a = new ArrayList();
          }
          this.a.add(Integer.valueOf(paramInt));
          return this;
        }
        
        public Points addGeoElements(GeoElements paramGeoElements)
        {
          if (paramGeoElements == null) {
            return this;
          }
          if (this.d.isEmpty()) {
            this.d = new ArrayList();
          }
          this.d.add(paramGeoElements);
          return this;
        }
        
        public final Points clear()
        {
          clearBound();
          clearType();
          clearGeoElements();
          this.e = -1;
          return this;
        }
        
        public Points clearBound()
        {
          this.a = Collections.emptyList();
          return this;
        }
        
        public Points clearGeoElements()
        {
          this.d = Collections.emptyList();
          return this;
        }
        
        public Points clearType()
        {
          this.b = false;
          this.c = 0;
          return this;
        }
        
        public int getBound(int paramInt)
        {
          return ((Integer)this.a.get(paramInt)).intValue();
        }
        
        public int getBoundCount()
        {
          return this.a.size();
        }
        
        public List<Integer> getBoundList()
        {
          return this.a;
        }
        
        public int getCachedSize()
        {
          if (this.e < 0) {
            getSerializedSize();
          }
          return this.e;
        }
        
        public GeoElements getGeoElements(int paramInt)
        {
          return (GeoElements)this.d.get(paramInt);
        }
        
        public int getGeoElementsCount()
        {
          return this.d.size();
        }
        
        public List<GeoElements> getGeoElementsList()
        {
          return this.d;
        }
        
        public int getSerializedSize()
        {
          Iterator localIterator = getBoundList().iterator();
          for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
          int j = 0 + i + getBoundList().size() * 1;
          i = j;
          if (hasType()) {
            i = j + CodedOutputStreamMicro.computeInt32Size(2, getType());
          }
          localIterator = getGeoElementsList().iterator();
          while (localIterator.hasNext()) {
            i = CodedOutputStreamMicro.computeMessageSize(3, (GeoElements)localIterator.next()) + i;
          }
          this.e = i;
          return i;
        }
        
        public int getType()
        {
          return this.c;
        }
        
        public boolean hasType()
        {
          return this.b;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Points mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          for (;;)
          {
            int i = paramCodedInputStreamMicro.readTag();
            switch (i)
            {
            default: 
              if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
              break;
            case 0: 
              return this;
            case 8: 
              addBound(paramCodedInputStreamMicro.readSInt32());
              break;
            case 16: 
              setType(paramCodedInputStreamMicro.readInt32());
              break;
            case 26: 
              GeoElements localGeoElements = new GeoElements();
              paramCodedInputStreamMicro.readMessage(localGeoElements);
              addGeoElements(localGeoElements);
            }
          }
        }
        
        public Points setBound(int paramInt1, int paramInt2)
        {
          this.a.set(paramInt1, Integer.valueOf(paramInt2));
          return this;
        }
        
        public Points setGeoElements(int paramInt, GeoElements paramGeoElements)
        {
          if (paramGeoElements == null) {
            return this;
          }
          this.d.set(paramInt, paramGeoElements);
          return this;
        }
        
        public Points setType(int paramInt)
        {
          this.b = true;
          this.c = paramInt;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          Iterator localIterator = getBoundList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeSInt32(1, ((Integer)localIterator.next()).intValue());
          }
          if (hasType()) {
            paramCodedOutputStreamMicro.writeInt32(2, getType());
          }
          localIterator = getGeoElementsList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(3, (GeoElements)localIterator.next());
          }
        }
        
        public static final class GeoElements
          extends MessageMicro
        {
          public static final int POINT_FIELD_NUMBER = 1;
          private List<Integer> a = Collections.emptyList();
          private int b = -1;
          
          public static GeoElements parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new GeoElements().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static GeoElements parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (GeoElements)new GeoElements().mergeFrom(paramArrayOfByte);
          }
          
          public GeoElements addPoint(int paramInt)
          {
            if (this.a.isEmpty()) {
              this.a = new ArrayList();
            }
            this.a.add(Integer.valueOf(paramInt));
            return this;
          }
          
          public final GeoElements clear()
          {
            clearPoint();
            this.b = -1;
            return this;
          }
          
          public GeoElements clearPoint()
          {
            this.a = Collections.emptyList();
            return this;
          }
          
          public int getCachedSize()
          {
            if (this.b < 0) {
              getSerializedSize();
            }
            return this.b;
          }
          
          public int getPoint(int paramInt)
          {
            return ((Integer)this.a.get(paramInt)).intValue();
          }
          
          public int getPointCount()
          {
            return this.a.size();
          }
          
          public List<Integer> getPointList()
          {
            return this.a;
          }
          
          public int getSerializedSize()
          {
            Iterator localIterator = getPointList().iterator();
            for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue()) + i) {}
            i = 0 + i + getPointList().size() * 1;
            this.b = i;
            return i;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public GeoElements mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            for (;;)
            {
              int i = paramCodedInputStreamMicro.readTag();
              switch (i)
              {
              default: 
                if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
                break;
              case 0: 
                return this;
              case 8: 
                addPoint(paramCodedInputStreamMicro.readSInt32());
              }
            }
          }
          
          public GeoElements setPoint(int paramInt1, int paramInt2)
          {
            this.a.set(paramInt1, Integer.valueOf(paramInt2));
            return this;
          }
          
          public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
            throws IOException
          {
            Iterator localIterator = getPointList().iterator();
            while (localIterator.hasNext()) {
              paramCodedOutputStreamMicro.writeSInt32(1, ((Integer)localIterator.next()).intValue());
            }
          }
        }
      }
    }
    
    public static final class OriginId
      extends MessageMicro
    {
      public static final int LBC_UID_FIELD_NUMBER = 1;
      public static final int OVERVIEW_GUID_FIELD_NUMBER = 2;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private int e = -1;
      
      public static OriginId parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new OriginId().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static OriginId parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (OriginId)new OriginId().mergeFrom(paramArrayOfByte);
      }
      
      public final OriginId clear()
      {
        clearLbcUid();
        clearOverviewGuid();
        this.e = -1;
        return this;
      }
      
      public OriginId clearLbcUid()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public OriginId clearOverviewGuid()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.e < 0) {
          getSerializedSize();
        }
        return this.e;
      }
      
      public String getLbcUid()
      {
        return this.b;
      }
      
      public String getOverviewGuid()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasLbcUid()) {
          i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLbcUid());
        }
        int j = i;
        if (hasOverviewGuid()) {
          j = i + CodedOutputStreamMicro.computeStringSize(2, getOverviewGuid());
        }
        this.e = j;
        return j;
      }
      
      public boolean hasLbcUid()
      {
        return this.a;
      }
      
      public boolean hasOverviewGuid()
      {
        return this.c;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public OriginId mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int i = paramCodedInputStreamMicro.readTag();
          switch (i)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setLbcUid(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setOverviewGuid(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public OriginId setLbcUid(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public OriginId setOverviewGuid(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasLbcUid()) {
          paramCodedOutputStreamMicro.writeString(1, getLbcUid());
        }
        if (hasOverviewGuid()) {
          paramCodedOutputStreamMicro.writeString(2, getOverviewGuid());
        }
      }
    }
    
    public static final class OtherStations
      extends MessageMicro
    {
      public static final int ADDR_FIELD_NUMBER = 2;
      public static final int ICON_ID_FIELD_NUMBER = 3;
      public static final int UID_FIELD_NUMBER = 1;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private int f = 0;
      private int g = -1;
      
      public static OtherStations parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new OtherStations().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static OtherStations parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (OtherStations)new OtherStations().mergeFrom(paramArrayOfByte);
      }
      
      public final OtherStations clear()
      {
        clearUid();
        clearAddr();
        clearIconId();
        this.g = -1;
        return this;
      }
      
      public OtherStations clearAddr()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public OtherStations clearIconId()
      {
        this.e = false;
        this.f = 0;
        return this;
      }
      
      public OtherStations clearUid()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public String getAddr()
      {
        return this.d;
      }
      
      public int getCachedSize()
      {
        if (this.g < 0) {
          getSerializedSize();
        }
        return this.g;
      }
      
      public int getIconId()
      {
        return this.f;
      }
      
      public int getSerializedSize()
      {
        int j = 0;
        if (hasUid()) {
          j = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
        }
        int i = j;
        if (hasAddr()) {
          i = j + CodedOutputStreamMicro.computeStringSize(2, getAddr());
        }
        j = i;
        if (hasIconId()) {
          j = i + CodedOutputStreamMicro.computeInt32Size(3, getIconId());
        }
        this.g = j;
        return j;
      }
      
      public String getUid()
      {
        return this.b;
      }
      
      public boolean hasAddr()
      {
        return this.c;
      }
      
      public boolean hasIconId()
      {
        return this.e;
      }
      
      public boolean hasUid()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public OtherStations mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        for (;;)
        {
          int i = paramCodedInputStreamMicro.readTag();
          switch (i)
          {
          default: 
            if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
            break;
          case 0: 
            return this;
          case 10: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setAddr(paramCodedInputStreamMicro.readString());
            break;
          case 24: 
            setIconId(paramCodedInputStreamMicro.readInt32());
          }
        }
      }
      
      public OtherStations setAddr(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public OtherStations setIconId(int paramInt)
      {
        this.e = true;
        this.f = paramInt;
        return this;
      }
      
      public OtherStations setUid(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(1, getUid());
        }
        if (hasAddr()) {
          paramCodedOutputStreamMicro.writeString(2, getAddr());
        }
        if (hasIconId()) {
          paramCodedOutputStreamMicro.writeInt32(3, getIconId());
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int CHANNEL_FIELD_NUMBER = 3;
    public static final int CLIENTSV_FIELD_NUMBER = 4;
    public static final int HAS_RTBUS_FIELD_NUMBER = 1;
    public static final int IM_FIELD_NUMBER = 5;
    public static final int LDATA_FIELD_NUMBER = 14;
    public static final int MB_FIELD_NUMBER = 6;
    public static final int NEWMAP_FIELD_NUMBER = 7;
    public static final int OS_FIELD_NUMBER = 8;
    public static final int QID_FIELD_NUMBER = 2;
    public static final int QT_FIELD_NUMBER = 9;
    public static final int REGION_TYPE_FIELD_NUMBER = 15;
    public static final int RESID_FIELD_NUMBER = 10;
    public static final int SV_FIELD_NUMBER = 11;
    public static final int TIME_FIELD_NUMBER = 12;
    public static final int WD_FIELD_NUMBER = 13;
    private boolean A;
    private String B = "";
    private boolean C;
    private String D = "";
    private int E = -1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
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
    private String p = "";
    private boolean q;
    private String r = "";
    private boolean s;
    private String t = "";
    private boolean u;
    private String v = "";
    private boolean w;
    private int x = 0;
    private boolean y;
    private String z = "";
    
    public static Option parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Option().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Option parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Option)new Option().mergeFrom(paramArrayOfByte);
    }
    
    public final Option clear()
    {
      clearHasRtbus();
      clearQid();
      clearChannel();
      clearClientsv();
      clearIm();
      clearMb();
      clearNewmap();
      clearOs();
      clearQt();
      clearResid();
      clearSv();
      clearTime();
      clearWd();
      clearLdata();
      clearRegionType();
      this.E = -1;
      return this;
    }
    
    public Option clearChannel()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Option clearClientsv()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Option clearHasRtbus()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Option clearIm()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Option clearLdata()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public Option clearMb()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Option clearNewmap()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Option clearOs()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public Option clearQid()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Option clearQt()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Option clearRegionType()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public Option clearResid()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public Option clearSv()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public Option clearTime()
    {
      this.w = false;
      this.x = 0;
      return this;
    }
    
    public Option clearWd()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.E < 0) {
        getSerializedSize();
      }
      return this.E;
    }
    
    public String getChannel()
    {
      return this.f;
    }
    
    public String getClientsv()
    {
      return this.h;
    }
    
    public int getHasRtbus()
    {
      return this.b;
    }
    
    public String getIm()
    {
      return this.j;
    }
    
    public String getLdata()
    {
      return this.B;
    }
    
    public String getMb()
    {
      return this.l;
    }
    
    public String getNewmap()
    {
      return this.n;
    }
    
    public String getOs()
    {
      return this.p;
    }
    
    public String getQid()
    {
      return this.d;
    }
    
    public String getQt()
    {
      return this.r;
    }
    
    public String getRegionType()
    {
      return this.D;
    }
    
    public String getResid()
    {
      return this.t;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasHasRtbus()) {
        i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getHasRtbus());
      }
      int i1 = i2;
      if (hasQid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getQid());
      }
      i2 = i1;
      if (hasChannel()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getChannel());
      }
      i1 = i2;
      if (hasClientsv()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getClientsv());
      }
      i2 = i1;
      if (hasIm()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getIm());
      }
      i1 = i2;
      if (hasMb()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getMb());
      }
      i2 = i1;
      if (hasNewmap()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getNewmap());
      }
      i1 = i2;
      if (hasOs()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getOs());
      }
      i2 = i1;
      if (hasQt()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getQt());
      }
      i1 = i2;
      if (hasResid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getResid());
      }
      i2 = i1;
      if (hasSv()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getSv());
      }
      i1 = i2;
      if (hasTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getTime());
      }
      i2 = i1;
      if (hasWd()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getWd());
      }
      i1 = i2;
      if (hasLdata()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getLdata());
      }
      i2 = i1;
      if (hasRegionType()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getRegionType());
      }
      this.E = i2;
      return i2;
    }
    
    public String getSv()
    {
      return this.v;
    }
    
    public int getTime()
    {
      return this.x;
    }
    
    public String getWd()
    {
      return this.z;
    }
    
    public boolean hasChannel()
    {
      return this.e;
    }
    
    public boolean hasClientsv()
    {
      return this.g;
    }
    
    public boolean hasHasRtbus()
    {
      return this.a;
    }
    
    public boolean hasIm()
    {
      return this.i;
    }
    
    public boolean hasLdata()
    {
      return this.A;
    }
    
    public boolean hasMb()
    {
      return this.k;
    }
    
    public boolean hasNewmap()
    {
      return this.m;
    }
    
    public boolean hasOs()
    {
      return this.o;
    }
    
    public boolean hasQid()
    {
      return this.c;
    }
    
    public boolean hasQt()
    {
      return this.q;
    }
    
    public boolean hasRegionType()
    {
      return this.C;
    }
    
    public boolean hasResid()
    {
      return this.s;
    }
    
    public boolean hasSv()
    {
      return this.u;
    }
    
    public boolean hasTime()
    {
      return this.w;
    }
    
    public boolean hasWd()
    {
      return this.y;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Option mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        case 8: 
          setHasRtbus(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setQid(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setChannel(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setClientsv(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setIm(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setMb(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setNewmap(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setOs(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setQt(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setResid(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setSv(paramCodedInputStreamMicro.readString());
          break;
        case 96: 
          setTime(paramCodedInputStreamMicro.readInt32());
          break;
        case 106: 
          setWd(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setLdata(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setRegionType(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Option setChannel(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Option setClientsv(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Option setHasRtbus(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Option setIm(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Option setLdata(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public Option setMb(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Option setNewmap(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Option setOs(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public Option setQid(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Option setQt(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Option setRegionType(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public Option setResid(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public Option setSv(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public Option setTime(int paramInt)
    {
      this.w = true;
      this.x = paramInt;
      return this;
    }
    
    public Option setWd(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasHasRtbus()) {
        paramCodedOutputStreamMicro.writeInt32(1, getHasRtbus());
      }
      if (hasQid()) {
        paramCodedOutputStreamMicro.writeString(2, getQid());
      }
      if (hasChannel()) {
        paramCodedOutputStreamMicro.writeString(3, getChannel());
      }
      if (hasClientsv()) {
        paramCodedOutputStreamMicro.writeString(4, getClientsv());
      }
      if (hasIm()) {
        paramCodedOutputStreamMicro.writeString(5, getIm());
      }
      if (hasMb()) {
        paramCodedOutputStreamMicro.writeString(6, getMb());
      }
      if (hasNewmap()) {
        paramCodedOutputStreamMicro.writeString(7, getNewmap());
      }
      if (hasOs()) {
        paramCodedOutputStreamMicro.writeString(8, getOs());
      }
      if (hasQt()) {
        paramCodedOutputStreamMicro.writeString(9, getQt());
      }
      if (hasResid()) {
        paramCodedOutputStreamMicro.writeString(10, getResid());
      }
      if (hasSv()) {
        paramCodedOutputStreamMicro.writeString(11, getSv());
      }
      if (hasTime()) {
        paramCodedOutputStreamMicro.writeInt32(12, getTime());
      }
      if (hasWd()) {
        paramCodedOutputStreamMicro.writeString(13, getWd());
      }
      if (hasLdata()) {
        paramCodedOutputStreamMicro.writeString(14, getLdata());
      }
      if (hasRegionType()) {
        paramCodedOutputStreamMicro.writeString(15, getRegionType());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Inf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */