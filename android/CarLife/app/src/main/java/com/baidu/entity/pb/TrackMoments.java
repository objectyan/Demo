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

public final class TrackMoments
  extends MessageMicro
{
  public static final int LAST_SID_FIELD_NUMBER = 4;
  public static final int LISTS_FIELD_NUMBER = 2;
  public static final int PERSONAL_FIELD_NUMBER = 1;
  public static final int TS_FIELD_NUMBER = 3;
  private List<Pic> a = Collections.emptyList();
  private List<Pic> b = Collections.emptyList();
  private boolean c;
  private int d = 0;
  private boolean e;
  private String f = "";
  private int g = -1;
  
  public static TrackMoments parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TrackMoments().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TrackMoments parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TrackMoments)new TrackMoments().mergeFrom(paramArrayOfByte);
  }
  
  public TrackMoments addLists(Pic paramPic)
  {
    if (paramPic == null) {
      return this;
    }
    if (this.b.isEmpty()) {
      this.b = new ArrayList();
    }
    this.b.add(paramPic);
    return this;
  }
  
  public TrackMoments addPersonal(Pic paramPic)
  {
    if (paramPic == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramPic);
    return this;
  }
  
  public final TrackMoments clear()
  {
    clearPersonal();
    clearLists();
    clearTs();
    clearLastSid();
    this.g = -1;
    return this;
  }
  
  public TrackMoments clearLastSid()
  {
    this.e = false;
    this.f = "";
    return this;
  }
  
  public TrackMoments clearLists()
  {
    this.b = Collections.emptyList();
    return this;
  }
  
  public TrackMoments clearPersonal()
  {
    this.a = Collections.emptyList();
    return this;
  }
  
  public TrackMoments clearTs()
  {
    this.c = false;
    this.d = 0;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.g < 0) {
      getSerializedSize();
    }
    return this.g;
  }
  
  public String getLastSid()
  {
    return this.f;
  }
  
  public Pic getLists(int paramInt)
  {
    return (Pic)this.b.get(paramInt);
  }
  
  public int getListsCount()
  {
    return this.b.size();
  }
  
  public List<Pic> getListsList()
  {
    return this.b;
  }
  
  public Pic getPersonal(int paramInt)
  {
    return (Pic)this.a.get(paramInt);
  }
  
  public int getPersonalCount()
  {
    return this.a.size();
  }
  
  public List<Pic> getPersonalList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getPersonalList().iterator();
    for (int j = 0; localIterator.hasNext(); j = CodedOutputStreamMicro.computeMessageSize(1, (Pic)localIterator.next()) + j) {}
    localIterator = getListsList().iterator();
    while (localIterator.hasNext()) {
      j += CodedOutputStreamMicro.computeMessageSize(2, (Pic)localIterator.next());
    }
    int i = j;
    if (hasTs()) {
      i = j + CodedOutputStreamMicro.computeInt32Size(3, getTs());
    }
    j = i;
    if (hasLastSid()) {
      j = i + CodedOutputStreamMicro.computeStringSize(4, getLastSid());
    }
    this.g = j;
    return j;
  }
  
  public int getTs()
  {
    return this.d;
  }
  
  public boolean hasLastSid()
  {
    return this.e;
  }
  
  public boolean hasTs()
  {
    return this.c;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public TrackMoments mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    for (;;)
    {
      int i = paramCodedInputStreamMicro.readTag();
      Pic localPic;
      switch (i)
      {
      default: 
        if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        localPic = new Pic();
        paramCodedInputStreamMicro.readMessage(localPic);
        addPersonal(localPic);
        break;
      case 18: 
        localPic = new Pic();
        paramCodedInputStreamMicro.readMessage(localPic);
        addLists(localPic);
        break;
      case 24: 
        setTs(paramCodedInputStreamMicro.readInt32());
        break;
      case 34: 
        setLastSid(paramCodedInputStreamMicro.readString());
      }
    }
  }
  
  public TrackMoments setLastSid(String paramString)
  {
    this.e = true;
    this.f = paramString;
    return this;
  }
  
  public TrackMoments setLists(int paramInt, Pic paramPic)
  {
    if (paramPic == null) {
      return this;
    }
    this.b.set(paramInt, paramPic);
    return this;
  }
  
  public TrackMoments setPersonal(int paramInt, Pic paramPic)
  {
    if (paramPic == null) {
      return this;
    }
    this.a.set(paramInt, paramPic);
    return this;
  }
  
  public TrackMoments setTs(int paramInt)
  {
    this.c = true;
    this.d = paramInt;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getPersonalList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (Pic)localIterator.next());
    }
    localIterator = getListsList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (Pic)localIterator.next());
    }
    if (hasTs()) {
      paramCodedOutputStreamMicro.writeInt32(3, getTs());
    }
    if (hasLastSid()) {
      paramCodedOutputStreamMicro.writeString(4, getLastSid());
    }
  }
  
  public static final class Imgs
    extends MessageMicro
  {
    public static final int RAW_FIELD_NUMBER = 2;
    public static final int THUMB_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static Imgs parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Imgs().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Imgs parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Imgs)new Imgs().mergeFrom(paramArrayOfByte);
    }
    
    public final Imgs clear()
    {
      clearThumb();
      clearRaw();
      this.e = -1;
      return this;
    }
    
    public Imgs clearRaw()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Imgs clearThumb()
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
    
    public String getRaw()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasThumb()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThumb());
      }
      int j = i;
      if (hasRaw()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getRaw());
      }
      this.e = j;
      return j;
    }
    
    public String getThumb()
    {
      return this.b;
    }
    
    public boolean hasRaw()
    {
      return this.c;
    }
    
    public boolean hasThumb()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Imgs mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setThumb(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setRaw(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Imgs setRaw(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Imgs setThumb(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasThumb()) {
        paramCodedOutputStreamMicro.writeString(1, getThumb());
      }
      if (hasRaw()) {
        paramCodedOutputStreamMicro.writeString(2, getRaw());
      }
    }
  }
  
  public static final class Pic
    extends MessageMicro
  {
    public static final int CITY_NUM_FIELD_NUMBER = 7;
    public static final int DATE_FIELD_NUMBER = 3;
    public static final int DISTANCE_FIELD_NUMBER = 6;
    public static final int IMGS_FIELD_NUMBER = 5;
    public static final int LOGO_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int POINT_NUM_FIELD_NUMBER = 9;
    public static final int PROVINCE_NUM_FIELD_NUMBER = 8;
    public static final int VIEWS_FIELD_NUMBER = 4;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private int h = 0;
    private boolean i;
    private TrackMoments.Imgs j = null;
    private boolean k;
    private int l = 0;
    private boolean m;
    private int n = 0;
    private boolean o;
    private int p = 0;
    private boolean q;
    private int r = 0;
    private int s = -1;
    
    public static Pic parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Pic().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Pic parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Pic)new Pic().mergeFrom(paramArrayOfByte);
    }
    
    public final Pic clear()
    {
      clearLogo();
      clearName();
      clearDate();
      clearViews();
      clearImgs();
      clearDistance();
      clearCityNum();
      clearProvinceNum();
      clearPointNum();
      this.s = -1;
      return this;
    }
    
    public Pic clearCityNum()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public Pic clearDate()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Pic clearDistance()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public Pic clearImgs()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public Pic clearLogo()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Pic clearName()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Pic clearPointNum()
    {
      this.q = false;
      this.r = 0;
      return this;
    }
    
    public Pic clearProvinceNum()
    {
      this.o = false;
      this.p = 0;
      return this;
    }
    
    public Pic clearViews()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.s < 0) {
        getSerializedSize();
      }
      return this.s;
    }
    
    public int getCityNum()
    {
      return this.n;
    }
    
    public String getDate()
    {
      return this.f;
    }
    
    public int getDistance()
    {
      return this.l;
    }
    
    public TrackMoments.Imgs getImgs()
    {
      return this.j;
    }
    
    public String getLogo()
    {
      return this.b;
    }
    
    public String getName()
    {
      return this.d;
    }
    
    public int getPointNum()
    {
      return this.r;
    }
    
    public int getProvinceNum()
    {
      return this.p;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasLogo()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getLogo());
      }
      int i1 = i2;
      if (hasName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
      }
      i2 = i1;
      if (hasDate()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getDate());
      }
      i1 = i2;
      if (hasViews()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getViews());
      }
      i2 = i1;
      if (hasImgs()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getImgs());
      }
      i1 = i2;
      if (hasDistance()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getDistance());
      }
      i2 = i1;
      if (hasCityNum()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getCityNum());
      }
      i1 = i2;
      if (hasProvinceNum()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getProvinceNum());
      }
      i2 = i1;
      if (hasPointNum()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getPointNum());
      }
      this.s = i2;
      return i2;
    }
    
    public int getViews()
    {
      return this.h;
    }
    
    public boolean hasCityNum()
    {
      return this.m;
    }
    
    public boolean hasDate()
    {
      return this.e;
    }
    
    public boolean hasDistance()
    {
      return this.k;
    }
    
    public boolean hasImgs()
    {
      return this.i;
    }
    
    public boolean hasLogo()
    {
      return this.a;
    }
    
    public boolean hasName()
    {
      return this.c;
    }
    
    public boolean hasPointNum()
    {
      return this.q;
    }
    
    public boolean hasProvinceNum()
    {
      return this.o;
    }
    
    public boolean hasViews()
    {
      return this.g;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Pic mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setLogo(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setDate(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setViews(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          TrackMoments.Imgs localImgs = new TrackMoments.Imgs();
          paramCodedInputStreamMicro.readMessage(localImgs);
          setImgs(localImgs);
          break;
        case 48: 
          setDistance(paramCodedInputStreamMicro.readInt32());
          break;
        case 56: 
          setCityNum(paramCodedInputStreamMicro.readInt32());
          break;
        case 64: 
          setProvinceNum(paramCodedInputStreamMicro.readInt32());
          break;
        case 72: 
          setPointNum(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Pic setCityNum(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public Pic setDate(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Pic setDistance(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public Pic setImgs(TrackMoments.Imgs paramImgs)
    {
      if (paramImgs == null) {
        return clearImgs();
      }
      this.i = true;
      this.j = paramImgs;
      return this;
    }
    
    public Pic setLogo(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Pic setName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Pic setPointNum(int paramInt)
    {
      this.q = true;
      this.r = paramInt;
      return this;
    }
    
    public Pic setProvinceNum(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public Pic setViews(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasLogo()) {
        paramCodedOutputStreamMicro.writeString(1, getLogo());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(2, getName());
      }
      if (hasDate()) {
        paramCodedOutputStreamMicro.writeString(3, getDate());
      }
      if (hasViews()) {
        paramCodedOutputStreamMicro.writeInt32(4, getViews());
      }
      if (hasImgs()) {
        paramCodedOutputStreamMicro.writeMessage(5, getImgs());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeInt32(6, getDistance());
      }
      if (hasCityNum()) {
        paramCodedOutputStreamMicro.writeInt32(7, getCityNum());
      }
      if (hasProvinceNum()) {
        paramCodedOutputStreamMicro.writeInt32(8, getProvinceNum());
      }
      if (hasPointNum()) {
        paramCodedOutputStreamMicro.writeInt32(9, getPointNum());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TrackMoments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */