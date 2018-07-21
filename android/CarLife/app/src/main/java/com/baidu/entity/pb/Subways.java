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

public final class Subways
  extends MessageMicro
{
  public static final int L_FIELD_NUMBER = 2;
  public static final int SW_XMLATTR_FIELD_NUMBER = 1;
  private boolean a;
  private SwXmlattr b = null;
  private List<L> c = Collections.emptyList();
  private int d = -1;
  
  public static Subways parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new Subways().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static Subways parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (Subways)new Subways().mergeFrom(paramArrayOfByte);
  }
  
  public Subways addL(L paramL)
  {
    if (paramL == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramL);
    return this;
  }
  
  public final Subways clear()
  {
    clearSwXmlattr();
    clearL();
    this.d = -1;
    return this;
  }
  
  public Subways clearL()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public Subways clearSwXmlattr()
  {
    this.a = false;
    this.b = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.d < 0) {
      getSerializedSize();
    }
    return this.d;
  }
  
  public L getL(int paramInt)
  {
    return (L)this.c.get(paramInt);
  }
  
  public int getLCount()
  {
    return this.c.size();
  }
  
  public List<L> getLList()
  {
    return this.c;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasSwXmlattr()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getSwXmlattr());
    }
    Iterator localIterator = getLList().iterator();
    while (localIterator.hasNext()) {
      i = CodedOutputStreamMicro.computeMessageSize(2, (L)localIterator.next()) + i;
    }
    this.d = i;
    return i;
  }
  
  public SwXmlattr getSwXmlattr()
  {
    return this.b;
  }
  
  public boolean hasSwXmlattr()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Subways mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new SwXmlattr();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setSwXmlattr((SwXmlattr)localObject);
        break;
      case 18: 
        localObject = new L();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addL((L)localObject);
      }
    }
  }
  
  public Subways setL(int paramInt, L paramL)
  {
    if (paramL == null) {
      return this;
    }
    this.c.set(paramInt, paramL);
    return this;
  }
  
  public Subways setSwXmlattr(SwXmlattr paramSwXmlattr)
  {
    if (paramSwXmlattr == null) {
      return clearSwXmlattr();
    }
    this.a = true;
    this.b = paramSwXmlattr;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasSwXmlattr()) {
      paramCodedOutputStreamMicro.writeMessage(1, getSwXmlattr());
    }
    Iterator localIterator = getLList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (L)localIterator.next());
    }
  }
  
  public static final class L
    extends MessageMicro
  {
    public static final int L_XMLATTR_FIELD_NUMBER = 1;
    public static final int P_FIELD_NUMBER = 2;
    private boolean a;
    private LXmlattr b = null;
    private List<P> c = Collections.emptyList();
    private int d = -1;
    
    public static L parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new L().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static L parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (L)new L().mergeFrom(paramArrayOfByte);
    }
    
    public L addP(P paramP)
    {
      if (paramP == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramP);
      return this;
    }
    
    public final L clear()
    {
      clearLXmlattr();
      clearP();
      this.d = -1;
      return this;
    }
    
    public L clearLXmlattr()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public L clearP()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public LXmlattr getLXmlattr()
    {
      return this.b;
    }
    
    public P getP(int paramInt)
    {
      return (P)this.c.get(paramInt);
    }
    
    public int getPCount()
    {
      return this.c.size();
    }
    
    public List<P> getPList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasLXmlattr()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getLXmlattr());
      }
      Iterator localIterator = getPList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (P)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasLXmlattr()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public L mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new LXmlattr();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setLXmlattr((LXmlattr)localObject);
          break;
        case 18: 
          localObject = new P();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addP((P)localObject);
        }
      }
    }
    
    public L setLXmlattr(LXmlattr paramLXmlattr)
    {
      if (paramLXmlattr == null) {
        return clearLXmlattr();
      }
      this.a = true;
      this.b = paramLXmlattr;
      return this;
    }
    
    public L setP(int paramInt, P paramP)
    {
      if (paramP == null) {
        return this;
      }
      this.c.set(paramInt, paramP);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasLXmlattr()) {
        paramCodedOutputStreamMicro.writeMessage(1, getLXmlattr());
      }
      Iterator localIterator = getPList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (P)localIterator.next());
      }
    }
    
    public static final class LXmlattr
      extends MessageMicro
    {
      public static final int LBR_FIELD_NUMBER = 8;
      public static final int LBX_FIELD_NUMBER = 6;
      public static final int LBY_FIELD_NUMBER = 7;
      public static final int LB_FIELD_NUMBER = 2;
      public static final int LC_FIELD_NUMBER = 9;
      public static final int LID_FIELD_NUMBER = 1;
      public static final int LOOP_FIELD_NUMBER = 5;
      public static final int N_FIELD_NUMBER = 4;
      public static final int SLB_FIELD_NUMBER = 3;
      public static final int UID2_FIELD_NUMBER = 11;
      public static final int UID_FIELD_NUMBER = 10;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private boolean i;
      private boolean j = false;
      private boolean k;
      private double l = 0.0D;
      private boolean m;
      private double n = 0.0D;
      private boolean o;
      private double p = 0.0D;
      private boolean q;
      private String r = "";
      private boolean s;
      private String t = "";
      private boolean u;
      private String v = "";
      private int w = -1;
      
      public static LXmlattr parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new LXmlattr().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static LXmlattr parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (LXmlattr)new LXmlattr().mergeFrom(paramArrayOfByte);
      }
      
      public final LXmlattr clear()
      {
        clearLid();
        clearLb();
        clearSlb();
        clearN();
        clearLoop();
        clearLbx();
        clearLby();
        clearLbr();
        clearLc();
        clearUid();
        clearUid2();
        this.w = -1;
        return this;
      }
      
      public LXmlattr clearLb()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public LXmlattr clearLbr()
      {
        this.o = false;
        this.p = 0.0D;
        return this;
      }
      
      public LXmlattr clearLbx()
      {
        this.k = false;
        this.l = 0.0D;
        return this;
      }
      
      public LXmlattr clearLby()
      {
        this.m = false;
        this.n = 0.0D;
        return this;
      }
      
      public LXmlattr clearLc()
      {
        this.q = false;
        this.r = "";
        return this;
      }
      
      public LXmlattr clearLid()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public LXmlattr clearLoop()
      {
        this.i = false;
        this.j = false;
        return this;
      }
      
      public LXmlattr clearN()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public LXmlattr clearSlb()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public LXmlattr clearUid()
      {
        this.s = false;
        this.t = "";
        return this;
      }
      
      public LXmlattr clearUid2()
      {
        this.u = false;
        this.v = "";
        return this;
      }
      
      public int getCachedSize()
      {
        if (this.w < 0) {
          getSerializedSize();
        }
        return this.w;
      }
      
      public String getLb()
      {
        return this.d;
      }
      
      public double getLbr()
      {
        return this.p;
      }
      
      public double getLbx()
      {
        return this.l;
      }
      
      public double getLby()
      {
        return this.n;
      }
      
      public String getLc()
      {
        return this.r;
      }
      
      public String getLid()
      {
        return this.b;
      }
      
      public boolean getLoop()
      {
        return this.j;
      }
      
      public String getN()
      {
        return this.h;
      }
      
      public int getSerializedSize()
      {
        int i2 = 0;
        if (hasLid()) {
          i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getLid());
        }
        int i1 = i2;
        if (hasLb()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getLb());
        }
        i2 = i1;
        if (hasSlb()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getSlb());
        }
        i1 = i2;
        if (hasN()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getN());
        }
        i2 = i1;
        if (hasLoop()) {
          i2 = i1 + CodedOutputStreamMicro.computeBoolSize(5, getLoop());
        }
        i1 = i2;
        if (hasLbx()) {
          i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(6, getLbx());
        }
        i2 = i1;
        if (hasLby()) {
          i2 = i1 + CodedOutputStreamMicro.computeDoubleSize(7, getLby());
        }
        i1 = i2;
        if (hasLbr()) {
          i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(8, getLbr());
        }
        i2 = i1;
        if (hasLc()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getLc());
        }
        i1 = i2;
        if (hasUid()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getUid());
        }
        i2 = i1;
        if (hasUid2()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getUid2());
        }
        this.w = i2;
        return i2;
      }
      
      public String getSlb()
      {
        return this.f;
      }
      
      public String getUid()
      {
        return this.t;
      }
      
      public String getUid2()
      {
        return this.v;
      }
      
      public boolean hasLb()
      {
        return this.c;
      }
      
      public boolean hasLbr()
      {
        return this.o;
      }
      
      public boolean hasLbx()
      {
        return this.k;
      }
      
      public boolean hasLby()
      {
        return this.m;
      }
      
      public boolean hasLc()
      {
        return this.q;
      }
      
      public boolean hasLid()
      {
        return this.a;
      }
      
      public boolean hasLoop()
      {
        return this.i;
      }
      
      public boolean hasN()
      {
        return this.g;
      }
      
      public boolean hasSlb()
      {
        return this.e;
      }
      
      public boolean hasUid()
      {
        return this.s;
      }
      
      public boolean hasUid2()
      {
        return this.u;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public LXmlattr mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setLid(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setLb(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setSlb(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setN(paramCodedInputStreamMicro.readString());
            break;
          case 40: 
            setLoop(paramCodedInputStreamMicro.readBool());
            break;
          case 49: 
            setLbx(paramCodedInputStreamMicro.readDouble());
            break;
          case 57: 
            setLby(paramCodedInputStreamMicro.readDouble());
            break;
          case 65: 
            setLbr(paramCodedInputStreamMicro.readDouble());
            break;
          case 74: 
            setLc(paramCodedInputStreamMicro.readString());
            break;
          case 82: 
            setUid(paramCodedInputStreamMicro.readString());
            break;
          case 90: 
            setUid2(paramCodedInputStreamMicro.readString());
          }
        }
      }
      
      public LXmlattr setLb(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public LXmlattr setLbr(double paramDouble)
      {
        this.o = true;
        this.p = paramDouble;
        return this;
      }
      
      public LXmlattr setLbx(double paramDouble)
      {
        this.k = true;
        this.l = paramDouble;
        return this;
      }
      
      public LXmlattr setLby(double paramDouble)
      {
        this.m = true;
        this.n = paramDouble;
        return this;
      }
      
      public LXmlattr setLc(String paramString)
      {
        this.q = true;
        this.r = paramString;
        return this;
      }
      
      public LXmlattr setLid(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public LXmlattr setLoop(boolean paramBoolean)
      {
        this.i = true;
        this.j = paramBoolean;
        return this;
      }
      
      public LXmlattr setN(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public LXmlattr setSlb(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public LXmlattr setUid(String paramString)
      {
        this.s = true;
        this.t = paramString;
        return this;
      }
      
      public LXmlattr setUid2(String paramString)
      {
        this.u = true;
        this.v = paramString;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasLid()) {
          paramCodedOutputStreamMicro.writeString(1, getLid());
        }
        if (hasLb()) {
          paramCodedOutputStreamMicro.writeString(2, getLb());
        }
        if (hasSlb()) {
          paramCodedOutputStreamMicro.writeString(3, getSlb());
        }
        if (hasN()) {
          paramCodedOutputStreamMicro.writeString(4, getN());
        }
        if (hasLoop()) {
          paramCodedOutputStreamMicro.writeBool(5, getLoop());
        }
        if (hasLbx()) {
          paramCodedOutputStreamMicro.writeDouble(6, getLbx());
        }
        if (hasLby()) {
          paramCodedOutputStreamMicro.writeDouble(7, getLby());
        }
        if (hasLbr()) {
          paramCodedOutputStreamMicro.writeDouble(8, getLbr());
        }
        if (hasLc()) {
          paramCodedOutputStreamMicro.writeString(9, getLc());
        }
        if (hasUid()) {
          paramCodedOutputStreamMicro.writeString(10, getUid());
        }
        if (hasUid2()) {
          paramCodedOutputStreamMicro.writeString(11, getUid2());
        }
      }
    }
    
    public static final class P
      extends MessageMicro
    {
      public static final int P_XMLATTR_FIELD_NUMBER = 1;
      private boolean a;
      private PXmlattr b = null;
      private int c = -1;
      
      public static P parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new P().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static P parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (P)new P().mergeFrom(paramArrayOfByte);
      }
      
      public final P clear()
      {
        clearPXmlattr();
        this.c = -1;
        return this;
      }
      
      public P clearPXmlattr()
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
      
      public PXmlattr getPXmlattr()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasPXmlattr()) {
          i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getPXmlattr());
        }
        this.c = i;
        return i;
      }
      
      public boolean hasPXmlattr()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public P mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            PXmlattr localPXmlattr = new PXmlattr();
            paramCodedInputStreamMicro.readMessage(localPXmlattr);
            setPXmlattr(localPXmlattr);
          }
        }
      }
      
      public P setPXmlattr(PXmlattr paramPXmlattr)
      {
        if (paramPXmlattr == null) {
          return clearPXmlattr();
        }
        this.a = true;
        this.b = paramPXmlattr;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasPXmlattr()) {
          paramCodedOutputStreamMicro.writeMessage(1, getPXmlattr());
        }
      }
      
      public static final class PXmlattr
        extends MessageMicro
      {
        public static final int BOLD_FIELD_NUMBER = 15;
        public static final int EX_FIELD_NUMBER = 8;
        public static final int IU_FIELD_NUMBER = 9;
        public static final int LB_FIELD_NUMBER = 2;
        public static final int PX_FIELD_NUMBER = 12;
        public static final int PY_FIELD_NUMBER = 13;
        public static final int RC_FIELD_NUMBER = 10;
        public static final int RX_FIELD_NUMBER = 5;
        public static final int RY_FIELD_NUMBER = 6;
        public static final int SID_FIELD_NUMBER = 1;
        public static final int SLB_FIELD_NUMBER = 11;
        public static final int ST_FIELD_NUMBER = 7;
        public static final int UID_FIELD_NUMBER = 14;
        public static final int X_FIELD_NUMBER = 3;
        public static final int Y_FIELD_NUMBER = 4;
        private boolean A;
        private String B = "";
        private boolean C;
        private boolean D = false;
        private int E = -1;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private double f = 0.0D;
        private boolean g;
        private double h = 0.0D;
        private boolean i;
        private double j = 0.0D;
        private boolean k;
        private double l = 0.0D;
        private boolean m;
        private boolean n = false;
        private boolean o;
        private boolean p = false;
        private boolean q;
        private boolean r = false;
        private boolean s;
        private boolean t = false;
        private boolean u;
        private boolean v = false;
        private boolean w;
        private double x = 0.0D;
        private boolean y;
        private double z = 0.0D;
        
        public static PXmlattr parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new PXmlattr().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static PXmlattr parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (PXmlattr)new PXmlattr().mergeFrom(paramArrayOfByte);
        }
        
        public final PXmlattr clear()
        {
          clearSid();
          clearLb();
          clearX();
          clearY();
          clearRx();
          clearRy();
          clearSt();
          clearEx();
          clearIu();
          clearRc();
          clearSlb();
          clearPx();
          clearPy();
          clearUid();
          clearBold();
          this.E = -1;
          return this;
        }
        
        public PXmlattr clearBold()
        {
          this.C = false;
          this.D = false;
          return this;
        }
        
        public PXmlattr clearEx()
        {
          this.o = false;
          this.p = false;
          return this;
        }
        
        public PXmlattr clearIu()
        {
          this.q = false;
          this.r = false;
          return this;
        }
        
        public PXmlattr clearLb()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public PXmlattr clearPx()
        {
          this.w = false;
          this.x = 0.0D;
          return this;
        }
        
        public PXmlattr clearPy()
        {
          this.y = false;
          this.z = 0.0D;
          return this;
        }
        
        public PXmlattr clearRc()
        {
          this.s = false;
          this.t = false;
          return this;
        }
        
        public PXmlattr clearRx()
        {
          this.i = false;
          this.j = 0.0D;
          return this;
        }
        
        public PXmlattr clearRy()
        {
          this.k = false;
          this.l = 0.0D;
          return this;
        }
        
        public PXmlattr clearSid()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public PXmlattr clearSlb()
        {
          this.u = false;
          this.v = false;
          return this;
        }
        
        public PXmlattr clearSt()
        {
          this.m = false;
          this.n = false;
          return this;
        }
        
        public PXmlattr clearUid()
        {
          this.A = false;
          this.B = "";
          return this;
        }
        
        public PXmlattr clearX()
        {
          this.e = false;
          this.f = 0.0D;
          return this;
        }
        
        public PXmlattr clearY()
        {
          this.g = false;
          this.h = 0.0D;
          return this;
        }
        
        public boolean getBold()
        {
          return this.D;
        }
        
        public int getCachedSize()
        {
          if (this.E < 0) {
            getSerializedSize();
          }
          return this.E;
        }
        
        public boolean getEx()
        {
          return this.p;
        }
        
        public boolean getIu()
        {
          return this.r;
        }
        
        public String getLb()
        {
          return this.d;
        }
        
        public double getPx()
        {
          return this.x;
        }
        
        public double getPy()
        {
          return this.z;
        }
        
        public boolean getRc()
        {
          return this.t;
        }
        
        public double getRx()
        {
          return this.j;
        }
        
        public double getRy()
        {
          return this.l;
        }
        
        public int getSerializedSize()
        {
          int i2 = 0;
          if (hasSid()) {
            i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getSid());
          }
          int i1 = i2;
          if (hasLb()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getLb());
          }
          i2 = i1;
          if (hasX()) {
            i2 = i1 + CodedOutputStreamMicro.computeDoubleSize(3, getX());
          }
          i1 = i2;
          if (hasY()) {
            i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(4, getY());
          }
          i2 = i1;
          if (hasRx()) {
            i2 = i1 + CodedOutputStreamMicro.computeDoubleSize(5, getRx());
          }
          i1 = i2;
          if (hasRy()) {
            i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(6, getRy());
          }
          i2 = i1;
          if (hasSt()) {
            i2 = i1 + CodedOutputStreamMicro.computeBoolSize(7, getSt());
          }
          i1 = i2;
          if (hasEx()) {
            i1 = i2 + CodedOutputStreamMicro.computeBoolSize(8, getEx());
          }
          i2 = i1;
          if (hasIu()) {
            i2 = i1 + CodedOutputStreamMicro.computeBoolSize(9, getIu());
          }
          i1 = i2;
          if (hasRc()) {
            i1 = i2 + CodedOutputStreamMicro.computeBoolSize(10, getRc());
          }
          i2 = i1;
          if (hasSlb()) {
            i2 = i1 + CodedOutputStreamMicro.computeBoolSize(11, getSlb());
          }
          i1 = i2;
          if (hasPx()) {
            i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(12, getPx());
          }
          i2 = i1;
          if (hasPy()) {
            i2 = i1 + CodedOutputStreamMicro.computeDoubleSize(13, getPy());
          }
          i1 = i2;
          if (hasUid()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getUid());
          }
          i2 = i1;
          if (hasBold()) {
            i2 = i1 + CodedOutputStreamMicro.computeBoolSize(15, getBold());
          }
          this.E = i2;
          return i2;
        }
        
        public String getSid()
        {
          return this.b;
        }
        
        public boolean getSlb()
        {
          return this.v;
        }
        
        public boolean getSt()
        {
          return this.n;
        }
        
        public String getUid()
        {
          return this.B;
        }
        
        public double getX()
        {
          return this.f;
        }
        
        public double getY()
        {
          return this.h;
        }
        
        public boolean hasBold()
        {
          return this.C;
        }
        
        public boolean hasEx()
        {
          return this.o;
        }
        
        public boolean hasIu()
        {
          return this.q;
        }
        
        public boolean hasLb()
        {
          return this.c;
        }
        
        public boolean hasPx()
        {
          return this.w;
        }
        
        public boolean hasPy()
        {
          return this.y;
        }
        
        public boolean hasRc()
        {
          return this.s;
        }
        
        public boolean hasRx()
        {
          return this.i;
        }
        
        public boolean hasRy()
        {
          return this.k;
        }
        
        public boolean hasSid()
        {
          return this.a;
        }
        
        public boolean hasSlb()
        {
          return this.u;
        }
        
        public boolean hasSt()
        {
          return this.m;
        }
        
        public boolean hasUid()
        {
          return this.A;
        }
        
        public boolean hasX()
        {
          return this.e;
        }
        
        public boolean hasY()
        {
          return this.g;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public PXmlattr mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setSid(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setLb(paramCodedInputStreamMicro.readString());
              break;
            case 25: 
              setX(paramCodedInputStreamMicro.readDouble());
              break;
            case 33: 
              setY(paramCodedInputStreamMicro.readDouble());
              break;
            case 41: 
              setRx(paramCodedInputStreamMicro.readDouble());
              break;
            case 49: 
              setRy(paramCodedInputStreamMicro.readDouble());
              break;
            case 56: 
              setSt(paramCodedInputStreamMicro.readBool());
              break;
            case 64: 
              setEx(paramCodedInputStreamMicro.readBool());
              break;
            case 72: 
              setIu(paramCodedInputStreamMicro.readBool());
              break;
            case 80: 
              setRc(paramCodedInputStreamMicro.readBool());
              break;
            case 88: 
              setSlb(paramCodedInputStreamMicro.readBool());
              break;
            case 97: 
              setPx(paramCodedInputStreamMicro.readDouble());
              break;
            case 105: 
              setPy(paramCodedInputStreamMicro.readDouble());
              break;
            case 114: 
              setUid(paramCodedInputStreamMicro.readString());
              break;
            case 120: 
              setBold(paramCodedInputStreamMicro.readBool());
            }
          }
        }
        
        public PXmlattr setBold(boolean paramBoolean)
        {
          this.C = true;
          this.D = paramBoolean;
          return this;
        }
        
        public PXmlattr setEx(boolean paramBoolean)
        {
          this.o = true;
          this.p = paramBoolean;
          return this;
        }
        
        public PXmlattr setIu(boolean paramBoolean)
        {
          this.q = true;
          this.r = paramBoolean;
          return this;
        }
        
        public PXmlattr setLb(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public PXmlattr setPx(double paramDouble)
        {
          this.w = true;
          this.x = paramDouble;
          return this;
        }
        
        public PXmlattr setPy(double paramDouble)
        {
          this.y = true;
          this.z = paramDouble;
          return this;
        }
        
        public PXmlattr setRc(boolean paramBoolean)
        {
          this.s = true;
          this.t = paramBoolean;
          return this;
        }
        
        public PXmlattr setRx(double paramDouble)
        {
          this.i = true;
          this.j = paramDouble;
          return this;
        }
        
        public PXmlattr setRy(double paramDouble)
        {
          this.k = true;
          this.l = paramDouble;
          return this;
        }
        
        public PXmlattr setSid(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public PXmlattr setSlb(boolean paramBoolean)
        {
          this.u = true;
          this.v = paramBoolean;
          return this;
        }
        
        public PXmlattr setSt(boolean paramBoolean)
        {
          this.m = true;
          this.n = paramBoolean;
          return this;
        }
        
        public PXmlattr setUid(String paramString)
        {
          this.A = true;
          this.B = paramString;
          return this;
        }
        
        public PXmlattr setX(double paramDouble)
        {
          this.e = true;
          this.f = paramDouble;
          return this;
        }
        
        public PXmlattr setY(double paramDouble)
        {
          this.g = true;
          this.h = paramDouble;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasSid()) {
            paramCodedOutputStreamMicro.writeString(1, getSid());
          }
          if (hasLb()) {
            paramCodedOutputStreamMicro.writeString(2, getLb());
          }
          if (hasX()) {
            paramCodedOutputStreamMicro.writeDouble(3, getX());
          }
          if (hasY()) {
            paramCodedOutputStreamMicro.writeDouble(4, getY());
          }
          if (hasRx()) {
            paramCodedOutputStreamMicro.writeDouble(5, getRx());
          }
          if (hasRy()) {
            paramCodedOutputStreamMicro.writeDouble(6, getRy());
          }
          if (hasSt()) {
            paramCodedOutputStreamMicro.writeBool(7, getSt());
          }
          if (hasEx()) {
            paramCodedOutputStreamMicro.writeBool(8, getEx());
          }
          if (hasIu()) {
            paramCodedOutputStreamMicro.writeBool(9, getIu());
          }
          if (hasRc()) {
            paramCodedOutputStreamMicro.writeBool(10, getRc());
          }
          if (hasSlb()) {
            paramCodedOutputStreamMicro.writeBool(11, getSlb());
          }
          if (hasPx()) {
            paramCodedOutputStreamMicro.writeDouble(12, getPx());
          }
          if (hasPy()) {
            paramCodedOutputStreamMicro.writeDouble(13, getPy());
          }
          if (hasUid()) {
            paramCodedOutputStreamMicro.writeString(14, getUid());
          }
          if (hasBold()) {
            paramCodedOutputStreamMicro.writeBool(15, getBold());
          }
        }
      }
    }
  }
  
  public static final class SwXmlattr
    extends MessageMicro
  {
    public static final int BG_FIELD_NUMBER = 5;
    public static final int CID_FIELD_NUMBER = 1;
    public static final int C_FIELD_NUMBER = 3;
    public static final int HEIGHT_FIELD_NUMBER = 8;
    public static final int ICON_FIELD_NUMBER = 6;
    public static final int N_FIELD_NUMBER = 2;
    public static final int SRC_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 9;
    public static final int WIDTH_FIELD_NUMBER = 7;
    private boolean a;
    private String b = "";
    private boolean c;
    private int d = 0;
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
    
    public static SwXmlattr parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SwXmlattr().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SwXmlattr parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SwXmlattr)new SwXmlattr().mergeFrom(paramArrayOfByte);
    }
    
    public final SwXmlattr clear()
    {
      clearCid();
      clearN();
      clearC();
      clearSrc();
      clearBg();
      clearIcon();
      clearWidth();
      clearHeight();
      clearVersion();
      this.s = -1;
      return this;
    }
    
    public SwXmlattr clearBg()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public SwXmlattr clearC()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public SwXmlattr clearCid()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public SwXmlattr clearHeight()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public SwXmlattr clearIcon()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public SwXmlattr clearN()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public SwXmlattr clearSrc()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public SwXmlattr clearVersion()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public SwXmlattr clearWidth()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public String getBg()
    {
      return this.j;
    }
    
    public String getC()
    {
      return this.f;
    }
    
    public int getCachedSize()
    {
      if (this.s < 0) {
        getSerializedSize();
      }
      return this.s;
    }
    
    public String getCid()
    {
      return this.b;
    }
    
    public String getHeight()
    {
      return this.p;
    }
    
    public String getIcon()
    {
      return this.l;
    }
    
    public int getN()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasCid()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCid());
      }
      int i1 = i2;
      if (hasN()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getN());
      }
      i2 = i1;
      if (hasC()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getC());
      }
      i1 = i2;
      if (hasSrc()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getSrc());
      }
      i2 = i1;
      if (hasBg()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getBg());
      }
      i1 = i2;
      if (hasIcon()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getIcon());
      }
      i2 = i1;
      if (hasWidth()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getWidth());
      }
      i1 = i2;
      if (hasHeight()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getHeight());
      }
      i2 = i1;
      if (hasVersion()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getVersion());
      }
      this.s = i2;
      return i2;
    }
    
    public String getSrc()
    {
      return this.h;
    }
    
    public String getVersion()
    {
      return this.r;
    }
    
    public String getWidth()
    {
      return this.n;
    }
    
    public boolean hasBg()
    {
      return this.i;
    }
    
    public boolean hasC()
    {
      return this.e;
    }
    
    public boolean hasCid()
    {
      return this.a;
    }
    
    public boolean hasHeight()
    {
      return this.o;
    }
    
    public boolean hasIcon()
    {
      return this.k;
    }
    
    public boolean hasN()
    {
      return this.c;
    }
    
    public boolean hasSrc()
    {
      return this.g;
    }
    
    public boolean hasVersion()
    {
      return this.q;
    }
    
    public boolean hasWidth()
    {
      return this.m;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SwXmlattr mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCid(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setN(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          setC(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setSrc(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setBg(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setWidth(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setHeight(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setVersion(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public SwXmlattr setBg(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public SwXmlattr setC(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public SwXmlattr setCid(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public SwXmlattr setHeight(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public SwXmlattr setIcon(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public SwXmlattr setN(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public SwXmlattr setSrc(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public SwXmlattr setVersion(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public SwXmlattr setWidth(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCid()) {
        paramCodedOutputStreamMicro.writeString(1, getCid());
      }
      if (hasN()) {
        paramCodedOutputStreamMicro.writeInt32(2, getN());
      }
      if (hasC()) {
        paramCodedOutputStreamMicro.writeString(3, getC());
      }
      if (hasSrc()) {
        paramCodedOutputStreamMicro.writeString(4, getSrc());
      }
      if (hasBg()) {
        paramCodedOutputStreamMicro.writeString(5, getBg());
      }
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(6, getIcon());
      }
      if (hasWidth()) {
        paramCodedOutputStreamMicro.writeString(7, getWidth());
      }
      if (hasHeight()) {
        paramCodedOutputStreamMicro.writeString(8, getHeight());
      }
      if (hasVersion()) {
        paramCodedOutputStreamMicro.writeString(9, getVersion());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/Subways.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */