package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Weather
  extends MessageMicro
{
  public static final int CONTENTS_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private boolean c;
  private Contents d = null;
  private int e = -1;
  
  public static Weather parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Weather().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Weather parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Weather)new Weather().mergeFrom(paramArrayOfByte);
  }
  
  public final Weather clear()
  {
    clearOption();
    clearContents();
    this.e = -1;
    return this;
  }
  
  public Weather clearContents()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public Weather clearOption()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.e < 0) {
      getSerializedSize();
    }
    return this.e;
  }
  
  public Contents getContents()
  {
    return this.d;
  }
  
  public Option getOption()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasOption()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
    }
    int j = i;
    if (hasContents()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(2, getContents());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasContents()
  {
    return this.c;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Weather mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Option();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setOption((Option)localObject);
        break;
      case 18: 
        localObject = new Contents();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setContents((Contents)localObject);
      }
    }
  }
  
  public Weather setContents(Contents paramContents)
  {
    if (paramContents == null) {
      return clearContents();
    }
    this.c = true;
    this.d = paramContents;
    return this;
  }
  
  public Weather setOption(Option paramOption)
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
    if (hasContents()) {
      paramCodedOutputStreamMicro.writeMessage(2, getContents());
    }
  }
  
  public static final class Contents
    extends MessageMicro
  {
    public static final int CNAME_FIELD_NUMBER = 1;
    public static final int PIC01_FIELD_NUMBER = 11;
    public static final int PIC02_FIELD_NUMBER = 12;
    public static final int PIC0T_FIELD_NUMBER = 7;
    public static final int PIC0_FIELD_NUMBER = 6;
    public static final int PIC11_FIELD_NUMBER = 19;
    public static final int PIC12_FIELD_NUMBER = 20;
    public static final int PIC1_FIELD_NUMBER = 18;
    public static final int PIC21_FIELD_NUMBER = 27;
    public static final int PIC22_FIELD_NUMBER = 28;
    public static final int PIC2_FIELD_NUMBER = 26;
    public static final int PIC31_FIELD_NUMBER = 35;
    public static final int PIC32_FIELD_NUMBER = 36;
    public static final int PIC3_FIELD_NUMBER = 34;
    public static final int PIC41_FIELD_NUMBER = 43;
    public static final int PIC42_FIELD_NUMBER = 44;
    public static final int PIC4_FIELD_NUMBER = 42;
    public static final int PICNAME0_FIELD_NUMBER = 8;
    public static final int PICNAME1_FIELD_NUMBER = 17;
    public static final int PICNAME2_FIELD_NUMBER = 25;
    public static final int PICNAME3_FIELD_NUMBER = 33;
    public static final int PICNAME4_FIELD_NUMBER = 41;
    public static final int PM25T_FIELD_NUMBER = 5;
    public static final int PM25_FIELD_NUMBER = 4;
    public static final int TEMP0_FIELD_NUMBER = 3;
    public static final int TEMP1_FIELD_NUMBER = 15;
    public static final int TEMP2_FIELD_NUMBER = 23;
    public static final int TEMP3_FIELD_NUMBER = 31;
    public static final int TEMP4_FIELD_NUMBER = 39;
    public static final int TIME0_FIELD_NUMBER = 9;
    public static final int TIME1_FIELD_NUMBER = 13;
    public static final int TIME2_FIELD_NUMBER = 21;
    public static final int TIME3_FIELD_NUMBER = 29;
    public static final int TIME4_FIELD_NUMBER = 37;
    public static final int WEATHER0_FIELD_NUMBER = 2;
    public static final int WEATHER1_FIELD_NUMBER = 14;
    public static final int WEATHER2_FIELD_NUMBER = 22;
    public static final int WEATHER3_FIELD_NUMBER = 30;
    public static final int WEATHER4_FIELD_NUMBER = 38;
    public static final int WIND0_FIELD_NUMBER = 10;
    public static final int WIND1_FIELD_NUMBER = 16;
    public static final int WIND2_FIELD_NUMBER = 24;
    public static final int WIND3_FIELD_NUMBER = 32;
    public static final int WIND4_FIELD_NUMBER = 40;
    private boolean A;
    private String B = "";
    private boolean C;
    private String D = "";
    private boolean E;
    private String F = "";
    private boolean G;
    private String H = "";
    private boolean I;
    private String J = "";
    private boolean K;
    private String L = "";
    private boolean M;
    private String N = "";
    private boolean O;
    private String P = "";
    private boolean Q;
    private String R = "";
    private boolean S;
    private String T = "";
    private boolean U;
    private String V = "";
    private boolean W;
    private String X = "";
    private boolean Y;
    private String Z = "";
    private boolean a;
    private boolean aA;
    private String aB = "";
    private boolean aC;
    private String aD = "";
    private boolean aE;
    private String aF = "";
    private boolean aG;
    private String aH = "";
    private boolean aI;
    private String aJ = "";
    private int aK = -1;
    private boolean aa;
    private String ab = "";
    private boolean ac;
    private String ad = "";
    private boolean ae;
    private String af = "";
    private boolean ag;
    private String ah = "";
    private boolean ai;
    private String aj = "";
    private boolean ak;
    private String al = "";
    private boolean am;
    private String an = "";
    private boolean ao;
    private String ap = "";
    private boolean aq;
    private String ar = "";
    private boolean as;
    private String at = "";
    private boolean au;
    private String av = "";
    private boolean aw;
    private String ax = "";
    private boolean ay;
    private String az = "";
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
    private String l = "";
    private boolean m;
    private int n = 0;
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
    
    public static Contents parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Contents().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Contents parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Contents)new Contents().mergeFrom(paramArrayOfByte);
    }
    
    public final Contents clear()
    {
      clearCname();
      clearWeather0();
      clearTemp0();
      clearPm25();
      clearPm25T();
      clearPic0();
      clearPic0T();
      clearPicName0();
      clearTime0();
      clearWind0();
      clearPic01();
      clearPic02();
      clearTime1();
      clearWeather1();
      clearTemp1();
      clearWind1();
      clearPicName1();
      clearPic1();
      clearPic11();
      clearPic12();
      clearTime2();
      clearWeather2();
      clearTemp2();
      clearWind2();
      clearPicName2();
      clearPic2();
      clearPic21();
      clearPic22();
      clearTime3();
      clearWeather3();
      clearTemp3();
      clearWind3();
      clearPicName3();
      clearPic3();
      clearPic31();
      clearPic32();
      clearTime4();
      clearWeather4();
      clearTemp4();
      clearWind4();
      clearPicName4();
      clearPic4();
      clearPic41();
      clearPic42();
      this.aK = -1;
      return this;
    }
    
    public Contents clearCname()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Contents clearPic0()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Contents clearPic01()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public Contents clearPic02()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public Contents clearPic0T()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public Contents clearPic1()
    {
      this.I = false;
      this.J = "";
      return this;
    }
    
    public Contents clearPic11()
    {
      this.K = false;
      this.L = "";
      return this;
    }
    
    public Contents clearPic12()
    {
      this.M = false;
      this.N = "";
      return this;
    }
    
    public Contents clearPic2()
    {
      this.Y = false;
      this.Z = "";
      return this;
    }
    
    public Contents clearPic21()
    {
      this.aa = false;
      this.ab = "";
      return this;
    }
    
    public Contents clearPic22()
    {
      this.ac = false;
      this.ad = "";
      return this;
    }
    
    public Contents clearPic3()
    {
      this.ao = false;
      this.ap = "";
      return this;
    }
    
    public Contents clearPic31()
    {
      this.aq = false;
      this.ar = "";
      return this;
    }
    
    public Contents clearPic32()
    {
      this.as = false;
      this.at = "";
      return this;
    }
    
    public Contents clearPic4()
    {
      this.aE = false;
      this.aF = "";
      return this;
    }
    
    public Contents clearPic41()
    {
      this.aG = false;
      this.aH = "";
      return this;
    }
    
    public Contents clearPic42()
    {
      this.aI = false;
      this.aJ = "";
      return this;
    }
    
    public Contents clearPicName0()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public Contents clearPicName1()
    {
      this.G = false;
      this.H = "";
      return this;
    }
    
    public Contents clearPicName2()
    {
      this.W = false;
      this.X = "";
      return this;
    }
    
    public Contents clearPicName3()
    {
      this.am = false;
      this.an = "";
      return this;
    }
    
    public Contents clearPicName4()
    {
      this.aC = false;
      this.aD = "";
      return this;
    }
    
    public Contents clearPm25()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Contents clearPm25T()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public Contents clearTemp0()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Contents clearTemp1()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public Contents clearTemp2()
    {
      this.S = false;
      this.T = "";
      return this;
    }
    
    public Contents clearTemp3()
    {
      this.ai = false;
      this.aj = "";
      return this;
    }
    
    public Contents clearTemp4()
    {
      this.ay = false;
      this.az = "";
      return this;
    }
    
    public Contents clearTime0()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public Contents clearTime1()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public Contents clearTime2()
    {
      this.O = false;
      this.P = "";
      return this;
    }
    
    public Contents clearTime3()
    {
      this.ae = false;
      this.af = "";
      return this;
    }
    
    public Contents clearTime4()
    {
      this.au = false;
      this.av = "";
      return this;
    }
    
    public Contents clearWeather0()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Contents clearWeather1()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public Contents clearWeather2()
    {
      this.Q = false;
      this.R = "";
      return this;
    }
    
    public Contents clearWeather3()
    {
      this.ag = false;
      this.ah = "";
      return this;
    }
    
    public Contents clearWeather4()
    {
      this.aw = false;
      this.ax = "";
      return this;
    }
    
    public Contents clearWind0()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public Contents clearWind1()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public Contents clearWind2()
    {
      this.U = false;
      this.V = "";
      return this;
    }
    
    public Contents clearWind3()
    {
      this.ak = false;
      this.al = "";
      return this;
    }
    
    public Contents clearWind4()
    {
      this.aA = false;
      this.aB = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.aK < 0) {
        getSerializedSize();
      }
      return this.aK;
    }
    
    public String getCname()
    {
      return this.b;
    }
    
    public String getPic0()
    {
      return this.l;
    }
    
    public String getPic01()
    {
      return this.v;
    }
    
    public String getPic02()
    {
      return this.x;
    }
    
    public int getPic0T()
    {
      return this.n;
    }
    
    public String getPic1()
    {
      return this.J;
    }
    
    public String getPic11()
    {
      return this.L;
    }
    
    public String getPic12()
    {
      return this.N;
    }
    
    public String getPic2()
    {
      return this.Z;
    }
    
    public String getPic21()
    {
      return this.ab;
    }
    
    public String getPic22()
    {
      return this.ad;
    }
    
    public String getPic3()
    {
      return this.ap;
    }
    
    public String getPic31()
    {
      return this.ar;
    }
    
    public String getPic32()
    {
      return this.at;
    }
    
    public String getPic4()
    {
      return this.aF;
    }
    
    public String getPic41()
    {
      return this.aH;
    }
    
    public String getPic42()
    {
      return this.aJ;
    }
    
    public String getPicName0()
    {
      return this.p;
    }
    
    public String getPicName1()
    {
      return this.H;
    }
    
    public String getPicName2()
    {
      return this.X;
    }
    
    public String getPicName3()
    {
      return this.an;
    }
    
    public String getPicName4()
    {
      return this.aD;
    }
    
    public int getPm25()
    {
      return this.h;
    }
    
    public String getPm25T()
    {
      return this.j;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasCname()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCname());
      }
      int i1 = i2;
      if (hasWeather0()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getWeather0());
      }
      i2 = i1;
      if (hasTemp0()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getTemp0());
      }
      i1 = i2;
      if (hasPm25()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getPm25());
      }
      i2 = i1;
      if (hasPm25T()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getPm25T());
      }
      i1 = i2;
      if (hasPic0()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getPic0());
      }
      i2 = i1;
      if (hasPic0T()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getPic0T());
      }
      i1 = i2;
      if (hasPicName0()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getPicName0());
      }
      i2 = i1;
      if (hasTime0()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getTime0());
      }
      i1 = i2;
      if (hasWind0()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getWind0());
      }
      i2 = i1;
      if (hasPic01()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getPic01());
      }
      i1 = i2;
      if (hasPic02()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getPic02());
      }
      i2 = i1;
      if (hasTime1()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getTime1());
      }
      i1 = i2;
      if (hasWeather1()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getWeather1());
      }
      i2 = i1;
      if (hasTemp1()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getTemp1());
      }
      i1 = i2;
      if (hasWind1()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getWind1());
      }
      i2 = i1;
      if (hasPicName1()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getPicName1());
      }
      i1 = i2;
      if (hasPic1()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getPic1());
      }
      i2 = i1;
      if (hasPic11()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(19, getPic11());
      }
      i1 = i2;
      if (hasPic12()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(20, getPic12());
      }
      i2 = i1;
      if (hasTime2()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(21, getTime2());
      }
      i1 = i2;
      if (hasWeather2()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(22, getWeather2());
      }
      i2 = i1;
      if (hasTemp2()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(23, getTemp2());
      }
      i1 = i2;
      if (hasWind2()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(24, getWind2());
      }
      i2 = i1;
      if (hasPicName2()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(25, getPicName2());
      }
      i1 = i2;
      if (hasPic2()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(26, getPic2());
      }
      i2 = i1;
      if (hasPic21()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(27, getPic21());
      }
      i1 = i2;
      if (hasPic22()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(28, getPic22());
      }
      i2 = i1;
      if (hasTime3()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(29, getTime3());
      }
      i1 = i2;
      if (hasWeather3()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(30, getWeather3());
      }
      i2 = i1;
      if (hasTemp3()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(31, getTemp3());
      }
      i1 = i2;
      if (hasWind3()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(32, getWind3());
      }
      i2 = i1;
      if (hasPicName3()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(33, getPicName3());
      }
      i1 = i2;
      if (hasPic3()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(34, getPic3());
      }
      i2 = i1;
      if (hasPic31()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(35, getPic31());
      }
      i1 = i2;
      if (hasPic32()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(36, getPic32());
      }
      i2 = i1;
      if (hasTime4()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(37, getTime4());
      }
      i1 = i2;
      if (hasWeather4()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(38, getWeather4());
      }
      i2 = i1;
      if (hasTemp4()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(39, getTemp4());
      }
      i1 = i2;
      if (hasWind4()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(40, getWind4());
      }
      i2 = i1;
      if (hasPicName4()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(41, getPicName4());
      }
      i1 = i2;
      if (hasPic4()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(42, getPic4());
      }
      i2 = i1;
      if (hasPic41()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(43, getPic41());
      }
      i1 = i2;
      if (hasPic42()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(44, getPic42());
      }
      this.aK = i1;
      return i1;
    }
    
    public String getTemp0()
    {
      return this.f;
    }
    
    public String getTemp1()
    {
      return this.D;
    }
    
    public String getTemp2()
    {
      return this.T;
    }
    
    public String getTemp3()
    {
      return this.aj;
    }
    
    public String getTemp4()
    {
      return this.az;
    }
    
    public String getTime0()
    {
      return this.r;
    }
    
    public String getTime1()
    {
      return this.z;
    }
    
    public String getTime2()
    {
      return this.P;
    }
    
    public String getTime3()
    {
      return this.af;
    }
    
    public String getTime4()
    {
      return this.av;
    }
    
    public String getWeather0()
    {
      return this.d;
    }
    
    public String getWeather1()
    {
      return this.B;
    }
    
    public String getWeather2()
    {
      return this.R;
    }
    
    public String getWeather3()
    {
      return this.ah;
    }
    
    public String getWeather4()
    {
      return this.ax;
    }
    
    public String getWind0()
    {
      return this.t;
    }
    
    public String getWind1()
    {
      return this.F;
    }
    
    public String getWind2()
    {
      return this.V;
    }
    
    public String getWind3()
    {
      return this.al;
    }
    
    public String getWind4()
    {
      return this.aB;
    }
    
    public boolean hasCname()
    {
      return this.a;
    }
    
    public boolean hasPic0()
    {
      return this.k;
    }
    
    public boolean hasPic01()
    {
      return this.u;
    }
    
    public boolean hasPic02()
    {
      return this.w;
    }
    
    public boolean hasPic0T()
    {
      return this.m;
    }
    
    public boolean hasPic1()
    {
      return this.I;
    }
    
    public boolean hasPic11()
    {
      return this.K;
    }
    
    public boolean hasPic12()
    {
      return this.M;
    }
    
    public boolean hasPic2()
    {
      return this.Y;
    }
    
    public boolean hasPic21()
    {
      return this.aa;
    }
    
    public boolean hasPic22()
    {
      return this.ac;
    }
    
    public boolean hasPic3()
    {
      return this.ao;
    }
    
    public boolean hasPic31()
    {
      return this.aq;
    }
    
    public boolean hasPic32()
    {
      return this.as;
    }
    
    public boolean hasPic4()
    {
      return this.aE;
    }
    
    public boolean hasPic41()
    {
      return this.aG;
    }
    
    public boolean hasPic42()
    {
      return this.aI;
    }
    
    public boolean hasPicName0()
    {
      return this.o;
    }
    
    public boolean hasPicName1()
    {
      return this.G;
    }
    
    public boolean hasPicName2()
    {
      return this.W;
    }
    
    public boolean hasPicName3()
    {
      return this.am;
    }
    
    public boolean hasPicName4()
    {
      return this.aC;
    }
    
    public boolean hasPm25()
    {
      return this.g;
    }
    
    public boolean hasPm25T()
    {
      return this.i;
    }
    
    public boolean hasTemp0()
    {
      return this.e;
    }
    
    public boolean hasTemp1()
    {
      return this.C;
    }
    
    public boolean hasTemp2()
    {
      return this.S;
    }
    
    public boolean hasTemp3()
    {
      return this.ai;
    }
    
    public boolean hasTemp4()
    {
      return this.ay;
    }
    
    public boolean hasTime0()
    {
      return this.q;
    }
    
    public boolean hasTime1()
    {
      return this.y;
    }
    
    public boolean hasTime2()
    {
      return this.O;
    }
    
    public boolean hasTime3()
    {
      return this.ae;
    }
    
    public boolean hasTime4()
    {
      return this.au;
    }
    
    public boolean hasWeather0()
    {
      return this.c;
    }
    
    public boolean hasWeather1()
    {
      return this.A;
    }
    
    public boolean hasWeather2()
    {
      return this.Q;
    }
    
    public boolean hasWeather3()
    {
      return this.ag;
    }
    
    public boolean hasWeather4()
    {
      return this.aw;
    }
    
    public boolean hasWind0()
    {
      return this.s;
    }
    
    public boolean hasWind1()
    {
      return this.E;
    }
    
    public boolean hasWind2()
    {
      return this.U;
    }
    
    public boolean hasWind3()
    {
      return this.ak;
    }
    
    public boolean hasWind4()
    {
      return this.aA;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Contents mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCname(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setWeather0(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTemp0(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setPm25(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setPm25T(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setPic0(paramCodedInputStreamMicro.readString());
          break;
        case 56: 
          setPic0T(paramCodedInputStreamMicro.readInt32());
          break;
        case 66: 
          setPicName0(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setTime0(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setWind0(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setPic01(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setPic02(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setTime1(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setWeather1(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setTemp1(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setWind1(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          setPicName1(paramCodedInputStreamMicro.readString());
          break;
        case 146: 
          setPic1(paramCodedInputStreamMicro.readString());
          break;
        case 154: 
          setPic11(paramCodedInputStreamMicro.readString());
          break;
        case 162: 
          setPic12(paramCodedInputStreamMicro.readString());
          break;
        case 170: 
          setTime2(paramCodedInputStreamMicro.readString());
          break;
        case 178: 
          setWeather2(paramCodedInputStreamMicro.readString());
          break;
        case 186: 
          setTemp2(paramCodedInputStreamMicro.readString());
          break;
        case 194: 
          setWind2(paramCodedInputStreamMicro.readString());
          break;
        case 202: 
          setPicName2(paramCodedInputStreamMicro.readString());
          break;
        case 210: 
          setPic2(paramCodedInputStreamMicro.readString());
          break;
        case 218: 
          setPic21(paramCodedInputStreamMicro.readString());
          break;
        case 226: 
          setPic22(paramCodedInputStreamMicro.readString());
          break;
        case 234: 
          setTime3(paramCodedInputStreamMicro.readString());
          break;
        case 242: 
          setWeather3(paramCodedInputStreamMicro.readString());
          break;
        case 250: 
          setTemp3(paramCodedInputStreamMicro.readString());
          break;
        case 258: 
          setWind3(paramCodedInputStreamMicro.readString());
          break;
        case 266: 
          setPicName3(paramCodedInputStreamMicro.readString());
          break;
        case 274: 
          setPic3(paramCodedInputStreamMicro.readString());
          break;
        case 282: 
          setPic31(paramCodedInputStreamMicro.readString());
          break;
        case 290: 
          setPic32(paramCodedInputStreamMicro.readString());
          break;
        case 298: 
          setTime4(paramCodedInputStreamMicro.readString());
          break;
        case 306: 
          setWeather4(paramCodedInputStreamMicro.readString());
          break;
        case 314: 
          setTemp4(paramCodedInputStreamMicro.readString());
          break;
        case 322: 
          setWind4(paramCodedInputStreamMicro.readString());
          break;
        case 330: 
          setPicName4(paramCodedInputStreamMicro.readString());
          break;
        case 338: 
          setPic4(paramCodedInputStreamMicro.readString());
          break;
        case 346: 
          setPic41(paramCodedInputStreamMicro.readString());
          break;
        case 354: 
          setPic42(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Contents setCname(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Contents setPic0(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Contents setPic01(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public Contents setPic02(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public Contents setPic0T(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public Contents setPic1(String paramString)
    {
      this.I = true;
      this.J = paramString;
      return this;
    }
    
    public Contents setPic11(String paramString)
    {
      this.K = true;
      this.L = paramString;
      return this;
    }
    
    public Contents setPic12(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }
    
    public Contents setPic2(String paramString)
    {
      this.Y = true;
      this.Z = paramString;
      return this;
    }
    
    public Contents setPic21(String paramString)
    {
      this.aa = true;
      this.ab = paramString;
      return this;
    }
    
    public Contents setPic22(String paramString)
    {
      this.ac = true;
      this.ad = paramString;
      return this;
    }
    
    public Contents setPic3(String paramString)
    {
      this.ao = true;
      this.ap = paramString;
      return this;
    }
    
    public Contents setPic31(String paramString)
    {
      this.aq = true;
      this.ar = paramString;
      return this;
    }
    
    public Contents setPic32(String paramString)
    {
      this.as = true;
      this.at = paramString;
      return this;
    }
    
    public Contents setPic4(String paramString)
    {
      this.aE = true;
      this.aF = paramString;
      return this;
    }
    
    public Contents setPic41(String paramString)
    {
      this.aG = true;
      this.aH = paramString;
      return this;
    }
    
    public Contents setPic42(String paramString)
    {
      this.aI = true;
      this.aJ = paramString;
      return this;
    }
    
    public Contents setPicName0(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public Contents setPicName1(String paramString)
    {
      this.G = true;
      this.H = paramString;
      return this;
    }
    
    public Contents setPicName2(String paramString)
    {
      this.W = true;
      this.X = paramString;
      return this;
    }
    
    public Contents setPicName3(String paramString)
    {
      this.am = true;
      this.an = paramString;
      return this;
    }
    
    public Contents setPicName4(String paramString)
    {
      this.aC = true;
      this.aD = paramString;
      return this;
    }
    
    public Contents setPm25(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Contents setPm25T(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public Contents setTemp0(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Contents setTemp1(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public Contents setTemp2(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }
    
    public Contents setTemp3(String paramString)
    {
      this.ai = true;
      this.aj = paramString;
      return this;
    }
    
    public Contents setTemp4(String paramString)
    {
      this.ay = true;
      this.az = paramString;
      return this;
    }
    
    public Contents setTime0(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public Contents setTime1(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public Contents setTime2(String paramString)
    {
      this.O = true;
      this.P = paramString;
      return this;
    }
    
    public Contents setTime3(String paramString)
    {
      this.ae = true;
      this.af = paramString;
      return this;
    }
    
    public Contents setTime4(String paramString)
    {
      this.au = true;
      this.av = paramString;
      return this;
    }
    
    public Contents setWeather0(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Contents setWeather1(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public Contents setWeather2(String paramString)
    {
      this.Q = true;
      this.R = paramString;
      return this;
    }
    
    public Contents setWeather3(String paramString)
    {
      this.ag = true;
      this.ah = paramString;
      return this;
    }
    
    public Contents setWeather4(String paramString)
    {
      this.aw = true;
      this.ax = paramString;
      return this;
    }
    
    public Contents setWind0(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public Contents setWind1(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public Contents setWind2(String paramString)
    {
      this.U = true;
      this.V = paramString;
      return this;
    }
    
    public Contents setWind3(String paramString)
    {
      this.ak = true;
      this.al = paramString;
      return this;
    }
    
    public Contents setWind4(String paramString)
    {
      this.aA = true;
      this.aB = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCname()) {
        paramCodedOutputStreamMicro.writeString(1, getCname());
      }
      if (hasWeather0()) {
        paramCodedOutputStreamMicro.writeString(2, getWeather0());
      }
      if (hasTemp0()) {
        paramCodedOutputStreamMicro.writeString(3, getTemp0());
      }
      if (hasPm25()) {
        paramCodedOutputStreamMicro.writeInt32(4, getPm25());
      }
      if (hasPm25T()) {
        paramCodedOutputStreamMicro.writeString(5, getPm25T());
      }
      if (hasPic0()) {
        paramCodedOutputStreamMicro.writeString(6, getPic0());
      }
      if (hasPic0T()) {
        paramCodedOutputStreamMicro.writeInt32(7, getPic0T());
      }
      if (hasPicName0()) {
        paramCodedOutputStreamMicro.writeString(8, getPicName0());
      }
      if (hasTime0()) {
        paramCodedOutputStreamMicro.writeString(9, getTime0());
      }
      if (hasWind0()) {
        paramCodedOutputStreamMicro.writeString(10, getWind0());
      }
      if (hasPic01()) {
        paramCodedOutputStreamMicro.writeString(11, getPic01());
      }
      if (hasPic02()) {
        paramCodedOutputStreamMicro.writeString(12, getPic02());
      }
      if (hasTime1()) {
        paramCodedOutputStreamMicro.writeString(13, getTime1());
      }
      if (hasWeather1()) {
        paramCodedOutputStreamMicro.writeString(14, getWeather1());
      }
      if (hasTemp1()) {
        paramCodedOutputStreamMicro.writeString(15, getTemp1());
      }
      if (hasWind1()) {
        paramCodedOutputStreamMicro.writeString(16, getWind1());
      }
      if (hasPicName1()) {
        paramCodedOutputStreamMicro.writeString(17, getPicName1());
      }
      if (hasPic1()) {
        paramCodedOutputStreamMicro.writeString(18, getPic1());
      }
      if (hasPic11()) {
        paramCodedOutputStreamMicro.writeString(19, getPic11());
      }
      if (hasPic12()) {
        paramCodedOutputStreamMicro.writeString(20, getPic12());
      }
      if (hasTime2()) {
        paramCodedOutputStreamMicro.writeString(21, getTime2());
      }
      if (hasWeather2()) {
        paramCodedOutputStreamMicro.writeString(22, getWeather2());
      }
      if (hasTemp2()) {
        paramCodedOutputStreamMicro.writeString(23, getTemp2());
      }
      if (hasWind2()) {
        paramCodedOutputStreamMicro.writeString(24, getWind2());
      }
      if (hasPicName2()) {
        paramCodedOutputStreamMicro.writeString(25, getPicName2());
      }
      if (hasPic2()) {
        paramCodedOutputStreamMicro.writeString(26, getPic2());
      }
      if (hasPic21()) {
        paramCodedOutputStreamMicro.writeString(27, getPic21());
      }
      if (hasPic22()) {
        paramCodedOutputStreamMicro.writeString(28, getPic22());
      }
      if (hasTime3()) {
        paramCodedOutputStreamMicro.writeString(29, getTime3());
      }
      if (hasWeather3()) {
        paramCodedOutputStreamMicro.writeString(30, getWeather3());
      }
      if (hasTemp3()) {
        paramCodedOutputStreamMicro.writeString(31, getTemp3());
      }
      if (hasWind3()) {
        paramCodedOutputStreamMicro.writeString(32, getWind3());
      }
      if (hasPicName3()) {
        paramCodedOutputStreamMicro.writeString(33, getPicName3());
      }
      if (hasPic3()) {
        paramCodedOutputStreamMicro.writeString(34, getPic3());
      }
      if (hasPic31()) {
        paramCodedOutputStreamMicro.writeString(35, getPic31());
      }
      if (hasPic32()) {
        paramCodedOutputStreamMicro.writeString(36, getPic32());
      }
      if (hasTime4()) {
        paramCodedOutputStreamMicro.writeString(37, getTime4());
      }
      if (hasWeather4()) {
        paramCodedOutputStreamMicro.writeString(38, getWeather4());
      }
      if (hasTemp4()) {
        paramCodedOutputStreamMicro.writeString(39, getTemp4());
      }
      if (hasWind4()) {
        paramCodedOutputStreamMicro.writeString(40, getWind4());
      }
      if (hasPicName4()) {
        paramCodedOutputStreamMicro.writeString(41, getPicName4());
      }
      if (hasPic4()) {
        paramCodedOutputStreamMicro.writeString(42, getPic4());
      }
      if (hasPic41()) {
        paramCodedOutputStreamMicro.writeString(43, getPic41());
      }
      if (hasPic42()) {
        paramCodedOutputStreamMicro.writeString(44, getPic42());
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int T_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
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
      clearStatus();
      clearT();
      this.e = -1;
      return this;
    }
    
    public Option clearStatus()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Option clearT()
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
      if (hasStatus()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStatus());
      }
      int j = i;
      if (hasT()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getT());
      }
      this.e = j;
      return j;
    }
    
    public int getStatus()
    {
      return this.b;
    }
    
    public String getT()
    {
      return this.d;
    }
    
    public boolean hasStatus()
    {
      return this.a;
    }
    
    public boolean hasT()
    {
      return this.c;
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
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          setStatus(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setT(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Option setStatus(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Option setT(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasStatus()) {
        paramCodedOutputStreamMicro.writeInt32(1, getStatus());
      }
      if (hasT()) {
        paramCodedOutputStreamMicro.writeString(2, getT());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Weather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */