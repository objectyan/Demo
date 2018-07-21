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

public final class Opnlayer
  extends MessageMicro
{
  public static final int BORDERLB_FIELD_NUMBER = 10;
  public static final int BORDERRT_FIELD_NUMBER = 11;
  public static final int BOTTOMICON_FIELD_NUMBER = 15;
  public static final int CENTER_FIELD_NUMBER = 4;
  public static final int EVENTTITLE_FIELD_NUMBER = 1;
  public static final int EVENTTYPE_FIELD_NUMBER = 2;
  public static final int FIRSTSHOW_FIELD_NUMBER = 18;
  public static final int ICON_FIELD_NUMBER = 6;
  public static final int IMAGEBOTTOM_FIELD_NUMBER = 7;
  public static final int IMAGEBUTTON_FIELD_NUMBER = 12;
  public static final int IMAGETOP_FIELD_NUMBER = 8;
  public static final int JUMPTO_FIELD_NUMBER = 16;
  public static final int LEVEL_FIELD_NUMBER = 3;
  public static final int NEEDLOGIN_FIELD_NUMBER = 19;
  public static final int NOTICE_FIELD_NUMBER = 17;
  public static final int POINTINFO_FIELD_NUMBER = 9;
  public static final int REFERSHMETERS_FIELD_NUMBER = 14;
  public static final int REFRESHSEC_FIELD_NUMBER = 13;
  public static final int SHARE_FIELD_NUMBER = 5;
  private int A = 0;
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
  private boolean a;
  private String b = "";
  private boolean c;
  private int d = 0;
  private boolean e;
  private int f = 0;
  private boolean g;
  private String h = "";
  private boolean i;
  private Share j = null;
  private boolean k;
  private String l = "";
  private boolean m;
  private String n = "";
  private boolean o;
  private String p = "";
  private List<Poi> q = Collections.emptyList();
  private boolean r;
  private String s = "";
  private boolean t;
  private String u = "";
  private boolean v;
  private String w = "";
  private boolean x;
  private int y = 0;
  private boolean z;
  
  public static Opnlayer parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Opnlayer().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Opnlayer parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Opnlayer)new Opnlayer().mergeFrom(paramArrayOfByte);
  }
  
  public Opnlayer addPointinfo(Poi paramPoi)
  {
    if (paramPoi == null) {
      return this;
    }
    if (this.q.isEmpty()) {
      this.q = new ArrayList();
    }
    this.q.add(paramPoi);
    return this;
  }
  
  public final Opnlayer clear()
  {
    clearEventtitle();
    clearEventtype();
    clearLevel();
    clearCenter();
    clearShare();
    clearIcon();
    clearImagebottom();
    clearImagetop();
    clearPointinfo();
    clearBorderlb();
    clearBorderrt();
    clearImagebutton();
    clearRefreshsec();
    clearRefershmeters();
    clearBottomicon();
    clearJumpto();
    clearNotice();
    clearFirstshow();
    clearNeedlogin();
    this.L = -1;
    return this;
  }
  
  public Opnlayer clearBorderlb()
  {
    this.r = false;
    this.s = "";
    return this;
  }
  
  public Opnlayer clearBorderrt()
  {
    this.t = false;
    this.u = "";
    return this;
  }
  
  public Opnlayer clearBottomicon()
  {
    this.B = false;
    this.C = "";
    return this;
  }
  
  public Opnlayer clearCenter()
  {
    this.g = false;
    this.h = "";
    return this;
  }
  
  public Opnlayer clearEventtitle()
  {
    this.a = false;
    this.b = "";
    return this;
  }
  
  public Opnlayer clearEventtype()
  {
    this.c = false;
    this.d = 0;
    return this;
  }
  
  public Opnlayer clearFirstshow()
  {
    this.H = false;
    this.I = "";
    return this;
  }
  
  public Opnlayer clearIcon()
  {
    this.k = false;
    this.l = "";
    return this;
  }
  
  public Opnlayer clearImagebottom()
  {
    this.m = false;
    this.n = "";
    return this;
  }
  
  public Opnlayer clearImagebutton()
  {
    this.v = false;
    this.w = "";
    return this;
  }
  
  public Opnlayer clearImagetop()
  {
    this.o = false;
    this.p = "";
    return this;
  }
  
  public Opnlayer clearJumpto()
  {
    this.D = false;
    this.E = "";
    return this;
  }
  
  public Opnlayer clearLevel()
  {
    this.e = false;
    this.f = 0;
    return this;
  }
  
  public Opnlayer clearNeedlogin()
  {
    this.J = false;
    this.K = "";
    return this;
  }
  
  public Opnlayer clearNotice()
  {
    this.F = false;
    this.G = "";
    return this;
  }
  
  public Opnlayer clearPointinfo()
  {
    this.q = Collections.emptyList();
    return this;
  }
  
  public Opnlayer clearRefershmeters()
  {
    this.z = false;
    this.A = 0;
    return this;
  }
  
  public Opnlayer clearRefreshsec()
  {
    this.x = false;
    this.y = 0;
    return this;
  }
  
  public Opnlayer clearShare()
  {
    this.i = false;
    this.j = null;
    return this;
  }
  
  public String getBorderlb()
  {
    return this.s;
  }
  
  public String getBorderrt()
  {
    return this.u;
  }
  
  public String getBottomicon()
  {
    return this.C;
  }
  
  public int getCachedSize()
  {
    if (this.L < 0) {
      getSerializedSize();
    }
    return this.L;
  }
  
  public String getCenter()
  {
    return this.h;
  }
  
  public String getEventtitle()
  {
    return this.b;
  }
  
  public int getEventtype()
  {
    return this.d;
  }
  
  public String getFirstshow()
  {
    return this.I;
  }
  
  public String getIcon()
  {
    return this.l;
  }
  
  public String getImagebottom()
  {
    return this.n;
  }
  
  public String getImagebutton()
  {
    return this.w;
  }
  
  public String getImagetop()
  {
    return this.p;
  }
  
  public String getJumpto()
  {
    return this.E;
  }
  
  public int getLevel()
  {
    return this.f;
  }
  
  public String getNeedlogin()
  {
    return this.K;
  }
  
  public String getNotice()
  {
    return this.G;
  }
  
  public Poi getPointinfo(int paramInt)
  {
    return (Poi)this.q.get(paramInt);
  }
  
  public int getPointinfoCount()
  {
    return this.q.size();
  }
  
  public List<Poi> getPointinfoList()
  {
    return this.q;
  }
  
  public int getRefershmeters()
  {
    return this.A;
  }
  
  public int getRefreshsec()
  {
    return this.y;
  }
  
  public int getSerializedSize()
  {
    int i2 = 0;
    if (hasEventtitle()) {
      i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getEventtitle());
    }
    int i1 = i2;
    if (hasEventtype()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getEventtype());
    }
    i2 = i1;
    if (hasLevel()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(3, getLevel());
    }
    i1 = i2;
    if (hasCenter()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getCenter());
    }
    i2 = i1;
    if (hasShare()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getShare());
    }
    i1 = i2;
    if (hasIcon()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getIcon());
    }
    i2 = i1;
    if (hasImagebottom()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getImagebottom());
    }
    i1 = i2;
    if (hasImagetop()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getImagetop());
    }
    Iterator localIterator = getPointinfoList().iterator();
    for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(9, (Poi)localIterator.next()) + i2) {}
    i1 = i2;
    if (hasBorderlb()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getBorderlb());
    }
    i2 = i1;
    if (hasBorderrt()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getBorderrt());
    }
    i1 = i2;
    if (hasImagebutton()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getImagebutton());
    }
    i2 = i1;
    if (hasRefreshsec()) {
      i2 = i1 + CodedOutputStreamMicro.computeInt32Size(13, getRefreshsec());
    }
    i1 = i2;
    if (hasRefershmeters()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(14, getRefershmeters());
    }
    i2 = i1;
    if (hasBottomicon()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getBottomicon());
    }
    i1 = i2;
    if (hasJumpto()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getJumpto());
    }
    i2 = i1;
    if (hasNotice()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getNotice());
    }
    i1 = i2;
    if (hasFirstshow()) {
      i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getFirstshow());
    }
    i2 = i1;
    if (hasNeedlogin()) {
      i2 = i1 + CodedOutputStreamMicro.computeStringSize(19, getNeedlogin());
    }
    this.L = i2;
    return i2;
  }
  
  public Share getShare()
  {
    return this.j;
  }
  
  public boolean hasBorderlb()
  {
    return this.r;
  }
  
  public boolean hasBorderrt()
  {
    return this.t;
  }
  
  public boolean hasBottomicon()
  {
    return this.B;
  }
  
  public boolean hasCenter()
  {
    return this.g;
  }
  
  public boolean hasEventtitle()
  {
    return this.a;
  }
  
  public boolean hasEventtype()
  {
    return this.c;
  }
  
  public boolean hasFirstshow()
  {
    return this.H;
  }
  
  public boolean hasIcon()
  {
    return this.k;
  }
  
  public boolean hasImagebottom()
  {
    return this.m;
  }
  
  public boolean hasImagebutton()
  {
    return this.v;
  }
  
  public boolean hasImagetop()
  {
    return this.o;
  }
  
  public boolean hasJumpto()
  {
    return this.D;
  }
  
  public boolean hasLevel()
  {
    return this.e;
  }
  
  public boolean hasNeedlogin()
  {
    return this.J;
  }
  
  public boolean hasNotice()
  {
    return this.F;
  }
  
  public boolean hasRefershmeters()
  {
    return this.z;
  }
  
  public boolean hasRefreshsec()
  {
    return this.x;
  }
  
  public boolean hasShare()
  {
    return this.i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Opnlayer mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setEventtitle(paramCodedInputStreamMicro.readString());
        break;
      case 16: 
        setEventtype(paramCodedInputStreamMicro.readInt32());
        break;
      case 24: 
        setLevel(paramCodedInputStreamMicro.readInt32());
        break;
      case 34: 
        setCenter(paramCodedInputStreamMicro.readString());
        break;
      case 42: 
        localObject = new Share();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setShare((Share)localObject);
        break;
      case 50: 
        setIcon(paramCodedInputStreamMicro.readString());
        break;
      case 58: 
        setImagebottom(paramCodedInputStreamMicro.readString());
        break;
      case 66: 
        setImagetop(paramCodedInputStreamMicro.readString());
        break;
      case 74: 
        localObject = new Poi();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addPointinfo((Poi)localObject);
        break;
      case 82: 
        setBorderlb(paramCodedInputStreamMicro.readString());
        break;
      case 90: 
        setBorderrt(paramCodedInputStreamMicro.readString());
        break;
      case 98: 
        setImagebutton(paramCodedInputStreamMicro.readString());
        break;
      case 104: 
        setRefreshsec(paramCodedInputStreamMicro.readInt32());
        break;
      case 112: 
        setRefershmeters(paramCodedInputStreamMicro.readInt32());
        break;
      case 122: 
        setBottomicon(paramCodedInputStreamMicro.readString());
        break;
      case 130: 
        setJumpto(paramCodedInputStreamMicro.readString());
        break;
      case 138: 
        setNotice(paramCodedInputStreamMicro.readString());
        break;
      case 146: 
        setFirstshow(paramCodedInputStreamMicro.readString());
        break;
      case 154: 
        setNeedlogin(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public Opnlayer setBorderlb(String paramString)
  {
    this.r = true;
    this.s = paramString;
    return this;
  }
  
  public Opnlayer setBorderrt(String paramString)
  {
    this.t = true;
    this.u = paramString;
    return this;
  }
  
  public Opnlayer setBottomicon(String paramString)
  {
    this.B = true;
    this.C = paramString;
    return this;
  }
  
  public Opnlayer setCenter(String paramString)
  {
    this.g = true;
    this.h = paramString;
    return this;
  }
  
  public Opnlayer setEventtitle(String paramString)
  {
    this.a = true;
    this.b = paramString;
    return this;
  }
  
  public Opnlayer setEventtype(int paramInt)
  {
    this.c = true;
    this.d = paramInt;
    return this;
  }
  
  public Opnlayer setFirstshow(String paramString)
  {
    this.H = true;
    this.I = paramString;
    return this;
  }
  
  public Opnlayer setIcon(String paramString)
  {
    this.k = true;
    this.l = paramString;
    return this;
  }
  
  public Opnlayer setImagebottom(String paramString)
  {
    this.m = true;
    this.n = paramString;
    return this;
  }
  
  public Opnlayer setImagebutton(String paramString)
  {
    this.v = true;
    this.w = paramString;
    return this;
  }
  
  public Opnlayer setImagetop(String paramString)
  {
    this.o = true;
    this.p = paramString;
    return this;
  }
  
  public Opnlayer setJumpto(String paramString)
  {
    this.D = true;
    this.E = paramString;
    return this;
  }
  
  public Opnlayer setLevel(int paramInt)
  {
    this.e = true;
    this.f = paramInt;
    return this;
  }
  
  public Opnlayer setNeedlogin(String paramString)
  {
    this.J = true;
    this.K = paramString;
    return this;
  }
  
  public Opnlayer setNotice(String paramString)
  {
    this.F = true;
    this.G = paramString;
    return this;
  }
  
  public Opnlayer setPointinfo(int paramInt, Poi paramPoi)
  {
    if (paramPoi == null) {
      return this;
    }
    this.q.set(paramInt, paramPoi);
    return this;
  }
  
  public Opnlayer setRefershmeters(int paramInt)
  {
    this.z = true;
    this.A = paramInt;
    return this;
  }
  
  public Opnlayer setRefreshsec(int paramInt)
  {
    this.x = true;
    this.y = paramInt;
    return this;
  }
  
  public Opnlayer setShare(Share paramShare)
  {
    if (paramShare == null) {
      return clearShare();
    }
    this.i = true;
    this.j = paramShare;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasEventtitle()) {
      paramCodedOutputStreamMicro.writeString(1, getEventtitle());
    }
    if (hasEventtype()) {
      paramCodedOutputStreamMicro.writeInt32(2, getEventtype());
    }
    if (hasLevel()) {
      paramCodedOutputStreamMicro.writeInt32(3, getLevel());
    }
    if (hasCenter()) {
      paramCodedOutputStreamMicro.writeString(4, getCenter());
    }
    if (hasShare()) {
      paramCodedOutputStreamMicro.writeMessage(5, getShare());
    }
    if (hasIcon()) {
      paramCodedOutputStreamMicro.writeString(6, getIcon());
    }
    if (hasImagebottom()) {
      paramCodedOutputStreamMicro.writeString(7, getImagebottom());
    }
    if (hasImagetop()) {
      paramCodedOutputStreamMicro.writeString(8, getImagetop());
    }
    Iterator localIterator = getPointinfoList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(9, (Poi)localIterator.next());
    }
    if (hasBorderlb()) {
      paramCodedOutputStreamMicro.writeString(10, getBorderlb());
    }
    if (hasBorderrt()) {
      paramCodedOutputStreamMicro.writeString(11, getBorderrt());
    }
    if (hasImagebutton()) {
      paramCodedOutputStreamMicro.writeString(12, getImagebutton());
    }
    if (hasRefreshsec()) {
      paramCodedOutputStreamMicro.writeInt32(13, getRefreshsec());
    }
    if (hasRefershmeters()) {
      paramCodedOutputStreamMicro.writeInt32(14, getRefershmeters());
    }
    if (hasBottomicon()) {
      paramCodedOutputStreamMicro.writeString(15, getBottomicon());
    }
    if (hasJumpto()) {
      paramCodedOutputStreamMicro.writeString(16, getJumpto());
    }
    if (hasNotice()) {
      paramCodedOutputStreamMicro.writeString(17, getNotice());
    }
    if (hasFirstshow()) {
      paramCodedOutputStreamMicro.writeString(18, getFirstshow());
    }
    if (hasNeedlogin()) {
      paramCodedOutputStreamMicro.writeString(19, getNeedlogin());
    }
  }
  
  public static final class Poi
    extends MessageMicro
  {
    public static final int ADDRESSCOLOR_FIELD_NUMBER = 15;
    public static final int ADDRESS_FIELD_NUMBER = 8;
    public static final int BUTTONS_FIELD_NUMBER = 17;
    public static final int DESBRIEF_FIELD_NUMBER = 10;
    public static final int DESTITLE_FIELD_NUMBER = 9;
    public static final int ICON_FIELD_NUMBER = 2;
    public static final int IMAGEBOTTOM_FIELD_NUMBER = 4;
    public static final int IMAGETOP_FIELD_NUMBER = 3;
    public static final int LINECOLOR_FIELD_NUMBER = 16;
    public static final int LOCATION_FIELD_NUMBER = 5;
    public static final int SHOWTYPE_FIELD_NUMBER = 6;
    public static final int TITLECOLOR_FIELD_NUMBER = 14;
    public static final int TITLE_FIELD_NUMBER = 7;
    public static final int TOPCOLOR_FIELD_NUMBER = 12;
    public static final int TOPICONTYPE_FIELD_NUMBER = 13;
    public static final int UID_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 11;
    private boolean A;
    private String B = "";
    private boolean C;
    private String D = "";
    private boolean E;
    private String F = "";
    private List<Button> G = Collections.emptyList();
    private int H = -1;
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
    private int z = 0;
    
    public static Poi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Poi().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Poi parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Poi)new Poi().mergeFrom(paramArrayOfByte);
    }
    
    public Poi addButtons(Button paramButton)
    {
      if (paramButton == null) {
        return this;
      }
      if (this.G.isEmpty()) {
        this.G = new ArrayList();
      }
      this.G.add(paramButton);
      return this;
    }
    
    public final Poi clear()
    {
      clearUid();
      clearIcon();
      clearImagetop();
      clearImagebottom();
      clearLocation();
      clearShowtype();
      clearTitle();
      clearAddress();
      clearDestitle();
      clearDesbrief();
      clearUrl();
      clearTopcolor();
      clearTopicontype();
      clearTitlecolor();
      clearAddresscolor();
      clearLinecolor();
      clearButtons();
      this.H = -1;
      return this;
    }
    
    public Poi clearAddress()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public Poi clearAddresscolor()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public Poi clearButtons()
    {
      this.G = Collections.emptyList();
      return this;
    }
    
    public Poi clearDesbrief()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public Poi clearDestitle()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Poi clearIcon()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Poi clearImagebottom()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Poi clearImagetop()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Poi clearLinecolor()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public Poi clearLocation()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Poi clearShowtype()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public Poi clearTitle()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Poi clearTitlecolor()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public Poi clearTopcolor()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public Poi clearTopicontype()
    {
      this.y = false;
      this.z = 0;
      return this;
    }
    
    public Poi clearUid()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Poi clearUrl()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public String getAddress()
    {
      return this.p;
    }
    
    public String getAddresscolor()
    {
      return this.D;
    }
    
    public Button getButtons(int paramInt)
    {
      return (Button)this.G.get(paramInt);
    }
    
    public int getButtonsCount()
    {
      return this.G.size();
    }
    
    public List<Button> getButtonsList()
    {
      return this.G;
    }
    
    public int getCachedSize()
    {
      if (this.H < 0) {
        getSerializedSize();
      }
      return this.H;
    }
    
    public String getDesbrief()
    {
      return this.t;
    }
    
    public String getDestitle()
    {
      return this.r;
    }
    
    public String getIcon()
    {
      return this.d;
    }
    
    public String getImagebottom()
    {
      return this.h;
    }
    
    public String getImagetop()
    {
      return this.f;
    }
    
    public String getLinecolor()
    {
      return this.F;
    }
    
    public String getLocation()
    {
      return this.j;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasUid()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
      }
      int i1 = i2;
      if (hasIcon()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getIcon());
      }
      i2 = i1;
      if (hasImagetop()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getImagetop());
      }
      i1 = i2;
      if (hasImagebottom()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getImagebottom());
      }
      i2 = i1;
      if (hasLocation()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getLocation());
      }
      i1 = i2;
      if (hasShowtype()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getShowtype());
      }
      i2 = i1;
      if (hasTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getTitle());
      }
      i1 = i2;
      if (hasAddress()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getAddress());
      }
      i2 = i1;
      if (hasDestitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getDestitle());
      }
      i1 = i2;
      if (hasDesbrief()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getDesbrief());
      }
      i2 = i1;
      if (hasUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getUrl());
      }
      i1 = i2;
      if (hasTopcolor()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getTopcolor());
      }
      i2 = i1;
      if (hasTopicontype()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(13, getTopicontype());
      }
      i1 = i2;
      if (hasTitlecolor()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getTitlecolor());
      }
      i2 = i1;
      if (hasAddresscolor()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getAddresscolor());
      }
      i1 = i2;
      if (hasLinecolor()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getLinecolor());
      }
      Iterator localIterator = getButtonsList().iterator();
      while (localIterator.hasNext()) {
        i1 = CodedOutputStreamMicro.computeMessageSize(17, (Button)localIterator.next()) + i1;
      }
      this.H = i1;
      return i1;
    }
    
    public int getShowtype()
    {
      return this.l;
    }
    
    public String getTitle()
    {
      return this.n;
    }
    
    public String getTitlecolor()
    {
      return this.B;
    }
    
    public String getTopcolor()
    {
      return this.x;
    }
    
    public int getTopicontype()
    {
      return this.z;
    }
    
    public String getUid()
    {
      return this.b;
    }
    
    public String getUrl()
    {
      return this.v;
    }
    
    public boolean hasAddress()
    {
      return this.o;
    }
    
    public boolean hasAddresscolor()
    {
      return this.C;
    }
    
    public boolean hasDesbrief()
    {
      return this.s;
    }
    
    public boolean hasDestitle()
    {
      return this.q;
    }
    
    public boolean hasIcon()
    {
      return this.c;
    }
    
    public boolean hasImagebottom()
    {
      return this.g;
    }
    
    public boolean hasImagetop()
    {
      return this.e;
    }
    
    public boolean hasLinecolor()
    {
      return this.E;
    }
    
    public boolean hasLocation()
    {
      return this.i;
    }
    
    public boolean hasShowtype()
    {
      return this.k;
    }
    
    public boolean hasTitle()
    {
      return this.m;
    }
    
    public boolean hasTitlecolor()
    {
      return this.A;
    }
    
    public boolean hasTopcolor()
    {
      return this.w;
    }
    
    public boolean hasTopicontype()
    {
      return this.y;
    }
    
    public boolean hasUid()
    {
      return this.a;
    }
    
    public boolean hasUrl()
    {
      return this.u;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Poi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setImagetop(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setImagebottom(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setLocation(paramCodedInputStreamMicro.readString());
          break;
        case 48: 
          setShowtype(paramCodedInputStreamMicro.readInt32());
          break;
        case 58: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setAddress(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setDestitle(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setDesbrief(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setUrl(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setTopcolor(paramCodedInputStreamMicro.readString());
          break;
        case 104: 
          setTopicontype(paramCodedInputStreamMicro.readInt32());
          break;
        case 114: 
          setTitlecolor(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setAddresscolor(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setLinecolor(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          Button localButton = new Button();
          paramCodedInputStreamMicro.readMessage(localButton);
          addButtons(localButton);
        }
      }
    }
    
    public Poi setAddress(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public Poi setAddresscolor(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public Poi setButtons(int paramInt, Button paramButton)
    {
      if (paramButton == null) {
        return this;
      }
      this.G.set(paramInt, paramButton);
      return this;
    }
    
    public Poi setDesbrief(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public Poi setDestitle(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Poi setIcon(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Poi setImagebottom(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Poi setImagetop(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Poi setLinecolor(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public Poi setLocation(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Poi setShowtype(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public Poi setTitle(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Poi setTitlecolor(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public Poi setTopcolor(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public Poi setTopicontype(int paramInt)
    {
      this.y = true;
      this.z = paramInt;
      return this;
    }
    
    public Poi setUid(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Poi setUrl(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(1, getUid());
      }
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(2, getIcon());
      }
      if (hasImagetop()) {
        paramCodedOutputStreamMicro.writeString(3, getImagetop());
      }
      if (hasImagebottom()) {
        paramCodedOutputStreamMicro.writeString(4, getImagebottom());
      }
      if (hasLocation()) {
        paramCodedOutputStreamMicro.writeString(5, getLocation());
      }
      if (hasShowtype()) {
        paramCodedOutputStreamMicro.writeInt32(6, getShowtype());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(7, getTitle());
      }
      if (hasAddress()) {
        paramCodedOutputStreamMicro.writeString(8, getAddress());
      }
      if (hasDestitle()) {
        paramCodedOutputStreamMicro.writeString(9, getDestitle());
      }
      if (hasDesbrief()) {
        paramCodedOutputStreamMicro.writeString(10, getDesbrief());
      }
      if (hasUrl()) {
        paramCodedOutputStreamMicro.writeString(11, getUrl());
      }
      if (hasTopcolor()) {
        paramCodedOutputStreamMicro.writeString(12, getTopcolor());
      }
      if (hasTopicontype()) {
        paramCodedOutputStreamMicro.writeInt32(13, getTopicontype());
      }
      if (hasTitlecolor()) {
        paramCodedOutputStreamMicro.writeString(14, getTitlecolor());
      }
      if (hasAddresscolor()) {
        paramCodedOutputStreamMicro.writeString(15, getAddresscolor());
      }
      if (hasLinecolor()) {
        paramCodedOutputStreamMicro.writeString(16, getLinecolor());
      }
      Iterator localIterator = getButtonsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(17, (Button)localIterator.next());
      }
    }
    
    public static final class Button
      extends MessageMicro
    {
      public static final int BUTTONICON_FIELD_NUMBER = 4;
      public static final int TITLE_FIELD_NUMBER = 1;
      public static final int TYPE_FIELD_NUMBER = 2;
      public static final int URL_FIELD_NUMBER = 3;
      private boolean a;
      private String b = "";
      private boolean c;
      private int d = 0;
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
        clearTitle();
        clearType();
        clearUrl();
        clearButtonicon();
        this.i = -1;
        return this;
      }
      
      public Button clearButtonicon()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Button clearTitle()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Button clearType()
      {
        this.c = false;
        this.d = 0;
        return this;
      }
      
      public Button clearUrl()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public String getButtonicon()
      {
        return this.h;
      }
      
      public int getCachedSize()
      {
        if (this.i < 0) {
          getSerializedSize();
        }
        return this.i;
      }
      
      public int getSerializedSize()
      {
        int k = 0;
        if (hasTitle()) {
          k = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
        }
        int j = k;
        if (hasType()) {
          j = k + CodedOutputStreamMicro.computeInt32Size(2, getType());
        }
        k = j;
        if (hasUrl()) {
          k = j + CodedOutputStreamMicro.computeStringSize(3, getUrl());
        }
        j = k;
        if (hasButtonicon()) {
          j = k + CodedOutputStreamMicro.computeStringSize(4, getButtonicon());
        }
        this.i = j;
        return j;
      }
      
      public String getTitle()
      {
        return this.b;
      }
      
      public int getType()
      {
        return this.d;
      }
      
      public String getUrl()
      {
        return this.f;
      }
      
      public boolean hasButtonicon()
      {
        return this.g;
      }
      
      public boolean hasTitle()
      {
        return this.a;
      }
      
      public boolean hasType()
      {
        return this.c;
      }
      
      public boolean hasUrl()
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
            setTitle(paramCodedInputStreamMicro.readString());
            break;
          case 16: 
            setType(paramCodedInputStreamMicro.readInt32());
            break;
          case 26: 
            setUrl(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setButtonicon(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public Button setButtonicon(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Button setTitle(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Button setType(int paramInt)
      {
        this.c = true;
        this.d = paramInt;
        return this;
      }
      
      public Button setUrl(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasTitle()) {
          paramCodedOutputStreamMicro.writeString(1, getTitle());
        }
        if (hasType()) {
          paramCodedOutputStreamMicro.writeInt32(2, getType());
        }
        if (hasUrl()) {
          paramCodedOutputStreamMicro.writeString(3, getUrl());
        }
        if (hasButtonicon()) {
          paramCodedOutputStreamMicro.writeString(4, getButtonicon());
        }
      }
    }
  }
  
  public static final class Share
    extends MessageMicro
  {
    public static final int BIGICON_FIELD_NUMBER = 6;
    public static final int LONGCONTENT_FIELD_NUMBER = 4;
    public static final int SHORTCONTENT_FIELD_NUMBER = 3;
    public static final int SMALLICON_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
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
    private int m = -1;
    
    public static Share parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Share().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Share parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Share)new Share().mergeFrom(paramArrayOfByte);
    }
    
    public final Share clear()
    {
      clearUrl();
      clearTitle();
      clearShortcontent();
      clearLongcontent();
      clearSmallicon();
      clearBigicon();
      this.m = -1;
      return this;
    }
    
    public Share clearBigicon()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Share clearLongcontent()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Share clearShortcontent()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Share clearSmallicon()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Share clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Share clearUrl()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public String getBigicon()
    {
      return this.l;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public String getLongcontent()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasUrl()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
      }
      int n = i1;
      if (hasTitle()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      i1 = n;
      if (hasShortcontent()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getShortcontent());
      }
      n = i1;
      if (hasLongcontent()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getLongcontent());
      }
      i1 = n;
      if (hasSmallicon()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getSmallicon());
      }
      n = i1;
      if (hasBigicon()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getBigicon());
      }
      this.m = n;
      return n;
    }
    
    public String getShortcontent()
    {
      return this.f;
    }
    
    public String getSmallicon()
    {
      return this.j;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public String getUrl()
    {
      return this.b;
    }
    
    public boolean hasBigicon()
    {
      return this.k;
    }
    
    public boolean hasLongcontent()
    {
      return this.g;
    }
    
    public boolean hasShortcontent()
    {
      return this.e;
    }
    
    public boolean hasSmallicon()
    {
      return this.i;
    }
    
    public boolean hasTitle()
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
    
    public Share mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int n = paramCodedInputStreamMicro.readTag();
        switch (n)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, n)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setUrl(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setShortcontent(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setLongcontent(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setSmallicon(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setBigicon(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Share setBigicon(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Share setLongcontent(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Share setShortcontent(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Share setSmallicon(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Share setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Share setUrl(String paramString)
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
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
      if (hasShortcontent()) {
        paramCodedOutputStreamMicro.writeString(3, getShortcontent());
      }
      if (hasLongcontent()) {
        paramCodedOutputStreamMicro.writeString(4, getLongcontent());
      }
      if (hasSmallicon()) {
        paramCodedOutputStreamMicro.writeString(5, getSmallicon());
      }
      if (hasBigicon()) {
        paramCodedOutputStreamMicro.writeString(6, getBigicon());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/Opnlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */