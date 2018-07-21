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

public final class TaResponse
  extends MessageMicro
{
  public static final int DATA_CONTENT_FIELD_NUMBER = 2;
  public static final int DATA_RESULT_FIELD_NUMBER = 1;
  private boolean a;
  private TaResult b = null;
  private boolean c;
  private TaContent d = null;
  private int e = -1;
  
  public static TaResponse parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new TaResponse().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static TaResponse parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (TaResponse)new TaResponse().mergeFrom(paramArrayOfByte);
  }
  
  public final TaResponse clear()
  {
    clearDataResult();
    clearDataContent();
    this.e = -1;
    return this;
  }
  
  public TaResponse clearDataContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public TaResponse clearDataResult()
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
  
  public TaContent getDataContent()
  {
    return this.d;
  }
  
  public TaResult getDataResult()
  {
    return this.b;
  }
  
  public int getSerializedSize()
  {
    int i = 0;
    if (hasDataResult()) {
      i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDataResult());
    }
    int j = i;
    if (hasDataContent()) {
      j = i + CodedOutputStreamMicro.computeMessageSize(2, getDataContent());
    }
    this.e = j;
    return j;
  }
  
  public boolean hasDataContent()
  {
    return this.c;
  }
  
  public boolean hasDataResult()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    if (!this.a) {}
    while ((!getDataResult().isInitialized()) || ((hasDataContent()) && (!getDataContent().isInitialized()))) {
      return false;
    }
    return true;
  }
  
  public TaResponse mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new TaResult();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setDataResult((TaResult)localObject);
        break;
      case 18: 
        localObject = new TaContent();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setDataContent((TaContent)localObject);
      }
    }
  }
  
  public TaResponse setDataContent(TaContent paramTaContent)
  {
    if (paramTaContent == null) {
      return clearDataContent();
    }
    this.c = true;
    this.d = paramTaContent;
    return this;
  }
  
  public TaResponse setDataResult(TaResult paramTaResult)
  {
    if (paramTaResult == null) {
      return clearDataResult();
    }
    this.a = true;
    this.b = paramTaResult;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasDataResult()) {
      paramCodedOutputStreamMicro.writeMessage(1, getDataResult());
    }
    if (hasDataContent()) {
      paramCodedOutputStreamMicro.writeMessage(2, getDataContent());
    }
  }
  
  public static final class AddPagePointSug
    extends MessageMicro
  {
    public static final int CITY_NAME_FIELD_NUMBER = 5;
    public static final int LOC_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int POINT_TYPE_FIELD_NUMBER = 1;
    public static final int SRC_FROM_FIELD_NUMBER = 6;
    public static final int UID_FIELD_NUMBER = 4;
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
    
    public static AddPagePointSug parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new AddPagePointSug().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static AddPagePointSug parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (AddPagePointSug)new AddPagePointSug().mergeFrom(paramArrayOfByte);
    }
    
    public final AddPagePointSug clear()
    {
      clearPointType();
      clearName();
      clearLoc();
      clearUid();
      clearCityName();
      clearSrcFrom();
      this.m = -1;
      return this;
    }
    
    public AddPagePointSug clearCityName()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public AddPagePointSug clearLoc()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public AddPagePointSug clearName()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public AddPagePointSug clearPointType()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public AddPagePointSug clearSrcFrom()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public AddPagePointSug clearUid()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public String getCityName()
    {
      return this.j;
    }
    
    public String getLoc()
    {
      return this.f;
    }
    
    public String getName()
    {
      return this.d;
    }
    
    public String getPointType()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasPointType()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getPointType());
      }
      int n = i1;
      if (hasName()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getName());
      }
      i1 = n;
      if (hasLoc()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getLoc());
      }
      n = i1;
      if (hasUid()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getUid());
      }
      i1 = n;
      if (hasCityName()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getCityName());
      }
      n = i1;
      if (hasSrcFrom()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getSrcFrom());
      }
      this.m = n;
      return n;
    }
    
    public String getSrcFrom()
    {
      return this.l;
    }
    
    public String getUid()
    {
      return this.h;
    }
    
    public boolean hasCityName()
    {
      return this.i;
    }
    
    public boolean hasLoc()
    {
      return this.e;
    }
    
    public boolean hasName()
    {
      return this.c;
    }
    
    public boolean hasPointType()
    {
      return this.a;
    }
    
    public boolean hasSrcFrom()
    {
      return this.k;
    }
    
    public boolean hasUid()
    {
      return this.g;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public AddPagePointSug mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setPointType(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setLoc(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setCityName(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setSrcFrom(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public AddPagePointSug setCityName(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public AddPagePointSug setLoc(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public AddPagePointSug setName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public AddPagePointSug setPointType(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public AddPagePointSug setSrcFrom(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public AddPagePointSug setUid(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPointType()) {
        paramCodedOutputStreamMicro.writeString(1, getPointType());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(2, getName());
      }
      if (hasLoc()) {
        paramCodedOutputStreamMicro.writeString(3, getLoc());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(4, getUid());
      }
      if (hasCityName()) {
        paramCodedOutputStreamMicro.writeString(5, getCityName());
      }
      if (hasSrcFrom()) {
        paramCodedOutputStreamMicro.writeString(6, getSrcFrom());
      }
    }
  }
  
  public static final class AddPageTravelModSug
    extends MessageMicro
  {
    public static final int CARD_ICON_URL_FIELD_NUMBER = 2;
    public static final int CARD_TYPE_FIELD_NUMBER = 1;
    public static final int CONTENT_FIELD_NUMBER = 4;
    public static final int IS_CLOSE_FIELD_NUMBER = 6;
    public static final int IS_SUG_FIELD_NUMBER = 5;
    public static final int LABEL_FIELD_NUMBER = 8;
    public static final int SUB_TITLE_FIELD_NUMBER = 7;
    public static final int TITLE_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private int j = 0;
    private boolean k;
    private int l = 0;
    private boolean m;
    private String n = "";
    private boolean o;
    private String p = "";
    private int q = -1;
    
    public static AddPageTravelModSug parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new AddPageTravelModSug().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static AddPageTravelModSug parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (AddPageTravelModSug)new AddPageTravelModSug().mergeFrom(paramArrayOfByte);
    }
    
    public final AddPageTravelModSug clear()
    {
      clearCardType();
      clearCardIconUrl();
      clearTitle();
      clearContent();
      clearIsSug();
      clearIsClose();
      clearSubTitle();
      clearLabel();
      this.q = -1;
      return this;
    }
    
    public AddPageTravelModSug clearCardIconUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public AddPageTravelModSug clearCardType()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public AddPageTravelModSug clearContent()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public AddPageTravelModSug clearIsClose()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public AddPageTravelModSug clearIsSug()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public AddPageTravelModSug clearLabel()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public AddPageTravelModSug clearSubTitle()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public AddPageTravelModSug clearTitle()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.q < 0) {
        getSerializedSize();
      }
      return this.q;
    }
    
    public String getCardIconUrl()
    {
      return this.d;
    }
    
    public String getCardType()
    {
      return this.b;
    }
    
    public String getContent()
    {
      return this.h;
    }
    
    public int getIsClose()
    {
      return this.l;
    }
    
    public int getIsSug()
    {
      return this.j;
    }
    
    public String getLabel()
    {
      return this.p;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasCardType()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCardType());
      }
      int i1 = i2;
      if (hasCardIconUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getCardIconUrl());
      }
      i2 = i1;
      if (hasTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getTitle());
      }
      i1 = i2;
      if (hasContent()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getContent());
      }
      i2 = i1;
      if (hasIsSug()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getIsSug());
      }
      i1 = i2;
      if (hasIsClose()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getIsClose());
      }
      i2 = i1;
      if (hasSubTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getSubTitle());
      }
      i1 = i2;
      if (hasLabel()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getLabel());
      }
      this.q = i1;
      return i1;
    }
    
    public String getSubTitle()
    {
      return this.n;
    }
    
    public String getTitle()
    {
      return this.f;
    }
    
    public boolean hasCardIconUrl()
    {
      return this.c;
    }
    
    public boolean hasCardType()
    {
      return this.a;
    }
    
    public boolean hasContent()
    {
      return this.g;
    }
    
    public boolean hasIsClose()
    {
      return this.k;
    }
    
    public boolean hasIsSug()
    {
      return this.i;
    }
    
    public boolean hasLabel()
    {
      return this.o;
    }
    
    public boolean hasSubTitle()
    {
      return this.m;
    }
    
    public boolean hasTitle()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public AddPageTravelModSug mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCardType(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setCardIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setContent(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setIsSug(paramCodedInputStreamMicro.readInt32());
          break;
        case 48: 
          setIsClose(paramCodedInputStreamMicro.readInt32());
          break;
        case 58: 
          setSubTitle(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setLabel(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public AddPageTravelModSug setCardIconUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public AddPageTravelModSug setCardType(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public AddPageTravelModSug setContent(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public AddPageTravelModSug setIsClose(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public AddPageTravelModSug setIsSug(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public AddPageTravelModSug setLabel(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public AddPageTravelModSug setSubTitle(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public AddPageTravelModSug setTitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCardType()) {
        paramCodedOutputStreamMicro.writeString(1, getCardType());
      }
      if (hasCardIconUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getCardIconUrl());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getTitle());
      }
      if (hasContent()) {
        paramCodedOutputStreamMicro.writeString(4, getContent());
      }
      if (hasIsSug()) {
        paramCodedOutputStreamMicro.writeInt32(5, getIsSug());
      }
      if (hasIsClose()) {
        paramCodedOutputStreamMicro.writeInt32(6, getIsClose());
      }
      if (hasSubTitle()) {
        paramCodedOutputStreamMicro.writeString(7, getSubTitle());
      }
      if (hasLabel()) {
        paramCodedOutputStreamMicro.writeString(8, getLabel());
      }
    }
  }
  
  public static final class AddPageTripTitleSug
    extends MessageMicro
  {
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private int c = -1;
    
    public static AddPageTripTitleSug parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new AddPageTripTitleSug().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static AddPageTripTitleSug parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (AddPageTripTitleSug)new AddPageTripTitleSug().mergeFrom(paramArrayOfByte);
    }
    
    public final AddPageTripTitleSug clear()
    {
      clearTitle();
      this.c = -1;
      return this;
    }
    
    public AddPageTripTitleSug clearTitle()
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
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasTitle()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      this.c = i;
      return i;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public AddPageTripTitleSug mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        }
      }
    }
    
    public AddPageTripTitleSug setTitle(String paramString)
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
    }
  }
  
  public static final class BMTrip
    extends MessageMicro
  {
    public static final int ARRIVAL_TIME_FIELD_NUMBER = 3;
    public static final int END_POINT_FIELD_NUMBER = 5;
    public static final int FLIGHT_INFO_FIELD_NUMBER = 9;
    public static final int START_POINT_FIELD_NUMBER = 4;
    public static final int START_TIME_FIELD_NUMBER = 2;
    public static final int TIME_TYPE_FIELD_NUMBER = 7;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int TRAIN_INFO_FIELD_NUMBER = 8;
    public static final int TRIP_TYPE_FIELD_NUMBER = 6;
    private boolean a;
    private String b = "";
    private boolean c;
    private long d = 0L;
    private boolean e;
    private long f = 0L;
    private boolean g;
    private TaResponse.MLTripPoint h = null;
    private boolean i;
    private TaResponse.MLTripPoint j = null;
    private boolean k;
    private long l = 0L;
    private boolean m;
    private long n = 0L;
    private boolean o;
    private TaResponse.MLTripTrainInfo p = null;
    private boolean q;
    private TaResponse.MLTripFlightInfo r = null;
    private int s = -1;
    
    public static BMTrip parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new BMTrip().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static BMTrip parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (BMTrip)new BMTrip().mergeFrom(paramArrayOfByte);
    }
    
    public final BMTrip clear()
    {
      clearTitle();
      clearStartTime();
      clearArrivalTime();
      clearStartPoint();
      clearEndPoint();
      clearTripType();
      clearTimeType();
      clearTrainInfo();
      clearFlightInfo();
      this.s = -1;
      return this;
    }
    
    public BMTrip clearArrivalTime()
    {
      this.e = false;
      this.f = 0L;
      return this;
    }
    
    public BMTrip clearEndPoint()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public BMTrip clearFlightInfo()
    {
      this.q = false;
      this.r = null;
      return this;
    }
    
    public BMTrip clearStartPoint()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public BMTrip clearStartTime()
    {
      this.c = false;
      this.d = 0L;
      return this;
    }
    
    public BMTrip clearTimeType()
    {
      this.m = false;
      this.n = 0L;
      return this;
    }
    
    public BMTrip clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public BMTrip clearTrainInfo()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public BMTrip clearTripType()
    {
      this.k = false;
      this.l = 0L;
      return this;
    }
    
    public long getArrivalTime()
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
    
    public TaResponse.MLTripPoint getEndPoint()
    {
      return this.j;
    }
    
    public TaResponse.MLTripFlightInfo getFlightInfo()
    {
      return this.r;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasTitle()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      int i1 = i2;
      if (hasStartTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(2, getStartTime());
      }
      i2 = i1;
      if (hasArrivalTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(3, getArrivalTime());
      }
      i1 = i2;
      if (hasStartPoint()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getStartPoint());
      }
      i2 = i1;
      if (hasEndPoint()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getEndPoint());
      }
      i1 = i2;
      if (hasTripType()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(6, getTripType());
      }
      i2 = i1;
      if (hasTimeType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(7, getTimeType());
      }
      i1 = i2;
      if (hasTrainInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getTrainInfo());
      }
      i2 = i1;
      if (hasFlightInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(9, getFlightInfo());
      }
      this.s = i2;
      return i2;
    }
    
    public TaResponse.MLTripPoint getStartPoint()
    {
      return this.h;
    }
    
    public long getStartTime()
    {
      return this.d;
    }
    
    public long getTimeType()
    {
      return this.n;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public TaResponse.MLTripTrainInfo getTrainInfo()
    {
      return this.p;
    }
    
    public long getTripType()
    {
      return this.l;
    }
    
    public boolean hasArrivalTime()
    {
      return this.e;
    }
    
    public boolean hasEndPoint()
    {
      return this.i;
    }
    
    public boolean hasFlightInfo()
    {
      return this.q;
    }
    
    public boolean hasStartPoint()
    {
      return this.g;
    }
    
    public boolean hasStartTime()
    {
      return this.c;
    }
    
    public boolean hasTimeType()
    {
      return this.m;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public boolean hasTrainInfo()
    {
      return this.o;
    }
    
    public boolean hasTripType()
    {
      return this.k;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g) || (!this.i) || (!getStartPoint().isInitialized()) || (!getEndPoint().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public BMTrip mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setStartTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 24: 
          setArrivalTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 34: 
          localObject = new TaResponse.MLTripPoint();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setStartPoint((TaResponse.MLTripPoint)localObject);
          break;
        case 42: 
          localObject = new TaResponse.MLTripPoint();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setEndPoint((TaResponse.MLTripPoint)localObject);
          break;
        case 48: 
          setTripType(paramCodedInputStreamMicro.readInt64());
          break;
        case 56: 
          setTimeType(paramCodedInputStreamMicro.readInt64());
          break;
        case 66: 
          localObject = new TaResponse.MLTripTrainInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTrainInfo((TaResponse.MLTripTrainInfo)localObject);
          break;
        case 74: 
          localObject = new TaResponse.MLTripFlightInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setFlightInfo((TaResponse.MLTripFlightInfo)localObject);
        }
      }
    }
    
    public BMTrip setArrivalTime(long paramLong)
    {
      this.e = true;
      this.f = paramLong;
      return this;
    }
    
    public BMTrip setEndPoint(TaResponse.MLTripPoint paramMLTripPoint)
    {
      if (paramMLTripPoint == null) {
        return clearEndPoint();
      }
      this.i = true;
      this.j = paramMLTripPoint;
      return this;
    }
    
    public BMTrip setFlightInfo(TaResponse.MLTripFlightInfo paramMLTripFlightInfo)
    {
      if (paramMLTripFlightInfo == null) {
        return clearFlightInfo();
      }
      this.q = true;
      this.r = paramMLTripFlightInfo;
      return this;
    }
    
    public BMTrip setStartPoint(TaResponse.MLTripPoint paramMLTripPoint)
    {
      if (paramMLTripPoint == null) {
        return clearStartPoint();
      }
      this.g = true;
      this.h = paramMLTripPoint;
      return this;
    }
    
    public BMTrip setStartTime(long paramLong)
    {
      this.c = true;
      this.d = paramLong;
      return this;
    }
    
    public BMTrip setTimeType(long paramLong)
    {
      this.m = true;
      this.n = paramLong;
      return this;
    }
    
    public BMTrip setTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public BMTrip setTrainInfo(TaResponse.MLTripTrainInfo paramMLTripTrainInfo)
    {
      if (paramMLTripTrainInfo == null) {
        return clearTrainInfo();
      }
      this.o = true;
      this.p = paramMLTripTrainInfo;
      return this;
    }
    
    public BMTrip setTripType(long paramLong)
    {
      this.k = true;
      this.l = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(1, getTitle());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeInt64(2, getStartTime());
      }
      if (hasArrivalTime()) {
        paramCodedOutputStreamMicro.writeInt64(3, getArrivalTime());
      }
      if (hasStartPoint()) {
        paramCodedOutputStreamMicro.writeMessage(4, getStartPoint());
      }
      if (hasEndPoint()) {
        paramCodedOutputStreamMicro.writeMessage(5, getEndPoint());
      }
      if (hasTripType()) {
        paramCodedOutputStreamMicro.writeInt64(6, getTripType());
      }
      if (hasTimeType()) {
        paramCodedOutputStreamMicro.writeInt64(7, getTimeType());
      }
      if (hasTrainInfo()) {
        paramCodedOutputStreamMicro.writeMessage(8, getTrainInfo());
      }
      if (hasFlightInfo()) {
        paramCodedOutputStreamMicro.writeMessage(9, getFlightInfo());
      }
    }
  }
  
  public static final class BaseMapList
    extends MessageMicro
  {
    public static final int TRIP_FIELD_NUMBER = 1;
    private List<TaResponse.BMTrip> a = Collections.emptyList();
    private int b = -1;
    
    public static BaseMapList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new BaseMapList().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static BaseMapList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (BaseMapList)new BaseMapList().mergeFrom(paramArrayOfByte);
    }
    
    public BaseMapList addTrip(TaResponse.BMTrip paramBMTrip)
    {
      if (paramBMTrip == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramBMTrip);
      return this;
    }
    
    public final BaseMapList clear()
    {
      clearTrip();
      this.b = -1;
      return this;
    }
    
    public BaseMapList clearTrip()
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
    
    public int getSerializedSize()
    {
      Iterator localIterator = getTripList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (TaResponse.BMTrip)localIterator.next()) + i) {}
      this.b = i;
      return i;
    }
    
    public TaResponse.BMTrip getTrip(int paramInt)
    {
      return (TaResponse.BMTrip)this.a.get(paramInt);
    }
    
    public int getTripCount()
    {
      return this.a.size();
    }
    
    public List<TaResponse.BMTrip> getTripList()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getTripList().iterator();
      while (localIterator.hasNext()) {
        if (!((TaResponse.BMTrip)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public BaseMapList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.BMTrip localBMTrip = new TaResponse.BMTrip();
          paramCodedInputStreamMicro.readMessage(localBMTrip);
          addTrip(localBMTrip);
        }
      }
    }
    
    public BaseMapList setTrip(int paramInt, TaResponse.BMTrip paramBMTrip)
    {
      if (paramBMTrip == null) {
        return this;
      }
      this.a.set(paramInt, paramBMTrip);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getTripList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (TaResponse.BMTrip)localIterator.next());
      }
    }
  }
  
  public static final class BaseTitleContent
    extends MessageMicro
  {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 4;
    public static final int URL_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static BaseTitleContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new BaseTitleContent().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static BaseTitleContent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (BaseTitleContent)new BaseTitleContent().mergeFrom(paramArrayOfByte);
    }
    
    public final BaseTitleContent clear()
    {
      clearTitle();
      clearContent();
      clearUrl();
      clearType();
      this.i = -1;
      return this;
    }
    
    public BaseTitleContent clearContent()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public BaseTitleContent clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public BaseTitleContent clearType()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public BaseTitleContent clearUrl()
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
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasTitle()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      int j = k;
      if (hasContent()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getContent());
      }
      k = j;
      if (hasUrl()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getUrl());
      }
      j = k;
      if (hasType()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getType());
      }
      this.i = j;
      return j;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public String getType()
    {
      return this.h;
    }
    
    public String getUrl()
    {
      return this.f;
    }
    
    public boolean hasContent()
    {
      return this.c;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public boolean hasType()
    {
      return this.g;
    }
    
    public boolean hasUrl()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public BaseTitleContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        case 18: 
          setContent(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setUrl(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setType(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public BaseTitleContent setContent(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public BaseTitleContent setTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public BaseTitleContent setType(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public BaseTitleContent setUrl(String paramString)
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
      if (hasContent()) {
        paramCodedOutputStreamMicro.writeString(2, getContent());
      }
      if (hasUrl()) {
        paramCodedOutputStreamMicro.writeString(3, getUrl());
      }
      if (hasType()) {
        paramCodedOutputStreamMicro.writeString(4, getType());
      }
    }
  }
  
  public static final class CalendarUploadInfo
    extends MessageMicro
  {
    public static final int CALENDAR_ID_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private int c = -1;
    
    public static CalendarUploadInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CalendarUploadInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CalendarUploadInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CalendarUploadInfo)new CalendarUploadInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final CalendarUploadInfo clear()
    {
      clearCalendarId();
      this.c = -1;
      return this;
    }
    
    public CalendarUploadInfo clearCalendarId()
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
    
    public String getCalendarId()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasCalendarId()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCalendarId());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasCalendarId()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public CalendarUploadInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCalendarId(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public CalendarUploadInfo setCalendarId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCalendarId()) {
        paramCodedOutputStreamMicro.writeString(1, getCalendarId());
      }
    }
  }
  
  public static final class CardInfo
    extends MessageMicro
  {
    public static final int CARD_ICON_FIELD_NUMBER = 1;
    public static final int CARD_TITLE_FIELD_NUMBER = 3;
    public static final int CARD_TYPE_FIELD_NUMBER = 9;
    public static final int COLOR_DESC_FIELD_NUMBER = 13;
    public static final int DETAIL_TITLE_FIELD_NUMBER = 6;
    public static final int JUMP_URL_FIELD_NUMBER = 7;
    public static final int MARK_TYPE_FIELD_NUMBER = 10;
    public static final int MARK_TYPE_SUM_FIELD_NUMBER = 14;
    public static final int PRIORITY_FIELD_NUMBER = 12;
    public static final int REMARK_FIELD_NUMBER = 4;
    public static final int SMALL_CARD_ICON_FIELD_NUMBER = 2;
    public static final int TIME_INFO_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 11;
    public static final int TRIP_ID_FIELD_NUMBER = 8;
    private boolean A;
    private String B = "";
    private int C = -1;
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
    private boolean s;
    private String t = "";
    private boolean u;
    private String v = "";
    private boolean w;
    private int x = 0;
    private boolean y;
    private String z = "";
    
    public static CardInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CardInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CardInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CardInfo)new CardInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final CardInfo clear()
    {
      clearCardIcon();
      clearSmallCardIcon();
      clearCardTitle();
      clearRemark();
      clearTimeInfo();
      clearDetailTitle();
      clearJumpUrl();
      clearTripId();
      clearCardType();
      clearMarkType();
      clearTitle();
      clearPriority();
      clearColorDesc();
      clearMarkTypeSum();
      this.C = -1;
      return this;
    }
    
    public CardInfo clearCardIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public CardInfo clearCardTitle()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public CardInfo clearCardType()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public CardInfo clearColorDesc()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public CardInfo clearDetailTitle()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public CardInfo clearJumpUrl()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public CardInfo clearMarkType()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public CardInfo clearMarkTypeSum()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public CardInfo clearPriority()
    {
      this.w = false;
      this.x = 0;
      return this;
    }
    
    public CardInfo clearRemark()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public CardInfo clearSmallCardIcon()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public CardInfo clearTimeInfo()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public CardInfo clearTitle()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public CardInfo clearTripId()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.C < 0) {
        getSerializedSize();
      }
      return this.C;
    }
    
    public String getCardIcon()
    {
      return this.b;
    }
    
    public String getCardTitle()
    {
      return this.f;
    }
    
    public String getCardType()
    {
      return this.r;
    }
    
    public String getColorDesc()
    {
      return this.z;
    }
    
    public String getDetailTitle()
    {
      return this.l;
    }
    
    public String getJumpUrl()
    {
      return this.n;
    }
    
    public String getMarkType()
    {
      return this.t;
    }
    
    public String getMarkTypeSum()
    {
      return this.B;
    }
    
    public int getPriority()
    {
      return this.x;
    }
    
    public String getRemark()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasCardIcon()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getCardIcon());
      }
      int i1 = i2;
      if (hasSmallCardIcon()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getSmallCardIcon());
      }
      i2 = i1;
      if (hasCardTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getCardTitle());
      }
      i1 = i2;
      if (hasRemark()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getRemark());
      }
      i2 = i1;
      if (hasTimeInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getTimeInfo());
      }
      i1 = i2;
      if (hasDetailTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getDetailTitle());
      }
      i2 = i1;
      if (hasJumpUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getJumpUrl());
      }
      i1 = i2;
      if (hasTripId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getTripId());
      }
      i2 = i1;
      if (hasCardType()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getCardType());
      }
      i1 = i2;
      if (hasMarkType()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getMarkType());
      }
      i2 = i1;
      if (hasTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getTitle());
      }
      i1 = i2;
      if (hasPriority()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(12, getPriority());
      }
      i2 = i1;
      if (hasColorDesc()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getColorDesc());
      }
      i1 = i2;
      if (hasMarkTypeSum()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getMarkTypeSum());
      }
      this.C = i1;
      return i1;
    }
    
    public String getSmallCardIcon()
    {
      return this.d;
    }
    
    public String getTimeInfo()
    {
      return this.j;
    }
    
    public String getTitle()
    {
      return this.v;
    }
    
    public String getTripId()
    {
      return this.p;
    }
    
    public boolean hasCardIcon()
    {
      return this.a;
    }
    
    public boolean hasCardTitle()
    {
      return this.e;
    }
    
    public boolean hasCardType()
    {
      return this.q;
    }
    
    public boolean hasColorDesc()
    {
      return this.y;
    }
    
    public boolean hasDetailTitle()
    {
      return this.k;
    }
    
    public boolean hasJumpUrl()
    {
      return this.m;
    }
    
    public boolean hasMarkType()
    {
      return this.s;
    }
    
    public boolean hasMarkTypeSum()
    {
      return this.A;
    }
    
    public boolean hasPriority()
    {
      return this.w;
    }
    
    public boolean hasRemark()
    {
      return this.g;
    }
    
    public boolean hasSmallCardIcon()
    {
      return this.c;
    }
    
    public boolean hasTimeInfo()
    {
      return this.i;
    }
    
    public boolean hasTitle()
    {
      return this.u;
    }
    
    public boolean hasTripId()
    {
      return this.o;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public CardInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCardIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setSmallCardIcon(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setCardTitle(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setRemark(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setTimeInfo(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setDetailTitle(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setTripId(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setCardType(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setMarkType(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 96: 
          setPriority(paramCodedInputStreamMicro.readInt32());
          break;
        case 106: 
          setColorDesc(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setMarkTypeSum(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public CardInfo setCardIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public CardInfo setCardTitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public CardInfo setCardType(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public CardInfo setColorDesc(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public CardInfo setDetailTitle(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public CardInfo setJumpUrl(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public CardInfo setMarkType(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public CardInfo setMarkTypeSum(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public CardInfo setPriority(int paramInt)
    {
      this.w = true;
      this.x = paramInt;
      return this;
    }
    
    public CardInfo setRemark(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public CardInfo setSmallCardIcon(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public CardInfo setTimeInfo(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public CardInfo setTitle(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public CardInfo setTripId(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCardIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getCardIcon());
      }
      if (hasSmallCardIcon()) {
        paramCodedOutputStreamMicro.writeString(2, getSmallCardIcon());
      }
      if (hasCardTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getCardTitle());
      }
      if (hasRemark()) {
        paramCodedOutputStreamMicro.writeString(4, getRemark());
      }
      if (hasTimeInfo()) {
        paramCodedOutputStreamMicro.writeString(5, getTimeInfo());
      }
      if (hasDetailTitle()) {
        paramCodedOutputStreamMicro.writeString(6, getDetailTitle());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(7, getJumpUrl());
      }
      if (hasTripId()) {
        paramCodedOutputStreamMicro.writeString(8, getTripId());
      }
      if (hasCardType()) {
        paramCodedOutputStreamMicro.writeString(9, getCardType());
      }
      if (hasMarkType()) {
        paramCodedOutputStreamMicro.writeString(10, getMarkType());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(11, getTitle());
      }
      if (hasPriority()) {
        paramCodedOutputStreamMicro.writeInt32(12, getPriority());
      }
      if (hasColorDesc()) {
        paramCodedOutputStreamMicro.writeString(13, getColorDesc());
      }
      if (hasMarkTypeSum()) {
        paramCodedOutputStreamMicro.writeString(14, getMarkTypeSum());
      }
    }
  }
  
  public static final class CardResource
    extends MessageMicro
  {
    public static final int AIDE_ICON_FIELD_NUMBER = 6;
    public static final int ARRIVE_TIME_FIELD_NUMBER = 3;
    public static final int DELAY_ICON_FIELD_NUMBER = 12;
    public static final int DELAY_TITLE_FIELD_NUMBER = 13;
    public static final int END_STATION_FIELD_NUMBER = 5;
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int IS_DELAY_FIELD_NUMBER = 14;
    public static final int IS_EXPIRE_FIELD_NUMBER = 17;
    public static final int ORDER_TYPE_FIELD_NUMBER = 15;
    public static final int REMARK_FIELD_NUMBER = 16;
    public static final int ROUTE_INFO_FIELD_NUMBER = 9;
    public static final int SHOW_TYPE_FIELD_NUMBER = 10;
    public static final int START_STATION_FIELD_NUMBER = 4;
    public static final int START_TIME_FIELD_NUMBER = 2;
    public static final int TRANSPORT_FIELD_NUMBER = 8;
    public static final int TRIP_EXT_FIELD_NUMBER = 7;
    public static final int TRIP_TYPE_FIELD_NUMBER = 11;
    private boolean A;
    private int B = 0;
    private boolean C;
    private String D = "";
    private boolean E;
    private String F = "";
    private boolean G;
    private boolean H = false;
    private int I = -1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private TaResponse.Station h = null;
    private boolean i;
    private TaResponse.Station j = null;
    private boolean k;
    private String l = "";
    private boolean m;
    private TaResponse.TripExt n = null;
    private boolean o;
    private TaResponse.Transport p = null;
    private boolean q;
    private String r = "";
    private boolean s;
    private int t = 0;
    private boolean u;
    private int v = 0;
    private boolean w;
    private String x = "";
    private boolean y;
    private String z = "";
    
    public static CardResource parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CardResource().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CardResource parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CardResource)new CardResource().mergeFrom(paramArrayOfByte);
    }
    
    public final CardResource clear()
    {
      clearIcon();
      clearStartTime();
      clearArriveTime();
      clearStartStation();
      clearEndStation();
      clearAideIcon();
      clearTripExt();
      clearTransport();
      clearRouteInfo();
      clearShowType();
      clearTripType();
      clearDelayIcon();
      clearDelayTitle();
      clearIsDelay();
      clearOrderType();
      clearRemark();
      clearIsExpire();
      this.I = -1;
      return this;
    }
    
    public CardResource clearAideIcon()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public CardResource clearArriveTime()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public CardResource clearDelayIcon()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public CardResource clearDelayTitle()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public CardResource clearEndStation()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public CardResource clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public CardResource clearIsDelay()
    {
      this.A = false;
      this.B = 0;
      return this;
    }
    
    public CardResource clearIsExpire()
    {
      this.G = false;
      this.H = false;
      return this;
    }
    
    public CardResource clearOrderType()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public CardResource clearRemark()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public CardResource clearRouteInfo()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public CardResource clearShowType()
    {
      this.s = false;
      this.t = 0;
      return this;
    }
    
    public CardResource clearStartStation()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public CardResource clearStartTime()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public CardResource clearTransport()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public CardResource clearTripExt()
    {
      this.m = false;
      this.n = null;
      return this;
    }
    
    public CardResource clearTripType()
    {
      this.u = false;
      this.v = 0;
      return this;
    }
    
    public String getAideIcon()
    {
      return this.l;
    }
    
    public String getArriveTime()
    {
      return this.f;
    }
    
    public int getCachedSize()
    {
      if (this.I < 0) {
        getSerializedSize();
      }
      return this.I;
    }
    
    public String getDelayIcon()
    {
      return this.x;
    }
    
    public String getDelayTitle()
    {
      return this.z;
    }
    
    public TaResponse.Station getEndStation()
    {
      return this.j;
    }
    
    public String getIcon()
    {
      return this.b;
    }
    
    public int getIsDelay()
    {
      return this.B;
    }
    
    public boolean getIsExpire()
    {
      return this.H;
    }
    
    public String getOrderType()
    {
      return this.D;
    }
    
    public String getRemark()
    {
      return this.F;
    }
    
    public String getRouteInfo()
    {
      return this.r;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasIcon()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
      }
      int i1 = i2;
      if (hasStartTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getStartTime());
      }
      i2 = i1;
      if (hasArriveTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getArriveTime());
      }
      i1 = i2;
      if (hasStartStation()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getStartStation());
      }
      i2 = i1;
      if (hasEndStation()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getEndStation());
      }
      i1 = i2;
      if (hasAideIcon()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getAideIcon());
      }
      i2 = i1;
      if (hasTripExt()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getTripExt());
      }
      i1 = i2;
      if (hasTransport()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(8, getTransport());
      }
      i2 = i1;
      if (hasRouteInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getRouteInfo());
      }
      i1 = i2;
      if (hasShowType()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(10, getShowType());
      }
      i2 = i1;
      if (hasTripType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getTripType());
      }
      i1 = i2;
      if (hasDelayIcon()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getDelayIcon());
      }
      i2 = i1;
      if (hasDelayTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getDelayTitle());
      }
      i1 = i2;
      if (hasIsDelay()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(14, getIsDelay());
      }
      i2 = i1;
      if (hasOrderType()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getOrderType());
      }
      i1 = i2;
      if (hasRemark()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getRemark());
      }
      i2 = i1;
      if (hasIsExpire()) {
        i2 = i1 + CodedOutputStreamMicro.computeBoolSize(17, getIsExpire());
      }
      this.I = i2;
      return i2;
    }
    
    public int getShowType()
    {
      return this.t;
    }
    
    public TaResponse.Station getStartStation()
    {
      return this.h;
    }
    
    public String getStartTime()
    {
      return this.d;
    }
    
    public TaResponse.Transport getTransport()
    {
      return this.p;
    }
    
    public TaResponse.TripExt getTripExt()
    {
      return this.n;
    }
    
    public int getTripType()
    {
      return this.v;
    }
    
    public boolean hasAideIcon()
    {
      return this.k;
    }
    
    public boolean hasArriveTime()
    {
      return this.e;
    }
    
    public boolean hasDelayIcon()
    {
      return this.w;
    }
    
    public boolean hasDelayTitle()
    {
      return this.y;
    }
    
    public boolean hasEndStation()
    {
      return this.i;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasIsDelay()
    {
      return this.A;
    }
    
    public boolean hasIsExpire()
    {
      return this.G;
    }
    
    public boolean hasOrderType()
    {
      return this.C;
    }
    
    public boolean hasRemark()
    {
      return this.E;
    }
    
    public boolean hasRouteInfo()
    {
      return this.q;
    }
    
    public boolean hasShowType()
    {
      return this.s;
    }
    
    public boolean hasStartStation()
    {
      return this.g;
    }
    
    public boolean hasStartTime()
    {
      return this.c;
    }
    
    public boolean hasTransport()
    {
      return this.o;
    }
    
    public boolean hasTripExt()
    {
      return this.m;
    }
    
    public boolean hasTripType()
    {
      return this.u;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public CardResource mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setStartTime(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setArriveTime(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          localObject = new TaResponse.Station();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setStartStation((TaResponse.Station)localObject);
          break;
        case 42: 
          localObject = new TaResponse.Station();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setEndStation((TaResponse.Station)localObject);
          break;
        case 50: 
          setAideIcon(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          localObject = new TaResponse.TripExt();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTripExt((TaResponse.TripExt)localObject);
          break;
        case 66: 
          localObject = new TaResponse.Transport();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTransport((TaResponse.Transport)localObject);
          break;
        case 74: 
          setRouteInfo(paramCodedInputStreamMicro.readString());
          break;
        case 80: 
          setShowType(paramCodedInputStreamMicro.readInt32());
          break;
        case 88: 
          setTripType(paramCodedInputStreamMicro.readInt32());
          break;
        case 98: 
          setDelayIcon(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setDelayTitle(paramCodedInputStreamMicro.readString());
          break;
        case 112: 
          setIsDelay(paramCodedInputStreamMicro.readInt32());
          break;
        case 122: 
          setOrderType(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setRemark(paramCodedInputStreamMicro.readString());
          break;
        case 136: 
          setIsExpire(paramCodedInputStreamMicro.readBool());
        }
      }
    }
    
    public CardResource setAideIcon(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public CardResource setArriveTime(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public CardResource setDelayIcon(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public CardResource setDelayTitle(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public CardResource setEndStation(TaResponse.Station paramStation)
    {
      if (paramStation == null) {
        return clearEndStation();
      }
      this.i = true;
      this.j = paramStation;
      return this;
    }
    
    public CardResource setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public CardResource setIsDelay(int paramInt)
    {
      this.A = true;
      this.B = paramInt;
      return this;
    }
    
    public CardResource setIsExpire(boolean paramBoolean)
    {
      this.G = true;
      this.H = paramBoolean;
      return this;
    }
    
    public CardResource setOrderType(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public CardResource setRemark(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public CardResource setRouteInfo(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public CardResource setShowType(int paramInt)
    {
      this.s = true;
      this.t = paramInt;
      return this;
    }
    
    public CardResource setStartStation(TaResponse.Station paramStation)
    {
      if (paramStation == null) {
        return clearStartStation();
      }
      this.g = true;
      this.h = paramStation;
      return this;
    }
    
    public CardResource setStartTime(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public CardResource setTransport(TaResponse.Transport paramTransport)
    {
      if (paramTransport == null) {
        return clearTransport();
      }
      this.o = true;
      this.p = paramTransport;
      return this;
    }
    
    public CardResource setTripExt(TaResponse.TripExt paramTripExt)
    {
      if (paramTripExt == null) {
        return clearTripExt();
      }
      this.m = true;
      this.n = paramTripExt;
      return this;
    }
    
    public CardResource setTripType(int paramInt)
    {
      this.u = true;
      this.v = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeString(2, getStartTime());
      }
      if (hasArriveTime()) {
        paramCodedOutputStreamMicro.writeString(3, getArriveTime());
      }
      if (hasStartStation()) {
        paramCodedOutputStreamMicro.writeMessage(4, getStartStation());
      }
      if (hasEndStation()) {
        paramCodedOutputStreamMicro.writeMessage(5, getEndStation());
      }
      if (hasAideIcon()) {
        paramCodedOutputStreamMicro.writeString(6, getAideIcon());
      }
      if (hasTripExt()) {
        paramCodedOutputStreamMicro.writeMessage(7, getTripExt());
      }
      if (hasTransport()) {
        paramCodedOutputStreamMicro.writeMessage(8, getTransport());
      }
      if (hasRouteInfo()) {
        paramCodedOutputStreamMicro.writeString(9, getRouteInfo());
      }
      if (hasShowType()) {
        paramCodedOutputStreamMicro.writeInt32(10, getShowType());
      }
      if (hasTripType()) {
        paramCodedOutputStreamMicro.writeInt32(11, getTripType());
      }
      if (hasDelayIcon()) {
        paramCodedOutputStreamMicro.writeString(12, getDelayIcon());
      }
      if (hasDelayTitle()) {
        paramCodedOutputStreamMicro.writeString(13, getDelayTitle());
      }
      if (hasIsDelay()) {
        paramCodedOutputStreamMicro.writeInt32(14, getIsDelay());
      }
      if (hasOrderType()) {
        paramCodedOutputStreamMicro.writeString(15, getOrderType());
      }
      if (hasRemark()) {
        paramCodedOutputStreamMicro.writeString(16, getRemark());
      }
      if (hasIsExpire()) {
        paramCodedOutputStreamMicro.writeBool(17, getIsExpire());
      }
    }
  }
  
  public static final class CityInfo
    extends MessageMicro
  {
    public static final int CITY_FIELD_NUMBER = 1;
    public static final int PINYIN_FIELD_NUMBER = 3;
    public static final int STA_NAME_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private int g = -1;
    
    public static CityInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CityInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CityInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CityInfo)new CityInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final CityInfo clear()
    {
      clearCity();
      clearStaName();
      clearPinyin();
      this.g = -1;
      return this;
    }
    
    public CityInfo clearCity()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public CityInfo clearPinyin()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public CityInfo clearStaName()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public String getCity()
    {
      return this.b;
    }
    
    public String getPinyin()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasCity()) {
        j = 0 + CodedOutputStreamMicro.computeStringSize(1, getCity());
      }
      int i = j;
      if (hasStaName()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getStaName());
      }
      j = i;
      if (hasPinyin()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getPinyin());
      }
      this.g = j;
      return j;
    }
    
    public String getStaName()
    {
      return this.d;
    }
    
    public boolean hasCity()
    {
      return this.a;
    }
    
    public boolean hasPinyin()
    {
      return this.e;
    }
    
    public boolean hasStaName()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public CityInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCity(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setStaName(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setPinyin(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public CityInfo setCity(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public CityInfo setPinyin(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public CityInfo setStaName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCity()) {
        paramCodedOutputStreamMicro.writeString(1, getCity());
      }
      if (hasStaName()) {
        paramCodedOutputStreamMicro.writeString(2, getStaName());
      }
      if (hasPinyin()) {
        paramCodedOutputStreamMicro.writeString(3, getPinyin());
      }
    }
  }
  
  public static final class CloudConf
    extends MessageMicro
  {
    public static final int CALENDAR_UPLOAD_FIELD_NUMBER = 1;
    public static final int HAS_CUR_TRIP_FIELD_NUMBER = 8;
    public static final int PAGE_SIZE_FIELD_NUMBER = 7;
    public static final int SMS_MAX_NUM_FIELD_NUMBER = 2;
    public static final int TOTAL_CNT_FIELD_NUMBER = 5;
    public static final int TOTAL_PAGE_FIELD_NUMBER = 6;
    public static final int UPLOAD_FIELD_NUMBER = 3;
    public static final int VERSION_FIELD_NUMBER = 4;
    private boolean a;
    private boolean b = false;
    private boolean c;
    private int d = 0;
    private boolean e;
    private boolean f = false;
    private boolean g;
    private long h = 0L;
    private boolean i;
    private int j = 0;
    private boolean k;
    private int l = 0;
    private boolean m;
    private int n = 0;
    private boolean o;
    private int p = 0;
    private int q = -1;
    
    public static CloudConf parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CloudConf().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CloudConf parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CloudConf)new CloudConf().mergeFrom(paramArrayOfByte);
    }
    
    public final CloudConf clear()
    {
      clearCalendarUpload();
      clearSmsMaxNum();
      clearUpload();
      clearVersion();
      clearTotalCnt();
      clearTotalPage();
      clearPageSize();
      clearHasCurTrip();
      this.q = -1;
      return this;
    }
    
    public CloudConf clearCalendarUpload()
    {
      this.a = false;
      this.b = false;
      return this;
    }
    
    public CloudConf clearHasCurTrip()
    {
      this.o = false;
      this.p = 0;
      return this;
    }
    
    public CloudConf clearPageSize()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public CloudConf clearSmsMaxNum()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public CloudConf clearTotalCnt()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public CloudConf clearTotalPage()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public CloudConf clearUpload()
    {
      this.e = false;
      this.f = false;
      return this;
    }
    
    public CloudConf clearVersion()
    {
      this.g = false;
      this.h = 0L;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.q < 0) {
        getSerializedSize();
      }
      return this.q;
    }
    
    public boolean getCalendarUpload()
    {
      return this.b;
    }
    
    public int getHasCurTrip()
    {
      return this.p;
    }
    
    public int getPageSize()
    {
      return this.n;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasCalendarUpload()) {
        i2 = 0 + CodedOutputStreamMicro.computeBoolSize(1, getCalendarUpload());
      }
      int i1 = i2;
      if (hasSmsMaxNum()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(2, getSmsMaxNum());
      }
      i2 = i1;
      if (hasUpload()) {
        i2 = i1 + CodedOutputStreamMicro.computeBoolSize(3, getUpload());
      }
      i1 = i2;
      if (hasVersion()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(4, getVersion());
      }
      i2 = i1;
      if (hasTotalCnt()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getTotalCnt());
      }
      i1 = i2;
      if (hasTotalPage()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getTotalPage());
      }
      i2 = i1;
      if (hasPageSize()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getPageSize());
      }
      i1 = i2;
      if (hasHasCurTrip()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getHasCurTrip());
      }
      this.q = i1;
      return i1;
    }
    
    public int getSmsMaxNum()
    {
      return this.d;
    }
    
    public int getTotalCnt()
    {
      return this.j;
    }
    
    public int getTotalPage()
    {
      return this.l;
    }
    
    public boolean getUpload()
    {
      return this.f;
    }
    
    public long getVersion()
    {
      return this.h;
    }
    
    public boolean hasCalendarUpload()
    {
      return this.a;
    }
    
    public boolean hasHasCurTrip()
    {
      return this.o;
    }
    
    public boolean hasPageSize()
    {
      return this.m;
    }
    
    public boolean hasSmsMaxNum()
    {
      return this.c;
    }
    
    public boolean hasTotalCnt()
    {
      return this.i;
    }
    
    public boolean hasTotalPage()
    {
      return this.k;
    }
    
    public boolean hasUpload()
    {
      return this.e;
    }
    
    public boolean hasVersion()
    {
      return this.g;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public CloudConf mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCalendarUpload(paramCodedInputStreamMicro.readBool());
          break;
        case 16: 
          setSmsMaxNum(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setUpload(paramCodedInputStreamMicro.readBool());
          break;
        case 32: 
          setVersion(paramCodedInputStreamMicro.readInt64());
          break;
        case 40: 
          setTotalCnt(paramCodedInputStreamMicro.readInt32());
          break;
        case 48: 
          setTotalPage(paramCodedInputStreamMicro.readInt32());
          break;
        case 56: 
          setPageSize(paramCodedInputStreamMicro.readInt32());
          break;
        case 64: 
          setHasCurTrip(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public CloudConf setCalendarUpload(boolean paramBoolean)
    {
      this.a = true;
      this.b = paramBoolean;
      return this;
    }
    
    public CloudConf setHasCurTrip(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public CloudConf setPageSize(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public CloudConf setSmsMaxNum(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public CloudConf setTotalCnt(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public CloudConf setTotalPage(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public CloudConf setUpload(boolean paramBoolean)
    {
      this.e = true;
      this.f = paramBoolean;
      return this;
    }
    
    public CloudConf setVersion(long paramLong)
    {
      this.g = true;
      this.h = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCalendarUpload()) {
        paramCodedOutputStreamMicro.writeBool(1, getCalendarUpload());
      }
      if (hasSmsMaxNum()) {
        paramCodedOutputStreamMicro.writeInt32(2, getSmsMaxNum());
      }
      if (hasUpload()) {
        paramCodedOutputStreamMicro.writeBool(3, getUpload());
      }
      if (hasVersion()) {
        paramCodedOutputStreamMicro.writeInt64(4, getVersion());
      }
      if (hasTotalCnt()) {
        paramCodedOutputStreamMicro.writeInt32(5, getTotalCnt());
      }
      if (hasTotalPage()) {
        paramCodedOutputStreamMicro.writeInt32(6, getTotalPage());
      }
      if (hasPageSize()) {
        paramCodedOutputStreamMicro.writeInt32(7, getPageSize());
      }
      if (hasHasCurTrip()) {
        paramCodedOutputStreamMicro.writeInt32(8, getHasCurTrip());
      }
    }
  }
  
  public static final class ControlData
    extends MessageMicro
  {
    public static final int CLOUD_CONF_FIELD_NUMBER = 4;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 2;
    public static final int DYNAMIC_MAP_DATA_FIELD_NUMBER = 3;
    public static final int SCENE_ENTRY_FIELD_NUMBER = 1;
    public static final int SMS_CONF_FIELD_NUMBER = 5;
    private boolean a;
    private TaResponse.SceneEntry b = null;
    private boolean c;
    private TaResponse.VersionInfo d = null;
    private boolean e;
    private ByteStringMicro f = ByteStringMicro.EMPTY;
    private boolean g;
    private TaResponse.CloudConf h = null;
    private boolean i;
    private TaResponse.CloudConf j = null;
    private int k = -1;
    
    public static ControlData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ControlData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ControlData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ControlData)new ControlData().mergeFrom(paramArrayOfByte);
    }
    
    public final ControlData clear()
    {
      clearSceneEntry();
      clearConfigVersion();
      clearDynamicMapData();
      clearCloudConf();
      clearSmsConf();
      this.k = -1;
      return this;
    }
    
    public ControlData clearCloudConf()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public ControlData clearConfigVersion()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public ControlData clearDynamicMapData()
    {
      this.e = false;
      this.f = ByteStringMicro.EMPTY;
      return this;
    }
    
    public ControlData clearSceneEntry()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public ControlData clearSmsConf()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public TaResponse.CloudConf getCloudConf()
    {
      return this.h;
    }
    
    public TaResponse.VersionInfo getConfigVersion()
    {
      return this.d;
    }
    
    public ByteStringMicro getDynamicMapData()
    {
      return this.f;
    }
    
    public TaResponse.SceneEntry getSceneEntry()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasSceneEntry()) {
        n = 0 + CodedOutputStreamMicro.computeMessageSize(1, getSceneEntry());
      }
      int m = n;
      if (hasConfigVersion()) {
        m = n + CodedOutputStreamMicro.computeMessageSize(2, getConfigVersion());
      }
      n = m;
      if (hasDynamicMapData()) {
        n = m + CodedOutputStreamMicro.computeBytesSize(3, getDynamicMapData());
      }
      m = n;
      if (hasCloudConf()) {
        m = n + CodedOutputStreamMicro.computeMessageSize(4, getCloudConf());
      }
      n = m;
      if (hasSmsConf()) {
        n = m + CodedOutputStreamMicro.computeMessageSize(5, getSmsConf());
      }
      this.k = n;
      return n;
    }
    
    public TaResponse.CloudConf getSmsConf()
    {
      return this.j;
    }
    
    public boolean hasCloudConf()
    {
      return this.g;
    }
    
    public boolean hasConfigVersion()
    {
      return this.c;
    }
    
    public boolean hasDynamicMapData()
    {
      return this.e;
    }
    
    public boolean hasSceneEntry()
    {
      return this.a;
    }
    
    public boolean hasSmsConf()
    {
      return this.i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ControlData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int m = paramCodedInputStreamMicro.readTag();
        Object localObject;
        switch (m)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, m)) {}
          break;
        case 0: 
          return this;
        case 10: 
          localObject = new TaResponse.SceneEntry();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setSceneEntry((TaResponse.SceneEntry)localObject);
          break;
        case 18: 
          localObject = new TaResponse.VersionInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setConfigVersion((TaResponse.VersionInfo)localObject);
          break;
        case 26: 
          setDynamicMapData(paramCodedInputStreamMicro.readBytes());
          break;
        case 34: 
          localObject = new TaResponse.CloudConf();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCloudConf((TaResponse.CloudConf)localObject);
          break;
        case 42: 
          localObject = new TaResponse.CloudConf();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setSmsConf((TaResponse.CloudConf)localObject);
        }
      }
    }
    
    public ControlData setCloudConf(TaResponse.CloudConf paramCloudConf)
    {
      if (paramCloudConf == null) {
        return clearCloudConf();
      }
      this.g = true;
      this.h = paramCloudConf;
      return this;
    }
    
    public ControlData setConfigVersion(TaResponse.VersionInfo paramVersionInfo)
    {
      if (paramVersionInfo == null) {
        return clearConfigVersion();
      }
      this.c = true;
      this.d = paramVersionInfo;
      return this;
    }
    
    public ControlData setDynamicMapData(ByteStringMicro paramByteStringMicro)
    {
      this.e = true;
      this.f = paramByteStringMicro;
      return this;
    }
    
    public ControlData setSceneEntry(TaResponse.SceneEntry paramSceneEntry)
    {
      if (paramSceneEntry == null) {
        return clearSceneEntry();
      }
      this.a = true;
      this.b = paramSceneEntry;
      return this;
    }
    
    public ControlData setSmsConf(TaResponse.CloudConf paramCloudConf)
    {
      if (paramCloudConf == null) {
        return clearSmsConf();
      }
      this.i = true;
      this.j = paramCloudConf;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasSceneEntry()) {
        paramCodedOutputStreamMicro.writeMessage(1, getSceneEntry());
      }
      if (hasConfigVersion()) {
        paramCodedOutputStreamMicro.writeMessage(2, getConfigVersion());
      }
      if (hasDynamicMapData()) {
        paramCodedOutputStreamMicro.writeBytes(3, getDynamicMapData());
      }
      if (hasCloudConf()) {
        paramCodedOutputStreamMicro.writeMessage(4, getCloudConf());
      }
      if (hasSmsConf()) {
        paramCodedOutputStreamMicro.writeMessage(5, getSmsConf());
      }
    }
  }
  
  public static final class ControlInfo
    extends MessageMicro
  {
    public static final int DEADLINE_TIME_FIELD_NUMBER = 2;
    public static final int NEXT_REQUEST_TIME_FIELD_NUMBER = 1;
    private boolean a;
    private long b = 0L;
    private boolean c;
    private long d = 0L;
    private int e = -1;
    
    public static ControlInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ControlInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ControlInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ControlInfo)new ControlInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final ControlInfo clear()
    {
      clearNextRequestTime();
      clearDeadlineTime();
      this.e = -1;
      return this;
    }
    
    public ControlInfo clearDeadlineTime()
    {
      this.c = false;
      this.d = 0L;
      return this;
    }
    
    public ControlInfo clearNextRequestTime()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public long getDeadlineTime()
    {
      return this.d;
    }
    
    public long getNextRequestTime()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasNextRequestTime()) {
        i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getNextRequestTime());
      }
      int j = i;
      if (hasDeadlineTime()) {
        j = i + CodedOutputStreamMicro.computeInt64Size(2, getDeadlineTime());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasDeadlineTime()
    {
      return this.c;
    }
    
    public boolean hasNextRequestTime()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ControlInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setNextRequestTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 16: 
          setDeadlineTime(paramCodedInputStreamMicro.readInt64());
        }
      }
    }
    
    public ControlInfo setDeadlineTime(long paramLong)
    {
      this.c = true;
      this.d = paramLong;
      return this;
    }
    
    public ControlInfo setNextRequestTime(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasNextRequestTime()) {
        paramCodedOutputStreamMicro.writeInt64(1, getNextRequestTime());
      }
      if (hasDeadlineTime()) {
        paramCodedOutputStreamMicro.writeInt64(2, getDeadlineTime());
      }
    }
  }
  
  public static final class DriverPageCardInfo
    extends MessageMicro
  {
    public static final int CONTROL_INFO_FIELD_NUMBER = 1;
    public static final int DRIVER_PAGE_FIELD_NUMBER = 2;
    public static final int NOTIFY_CONTENT_FIELD_NUMBER = 3;
    private boolean a;
    private TaResponse.ControlInfo b = null;
    private List<TaResponse.DriverPageInfo> c = Collections.emptyList();
    private List<TaResponse.NotifyContent> d = Collections.emptyList();
    private int e = -1;
    
    public static DriverPageCardInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new DriverPageCardInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static DriverPageCardInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (DriverPageCardInfo)new DriverPageCardInfo().mergeFrom(paramArrayOfByte);
    }
    
    public DriverPageCardInfo addDriverPage(TaResponse.DriverPageInfo paramDriverPageInfo)
    {
      if (paramDriverPageInfo == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramDriverPageInfo);
      return this;
    }
    
    public DriverPageCardInfo addNotifyContent(TaResponse.NotifyContent paramNotifyContent)
    {
      if (paramNotifyContent == null) {
        return this;
      }
      if (this.d.isEmpty()) {
        this.d = new ArrayList();
      }
      this.d.add(paramNotifyContent);
      return this;
    }
    
    public final DriverPageCardInfo clear()
    {
      clearControlInfo();
      clearDriverPage();
      clearNotifyContent();
      this.e = -1;
      return this;
    }
    
    public DriverPageCardInfo clearControlInfo()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public DriverPageCardInfo clearDriverPage()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public DriverPageCardInfo clearNotifyContent()
    {
      this.d = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public TaResponse.ControlInfo getControlInfo()
    {
      return this.b;
    }
    
    public TaResponse.DriverPageInfo getDriverPage(int paramInt)
    {
      return (TaResponse.DriverPageInfo)this.c.get(paramInt);
    }
    
    public int getDriverPageCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.DriverPageInfo> getDriverPageList()
    {
      return this.c;
    }
    
    public TaResponse.NotifyContent getNotifyContent(int paramInt)
    {
      return (TaResponse.NotifyContent)this.d.get(paramInt);
    }
    
    public int getNotifyContentCount()
    {
      return this.d.size();
    }
    
    public List<TaResponse.NotifyContent> getNotifyContentList()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasControlInfo()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getControlInfo());
      }
      Iterator localIterator = getDriverPageList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.DriverPageInfo)localIterator.next()) + i;
      }
      localIterator = getNotifyContentList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStreamMicro.computeMessageSize(3, (TaResponse.NotifyContent)localIterator.next());
      }
      this.e = i;
      return i;
    }
    
    public boolean hasControlInfo()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public DriverPageCardInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new TaResponse.ControlInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setControlInfo((TaResponse.ControlInfo)localObject);
          break;
        case 18: 
          localObject = new TaResponse.DriverPageInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addDriverPage((TaResponse.DriverPageInfo)localObject);
          break;
        case 26: 
          localObject = new TaResponse.NotifyContent();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addNotifyContent((TaResponse.NotifyContent)localObject);
        }
      }
    }
    
    public DriverPageCardInfo setControlInfo(TaResponse.ControlInfo paramControlInfo)
    {
      if (paramControlInfo == null) {
        return clearControlInfo();
      }
      this.a = true;
      this.b = paramControlInfo;
      return this;
    }
    
    public DriverPageCardInfo setDriverPage(int paramInt, TaResponse.DriverPageInfo paramDriverPageInfo)
    {
      if (paramDriverPageInfo == null) {
        return this;
      }
      this.c.set(paramInt, paramDriverPageInfo);
      return this;
    }
    
    public DriverPageCardInfo setNotifyContent(int paramInt, TaResponse.NotifyContent paramNotifyContent)
    {
      if (paramNotifyContent == null) {
        return this;
      }
      this.d.set(paramInt, paramNotifyContent);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasControlInfo()) {
        paramCodedOutputStreamMicro.writeMessage(1, getControlInfo());
      }
      Iterator localIterator = getDriverPageList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.DriverPageInfo)localIterator.next());
      }
      localIterator = getNotifyContentList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (TaResponse.NotifyContent)localIterator.next());
      }
    }
  }
  
  public static final class DriverPageContent
    extends MessageMicro
  {
    public static final int NOTIFY_CONTENT_FIELD_NUMBER = 1;
    private List<TaResponse.NotifyContent> a = Collections.emptyList();
    private int b = -1;
    
    public static DriverPageContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new DriverPageContent().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static DriverPageContent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (DriverPageContent)new DriverPageContent().mergeFrom(paramArrayOfByte);
    }
    
    public DriverPageContent addNotifyContent(TaResponse.NotifyContent paramNotifyContent)
    {
      if (paramNotifyContent == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramNotifyContent);
      return this;
    }
    
    public final DriverPageContent clear()
    {
      clearNotifyContent();
      this.b = -1;
      return this;
    }
    
    public DriverPageContent clearNotifyContent()
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
    
    public TaResponse.NotifyContent getNotifyContent(int paramInt)
    {
      return (TaResponse.NotifyContent)this.a.get(paramInt);
    }
    
    public int getNotifyContentCount()
    {
      return this.a.size();
    }
    
    public List<TaResponse.NotifyContent> getNotifyContentList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getNotifyContentList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (TaResponse.NotifyContent)localIterator.next()) + i) {}
      this.b = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public DriverPageContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.NotifyContent localNotifyContent = new TaResponse.NotifyContent();
          paramCodedInputStreamMicro.readMessage(localNotifyContent);
          addNotifyContent(localNotifyContent);
        }
      }
    }
    
    public DriverPageContent setNotifyContent(int paramInt, TaResponse.NotifyContent paramNotifyContent)
    {
      if (paramNotifyContent == null) {
        return this;
      }
      this.a.set(paramInt, paramNotifyContent);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getNotifyContentList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (TaResponse.NotifyContent)localIterator.next());
      }
    }
  }
  
  public static final class DriverPageInfo
    extends MessageMicro
  {
    public static final int BUTTON_TITLE_FIELD_NUMBER = 3;
    public static final int CARD_ICON_URL_FIELD_NUMBER = 9;
    public static final int CARD_TYPE_FIELD_NUMBER = 11;
    public static final int DETAIL_URL_FIELD_NUMBER = 6;
    public static final int END_LOC_FIELD_NUMBER = 13;
    public static final int ICON_URL_FIELD_NUMBER = 5;
    public static final int IS_ROUTE_FIELD_NUMBER = 15;
    public static final int JUMP_URL_FIELD_NUMBER = 4;
    public static final int LABEL_FIELD_NUMBER = 17;
    public static final int NOTIFY_CONTENT_FIELD_NUMBER = 16;
    public static final int POI_UID_FIELD_NUMBER = 8;
    public static final int START_LOC_FIELD_NUMBER = 12;
    public static final int STATUS_TITLE_FIELD_NUMBER = 14;
    public static final int SUB_TITLE_FIELD_NUMBER = 2;
    public static final int SUG_FLAG_FIELD_NUMBER = 10;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 7;
    private boolean A;
    private String B = "";
    private boolean C;
    private boolean D = false;
    private List<TaResponse.NotifyContent> E = Collections.emptyList();
    private boolean F;
    private String G = "";
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
    private String x = "";
    private boolean y;
    private String z = "";
    
    public static DriverPageInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new DriverPageInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static DriverPageInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (DriverPageInfo)new DriverPageInfo().mergeFrom(paramArrayOfByte);
    }
    
    public DriverPageInfo addNotifyContent(TaResponse.NotifyContent paramNotifyContent)
    {
      if (paramNotifyContent == null) {
        return this;
      }
      if (this.E.isEmpty()) {
        this.E = new ArrayList();
      }
      this.E.add(paramNotifyContent);
      return this;
    }
    
    public final DriverPageInfo clear()
    {
      clearTitle();
      clearSubTitle();
      clearButtonTitle();
      clearJumpUrl();
      clearIconUrl();
      clearDetailUrl();
      clearType();
      clearPoiUid();
      clearCardIconUrl();
      clearSugFlag();
      clearCardType();
      clearStartLoc();
      clearEndLoc();
      clearStatusTitle();
      clearIsRoute();
      clearNotifyContent();
      clearLabel();
      this.H = -1;
      return this;
    }
    
    public DriverPageInfo clearButtonTitle()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public DriverPageInfo clearCardIconUrl()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public DriverPageInfo clearCardType()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public DriverPageInfo clearDetailUrl()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public DriverPageInfo clearEndLoc()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public DriverPageInfo clearIconUrl()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public DriverPageInfo clearIsRoute()
    {
      this.C = false;
      this.D = false;
      return this;
    }
    
    public DriverPageInfo clearJumpUrl()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public DriverPageInfo clearLabel()
    {
      this.F = false;
      this.G = "";
      return this;
    }
    
    public DriverPageInfo clearNotifyContent()
    {
      this.E = Collections.emptyList();
      return this;
    }
    
    public DriverPageInfo clearPoiUid()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public DriverPageInfo clearStartLoc()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public DriverPageInfo clearStatusTitle()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public DriverPageInfo clearSubTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public DriverPageInfo clearSugFlag()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public DriverPageInfo clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public DriverPageInfo clearType()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public String getButtonTitle()
    {
      return this.f;
    }
    
    public int getCachedSize()
    {
      if (this.H < 0) {
        getSerializedSize();
      }
      return this.H;
    }
    
    public String getCardIconUrl()
    {
      return this.r;
    }
    
    public String getCardType()
    {
      return this.v;
    }
    
    public String getDetailUrl()
    {
      return this.l;
    }
    
    public String getEndLoc()
    {
      return this.z;
    }
    
    public String getIconUrl()
    {
      return this.j;
    }
    
    public boolean getIsRoute()
    {
      return this.D;
    }
    
    public String getJumpUrl()
    {
      return this.h;
    }
    
    public String getLabel()
    {
      return this.G;
    }
    
    public TaResponse.NotifyContent getNotifyContent(int paramInt)
    {
      return (TaResponse.NotifyContent)this.E.get(paramInt);
    }
    
    public int getNotifyContentCount()
    {
      return this.E.size();
    }
    
    public List<TaResponse.NotifyContent> getNotifyContentList()
    {
      return this.E;
    }
    
    public String getPoiUid()
    {
      return this.p;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasTitle()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      int i1 = i2;
      if (hasSubTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
      }
      i2 = i1;
      if (hasButtonTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getButtonTitle());
      }
      i1 = i2;
      if (hasJumpUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getJumpUrl());
      }
      i2 = i1;
      if (hasIconUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getIconUrl());
      }
      i1 = i2;
      if (hasDetailUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getDetailUrl());
      }
      i2 = i1;
      if (hasType()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getType());
      }
      i1 = i2;
      if (hasPoiUid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getPoiUid());
      }
      i2 = i1;
      if (hasCardIconUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getCardIconUrl());
      }
      i1 = i2;
      if (hasSugFlag()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getSugFlag());
      }
      i2 = i1;
      if (hasCardType()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getCardType());
      }
      i1 = i2;
      if (hasStartLoc()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getStartLoc());
      }
      i2 = i1;
      if (hasEndLoc()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getEndLoc());
      }
      i1 = i2;
      if (hasStatusTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getStatusTitle());
      }
      i2 = i1;
      if (hasIsRoute()) {
        i2 = i1 + CodedOutputStreamMicro.computeBoolSize(15, getIsRoute());
      }
      Iterator localIterator = getNotifyContentList().iterator();
      for (i1 = i2; localIterator.hasNext(); i1 = CodedOutputStreamMicro.computeMessageSize(16, (TaResponse.NotifyContent)localIterator.next()) + i1) {}
      i2 = i1;
      if (hasLabel()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getLabel());
      }
      this.H = i2;
      return i2;
    }
    
    public String getStartLoc()
    {
      return this.x;
    }
    
    public String getStatusTitle()
    {
      return this.B;
    }
    
    public String getSubTitle()
    {
      return this.d;
    }
    
    public String getSugFlag()
    {
      return this.t;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public String getType()
    {
      return this.n;
    }
    
    public boolean hasButtonTitle()
    {
      return this.e;
    }
    
    public boolean hasCardIconUrl()
    {
      return this.q;
    }
    
    public boolean hasCardType()
    {
      return this.u;
    }
    
    public boolean hasDetailUrl()
    {
      return this.k;
    }
    
    public boolean hasEndLoc()
    {
      return this.y;
    }
    
    public boolean hasIconUrl()
    {
      return this.i;
    }
    
    public boolean hasIsRoute()
    {
      return this.C;
    }
    
    public boolean hasJumpUrl()
    {
      return this.g;
    }
    
    public boolean hasLabel()
    {
      return this.F;
    }
    
    public boolean hasPoiUid()
    {
      return this.o;
    }
    
    public boolean hasStartLoc()
    {
      return this.w;
    }
    
    public boolean hasStatusTitle()
    {
      return this.A;
    }
    
    public boolean hasSubTitle()
    {
      return this.c;
    }
    
    public boolean hasSugFlag()
    {
      return this.s;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public boolean hasType()
    {
      return this.m;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public DriverPageInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setSubTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setButtonTitle(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setDetailUrl(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setType(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setPoiUid(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setCardIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setSugFlag(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setCardType(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setStartLoc(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setEndLoc(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setStatusTitle(paramCodedInputStreamMicro.readString());
          break;
        case 120: 
          setIsRoute(paramCodedInputStreamMicro.readBool());
          break;
        case 130: 
          TaResponse.NotifyContent localNotifyContent = new TaResponse.NotifyContent();
          paramCodedInputStreamMicro.readMessage(localNotifyContent);
          addNotifyContent(localNotifyContent);
          break;
        case 138: 
          setLabel(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public DriverPageInfo setButtonTitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public DriverPageInfo setCardIconUrl(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public DriverPageInfo setCardType(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public DriverPageInfo setDetailUrl(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public DriverPageInfo setEndLoc(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public DriverPageInfo setIconUrl(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public DriverPageInfo setIsRoute(boolean paramBoolean)
    {
      this.C = true;
      this.D = paramBoolean;
      return this;
    }
    
    public DriverPageInfo setJumpUrl(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public DriverPageInfo setLabel(String paramString)
    {
      this.F = true;
      this.G = paramString;
      return this;
    }
    
    public DriverPageInfo setNotifyContent(int paramInt, TaResponse.NotifyContent paramNotifyContent)
    {
      if (paramNotifyContent == null) {
        return this;
      }
      this.E.set(paramInt, paramNotifyContent);
      return this;
    }
    
    public DriverPageInfo setPoiUid(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public DriverPageInfo setStartLoc(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public DriverPageInfo setStatusTitle(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public DriverPageInfo setSubTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public DriverPageInfo setSugFlag(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public DriverPageInfo setTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public DriverPageInfo setType(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(1, getTitle());
      }
      if (hasSubTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getSubTitle());
      }
      if (hasButtonTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getButtonTitle());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(4, getJumpUrl());
      }
      if (hasIconUrl()) {
        paramCodedOutputStreamMicro.writeString(5, getIconUrl());
      }
      if (hasDetailUrl()) {
        paramCodedOutputStreamMicro.writeString(6, getDetailUrl());
      }
      if (hasType()) {
        paramCodedOutputStreamMicro.writeString(7, getType());
      }
      if (hasPoiUid()) {
        paramCodedOutputStreamMicro.writeString(8, getPoiUid());
      }
      if (hasCardIconUrl()) {
        paramCodedOutputStreamMicro.writeString(9, getCardIconUrl());
      }
      if (hasSugFlag()) {
        paramCodedOutputStreamMicro.writeString(10, getSugFlag());
      }
      if (hasCardType()) {
        paramCodedOutputStreamMicro.writeString(11, getCardType());
      }
      if (hasStartLoc()) {
        paramCodedOutputStreamMicro.writeString(12, getStartLoc());
      }
      if (hasEndLoc()) {
        paramCodedOutputStreamMicro.writeString(13, getEndLoc());
      }
      if (hasStatusTitle()) {
        paramCodedOutputStreamMicro.writeString(14, getStatusTitle());
      }
      if (hasIsRoute()) {
        paramCodedOutputStreamMicro.writeBool(15, getIsRoute());
      }
      Iterator localIterator = getNotifyContentList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(16, (TaResponse.NotifyContent)localIterator.next());
      }
      if (hasLabel()) {
        paramCodedOutputStreamMicro.writeString(17, getLabel());
      }
    }
  }
  
  public static final class FlightCheckData
    extends MessageMicro
  {
    public static final int FLIGHT_COUNT_FIELD_NUMBER = 1;
    public static final int FLIGHT_LIST_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private List<TaResponse.FlightNoDetailData> c = Collections.emptyList();
    private int d = -1;
    
    public static FlightCheckData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightCheckData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightCheckData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightCheckData)new FlightCheckData().mergeFrom(paramArrayOfByte);
    }
    
    public FlightCheckData addFlightList(TaResponse.FlightNoDetailData paramFlightNoDetailData)
    {
      if (paramFlightNoDetailData == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramFlightNoDetailData);
      return this;
    }
    
    public final FlightCheckData clear()
    {
      clearFlightCount();
      clearFlightList();
      this.d = -1;
      return this;
    }
    
    public FlightCheckData clearFlightCount()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public FlightCheckData clearFlightList()
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
    
    public int getFlightCount()
    {
      return this.b;
    }
    
    public TaResponse.FlightNoDetailData getFlightList(int paramInt)
    {
      return (TaResponse.FlightNoDetailData)this.c.get(paramInt);
    }
    
    public int getFlightListCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.FlightNoDetailData> getFlightListList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasFlightCount()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getFlightCount());
      }
      Iterator localIterator = getFlightListList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.FlightNoDetailData)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasFlightCount()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public FlightCheckData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setFlightCount(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          TaResponse.FlightNoDetailData localFlightNoDetailData = new TaResponse.FlightNoDetailData();
          paramCodedInputStreamMicro.readMessage(localFlightNoDetailData);
          addFlightList(localFlightNoDetailData);
        }
      }
    }
    
    public FlightCheckData setFlightCount(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public FlightCheckData setFlightList(int paramInt, TaResponse.FlightNoDetailData paramFlightNoDetailData)
    {
      if (paramFlightNoDetailData == null) {
        return this;
      }
      this.c.set(paramInt, paramFlightNoDetailData);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasFlightCount()) {
        paramCodedOutputStreamMicro.writeInt32(1, getFlightCount());
      }
      Iterator localIterator = getFlightListList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.FlightNoDetailData)localIterator.next());
      }
    }
  }
  
  public static final class FlightConfigData
    extends MessageMicro
  {
    public static final int DATA_FIELD_NUMBER = 2;
    public static final int SHORT_TITLE_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<TaResponse.FlightListData> c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private int f = -1;
    
    public static FlightConfigData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightConfigData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightConfigData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightConfigData)new FlightConfigData().mergeFrom(paramArrayOfByte);
    }
    
    public FlightConfigData addData(TaResponse.FlightListData paramFlightListData)
    {
      if (paramFlightListData == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramFlightListData);
      return this;
    }
    
    public final FlightConfigData clear()
    {
      clearTitle();
      clearData();
      clearShortTitle();
      this.f = -1;
      return this;
    }
    
    public FlightConfigData clearData()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public FlightConfigData clearShortTitle()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public FlightConfigData clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.f < 0) {
        getSerializedSize();
      }
      return this.f;
    }
    
    public TaResponse.FlightListData getData(int paramInt)
    {
      return (TaResponse.FlightListData)this.c.get(paramInt);
    }
    
    public int getDataCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.FlightListData> getDataList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasTitle()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.FlightListData)localIterator.next()) + i;
      }
      int j = i;
      if (hasShortTitle()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getShortTitle());
      }
      this.f = j;
      return j;
    }
    
    public String getShortTitle()
    {
      return this.e;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public boolean hasShortTitle()
    {
      return this.d;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public FlightConfigData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.FlightListData localFlightListData = new TaResponse.FlightListData();
          paramCodedInputStreamMicro.readMessage(localFlightListData);
          addData(localFlightListData);
          break;
        case 26: 
          setShortTitle(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public FlightConfigData setData(int paramInt, TaResponse.FlightListData paramFlightListData)
    {
      if (paramFlightListData == null) {
        return this;
      }
      this.c.set(paramInt, paramFlightListData);
      return this;
    }
    
    public FlightConfigData setShortTitle(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public FlightConfigData setTitle(String paramString)
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
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.FlightListData)localIterator.next());
      }
      if (hasShortTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getShortTitle());
      }
    }
  }
  
  public static final class FlightConfigDataDetail
    extends MessageMicro
  {
    public static final int DATA_FIELD_NUMBER = 2;
    public static final int SHORT_TITLE_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<TaResponse.FlightListData> c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private int f = -1;
    
    public static FlightConfigDataDetail parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightConfigDataDetail().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightConfigDataDetail parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightConfigDataDetail)new FlightConfigDataDetail().mergeFrom(paramArrayOfByte);
    }
    
    public FlightConfigDataDetail addData(TaResponse.FlightListData paramFlightListData)
    {
      if (paramFlightListData == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramFlightListData);
      return this;
    }
    
    public final FlightConfigDataDetail clear()
    {
      clearTitle();
      clearData();
      clearShortTitle();
      this.f = -1;
      return this;
    }
    
    public FlightConfigDataDetail clearData()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public FlightConfigDataDetail clearShortTitle()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public FlightConfigDataDetail clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.f < 0) {
        getSerializedSize();
      }
      return this.f;
    }
    
    public TaResponse.FlightListData getData(int paramInt)
    {
      return (TaResponse.FlightListData)this.c.get(paramInt);
    }
    
    public int getDataCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.FlightListData> getDataList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasTitle()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.FlightListData)localIterator.next()) + i;
      }
      int j = i;
      if (hasShortTitle()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getShortTitle());
      }
      this.f = j;
      return j;
    }
    
    public String getShortTitle()
    {
      return this.e;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public boolean hasShortTitle()
    {
      return this.d;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public FlightConfigDataDetail mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.FlightListData localFlightListData = new TaResponse.FlightListData();
          paramCodedInputStreamMicro.readMessage(localFlightListData);
          addData(localFlightListData);
          break;
        case 26: 
          setShortTitle(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public FlightConfigDataDetail setData(int paramInt, TaResponse.FlightListData paramFlightListData)
    {
      if (paramFlightListData == null) {
        return this;
      }
      this.c.set(paramInt, paramFlightListData);
      return this;
    }
    
    public FlightConfigDataDetail setShortTitle(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public FlightConfigDataDetail setTitle(String paramString)
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
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.FlightListData)localIterator.next());
      }
      if (hasShortTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getShortTitle());
      }
    }
  }
  
  public static final class FlightDetailData
    extends MessageMicro
  {
    public static final int AIRLINE_ABBREV_FIELD_NUMBER = 4;
    public static final int AIRLINE_CODE_FIELD_NUMBER = 2;
    public static final int AIRLINE_FIELD_NUMBER = 3;
    public static final int ARRIVAL_AIRPORT_FIELD_NUMBER = 13;
    public static final int ARRIVAL_AIRPORT_NAME_FIELD_NUMBER = 25;
    public static final int ARRIVAL_CITY_NAME_FIELD_NUMBER = 23;
    public static final int ARRIVAL_TERMINAL_FIELD_NUMBER = 14;
    public static final int ARRIVAL_TIME_FIELD_NUMBER = 12;
    public static final int ARRIVAL_TIME_STR_FIELD_NUMBER = 21;
    public static final int DEPART_AIRPORT_FIELD_NUMBER = 10;
    public static final int DEPART_AIRPORT_NAME_FIELD_NUMBER = 24;
    public static final int DEPART_CITY_NAME_FIELD_NUMBER = 22;
    public static final int DEPART_TERMINAL_FIELD_NUMBER = 11;
    public static final int DEPART_TIME_FIELD_NUMBER = 9;
    public static final int DEPART_TIME_STR_FIELD_NUMBER = 20;
    public static final int ECONOMY_CABIN_DISCOUNT_FIELD_NUMBER = 6;
    public static final int ECONOMY_CABIN_PRICE_FIELD_NUMBER = 5;
    public static final int FIRST_CABIN_DISCOUNT_FIELD_NUMBER = 8;
    public static final int FIRST_CABIN_PRICE_FIELD_NUMBER = 7;
    public static final int FLIGHT_NO_FIELD_NUMBER = 1;
    public static final int FLIGHT_SIZE_FIELD_NUMBER = 16;
    public static final int FLIGHT_TYPE_FIELD_NUMBER = 15;
    public static final int IS_SHARE_FIELD_NUMBER = 17;
    public static final int PARTNER_FIELD_NUMBER = 19;
    public static final int TICKET_COUNT_FIELD_NUMBER = 18;
    private boolean A;
    private String B = "";
    private boolean C;
    private String D = "";
    private boolean E;
    private String F = "";
    private boolean G;
    private boolean H = false;
    private boolean I;
    private int J = 0;
    private boolean K;
    private int L = 0;
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
    private int Y = -1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private long j = 0L;
    private boolean k;
    private float l = 0.0F;
    private boolean m;
    private float n = 0.0F;
    private boolean o;
    private float p = 0.0F;
    private boolean q;
    private long r = 0L;
    private boolean s;
    private String t = "";
    private boolean u;
    private String v = "";
    private boolean w;
    private long x = 0L;
    private boolean y;
    private String z = "";
    
    public static FlightDetailData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightDetailData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightDetailData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightDetailData)new FlightDetailData().mergeFrom(paramArrayOfByte);
    }
    
    public final FlightDetailData clear()
    {
      clearFlightNo();
      clearAirlineCode();
      clearAirline();
      clearAirlineAbbrev();
      clearEconomyCabinPrice();
      clearEconomyCabinDiscount();
      clearFirstCabinPrice();
      clearFirstCabinDiscount();
      clearDepartTime();
      clearDepartAirport();
      clearDepartTerminal();
      clearArrivalTime();
      clearArrivalAirport();
      clearArrivalTerminal();
      clearFlightType();
      clearFlightSize();
      clearIsShare();
      clearTicketCount();
      clearPartner();
      clearDepartTimeStr();
      clearArrivalTimeStr();
      clearDepartCityName();
      clearArrivalCityName();
      clearDepartAirportName();
      clearArrivalAirportName();
      this.Y = -1;
      return this;
    }
    
    public FlightDetailData clearAirline()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public FlightDetailData clearAirlineAbbrev()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public FlightDetailData clearAirlineCode()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public FlightDetailData clearArrivalAirport()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public FlightDetailData clearArrivalAirportName()
    {
      this.W = false;
      this.X = "";
      return this;
    }
    
    public FlightDetailData clearArrivalCityName()
    {
      this.S = false;
      this.T = "";
      return this;
    }
    
    public FlightDetailData clearArrivalTerminal()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public FlightDetailData clearArrivalTime()
    {
      this.w = false;
      this.x = 0L;
      return this;
    }
    
    public FlightDetailData clearArrivalTimeStr()
    {
      this.O = false;
      this.P = "";
      return this;
    }
    
    public FlightDetailData clearDepartAirport()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public FlightDetailData clearDepartAirportName()
    {
      this.U = false;
      this.V = "";
      return this;
    }
    
    public FlightDetailData clearDepartCityName()
    {
      this.Q = false;
      this.R = "";
      return this;
    }
    
    public FlightDetailData clearDepartTerminal()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public FlightDetailData clearDepartTime()
    {
      this.q = false;
      this.r = 0L;
      return this;
    }
    
    public FlightDetailData clearDepartTimeStr()
    {
      this.M = false;
      this.N = "";
      return this;
    }
    
    public FlightDetailData clearEconomyCabinDiscount()
    {
      this.k = false;
      this.l = 0.0F;
      return this;
    }
    
    public FlightDetailData clearEconomyCabinPrice()
    {
      this.i = false;
      this.j = 0L;
      return this;
    }
    
    public FlightDetailData clearFirstCabinDiscount()
    {
      this.o = false;
      this.p = 0.0F;
      return this;
    }
    
    public FlightDetailData clearFirstCabinPrice()
    {
      this.m = false;
      this.n = 0.0F;
      return this;
    }
    
    public FlightDetailData clearFlightNo()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public FlightDetailData clearFlightSize()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public FlightDetailData clearFlightType()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public FlightDetailData clearIsShare()
    {
      this.G = false;
      this.H = false;
      return this;
    }
    
    public FlightDetailData clearPartner()
    {
      this.K = false;
      this.L = 0;
      return this;
    }
    
    public FlightDetailData clearTicketCount()
    {
      this.I = false;
      this.J = 0;
      return this;
    }
    
    public String getAirline()
    {
      return this.f;
    }
    
    public String getAirlineAbbrev()
    {
      return this.h;
    }
    
    public String getAirlineCode()
    {
      return this.d;
    }
    
    public String getArrivalAirport()
    {
      return this.z;
    }
    
    public String getArrivalAirportName()
    {
      return this.X;
    }
    
    public String getArrivalCityName()
    {
      return this.T;
    }
    
    public String getArrivalTerminal()
    {
      return this.B;
    }
    
    public long getArrivalTime()
    {
      return this.x;
    }
    
    public String getArrivalTimeStr()
    {
      return this.P;
    }
    
    public int getCachedSize()
    {
      if (this.Y < 0) {
        getSerializedSize();
      }
      return this.Y;
    }
    
    public String getDepartAirport()
    {
      return this.t;
    }
    
    public String getDepartAirportName()
    {
      return this.V;
    }
    
    public String getDepartCityName()
    {
      return this.R;
    }
    
    public String getDepartTerminal()
    {
      return this.v;
    }
    
    public long getDepartTime()
    {
      return this.r;
    }
    
    public String getDepartTimeStr()
    {
      return this.N;
    }
    
    public float getEconomyCabinDiscount()
    {
      return this.l;
    }
    
    public long getEconomyCabinPrice()
    {
      return this.j;
    }
    
    public float getFirstCabinDiscount()
    {
      return this.p;
    }
    
    public float getFirstCabinPrice()
    {
      return this.n;
    }
    
    public String getFlightNo()
    {
      return this.b;
    }
    
    public String getFlightSize()
    {
      return this.F;
    }
    
    public String getFlightType()
    {
      return this.D;
    }
    
    public boolean getIsShare()
    {
      return this.H;
    }
    
    public int getPartner()
    {
      return this.L;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasFlightNo()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getFlightNo());
      }
      int i1 = i2;
      if (hasAirlineCode()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getAirlineCode());
      }
      i2 = i1;
      if (hasAirline()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getAirline());
      }
      i1 = i2;
      if (hasAirlineAbbrev()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getAirlineAbbrev());
      }
      i2 = i1;
      if (hasEconomyCabinPrice()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(5, getEconomyCabinPrice());
      }
      i1 = i2;
      if (hasEconomyCabinDiscount()) {
        i1 = i2 + CodedOutputStreamMicro.computeFloatSize(6, getEconomyCabinDiscount());
      }
      i2 = i1;
      if (hasFirstCabinPrice()) {
        i2 = i1 + CodedOutputStreamMicro.computeFloatSize(7, getFirstCabinPrice());
      }
      i1 = i2;
      if (hasFirstCabinDiscount()) {
        i1 = i2 + CodedOutputStreamMicro.computeFloatSize(8, getFirstCabinDiscount());
      }
      i2 = i1;
      if (hasDepartTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(9, getDepartTime());
      }
      i1 = i2;
      if (hasDepartAirport()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getDepartAirport());
      }
      i2 = i1;
      if (hasDepartTerminal()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getDepartTerminal());
      }
      i1 = i2;
      if (hasArrivalTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(12, getArrivalTime());
      }
      i2 = i1;
      if (hasArrivalAirport()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getArrivalAirport());
      }
      i1 = i2;
      if (hasArrivalTerminal()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getArrivalTerminal());
      }
      i2 = i1;
      if (hasFlightType()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getFlightType());
      }
      i1 = i2;
      if (hasFlightSize()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getFlightSize());
      }
      i2 = i1;
      if (hasIsShare()) {
        i2 = i1 + CodedOutputStreamMicro.computeBoolSize(17, getIsShare());
      }
      i1 = i2;
      if (hasTicketCount()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(18, getTicketCount());
      }
      i2 = i1;
      if (hasPartner()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(19, getPartner());
      }
      i1 = i2;
      if (hasDepartTimeStr()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(20, getDepartTimeStr());
      }
      i2 = i1;
      if (hasArrivalTimeStr()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(21, getArrivalTimeStr());
      }
      i1 = i2;
      if (hasDepartCityName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(22, getDepartCityName());
      }
      i2 = i1;
      if (hasArrivalCityName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(23, getArrivalCityName());
      }
      i1 = i2;
      if (hasDepartAirportName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(24, getDepartAirportName());
      }
      i2 = i1;
      if (hasArrivalAirportName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(25, getArrivalAirportName());
      }
      this.Y = i2;
      return i2;
    }
    
    public int getTicketCount()
    {
      return this.J;
    }
    
    public boolean hasAirline()
    {
      return this.e;
    }
    
    public boolean hasAirlineAbbrev()
    {
      return this.g;
    }
    
    public boolean hasAirlineCode()
    {
      return this.c;
    }
    
    public boolean hasArrivalAirport()
    {
      return this.y;
    }
    
    public boolean hasArrivalAirportName()
    {
      return this.W;
    }
    
    public boolean hasArrivalCityName()
    {
      return this.S;
    }
    
    public boolean hasArrivalTerminal()
    {
      return this.A;
    }
    
    public boolean hasArrivalTime()
    {
      return this.w;
    }
    
    public boolean hasArrivalTimeStr()
    {
      return this.O;
    }
    
    public boolean hasDepartAirport()
    {
      return this.s;
    }
    
    public boolean hasDepartAirportName()
    {
      return this.U;
    }
    
    public boolean hasDepartCityName()
    {
      return this.Q;
    }
    
    public boolean hasDepartTerminal()
    {
      return this.u;
    }
    
    public boolean hasDepartTime()
    {
      return this.q;
    }
    
    public boolean hasDepartTimeStr()
    {
      return this.M;
    }
    
    public boolean hasEconomyCabinDiscount()
    {
      return this.k;
    }
    
    public boolean hasEconomyCabinPrice()
    {
      return this.i;
    }
    
    public boolean hasFirstCabinDiscount()
    {
      return this.o;
    }
    
    public boolean hasFirstCabinPrice()
    {
      return this.m;
    }
    
    public boolean hasFlightNo()
    {
      return this.a;
    }
    
    public boolean hasFlightSize()
    {
      return this.E;
    }
    
    public boolean hasFlightType()
    {
      return this.C;
    }
    
    public boolean hasIsShare()
    {
      return this.G;
    }
    
    public boolean hasPartner()
    {
      return this.K;
    }
    
    public boolean hasTicketCount()
    {
      return this.I;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g) || (!this.i) || (!this.k) || (!this.m) || (!this.o) || (!this.q) || (!this.s) || (!this.u) || (!this.w) || (!this.y) || (!this.A) || (!this.C) || (!this.E) || (!this.G) || (!this.I) || (!this.K) || (!this.M) || (!this.O) || (!this.Q) || (!this.S) || (!this.U) || (!this.W)) {
        return false;
      }
      return true;
    }
    
    public FlightDetailData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setFlightNo(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setAirlineCode(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setAirline(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setAirlineAbbrev(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setEconomyCabinPrice(paramCodedInputStreamMicro.readInt64());
          break;
        case 53: 
          setEconomyCabinDiscount(paramCodedInputStreamMicro.readFloat());
          break;
        case 61: 
          setFirstCabinPrice(paramCodedInputStreamMicro.readFloat());
          break;
        case 69: 
          setFirstCabinDiscount(paramCodedInputStreamMicro.readFloat());
          break;
        case 72: 
          setDepartTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 82: 
          setDepartAirport(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setDepartTerminal(paramCodedInputStreamMicro.readString());
          break;
        case 96: 
          setArrivalTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 106: 
          setArrivalAirport(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setArrivalTerminal(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setFlightType(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setFlightSize(paramCodedInputStreamMicro.readString());
          break;
        case 136: 
          setIsShare(paramCodedInputStreamMicro.readBool());
          break;
        case 144: 
          setTicketCount(paramCodedInputStreamMicro.readInt32());
          break;
        case 152: 
          setPartner(paramCodedInputStreamMicro.readInt32());
          break;
        case 162: 
          setDepartTimeStr(paramCodedInputStreamMicro.readString());
          break;
        case 170: 
          setArrivalTimeStr(paramCodedInputStreamMicro.readString());
          break;
        case 178: 
          setDepartCityName(paramCodedInputStreamMicro.readString());
          break;
        case 186: 
          setArrivalCityName(paramCodedInputStreamMicro.readString());
          break;
        case 194: 
          setDepartAirportName(paramCodedInputStreamMicro.readString());
          break;
        case 202: 
          setArrivalAirportName(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public FlightDetailData setAirline(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public FlightDetailData setAirlineAbbrev(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public FlightDetailData setAirlineCode(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public FlightDetailData setArrivalAirport(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public FlightDetailData setArrivalAirportName(String paramString)
    {
      this.W = true;
      this.X = paramString;
      return this;
    }
    
    public FlightDetailData setArrivalCityName(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }
    
    public FlightDetailData setArrivalTerminal(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public FlightDetailData setArrivalTime(long paramLong)
    {
      this.w = true;
      this.x = paramLong;
      return this;
    }
    
    public FlightDetailData setArrivalTimeStr(String paramString)
    {
      this.O = true;
      this.P = paramString;
      return this;
    }
    
    public FlightDetailData setDepartAirport(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public FlightDetailData setDepartAirportName(String paramString)
    {
      this.U = true;
      this.V = paramString;
      return this;
    }
    
    public FlightDetailData setDepartCityName(String paramString)
    {
      this.Q = true;
      this.R = paramString;
      return this;
    }
    
    public FlightDetailData setDepartTerminal(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public FlightDetailData setDepartTime(long paramLong)
    {
      this.q = true;
      this.r = paramLong;
      return this;
    }
    
    public FlightDetailData setDepartTimeStr(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }
    
    public FlightDetailData setEconomyCabinDiscount(float paramFloat)
    {
      this.k = true;
      this.l = paramFloat;
      return this;
    }
    
    public FlightDetailData setEconomyCabinPrice(long paramLong)
    {
      this.i = true;
      this.j = paramLong;
      return this;
    }
    
    public FlightDetailData setFirstCabinDiscount(float paramFloat)
    {
      this.o = true;
      this.p = paramFloat;
      return this;
    }
    
    public FlightDetailData setFirstCabinPrice(float paramFloat)
    {
      this.m = true;
      this.n = paramFloat;
      return this;
    }
    
    public FlightDetailData setFlightNo(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public FlightDetailData setFlightSize(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public FlightDetailData setFlightType(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public FlightDetailData setIsShare(boolean paramBoolean)
    {
      this.G = true;
      this.H = paramBoolean;
      return this;
    }
    
    public FlightDetailData setPartner(int paramInt)
    {
      this.K = true;
      this.L = paramInt;
      return this;
    }
    
    public FlightDetailData setTicketCount(int paramInt)
    {
      this.I = true;
      this.J = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasFlightNo()) {
        paramCodedOutputStreamMicro.writeString(1, getFlightNo());
      }
      if (hasAirlineCode()) {
        paramCodedOutputStreamMicro.writeString(2, getAirlineCode());
      }
      if (hasAirline()) {
        paramCodedOutputStreamMicro.writeString(3, getAirline());
      }
      if (hasAirlineAbbrev()) {
        paramCodedOutputStreamMicro.writeString(4, getAirlineAbbrev());
      }
      if (hasEconomyCabinPrice()) {
        paramCodedOutputStreamMicro.writeInt64(5, getEconomyCabinPrice());
      }
      if (hasEconomyCabinDiscount()) {
        paramCodedOutputStreamMicro.writeFloat(6, getEconomyCabinDiscount());
      }
      if (hasFirstCabinPrice()) {
        paramCodedOutputStreamMicro.writeFloat(7, getFirstCabinPrice());
      }
      if (hasFirstCabinDiscount()) {
        paramCodedOutputStreamMicro.writeFloat(8, getFirstCabinDiscount());
      }
      if (hasDepartTime()) {
        paramCodedOutputStreamMicro.writeInt64(9, getDepartTime());
      }
      if (hasDepartAirport()) {
        paramCodedOutputStreamMicro.writeString(10, getDepartAirport());
      }
      if (hasDepartTerminal()) {
        paramCodedOutputStreamMicro.writeString(11, getDepartTerminal());
      }
      if (hasArrivalTime()) {
        paramCodedOutputStreamMicro.writeInt64(12, getArrivalTime());
      }
      if (hasArrivalAirport()) {
        paramCodedOutputStreamMicro.writeString(13, getArrivalAirport());
      }
      if (hasArrivalTerminal()) {
        paramCodedOutputStreamMicro.writeString(14, getArrivalTerminal());
      }
      if (hasFlightType()) {
        paramCodedOutputStreamMicro.writeString(15, getFlightType());
      }
      if (hasFlightSize()) {
        paramCodedOutputStreamMicro.writeString(16, getFlightSize());
      }
      if (hasIsShare()) {
        paramCodedOutputStreamMicro.writeBool(17, getIsShare());
      }
      if (hasTicketCount()) {
        paramCodedOutputStreamMicro.writeInt32(18, getTicketCount());
      }
      if (hasPartner()) {
        paramCodedOutputStreamMicro.writeInt32(19, getPartner());
      }
      if (hasDepartTimeStr()) {
        paramCodedOutputStreamMicro.writeString(20, getDepartTimeStr());
      }
      if (hasArrivalTimeStr()) {
        paramCodedOutputStreamMicro.writeString(21, getArrivalTimeStr());
      }
      if (hasDepartCityName()) {
        paramCodedOutputStreamMicro.writeString(22, getDepartCityName());
      }
      if (hasArrivalCityName()) {
        paramCodedOutputStreamMicro.writeString(23, getArrivalCityName());
      }
      if (hasDepartAirportName()) {
        paramCodedOutputStreamMicro.writeString(24, getDepartAirportName());
      }
      if (hasArrivalAirportName()) {
        paramCodedOutputStreamMicro.writeString(25, getArrivalAirportName());
      }
    }
  }
  
  public static final class FlightListData
    extends MessageMicro
  {
    public static final int APS_NAME_FIELD_NUMBER = 1;
    public static final int CODE_FIELD_NUMBER = 2;
    public static final int COUNTRY_ID_FIELD_NUMBER = 20;
    public static final int COUNTRY_NAME_FIELD_NUMBER = 4;
    public static final int DATA_VER_FIELD_NUMBER = 19;
    public static final int ENAME_FIELD_NUMBER = 6;
    public static final int ERROR_NO_FIELD_NUMBER = 22;
    public static final int FLAG_FIELD_NUMBER = 18;
    public static final int HOT_FLAG1_FIELD_NUMBER = 24;
    public static final int HOT_FLAG_FIELD_NUMBER = 12;
    public static final int ID_FIELD_NUMBER = 16;
    public static final int INITIAL_FIELD_NUMBER = 10;
    public static final int IS_ANCHOR_FIELD_NUMBER = 11;
    public static final int IS_DOMESTIC_FIELD_NUMBER = 25;
    public static final int IS_INTERNATIONAL_FIELD_NUMBER = 26;
    public static final int JP_FIELD_NUMBER = 9;
    public static final int KEY_FIELD_NUMBER = 15;
    public static final int LAT_FIELD_NUMBER = 14;
    public static final int LON_FIELD_NUMBER = 13;
    public static final int NAME_FIELD_NUMBER = 8;
    public static final int OPR_FIELD_NUMBER = 17;
    public static final int PORT_CODE_FIELD_NUMBER = 7;
    public static final int PORT_NAME_FIELD_NUMBER = 5;
    public static final int PY_FIELD_NUMBER = 3;
    public static final int TOTAL_NAME_FIELD_NUMBER = 23;
    public static final int WEIGHT_FIELD_NUMBER = 21;
    private boolean A;
    private float B = 0.0F;
    private boolean C;
    private int D = 0;
    private boolean E;
    private int F = 0;
    private boolean G;
    private int H = 0;
    private boolean I;
    private int J = 0;
    private boolean K;
    private int L = 0;
    private boolean M;
    private int N = 0;
    private boolean O;
    private int P = 0;
    private boolean Q;
    private int R = 0;
    private boolean S;
    private String T = "";
    private boolean U;
    private float V = 0.0F;
    private boolean W;
    private int X = 0;
    private boolean Y;
    private int Z = 0;
    private boolean a;
    private int aa = -1;
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
    private boolean s;
    private String t = "";
    private boolean u;
    private boolean v = false;
    private boolean w;
    private float x = 0.0F;
    private boolean y;
    private float z = 0.0F;
    
    public static FlightListData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightListData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightListData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightListData)new FlightListData().mergeFrom(paramArrayOfByte);
    }
    
    public final FlightListData clear()
    {
      clearApsName();
      clearCode();
      clearPy();
      clearCountryName();
      clearPortName();
      clearEname();
      clearPortCode();
      clearName();
      clearJp();
      clearInitial();
      clearIsAnchor();
      clearHotFlag();
      clearLon();
      clearLat();
      clearKey();
      clearId();
      clearOpr();
      clearFlag();
      clearDataVer();
      clearCountryId();
      clearWeight();
      clearErrorNo();
      clearTotalName();
      clearHotFlag1();
      clearIsDomestic();
      clearIsInternational();
      this.aa = -1;
      return this;
    }
    
    public FlightListData clearApsName()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public FlightListData clearCode()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public FlightListData clearCountryId()
    {
      this.M = false;
      this.N = 0;
      return this;
    }
    
    public FlightListData clearCountryName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public FlightListData clearDataVer()
    {
      this.K = false;
      this.L = 0;
      return this;
    }
    
    public FlightListData clearEname()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public FlightListData clearErrorNo()
    {
      this.Q = false;
      this.R = 0;
      return this;
    }
    
    public FlightListData clearFlag()
    {
      this.I = false;
      this.J = 0;
      return this;
    }
    
    public FlightListData clearHotFlag()
    {
      this.w = false;
      this.x = 0.0F;
      return this;
    }
    
    public FlightListData clearHotFlag1()
    {
      this.U = false;
      this.V = 0.0F;
      return this;
    }
    
    public FlightListData clearId()
    {
      this.E = false;
      this.F = 0;
      return this;
    }
    
    public FlightListData clearInitial()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public FlightListData clearIsAnchor()
    {
      this.u = false;
      this.v = false;
      return this;
    }
    
    public FlightListData clearIsDomestic()
    {
      this.W = false;
      this.X = 0;
      return this;
    }
    
    public FlightListData clearIsInternational()
    {
      this.Y = false;
      this.Z = 0;
      return this;
    }
    
    public FlightListData clearJp()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public FlightListData clearKey()
    {
      this.C = false;
      this.D = 0;
      return this;
    }
    
    public FlightListData clearLat()
    {
      this.A = false;
      this.B = 0.0F;
      return this;
    }
    
    public FlightListData clearLon()
    {
      this.y = false;
      this.z = 0.0F;
      return this;
    }
    
    public FlightListData clearName()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public FlightListData clearOpr()
    {
      this.G = false;
      this.H = 0;
      return this;
    }
    
    public FlightListData clearPortCode()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public FlightListData clearPortName()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public FlightListData clearPy()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public FlightListData clearTotalName()
    {
      this.S = false;
      this.T = "";
      return this;
    }
    
    public FlightListData clearWeight()
    {
      this.O = false;
      this.P = 0;
      return this;
    }
    
    public String getApsName()
    {
      return this.b;
    }
    
    public int getCachedSize()
    {
      if (this.aa < 0) {
        getSerializedSize();
      }
      return this.aa;
    }
    
    public String getCode()
    {
      return this.d;
    }
    
    public int getCountryId()
    {
      return this.N;
    }
    
    public String getCountryName()
    {
      return this.h;
    }
    
    public int getDataVer()
    {
      return this.L;
    }
    
    public String getEname()
    {
      return this.l;
    }
    
    public int getErrorNo()
    {
      return this.R;
    }
    
    public int getFlag()
    {
      return this.J;
    }
    
    public float getHotFlag()
    {
      return this.x;
    }
    
    public float getHotFlag1()
    {
      return this.V;
    }
    
    public int getId()
    {
      return this.F;
    }
    
    public String getInitial()
    {
      return this.t;
    }
    
    public boolean getIsAnchor()
    {
      return this.v;
    }
    
    public int getIsDomestic()
    {
      return this.X;
    }
    
    public int getIsInternational()
    {
      return this.Z;
    }
    
    public String getJp()
    {
      return this.r;
    }
    
    public int getKey()
    {
      return this.D;
    }
    
    public float getLat()
    {
      return this.B;
    }
    
    public float getLon()
    {
      return this.z;
    }
    
    public String getName()
    {
      return this.p;
    }
    
    public int getOpr()
    {
      return this.H;
    }
    
    public String getPortCode()
    {
      return this.n;
    }
    
    public String getPortName()
    {
      return this.j;
    }
    
    public String getPy()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasApsName()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getApsName());
      }
      int i1 = i2;
      if (hasCode()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getCode());
      }
      i2 = i1;
      if (hasPy()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getPy());
      }
      i1 = i2;
      if (hasCountryName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getCountryName());
      }
      i2 = i1;
      if (hasPortName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getPortName());
      }
      i1 = i2;
      if (hasEname()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getEname());
      }
      i2 = i1;
      if (hasPortCode()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getPortCode());
      }
      i1 = i2;
      if (hasName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getName());
      }
      i2 = i1;
      if (hasJp()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getJp());
      }
      i1 = i2;
      if (hasInitial()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getInitial());
      }
      i2 = i1;
      if (hasIsAnchor()) {
        i2 = i1 + CodedOutputStreamMicro.computeBoolSize(11, getIsAnchor());
      }
      i1 = i2;
      if (hasHotFlag()) {
        i1 = i2 + CodedOutputStreamMicro.computeFloatSize(12, getHotFlag());
      }
      i2 = i1;
      if (hasLon()) {
        i2 = i1 + CodedOutputStreamMicro.computeFloatSize(13, getLon());
      }
      i1 = i2;
      if (hasLat()) {
        i1 = i2 + CodedOutputStreamMicro.computeFloatSize(14, getLat());
      }
      i2 = i1;
      if (hasKey()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(15, getKey());
      }
      i1 = i2;
      if (hasId()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(16, getId());
      }
      i2 = i1;
      if (hasOpr()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(17, getOpr());
      }
      i1 = i2;
      if (hasFlag()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(18, getFlag());
      }
      i2 = i1;
      if (hasDataVer()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(19, getDataVer());
      }
      i1 = i2;
      if (hasCountryId()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(20, getCountryId());
      }
      i2 = i1;
      if (hasWeight()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(21, getWeight());
      }
      i1 = i2;
      if (hasErrorNo()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(22, getErrorNo());
      }
      i2 = i1;
      if (hasTotalName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(23, getTotalName());
      }
      i1 = i2;
      if (hasHotFlag1()) {
        i1 = i2 + CodedOutputStreamMicro.computeFloatSize(24, getHotFlag1());
      }
      i2 = i1;
      if (hasIsDomestic()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(25, getIsDomestic());
      }
      i1 = i2;
      if (hasIsInternational()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(26, getIsInternational());
      }
      this.aa = i1;
      return i1;
    }
    
    public String getTotalName()
    {
      return this.T;
    }
    
    public int getWeight()
    {
      return this.P;
    }
    
    public boolean hasApsName()
    {
      return this.a;
    }
    
    public boolean hasCode()
    {
      return this.c;
    }
    
    public boolean hasCountryId()
    {
      return this.M;
    }
    
    public boolean hasCountryName()
    {
      return this.g;
    }
    
    public boolean hasDataVer()
    {
      return this.K;
    }
    
    public boolean hasEname()
    {
      return this.k;
    }
    
    public boolean hasErrorNo()
    {
      return this.Q;
    }
    
    public boolean hasFlag()
    {
      return this.I;
    }
    
    public boolean hasHotFlag()
    {
      return this.w;
    }
    
    public boolean hasHotFlag1()
    {
      return this.U;
    }
    
    public boolean hasId()
    {
      return this.E;
    }
    
    public boolean hasInitial()
    {
      return this.s;
    }
    
    public boolean hasIsAnchor()
    {
      return this.u;
    }
    
    public boolean hasIsDomestic()
    {
      return this.W;
    }
    
    public boolean hasIsInternational()
    {
      return this.Y;
    }
    
    public boolean hasJp()
    {
      return this.q;
    }
    
    public boolean hasKey()
    {
      return this.C;
    }
    
    public boolean hasLat()
    {
      return this.A;
    }
    
    public boolean hasLon()
    {
      return this.y;
    }
    
    public boolean hasName()
    {
      return this.o;
    }
    
    public boolean hasOpr()
    {
      return this.G;
    }
    
    public boolean hasPortCode()
    {
      return this.m;
    }
    
    public boolean hasPortName()
    {
      return this.i;
    }
    
    public boolean hasPy()
    {
      return this.e;
    }
    
    public boolean hasTotalName()
    {
      return this.S;
    }
    
    public boolean hasWeight()
    {
      return this.O;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public FlightListData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setApsName(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setCode(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setPy(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setCountryName(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setPortName(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setEname(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setPortCode(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setJp(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setInitial(paramCodedInputStreamMicro.readString());
          break;
        case 88: 
          setIsAnchor(paramCodedInputStreamMicro.readBool());
          break;
        case 101: 
          setHotFlag(paramCodedInputStreamMicro.readFloat());
          break;
        case 109: 
          setLon(paramCodedInputStreamMicro.readFloat());
          break;
        case 117: 
          setLat(paramCodedInputStreamMicro.readFloat());
          break;
        case 120: 
          setKey(paramCodedInputStreamMicro.readInt32());
          break;
        case 128: 
          setId(paramCodedInputStreamMicro.readInt32());
          break;
        case 136: 
          setOpr(paramCodedInputStreamMicro.readInt32());
          break;
        case 144: 
          setFlag(paramCodedInputStreamMicro.readInt32());
          break;
        case 152: 
          setDataVer(paramCodedInputStreamMicro.readInt32());
          break;
        case 160: 
          setCountryId(paramCodedInputStreamMicro.readInt32());
          break;
        case 168: 
          setWeight(paramCodedInputStreamMicro.readInt32());
          break;
        case 176: 
          setErrorNo(paramCodedInputStreamMicro.readInt32());
          break;
        case 186: 
          setTotalName(paramCodedInputStreamMicro.readString());
          break;
        case 197: 
          setHotFlag1(paramCodedInputStreamMicro.readFloat());
          break;
        case 200: 
          setIsDomestic(paramCodedInputStreamMicro.readInt32());
          break;
        case 208: 
          setIsInternational(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public FlightListData setApsName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public FlightListData setCode(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public FlightListData setCountryId(int paramInt)
    {
      this.M = true;
      this.N = paramInt;
      return this;
    }
    
    public FlightListData setCountryName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public FlightListData setDataVer(int paramInt)
    {
      this.K = true;
      this.L = paramInt;
      return this;
    }
    
    public FlightListData setEname(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public FlightListData setErrorNo(int paramInt)
    {
      this.Q = true;
      this.R = paramInt;
      return this;
    }
    
    public FlightListData setFlag(int paramInt)
    {
      this.I = true;
      this.J = paramInt;
      return this;
    }
    
    public FlightListData setHotFlag(float paramFloat)
    {
      this.w = true;
      this.x = paramFloat;
      return this;
    }
    
    public FlightListData setHotFlag1(float paramFloat)
    {
      this.U = true;
      this.V = paramFloat;
      return this;
    }
    
    public FlightListData setId(int paramInt)
    {
      this.E = true;
      this.F = paramInt;
      return this;
    }
    
    public FlightListData setInitial(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public FlightListData setIsAnchor(boolean paramBoolean)
    {
      this.u = true;
      this.v = paramBoolean;
      return this;
    }
    
    public FlightListData setIsDomestic(int paramInt)
    {
      this.W = true;
      this.X = paramInt;
      return this;
    }
    
    public FlightListData setIsInternational(int paramInt)
    {
      this.Y = true;
      this.Z = paramInt;
      return this;
    }
    
    public FlightListData setJp(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public FlightListData setKey(int paramInt)
    {
      this.C = true;
      this.D = paramInt;
      return this;
    }
    
    public FlightListData setLat(float paramFloat)
    {
      this.A = true;
      this.B = paramFloat;
      return this;
    }
    
    public FlightListData setLon(float paramFloat)
    {
      this.y = true;
      this.z = paramFloat;
      return this;
    }
    
    public FlightListData setName(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public FlightListData setOpr(int paramInt)
    {
      this.G = true;
      this.H = paramInt;
      return this;
    }
    
    public FlightListData setPortCode(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public FlightListData setPortName(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public FlightListData setPy(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public FlightListData setTotalName(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }
    
    public FlightListData setWeight(int paramInt)
    {
      this.O = true;
      this.P = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasApsName()) {
        paramCodedOutputStreamMicro.writeString(1, getApsName());
      }
      if (hasCode()) {
        paramCodedOutputStreamMicro.writeString(2, getCode());
      }
      if (hasPy()) {
        paramCodedOutputStreamMicro.writeString(3, getPy());
      }
      if (hasCountryName()) {
        paramCodedOutputStreamMicro.writeString(4, getCountryName());
      }
      if (hasPortName()) {
        paramCodedOutputStreamMicro.writeString(5, getPortName());
      }
      if (hasEname()) {
        paramCodedOutputStreamMicro.writeString(6, getEname());
      }
      if (hasPortCode()) {
        paramCodedOutputStreamMicro.writeString(7, getPortCode());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(8, getName());
      }
      if (hasJp()) {
        paramCodedOutputStreamMicro.writeString(9, getJp());
      }
      if (hasInitial()) {
        paramCodedOutputStreamMicro.writeString(10, getInitial());
      }
      if (hasIsAnchor()) {
        paramCodedOutputStreamMicro.writeBool(11, getIsAnchor());
      }
      if (hasHotFlag()) {
        paramCodedOutputStreamMicro.writeFloat(12, getHotFlag());
      }
      if (hasLon()) {
        paramCodedOutputStreamMicro.writeFloat(13, getLon());
      }
      if (hasLat()) {
        paramCodedOutputStreamMicro.writeFloat(14, getLat());
      }
      if (hasKey()) {
        paramCodedOutputStreamMicro.writeInt32(15, getKey());
      }
      if (hasId()) {
        paramCodedOutputStreamMicro.writeInt32(16, getId());
      }
      if (hasOpr()) {
        paramCodedOutputStreamMicro.writeInt32(17, getOpr());
      }
      if (hasFlag()) {
        paramCodedOutputStreamMicro.writeInt32(18, getFlag());
      }
      if (hasDataVer()) {
        paramCodedOutputStreamMicro.writeInt32(19, getDataVer());
      }
      if (hasCountryId()) {
        paramCodedOutputStreamMicro.writeInt32(20, getCountryId());
      }
      if (hasWeight()) {
        paramCodedOutputStreamMicro.writeInt32(21, getWeight());
      }
      if (hasErrorNo()) {
        paramCodedOutputStreamMicro.writeInt32(22, getErrorNo());
      }
      if (hasTotalName()) {
        paramCodedOutputStreamMicro.writeString(23, getTotalName());
      }
      if (hasHotFlag1()) {
        paramCodedOutputStreamMicro.writeFloat(24, getHotFlag1());
      }
      if (hasIsDomestic()) {
        paramCodedOutputStreamMicro.writeInt32(25, getIsDomestic());
      }
      if (hasIsInternational()) {
        paramCodedOutputStreamMicro.writeInt32(26, getIsInternational());
      }
    }
  }
  
  public static final class FlightNoDetailData
    extends MessageMicro
  {
    public static final int AIRLINE_CODE_FIELD_NUMBER = 2;
    public static final int AIRLINE_FIELD_NUMBER = 3;
    public static final int ARRIVAL_AIRPORT_FIELD_NUMBER = 11;
    public static final int ARRIVAL_AIRPORT_NAME_ABBREV_FIELD_NUMBER = 19;
    public static final int ARRIVAL_AIRPORT_NAME_FIELD_NUMBER = 12;
    public static final int ARRIVAL_CITY_CODE_FIELD_NUMBER = 13;
    public static final int ARRIVAL_CITY_NAME_FIELD_NUMBER = 14;
    public static final int ARRIVAL_TERMINAL_FIELD_NUMBER = 15;
    public static final int ARRIVAL_TIME_FIELD_NUMBER = 10;
    public static final int ARRIVAL_TIME_STR_FIELD_NUMBER = 17;
    public static final int BAGGAGE_ID_FIELD_NUMBER = 24;
    public static final int BOARD_GATE_FIELD_NUMBER = 23;
    public static final int CHECKIN_TABLE_FIELD_NUMBER = 21;
    public static final int DEPART_AIRPORT_FIELD_NUMBER = 5;
    public static final int DEPART_AIRPORT_NAME_ABBREV_FIELD_NUMBER = 18;
    public static final int DEPART_AIRPORT_NAME_FIELD_NUMBER = 6;
    public static final int DEPART_CITY_CODE_FIELD_NUMBER = 7;
    public static final int DEPART_CITY_NAME_FIELD_NUMBER = 8;
    public static final int DEPART_TERMINAL_FIELD_NUMBER = 9;
    public static final int DEPART_TIME_FIELD_NUMBER = 4;
    public static final int DEPART_TIME_STR_FIELD_NUMBER = 16;
    public static final int EMTIMATE_ARR_TIME_TITLE_FIELD_NUMBER = 31;
    public static final int ESTIMATE_DEP_TIME_TITLE_FIELD_NUMBER = 30;
    public static final int FCATEGORY_FIELD_NUMBER = 20;
    public static final int FLIGHT_NO_FIELD_NUMBER = 1;
    public static final int FLIGHT_STATE_FIELD_NUMBER = 22;
    public static final int FLIGHT_TIME_CONTENT_FIELD_NUMBER = 33;
    public static final int IS_DELAY_FIELD_NUMBER = 29;
    public static final int PLAN_TIME_CONTENT_FIELD_NUMBER = 32;
    public static final int SHARE_FLIGHTNO_FIELD_NUMBER = 25;
    public static final int SUPPLIED_BY_FIELD_NUMBER = 28;
    public static final int VERY_ZHUN_READY_ARRTIME_DATE_FIELD_NUMBER = 27;
    public static final int VERY_ZHUN_READY_DEPTIME_DATE_FIELD_NUMBER = 26;
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
    private boolean aa;
    private String ab = "";
    private boolean ac;
    private String ad = "";
    private boolean ae;
    private int af = 0;
    private boolean ag;
    private String ah = "";
    private boolean ai;
    private String aj = "";
    private boolean ak;
    private String al = "";
    private List<TaResponse.FlightTimeContent> am = Collections.emptyList();
    private int an = -1;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private long h = 0L;
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
    private long t = 0L;
    private boolean u;
    private String v = "";
    private boolean w;
    private String x = "";
    private boolean y;
    private String z = "";
    
    public static FlightNoDetailData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightNoDetailData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightNoDetailData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightNoDetailData)new FlightNoDetailData().mergeFrom(paramArrayOfByte);
    }
    
    public FlightNoDetailData addFlightTimeContent(TaResponse.FlightTimeContent paramFlightTimeContent)
    {
      if (paramFlightTimeContent == null) {
        return this;
      }
      if (this.am.isEmpty()) {
        this.am = new ArrayList();
      }
      this.am.add(paramFlightTimeContent);
      return this;
    }
    
    public final FlightNoDetailData clear()
    {
      clearFlightNo();
      clearAirlineCode();
      clearAirline();
      clearDepartTime();
      clearDepartAirport();
      clearDepartAirportName();
      clearDepartCityCode();
      clearDepartCityName();
      clearDepartTerminal();
      clearArrivalTime();
      clearArrivalAirport();
      clearArrivalAirportName();
      clearArrivalCityCode();
      clearArrivalCityName();
      clearArrivalTerminal();
      clearDepartTimeStr();
      clearArrivalTimeStr();
      clearDepartAirportNameAbbrev();
      clearArrivalAirportNameAbbrev();
      clearFcategory();
      clearCheckinTable();
      clearFlightState();
      clearBoardGate();
      clearBaggageId();
      clearShareFlightNo();
      clearVeryZhunReadyDeptimeDate();
      clearVeryZhunReadyArrtimeDate();
      clearSuppliedBy();
      clearIsDelay();
      clearEstimateDepTimeTitle();
      clearEmtimateArrTimeTitle();
      clearPlanTimeContent();
      clearFlightTimeContent();
      this.an = -1;
      return this;
    }
    
    public FlightNoDetailData clearAirline()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public FlightNoDetailData clearAirlineCode()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public FlightNoDetailData clearArrivalAirport()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public FlightNoDetailData clearArrivalAirportName()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public FlightNoDetailData clearArrivalAirportNameAbbrev()
    {
      this.K = false;
      this.L = "";
      return this;
    }
    
    public FlightNoDetailData clearArrivalCityCode()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public FlightNoDetailData clearArrivalCityName()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public FlightNoDetailData clearArrivalTerminal()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public FlightNoDetailData clearArrivalTime()
    {
      this.s = false;
      this.t = 0L;
      return this;
    }
    
    public FlightNoDetailData clearArrivalTimeStr()
    {
      this.G = false;
      this.H = "";
      return this;
    }
    
    public FlightNoDetailData clearBaggageId()
    {
      this.U = false;
      this.V = "";
      return this;
    }
    
    public FlightNoDetailData clearBoardGate()
    {
      this.S = false;
      this.T = "";
      return this;
    }
    
    public FlightNoDetailData clearCheckinTable()
    {
      this.O = false;
      this.P = "";
      return this;
    }
    
    public FlightNoDetailData clearDepartAirport()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public FlightNoDetailData clearDepartAirportName()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public FlightNoDetailData clearDepartAirportNameAbbrev()
    {
      this.I = false;
      this.J = "";
      return this;
    }
    
    public FlightNoDetailData clearDepartCityCode()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public FlightNoDetailData clearDepartCityName()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public FlightNoDetailData clearDepartTerminal()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public FlightNoDetailData clearDepartTime()
    {
      this.g = false;
      this.h = 0L;
      return this;
    }
    
    public FlightNoDetailData clearDepartTimeStr()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public FlightNoDetailData clearEmtimateArrTimeTitle()
    {
      this.ai = false;
      this.aj = "";
      return this;
    }
    
    public FlightNoDetailData clearEstimateDepTimeTitle()
    {
      this.ag = false;
      this.ah = "";
      return this;
    }
    
    public FlightNoDetailData clearFcategory()
    {
      this.M = false;
      this.N = "";
      return this;
    }
    
    public FlightNoDetailData clearFlightNo()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public FlightNoDetailData clearFlightState()
    {
      this.Q = false;
      this.R = "";
      return this;
    }
    
    public FlightNoDetailData clearFlightTimeContent()
    {
      this.am = Collections.emptyList();
      return this;
    }
    
    public FlightNoDetailData clearIsDelay()
    {
      this.ae = false;
      this.af = 0;
      return this;
    }
    
    public FlightNoDetailData clearPlanTimeContent()
    {
      this.ak = false;
      this.al = "";
      return this;
    }
    
    public FlightNoDetailData clearShareFlightNo()
    {
      this.W = false;
      this.X = "";
      return this;
    }
    
    public FlightNoDetailData clearSuppliedBy()
    {
      this.ac = false;
      this.ad = "";
      return this;
    }
    
    public FlightNoDetailData clearVeryZhunReadyArrtimeDate()
    {
      this.aa = false;
      this.ab = "";
      return this;
    }
    
    public FlightNoDetailData clearVeryZhunReadyDeptimeDate()
    {
      this.Y = false;
      this.Z = "";
      return this;
    }
    
    public String getAirline()
    {
      return this.f;
    }
    
    public String getAirlineCode()
    {
      return this.d;
    }
    
    public String getArrivalAirport()
    {
      return this.v;
    }
    
    public String getArrivalAirportName()
    {
      return this.x;
    }
    
    public String getArrivalAirportNameAbbrev()
    {
      return this.L;
    }
    
    public String getArrivalCityCode()
    {
      return this.z;
    }
    
    public String getArrivalCityName()
    {
      return this.B;
    }
    
    public String getArrivalTerminal()
    {
      return this.D;
    }
    
    public long getArrivalTime()
    {
      return this.t;
    }
    
    public String getArrivalTimeStr()
    {
      return this.H;
    }
    
    public String getBaggageId()
    {
      return this.V;
    }
    
    public String getBoardGate()
    {
      return this.T;
    }
    
    public int getCachedSize()
    {
      if (this.an < 0) {
        getSerializedSize();
      }
      return this.an;
    }
    
    public String getCheckinTable()
    {
      return this.P;
    }
    
    public String getDepartAirport()
    {
      return this.j;
    }
    
    public String getDepartAirportName()
    {
      return this.l;
    }
    
    public String getDepartAirportNameAbbrev()
    {
      return this.J;
    }
    
    public String getDepartCityCode()
    {
      return this.n;
    }
    
    public String getDepartCityName()
    {
      return this.p;
    }
    
    public String getDepartTerminal()
    {
      return this.r;
    }
    
    public long getDepartTime()
    {
      return this.h;
    }
    
    public String getDepartTimeStr()
    {
      return this.F;
    }
    
    public String getEmtimateArrTimeTitle()
    {
      return this.aj;
    }
    
    public String getEstimateDepTimeTitle()
    {
      return this.ah;
    }
    
    public String getFcategory()
    {
      return this.N;
    }
    
    public String getFlightNo()
    {
      return this.b;
    }
    
    public String getFlightState()
    {
      return this.R;
    }
    
    public TaResponse.FlightTimeContent getFlightTimeContent(int paramInt)
    {
      return (TaResponse.FlightTimeContent)this.am.get(paramInt);
    }
    
    public int getFlightTimeContentCount()
    {
      return this.am.size();
    }
    
    public List<TaResponse.FlightTimeContent> getFlightTimeContentList()
    {
      return this.am;
    }
    
    public int getIsDelay()
    {
      return this.af;
    }
    
    public String getPlanTimeContent()
    {
      return this.al;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasFlightNo()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getFlightNo());
      }
      int i1 = i2;
      if (hasAirlineCode()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getAirlineCode());
      }
      i2 = i1;
      if (hasAirline()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getAirline());
      }
      i1 = i2;
      if (hasDepartTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(4, getDepartTime());
      }
      i2 = i1;
      if (hasDepartAirport()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getDepartAirport());
      }
      i1 = i2;
      if (hasDepartAirportName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getDepartAirportName());
      }
      i2 = i1;
      if (hasDepartCityCode()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getDepartCityCode());
      }
      i1 = i2;
      if (hasDepartCityName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getDepartCityName());
      }
      i2 = i1;
      if (hasDepartTerminal()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getDepartTerminal());
      }
      i1 = i2;
      if (hasArrivalTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(10, getArrivalTime());
      }
      i2 = i1;
      if (hasArrivalAirport()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getArrivalAirport());
      }
      i1 = i2;
      if (hasArrivalAirportName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getArrivalAirportName());
      }
      i2 = i1;
      if (hasArrivalCityCode()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getArrivalCityCode());
      }
      i1 = i2;
      if (hasArrivalCityName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getArrivalCityName());
      }
      i2 = i1;
      if (hasArrivalTerminal()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getArrivalTerminal());
      }
      i1 = i2;
      if (hasDepartTimeStr()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getDepartTimeStr());
      }
      i2 = i1;
      if (hasArrivalTimeStr()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getArrivalTimeStr());
      }
      i1 = i2;
      if (hasDepartAirportNameAbbrev()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getDepartAirportNameAbbrev());
      }
      i2 = i1;
      if (hasArrivalAirportNameAbbrev()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(19, getArrivalAirportNameAbbrev());
      }
      i1 = i2;
      if (hasFcategory()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(20, getFcategory());
      }
      i2 = i1;
      if (hasCheckinTable()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(21, getCheckinTable());
      }
      i1 = i2;
      if (hasFlightState()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(22, getFlightState());
      }
      i2 = i1;
      if (hasBoardGate()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(23, getBoardGate());
      }
      i1 = i2;
      if (hasBaggageId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(24, getBaggageId());
      }
      i2 = i1;
      if (hasShareFlightNo()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(25, getShareFlightNo());
      }
      i1 = i2;
      if (hasVeryZhunReadyDeptimeDate()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(26, getVeryZhunReadyDeptimeDate());
      }
      i2 = i1;
      if (hasVeryZhunReadyArrtimeDate()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(27, getVeryZhunReadyArrtimeDate());
      }
      i1 = i2;
      if (hasSuppliedBy()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(28, getSuppliedBy());
      }
      i2 = i1;
      if (hasIsDelay()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(29, getIsDelay());
      }
      i1 = i2;
      if (hasEstimateDepTimeTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(30, getEstimateDepTimeTitle());
      }
      i2 = i1;
      if (hasEmtimateArrTimeTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(31, getEmtimateArrTimeTitle());
      }
      i1 = i2;
      if (hasPlanTimeContent()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(32, getPlanTimeContent());
      }
      Iterator localIterator = getFlightTimeContentList().iterator();
      while (localIterator.hasNext()) {
        i1 = CodedOutputStreamMicro.computeMessageSize(33, (TaResponse.FlightTimeContent)localIterator.next()) + i1;
      }
      this.an = i1;
      return i1;
    }
    
    public String getShareFlightNo()
    {
      return this.X;
    }
    
    public String getSuppliedBy()
    {
      return this.ad;
    }
    
    public String getVeryZhunReadyArrtimeDate()
    {
      return this.ab;
    }
    
    public String getVeryZhunReadyDeptimeDate()
    {
      return this.Z;
    }
    
    public boolean hasAirline()
    {
      return this.e;
    }
    
    public boolean hasAirlineCode()
    {
      return this.c;
    }
    
    public boolean hasArrivalAirport()
    {
      return this.u;
    }
    
    public boolean hasArrivalAirportName()
    {
      return this.w;
    }
    
    public boolean hasArrivalAirportNameAbbrev()
    {
      return this.K;
    }
    
    public boolean hasArrivalCityCode()
    {
      return this.y;
    }
    
    public boolean hasArrivalCityName()
    {
      return this.A;
    }
    
    public boolean hasArrivalTerminal()
    {
      return this.C;
    }
    
    public boolean hasArrivalTime()
    {
      return this.s;
    }
    
    public boolean hasArrivalTimeStr()
    {
      return this.G;
    }
    
    public boolean hasBaggageId()
    {
      return this.U;
    }
    
    public boolean hasBoardGate()
    {
      return this.S;
    }
    
    public boolean hasCheckinTable()
    {
      return this.O;
    }
    
    public boolean hasDepartAirport()
    {
      return this.i;
    }
    
    public boolean hasDepartAirportName()
    {
      return this.k;
    }
    
    public boolean hasDepartAirportNameAbbrev()
    {
      return this.I;
    }
    
    public boolean hasDepartCityCode()
    {
      return this.m;
    }
    
    public boolean hasDepartCityName()
    {
      return this.o;
    }
    
    public boolean hasDepartTerminal()
    {
      return this.q;
    }
    
    public boolean hasDepartTime()
    {
      return this.g;
    }
    
    public boolean hasDepartTimeStr()
    {
      return this.E;
    }
    
    public boolean hasEmtimateArrTimeTitle()
    {
      return this.ai;
    }
    
    public boolean hasEstimateDepTimeTitle()
    {
      return this.ag;
    }
    
    public boolean hasFcategory()
    {
      return this.M;
    }
    
    public boolean hasFlightNo()
    {
      return this.a;
    }
    
    public boolean hasFlightState()
    {
      return this.Q;
    }
    
    public boolean hasIsDelay()
    {
      return this.ae;
    }
    
    public boolean hasPlanTimeContent()
    {
      return this.ak;
    }
    
    public boolean hasShareFlightNo()
    {
      return this.W;
    }
    
    public boolean hasSuppliedBy()
    {
      return this.ac;
    }
    
    public boolean hasVeryZhunReadyArrtimeDate()
    {
      return this.aa;
    }
    
    public boolean hasVeryZhunReadyDeptimeDate()
    {
      return this.Y;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public FlightNoDetailData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setFlightNo(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setAirlineCode(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setAirline(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setDepartTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 42: 
          setDepartAirport(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setDepartAirportName(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setDepartCityCode(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setDepartCityName(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setDepartTerminal(paramCodedInputStreamMicro.readString());
          break;
        case 80: 
          setArrivalTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 90: 
          setArrivalAirport(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setArrivalAirportName(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setArrivalCityCode(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setArrivalCityName(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setArrivalTerminal(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setDepartTimeStr(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          setArrivalTimeStr(paramCodedInputStreamMicro.readString());
          break;
        case 146: 
          setDepartAirportNameAbbrev(paramCodedInputStreamMicro.readString());
          break;
        case 154: 
          setArrivalAirportNameAbbrev(paramCodedInputStreamMicro.readString());
          break;
        case 162: 
          setFcategory(paramCodedInputStreamMicro.readString());
          break;
        case 170: 
          setCheckinTable(paramCodedInputStreamMicro.readString());
          break;
        case 178: 
          setFlightState(paramCodedInputStreamMicro.readString());
          break;
        case 186: 
          setBoardGate(paramCodedInputStreamMicro.readString());
          break;
        case 194: 
          setBaggageId(paramCodedInputStreamMicro.readString());
          break;
        case 202: 
          setShareFlightNo(paramCodedInputStreamMicro.readString());
          break;
        case 210: 
          setVeryZhunReadyDeptimeDate(paramCodedInputStreamMicro.readString());
          break;
        case 218: 
          setVeryZhunReadyArrtimeDate(paramCodedInputStreamMicro.readString());
          break;
        case 226: 
          setSuppliedBy(paramCodedInputStreamMicro.readString());
          break;
        case 232: 
          setIsDelay(paramCodedInputStreamMicro.readInt32());
          break;
        case 242: 
          setEstimateDepTimeTitle(paramCodedInputStreamMicro.readString());
          break;
        case 250: 
          setEmtimateArrTimeTitle(paramCodedInputStreamMicro.readString());
          break;
        case 258: 
          setPlanTimeContent(paramCodedInputStreamMicro.readString());
          break;
        case 266: 
          TaResponse.FlightTimeContent localFlightTimeContent = new TaResponse.FlightTimeContent();
          paramCodedInputStreamMicro.readMessage(localFlightTimeContent);
          addFlightTimeContent(localFlightTimeContent);
        }
      }
    }
    
    public FlightNoDetailData setAirline(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public FlightNoDetailData setAirlineCode(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public FlightNoDetailData setArrivalAirport(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public FlightNoDetailData setArrivalAirportName(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public FlightNoDetailData setArrivalAirportNameAbbrev(String paramString)
    {
      this.K = true;
      this.L = paramString;
      return this;
    }
    
    public FlightNoDetailData setArrivalCityCode(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public FlightNoDetailData setArrivalCityName(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public FlightNoDetailData setArrivalTerminal(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public FlightNoDetailData setArrivalTime(long paramLong)
    {
      this.s = true;
      this.t = paramLong;
      return this;
    }
    
    public FlightNoDetailData setArrivalTimeStr(String paramString)
    {
      this.G = true;
      this.H = paramString;
      return this;
    }
    
    public FlightNoDetailData setBaggageId(String paramString)
    {
      this.U = true;
      this.V = paramString;
      return this;
    }
    
    public FlightNoDetailData setBoardGate(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }
    
    public FlightNoDetailData setCheckinTable(String paramString)
    {
      this.O = true;
      this.P = paramString;
      return this;
    }
    
    public FlightNoDetailData setDepartAirport(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public FlightNoDetailData setDepartAirportName(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public FlightNoDetailData setDepartAirportNameAbbrev(String paramString)
    {
      this.I = true;
      this.J = paramString;
      return this;
    }
    
    public FlightNoDetailData setDepartCityCode(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public FlightNoDetailData setDepartCityName(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public FlightNoDetailData setDepartTerminal(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public FlightNoDetailData setDepartTime(long paramLong)
    {
      this.g = true;
      this.h = paramLong;
      return this;
    }
    
    public FlightNoDetailData setDepartTimeStr(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public FlightNoDetailData setEmtimateArrTimeTitle(String paramString)
    {
      this.ai = true;
      this.aj = paramString;
      return this;
    }
    
    public FlightNoDetailData setEstimateDepTimeTitle(String paramString)
    {
      this.ag = true;
      this.ah = paramString;
      return this;
    }
    
    public FlightNoDetailData setFcategory(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }
    
    public FlightNoDetailData setFlightNo(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public FlightNoDetailData setFlightState(String paramString)
    {
      this.Q = true;
      this.R = paramString;
      return this;
    }
    
    public FlightNoDetailData setFlightTimeContent(int paramInt, TaResponse.FlightTimeContent paramFlightTimeContent)
    {
      if (paramFlightTimeContent == null) {
        return this;
      }
      this.am.set(paramInt, paramFlightTimeContent);
      return this;
    }
    
    public FlightNoDetailData setIsDelay(int paramInt)
    {
      this.ae = true;
      this.af = paramInt;
      return this;
    }
    
    public FlightNoDetailData setPlanTimeContent(String paramString)
    {
      this.ak = true;
      this.al = paramString;
      return this;
    }
    
    public FlightNoDetailData setShareFlightNo(String paramString)
    {
      this.W = true;
      this.X = paramString;
      return this;
    }
    
    public FlightNoDetailData setSuppliedBy(String paramString)
    {
      this.ac = true;
      this.ad = paramString;
      return this;
    }
    
    public FlightNoDetailData setVeryZhunReadyArrtimeDate(String paramString)
    {
      this.aa = true;
      this.ab = paramString;
      return this;
    }
    
    public FlightNoDetailData setVeryZhunReadyDeptimeDate(String paramString)
    {
      this.Y = true;
      this.Z = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasFlightNo()) {
        paramCodedOutputStreamMicro.writeString(1, getFlightNo());
      }
      if (hasAirlineCode()) {
        paramCodedOutputStreamMicro.writeString(2, getAirlineCode());
      }
      if (hasAirline()) {
        paramCodedOutputStreamMicro.writeString(3, getAirline());
      }
      if (hasDepartTime()) {
        paramCodedOutputStreamMicro.writeInt64(4, getDepartTime());
      }
      if (hasDepartAirport()) {
        paramCodedOutputStreamMicro.writeString(5, getDepartAirport());
      }
      if (hasDepartAirportName()) {
        paramCodedOutputStreamMicro.writeString(6, getDepartAirportName());
      }
      if (hasDepartCityCode()) {
        paramCodedOutputStreamMicro.writeString(7, getDepartCityCode());
      }
      if (hasDepartCityName()) {
        paramCodedOutputStreamMicro.writeString(8, getDepartCityName());
      }
      if (hasDepartTerminal()) {
        paramCodedOutputStreamMicro.writeString(9, getDepartTerminal());
      }
      if (hasArrivalTime()) {
        paramCodedOutputStreamMicro.writeInt64(10, getArrivalTime());
      }
      if (hasArrivalAirport()) {
        paramCodedOutputStreamMicro.writeString(11, getArrivalAirport());
      }
      if (hasArrivalAirportName()) {
        paramCodedOutputStreamMicro.writeString(12, getArrivalAirportName());
      }
      if (hasArrivalCityCode()) {
        paramCodedOutputStreamMicro.writeString(13, getArrivalCityCode());
      }
      if (hasArrivalCityName()) {
        paramCodedOutputStreamMicro.writeString(14, getArrivalCityName());
      }
      if (hasArrivalTerminal()) {
        paramCodedOutputStreamMicro.writeString(15, getArrivalTerminal());
      }
      if (hasDepartTimeStr()) {
        paramCodedOutputStreamMicro.writeString(16, getDepartTimeStr());
      }
      if (hasArrivalTimeStr()) {
        paramCodedOutputStreamMicro.writeString(17, getArrivalTimeStr());
      }
      if (hasDepartAirportNameAbbrev()) {
        paramCodedOutputStreamMicro.writeString(18, getDepartAirportNameAbbrev());
      }
      if (hasArrivalAirportNameAbbrev()) {
        paramCodedOutputStreamMicro.writeString(19, getArrivalAirportNameAbbrev());
      }
      if (hasFcategory()) {
        paramCodedOutputStreamMicro.writeString(20, getFcategory());
      }
      if (hasCheckinTable()) {
        paramCodedOutputStreamMicro.writeString(21, getCheckinTable());
      }
      if (hasFlightState()) {
        paramCodedOutputStreamMicro.writeString(22, getFlightState());
      }
      if (hasBoardGate()) {
        paramCodedOutputStreamMicro.writeString(23, getBoardGate());
      }
      if (hasBaggageId()) {
        paramCodedOutputStreamMicro.writeString(24, getBaggageId());
      }
      if (hasShareFlightNo()) {
        paramCodedOutputStreamMicro.writeString(25, getShareFlightNo());
      }
      if (hasVeryZhunReadyDeptimeDate()) {
        paramCodedOutputStreamMicro.writeString(26, getVeryZhunReadyDeptimeDate());
      }
      if (hasVeryZhunReadyArrtimeDate()) {
        paramCodedOutputStreamMicro.writeString(27, getVeryZhunReadyArrtimeDate());
      }
      if (hasSuppliedBy()) {
        paramCodedOutputStreamMicro.writeString(28, getSuppliedBy());
      }
      if (hasIsDelay()) {
        paramCodedOutputStreamMicro.writeInt32(29, getIsDelay());
      }
      if (hasEstimateDepTimeTitle()) {
        paramCodedOutputStreamMicro.writeString(30, getEstimateDepTimeTitle());
      }
      if (hasEmtimateArrTimeTitle()) {
        paramCodedOutputStreamMicro.writeString(31, getEmtimateArrTimeTitle());
      }
      if (hasPlanTimeContent()) {
        paramCodedOutputStreamMicro.writeString(32, getPlanTimeContent());
      }
      Iterator localIterator = getFlightTimeContentList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(33, (TaResponse.FlightTimeContent)localIterator.next());
      }
    }
  }
  
  public static final class FlightNoGroup
    extends MessageMicro
  {
    public static final int FLIGHT_NO_DETAIL_FIELD_NUMBER = 2;
    public static final int FLIGHT_NO_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<TaResponse.FlightNoDetailData> c = Collections.emptyList();
    private int d = -1;
    
    public static FlightNoGroup parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightNoGroup().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightNoGroup parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightNoGroup)new FlightNoGroup().mergeFrom(paramArrayOfByte);
    }
    
    public FlightNoGroup addFlightNoDetail(TaResponse.FlightNoDetailData paramFlightNoDetailData)
    {
      if (paramFlightNoDetailData == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramFlightNoDetailData);
      return this;
    }
    
    public final FlightNoGroup clear()
    {
      clearFlightNo();
      clearFlightNoDetail();
      this.d = -1;
      return this;
    }
    
    public FlightNoGroup clearFlightNo()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public FlightNoGroup clearFlightNoDetail()
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
    
    public String getFlightNo()
    {
      return this.b;
    }
    
    public TaResponse.FlightNoDetailData getFlightNoDetail(int paramInt)
    {
      return (TaResponse.FlightNoDetailData)this.c.get(paramInt);
    }
    
    public int getFlightNoDetailCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.FlightNoDetailData> getFlightNoDetailList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasFlightNo()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFlightNo());
      }
      Iterator localIterator = getFlightNoDetailList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.FlightNoDetailData)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasFlightNo()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return this.a;
    }
    
    public FlightNoGroup mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setFlightNo(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          TaResponse.FlightNoDetailData localFlightNoDetailData = new TaResponse.FlightNoDetailData();
          paramCodedInputStreamMicro.readMessage(localFlightNoDetailData);
          addFlightNoDetail(localFlightNoDetailData);
        }
      }
    }
    
    public FlightNoGroup setFlightNo(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public FlightNoGroup setFlightNoDetail(int paramInt, TaResponse.FlightNoDetailData paramFlightNoDetailData)
    {
      if (paramFlightNoDetailData == null) {
        return this;
      }
      this.c.set(paramInt, paramFlightNoDetailData);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasFlightNo()) {
        paramCodedOutputStreamMicro.writeString(1, getFlightNo());
      }
      Iterator localIterator = getFlightNoDetailList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.FlightNoDetailData)localIterator.next());
      }
    }
  }
  
  public static final class FlightNoSugData
    extends MessageMicro
  {
    public static final int FLIGHT_NO_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private int c = -1;
    
    public static FlightNoSugData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightNoSugData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightNoSugData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightNoSugData)new FlightNoSugData().mergeFrom(paramArrayOfByte);
    }
    
    public final FlightNoSugData clear()
    {
      clearFlightNo();
      this.c = -1;
      return this;
    }
    
    public FlightNoSugData clearFlightNo()
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
    
    public String getFlightNo()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasFlightNo()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFlightNo());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasFlightNo()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return this.a;
    }
    
    public FlightNoSugData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setFlightNo(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public FlightNoSugData setFlightNo(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasFlightNo()) {
        paramCodedOutputStreamMicro.writeString(1, getFlightNo());
      }
    }
  }
  
  public static final class FlightSugData
    extends MessageMicro
  {
    public static final int FLIGHTNO_COUNT_FIELD_NUMBER = 1;
    public static final int FLIGHTNO_LIST_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private List<TaResponse.FlightNoDetailData> c = Collections.emptyList();
    private int d = -1;
    
    public static FlightSugData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightSugData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightSugData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightSugData)new FlightSugData().mergeFrom(paramArrayOfByte);
    }
    
    public FlightSugData addFlightnoList(TaResponse.FlightNoDetailData paramFlightNoDetailData)
    {
      if (paramFlightNoDetailData == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramFlightNoDetailData);
      return this;
    }
    
    public final FlightSugData clear()
    {
      clearFlightnoCount();
      clearFlightnoList();
      this.d = -1;
      return this;
    }
    
    public FlightSugData clearFlightnoCount()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public FlightSugData clearFlightnoList()
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
    
    public int getFlightnoCount()
    {
      return this.b;
    }
    
    public TaResponse.FlightNoDetailData getFlightnoList(int paramInt)
    {
      return (TaResponse.FlightNoDetailData)this.c.get(paramInt);
    }
    
    public int getFlightnoListCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.FlightNoDetailData> getFlightnoListList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasFlightnoCount()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getFlightnoCount());
      }
      Iterator localIterator = getFlightnoListList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.FlightNoDetailData)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasFlightnoCount()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public FlightSugData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setFlightnoCount(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          TaResponse.FlightNoDetailData localFlightNoDetailData = new TaResponse.FlightNoDetailData();
          paramCodedInputStreamMicro.readMessage(localFlightNoDetailData);
          addFlightnoList(localFlightNoDetailData);
        }
      }
    }
    
    public FlightSugData setFlightnoCount(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public FlightSugData setFlightnoList(int paramInt, TaResponse.FlightNoDetailData paramFlightNoDetailData)
    {
      if (paramFlightNoDetailData == null) {
        return this;
      }
      this.c.set(paramInt, paramFlightNoDetailData);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasFlightnoCount()) {
        paramCodedOutputStreamMicro.writeInt32(1, getFlightnoCount());
      }
      Iterator localIterator = getFlightnoListList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.FlightNoDetailData)localIterator.next());
      }
    }
  }
  
  public static final class FlightTimeContent
    extends MessageMicro
  {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static FlightTimeContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new FlightTimeContent().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static FlightTimeContent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (FlightTimeContent)new FlightTimeContent().mergeFrom(paramArrayOfByte);
    }
    
    public final FlightTimeContent clear()
    {
      clearTitle();
      clearContent();
      this.e = -1;
      return this;
    }
    
    public FlightTimeContent clearContent()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public FlightTimeContent clearTitle()
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
    
    public FlightTimeContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
    
    public FlightTimeContent setContent(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public FlightTimeContent setTitle(String paramString)
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
  
  public static final class IsTripUpdate
    extends MessageMicro
  {
    public static final int IS_UPDATE_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private int c = -1;
    
    public static IsTripUpdate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new IsTripUpdate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static IsTripUpdate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (IsTripUpdate)new IsTripUpdate().mergeFrom(paramArrayOfByte);
    }
    
    public final IsTripUpdate clear()
    {
      clearIsUpdate();
      this.c = -1;
      return this;
    }
    
    public IsTripUpdate clearIsUpdate()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.c < 0) {
        getSerializedSize();
      }
      return this.c;
    }
    
    public int getIsUpdate()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasIsUpdate()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsUpdate());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasIsUpdate()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return this.a;
    }
    
    public IsTripUpdate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIsUpdate(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public IsTripUpdate setIsUpdate(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsUpdate()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIsUpdate());
      }
    }
  }
  
  public static final class ML
    extends MessageMicro
  {
    public static final int CLOUD_CONF_FIELD_NUMBER = 7;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 5;
    public static final int DYNAMIC_MAP_DATA_FIELD_NUMBER = 6;
    public static final int ML_DESC_FIELD_NUMBER = 9;
    public static final int ML_HEADER_FIELD_NUMBER = 1;
    public static final int ML_SUGLIST_FIELD_NUMBER = 8;
    public static final int ML_SUG_FIELD_NUMBER = 3;
    public static final int ML_TRIP_GROUP_FIELD_NUMBER = 2;
    public static final int SCENE_ENTRY_FIELD_NUMBER = 4;
    private boolean a;
    private TaResponse.MLHeader b = null;
    private List<TaResponse.MLTripGroup> c = Collections.emptyList();
    private List<TaResponse.MLSug> d = Collections.emptyList();
    private boolean e;
    private TaResponse.SceneEntry f = null;
    private boolean g;
    private TaResponse.VersionInfo h = null;
    private boolean i;
    private ByteStringMicro j = ByteStringMicro.EMPTY;
    private boolean k;
    private TaResponse.CloudConf l = null;
    private List<TaResponse.DriverPageInfo> m = Collections.emptyList();
    private boolean n;
    private TaResponse.MLDesc o = null;
    private int p = -1;
    
    public static ML parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ML().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ML parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ML)new ML().mergeFrom(paramArrayOfByte);
    }
    
    public ML addMlSug(TaResponse.MLSug paramMLSug)
    {
      if (paramMLSug == null) {
        return this;
      }
      if (this.d.isEmpty()) {
        this.d = new ArrayList();
      }
      this.d.add(paramMLSug);
      return this;
    }
    
    public ML addMlSuglist(TaResponse.DriverPageInfo paramDriverPageInfo)
    {
      if (paramDriverPageInfo == null) {
        return this;
      }
      if (this.m.isEmpty()) {
        this.m = new ArrayList();
      }
      this.m.add(paramDriverPageInfo);
      return this;
    }
    
    public ML addMlTripGroup(TaResponse.MLTripGroup paramMLTripGroup)
    {
      if (paramMLTripGroup == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramMLTripGroup);
      return this;
    }
    
    public final ML clear()
    {
      clearMlHeader();
      clearMlTripGroup();
      clearMlSug();
      clearSceneEntry();
      clearConfigVersion();
      clearDynamicMapData();
      clearCloudConf();
      clearMlSuglist();
      clearMlDesc();
      this.p = -1;
      return this;
    }
    
    public ML clearCloudConf()
    {
      this.k = false;
      this.l = null;
      return this;
    }
    
    public ML clearConfigVersion()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public ML clearDynamicMapData()
    {
      this.i = false;
      this.j = ByteStringMicro.EMPTY;
      return this;
    }
    
    public ML clearMlDesc()
    {
      this.n = false;
      this.o = null;
      return this;
    }
    
    public ML clearMlHeader()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public ML clearMlSug()
    {
      this.d = Collections.emptyList();
      return this;
    }
    
    public ML clearMlSuglist()
    {
      this.m = Collections.emptyList();
      return this;
    }
    
    public ML clearMlTripGroup()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public ML clearSceneEntry()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.p < 0) {
        getSerializedSize();
      }
      return this.p;
    }
    
    public TaResponse.CloudConf getCloudConf()
    {
      return this.l;
    }
    
    public TaResponse.VersionInfo getConfigVersion()
    {
      return this.h;
    }
    
    public ByteStringMicro getDynamicMapData()
    {
      return this.j;
    }
    
    public TaResponse.MLDesc getMlDesc()
    {
      return this.o;
    }
    
    public TaResponse.MLHeader getMlHeader()
    {
      return this.b;
    }
    
    public TaResponse.MLSug getMlSug(int paramInt)
    {
      return (TaResponse.MLSug)this.d.get(paramInt);
    }
    
    public int getMlSugCount()
    {
      return this.d.size();
    }
    
    public List<TaResponse.MLSug> getMlSugList()
    {
      return this.d;
    }
    
    public TaResponse.DriverPageInfo getMlSuglist(int paramInt)
    {
      return (TaResponse.DriverPageInfo)this.m.get(paramInt);
    }
    
    public int getMlSuglistCount()
    {
      return this.m.size();
    }
    
    public List<TaResponse.DriverPageInfo> getMlSuglistList()
    {
      return this.m;
    }
    
    public TaResponse.MLTripGroup getMlTripGroup(int paramInt)
    {
      return (TaResponse.MLTripGroup)this.c.get(paramInt);
    }
    
    public int getMlTripGroupCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.MLTripGroup> getMlTripGroupList()
    {
      return this.c;
    }
    
    public TaResponse.SceneEntry getSceneEntry()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasMlHeader()) {
        i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMlHeader());
      }
      Iterator localIterator = getMlTripGroupList().iterator();
      for (int i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.MLTripGroup)localIterator.next()) + i2) {}
      localIterator = getMlSugList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(3, (TaResponse.MLSug)localIterator.next());
      }
      i1 = i2;
      if (hasSceneEntry()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getSceneEntry());
      }
      i2 = i1;
      if (hasConfigVersion()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(5, getConfigVersion());
      }
      i1 = i2;
      if (hasDynamicMapData()) {
        i1 = i2 + CodedOutputStreamMicro.computeBytesSize(6, getDynamicMapData());
      }
      i2 = i1;
      if (hasCloudConf()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(7, getCloudConf());
      }
      localIterator = getMlSuglistList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(8, (TaResponse.DriverPageInfo)localIterator.next());
      }
      i1 = i2;
      if (hasMlDesc()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(9, getMlDesc());
      }
      this.p = i1;
      return i1;
    }
    
    public boolean hasCloudConf()
    {
      return this.k;
    }
    
    public boolean hasConfigVersion()
    {
      return this.g;
    }
    
    public boolean hasDynamicMapData()
    {
      return this.i;
    }
    
    public boolean hasMlDesc()
    {
      return this.n;
    }
    
    public boolean hasMlHeader()
    {
      return this.a;
    }
    
    public boolean hasSceneEntry()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      if ((hasMlHeader()) && (!getMlHeader().isInitialized())) {
        return false;
      }
      Iterator localIterator = getMlTripGroupList().iterator();
      while (localIterator.hasNext()) {
        if (!((TaResponse.MLTripGroup)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      localIterator = getMlSugList().iterator();
      while (localIterator.hasNext()) {
        if (!((TaResponse.MLSug)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public ML mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new TaResponse.MLHeader();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setMlHeader((TaResponse.MLHeader)localObject);
          break;
        case 18: 
          localObject = new TaResponse.MLTripGroup();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addMlTripGroup((TaResponse.MLTripGroup)localObject);
          break;
        case 26: 
          localObject = new TaResponse.MLSug();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addMlSug((TaResponse.MLSug)localObject);
          break;
        case 34: 
          localObject = new TaResponse.SceneEntry();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setSceneEntry((TaResponse.SceneEntry)localObject);
          break;
        case 42: 
          localObject = new TaResponse.VersionInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setConfigVersion((TaResponse.VersionInfo)localObject);
          break;
        case 50: 
          setDynamicMapData(paramCodedInputStreamMicro.readBytes());
          break;
        case 58: 
          localObject = new TaResponse.CloudConf();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCloudConf((TaResponse.CloudConf)localObject);
          break;
        case 66: 
          localObject = new TaResponse.DriverPageInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addMlSuglist((TaResponse.DriverPageInfo)localObject);
          break;
        case 74: 
          localObject = new TaResponse.MLDesc();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setMlDesc((TaResponse.MLDesc)localObject);
        }
      }
    }
    
    public ML setCloudConf(TaResponse.CloudConf paramCloudConf)
    {
      if (paramCloudConf == null) {
        return clearCloudConf();
      }
      this.k = true;
      this.l = paramCloudConf;
      return this;
    }
    
    public ML setConfigVersion(TaResponse.VersionInfo paramVersionInfo)
    {
      if (paramVersionInfo == null) {
        return clearConfigVersion();
      }
      this.g = true;
      this.h = paramVersionInfo;
      return this;
    }
    
    public ML setDynamicMapData(ByteStringMicro paramByteStringMicro)
    {
      this.i = true;
      this.j = paramByteStringMicro;
      return this;
    }
    
    public ML setMlDesc(TaResponse.MLDesc paramMLDesc)
    {
      if (paramMLDesc == null) {
        return clearMlDesc();
      }
      this.n = true;
      this.o = paramMLDesc;
      return this;
    }
    
    public ML setMlHeader(TaResponse.MLHeader paramMLHeader)
    {
      if (paramMLHeader == null) {
        return clearMlHeader();
      }
      this.a = true;
      this.b = paramMLHeader;
      return this;
    }
    
    public ML setMlSug(int paramInt, TaResponse.MLSug paramMLSug)
    {
      if (paramMLSug == null) {
        return this;
      }
      this.d.set(paramInt, paramMLSug);
      return this;
    }
    
    public ML setMlSuglist(int paramInt, TaResponse.DriverPageInfo paramDriverPageInfo)
    {
      if (paramDriverPageInfo == null) {
        return this;
      }
      this.m.set(paramInt, paramDriverPageInfo);
      return this;
    }
    
    public ML setMlTripGroup(int paramInt, TaResponse.MLTripGroup paramMLTripGroup)
    {
      if (paramMLTripGroup == null) {
        return this;
      }
      this.c.set(paramInt, paramMLTripGroup);
      return this;
    }
    
    public ML setSceneEntry(TaResponse.SceneEntry paramSceneEntry)
    {
      if (paramSceneEntry == null) {
        return clearSceneEntry();
      }
      this.e = true;
      this.f = paramSceneEntry;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasMlHeader()) {
        paramCodedOutputStreamMicro.writeMessage(1, getMlHeader());
      }
      Iterator localIterator = getMlTripGroupList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.MLTripGroup)localIterator.next());
      }
      localIterator = getMlSugList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (TaResponse.MLSug)localIterator.next());
      }
      if (hasSceneEntry()) {
        paramCodedOutputStreamMicro.writeMessage(4, getSceneEntry());
      }
      if (hasConfigVersion()) {
        paramCodedOutputStreamMicro.writeMessage(5, getConfigVersion());
      }
      if (hasDynamicMapData()) {
        paramCodedOutputStreamMicro.writeBytes(6, getDynamicMapData());
      }
      if (hasCloudConf()) {
        paramCodedOutputStreamMicro.writeMessage(7, getCloudConf());
      }
      localIterator = getMlSuglistList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (TaResponse.DriverPageInfo)localIterator.next());
      }
      if (hasMlDesc()) {
        paramCodedOutputStreamMicro.writeMessage(9, getMlDesc());
      }
    }
  }
  
  public static final class MLDesc
    extends MessageMicro
  {
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int JUMP_URL_FIELD_NUMBER = 2;
    public static final int SUB_TITLE_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static MLDesc parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLDesc().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLDesc parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLDesc)new MLDesc().mergeFrom(paramArrayOfByte);
    }
    
    public final MLDesc clear()
    {
      clearIcon();
      clearJumpUrl();
      clearTitle();
      clearSubTitle();
      this.i = -1;
      return this;
    }
    
    public MLDesc clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLDesc clearJumpUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLDesc clearSubTitle()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLDesc clearTitle()
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
    
    public String getIcon()
    {
      return this.b;
    }
    
    public String getJumpUrl()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasIcon()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
      }
      int j = k;
      if (hasJumpUrl()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getJumpUrl());
      }
      k = j;
      if (hasTitle()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getTitle());
      }
      j = k;
      if (hasSubTitle()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getSubTitle());
      }
      this.i = j;
      return j;
    }
    
    public String getSubTitle()
    {
      return this.h;
    }
    
    public String getTitle()
    {
      return this.f;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasJumpUrl()
    {
      return this.c;
    }
    
    public boolean hasSubTitle()
    {
      return this.g;
    }
    
    public boolean hasTitle()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MLDesc mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setSubTitle(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLDesc setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLDesc setJumpUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLDesc setSubTitle(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLDesc setTitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getJumpUrl());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getTitle());
      }
      if (hasSubTitle()) {
        paramCodedOutputStreamMicro.writeString(4, getSubTitle());
      }
    }
  }
  
  public static final class MLHeader
    extends MessageMicro
  {
    public static final int LOC_FIELD_NUMBER = 2;
    public static final int ML_HEADER_WEATHER_FIELD_NUMBER = 1;
    private boolean a;
    private TaResponse.MLHeaderWeather b = null;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static MLHeader parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLHeader().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLHeader parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLHeader)new MLHeader().mergeFrom(paramArrayOfByte);
    }
    
    public final MLHeader clear()
    {
      clearMlHeaderWeather();
      clearLoc();
      this.e = -1;
      return this;
    }
    
    public MLHeader clearLoc()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLHeader clearMlHeaderWeather()
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
    
    public String getLoc()
    {
      return this.d;
    }
    
    public TaResponse.MLHeaderWeather getMlHeaderWeather()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasMlHeaderWeather()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMlHeaderWeather());
      }
      int j = i;
      if (hasLoc()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getLoc());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasLoc()
    {
      return this.c;
    }
    
    public boolean hasMlHeaderWeather()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!getMlHeaderWeather().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public MLHeader mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.MLHeaderWeather localMLHeaderWeather = new TaResponse.MLHeaderWeather();
          paramCodedInputStreamMicro.readMessage(localMLHeaderWeather);
          setMlHeaderWeather(localMLHeaderWeather);
          break;
        case 18: 
          setLoc(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLHeader setLoc(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLHeader setMlHeaderWeather(TaResponse.MLHeaderWeather paramMLHeaderWeather)
    {
      if (paramMLHeaderWeather == null) {
        return clearMlHeaderWeather();
      }
      this.a = true;
      this.b = paramMLHeaderWeather;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasMlHeaderWeather()) {
        paramCodedOutputStreamMicro.writeMessage(1, getMlHeaderWeather());
      }
      if (hasLoc()) {
        paramCodedOutputStreamMicro.writeString(2, getLoc());
      }
    }
  }
  
  public static final class MLHeaderWeather
    extends MessageMicro
  {
    public static final int CARLIMIT_INFO_FIELD_NUMBER = 10;
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int JUMP_URL_FIELD_NUMBER = 5;
    public static final int NEW_ICON_FIELD_NUMBER = 8;
    public static final int PM25_FIELD_NUMBER = 4;
    public static final int SCHEME_FIELD_NUMBER = 3;
    public static final int TEMP_RANGE_FIELD_NUMBER = 7;
    public static final int TEXT_FIELD_NUMBER = 2;
    public static final int WEATHER_FIELD_NUMBER = 6;
    public static final int WEATHER_WARNING_FIELD_NUMBER = 9;
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
    private TaResponse.BaseTitleContent r = null;
    private boolean s;
    private TaResponse.BaseTitleContent t = null;
    private int u = -1;
    
    public static MLHeaderWeather parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLHeaderWeather().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLHeaderWeather parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLHeaderWeather)new MLHeaderWeather().mergeFrom(paramArrayOfByte);
    }
    
    public final MLHeaderWeather clear()
    {
      clearIcon();
      clearText();
      clearScheme();
      clearPm25();
      clearJumpUrl();
      clearWeather();
      clearTempRange();
      clearNewIcon();
      clearWeatherWarning();
      clearCarlimitInfo();
      this.u = -1;
      return this;
    }
    
    public MLHeaderWeather clearCarlimitInfo()
    {
      this.s = false;
      this.t = null;
      return this;
    }
    
    public MLHeaderWeather clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLHeaderWeather clearJumpUrl()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public MLHeaderWeather clearNewIcon()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public MLHeaderWeather clearPm25()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLHeaderWeather clearScheme()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLHeaderWeather clearTempRange()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public MLHeaderWeather clearText()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLHeaderWeather clearWeather()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public MLHeaderWeather clearWeatherWarning()
    {
      this.q = false;
      this.r = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.u < 0) {
        getSerializedSize();
      }
      return this.u;
    }
    
    public TaResponse.BaseTitleContent getCarlimitInfo()
    {
      return this.t;
    }
    
    public String getIcon()
    {
      return this.b;
    }
    
    public String getJumpUrl()
    {
      return this.j;
    }
    
    public String getNewIcon()
    {
      return this.p;
    }
    
    public String getPm25()
    {
      return this.h;
    }
    
    public String getScheme()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasIcon()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
      }
      int i1 = i2;
      if (hasText()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getText());
      }
      i2 = i1;
      if (hasScheme()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getScheme());
      }
      i1 = i2;
      if (hasPm25()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getPm25());
      }
      i2 = i1;
      if (hasJumpUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getJumpUrl());
      }
      i1 = i2;
      if (hasWeather()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getWeather());
      }
      i2 = i1;
      if (hasTempRange()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getTempRange());
      }
      i1 = i2;
      if (hasNewIcon()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getNewIcon());
      }
      i2 = i1;
      if (hasWeatherWarning()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(9, getWeatherWarning());
      }
      i1 = i2;
      if (hasCarlimitInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(10, getCarlimitInfo());
      }
      this.u = i1;
      return i1;
    }
    
    public String getTempRange()
    {
      return this.n;
    }
    
    public String getText()
    {
      return this.d;
    }
    
    public String getWeather()
    {
      return this.l;
    }
    
    public TaResponse.BaseTitleContent getWeatherWarning()
    {
      return this.r;
    }
    
    public boolean hasCarlimitInfo()
    {
      return this.s;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasJumpUrl()
    {
      return this.i;
    }
    
    public boolean hasNewIcon()
    {
      return this.o;
    }
    
    public boolean hasPm25()
    {
      return this.g;
    }
    
    public boolean hasScheme()
    {
      return this.e;
    }
    
    public boolean hasTempRange()
    {
      return this.m;
    }
    
    public boolean hasText()
    {
      return this.c;
    }
    
    public boolean hasWeather()
    {
      return this.k;
    }
    
    public boolean hasWeatherWarning()
    {
      return this.q;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while (!this.c) {
        return false;
      }
      return true;
    }
    
    public MLHeaderWeather mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      for (;;)
      {
        int i1 = paramCodedInputStreamMicro.readTag();
        TaResponse.BaseTitleContent localBaseTitleContent;
        switch (i1)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i1)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setText(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setScheme(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setPm25(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setWeather(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setTempRange(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setNewIcon(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          localBaseTitleContent = new TaResponse.BaseTitleContent();
          paramCodedInputStreamMicro.readMessage(localBaseTitleContent);
          setWeatherWarning(localBaseTitleContent);
          break;
        case 82: 
          localBaseTitleContent = new TaResponse.BaseTitleContent();
          paramCodedInputStreamMicro.readMessage(localBaseTitleContent);
          setCarlimitInfo(localBaseTitleContent);
        }
      }
    }
    
    public MLHeaderWeather setCarlimitInfo(TaResponse.BaseTitleContent paramBaseTitleContent)
    {
      if (paramBaseTitleContent == null) {
        return clearCarlimitInfo();
      }
      this.s = true;
      this.t = paramBaseTitleContent;
      return this;
    }
    
    public MLHeaderWeather setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLHeaderWeather setJumpUrl(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public MLHeaderWeather setNewIcon(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public MLHeaderWeather setPm25(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLHeaderWeather setScheme(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLHeaderWeather setTempRange(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public MLHeaderWeather setText(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLHeaderWeather setWeather(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public MLHeaderWeather setWeatherWarning(TaResponse.BaseTitleContent paramBaseTitleContent)
    {
      if (paramBaseTitleContent == null) {
        return clearWeatherWarning();
      }
      this.q = true;
      this.r = paramBaseTitleContent;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      if (hasText()) {
        paramCodedOutputStreamMicro.writeString(2, getText());
      }
      if (hasScheme()) {
        paramCodedOutputStreamMicro.writeString(3, getScheme());
      }
      if (hasPm25()) {
        paramCodedOutputStreamMicro.writeString(4, getPm25());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(5, getJumpUrl());
      }
      if (hasWeather()) {
        paramCodedOutputStreamMicro.writeString(6, getWeather());
      }
      if (hasTempRange()) {
        paramCodedOutputStreamMicro.writeString(7, getTempRange());
      }
      if (hasNewIcon()) {
        paramCodedOutputStreamMicro.writeString(8, getNewIcon());
      }
      if (hasWeatherWarning()) {
        paramCodedOutputStreamMicro.writeMessage(9, getWeatherWarning());
      }
      if (hasCarlimitInfo()) {
        paramCodedOutputStreamMicro.writeMessage(10, getCarlimitInfo());
      }
    }
  }
  
  public static final class MLSug
    extends MessageMicro
  {
    public static final int DESC_FIELD_NUMBER = 4;
    public static final int ICON_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int UID_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static MLSug parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLSug().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLSug parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLSug)new MLSug().mergeFrom(paramArrayOfByte);
    }
    
    public final MLSug clear()
    {
      clearUid();
      clearName();
      clearIcon();
      clearDesc();
      this.i = -1;
      return this;
    }
    
    public MLSug clearDesc()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLSug clearIcon()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLSug clearName()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLSug clearUid()
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
    
    public String getDesc()
    {
      return this.h;
    }
    
    public String getIcon()
    {
      return this.f;
    }
    
    public String getName()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasUid()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
      }
      int j = k;
      if (hasName()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getName());
      }
      k = j;
      if (hasIcon()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getIcon());
      }
      j = k;
      if (hasDesc()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getDesc());
      }
      this.i = j;
      return j;
    }
    
    public String getUid()
    {
      return this.b;
    }
    
    public boolean hasDesc()
    {
      return this.g;
    }
    
    public boolean hasIcon()
    {
      return this.e;
    }
    
    public boolean hasName()
    {
      return this.c;
    }
    
    public boolean hasUid()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g)) {
        return false;
      }
      return true;
    }
    
    public MLSug mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setDesc(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLSug setDesc(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLSug setIcon(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLSug setName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLSug setUid(String paramString)
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
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(2, getName());
      }
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(3, getIcon());
      }
      if (hasDesc()) {
        paramCodedOutputStreamMicro.writeString(4, getDesc());
      }
    }
  }
  
  public static final class MLTrip
    extends MessageMicro
  {
    public static final int ARRIVAL_TIME_FIELD_NUMBER = 7;
    public static final int CARD_RESOURCE_FIELD_NUMBER = 11;
    public static final int COST_TIME_FIELD_NUMBER = 40;
    public static final int CREATE_INFO_FIELD_NUMBER = 12;
    public static final int DETAIL_URL_FIELD_NUMBER = 20;
    public static final int END_POINT_FIELD_NUMBER = 10;
    public static final int END_POINT_SUB_TITLE_FIELD_NUMBER = 46;
    public static final int END_POINT_TITLE_FIELD_NUMBER = 39;
    public static final int EVENT_TRIP_TITLE_FIELD_NUMBER = 41;
    public static final int FLIGHT_INFO_FIELD_NUMBER = 19;
    public static final int GUIDE_REMARK_FIELD_NUMBER = 17;
    public static final int ICON_INFO_FIELD_NUMBER = 21;
    public static final int IS_CROSS_FIELD_NUMBER = 16;
    public static final int IS_OLD_FIELD_NUMBER = 44;
    public static final int IS_REMIND_FIELD_NUMBER = 6;
    public static final int IS_REPEAT_FIELD_NUMBER = 29;
    public static final int IS_SHOW_ROUTE_MAP_FIELD_NUMBER = 27;
    public static final int IS_WHOLEDAY_FIELD_NUMBER = 51;
    public static final int JUMP_CONTENT_FIELD_NUMBER = 36;
    public static final int JUMP_URL_FIELD_NUMBER = 37;
    public static final int REMARK_FIELD_NUMBER = 3;
    public static final int REPEAT_DEADLINE_FIELD_NUMBER = 49;
    public static final int REPEAT_TIMESTAMP_FIELD_NUMBER = 31;
    public static final int REPEAT_TYPE_FIELD_NUMBER = 48;
    public static final int ROUTE_INFO_FIELD_NUMBER = 8;
    public static final int SRC_FROM_FIELD_NUMBER = 50;
    public static final int START_POINT_FIELD_NUMBER = 9;
    public static final int START_POINT_SUB_TITLE_FIELD_NUMBER = 45;
    public static final int START_POINT_TITLE_FIELD_NUMBER = 38;
    public static final int START_TIME_FIELD_NUMBER = 14;
    public static final int STATUS_FIELD_NUMBER = 4;
    public static final int SUB_TRIP_TYPE_FIELD_NUMBER = 30;
    public static final int SUG_CARD_FIELD_NUMBER = 28;
    public static final int SUG_TIME_FIELD_NUMBER = 5;
    public static final int TIME_TYPE_FIELD_NUMBER = 15;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TITLE_TYPE_FIELD_NUMBER = 43;
    public static final int TITLE_URL_FIELD_NUMBER = 32;
    public static final int TRAIN_INFO_FIELD_NUMBER = 18;
    public static final int TRIP_ADDR_TITLE_FIELD_NUMBER = 23;
    public static final int TRIP_CARD_TITLE_FIELD_NUMBER = 22;
    public static final int TRIP_DESC_FIELD_NUMBER = 47;
    public static final int TRIP_ENDTIME_CONTENT_FIELD_NUMBER = 35;
    public static final int TRIP_ICON_URL_FIELD_NUMBER = 26;
    public static final int TRIP_ID_FIELD_NUMBER = 1;
    public static final int TRIP_NEW_ICON_URL_FIELD_NUMBER = 42;
    public static final int TRIP_ROUTE_TITLE_FIELD_NUMBER = 25;
    public static final int TRIP_STARTTIME_CONTENT_FIELD_NUMBER = 34;
    public static final int TRIP_TIME_CONTENT_FIELD_NUMBER = 33;
    public static final int TRIP_TIME_TITLE_FIELD_NUMBER = 24;
    public static final int TRIP_TYPE_FIELD_NUMBER = 13;
    private boolean A;
    private long B = 0L;
    private boolean C;
    private long D = 0L;
    private boolean E;
    private int F = 0;
    private boolean G;
    private String H = "";
    private boolean I;
    private TaResponse.MLTripTrainInfo J = null;
    private boolean K;
    private TaResponse.MLTripFlightInfo L = null;
    private boolean M;
    private String N = "";
    private boolean O;
    private TaResponse.MLTripCardIconInfo P = null;
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
    private String aA = "";
    private boolean aB;
    private String aC = "";
    private boolean aD;
    private String aE = "";
    private boolean aF;
    private String aG = "";
    private boolean aH;
    private int aI = 0;
    private boolean aJ;
    private String aK = "";
    private boolean aL;
    private String aM = "";
    private boolean aN;
    private String aO = "";
    private boolean aP;
    private String aQ = "";
    private boolean aR;
    private long aS = 0L;
    private boolean aT;
    private String aU = "";
    private boolean aV;
    private int aW = 0;
    private int aX = -1;
    private boolean aa;
    private int ab = 0;
    private List<TaResponse.MLTripSugInfo> ac = Collections.emptyList();
    private boolean ad;
    private int ae = 0;
    private boolean af;
    private long ag = 0L;
    private boolean ah;
    private long ai = 0L;
    private boolean aj;
    private String ak = "";
    private boolean al;
    private String am = "";
    private boolean an;
    private String ao = "";
    private boolean ap;
    private String aq = "";
    private boolean ar;
    private String as = "";
    private boolean at;
    private String au = "";
    private boolean av;
    private String aw = "";
    private boolean ax;
    private String ay = "";
    private boolean az;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private int h = 0;
    private boolean i;
    private long j = 0L;
    private boolean k;
    private int l = 0;
    private boolean m;
    private long n = 0L;
    private boolean o;
    private String p = "";
    private boolean q;
    private TaResponse.MLTripPoint r = null;
    private boolean s;
    private TaResponse.MLTripPoint t = null;
    private boolean u;
    private TaResponse.MLTripCardResource v = null;
    private boolean w;
    private TaResponse.MLTripCreateInfo x = null;
    private boolean y;
    private long z = 0L;
    
    public static MLTrip parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTrip().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTrip parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTrip)new MLTrip().mergeFrom(paramArrayOfByte);
    }
    
    public MLTrip addSugCard(TaResponse.MLTripSugInfo paramMLTripSugInfo)
    {
      if (paramMLTripSugInfo == null) {
        return this;
      }
      if (this.ac.isEmpty()) {
        this.ac = new ArrayList();
      }
      this.ac.add(paramMLTripSugInfo);
      return this;
    }
    
    public final MLTrip clear()
    {
      clearTripId();
      clearTitle();
      clearRemark();
      clearStatus();
      clearSugTime();
      clearIsRemind();
      clearArrivalTime();
      clearRouteInfo();
      clearStartPoint();
      clearEndPoint();
      clearCardResource();
      clearCreateInfo();
      clearTripType();
      clearStartTime();
      clearTimeType();
      clearIsCross();
      clearGuideRemark();
      clearTrainInfo();
      clearFlightInfo();
      clearDetailUrl();
      clearIconInfo();
      clearTripCardTitle();
      clearTripAddrTitle();
      clearTripTimeTitle();
      clearTripRouteTitle();
      clearTripIconUrl();
      clearIsShowRouteMap();
      clearSugCard();
      clearIsRepeat();
      clearSubTripType();
      clearRepeatTimestamp();
      clearTitleUrl();
      clearTripTimeContent();
      clearTripStarttimeContent();
      clearTripEndtimeContent();
      clearJumpContent();
      clearJumpUrl();
      clearStartPointTitle();
      clearEndPointTitle();
      clearCostTime();
      clearEventTripTitle();
      clearTripNewIconUrl();
      clearTitleType();
      clearIsOld();
      clearStartPointSubTitle();
      clearEndPointSubTitle();
      clearTripDesc();
      clearRepeatType();
      clearRepeatDeadline();
      clearSrcFrom();
      clearIsWholeday();
      this.aX = -1;
      return this;
    }
    
    public MLTrip clearArrivalTime()
    {
      this.m = false;
      this.n = 0L;
      return this;
    }
    
    public MLTrip clearCardResource()
    {
      this.u = false;
      this.v = null;
      return this;
    }
    
    public MLTrip clearCostTime()
    {
      this.az = false;
      this.aA = "";
      return this;
    }
    
    public MLTrip clearCreateInfo()
    {
      this.w = false;
      this.x = null;
      return this;
    }
    
    public MLTrip clearDetailUrl()
    {
      this.M = false;
      this.N = "";
      return this;
    }
    
    public MLTrip clearEndPoint()
    {
      this.s = false;
      this.t = null;
      return this;
    }
    
    public MLTrip clearEndPointSubTitle()
    {
      this.aL = false;
      this.aM = "";
      return this;
    }
    
    public MLTrip clearEndPointTitle()
    {
      this.ax = false;
      this.ay = "";
      return this;
    }
    
    public MLTrip clearEventTripTitle()
    {
      this.aB = false;
      this.aC = "";
      return this;
    }
    
    public MLTrip clearFlightInfo()
    {
      this.K = false;
      this.L = null;
      return this;
    }
    
    public MLTrip clearGuideRemark()
    {
      this.G = false;
      this.H = "";
      return this;
    }
    
    public MLTrip clearIconInfo()
    {
      this.O = false;
      this.P = null;
      return this;
    }
    
    public MLTrip clearIsCross()
    {
      this.E = false;
      this.F = 0;
      return this;
    }
    
    public MLTrip clearIsOld()
    {
      this.aH = false;
      this.aI = 0;
      return this;
    }
    
    public MLTrip clearIsRemind()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public MLTrip clearIsRepeat()
    {
      this.ad = false;
      this.ae = 0;
      return this;
    }
    
    public MLTrip clearIsShowRouteMap()
    {
      this.aa = false;
      this.ab = 0;
      return this;
    }
    
    public MLTrip clearIsWholeday()
    {
      this.aV = false;
      this.aW = 0;
      return this;
    }
    
    public MLTrip clearJumpContent()
    {
      this.ar = false;
      this.as = "";
      return this;
    }
    
    public MLTrip clearJumpUrl()
    {
      this.at = false;
      this.au = "";
      return this;
    }
    
    public MLTrip clearRemark()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLTrip clearRepeatDeadline()
    {
      this.aR = false;
      this.aS = 0L;
      return this;
    }
    
    public MLTrip clearRepeatTimestamp()
    {
      this.ah = false;
      this.ai = 0L;
      return this;
    }
    
    public MLTrip clearRepeatType()
    {
      this.aP = false;
      this.aQ = "";
      return this;
    }
    
    public MLTrip clearRouteInfo()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public MLTrip clearSrcFrom()
    {
      this.aT = false;
      this.aU = "";
      return this;
    }
    
    public MLTrip clearStartPoint()
    {
      this.q = false;
      this.r = null;
      return this;
    }
    
    public MLTrip clearStartPointSubTitle()
    {
      this.aJ = false;
      this.aK = "";
      return this;
    }
    
    public MLTrip clearStartPointTitle()
    {
      this.av = false;
      this.aw = "";
      return this;
    }
    
    public MLTrip clearStartTime()
    {
      this.A = false;
      this.B = 0L;
      return this;
    }
    
    public MLTrip clearStatus()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public MLTrip clearSubTripType()
    {
      this.af = false;
      this.ag = 0L;
      return this;
    }
    
    public MLTrip clearSugCard()
    {
      this.ac = Collections.emptyList();
      return this;
    }
    
    public MLTrip clearSugTime()
    {
      this.i = false;
      this.j = 0L;
      return this;
    }
    
    public MLTrip clearTimeType()
    {
      this.C = false;
      this.D = 0L;
      return this;
    }
    
    public MLTrip clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLTrip clearTitleType()
    {
      this.aF = false;
      this.aG = "";
      return this;
    }
    
    public MLTrip clearTitleUrl()
    {
      this.aj = false;
      this.ak = "";
      return this;
    }
    
    public MLTrip clearTrainInfo()
    {
      this.I = false;
      this.J = null;
      return this;
    }
    
    public MLTrip clearTripAddrTitle()
    {
      this.S = false;
      this.T = "";
      return this;
    }
    
    public MLTrip clearTripCardTitle()
    {
      this.Q = false;
      this.R = "";
      return this;
    }
    
    public MLTrip clearTripDesc()
    {
      this.aN = false;
      this.aO = "";
      return this;
    }
    
    public MLTrip clearTripEndtimeContent()
    {
      this.ap = false;
      this.aq = "";
      return this;
    }
    
    public MLTrip clearTripIconUrl()
    {
      this.Y = false;
      this.Z = "";
      return this;
    }
    
    public MLTrip clearTripId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTrip clearTripNewIconUrl()
    {
      this.aD = false;
      this.aE = "";
      return this;
    }
    
    public MLTrip clearTripRouteTitle()
    {
      this.W = false;
      this.X = "";
      return this;
    }
    
    public MLTrip clearTripStarttimeContent()
    {
      this.an = false;
      this.ao = "";
      return this;
    }
    
    public MLTrip clearTripTimeContent()
    {
      this.al = false;
      this.am = "";
      return this;
    }
    
    public MLTrip clearTripTimeTitle()
    {
      this.U = false;
      this.V = "";
      return this;
    }
    
    public MLTrip clearTripType()
    {
      this.y = false;
      this.z = 0L;
      return this;
    }
    
    public long getArrivalTime()
    {
      return this.n;
    }
    
    public int getCachedSize()
    {
      if (this.aX < 0) {
        getSerializedSize();
      }
      return this.aX;
    }
    
    public TaResponse.MLTripCardResource getCardResource()
    {
      return this.v;
    }
    
    public String getCostTime()
    {
      return this.aA;
    }
    
    public TaResponse.MLTripCreateInfo getCreateInfo()
    {
      return this.x;
    }
    
    public String getDetailUrl()
    {
      return this.N;
    }
    
    public TaResponse.MLTripPoint getEndPoint()
    {
      return this.t;
    }
    
    public String getEndPointSubTitle()
    {
      return this.aM;
    }
    
    public String getEndPointTitle()
    {
      return this.ay;
    }
    
    public String getEventTripTitle()
    {
      return this.aC;
    }
    
    public TaResponse.MLTripFlightInfo getFlightInfo()
    {
      return this.L;
    }
    
    public String getGuideRemark()
    {
      return this.H;
    }
    
    public TaResponse.MLTripCardIconInfo getIconInfo()
    {
      return this.P;
    }
    
    public int getIsCross()
    {
      return this.F;
    }
    
    public int getIsOld()
    {
      return this.aI;
    }
    
    public int getIsRemind()
    {
      return this.l;
    }
    
    public int getIsRepeat()
    {
      return this.ae;
    }
    
    public int getIsShowRouteMap()
    {
      return this.ab;
    }
    
    public int getIsWholeday()
    {
      return this.aW;
    }
    
    public String getJumpContent()
    {
      return this.as;
    }
    
    public String getJumpUrl()
    {
      return this.au;
    }
    
    public String getRemark()
    {
      return this.f;
    }
    
    public long getRepeatDeadline()
    {
      return this.aS;
    }
    
    public long getRepeatTimestamp()
    {
      return this.ai;
    }
    
    public String getRepeatType()
    {
      return this.aQ;
    }
    
    public String getRouteInfo()
    {
      return this.p;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasTripId()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTripId());
      }
      int i1 = i2;
      if (hasTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      i2 = i1;
      if (hasRemark()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getRemark());
      }
      i1 = i2;
      if (hasStatus()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getStatus());
      }
      i2 = i1;
      if (hasSugTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(5, getSugTime());
      }
      i1 = i2;
      if (hasIsRemind()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getIsRemind());
      }
      i2 = i1;
      if (hasArrivalTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(7, getArrivalTime());
      }
      i1 = i2;
      if (hasRouteInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getRouteInfo());
      }
      i2 = i1;
      if (hasStartPoint()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(9, getStartPoint());
      }
      i1 = i2;
      if (hasEndPoint()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(10, getEndPoint());
      }
      i2 = i1;
      if (hasCardResource()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(11, getCardResource());
      }
      i1 = i2;
      if (hasCreateInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(12, getCreateInfo());
      }
      i2 = i1;
      if (hasTripType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(13, getTripType());
      }
      i1 = i2;
      if (hasStartTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(14, getStartTime());
      }
      i2 = i1;
      if (hasTimeType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(15, getTimeType());
      }
      i1 = i2;
      if (hasIsCross()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(16, getIsCross());
      }
      i2 = i1;
      if (hasGuideRemark()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getGuideRemark());
      }
      i1 = i2;
      if (hasTrainInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(18, getTrainInfo());
      }
      i2 = i1;
      if (hasFlightInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(19, getFlightInfo());
      }
      i1 = i2;
      if (hasDetailUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(20, getDetailUrl());
      }
      i2 = i1;
      if (hasIconInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(21, getIconInfo());
      }
      i1 = i2;
      if (hasTripCardTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(22, getTripCardTitle());
      }
      i2 = i1;
      if (hasTripAddrTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(23, getTripAddrTitle());
      }
      i1 = i2;
      if (hasTripTimeTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(24, getTripTimeTitle());
      }
      i2 = i1;
      if (hasTripRouteTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(25, getTripRouteTitle());
      }
      i1 = i2;
      if (hasTripIconUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(26, getTripIconUrl());
      }
      i2 = i1;
      if (hasIsShowRouteMap()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(27, getIsShowRouteMap());
      }
      Iterator localIterator = getSugCardList().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(28, (TaResponse.MLTripSugInfo)localIterator.next()) + i2;
      }
      i1 = i2;
      if (hasIsRepeat()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(29, getIsRepeat());
      }
      i2 = i1;
      if (hasSubTripType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(30, getSubTripType());
      }
      i1 = i2;
      if (hasRepeatTimestamp()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(31, getRepeatTimestamp());
      }
      i2 = i1;
      if (hasTitleUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(32, getTitleUrl());
      }
      i1 = i2;
      if (hasTripTimeContent()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(33, getTripTimeContent());
      }
      i2 = i1;
      if (hasTripStarttimeContent()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(34, getTripStarttimeContent());
      }
      i1 = i2;
      if (hasTripEndtimeContent()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(35, getTripEndtimeContent());
      }
      i2 = i1;
      if (hasJumpContent()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(36, getJumpContent());
      }
      i1 = i2;
      if (hasJumpUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(37, getJumpUrl());
      }
      i2 = i1;
      if (hasStartPointTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(38, getStartPointTitle());
      }
      i1 = i2;
      if (hasEndPointTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(39, getEndPointTitle());
      }
      i2 = i1;
      if (hasCostTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(40, getCostTime());
      }
      i1 = i2;
      if (hasEventTripTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(41, getEventTripTitle());
      }
      i2 = i1;
      if (hasTripNewIconUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(42, getTripNewIconUrl());
      }
      i1 = i2;
      if (hasTitleType()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(43, getTitleType());
      }
      i2 = i1;
      if (hasIsOld()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(44, getIsOld());
      }
      i1 = i2;
      if (hasStartPointSubTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(45, getStartPointSubTitle());
      }
      i2 = i1;
      if (hasEndPointSubTitle()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(46, getEndPointSubTitle());
      }
      i1 = i2;
      if (hasTripDesc()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(47, getTripDesc());
      }
      i2 = i1;
      if (hasRepeatType()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(48, getRepeatType());
      }
      i1 = i2;
      if (hasRepeatDeadline()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(49, getRepeatDeadline());
      }
      i2 = i1;
      if (hasSrcFrom()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(50, getSrcFrom());
      }
      i1 = i2;
      if (hasIsWholeday()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(51, getIsWholeday());
      }
      this.aX = i1;
      return i1;
    }
    
    public String getSrcFrom()
    {
      return this.aU;
    }
    
    public TaResponse.MLTripPoint getStartPoint()
    {
      return this.r;
    }
    
    public String getStartPointSubTitle()
    {
      return this.aK;
    }
    
    public String getStartPointTitle()
    {
      return this.aw;
    }
    
    public long getStartTime()
    {
      return this.B;
    }
    
    public int getStatus()
    {
      return this.h;
    }
    
    public long getSubTripType()
    {
      return this.ag;
    }
    
    public TaResponse.MLTripSugInfo getSugCard(int paramInt)
    {
      return (TaResponse.MLTripSugInfo)this.ac.get(paramInt);
    }
    
    public int getSugCardCount()
    {
      return this.ac.size();
    }
    
    public List<TaResponse.MLTripSugInfo> getSugCardList()
    {
      return this.ac;
    }
    
    public long getSugTime()
    {
      return this.j;
    }
    
    public long getTimeType()
    {
      return this.D;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public String getTitleType()
    {
      return this.aG;
    }
    
    public String getTitleUrl()
    {
      return this.ak;
    }
    
    public TaResponse.MLTripTrainInfo getTrainInfo()
    {
      return this.J;
    }
    
    public String getTripAddrTitle()
    {
      return this.T;
    }
    
    public String getTripCardTitle()
    {
      return this.R;
    }
    
    public String getTripDesc()
    {
      return this.aO;
    }
    
    public String getTripEndtimeContent()
    {
      return this.aq;
    }
    
    public String getTripIconUrl()
    {
      return this.Z;
    }
    
    public String getTripId()
    {
      return this.b;
    }
    
    public String getTripNewIconUrl()
    {
      return this.aE;
    }
    
    public String getTripRouteTitle()
    {
      return this.X;
    }
    
    public String getTripStarttimeContent()
    {
      return this.ao;
    }
    
    public String getTripTimeContent()
    {
      return this.am;
    }
    
    public String getTripTimeTitle()
    {
      return this.V;
    }
    
    public long getTripType()
    {
      return this.z;
    }
    
    public boolean hasArrivalTime()
    {
      return this.m;
    }
    
    public boolean hasCardResource()
    {
      return this.u;
    }
    
    public boolean hasCostTime()
    {
      return this.az;
    }
    
    public boolean hasCreateInfo()
    {
      return this.w;
    }
    
    public boolean hasDetailUrl()
    {
      return this.M;
    }
    
    public boolean hasEndPoint()
    {
      return this.s;
    }
    
    public boolean hasEndPointSubTitle()
    {
      return this.aL;
    }
    
    public boolean hasEndPointTitle()
    {
      return this.ax;
    }
    
    public boolean hasEventTripTitle()
    {
      return this.aB;
    }
    
    public boolean hasFlightInfo()
    {
      return this.K;
    }
    
    public boolean hasGuideRemark()
    {
      return this.G;
    }
    
    public boolean hasIconInfo()
    {
      return this.O;
    }
    
    public boolean hasIsCross()
    {
      return this.E;
    }
    
    public boolean hasIsOld()
    {
      return this.aH;
    }
    
    public boolean hasIsRemind()
    {
      return this.k;
    }
    
    public boolean hasIsRepeat()
    {
      return this.ad;
    }
    
    public boolean hasIsShowRouteMap()
    {
      return this.aa;
    }
    
    public boolean hasIsWholeday()
    {
      return this.aV;
    }
    
    public boolean hasJumpContent()
    {
      return this.ar;
    }
    
    public boolean hasJumpUrl()
    {
      return this.at;
    }
    
    public boolean hasRemark()
    {
      return this.e;
    }
    
    public boolean hasRepeatDeadline()
    {
      return this.aR;
    }
    
    public boolean hasRepeatTimestamp()
    {
      return this.ah;
    }
    
    public boolean hasRepeatType()
    {
      return this.aP;
    }
    
    public boolean hasRouteInfo()
    {
      return this.o;
    }
    
    public boolean hasSrcFrom()
    {
      return this.aT;
    }
    
    public boolean hasStartPoint()
    {
      return this.q;
    }
    
    public boolean hasStartPointSubTitle()
    {
      return this.aJ;
    }
    
    public boolean hasStartPointTitle()
    {
      return this.av;
    }
    
    public boolean hasStartTime()
    {
      return this.A;
    }
    
    public boolean hasStatus()
    {
      return this.g;
    }
    
    public boolean hasSubTripType()
    {
      return this.af;
    }
    
    public boolean hasSugTime()
    {
      return this.i;
    }
    
    public boolean hasTimeType()
    {
      return this.C;
    }
    
    public boolean hasTitle()
    {
      return this.c;
    }
    
    public boolean hasTitleType()
    {
      return this.aF;
    }
    
    public boolean hasTitleUrl()
    {
      return this.aj;
    }
    
    public boolean hasTrainInfo()
    {
      return this.I;
    }
    
    public boolean hasTripAddrTitle()
    {
      return this.S;
    }
    
    public boolean hasTripCardTitle()
    {
      return this.Q;
    }
    
    public boolean hasTripDesc()
    {
      return this.aN;
    }
    
    public boolean hasTripEndtimeContent()
    {
      return this.ap;
    }
    
    public boolean hasTripIconUrl()
    {
      return this.Y;
    }
    
    public boolean hasTripId()
    {
      return this.a;
    }
    
    public boolean hasTripNewIconUrl()
    {
      return this.aD;
    }
    
    public boolean hasTripRouteTitle()
    {
      return this.W;
    }
    
    public boolean hasTripStarttimeContent()
    {
      return this.an;
    }
    
    public boolean hasTripTimeContent()
    {
      return this.al;
    }
    
    public boolean hasTripTimeTitle()
    {
      return this.U;
    }
    
    public boolean hasTripType()
    {
      return this.y;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {
        return false;
      }
      if (!this.c) {
        return false;
      }
      if (!this.e) {
        return false;
      }
      if (!this.g) {
        return false;
      }
      if (!this.i) {
        return false;
      }
      if (!this.k) {
        return false;
      }
      if (!this.m) {
        return false;
      }
      if (!this.o) {
        return false;
      }
      if (!this.q) {
        return false;
      }
      if (!this.s) {
        return false;
      }
      if (!this.u) {
        return false;
      }
      if (!this.w) {
        return false;
      }
      if (!getStartPoint().isInitialized()) {
        return false;
      }
      if (!getEndPoint().isInitialized()) {
        return false;
      }
      if (!getCardResource().isInitialized()) {
        return false;
      }
      if (!getCreateInfo().isInitialized()) {
        return false;
      }
      Iterator localIterator = getSugCardList().iterator();
      while (localIterator.hasNext()) {
        if (!((TaResponse.MLTripSugInfo)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public MLTrip mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTripId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setRemark(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setStatus(paramCodedInputStreamMicro.readInt32());
          break;
        case 40: 
          setSugTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 48: 
          setIsRemind(paramCodedInputStreamMicro.readInt32());
          break;
        case 56: 
          setArrivalTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 66: 
          setRouteInfo(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          localObject = new TaResponse.MLTripPoint();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setStartPoint((TaResponse.MLTripPoint)localObject);
          break;
        case 82: 
          localObject = new TaResponse.MLTripPoint();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setEndPoint((TaResponse.MLTripPoint)localObject);
          break;
        case 90: 
          localObject = new TaResponse.MLTripCardResource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCardResource((TaResponse.MLTripCardResource)localObject);
          break;
        case 98: 
          localObject = new TaResponse.MLTripCreateInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCreateInfo((TaResponse.MLTripCreateInfo)localObject);
          break;
        case 104: 
          setTripType(paramCodedInputStreamMicro.readInt64());
          break;
        case 112: 
          setStartTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 120: 
          setTimeType(paramCodedInputStreamMicro.readInt64());
          break;
        case 128: 
          setIsCross(paramCodedInputStreamMicro.readInt32());
          break;
        case 138: 
          setGuideRemark(paramCodedInputStreamMicro.readString());
          break;
        case 146: 
          localObject = new TaResponse.MLTripTrainInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTrainInfo((TaResponse.MLTripTrainInfo)localObject);
          break;
        case 154: 
          localObject = new TaResponse.MLTripFlightInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setFlightInfo((TaResponse.MLTripFlightInfo)localObject);
          break;
        case 162: 
          setDetailUrl(paramCodedInputStreamMicro.readString());
          break;
        case 170: 
          localObject = new TaResponse.MLTripCardIconInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setIconInfo((TaResponse.MLTripCardIconInfo)localObject);
          break;
        case 178: 
          setTripCardTitle(paramCodedInputStreamMicro.readString());
          break;
        case 186: 
          setTripAddrTitle(paramCodedInputStreamMicro.readString());
          break;
        case 194: 
          setTripTimeTitle(paramCodedInputStreamMicro.readString());
          break;
        case 202: 
          setTripRouteTitle(paramCodedInputStreamMicro.readString());
          break;
        case 210: 
          setTripIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 216: 
          setIsShowRouteMap(paramCodedInputStreamMicro.readInt32());
          break;
        case 226: 
          localObject = new TaResponse.MLTripSugInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addSugCard((TaResponse.MLTripSugInfo)localObject);
          break;
        case 232: 
          setIsRepeat(paramCodedInputStreamMicro.readInt32());
          break;
        case 240: 
          setSubTripType(paramCodedInputStreamMicro.readInt64());
          break;
        case 248: 
          setRepeatTimestamp(paramCodedInputStreamMicro.readInt64());
          break;
        case 258: 
          setTitleUrl(paramCodedInputStreamMicro.readString());
          break;
        case 266: 
          setTripTimeContent(paramCodedInputStreamMicro.readString());
          break;
        case 274: 
          setTripStarttimeContent(paramCodedInputStreamMicro.readString());
          break;
        case 282: 
          setTripEndtimeContent(paramCodedInputStreamMicro.readString());
          break;
        case 290: 
          setJumpContent(paramCodedInputStreamMicro.readString());
          break;
        case 298: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 306: 
          setStartPointTitle(paramCodedInputStreamMicro.readString());
          break;
        case 314: 
          setEndPointTitle(paramCodedInputStreamMicro.readString());
          break;
        case 322: 
          setCostTime(paramCodedInputStreamMicro.readString());
          break;
        case 330: 
          setEventTripTitle(paramCodedInputStreamMicro.readString());
          break;
        case 338: 
          setTripNewIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 346: 
          setTitleType(paramCodedInputStreamMicro.readString());
          break;
        case 352: 
          setIsOld(paramCodedInputStreamMicro.readInt32());
          break;
        case 362: 
          setStartPointSubTitle(paramCodedInputStreamMicro.readString());
          break;
        case 370: 
          setEndPointSubTitle(paramCodedInputStreamMicro.readString());
          break;
        case 378: 
          setTripDesc(paramCodedInputStreamMicro.readString());
          break;
        case 386: 
          setRepeatType(paramCodedInputStreamMicro.readString());
          break;
        case 392: 
          setRepeatDeadline(paramCodedInputStreamMicro.readInt64());
          break;
        case 402: 
          setSrcFrom(paramCodedInputStreamMicro.readString());
          break;
        case 408: 
          setIsWholeday(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public MLTrip setArrivalTime(long paramLong)
    {
      this.m = true;
      this.n = paramLong;
      return this;
    }
    
    public MLTrip setCardResource(TaResponse.MLTripCardResource paramMLTripCardResource)
    {
      if (paramMLTripCardResource == null) {
        return clearCardResource();
      }
      this.u = true;
      this.v = paramMLTripCardResource;
      return this;
    }
    
    public MLTrip setCostTime(String paramString)
    {
      this.az = true;
      this.aA = paramString;
      return this;
    }
    
    public MLTrip setCreateInfo(TaResponse.MLTripCreateInfo paramMLTripCreateInfo)
    {
      if (paramMLTripCreateInfo == null) {
        return clearCreateInfo();
      }
      this.w = true;
      this.x = paramMLTripCreateInfo;
      return this;
    }
    
    public MLTrip setDetailUrl(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }
    
    public MLTrip setEndPoint(TaResponse.MLTripPoint paramMLTripPoint)
    {
      if (paramMLTripPoint == null) {
        return clearEndPoint();
      }
      this.s = true;
      this.t = paramMLTripPoint;
      return this;
    }
    
    public MLTrip setEndPointSubTitle(String paramString)
    {
      this.aL = true;
      this.aM = paramString;
      return this;
    }
    
    public MLTrip setEndPointTitle(String paramString)
    {
      this.ax = true;
      this.ay = paramString;
      return this;
    }
    
    public MLTrip setEventTripTitle(String paramString)
    {
      this.aB = true;
      this.aC = paramString;
      return this;
    }
    
    public MLTrip setFlightInfo(TaResponse.MLTripFlightInfo paramMLTripFlightInfo)
    {
      if (paramMLTripFlightInfo == null) {
        return clearFlightInfo();
      }
      this.K = true;
      this.L = paramMLTripFlightInfo;
      return this;
    }
    
    public MLTrip setGuideRemark(String paramString)
    {
      this.G = true;
      this.H = paramString;
      return this;
    }
    
    public MLTrip setIconInfo(TaResponse.MLTripCardIconInfo paramMLTripCardIconInfo)
    {
      if (paramMLTripCardIconInfo == null) {
        return clearIconInfo();
      }
      this.O = true;
      this.P = paramMLTripCardIconInfo;
      return this;
    }
    
    public MLTrip setIsCross(int paramInt)
    {
      this.E = true;
      this.F = paramInt;
      return this;
    }
    
    public MLTrip setIsOld(int paramInt)
    {
      this.aH = true;
      this.aI = paramInt;
      return this;
    }
    
    public MLTrip setIsRemind(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public MLTrip setIsRepeat(int paramInt)
    {
      this.ad = true;
      this.ae = paramInt;
      return this;
    }
    
    public MLTrip setIsShowRouteMap(int paramInt)
    {
      this.aa = true;
      this.ab = paramInt;
      return this;
    }
    
    public MLTrip setIsWholeday(int paramInt)
    {
      this.aV = true;
      this.aW = paramInt;
      return this;
    }
    
    public MLTrip setJumpContent(String paramString)
    {
      this.ar = true;
      this.as = paramString;
      return this;
    }
    
    public MLTrip setJumpUrl(String paramString)
    {
      this.at = true;
      this.au = paramString;
      return this;
    }
    
    public MLTrip setRemark(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLTrip setRepeatDeadline(long paramLong)
    {
      this.aR = true;
      this.aS = paramLong;
      return this;
    }
    
    public MLTrip setRepeatTimestamp(long paramLong)
    {
      this.ah = true;
      this.ai = paramLong;
      return this;
    }
    
    public MLTrip setRepeatType(String paramString)
    {
      this.aP = true;
      this.aQ = paramString;
      return this;
    }
    
    public MLTrip setRouteInfo(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public MLTrip setSrcFrom(String paramString)
    {
      this.aT = true;
      this.aU = paramString;
      return this;
    }
    
    public MLTrip setStartPoint(TaResponse.MLTripPoint paramMLTripPoint)
    {
      if (paramMLTripPoint == null) {
        return clearStartPoint();
      }
      this.q = true;
      this.r = paramMLTripPoint;
      return this;
    }
    
    public MLTrip setStartPointSubTitle(String paramString)
    {
      this.aJ = true;
      this.aK = paramString;
      return this;
    }
    
    public MLTrip setStartPointTitle(String paramString)
    {
      this.av = true;
      this.aw = paramString;
      return this;
    }
    
    public MLTrip setStartTime(long paramLong)
    {
      this.A = true;
      this.B = paramLong;
      return this;
    }
    
    public MLTrip setStatus(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public MLTrip setSubTripType(long paramLong)
    {
      this.af = true;
      this.ag = paramLong;
      return this;
    }
    
    public MLTrip setSugCard(int paramInt, TaResponse.MLTripSugInfo paramMLTripSugInfo)
    {
      if (paramMLTripSugInfo == null) {
        return this;
      }
      this.ac.set(paramInt, paramMLTripSugInfo);
      return this;
    }
    
    public MLTrip setSugTime(long paramLong)
    {
      this.i = true;
      this.j = paramLong;
      return this;
    }
    
    public MLTrip setTimeType(long paramLong)
    {
      this.C = true;
      this.D = paramLong;
      return this;
    }
    
    public MLTrip setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLTrip setTitleType(String paramString)
    {
      this.aF = true;
      this.aG = paramString;
      return this;
    }
    
    public MLTrip setTitleUrl(String paramString)
    {
      this.aj = true;
      this.ak = paramString;
      return this;
    }
    
    public MLTrip setTrainInfo(TaResponse.MLTripTrainInfo paramMLTripTrainInfo)
    {
      if (paramMLTripTrainInfo == null) {
        return clearTrainInfo();
      }
      this.I = true;
      this.J = paramMLTripTrainInfo;
      return this;
    }
    
    public MLTrip setTripAddrTitle(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }
    
    public MLTrip setTripCardTitle(String paramString)
    {
      this.Q = true;
      this.R = paramString;
      return this;
    }
    
    public MLTrip setTripDesc(String paramString)
    {
      this.aN = true;
      this.aO = paramString;
      return this;
    }
    
    public MLTrip setTripEndtimeContent(String paramString)
    {
      this.ap = true;
      this.aq = paramString;
      return this;
    }
    
    public MLTrip setTripIconUrl(String paramString)
    {
      this.Y = true;
      this.Z = paramString;
      return this;
    }
    
    public MLTrip setTripId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTrip setTripNewIconUrl(String paramString)
    {
      this.aD = true;
      this.aE = paramString;
      return this;
    }
    
    public MLTrip setTripRouteTitle(String paramString)
    {
      this.W = true;
      this.X = paramString;
      return this;
    }
    
    public MLTrip setTripStarttimeContent(String paramString)
    {
      this.an = true;
      this.ao = paramString;
      return this;
    }
    
    public MLTrip setTripTimeContent(String paramString)
    {
      this.al = true;
      this.am = paramString;
      return this;
    }
    
    public MLTrip setTripTimeTitle(String paramString)
    {
      this.U = true;
      this.V = paramString;
      return this;
    }
    
    public MLTrip setTripType(long paramLong)
    {
      this.y = true;
      this.z = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTripId()) {
        paramCodedOutputStreamMicro.writeString(1, getTripId());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
      if (hasRemark()) {
        paramCodedOutputStreamMicro.writeString(3, getRemark());
      }
      if (hasStatus()) {
        paramCodedOutputStreamMicro.writeInt32(4, getStatus());
      }
      if (hasSugTime()) {
        paramCodedOutputStreamMicro.writeInt64(5, getSugTime());
      }
      if (hasIsRemind()) {
        paramCodedOutputStreamMicro.writeInt32(6, getIsRemind());
      }
      if (hasArrivalTime()) {
        paramCodedOutputStreamMicro.writeInt64(7, getArrivalTime());
      }
      if (hasRouteInfo()) {
        paramCodedOutputStreamMicro.writeString(8, getRouteInfo());
      }
      if (hasStartPoint()) {
        paramCodedOutputStreamMicro.writeMessage(9, getStartPoint());
      }
      if (hasEndPoint()) {
        paramCodedOutputStreamMicro.writeMessage(10, getEndPoint());
      }
      if (hasCardResource()) {
        paramCodedOutputStreamMicro.writeMessage(11, getCardResource());
      }
      if (hasCreateInfo()) {
        paramCodedOutputStreamMicro.writeMessage(12, getCreateInfo());
      }
      if (hasTripType()) {
        paramCodedOutputStreamMicro.writeInt64(13, getTripType());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeInt64(14, getStartTime());
      }
      if (hasTimeType()) {
        paramCodedOutputStreamMicro.writeInt64(15, getTimeType());
      }
      if (hasIsCross()) {
        paramCodedOutputStreamMicro.writeInt32(16, getIsCross());
      }
      if (hasGuideRemark()) {
        paramCodedOutputStreamMicro.writeString(17, getGuideRemark());
      }
      if (hasTrainInfo()) {
        paramCodedOutputStreamMicro.writeMessage(18, getTrainInfo());
      }
      if (hasFlightInfo()) {
        paramCodedOutputStreamMicro.writeMessage(19, getFlightInfo());
      }
      if (hasDetailUrl()) {
        paramCodedOutputStreamMicro.writeString(20, getDetailUrl());
      }
      if (hasIconInfo()) {
        paramCodedOutputStreamMicro.writeMessage(21, getIconInfo());
      }
      if (hasTripCardTitle()) {
        paramCodedOutputStreamMicro.writeString(22, getTripCardTitle());
      }
      if (hasTripAddrTitle()) {
        paramCodedOutputStreamMicro.writeString(23, getTripAddrTitle());
      }
      if (hasTripTimeTitle()) {
        paramCodedOutputStreamMicro.writeString(24, getTripTimeTitle());
      }
      if (hasTripRouteTitle()) {
        paramCodedOutputStreamMicro.writeString(25, getTripRouteTitle());
      }
      if (hasTripIconUrl()) {
        paramCodedOutputStreamMicro.writeString(26, getTripIconUrl());
      }
      if (hasIsShowRouteMap()) {
        paramCodedOutputStreamMicro.writeInt32(27, getIsShowRouteMap());
      }
      Iterator localIterator = getSugCardList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(28, (TaResponse.MLTripSugInfo)localIterator.next());
      }
      if (hasIsRepeat()) {
        paramCodedOutputStreamMicro.writeInt32(29, getIsRepeat());
      }
      if (hasSubTripType()) {
        paramCodedOutputStreamMicro.writeInt64(30, getSubTripType());
      }
      if (hasRepeatTimestamp()) {
        paramCodedOutputStreamMicro.writeInt64(31, getRepeatTimestamp());
      }
      if (hasTitleUrl()) {
        paramCodedOutputStreamMicro.writeString(32, getTitleUrl());
      }
      if (hasTripTimeContent()) {
        paramCodedOutputStreamMicro.writeString(33, getTripTimeContent());
      }
      if (hasTripStarttimeContent()) {
        paramCodedOutputStreamMicro.writeString(34, getTripStarttimeContent());
      }
      if (hasTripEndtimeContent()) {
        paramCodedOutputStreamMicro.writeString(35, getTripEndtimeContent());
      }
      if (hasJumpContent()) {
        paramCodedOutputStreamMicro.writeString(36, getJumpContent());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(37, getJumpUrl());
      }
      if (hasStartPointTitle()) {
        paramCodedOutputStreamMicro.writeString(38, getStartPointTitle());
      }
      if (hasEndPointTitle()) {
        paramCodedOutputStreamMicro.writeString(39, getEndPointTitle());
      }
      if (hasCostTime()) {
        paramCodedOutputStreamMicro.writeString(40, getCostTime());
      }
      if (hasEventTripTitle()) {
        paramCodedOutputStreamMicro.writeString(41, getEventTripTitle());
      }
      if (hasTripNewIconUrl()) {
        paramCodedOutputStreamMicro.writeString(42, getTripNewIconUrl());
      }
      if (hasTitleType()) {
        paramCodedOutputStreamMicro.writeString(43, getTitleType());
      }
      if (hasIsOld()) {
        paramCodedOutputStreamMicro.writeInt32(44, getIsOld());
      }
      if (hasStartPointSubTitle()) {
        paramCodedOutputStreamMicro.writeString(45, getStartPointSubTitle());
      }
      if (hasEndPointSubTitle()) {
        paramCodedOutputStreamMicro.writeString(46, getEndPointSubTitle());
      }
      if (hasTripDesc()) {
        paramCodedOutputStreamMicro.writeString(47, getTripDesc());
      }
      if (hasRepeatType()) {
        paramCodedOutputStreamMicro.writeString(48, getRepeatType());
      }
      if (hasRepeatDeadline()) {
        paramCodedOutputStreamMicro.writeInt64(49, getRepeatDeadline());
      }
      if (hasSrcFrom()) {
        paramCodedOutputStreamMicro.writeString(50, getSrcFrom());
      }
      if (hasIsWholeday()) {
        paramCodedOutputStreamMicro.writeInt32(51, getIsWholeday());
      }
    }
  }
  
  public static final class MLTripCardIconInfo
    extends MessageMicro
  {
    public static final int JUMP_URL_FIELD_NUMBER = 1;
    public static final int PHONE_FIELD_NUMBER = 4;
    public static final int SHOW_BUTTON_TITLE_FIELD_NUMBER = 3;
    public static final int SHOW_TYPE_FIELD_NUMBER = 5;
    public static final int SHOW_URL_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private int j = 0;
    private int k = -1;
    
    public static MLTripCardIconInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripCardIconInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripCardIconInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripCardIconInfo)new MLTripCardIconInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripCardIconInfo clear()
    {
      clearJumpUrl();
      clearShowUrl();
      clearShowButtonTitle();
      clearPhone();
      clearShowType();
      this.k = -1;
      return this;
    }
    
    public MLTripCardIconInfo clearJumpUrl()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTripCardIconInfo clearPhone()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLTripCardIconInfo clearShowButtonTitle()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLTripCardIconInfo clearShowType()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public MLTripCardIconInfo clearShowUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public String getJumpUrl()
    {
      return this.b;
    }
    
    public String getPhone()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasJumpUrl()) {
        n = 0 + CodedOutputStreamMicro.computeStringSize(1, getJumpUrl());
      }
      int m = n;
      if (hasShowUrl()) {
        m = n + CodedOutputStreamMicro.computeStringSize(2, getShowUrl());
      }
      n = m;
      if (hasShowButtonTitle()) {
        n = m + CodedOutputStreamMicro.computeStringSize(3, getShowButtonTitle());
      }
      m = n;
      if (hasPhone()) {
        m = n + CodedOutputStreamMicro.computeStringSize(4, getPhone());
      }
      n = m;
      if (hasShowType()) {
        n = m + CodedOutputStreamMicro.computeInt32Size(5, getShowType());
      }
      this.k = n;
      return n;
    }
    
    public String getShowButtonTitle()
    {
      return this.f;
    }
    
    public int getShowType()
    {
      return this.j;
    }
    
    public String getShowUrl()
    {
      return this.d;
    }
    
    public boolean hasJumpUrl()
    {
      return this.a;
    }
    
    public boolean hasPhone()
    {
      return this.g;
    }
    
    public boolean hasShowButtonTitle()
    {
      return this.e;
    }
    
    public boolean hasShowType()
    {
      return this.i;
    }
    
    public boolean hasShowUrl()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MLTripCardIconInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setShowUrl(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setShowButtonTitle(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setPhone(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setShowType(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public MLTripCardIconInfo setJumpUrl(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTripCardIconInfo setPhone(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLTripCardIconInfo setShowButtonTitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLTripCardIconInfo setShowType(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public MLTripCardIconInfo setShowUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(1, getJumpUrl());
      }
      if (hasShowUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getShowUrl());
      }
      if (hasShowButtonTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getShowButtonTitle());
      }
      if (hasPhone()) {
        paramCodedOutputStreamMicro.writeString(4, getPhone());
      }
      if (hasShowType()) {
        paramCodedOutputStreamMicro.writeInt32(5, getShowType());
      }
    }
  }
  
  public static final class MLTripCardResource
    extends MessageMicro
  {
    public static final int ICON_DESC_FIELD_NUMBER = 2;
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int SUB_TITLE_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static MLTripCardResource parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripCardResource().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripCardResource parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripCardResource)new MLTripCardResource().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripCardResource clear()
    {
      clearIcon();
      clearIconDesc();
      clearTitle();
      clearSubTitle();
      this.i = -1;
      return this;
    }
    
    public MLTripCardResource clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTripCardResource clearIconDesc()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLTripCardResource clearSubTitle()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLTripCardResource clearTitle()
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
    
    public String getIcon()
    {
      return this.b;
    }
    
    public String getIconDesc()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasIcon()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
      }
      int j = k;
      if (hasIconDesc()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getIconDesc());
      }
      k = j;
      if (hasTitle()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getTitle());
      }
      j = k;
      if (hasSubTitle()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getSubTitle());
      }
      this.i = j;
      return j;
    }
    
    public String getSubTitle()
    {
      return this.h;
    }
    
    public String getTitle()
    {
      return this.f;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasIconDesc()
    {
      return this.c;
    }
    
    public boolean hasSubTitle()
    {
      return this.g;
    }
    
    public boolean hasTitle()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g)) {
        return false;
      }
      return true;
    }
    
    public MLTripCardResource mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setIconDesc(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setSubTitle(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLTripCardResource setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTripCardResource setIconDesc(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLTripCardResource setSubTitle(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLTripCardResource setTitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      if (hasIconDesc()) {
        paramCodedOutputStreamMicro.writeString(2, getIconDesc());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getTitle());
      }
      if (hasSubTitle()) {
        paramCodedOutputStreamMicro.writeString(4, getSubTitle());
      }
    }
  }
  
  public static final class MLTripCitySep
    extends MessageMicro
  {
    public static final int REMOTE_WEATHER_FIELD_NUMBER = 2;
    public static final int TEXT_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private TaResponse.MLWeahterSep d = null;
    private int e = -1;
    
    public static MLTripCitySep parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripCitySep().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripCitySep parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripCitySep)new MLTripCitySep().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripCitySep clear()
    {
      clearText();
      clearRemoteWeather();
      this.e = -1;
      return this;
    }
    
    public MLTripCitySep clearRemoteWeather()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public MLTripCitySep clearText()
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
    
    public TaResponse.MLWeahterSep getRemoteWeather()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasText()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getText());
      }
      int j = i;
      if (hasRemoteWeather()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getRemoteWeather());
      }
      this.e = j;
      return j;
    }
    
    public String getText()
    {
      return this.b;
    }
    
    public boolean hasRemoteWeather()
    {
      return this.c;
    }
    
    public boolean hasText()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return this.a;
    }
    
    public MLTripCitySep mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setText(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          TaResponse.MLWeahterSep localMLWeahterSep = new TaResponse.MLWeahterSep();
          paramCodedInputStreamMicro.readMessage(localMLWeahterSep);
          setRemoteWeather(localMLWeahterSep);
        }
      }
    }
    
    public MLTripCitySep setRemoteWeather(TaResponse.MLWeahterSep paramMLWeahterSep)
    {
      if (paramMLWeahterSep == null) {
        return clearRemoteWeather();
      }
      this.c = true;
      this.d = paramMLWeahterSep;
      return this;
    }
    
    public MLTripCitySep setText(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasText()) {
        paramCodedOutputStreamMicro.writeString(1, getText());
      }
      if (hasRemoteWeather()) {
        paramCodedOutputStreamMicro.writeMessage(2, getRemoteWeather());
      }
    }
  }
  
  public static final class MLTripCitySepWeather
    extends MessageMicro
  {
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int JUMP_URL_FIELD_NUMBER = 5;
    public static final int PM25_FIELD_NUMBER = 4;
    public static final int SCHEME_FIELD_NUMBER = 3;
    public static final int TEXT_FIELD_NUMBER = 2;
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
    
    public static MLTripCitySepWeather parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripCitySepWeather().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripCitySepWeather parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripCitySepWeather)new MLTripCitySepWeather().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripCitySepWeather clear()
    {
      clearIcon();
      clearText();
      clearScheme();
      clearPm25();
      clearJumpUrl();
      this.k = -1;
      return this;
    }
    
    public MLTripCitySepWeather clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTripCitySepWeather clearJumpUrl()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public MLTripCitySepWeather clearPm25()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLTripCitySepWeather clearScheme()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLTripCitySepWeather clearText()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public String getIcon()
    {
      return this.b;
    }
    
    public String getJumpUrl()
    {
      return this.j;
    }
    
    public String getPm25()
    {
      return this.h;
    }
    
    public String getScheme()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasIcon()) {
        n = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
      }
      int m = n;
      if (hasText()) {
        m = n + CodedOutputStreamMicro.computeStringSize(2, getText());
      }
      n = m;
      if (hasScheme()) {
        n = m + CodedOutputStreamMicro.computeStringSize(3, getScheme());
      }
      m = n;
      if (hasPm25()) {
        m = n + CodedOutputStreamMicro.computeStringSize(4, getPm25());
      }
      n = m;
      if (hasJumpUrl()) {
        n = m + CodedOutputStreamMicro.computeStringSize(5, getJumpUrl());
      }
      this.k = n;
      return n;
    }
    
    public String getText()
    {
      return this.d;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasJumpUrl()
    {
      return this.i;
    }
    
    public boolean hasPm25()
    {
      return this.g;
    }
    
    public boolean hasScheme()
    {
      return this.e;
    }
    
    public boolean hasText()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while (!this.c) {
        return false;
      }
      return true;
    }
    
    public MLTripCitySepWeather mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setText(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setScheme(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setPm25(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLTripCitySepWeather setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTripCitySepWeather setJumpUrl(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public MLTripCitySepWeather setPm25(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLTripCitySepWeather setScheme(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLTripCitySepWeather setText(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      if (hasText()) {
        paramCodedOutputStreamMicro.writeString(2, getText());
      }
      if (hasScheme()) {
        paramCodedOutputStreamMicro.writeString(3, getScheme());
      }
      if (hasPm25()) {
        paramCodedOutputStreamMicro.writeString(4, getPm25());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(5, getJumpUrl());
      }
    }
  }
  
  public static final class MLTripCreateInfo
    extends MessageMicro
  {
    public static final int CREATE_TYPE_FIELD_NUMBER = 1;
    public static final int ORDER_ID_FIELD_NUMBER = 2;
    public static final int ORDER_TYPE_FIELD_NUMBER = 4;
    public static final int ORDER_URL_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static MLTripCreateInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripCreateInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripCreateInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripCreateInfo)new MLTripCreateInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripCreateInfo clear()
    {
      clearCreateType();
      clearOrderId();
      clearOrderUrl();
      clearOrderType();
      this.i = -1;
      return this;
    }
    
    public MLTripCreateInfo clearCreateType()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTripCreateInfo clearOrderId()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLTripCreateInfo clearOrderType()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLTripCreateInfo clearOrderUrl()
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
    
    public String getCreateType()
    {
      return this.b;
    }
    
    public String getOrderId()
    {
      return this.d;
    }
    
    public String getOrderType()
    {
      return this.h;
    }
    
    public String getOrderUrl()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasCreateType()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getCreateType());
      }
      int j = k;
      if (hasOrderId()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getOrderId());
      }
      k = j;
      if (hasOrderUrl()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getOrderUrl());
      }
      j = k;
      if (hasOrderType()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getOrderType());
      }
      this.i = j;
      return j;
    }
    
    public boolean hasCreateType()
    {
      return this.a;
    }
    
    public boolean hasOrderId()
    {
      return this.c;
    }
    
    public boolean hasOrderType()
    {
      return this.g;
    }
    
    public boolean hasOrderUrl()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return this.a;
    }
    
    public MLTripCreateInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCreateType(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setOrderId(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setOrderUrl(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setOrderType(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLTripCreateInfo setCreateType(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTripCreateInfo setOrderId(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLTripCreateInfo setOrderType(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLTripCreateInfo setOrderUrl(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCreateType()) {
        paramCodedOutputStreamMicro.writeString(1, getCreateType());
      }
      if (hasOrderId()) {
        paramCodedOutputStreamMicro.writeString(2, getOrderId());
      }
      if (hasOrderUrl()) {
        paramCodedOutputStreamMicro.writeString(3, getOrderUrl());
      }
      if (hasOrderType()) {
        paramCodedOutputStreamMicro.writeString(4, getOrderType());
      }
    }
  }
  
  public static final class MLTripFlightInfo
    extends MessageMicro
  {
    public static final int ADD_FLIGHT_TYPE_FIELD_NUMBER = 1;
    public static final int AIRLINE_FIELD_NUMBER = 29;
    public static final int AIRLINE_URL_FIELD_NUMBER = 31;
    public static final int ARRIVAL_AIRPORT_CODE_FIELD_NUMBER = 7;
    public static final int ARRIVAL_AIRPORT_NAME_ABBREV_FIELD_NUMBER = 18;
    public static final int ARRIVAL_AIRPORT_NAME_FIELD_NUMBER = 17;
    public static final int ARRIVAL_CITY_CODE_FIELD_NUMBER = 19;
    public static final int ARRIVAL_CITY_NAME_FIELD_NUMBER = 20;
    public static final int ARRIVAL_TERMINAL_NAME_FIELD_NUMBER = 10;
    public static final int ARRIVAL_TIME_FIELD_NUMBER = 6;
    public static final int ARRIVAL_TIME_STR_FIELD_NUMBER = 12;
    public static final int BAGGAGE_ID_FIELD_NUMBER = 24;
    public static final int BOARD_GATE_FIELD_NUMBER = 23;
    public static final int CHECKIN_TABLE_FIELD_NUMBER = 21;
    public static final int DEPART_AIRPORT_CODE_FIELD_NUMBER = 8;
    public static final int DEPART_AIRPORT_NAME_ABBREV_FIELD_NUMBER = 13;
    public static final int DEPART_AIRPORT_NAME_FIELD_NUMBER = 16;
    public static final int DEPART_CITY_CODE_FIELD_NUMBER = 14;
    public static final int DEPART_CITY_NAME_FIELD_NUMBER = 15;
    public static final int DEPART_TERMINAL_NAME_FIELD_NUMBER = 9;
    public static final int DEPART_TIME_FIELD_NUMBER = 5;
    public static final int DEPART_TIME_STR_FIELD_NUMBER = 11;
    public static final int END_AIRPORT_NAME_FIELD_NUMBER = 4;
    public static final int FLIGHT_NO_FIELD_NUMBER = 2;
    public static final int FLIGHT_STATE_FIELD_NUMBER = 22;
    public static final int IS_DELAY_FIELD_NUMBER = 30;
    public static final int SHARE_FLIGHTNO_FIELD_NUMBER = 25;
    public static final int START_AIRPORT_NAME_FIELD_NUMBER = 3;
    public static final int SUPPLIED_BY_FIELD_NUMBER = 28;
    public static final int VERY_ZHUN_READY_ARRTIME_DATE_FIELD_NUMBER = 27;
    public static final int VERY_ZHUN_READY_DEPTIME_DATE_FIELD_NUMBER = 26;
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
    private boolean aa;
    private String ab = "";
    private boolean ac;
    private String ad = "";
    private boolean ae;
    private String af = "";
    private boolean ag;
    private int ah = 0;
    private boolean ai;
    private String aj = "";
    private int ak = -1;
    private long b = 0L;
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private long j = 0L;
    private boolean k;
    private long l = 0L;
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
    
    public static MLTripFlightInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripFlightInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripFlightInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripFlightInfo)new MLTripFlightInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripFlightInfo clear()
    {
      clearAddFlightType();
      clearFlightNo();
      clearStartAirportName();
      clearEndAirportName();
      clearDepartTime();
      clearArrivalTime();
      clearArrivalAirportCode();
      clearDepartAirportCode();
      clearDepartTerminalName();
      clearArrivalTerminalName();
      clearDepartTimeStr();
      clearArrivalTimeStr();
      clearDepartAirportNameAbbrev();
      clearDepartCityCode();
      clearDepartCityName();
      clearDepartAirportName();
      clearArrivalAirportName();
      clearArrivalAirportNameAbbrev();
      clearArrivalCityCode();
      clearArrivalCityName();
      clearCheckinTable();
      clearFlightState();
      clearBoardGate();
      clearBaggageId();
      clearShareFlightNo();
      clearVeryZhunReadyDeptimeDate();
      clearVeryZhunReadyArrtimeDate();
      clearSuppliedBy();
      clearAirline();
      clearIsDelay();
      clearAirlineUrl();
      this.ak = -1;
      return this;
    }
    
    public MLTripFlightInfo clearAddFlightType()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public MLTripFlightInfo clearAirline()
    {
      this.ae = false;
      this.af = "";
      return this;
    }
    
    public MLTripFlightInfo clearAirlineUrl()
    {
      this.ai = false;
      this.aj = "";
      return this;
    }
    
    public MLTripFlightInfo clearArrivalAirportCode()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public MLTripFlightInfo clearArrivalAirportName()
    {
      this.G = false;
      this.H = "";
      return this;
    }
    
    public MLTripFlightInfo clearArrivalAirportNameAbbrev()
    {
      this.I = false;
      this.J = "";
      return this;
    }
    
    public MLTripFlightInfo clearArrivalCityCode()
    {
      this.K = false;
      this.L = "";
      return this;
    }
    
    public MLTripFlightInfo clearArrivalCityName()
    {
      this.M = false;
      this.N = "";
      return this;
    }
    
    public MLTripFlightInfo clearArrivalTerminalName()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public MLTripFlightInfo clearArrivalTime()
    {
      this.k = false;
      this.l = 0L;
      return this;
    }
    
    public MLTripFlightInfo clearArrivalTimeStr()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public MLTripFlightInfo clearBaggageId()
    {
      this.U = false;
      this.V = "";
      return this;
    }
    
    public MLTripFlightInfo clearBoardGate()
    {
      this.S = false;
      this.T = "";
      return this;
    }
    
    public MLTripFlightInfo clearCheckinTable()
    {
      this.O = false;
      this.P = "";
      return this;
    }
    
    public MLTripFlightInfo clearDepartAirportCode()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public MLTripFlightInfo clearDepartAirportName()
    {
      this.E = false;
      this.F = "";
      return this;
    }
    
    public MLTripFlightInfo clearDepartAirportNameAbbrev()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public MLTripFlightInfo clearDepartCityCode()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public MLTripFlightInfo clearDepartCityName()
    {
      this.C = false;
      this.D = "";
      return this;
    }
    
    public MLTripFlightInfo clearDepartTerminalName()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public MLTripFlightInfo clearDepartTime()
    {
      this.i = false;
      this.j = 0L;
      return this;
    }
    
    public MLTripFlightInfo clearDepartTimeStr()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public MLTripFlightInfo clearEndAirportName()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLTripFlightInfo clearFlightNo()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLTripFlightInfo clearFlightState()
    {
      this.Q = false;
      this.R = "";
      return this;
    }
    
    public MLTripFlightInfo clearIsDelay()
    {
      this.ag = false;
      this.ah = 0;
      return this;
    }
    
    public MLTripFlightInfo clearShareFlightNo()
    {
      this.W = false;
      this.X = "";
      return this;
    }
    
    public MLTripFlightInfo clearStartAirportName()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLTripFlightInfo clearSuppliedBy()
    {
      this.ac = false;
      this.ad = "";
      return this;
    }
    
    public MLTripFlightInfo clearVeryZhunReadyArrtimeDate()
    {
      this.aa = false;
      this.ab = "";
      return this;
    }
    
    public MLTripFlightInfo clearVeryZhunReadyDeptimeDate()
    {
      this.Y = false;
      this.Z = "";
      return this;
    }
    
    public long getAddFlightType()
    {
      return this.b;
    }
    
    public String getAirline()
    {
      return this.af;
    }
    
    public String getAirlineUrl()
    {
      return this.aj;
    }
    
    public String getArrivalAirportCode()
    {
      return this.n;
    }
    
    public String getArrivalAirportName()
    {
      return this.H;
    }
    
    public String getArrivalAirportNameAbbrev()
    {
      return this.J;
    }
    
    public String getArrivalCityCode()
    {
      return this.L;
    }
    
    public String getArrivalCityName()
    {
      return this.N;
    }
    
    public String getArrivalTerminalName()
    {
      return this.t;
    }
    
    public long getArrivalTime()
    {
      return this.l;
    }
    
    public String getArrivalTimeStr()
    {
      return this.x;
    }
    
    public String getBaggageId()
    {
      return this.V;
    }
    
    public String getBoardGate()
    {
      return this.T;
    }
    
    public int getCachedSize()
    {
      if (this.ak < 0) {
        getSerializedSize();
      }
      return this.ak;
    }
    
    public String getCheckinTable()
    {
      return this.P;
    }
    
    public String getDepartAirportCode()
    {
      return this.p;
    }
    
    public String getDepartAirportName()
    {
      return this.F;
    }
    
    public String getDepartAirportNameAbbrev()
    {
      return this.z;
    }
    
    public String getDepartCityCode()
    {
      return this.B;
    }
    
    public String getDepartCityName()
    {
      return this.D;
    }
    
    public String getDepartTerminalName()
    {
      return this.r;
    }
    
    public long getDepartTime()
    {
      return this.j;
    }
    
    public String getDepartTimeStr()
    {
      return this.v;
    }
    
    public String getEndAirportName()
    {
      return this.h;
    }
    
    public String getFlightNo()
    {
      return this.d;
    }
    
    public String getFlightState()
    {
      return this.R;
    }
    
    public int getIsDelay()
    {
      return this.ah;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasAddFlightType()) {
        i2 = 0 + CodedOutputStreamMicro.computeInt64Size(1, getAddFlightType());
      }
      int i1 = i2;
      if (hasFlightNo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getFlightNo());
      }
      i2 = i1;
      if (hasStartAirportName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getStartAirportName());
      }
      i1 = i2;
      if (hasEndAirportName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getEndAirportName());
      }
      i2 = i1;
      if (hasDepartTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(5, getDepartTime());
      }
      i1 = i2;
      if (hasArrivalTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(6, getArrivalTime());
      }
      i2 = i1;
      if (hasArrivalAirportCode()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getArrivalAirportCode());
      }
      i1 = i2;
      if (hasDepartAirportCode()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getDepartAirportCode());
      }
      i2 = i1;
      if (hasDepartTerminalName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getDepartTerminalName());
      }
      i1 = i2;
      if (hasArrivalTerminalName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getArrivalTerminalName());
      }
      i2 = i1;
      if (hasDepartTimeStr()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getDepartTimeStr());
      }
      i1 = i2;
      if (hasArrivalTimeStr()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getArrivalTimeStr());
      }
      i2 = i1;
      if (hasDepartAirportNameAbbrev()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getDepartAirportNameAbbrev());
      }
      i1 = i2;
      if (hasDepartCityCode()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getDepartCityCode());
      }
      i2 = i1;
      if (hasDepartCityName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getDepartCityName());
      }
      i1 = i2;
      if (hasDepartAirportName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(16, getDepartAirportName());
      }
      i2 = i1;
      if (hasArrivalAirportName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(17, getArrivalAirportName());
      }
      i1 = i2;
      if (hasArrivalAirportNameAbbrev()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(18, getArrivalAirportNameAbbrev());
      }
      i2 = i1;
      if (hasArrivalCityCode()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(19, getArrivalCityCode());
      }
      i1 = i2;
      if (hasArrivalCityName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(20, getArrivalCityName());
      }
      i2 = i1;
      if (hasCheckinTable()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(21, getCheckinTable());
      }
      i1 = i2;
      if (hasFlightState()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(22, getFlightState());
      }
      i2 = i1;
      if (hasBoardGate()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(23, getBoardGate());
      }
      i1 = i2;
      if (hasBaggageId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(24, getBaggageId());
      }
      i2 = i1;
      if (hasShareFlightNo()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(25, getShareFlightNo());
      }
      i1 = i2;
      if (hasVeryZhunReadyDeptimeDate()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(26, getVeryZhunReadyDeptimeDate());
      }
      i2 = i1;
      if (hasVeryZhunReadyArrtimeDate()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(27, getVeryZhunReadyArrtimeDate());
      }
      i1 = i2;
      if (hasSuppliedBy()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(28, getSuppliedBy());
      }
      i2 = i1;
      if (hasAirline()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(29, getAirline());
      }
      i1 = i2;
      if (hasIsDelay()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(30, getIsDelay());
      }
      i2 = i1;
      if (hasAirlineUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(31, getAirlineUrl());
      }
      this.ak = i2;
      return i2;
    }
    
    public String getShareFlightNo()
    {
      return this.X;
    }
    
    public String getStartAirportName()
    {
      return this.f;
    }
    
    public String getSuppliedBy()
    {
      return this.ad;
    }
    
    public String getVeryZhunReadyArrtimeDate()
    {
      return this.ab;
    }
    
    public String getVeryZhunReadyDeptimeDate()
    {
      return this.Z;
    }
    
    public boolean hasAddFlightType()
    {
      return this.a;
    }
    
    public boolean hasAirline()
    {
      return this.ae;
    }
    
    public boolean hasAirlineUrl()
    {
      return this.ai;
    }
    
    public boolean hasArrivalAirportCode()
    {
      return this.m;
    }
    
    public boolean hasArrivalAirportName()
    {
      return this.G;
    }
    
    public boolean hasArrivalAirportNameAbbrev()
    {
      return this.I;
    }
    
    public boolean hasArrivalCityCode()
    {
      return this.K;
    }
    
    public boolean hasArrivalCityName()
    {
      return this.M;
    }
    
    public boolean hasArrivalTerminalName()
    {
      return this.s;
    }
    
    public boolean hasArrivalTime()
    {
      return this.k;
    }
    
    public boolean hasArrivalTimeStr()
    {
      return this.w;
    }
    
    public boolean hasBaggageId()
    {
      return this.U;
    }
    
    public boolean hasBoardGate()
    {
      return this.S;
    }
    
    public boolean hasCheckinTable()
    {
      return this.O;
    }
    
    public boolean hasDepartAirportCode()
    {
      return this.o;
    }
    
    public boolean hasDepartAirportName()
    {
      return this.E;
    }
    
    public boolean hasDepartAirportNameAbbrev()
    {
      return this.y;
    }
    
    public boolean hasDepartCityCode()
    {
      return this.A;
    }
    
    public boolean hasDepartCityName()
    {
      return this.C;
    }
    
    public boolean hasDepartTerminalName()
    {
      return this.q;
    }
    
    public boolean hasDepartTime()
    {
      return this.i;
    }
    
    public boolean hasDepartTimeStr()
    {
      return this.u;
    }
    
    public boolean hasEndAirportName()
    {
      return this.g;
    }
    
    public boolean hasFlightNo()
    {
      return this.c;
    }
    
    public boolean hasFlightState()
    {
      return this.Q;
    }
    
    public boolean hasIsDelay()
    {
      return this.ag;
    }
    
    public boolean hasShareFlightNo()
    {
      return this.W;
    }
    
    public boolean hasStartAirportName()
    {
      return this.e;
    }
    
    public boolean hasSuppliedBy()
    {
      return this.ac;
    }
    
    public boolean hasVeryZhunReadyArrtimeDate()
    {
      return this.aa;
    }
    
    public boolean hasVeryZhunReadyDeptimeDate()
    {
      return this.Y;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MLTripFlightInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setAddFlightType(paramCodedInputStreamMicro.readInt64());
          break;
        case 18: 
          setFlightNo(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setStartAirportName(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setEndAirportName(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setDepartTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 48: 
          setArrivalTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 58: 
          setArrivalAirportCode(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setDepartAirportCode(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setDepartTerminalName(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setArrivalTerminalName(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setDepartTimeStr(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setArrivalTimeStr(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setDepartAirportNameAbbrev(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setDepartCityCode(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setDepartCityName(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          setDepartAirportName(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          setArrivalAirportName(paramCodedInputStreamMicro.readString());
          break;
        case 146: 
          setArrivalAirportNameAbbrev(paramCodedInputStreamMicro.readString());
          break;
        case 154: 
          setArrivalCityCode(paramCodedInputStreamMicro.readString());
          break;
        case 162: 
          setArrivalCityName(paramCodedInputStreamMicro.readString());
          break;
        case 170: 
          setCheckinTable(paramCodedInputStreamMicro.readString());
          break;
        case 178: 
          setFlightState(paramCodedInputStreamMicro.readString());
          break;
        case 186: 
          setBoardGate(paramCodedInputStreamMicro.readString());
          break;
        case 194: 
          setBaggageId(paramCodedInputStreamMicro.readString());
          break;
        case 202: 
          setShareFlightNo(paramCodedInputStreamMicro.readString());
          break;
        case 210: 
          setVeryZhunReadyDeptimeDate(paramCodedInputStreamMicro.readString());
          break;
        case 218: 
          setVeryZhunReadyArrtimeDate(paramCodedInputStreamMicro.readString());
          break;
        case 226: 
          setSuppliedBy(paramCodedInputStreamMicro.readString());
          break;
        case 234: 
          setAirline(paramCodedInputStreamMicro.readString());
          break;
        case 240: 
          setIsDelay(paramCodedInputStreamMicro.readInt32());
          break;
        case 250: 
          setAirlineUrl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLTripFlightInfo setAddFlightType(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public MLTripFlightInfo setAirline(String paramString)
    {
      this.ae = true;
      this.af = paramString;
      return this;
    }
    
    public MLTripFlightInfo setAirlineUrl(String paramString)
    {
      this.ai = true;
      this.aj = paramString;
      return this;
    }
    
    public MLTripFlightInfo setArrivalAirportCode(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public MLTripFlightInfo setArrivalAirportName(String paramString)
    {
      this.G = true;
      this.H = paramString;
      return this;
    }
    
    public MLTripFlightInfo setArrivalAirportNameAbbrev(String paramString)
    {
      this.I = true;
      this.J = paramString;
      return this;
    }
    
    public MLTripFlightInfo setArrivalCityCode(String paramString)
    {
      this.K = true;
      this.L = paramString;
      return this;
    }
    
    public MLTripFlightInfo setArrivalCityName(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }
    
    public MLTripFlightInfo setArrivalTerminalName(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public MLTripFlightInfo setArrivalTime(long paramLong)
    {
      this.k = true;
      this.l = paramLong;
      return this;
    }
    
    public MLTripFlightInfo setArrivalTimeStr(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public MLTripFlightInfo setBaggageId(String paramString)
    {
      this.U = true;
      this.V = paramString;
      return this;
    }
    
    public MLTripFlightInfo setBoardGate(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }
    
    public MLTripFlightInfo setCheckinTable(String paramString)
    {
      this.O = true;
      this.P = paramString;
      return this;
    }
    
    public MLTripFlightInfo setDepartAirportCode(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public MLTripFlightInfo setDepartAirportName(String paramString)
    {
      this.E = true;
      this.F = paramString;
      return this;
    }
    
    public MLTripFlightInfo setDepartAirportNameAbbrev(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public MLTripFlightInfo setDepartCityCode(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public MLTripFlightInfo setDepartCityName(String paramString)
    {
      this.C = true;
      this.D = paramString;
      return this;
    }
    
    public MLTripFlightInfo setDepartTerminalName(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public MLTripFlightInfo setDepartTime(long paramLong)
    {
      this.i = true;
      this.j = paramLong;
      return this;
    }
    
    public MLTripFlightInfo setDepartTimeStr(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public MLTripFlightInfo setEndAirportName(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLTripFlightInfo setFlightNo(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLTripFlightInfo setFlightState(String paramString)
    {
      this.Q = true;
      this.R = paramString;
      return this;
    }
    
    public MLTripFlightInfo setIsDelay(int paramInt)
    {
      this.ag = true;
      this.ah = paramInt;
      return this;
    }
    
    public MLTripFlightInfo setShareFlightNo(String paramString)
    {
      this.W = true;
      this.X = paramString;
      return this;
    }
    
    public MLTripFlightInfo setStartAirportName(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLTripFlightInfo setSuppliedBy(String paramString)
    {
      this.ac = true;
      this.ad = paramString;
      return this;
    }
    
    public MLTripFlightInfo setVeryZhunReadyArrtimeDate(String paramString)
    {
      this.aa = true;
      this.ab = paramString;
      return this;
    }
    
    public MLTripFlightInfo setVeryZhunReadyDeptimeDate(String paramString)
    {
      this.Y = true;
      this.Z = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAddFlightType()) {
        paramCodedOutputStreamMicro.writeInt64(1, getAddFlightType());
      }
      if (hasFlightNo()) {
        paramCodedOutputStreamMicro.writeString(2, getFlightNo());
      }
      if (hasStartAirportName()) {
        paramCodedOutputStreamMicro.writeString(3, getStartAirportName());
      }
      if (hasEndAirportName()) {
        paramCodedOutputStreamMicro.writeString(4, getEndAirportName());
      }
      if (hasDepartTime()) {
        paramCodedOutputStreamMicro.writeInt64(5, getDepartTime());
      }
      if (hasArrivalTime()) {
        paramCodedOutputStreamMicro.writeInt64(6, getArrivalTime());
      }
      if (hasArrivalAirportCode()) {
        paramCodedOutputStreamMicro.writeString(7, getArrivalAirportCode());
      }
      if (hasDepartAirportCode()) {
        paramCodedOutputStreamMicro.writeString(8, getDepartAirportCode());
      }
      if (hasDepartTerminalName()) {
        paramCodedOutputStreamMicro.writeString(9, getDepartTerminalName());
      }
      if (hasArrivalTerminalName()) {
        paramCodedOutputStreamMicro.writeString(10, getArrivalTerminalName());
      }
      if (hasDepartTimeStr()) {
        paramCodedOutputStreamMicro.writeString(11, getDepartTimeStr());
      }
      if (hasArrivalTimeStr()) {
        paramCodedOutputStreamMicro.writeString(12, getArrivalTimeStr());
      }
      if (hasDepartAirportNameAbbrev()) {
        paramCodedOutputStreamMicro.writeString(13, getDepartAirportNameAbbrev());
      }
      if (hasDepartCityCode()) {
        paramCodedOutputStreamMicro.writeString(14, getDepartCityCode());
      }
      if (hasDepartCityName()) {
        paramCodedOutputStreamMicro.writeString(15, getDepartCityName());
      }
      if (hasDepartAirportName()) {
        paramCodedOutputStreamMicro.writeString(16, getDepartAirportName());
      }
      if (hasArrivalAirportName()) {
        paramCodedOutputStreamMicro.writeString(17, getArrivalAirportName());
      }
      if (hasArrivalAirportNameAbbrev()) {
        paramCodedOutputStreamMicro.writeString(18, getArrivalAirportNameAbbrev());
      }
      if (hasArrivalCityCode()) {
        paramCodedOutputStreamMicro.writeString(19, getArrivalCityCode());
      }
      if (hasArrivalCityName()) {
        paramCodedOutputStreamMicro.writeString(20, getArrivalCityName());
      }
      if (hasCheckinTable()) {
        paramCodedOutputStreamMicro.writeString(21, getCheckinTable());
      }
      if (hasFlightState()) {
        paramCodedOutputStreamMicro.writeString(22, getFlightState());
      }
      if (hasBoardGate()) {
        paramCodedOutputStreamMicro.writeString(23, getBoardGate());
      }
      if (hasBaggageId()) {
        paramCodedOutputStreamMicro.writeString(24, getBaggageId());
      }
      if (hasShareFlightNo()) {
        paramCodedOutputStreamMicro.writeString(25, getShareFlightNo());
      }
      if (hasVeryZhunReadyDeptimeDate()) {
        paramCodedOutputStreamMicro.writeString(26, getVeryZhunReadyDeptimeDate());
      }
      if (hasVeryZhunReadyArrtimeDate()) {
        paramCodedOutputStreamMicro.writeString(27, getVeryZhunReadyArrtimeDate());
      }
      if (hasSuppliedBy()) {
        paramCodedOutputStreamMicro.writeString(28, getSuppliedBy());
      }
      if (hasAirline()) {
        paramCodedOutputStreamMicro.writeString(29, getAirline());
      }
      if (hasIsDelay()) {
        paramCodedOutputStreamMicro.writeInt32(30, getIsDelay());
      }
      if (hasAirlineUrl()) {
        paramCodedOutputStreamMicro.writeString(31, getAirlineUrl());
      }
    }
  }
  
  public static final class MLTripGroup
    extends MessageMicro
  {
    public static final int DATA_FIELD_NUMBER = 2;
    public static final int DAY_FIELD_NUMBER = 1;
    private boolean a;
    private long b = 0L;
    private List<TaResponse.MLTripGroupData> c = Collections.emptyList();
    private int d = -1;
    
    public static MLTripGroup parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripGroup().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripGroup parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripGroup)new MLTripGroup().mergeFrom(paramArrayOfByte);
    }
    
    public MLTripGroup addData(TaResponse.MLTripGroupData paramMLTripGroupData)
    {
      if (paramMLTripGroupData == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramMLTripGroupData);
      return this;
    }
    
    public final MLTripGroup clear()
    {
      clearDay();
      clearData();
      this.d = -1;
      return this;
    }
    
    public MLTripGroup clearData()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public MLTripGroup clearDay()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public TaResponse.MLTripGroupData getData(int paramInt)
    {
      return (TaResponse.MLTripGroupData)this.c.get(paramInt);
    }
    
    public int getDataCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.MLTripGroupData> getDataList()
    {
      return this.c;
    }
    
    public long getDay()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasDay()) {
        i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getDay());
      }
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.MLTripGroupData)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasDay()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {
        return false;
      }
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        if (!((TaResponse.MLTripGroupData)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public MLTripGroup mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setDay(paramCodedInputStreamMicro.readInt64());
          break;
        case 18: 
          TaResponse.MLTripGroupData localMLTripGroupData = new TaResponse.MLTripGroupData();
          paramCodedInputStreamMicro.readMessage(localMLTripGroupData);
          addData(localMLTripGroupData);
        }
      }
    }
    
    public MLTripGroup setData(int paramInt, TaResponse.MLTripGroupData paramMLTripGroupData)
    {
      if (paramMLTripGroupData == null) {
        return this;
      }
      this.c.set(paramInt, paramMLTripGroupData);
      return this;
    }
    
    public MLTripGroup setDay(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasDay()) {
        paramCodedOutputStreamMicro.writeInt64(1, getDay());
      }
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.MLTripGroupData)localIterator.next());
      }
    }
  }
  
  public static final class MLTripGroupData
    extends MessageMicro
  {
    public static final int GTYPE_FIELD_NUMBER = 1;
    public static final int SEP_FIELD_NUMBER = 2;
    public static final int TRIP_FIELD_NUMBER = 3;
    public static final int WEATHER_FIELD_NUMBER = 4;
    private boolean a;
    private String b = "";
    private boolean c;
    private TaResponse.MLTripCitySep d = null;
    private boolean e;
    private TaResponse.MLTrip f = null;
    private boolean g;
    private TaResponse.MLWeahterSep h = null;
    private int i = -1;
    
    public static MLTripGroupData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripGroupData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripGroupData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripGroupData)new MLTripGroupData().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripGroupData clear()
    {
      clearGtype();
      clearSep();
      clearTrip();
      clearWeather();
      this.i = -1;
      return this;
    }
    
    public MLTripGroupData clearGtype()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTripGroupData clearSep()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public MLTripGroupData clearTrip()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public MLTripGroupData clearWeather()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public String getGtype()
    {
      return this.b;
    }
    
    public TaResponse.MLTripCitySep getSep()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasGtype()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getGtype());
      }
      int j = k;
      if (hasSep()) {
        j = k + CodedOutputStreamMicro.computeMessageSize(2, getSep());
      }
      k = j;
      if (hasTrip()) {
        k = j + CodedOutputStreamMicro.computeMessageSize(3, getTrip());
      }
      j = k;
      if (hasWeather()) {
        j = k + CodedOutputStreamMicro.computeMessageSize(4, getWeather());
      }
      this.i = j;
      return j;
    }
    
    public TaResponse.MLTrip getTrip()
    {
      return this.f;
    }
    
    public TaResponse.MLWeahterSep getWeather()
    {
      return this.h;
    }
    
    public boolean hasGtype()
    {
      return this.a;
    }
    
    public boolean hasSep()
    {
      return this.c;
    }
    
    public boolean hasTrip()
    {
      return this.e;
    }
    
    public boolean hasWeather()
    {
      return this.g;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while (((hasSep()) && (!getSep().isInitialized())) || ((hasTrip()) && (!getTrip().isInitialized()))) {
        return false;
      }
      return true;
    }
    
    public MLTripGroupData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setGtype(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          localObject = new TaResponse.MLTripCitySep();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setSep((TaResponse.MLTripCitySep)localObject);
          break;
        case 26: 
          localObject = new TaResponse.MLTrip();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTrip((TaResponse.MLTrip)localObject);
          break;
        case 34: 
          localObject = new TaResponse.MLWeahterSep();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setWeather((TaResponse.MLWeahterSep)localObject);
        }
      }
    }
    
    public MLTripGroupData setGtype(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTripGroupData setSep(TaResponse.MLTripCitySep paramMLTripCitySep)
    {
      if (paramMLTripCitySep == null) {
        return clearSep();
      }
      this.c = true;
      this.d = paramMLTripCitySep;
      return this;
    }
    
    public MLTripGroupData setTrip(TaResponse.MLTrip paramMLTrip)
    {
      if (paramMLTrip == null) {
        return clearTrip();
      }
      this.e = true;
      this.f = paramMLTrip;
      return this;
    }
    
    public MLTripGroupData setWeather(TaResponse.MLWeahterSep paramMLWeahterSep)
    {
      if (paramMLWeahterSep == null) {
        return clearWeather();
      }
      this.g = true;
      this.h = paramMLWeahterSep;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasGtype()) {
        paramCodedOutputStreamMicro.writeString(1, getGtype());
      }
      if (hasSep()) {
        paramCodedOutputStreamMicro.writeMessage(2, getSep());
      }
      if (hasTrip()) {
        paramCodedOutputStreamMicro.writeMessage(3, getTrip());
      }
      if (hasWeather()) {
        paramCodedOutputStreamMicro.writeMessage(4, getWeather());
      }
    }
  }
  
  public static final class MLTripPoint
    extends MessageMicro
  {
    public static final int ADDRESS_FIELD_NUMBER = 7;
    public static final int CITY_ID_FIELD_NUMBER = 8;
    public static final int CITY_NAME_FIELD_NUMBER = 6;
    public static final int DETAIL_URL_FIELD_NUMBER = 9;
    public static final int ICON_FIELD_NUMBER = 10;
    public static final int LOC_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int POINT_TYPE_FIELD_NUMBER = 1;
    public static final int PUID_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 4;
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
    private List<TaResponse.MLTripCardIconInfo> s = Collections.emptyList();
    private int t = -1;
    
    public static MLTripPoint parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripPoint().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripPoint parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripPoint)new MLTripPoint().mergeFrom(paramArrayOfByte);
    }
    
    public MLTripPoint addIcon(TaResponse.MLTripCardIconInfo paramMLTripCardIconInfo)
    {
      if (paramMLTripCardIconInfo == null) {
        return this;
      }
      if (this.s.isEmpty()) {
        this.s = new ArrayList();
      }
      this.s.add(paramMLTripCardIconInfo);
      return this;
    }
    
    public final MLTripPoint clear()
    {
      clearPointType();
      clearName();
      clearLoc();
      clearUid();
      clearPuid();
      clearCityName();
      clearAddress();
      clearCityId();
      clearDetailUrl();
      clearIcon();
      this.t = -1;
      return this;
    }
    
    public MLTripPoint clearAddress()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public MLTripPoint clearCityId()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public MLTripPoint clearCityName()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public MLTripPoint clearDetailUrl()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public MLTripPoint clearIcon()
    {
      this.s = Collections.emptyList();
      return this;
    }
    
    public MLTripPoint clearLoc()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLTripPoint clearName()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLTripPoint clearPointType()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTripPoint clearPuid()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public MLTripPoint clearUid()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public String getAddress()
    {
      return this.n;
    }
    
    public int getCachedSize()
    {
      if (this.t < 0) {
        getSerializedSize();
      }
      return this.t;
    }
    
    public String getCityId()
    {
      return this.p;
    }
    
    public String getCityName()
    {
      return this.l;
    }
    
    public String getDetailUrl()
    {
      return this.r;
    }
    
    public TaResponse.MLTripCardIconInfo getIcon(int paramInt)
    {
      return (TaResponse.MLTripCardIconInfo)this.s.get(paramInt);
    }
    
    public int getIconCount()
    {
      return this.s.size();
    }
    
    public List<TaResponse.MLTripCardIconInfo> getIconList()
    {
      return this.s;
    }
    
    public String getLoc()
    {
      return this.f;
    }
    
    public String getName()
    {
      return this.d;
    }
    
    public String getPointType()
    {
      return this.b;
    }
    
    public String getPuid()
    {
      return this.j;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasPointType()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getPointType());
      }
      int i1 = i2;
      if (hasName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getName());
      }
      i2 = i1;
      if (hasLoc()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getLoc());
      }
      i1 = i2;
      if (hasUid()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getUid());
      }
      i2 = i1;
      if (hasPuid()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getPuid());
      }
      i1 = i2;
      if (hasCityName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getCityName());
      }
      i2 = i1;
      if (hasAddress()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getAddress());
      }
      i1 = i2;
      if (hasCityId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getCityId());
      }
      i2 = i1;
      if (hasDetailUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getDetailUrl());
      }
      Iterator localIterator = getIconList().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(10, (TaResponse.MLTripCardIconInfo)localIterator.next()) + i2;
      }
      this.t = i2;
      return i2;
    }
    
    public String getUid()
    {
      return this.h;
    }
    
    public boolean hasAddress()
    {
      return this.m;
    }
    
    public boolean hasCityId()
    {
      return this.o;
    }
    
    public boolean hasCityName()
    {
      return this.k;
    }
    
    public boolean hasDetailUrl()
    {
      return this.q;
    }
    
    public boolean hasLoc()
    {
      return this.e;
    }
    
    public boolean hasName()
    {
      return this.c;
    }
    
    public boolean hasPointType()
    {
      return this.a;
    }
    
    public boolean hasPuid()
    {
      return this.i;
    }
    
    public boolean hasUid()
    {
      return this.g;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g)) {
        return false;
      }
      return true;
    }
    
    public MLTripPoint mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setPointType(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setLoc(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setPuid(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setCityName(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setAddress(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setCityId(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setDetailUrl(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          TaResponse.MLTripCardIconInfo localMLTripCardIconInfo = new TaResponse.MLTripCardIconInfo();
          paramCodedInputStreamMicro.readMessage(localMLTripCardIconInfo);
          addIcon(localMLTripCardIconInfo);
        }
      }
    }
    
    public MLTripPoint setAddress(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public MLTripPoint setCityId(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public MLTripPoint setCityName(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public MLTripPoint setDetailUrl(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public MLTripPoint setIcon(int paramInt, TaResponse.MLTripCardIconInfo paramMLTripCardIconInfo)
    {
      if (paramMLTripCardIconInfo == null) {
        return this;
      }
      this.s.set(paramInt, paramMLTripCardIconInfo);
      return this;
    }
    
    public MLTripPoint setLoc(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLTripPoint setName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLTripPoint setPointType(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTripPoint setPuid(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public MLTripPoint setUid(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPointType()) {
        paramCodedOutputStreamMicro.writeString(1, getPointType());
      }
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(2, getName());
      }
      if (hasLoc()) {
        paramCodedOutputStreamMicro.writeString(3, getLoc());
      }
      if (hasUid()) {
        paramCodedOutputStreamMicro.writeString(4, getUid());
      }
      if (hasPuid()) {
        paramCodedOutputStreamMicro.writeString(5, getPuid());
      }
      if (hasCityName()) {
        paramCodedOutputStreamMicro.writeString(6, getCityName());
      }
      if (hasAddress()) {
        paramCodedOutputStreamMicro.writeString(7, getAddress());
      }
      if (hasCityId()) {
        paramCodedOutputStreamMicro.writeString(8, getCityId());
      }
      if (hasDetailUrl()) {
        paramCodedOutputStreamMicro.writeString(9, getDetailUrl());
      }
      Iterator localIterator = getIconList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(10, (TaResponse.MLTripCardIconInfo)localIterator.next());
      }
    }
  }
  
  public static final class MLTripSugInfo
    extends MessageMicro
  {
    public static final int DISTANCE_FIELD_NUMBER = 2;
    public static final int ICON_URL_FIELD_NUMBER = 5;
    public static final int JUMP_URL_FIELD_NUMBER = 6;
    public static final int LEAD_TITLE_FIELD_NUMBER = 1;
    public static final int MORE_URL_FIELD_NUMBER = 8;
    public static final int POINT_FIELD_NUMBER = 4;
    public static final int SUG_FLAG_FIELD_NUMBER = 9;
    public static final int TAG_FIELD_NUMBER = 7;
    public static final int TAKE_TIME_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private TaResponse.MLTripPoint h = null;
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
    
    public static MLTripSugInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripSugInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripSugInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripSugInfo)new MLTripSugInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripSugInfo clear()
    {
      clearLeadTitle();
      clearDistance();
      clearTakeTime();
      clearPoint();
      clearIconUrl();
      clearJumpUrl();
      clearTag();
      clearMoreUrl();
      clearSugFlag();
      this.s = -1;
      return this;
    }
    
    public MLTripSugInfo clearDistance()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLTripSugInfo clearIconUrl()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public MLTripSugInfo clearJumpUrl()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public MLTripSugInfo clearLeadTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTripSugInfo clearMoreUrl()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public MLTripSugInfo clearPoint()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public MLTripSugInfo clearSugFlag()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public MLTripSugInfo clearTag()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public MLTripSugInfo clearTakeTime()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.s < 0) {
        getSerializedSize();
      }
      return this.s;
    }
    
    public String getDistance()
    {
      return this.d;
    }
    
    public String getIconUrl()
    {
      return this.j;
    }
    
    public String getJumpUrl()
    {
      return this.l;
    }
    
    public String getLeadTitle()
    {
      return this.b;
    }
    
    public String getMoreUrl()
    {
      return this.p;
    }
    
    public TaResponse.MLTripPoint getPoint()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasLeadTitle()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getLeadTitle());
      }
      int i1 = i2;
      if (hasDistance()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getDistance());
      }
      i2 = i1;
      if (hasTakeTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getTakeTime());
      }
      i1 = i2;
      if (hasPoint()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(4, getPoint());
      }
      i2 = i1;
      if (hasIconUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getIconUrl());
      }
      i1 = i2;
      if (hasJumpUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getJumpUrl());
      }
      i2 = i1;
      if (hasTag()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getTag());
      }
      i1 = i2;
      if (hasMoreUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getMoreUrl());
      }
      i2 = i1;
      if (hasSugFlag()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getSugFlag());
      }
      this.s = i2;
      return i2;
    }
    
    public String getSugFlag()
    {
      return this.r;
    }
    
    public String getTag()
    {
      return this.n;
    }
    
    public String getTakeTime()
    {
      return this.f;
    }
    
    public boolean hasDistance()
    {
      return this.c;
    }
    
    public boolean hasIconUrl()
    {
      return this.i;
    }
    
    public boolean hasJumpUrl()
    {
      return this.k;
    }
    
    public boolean hasLeadTitle()
    {
      return this.a;
    }
    
    public boolean hasMoreUrl()
    {
      return this.o;
    }
    
    public boolean hasPoint()
    {
      return this.g;
    }
    
    public boolean hasSugFlag()
    {
      return this.q;
    }
    
    public boolean hasTag()
    {
      return this.m;
    }
    
    public boolean hasTakeTime()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return (!hasPoint()) || (getPoint().isInitialized());
    }
    
    public MLTripSugInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setLeadTitle(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setDistance(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTakeTime(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          TaResponse.MLTripPoint localMLTripPoint = new TaResponse.MLTripPoint();
          paramCodedInputStreamMicro.readMessage(localMLTripPoint);
          setPoint(localMLTripPoint);
          break;
        case 42: 
          setIconUrl(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setTag(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setMoreUrl(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setSugFlag(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLTripSugInfo setDistance(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLTripSugInfo setIconUrl(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public MLTripSugInfo setJumpUrl(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public MLTripSugInfo setLeadTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTripSugInfo setMoreUrl(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public MLTripSugInfo setPoint(TaResponse.MLTripPoint paramMLTripPoint)
    {
      if (paramMLTripPoint == null) {
        return clearPoint();
      }
      this.g = true;
      this.h = paramMLTripPoint;
      return this;
    }
    
    public MLTripSugInfo setSugFlag(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public MLTripSugInfo setTag(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public MLTripSugInfo setTakeTime(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasLeadTitle()) {
        paramCodedOutputStreamMicro.writeString(1, getLeadTitle());
      }
      if (hasDistance()) {
        paramCodedOutputStreamMicro.writeString(2, getDistance());
      }
      if (hasTakeTime()) {
        paramCodedOutputStreamMicro.writeString(3, getTakeTime());
      }
      if (hasPoint()) {
        paramCodedOutputStreamMicro.writeMessage(4, getPoint());
      }
      if (hasIconUrl()) {
        paramCodedOutputStreamMicro.writeString(5, getIconUrl());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(6, getJumpUrl());
      }
      if (hasTag()) {
        paramCodedOutputStreamMicro.writeString(7, getTag());
      }
      if (hasMoreUrl()) {
        paramCodedOutputStreamMicro.writeString(8, getMoreUrl());
      }
      if (hasSugFlag()) {
        paramCodedOutputStreamMicro.writeString(9, getSugFlag());
      }
    }
  }
  
  public static final class MLTripTrainInfo
    extends MessageMicro
  {
    public static final int ARR_TIME_STR_FIELD_NUMBER = 7;
    public static final int DAY_DIFF_FIELD_NUMBER = 4;
    public static final int DEP_TIME_STR_FIELD_NUMBER = 6;
    public static final int RAILWAY_CARRIAGE_FIELD_NUMBER = 2;
    public static final int TRAIN_NO_FIELD_NUMBER = 1;
    public static final int TRAIN_SEAT_NO_FIELD_NUMBER = 3;
    public static final int TRAIN_TYPE_FIELD_NUMBER = 8;
    public static final int USE_TIME_FIELD_NUMBER = 5;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private boolean h = false;
    private boolean i;
    private int j = 0;
    private boolean k;
    private String l = "";
    private boolean m;
    private String n = "";
    private boolean o;
    private String p = "";
    private int q = -1;
    
    public static MLTripTrainInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLTripTrainInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLTripTrainInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLTripTrainInfo)new MLTripTrainInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final MLTripTrainInfo clear()
    {
      clearTrainNo();
      clearRailwayCarriage();
      clearTrainSeatNo();
      clearDayDiff();
      clearUseTime();
      clearDepTimeStr();
      clearArrTimeStr();
      clearTrainType();
      this.q = -1;
      return this;
    }
    
    public MLTripTrainInfo clearArrTimeStr()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public MLTripTrainInfo clearDayDiff()
    {
      this.g = false;
      this.h = false;
      return this;
    }
    
    public MLTripTrainInfo clearDepTimeStr()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public MLTripTrainInfo clearRailwayCarriage()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLTripTrainInfo clearTrainNo()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLTripTrainInfo clearTrainSeatNo()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLTripTrainInfo clearTrainType()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public MLTripTrainInfo clearUseTime()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public String getArrTimeStr()
    {
      return this.n;
    }
    
    public int getCachedSize()
    {
      if (this.q < 0) {
        getSerializedSize();
      }
      return this.q;
    }
    
    public boolean getDayDiff()
    {
      return this.h;
    }
    
    public String getDepTimeStr()
    {
      return this.l;
    }
    
    public String getRailwayCarriage()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasTrainNo()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTrainNo());
      }
      int i1 = i2;
      if (hasRailwayCarriage()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getRailwayCarriage());
      }
      i2 = i1;
      if (hasTrainSeatNo()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getTrainSeatNo());
      }
      i1 = i2;
      if (hasDayDiff()) {
        i1 = i2 + CodedOutputStreamMicro.computeBoolSize(4, getDayDiff());
      }
      i2 = i1;
      if (hasUseTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(5, getUseTime());
      }
      i1 = i2;
      if (hasDepTimeStr()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getDepTimeStr());
      }
      i2 = i1;
      if (hasArrTimeStr()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getArrTimeStr());
      }
      i1 = i2;
      if (hasTrainType()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getTrainType());
      }
      this.q = i1;
      return i1;
    }
    
    public String getTrainNo()
    {
      return this.b;
    }
    
    public String getTrainSeatNo()
    {
      return this.f;
    }
    
    public String getTrainType()
    {
      return this.p;
    }
    
    public int getUseTime()
    {
      return this.j;
    }
    
    public boolean hasArrTimeStr()
    {
      return this.m;
    }
    
    public boolean hasDayDiff()
    {
      return this.g;
    }
    
    public boolean hasDepTimeStr()
    {
      return this.k;
    }
    
    public boolean hasRailwayCarriage()
    {
      return this.c;
    }
    
    public boolean hasTrainNo()
    {
      return this.a;
    }
    
    public boolean hasTrainSeatNo()
    {
      return this.e;
    }
    
    public boolean hasTrainType()
    {
      return this.o;
    }
    
    public boolean hasUseTime()
    {
      return this.i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MLTripTrainInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTrainNo(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setRailwayCarriage(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTrainSeatNo(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setDayDiff(paramCodedInputStreamMicro.readBool());
          break;
        case 40: 
          setUseTime(paramCodedInputStreamMicro.readInt32());
          break;
        case 50: 
          setDepTimeStr(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setArrTimeStr(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setTrainType(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public MLTripTrainInfo setArrTimeStr(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public MLTripTrainInfo setDayDiff(boolean paramBoolean)
    {
      this.g = true;
      this.h = paramBoolean;
      return this;
    }
    
    public MLTripTrainInfo setDepTimeStr(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public MLTripTrainInfo setRailwayCarriage(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLTripTrainInfo setTrainNo(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLTripTrainInfo setTrainSeatNo(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLTripTrainInfo setTrainType(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public MLTripTrainInfo setUseTime(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTrainNo()) {
        paramCodedOutputStreamMicro.writeString(1, getTrainNo());
      }
      if (hasRailwayCarriage()) {
        paramCodedOutputStreamMicro.writeString(2, getRailwayCarriage());
      }
      if (hasTrainSeatNo()) {
        paramCodedOutputStreamMicro.writeString(3, getTrainSeatNo());
      }
      if (hasDayDiff()) {
        paramCodedOutputStreamMicro.writeBool(4, getDayDiff());
      }
      if (hasUseTime()) {
        paramCodedOutputStreamMicro.writeInt32(5, getUseTime());
      }
      if (hasDepTimeStr()) {
        paramCodedOutputStreamMicro.writeString(6, getDepTimeStr());
      }
      if (hasArrTimeStr()) {
        paramCodedOutputStreamMicro.writeString(7, getArrTimeStr());
      }
      if (hasTrainType()) {
        paramCodedOutputStreamMicro.writeString(8, getTrainType());
      }
    }
  }
  
  public static final class MLWeahterSep
    extends MessageMicro
  {
    public static final int CITY_FIELD_NUMBER = 6;
    public static final int CITY_ICON_FIELD_NUMBER = 10;
    public static final int CITY_ID_FIELD_NUMBER = 9;
    public static final int EXT_CARD_FIELD_NUMBER = 11;
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int JUMP_URL_FIELD_NUMBER = 4;
    public static final int LOC_FIELD_NUMBER = 5;
    public static final int PM25_FIELD_NUMBER = 3;
    public static final int TEMP_RANGE_FIELD_NUMBER = 8;
    public static final int TEXT_FIELD_NUMBER = 2;
    public static final int WEATHER_FIELD_NUMBER = 7;
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
    private boolean s;
    private String t = "";
    private List<TaResponse.BaseTitleContent> u = Collections.emptyList();
    private int v = -1;
    
    public static MLWeahterSep parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MLWeahterSep().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MLWeahterSep parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MLWeahterSep)new MLWeahterSep().mergeFrom(paramArrayOfByte);
    }
    
    public MLWeahterSep addExtCard(TaResponse.BaseTitleContent paramBaseTitleContent)
    {
      if (paramBaseTitleContent == null) {
        return this;
      }
      if (this.u.isEmpty()) {
        this.u = new ArrayList();
      }
      this.u.add(paramBaseTitleContent);
      return this;
    }
    
    public final MLWeahterSep clear()
    {
      clearIcon();
      clearText();
      clearPm25();
      clearJumpUrl();
      clearLoc();
      clearCity();
      clearWeather();
      clearTempRange();
      clearCityId();
      clearCityIcon();
      clearExtCard();
      this.v = -1;
      return this;
    }
    
    public MLWeahterSep clearCity()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public MLWeahterSep clearCityIcon()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public MLWeahterSep clearCityId()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public MLWeahterSep clearExtCard()
    {
      this.u = Collections.emptyList();
      return this;
    }
    
    public MLWeahterSep clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public MLWeahterSep clearJumpUrl()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public MLWeahterSep clearLoc()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public MLWeahterSep clearPm25()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public MLWeahterSep clearTempRange()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public MLWeahterSep clearText()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public MLWeahterSep clearWeather()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.v < 0) {
        getSerializedSize();
      }
      return this.v;
    }
    
    public String getCity()
    {
      return this.l;
    }
    
    public String getCityIcon()
    {
      return this.t;
    }
    
    public String getCityId()
    {
      return this.r;
    }
    
    public TaResponse.BaseTitleContent getExtCard(int paramInt)
    {
      return (TaResponse.BaseTitleContent)this.u.get(paramInt);
    }
    
    public int getExtCardCount()
    {
      return this.u.size();
    }
    
    public List<TaResponse.BaseTitleContent> getExtCardList()
    {
      return this.u;
    }
    
    public String getIcon()
    {
      return this.b;
    }
    
    public String getJumpUrl()
    {
      return this.h;
    }
    
    public String getLoc()
    {
      return this.j;
    }
    
    public String getPm25()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasIcon()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
      }
      int i1 = i2;
      if (hasText()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getText());
      }
      i2 = i1;
      if (hasPm25()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getPm25());
      }
      i1 = i2;
      if (hasJumpUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getJumpUrl());
      }
      i2 = i1;
      if (hasLoc()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getLoc());
      }
      i1 = i2;
      if (hasCity()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getCity());
      }
      i2 = i1;
      if (hasWeather()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getWeather());
      }
      i1 = i2;
      if (hasTempRange()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getTempRange());
      }
      i2 = i1;
      if (hasCityId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getCityId());
      }
      i1 = i2;
      if (hasCityIcon()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getCityIcon());
      }
      Iterator localIterator = getExtCardList().iterator();
      while (localIterator.hasNext()) {
        i1 = CodedOutputStreamMicro.computeMessageSize(11, (TaResponse.BaseTitleContent)localIterator.next()) + i1;
      }
      this.v = i1;
      return i1;
    }
    
    public String getTempRange()
    {
      return this.p;
    }
    
    public String getText()
    {
      return this.d;
    }
    
    public String getWeather()
    {
      return this.n;
    }
    
    public boolean hasCity()
    {
      return this.k;
    }
    
    public boolean hasCityIcon()
    {
      return this.s;
    }
    
    public boolean hasCityId()
    {
      return this.q;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasJumpUrl()
    {
      return this.g;
    }
    
    public boolean hasLoc()
    {
      return this.i;
    }
    
    public boolean hasPm25()
    {
      return this.e;
    }
    
    public boolean hasTempRange()
    {
      return this.o;
    }
    
    public boolean hasText()
    {
      return this.c;
    }
    
    public boolean hasWeather()
    {
      return this.m;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MLWeahterSep mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setText(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setPm25(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setLoc(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setCity(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setWeather(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setTempRange(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setCityId(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setCityIcon(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          TaResponse.BaseTitleContent localBaseTitleContent = new TaResponse.BaseTitleContent();
          paramCodedInputStreamMicro.readMessage(localBaseTitleContent);
          addExtCard(localBaseTitleContent);
        }
      }
    }
    
    public MLWeahterSep setCity(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public MLWeahterSep setCityIcon(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public MLWeahterSep setCityId(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public MLWeahterSep setExtCard(int paramInt, TaResponse.BaseTitleContent paramBaseTitleContent)
    {
      if (paramBaseTitleContent == null) {
        return this;
      }
      this.u.set(paramInt, paramBaseTitleContent);
      return this;
    }
    
    public MLWeahterSep setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public MLWeahterSep setJumpUrl(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public MLWeahterSep setLoc(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public MLWeahterSep setPm25(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public MLWeahterSep setTempRange(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public MLWeahterSep setText(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public MLWeahterSep setWeather(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      if (hasText()) {
        paramCodedOutputStreamMicro.writeString(2, getText());
      }
      if (hasPm25()) {
        paramCodedOutputStreamMicro.writeString(3, getPm25());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(4, getJumpUrl());
      }
      if (hasLoc()) {
        paramCodedOutputStreamMicro.writeString(5, getLoc());
      }
      if (hasCity()) {
        paramCodedOutputStreamMicro.writeString(6, getCity());
      }
      if (hasWeather()) {
        paramCodedOutputStreamMicro.writeString(7, getWeather());
      }
      if (hasTempRange()) {
        paramCodedOutputStreamMicro.writeString(8, getTempRange());
      }
      if (hasCityId()) {
        paramCodedOutputStreamMicro.writeString(9, getCityId());
      }
      if (hasCityIcon()) {
        paramCodedOutputStreamMicro.writeString(10, getCityIcon());
      }
      Iterator localIterator = getExtCardList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(11, (TaResponse.BaseTitleContent)localIterator.next());
      }
    }
  }
  
  public static final class MapShowButton
    extends MessageMicro
  {
    public static final int IS_SHOW_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private int c = -1;
    
    public static MapShowButton parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MapShowButton().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MapShowButton parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MapShowButton)new MapShowButton().mergeFrom(paramArrayOfByte);
    }
    
    public final MapShowButton clear()
    {
      clearIsShow();
      this.c = -1;
      return this;
    }
    
    public MapShowButton clearIsShow()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.c < 0) {
        getSerializedSize();
      }
      return this.c;
    }
    
    public int getIsShow()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasIsShow()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsShow());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasIsShow()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public MapShowButton mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIsShow(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public MapShowButton setIsShow(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsShow()) {
        paramCodedOutputStreamMicro.writeInt32(1, getIsShow());
      }
    }
  }
  
  public static final class NMLCardResource
    extends MessageMicro
  {
    public static final int ARRIVE_CITY_NAME_FIELD_NUMBER = 6;
    public static final int ARRIVE_TIME_FIELD_NUMBER = 12;
    public static final int CARD_LINK_FIELD_NUMBER = 22;
    public static final int CARD_STATISTIC_TYPE_FIELD_NUMBER = 23;
    public static final int DEADLINE_TIME_FIELD_NUMBER = 10;
    public static final int DETAIL_TITLE_FIELD_NUMBER = 16;
    public static final int ICON_DELAY_FIELD_NUMBER = 2;
    public static final int ICON_DESC_FIELD_NUMBER = 3;
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int IS_CARLIMIT_FIELD_NUMBER = 18;
    public static final int IS_DELAY_FIELD_NUMBER = 4;
    public static final int IS_REQUEST_FIELD_NUMBER = 24;
    public static final int LEFT_TITLE1_FIELD_NUMBER = 14;
    public static final int LEFT_TITLE2_FIELD_NUMBER = 15;
    public static final int ORDER_TYPE_FIELD_NUMBER = 21;
    public static final int SHOW_TYPE_FIELD_NUMBER = 13;
    public static final int START_CITY_NAME_FIELD_NUMBER = 5;
    public static final int START_TIME_FIELD_NUMBER = 11;
    public static final int SUB_TITLE_FIELD_NUMBER = 8;
    public static final int TITLE_FIELD_NUMBER = 7;
    public static final int TRANSPORT_FIELD_NUMBER = 9;
    public static final int TRIP_EXT_FIELD_NUMBER = 17;
    public static final int TRIP_ID_FIELD_NUMBER = 19;
    public static final int TRIP_TYPE_FIELD_NUMBER = 20;
    private String A = "";
    private boolean B;
    private String C = "";
    private List<String> D = Collections.emptyList();
    private boolean E;
    private TaResponse.TripExt F = null;
    private boolean G;
    private boolean H = false;
    private boolean I;
    private String J = "";
    private boolean K;
    private int L = 0;
    private boolean M;
    private String N = "";
    private boolean O;
    private String P = "";
    private boolean Q;
    private int R = 0;
    private boolean S;
    private boolean T = false;
    private int U = -1;
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
    private String l = "";
    private boolean m;
    private String n = "";
    private boolean o;
    private String p = "";
    private List<TaResponse.Transport> q = Collections.emptyList();
    private boolean r;
    private long s = 0L;
    private boolean t;
    private String u = "";
    private boolean v;
    private String w = "";
    private boolean x;
    private int y = 0;
    private boolean z;
    
    public static NMLCardResource parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new NMLCardResource().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static NMLCardResource parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (NMLCardResource)new NMLCardResource().mergeFrom(paramArrayOfByte);
    }
    
    public NMLCardResource addDetailTitle(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.D.isEmpty()) {
        this.D = new ArrayList();
      }
      this.D.add(paramString);
      return this;
    }
    
    public NMLCardResource addTransport(TaResponse.Transport paramTransport)
    {
      if (paramTransport == null) {
        return this;
      }
      if (this.q.isEmpty()) {
        this.q = new ArrayList();
      }
      this.q.add(paramTransport);
      return this;
    }
    
    public final NMLCardResource clear()
    {
      clearIcon();
      clearIconDelay();
      clearIconDesc();
      clearIsDelay();
      clearStartCityName();
      clearArriveCityName();
      clearTitle();
      clearSubTitle();
      clearTransport();
      clearDeadlineTime();
      clearStartTime();
      clearArriveTime();
      clearShowType();
      clearLeftTitle1();
      clearLeftTitle2();
      clearDetailTitle();
      clearTripExt();
      clearIsCarlimit();
      clearTripId();
      clearTripType();
      clearOrderType();
      clearCardLink();
      clearCardStatisticType();
      clearIsRequest();
      this.U = -1;
      return this;
    }
    
    public NMLCardResource clearArriveCityName()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public NMLCardResource clearArriveTime()
    {
      this.v = false;
      this.w = "";
      return this;
    }
    
    public NMLCardResource clearCardLink()
    {
      this.O = false;
      this.P = "";
      return this;
    }
    
    public NMLCardResource clearCardStatisticType()
    {
      this.Q = false;
      this.R = 0;
      return this;
    }
    
    public NMLCardResource clearDeadlineTime()
    {
      this.r = false;
      this.s = 0L;
      return this;
    }
    
    public NMLCardResource clearDetailTitle()
    {
      this.D = Collections.emptyList();
      return this;
    }
    
    public NMLCardResource clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public NMLCardResource clearIconDelay()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public NMLCardResource clearIconDesc()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public NMLCardResource clearIsCarlimit()
    {
      this.G = false;
      this.H = false;
      return this;
    }
    
    public NMLCardResource clearIsDelay()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public NMLCardResource clearIsRequest()
    {
      this.S = false;
      this.T = false;
      return this;
    }
    
    public NMLCardResource clearLeftTitle1()
    {
      this.z = false;
      this.A = "";
      return this;
    }
    
    public NMLCardResource clearLeftTitle2()
    {
      this.B = false;
      this.C = "";
      return this;
    }
    
    public NMLCardResource clearOrderType()
    {
      this.M = false;
      this.N = "";
      return this;
    }
    
    public NMLCardResource clearShowType()
    {
      this.x = false;
      this.y = 0;
      return this;
    }
    
    public NMLCardResource clearStartCityName()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public NMLCardResource clearStartTime()
    {
      this.t = false;
      this.u = "";
      return this;
    }
    
    public NMLCardResource clearSubTitle()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public NMLCardResource clearTitle()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public NMLCardResource clearTransport()
    {
      this.q = Collections.emptyList();
      return this;
    }
    
    public NMLCardResource clearTripExt()
    {
      this.E = false;
      this.F = null;
      return this;
    }
    
    public NMLCardResource clearTripId()
    {
      this.I = false;
      this.J = "";
      return this;
    }
    
    public NMLCardResource clearTripType()
    {
      this.K = false;
      this.L = 0;
      return this;
    }
    
    public String getArriveCityName()
    {
      return this.l;
    }
    
    public String getArriveTime()
    {
      return this.w;
    }
    
    public int getCachedSize()
    {
      if (this.U < 0) {
        getSerializedSize();
      }
      return this.U;
    }
    
    public String getCardLink()
    {
      return this.P;
    }
    
    public int getCardStatisticType()
    {
      return this.R;
    }
    
    public long getDeadlineTime()
    {
      return this.s;
    }
    
    public String getDetailTitle(int paramInt)
    {
      return (String)this.D.get(paramInt);
    }
    
    public int getDetailTitleCount()
    {
      return this.D.size();
    }
    
    public List<String> getDetailTitleList()
    {
      return this.D;
    }
    
    public String getIcon()
    {
      return this.b;
    }
    
    public String getIconDelay()
    {
      return this.d;
    }
    
    public String getIconDesc()
    {
      return this.f;
    }
    
    public boolean getIsCarlimit()
    {
      return this.H;
    }
    
    public int getIsDelay()
    {
      return this.h;
    }
    
    public boolean getIsRequest()
    {
      return this.T;
    }
    
    public String getLeftTitle1()
    {
      return this.A;
    }
    
    public String getLeftTitle2()
    {
      return this.C;
    }
    
    public String getOrderType()
    {
      return this.N;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasIcon()) {}
      for (int i2 = CodedOutputStreamMicro.computeStringSize(1, getIcon()) + 0;; i2 = 0)
      {
        int i1 = i2;
        if (hasIconDelay()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getIconDelay());
        }
        i2 = i1;
        if (hasIconDesc()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getIconDesc());
        }
        i1 = i2;
        if (hasIsDelay()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getIsDelay());
        }
        i2 = i1;
        if (hasStartCityName()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getStartCityName());
        }
        i1 = i2;
        if (hasArriveCityName()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getArriveCityName());
        }
        i2 = i1;
        if (hasTitle()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getTitle());
        }
        i1 = i2;
        if (hasSubTitle()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getSubTitle());
        }
        Iterator localIterator = getTransportList().iterator();
        for (i2 = i1; localIterator.hasNext(); i2 = CodedOutputStreamMicro.computeMessageSize(9, (TaResponse.Transport)localIterator.next()) + i2) {}
        i1 = i2;
        if (hasDeadlineTime()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt64Size(10, getDeadlineTime());
        }
        i2 = i1;
        if (hasStartTime()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getStartTime());
        }
        i1 = i2;
        if (hasArriveTime()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getArriveTime());
        }
        i2 = i1;
        if (hasShowType()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(13, getShowType());
        }
        i1 = i2;
        if (hasLeftTitle1()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getLeftTitle1());
        }
        i2 = i1;
        if (hasLeftTitle2()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(15, getLeftTitle2());
        }
        localIterator = getDetailTitleList().iterator();
        i1 = i3;
        while (localIterator.hasNext()) {
          i1 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
        }
        i2 = i2 + i1 + getDetailTitleList().size() * 2;
        i1 = i2;
        if (hasTripExt()) {
          i1 = i2 + CodedOutputStreamMicro.computeMessageSize(17, getTripExt());
        }
        i2 = i1;
        if (hasIsCarlimit()) {
          i2 = i1 + CodedOutputStreamMicro.computeBoolSize(18, getIsCarlimit());
        }
        i1 = i2;
        if (hasTripId()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(19, getTripId());
        }
        i2 = i1;
        if (hasTripType()) {
          i2 = i1 + CodedOutputStreamMicro.computeInt32Size(20, getTripType());
        }
        i1 = i2;
        if (hasOrderType()) {
          i1 = i2 + CodedOutputStreamMicro.computeStringSize(21, getOrderType());
        }
        i2 = i1;
        if (hasCardLink()) {
          i2 = i1 + CodedOutputStreamMicro.computeStringSize(22, getCardLink());
        }
        i1 = i2;
        if (hasCardStatisticType()) {
          i1 = i2 + CodedOutputStreamMicro.computeInt32Size(23, getCardStatisticType());
        }
        i2 = i1;
        if (hasIsRequest()) {
          i2 = i1 + CodedOutputStreamMicro.computeBoolSize(24, getIsRequest());
        }
        this.U = i2;
        return i2;
      }
    }
    
    public int getShowType()
    {
      return this.y;
    }
    
    public String getStartCityName()
    {
      return this.j;
    }
    
    public String getStartTime()
    {
      return this.u;
    }
    
    public String getSubTitle()
    {
      return this.p;
    }
    
    public String getTitle()
    {
      return this.n;
    }
    
    public TaResponse.Transport getTransport(int paramInt)
    {
      return (TaResponse.Transport)this.q.get(paramInt);
    }
    
    public int getTransportCount()
    {
      return this.q.size();
    }
    
    public List<TaResponse.Transport> getTransportList()
    {
      return this.q;
    }
    
    public TaResponse.TripExt getTripExt()
    {
      return this.F;
    }
    
    public String getTripId()
    {
      return this.J;
    }
    
    public int getTripType()
    {
      return this.L;
    }
    
    public boolean hasArriveCityName()
    {
      return this.k;
    }
    
    public boolean hasArriveTime()
    {
      return this.v;
    }
    
    public boolean hasCardLink()
    {
      return this.O;
    }
    
    public boolean hasCardStatisticType()
    {
      return this.Q;
    }
    
    public boolean hasDeadlineTime()
    {
      return this.r;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasIconDelay()
    {
      return this.c;
    }
    
    public boolean hasIconDesc()
    {
      return this.e;
    }
    
    public boolean hasIsCarlimit()
    {
      return this.G;
    }
    
    public boolean hasIsDelay()
    {
      return this.g;
    }
    
    public boolean hasIsRequest()
    {
      return this.S;
    }
    
    public boolean hasLeftTitle1()
    {
      return this.z;
    }
    
    public boolean hasLeftTitle2()
    {
      return this.B;
    }
    
    public boolean hasOrderType()
    {
      return this.M;
    }
    
    public boolean hasShowType()
    {
      return this.x;
    }
    
    public boolean hasStartCityName()
    {
      return this.i;
    }
    
    public boolean hasStartTime()
    {
      return this.t;
    }
    
    public boolean hasSubTitle()
    {
      return this.o;
    }
    
    public boolean hasTitle()
    {
      return this.m;
    }
    
    public boolean hasTripExt()
    {
      return this.E;
    }
    
    public boolean hasTripId()
    {
      return this.I;
    }
    
    public boolean hasTripType()
    {
      return this.K;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public NMLCardResource mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setIconDelay(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setIconDesc(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setIsDelay(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setStartCityName(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setArriveCityName(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setSubTitle(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          localObject = new TaResponse.Transport();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTransport((TaResponse.Transport)localObject);
          break;
        case 80: 
          setDeadlineTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 90: 
          setStartTime(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setArriveTime(paramCodedInputStreamMicro.readString());
          break;
        case 104: 
          setShowType(paramCodedInputStreamMicro.readInt32());
          break;
        case 114: 
          setLeftTitle1(paramCodedInputStreamMicro.readString());
          break;
        case 122: 
          setLeftTitle2(paramCodedInputStreamMicro.readString());
          break;
        case 130: 
          addDetailTitle(paramCodedInputStreamMicro.readString());
          break;
        case 138: 
          localObject = new TaResponse.TripExt();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTripExt((TaResponse.TripExt)localObject);
          break;
        case 144: 
          setIsCarlimit(paramCodedInputStreamMicro.readBool());
          break;
        case 154: 
          setTripId(paramCodedInputStreamMicro.readString());
          break;
        case 160: 
          setTripType(paramCodedInputStreamMicro.readInt32());
          break;
        case 170: 
          setOrderType(paramCodedInputStreamMicro.readString());
          break;
        case 178: 
          setCardLink(paramCodedInputStreamMicro.readString());
          break;
        case 184: 
          setCardStatisticType(paramCodedInputStreamMicro.readInt32());
          break;
        case 192: 
          setIsRequest(paramCodedInputStreamMicro.readBool());
        }
      }
    }
    
    public NMLCardResource setArriveCityName(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public NMLCardResource setArriveTime(String paramString)
    {
      this.v = true;
      this.w = paramString;
      return this;
    }
    
    public NMLCardResource setCardLink(String paramString)
    {
      this.O = true;
      this.P = paramString;
      return this;
    }
    
    public NMLCardResource setCardStatisticType(int paramInt)
    {
      this.Q = true;
      this.R = paramInt;
      return this;
    }
    
    public NMLCardResource setDeadlineTime(long paramLong)
    {
      this.r = true;
      this.s = paramLong;
      return this;
    }
    
    public NMLCardResource setDetailTitle(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.D.set(paramInt, paramString);
      return this;
    }
    
    public NMLCardResource setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public NMLCardResource setIconDelay(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public NMLCardResource setIconDesc(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public NMLCardResource setIsCarlimit(boolean paramBoolean)
    {
      this.G = true;
      this.H = paramBoolean;
      return this;
    }
    
    public NMLCardResource setIsDelay(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public NMLCardResource setIsRequest(boolean paramBoolean)
    {
      this.S = true;
      this.T = paramBoolean;
      return this;
    }
    
    public NMLCardResource setLeftTitle1(String paramString)
    {
      this.z = true;
      this.A = paramString;
      return this;
    }
    
    public NMLCardResource setLeftTitle2(String paramString)
    {
      this.B = true;
      this.C = paramString;
      return this;
    }
    
    public NMLCardResource setOrderType(String paramString)
    {
      this.M = true;
      this.N = paramString;
      return this;
    }
    
    public NMLCardResource setShowType(int paramInt)
    {
      this.x = true;
      this.y = paramInt;
      return this;
    }
    
    public NMLCardResource setStartCityName(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public NMLCardResource setStartTime(String paramString)
    {
      this.t = true;
      this.u = paramString;
      return this;
    }
    
    public NMLCardResource setSubTitle(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public NMLCardResource setTitle(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public NMLCardResource setTransport(int paramInt, TaResponse.Transport paramTransport)
    {
      if (paramTransport == null) {
        return this;
      }
      this.q.set(paramInt, paramTransport);
      return this;
    }
    
    public NMLCardResource setTripExt(TaResponse.TripExt paramTripExt)
    {
      if (paramTripExt == null) {
        return clearTripExt();
      }
      this.E = true;
      this.F = paramTripExt;
      return this;
    }
    
    public NMLCardResource setTripId(String paramString)
    {
      this.I = true;
      this.J = paramString;
      return this;
    }
    
    public NMLCardResource setTripType(int paramInt)
    {
      this.K = true;
      this.L = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      if (hasIconDelay()) {
        paramCodedOutputStreamMicro.writeString(2, getIconDelay());
      }
      if (hasIconDesc()) {
        paramCodedOutputStreamMicro.writeString(3, getIconDesc());
      }
      if (hasIsDelay()) {
        paramCodedOutputStreamMicro.writeInt32(4, getIsDelay());
      }
      if (hasStartCityName()) {
        paramCodedOutputStreamMicro.writeString(5, getStartCityName());
      }
      if (hasArriveCityName()) {
        paramCodedOutputStreamMicro.writeString(6, getArriveCityName());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(7, getTitle());
      }
      if (hasSubTitle()) {
        paramCodedOutputStreamMicro.writeString(8, getSubTitle());
      }
      Iterator localIterator = getTransportList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(9, (TaResponse.Transport)localIterator.next());
      }
      if (hasDeadlineTime()) {
        paramCodedOutputStreamMicro.writeInt64(10, getDeadlineTime());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeString(11, getStartTime());
      }
      if (hasArriveTime()) {
        paramCodedOutputStreamMicro.writeString(12, getArriveTime());
      }
      if (hasShowType()) {
        paramCodedOutputStreamMicro.writeInt32(13, getShowType());
      }
      if (hasLeftTitle1()) {
        paramCodedOutputStreamMicro.writeString(14, getLeftTitle1());
      }
      if (hasLeftTitle2()) {
        paramCodedOutputStreamMicro.writeString(15, getLeftTitle2());
      }
      localIterator = getDetailTitleList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(16, (String)localIterator.next());
      }
      if (hasTripExt()) {
        paramCodedOutputStreamMicro.writeMessage(17, getTripExt());
      }
      if (hasIsCarlimit()) {
        paramCodedOutputStreamMicro.writeBool(18, getIsCarlimit());
      }
      if (hasTripId()) {
        paramCodedOutputStreamMicro.writeString(19, getTripId());
      }
      if (hasTripType()) {
        paramCodedOutputStreamMicro.writeInt32(20, getTripType());
      }
      if (hasOrderType()) {
        paramCodedOutputStreamMicro.writeString(21, getOrderType());
      }
      if (hasCardLink()) {
        paramCodedOutputStreamMicro.writeString(22, getCardLink());
      }
      if (hasCardStatisticType()) {
        paramCodedOutputStreamMicro.writeInt32(23, getCardStatisticType());
      }
      if (hasIsRequest()) {
        paramCodedOutputStreamMicro.writeBool(24, getIsRequest());
      }
    }
  }
  
  public static final class NMLHeader
    extends MessageMicro
  {
    public static final int ELEM_FIELD_NUMBER = 1;
    private List<TaResponse.NMLHeaderElem> a = Collections.emptyList();
    private int b = -1;
    
    public static NMLHeader parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new NMLHeader().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static NMLHeader parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (NMLHeader)new NMLHeader().mergeFrom(paramArrayOfByte);
    }
    
    public NMLHeader addElem(TaResponse.NMLHeaderElem paramNMLHeaderElem)
    {
      if (paramNMLHeaderElem == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramNMLHeaderElem);
      return this;
    }
    
    public final NMLHeader clear()
    {
      clearElem();
      this.b = -1;
      return this;
    }
    
    public NMLHeader clearElem()
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
    
    public TaResponse.NMLHeaderElem getElem(int paramInt)
    {
      return (TaResponse.NMLHeaderElem)this.a.get(paramInt);
    }
    
    public int getElemCount()
    {
      return this.a.size();
    }
    
    public List<TaResponse.NMLHeaderElem> getElemList()
    {
      return this.a;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getElemList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (TaResponse.NMLHeaderElem)localIterator.next()) + i) {}
      this.b = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public NMLHeader mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.NMLHeaderElem localNMLHeaderElem = new TaResponse.NMLHeaderElem();
          paramCodedInputStreamMicro.readMessage(localNMLHeaderElem);
          addElem(localNMLHeaderElem);
        }
      }
    }
    
    public NMLHeader setElem(int paramInt, TaResponse.NMLHeaderElem paramNMLHeaderElem)
    {
      if (paramNMLHeaderElem == null) {
        return this;
      }
      this.a.set(paramInt, paramNMLHeaderElem);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getElemList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (TaResponse.NMLHeaderElem)localIterator.next());
      }
    }
  }
  
  public static final class NMLHeaderElem
    extends MessageMicro
  {
    public static final int ELEMS_FIELD_NUMBER = 2;
    public static final int ICON_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<String> c = Collections.emptyList();
    private int d = -1;
    
    public static NMLHeaderElem parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new NMLHeaderElem().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static NMLHeaderElem parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (NMLHeaderElem)new NMLHeaderElem().mergeFrom(paramArrayOfByte);
    }
    
    public NMLHeaderElem addElems(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramString);
      return this;
    }
    
    public final NMLHeaderElem clear()
    {
      clearIcon();
      clearElems();
      this.d = -1;
      return this;
    }
    
    public NMLHeaderElem clearElems()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public NMLHeaderElem clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public String getElems(int paramInt)
    {
      return (String)this.c.get(paramInt);
    }
    
    public int getElemsCount()
    {
      return this.c.size();
    }
    
    public List<String> getElemsList()
    {
      return this.c;
    }
    
    public String getIcon()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasIcon()) {}
      for (int i = CodedOutputStreamMicro.computeStringSize(1, getIcon()) + 0;; i = 0)
      {
        Iterator localIterator = getElemsList().iterator();
        while (localIterator.hasNext()) {
          j += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
        }
        i = i + j + getElemsList().size() * 1;
        this.d = i;
        return i;
      }
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public NMLHeaderElem mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          addElems(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public NMLHeaderElem setElems(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.c.set(paramInt, paramString);
      return this;
    }
    
    public NMLHeaderElem setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      Iterator localIterator = getElemsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(2, (String)localIterator.next());
      }
    }
  }
  
  public static final class NearMainList
    extends MessageMicro
  {
    public static final int AIDE_URL_FIELD_NUMBER = 3;
    public static final int CARDRESOURCE_FIELD_NUMBER = 2;
    public static final int HEADER_FIELD_NUMBER = 1;
    public static final int IS_SHOW_FIELD_NUMBER = 4;
    private boolean a;
    private TaResponse.NMLHeader b = null;
    private List<TaResponse.NMLCardResource> c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private boolean f;
    private boolean g = false;
    private int h = -1;
    
    public static NearMainList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new NearMainList().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static NearMainList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (NearMainList)new NearMainList().mergeFrom(paramArrayOfByte);
    }
    
    public NearMainList addCardresource(TaResponse.NMLCardResource paramNMLCardResource)
    {
      if (paramNMLCardResource == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramNMLCardResource);
      return this;
    }
    
    public final NearMainList clear()
    {
      clearHeader();
      clearCardresource();
      clearAideUrl();
      clearIsShow();
      this.h = -1;
      return this;
    }
    
    public NearMainList clearAideUrl()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public NearMainList clearCardresource()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public NearMainList clearHeader()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public NearMainList clearIsShow()
    {
      this.f = false;
      this.g = false;
      return this;
    }
    
    public String getAideUrl()
    {
      return this.e;
    }
    
    public int getCachedSize()
    {
      if (this.h < 0) {
        getSerializedSize();
      }
      return this.h;
    }
    
    public TaResponse.NMLCardResource getCardresource(int paramInt)
    {
      return (TaResponse.NMLCardResource)this.c.get(paramInt);
    }
    
    public int getCardresourceCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.NMLCardResource> getCardresourceList()
    {
      return this.c;
    }
    
    public TaResponse.NMLHeader getHeader()
    {
      return this.b;
    }
    
    public boolean getIsShow()
    {
      return this.g;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasHeader()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHeader());
      }
      Iterator localIterator = getCardresourceList().iterator();
      for (int j = i; localIterator.hasNext(); j = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.NMLCardResource)localIterator.next()) + j) {}
      i = j;
      if (hasAideUrl()) {
        i = j + CodedOutputStreamMicro.computeStringSize(3, getAideUrl());
      }
      j = i;
      if (hasIsShow()) {
        j = i + CodedOutputStreamMicro.computeBoolSize(4, getIsShow());
      }
      this.h = j;
      return j;
    }
    
    public boolean hasAideUrl()
    {
      return this.d;
    }
    
    public boolean hasHeader()
    {
      return this.a;
    }
    
    public boolean hasIsShow()
    {
      return this.f;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public NearMainList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new TaResponse.NMLHeader();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setHeader((TaResponse.NMLHeader)localObject);
          break;
        case 18: 
          localObject = new TaResponse.NMLCardResource();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addCardresource((TaResponse.NMLCardResource)localObject);
          break;
        case 26: 
          setAideUrl(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setIsShow(paramCodedInputStreamMicro.readBool());
        }
      }
    }
    
    public NearMainList setAideUrl(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public NearMainList setCardresource(int paramInt, TaResponse.NMLCardResource paramNMLCardResource)
    {
      if (paramNMLCardResource == null) {
        return this;
      }
      this.c.set(paramInt, paramNMLCardResource);
      return this;
    }
    
    public NearMainList setHeader(TaResponse.NMLHeader paramNMLHeader)
    {
      if (paramNMLHeader == null) {
        return clearHeader();
      }
      this.a = true;
      this.b = paramNMLHeader;
      return this;
    }
    
    public NearMainList setIsShow(boolean paramBoolean)
    {
      this.f = true;
      this.g = paramBoolean;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasHeader()) {
        paramCodedOutputStreamMicro.writeMessage(1, getHeader());
      }
      Iterator localIterator = getCardresourceList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.NMLCardResource)localIterator.next());
      }
      if (hasAideUrl()) {
        paramCodedOutputStreamMicro.writeString(3, getAideUrl());
      }
      if (hasIsShow()) {
        paramCodedOutputStreamMicro.writeBool(4, getIsShow());
      }
    }
  }
  
  public static final class NotifyContent
    extends MessageMicro
  {
    public static final int JUMP_URL_FIELD_NUMBER = 2;
    public static final int NOTIFY_TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static NotifyContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new NotifyContent().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static NotifyContent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (NotifyContent)new NotifyContent().mergeFrom(paramArrayOfByte);
    }
    
    public final NotifyContent clear()
    {
      clearNotifyTitle();
      clearJumpUrl();
      this.e = -1;
      return this;
    }
    
    public NotifyContent clearJumpUrl()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public NotifyContent clearNotifyTitle()
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
    
    public String getJumpUrl()
    {
      return this.d;
    }
    
    public String getNotifyTitle()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasNotifyTitle()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getNotifyTitle());
      }
      int j = i;
      if (hasJumpUrl()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getJumpUrl());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasJumpUrl()
    {
      return this.c;
    }
    
    public boolean hasNotifyTitle()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public NotifyContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setNotifyTitle(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public NotifyContent setJumpUrl(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public NotifyContent setNotifyTitle(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasNotifyTitle()) {
        paramCodedOutputStreamMicro.writeString(1, getNotifyTitle());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getJumpUrl());
      }
    }
  }
  
  public static final class OrderSet
    extends MessageMicro
  {
    public static final int ORDER_NAME_FIELD_NUMBER = 2;
    public static final int ORDER_TYPE_FIELD_NUMBER = 1;
    public static final int STATUS_FIELD_NUMBER = 3;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private int f = 0;
    private int g = -1;
    
    public static OrderSet parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new OrderSet().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static OrderSet parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (OrderSet)new OrderSet().mergeFrom(paramArrayOfByte);
    }
    
    public final OrderSet clear()
    {
      clearOrderType();
      clearOrderName();
      clearStatus();
      this.g = -1;
      return this;
    }
    
    public OrderSet clearOrderName()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public OrderSet clearOrderType()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public OrderSet clearStatus()
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
    
    public String getOrderName()
    {
      return this.d;
    }
    
    public String getOrderType()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasOrderType()) {
        j = 0 + CodedOutputStreamMicro.computeStringSize(1, getOrderType());
      }
      int i = j;
      if (hasOrderName()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getOrderName());
      }
      j = i;
      if (hasStatus()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getStatus());
      }
      this.g = j;
      return j;
    }
    
    public int getStatus()
    {
      return this.f;
    }
    
    public boolean hasOrderName()
    {
      return this.c;
    }
    
    public boolean hasOrderType()
    {
      return this.a;
    }
    
    public boolean hasStatus()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public OrderSet mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setOrderType(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setOrderName(paramCodedInputStreamMicro.readString());
          break;
        case 24: 
          setStatus(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public OrderSet setOrderName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public OrderSet setOrderType(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public OrderSet setStatus(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasOrderType()) {
        paramCodedOutputStreamMicro.writeString(1, getOrderType());
      }
      if (hasOrderName()) {
        paramCodedOutputStreamMicro.writeString(2, getOrderName());
      }
      if (hasStatus()) {
        paramCodedOutputStreamMicro.writeInt32(3, getStatus());
      }
    }
  }
  
  public static final class PageContent
    extends MessageMicro
  {
    public static final int DRIVER_PAGE_CONTENT_FIELD_NUMBER = 1;
    private boolean a;
    private TaResponse.DriverPageContent b = null;
    private int c = -1;
    
    public static PageContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new PageContent().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static PageContent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (PageContent)new PageContent().mergeFrom(paramArrayOfByte);
    }
    
    public final PageContent clear()
    {
      clearDriverPageContent();
      this.c = -1;
      return this;
    }
    
    public PageContent clearDriverPageContent()
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
    
    public TaResponse.DriverPageContent getDriverPageContent()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasDriverPageContent()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDriverPageContent());
      }
      this.c = i;
      return i;
    }
    
    public boolean hasDriverPageContent()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public PageContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.DriverPageContent localDriverPageContent = new TaResponse.DriverPageContent();
          paramCodedInputStreamMicro.readMessage(localDriverPageContent);
          setDriverPageContent(localDriverPageContent);
        }
      }
    }
    
    public PageContent setDriverPageContent(TaResponse.DriverPageContent paramDriverPageContent)
    {
      if (paramDriverPageContent == null) {
        return clearDriverPageContent();
      }
      this.a = true;
      this.b = paramDriverPageContent;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasDriverPageContent()) {
        paramCodedOutputStreamMicro.writeMessage(1, getDriverPageContent());
      }
    }
  }
  
  public static final class RecPOI
    extends MessageMicro
  {
    public static final int DIS_FIELD_NUMBER = 4;
    public static final int ICON_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int UID_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private int h = 0;
    private int i = -1;
    
    public static RecPOI parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new RecPOI().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static RecPOI parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (RecPOI)new RecPOI().mergeFrom(paramArrayOfByte);
    }
    
    public final RecPOI clear()
    {
      clearUid();
      clearName();
      clearIcon();
      clearDis();
      this.i = -1;
      return this;
    }
    
    public RecPOI clearDis()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public RecPOI clearIcon()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public RecPOI clearName()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public RecPOI clearUid()
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
    
    public int getDis()
    {
      return this.h;
    }
    
    public String getIcon()
    {
      return this.f;
    }
    
    public String getName()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasUid()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
      }
      int j = k;
      if (hasName()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getName());
      }
      k = j;
      if (hasIcon()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getIcon());
      }
      j = k;
      if (hasDis()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(4, getDis());
      }
      this.i = j;
      return j;
    }
    
    public String getUid()
    {
      return this.b;
    }
    
    public boolean hasDis()
    {
      return this.g;
    }
    
    public boolean hasIcon()
    {
      return this.e;
    }
    
    public boolean hasName()
    {
      return this.c;
    }
    
    public boolean hasUid()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g)) {
        return false;
      }
      return true;
    }
    
    public RecPOI mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setUid(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setDis(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public RecPOI setDis(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public RecPOI setIcon(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public RecPOI setName(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public RecPOI setUid(String paramString)
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
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(2, getName());
      }
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(3, getIcon());
      }
      if (hasDis()) {
        paramCodedOutputStreamMicro.writeInt32(4, getDis());
      }
    }
  }
  
  public static final class SceneEntry
    extends MessageMicro
  {
    public static final int CHECKIMAGEAREA_FIELD_NUMBER = 3;
    public static final int CHECKRESIDENTCITY_FIELD_NUMBER = 2;
    public static final int ISREDPOINTSHOW_FIELD_NUMBER = 5;
    public static final int ISSHOW_FIELD_NUMBER = 1;
    public static final int NO_TRIP_CONTENT_FIELD_NUMBER = 6;
    public static final int NO_TRIP_URL_FIELD_NUMBER = 7;
    public static final int RESIDENTCITYS_FIELD_NUMBER = 4;
    private boolean a;
    private boolean b = false;
    private boolean c;
    private boolean d = false;
    private boolean e;
    private boolean f = false;
    private List<String> g = Collections.emptyList();
    private boolean h;
    private boolean i = false;
    private boolean j;
    private String k = "";
    private boolean l;
    private String m = "";
    private int n = -1;
    
    public static SceneEntry parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SceneEntry().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SceneEntry parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SceneEntry)new SceneEntry().mergeFrom(paramArrayOfByte);
    }
    
    public SceneEntry addResidentCitys(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.g.isEmpty()) {
        this.g = new ArrayList();
      }
      this.g.add(paramString);
      return this;
    }
    
    public final SceneEntry clear()
    {
      clearIsShow();
      clearCheckResidentCity();
      clearCheckImageArea();
      clearResidentCitys();
      clearIsRedPointShow();
      clearNoTripContent();
      clearNoTripUrl();
      this.n = -1;
      return this;
    }
    
    public SceneEntry clearCheckImageArea()
    {
      this.e = false;
      this.f = false;
      return this;
    }
    
    public SceneEntry clearCheckResidentCity()
    {
      this.c = false;
      this.d = false;
      return this;
    }
    
    public SceneEntry clearIsRedPointShow()
    {
      this.h = false;
      this.i = false;
      return this;
    }
    
    public SceneEntry clearIsShow()
    {
      this.a = false;
      this.b = false;
      return this;
    }
    
    public SceneEntry clearNoTripContent()
    {
      this.j = false;
      this.k = "";
      return this;
    }
    
    public SceneEntry clearNoTripUrl()
    {
      this.l = false;
      this.m = "";
      return this;
    }
    
    public SceneEntry clearResidentCitys()
    {
      this.g = Collections.emptyList();
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.n < 0) {
        getSerializedSize();
      }
      return this.n;
    }
    
    public boolean getCheckImageArea()
    {
      return this.f;
    }
    
    public boolean getCheckResidentCity()
    {
      return this.d;
    }
    
    public boolean getIsRedPointShow()
    {
      return this.i;
    }
    
    public boolean getIsShow()
    {
      return this.b;
    }
    
    public String getNoTripContent()
    {
      return this.k;
    }
    
    public String getNoTripUrl()
    {
      return this.m;
    }
    
    public String getResidentCitys(int paramInt)
    {
      return (String)this.g.get(paramInt);
    }
    
    public int getResidentCitysCount()
    {
      return this.g.size();
    }
    
    public List<String> getResidentCitysList()
    {
      return this.g;
    }
    
    public int getSerializedSize()
    {
      int i3 = 0;
      if (hasIsShow()) {}
      for (int i1 = CodedOutputStreamMicro.computeBoolSize(1, getIsShow()) + 0;; i1 = 0)
      {
        int i2 = i1;
        if (hasCheckResidentCity()) {
          i2 = i1 + CodedOutputStreamMicro.computeBoolSize(2, getCheckResidentCity());
        }
        if (hasCheckImageArea()) {}
        for (i1 = i2 + CodedOutputStreamMicro.computeBoolSize(3, getCheckImageArea());; i1 = i2)
        {
          Iterator localIterator = getResidentCitysList().iterator();
          i2 = i3;
          while (localIterator.hasNext()) {
            i2 += CodedOutputStreamMicro.computeStringSizeNoTag((String)localIterator.next());
          }
          i2 = i1 + i2 + getResidentCitysList().size() * 1;
          i1 = i2;
          if (hasIsRedPointShow()) {
            i1 = i2 + CodedOutputStreamMicro.computeBoolSize(5, getIsRedPointShow());
          }
          i2 = i1;
          if (hasNoTripContent()) {
            i2 = i1 + CodedOutputStreamMicro.computeStringSize(6, getNoTripContent());
          }
          i1 = i2;
          if (hasNoTripUrl()) {
            i1 = i2 + CodedOutputStreamMicro.computeStringSize(7, getNoTripUrl());
          }
          this.n = i1;
          return i1;
        }
      }
    }
    
    public boolean hasCheckImageArea()
    {
      return this.e;
    }
    
    public boolean hasCheckResidentCity()
    {
      return this.c;
    }
    
    public boolean hasIsRedPointShow()
    {
      return this.h;
    }
    
    public boolean hasIsShow()
    {
      return this.a;
    }
    
    public boolean hasNoTripContent()
    {
      return this.j;
    }
    
    public boolean hasNoTripUrl()
    {
      return this.l;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SceneEntry mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIsShow(paramCodedInputStreamMicro.readBool());
          break;
        case 16: 
          setCheckResidentCity(paramCodedInputStreamMicro.readBool());
          break;
        case 24: 
          setCheckImageArea(paramCodedInputStreamMicro.readBool());
          break;
        case 34: 
          addResidentCitys(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setIsRedPointShow(paramCodedInputStreamMicro.readBool());
          break;
        case 50: 
          setNoTripContent(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setNoTripUrl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public SceneEntry setCheckImageArea(boolean paramBoolean)
    {
      this.e = true;
      this.f = paramBoolean;
      return this;
    }
    
    public SceneEntry setCheckResidentCity(boolean paramBoolean)
    {
      this.c = true;
      this.d = paramBoolean;
      return this;
    }
    
    public SceneEntry setIsRedPointShow(boolean paramBoolean)
    {
      this.h = true;
      this.i = paramBoolean;
      return this;
    }
    
    public SceneEntry setIsShow(boolean paramBoolean)
    {
      this.a = true;
      this.b = paramBoolean;
      return this;
    }
    
    public SceneEntry setNoTripContent(String paramString)
    {
      this.j = true;
      this.k = paramString;
      return this;
    }
    
    public SceneEntry setNoTripUrl(String paramString)
    {
      this.l = true;
      this.m = paramString;
      return this;
    }
    
    public SceneEntry setResidentCitys(int paramInt, String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.g.set(paramInt, paramString);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIsShow()) {
        paramCodedOutputStreamMicro.writeBool(1, getIsShow());
      }
      if (hasCheckResidentCity()) {
        paramCodedOutputStreamMicro.writeBool(2, getCheckResidentCity());
      }
      if (hasCheckImageArea()) {
        paramCodedOutputStreamMicro.writeBool(3, getCheckImageArea());
      }
      Iterator localIterator = getResidentCitysList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeString(4, (String)localIterator.next());
      }
      if (hasIsRedPointShow()) {
        paramCodedOutputStreamMicro.writeBool(5, getIsRedPointShow());
      }
      if (hasNoTripContent()) {
        paramCodedOutputStreamMicro.writeString(6, getNoTripContent());
      }
      if (hasNoTripUrl()) {
        paramCodedOutputStreamMicro.writeString(7, getNoTripUrl());
      }
    }
  }
  
  public static final class ShareLinkInfo
    extends MessageMicro
  {
    public static final int SHARE_ICON_FIELD_NUMBER = 2;
    public static final int SHARE_SUBTITLE_FIELD_NUMBER = 4;
    public static final int SHARE_TITLE_FIELD_NUMBER = 3;
    public static final int SHARE_URL_FIELD_NUMBER = 1;
    public static final int SHARE_WEIBO_ICON_FIELD_NUMBER = 5;
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
    
    public static ShareLinkInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ShareLinkInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ShareLinkInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ShareLinkInfo)new ShareLinkInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final ShareLinkInfo clear()
    {
      clearShareUrl();
      clearShareIcon();
      clearShareTitle();
      clearShareSubtitle();
      clearShareWeiboIcon();
      this.k = -1;
      return this;
    }
    
    public ShareLinkInfo clearShareIcon()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public ShareLinkInfo clearShareSubtitle()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public ShareLinkInfo clearShareTitle()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public ShareLinkInfo clearShareUrl()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public ShareLinkInfo clearShareWeiboIcon()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasShareUrl()) {
        n = 0 + CodedOutputStreamMicro.computeStringSize(1, getShareUrl());
      }
      int m = n;
      if (hasShareIcon()) {
        m = n + CodedOutputStreamMicro.computeStringSize(2, getShareIcon());
      }
      n = m;
      if (hasShareTitle()) {
        n = m + CodedOutputStreamMicro.computeStringSize(3, getShareTitle());
      }
      m = n;
      if (hasShareSubtitle()) {
        m = n + CodedOutputStreamMicro.computeStringSize(4, getShareSubtitle());
      }
      n = m;
      if (hasShareWeiboIcon()) {
        n = m + CodedOutputStreamMicro.computeStringSize(5, getShareWeiboIcon());
      }
      this.k = n;
      return n;
    }
    
    public String getShareIcon()
    {
      return this.d;
    }
    
    public String getShareSubtitle()
    {
      return this.h;
    }
    
    public String getShareTitle()
    {
      return this.f;
    }
    
    public String getShareUrl()
    {
      return this.b;
    }
    
    public String getShareWeiboIcon()
    {
      return this.j;
    }
    
    public boolean hasShareIcon()
    {
      return this.c;
    }
    
    public boolean hasShareSubtitle()
    {
      return this.g;
    }
    
    public boolean hasShareTitle()
    {
      return this.e;
    }
    
    public boolean hasShareUrl()
    {
      return this.a;
    }
    
    public boolean hasShareWeiboIcon()
    {
      return this.i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ShareLinkInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setShareUrl(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setShareIcon(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setShareTitle(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setShareSubtitle(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setShareWeiboIcon(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ShareLinkInfo setShareIcon(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public ShareLinkInfo setShareSubtitle(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public ShareLinkInfo setShareTitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public ShareLinkInfo setShareUrl(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public ShareLinkInfo setShareWeiboIcon(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasShareUrl()) {
        paramCodedOutputStreamMicro.writeString(1, getShareUrl());
      }
      if (hasShareIcon()) {
        paramCodedOutputStreamMicro.writeString(2, getShareIcon());
      }
      if (hasShareTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getShareTitle());
      }
      if (hasShareSubtitle()) {
        paramCodedOutputStreamMicro.writeString(4, getShareSubtitle());
      }
      if (hasShareWeiboIcon()) {
        paramCodedOutputStreamMicro.writeString(5, getShareWeiboIcon());
      }
    }
  }
  
  public static final class ShareTrip
    extends MessageMicro
  {
    public static final int CARDS_FIELD_NUMBER = 2;
    public static final int DAY_FIELD_NUMBER = 1;
    private boolean a;
    private long b = 0L;
    private List<TaResponse.CardResource> c = Collections.emptyList();
    private int d = -1;
    
    public static ShareTrip parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ShareTrip().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ShareTrip parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ShareTrip)new ShareTrip().mergeFrom(paramArrayOfByte);
    }
    
    public ShareTrip addCards(TaResponse.CardResource paramCardResource)
    {
      if (paramCardResource == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramCardResource);
      return this;
    }
    
    public final ShareTrip clear()
    {
      clearDay();
      clearCards();
      this.d = -1;
      return this;
    }
    
    public ShareTrip clearCards()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public ShareTrip clearDay()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public TaResponse.CardResource getCards(int paramInt)
    {
      return (TaResponse.CardResource)this.c.get(paramInt);
    }
    
    public int getCardsCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.CardResource> getCardsList()
    {
      return this.c;
    }
    
    public long getDay()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasDay()) {
        i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getDay());
      }
      Iterator localIterator = getCardsList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.CardResource)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasDay()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ShareTrip mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setDay(paramCodedInputStreamMicro.readInt64());
          break;
        case 18: 
          TaResponse.CardResource localCardResource = new TaResponse.CardResource();
          paramCodedInputStreamMicro.readMessage(localCardResource);
          addCards(localCardResource);
        }
      }
    }
    
    public ShareTrip setCards(int paramInt, TaResponse.CardResource paramCardResource)
    {
      if (paramCardResource == null) {
        return this;
      }
      this.c.set(paramInt, paramCardResource);
      return this;
    }
    
    public ShareTrip setDay(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasDay()) {
        paramCodedOutputStreamMicro.writeInt64(1, getDay());
      }
      Iterator localIterator = getCardsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.CardResource)localIterator.next());
      }
    }
  }
  
  public static final class ShareTripGroup
    extends MessageMicro
  {
    public static final int SHARE_TRIP_FIELD_NUMBER = 1;
    public static final int SHARE_URL_FIELD_NUMBER = 2;
    private List<TaResponse.ShareTrip> a = Collections.emptyList();
    private boolean b;
    private String c = "";
    private int d = -1;
    
    public static ShareTripGroup parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ShareTripGroup().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ShareTripGroup parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ShareTripGroup)new ShareTripGroup().mergeFrom(paramArrayOfByte);
    }
    
    public ShareTripGroup addShareTrip(TaResponse.ShareTrip paramShareTrip)
    {
      if (paramShareTrip == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramShareTrip);
      return this;
    }
    
    public final ShareTripGroup clear()
    {
      clearShareTrip();
      clearShareUrl();
      this.d = -1;
      return this;
    }
    
    public ShareTripGroup clearShareTrip()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public ShareTripGroup clearShareUrl()
    {
      this.b = false;
      this.c = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getShareTripList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (TaResponse.ShareTrip)localIterator.next()) + i) {}
      int j = i;
      if (hasShareUrl()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getShareUrl());
      }
      this.d = j;
      return j;
    }
    
    public TaResponse.ShareTrip getShareTrip(int paramInt)
    {
      return (TaResponse.ShareTrip)this.a.get(paramInt);
    }
    
    public int getShareTripCount()
    {
      return this.a.size();
    }
    
    public List<TaResponse.ShareTrip> getShareTripList()
    {
      return this.a;
    }
    
    public String getShareUrl()
    {
      return this.c;
    }
    
    public boolean hasShareUrl()
    {
      return this.b;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ShareTripGroup mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.ShareTrip localShareTrip = new TaResponse.ShareTrip();
          paramCodedInputStreamMicro.readMessage(localShareTrip);
          addShareTrip(localShareTrip);
          break;
        case 18: 
          setShareUrl(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ShareTripGroup setShareTrip(int paramInt, TaResponse.ShareTrip paramShareTrip)
    {
      if (paramShareTrip == null) {
        return this;
      }
      this.a.set(paramInt, paramShareTrip);
      return this;
    }
    
    public ShareTripGroup setShareUrl(String paramString)
    {
      this.b = true;
      this.c = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getShareTripList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (TaResponse.ShareTrip)localIterator.next());
      }
      if (hasShareUrl()) {
        paramCodedOutputStreamMicro.writeString(2, getShareUrl());
      }
    }
  }
  
  public static final class ShareTripInfo
    extends MessageMicro
  {
    public static final int SHARE_TRIP_GROUP_FIELD_NUMBER = 1;
    private boolean a;
    private TaResponse.ShareTripGroup b = null;
    private int c = -1;
    
    public static ShareTripInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ShareTripInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ShareTripInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ShareTripInfo)new ShareTripInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final ShareTripInfo clear()
    {
      clearShareTripGroup();
      this.c = -1;
      return this;
    }
    
    public ShareTripInfo clearShareTripGroup()
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
      if (hasShareTripGroup()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getShareTripGroup());
      }
      this.c = i;
      return i;
    }
    
    public TaResponse.ShareTripGroup getShareTripGroup()
    {
      return this.b;
    }
    
    public boolean hasShareTripGroup()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public ShareTripInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.ShareTripGroup localShareTripGroup = new TaResponse.ShareTripGroup();
          paramCodedInputStreamMicro.readMessage(localShareTripGroup);
          setShareTripGroup(localShareTripGroup);
        }
      }
    }
    
    public ShareTripInfo setShareTripGroup(TaResponse.ShareTripGroup paramShareTripGroup)
    {
      if (paramShareTripGroup == null) {
        return clearShareTripGroup();
      }
      this.a = true;
      this.b = paramShareTripGroup;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasShareTripGroup()) {
        paramCodedOutputStreamMicro.writeMessage(1, getShareTripGroup());
      }
    }
  }
  
  public static final class SmsOrder
    extends MessageMicro
  {
    public static final int DSTR_FIELD_NUMBER = 2;
    public static final int LSTR_FIELD_NUMBER = 4;
    public static final int MSTR_FIELD_NUMBER = 1;
    public static final int TSTR_FIELD_NUMBER = 3;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private int i = -1;
    
    public static SmsOrder parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SmsOrder().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SmsOrder parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SmsOrder)new SmsOrder().mergeFrom(paramArrayOfByte);
    }
    
    public final SmsOrder clear()
    {
      clearMstr();
      clearDstr();
      clearTstr();
      clearLstr();
      this.i = -1;
      return this;
    }
    
    public SmsOrder clearDstr()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public SmsOrder clearLstr()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public SmsOrder clearMstr()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public SmsOrder clearTstr()
    {
      this.e = false;
      this.f = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.i < 0) {
        getSerializedSize();
      }
      return this.i;
    }
    
    public int getDstr()
    {
      return this.d;
    }
    
    public int getLstr()
    {
      return this.h;
    }
    
    public int getMstr()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int k = 0;
      if (hasMstr()) {
        k = 0 + CodedOutputStreamMicro.computeInt32Size(1, getMstr());
      }
      int j = k;
      if (hasDstr()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(2, getDstr());
      }
      k = j;
      if (hasTstr()) {
        k = j + CodedOutputStreamMicro.computeInt32Size(3, getTstr());
      }
      j = k;
      if (hasLstr()) {
        j = k + CodedOutputStreamMicro.computeInt32Size(4, getLstr());
      }
      this.i = j;
      return j;
    }
    
    public int getTstr()
    {
      return this.f;
    }
    
    public boolean hasDstr()
    {
      return this.c;
    }
    
    public boolean hasLstr()
    {
      return this.g;
    }
    
    public boolean hasMstr()
    {
      return this.a;
    }
    
    public boolean hasTstr()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SmsOrder mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setMstr(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setDstr(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setTstr(paramCodedInputStreamMicro.readInt32());
          break;
        case 32: 
          setLstr(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public SmsOrder setDstr(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public SmsOrder setLstr(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public SmsOrder setMstr(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public SmsOrder setTstr(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasMstr()) {
        paramCodedOutputStreamMicro.writeInt32(1, getMstr());
      }
      if (hasDstr()) {
        paramCodedOutputStreamMicro.writeInt32(2, getDstr());
      }
      if (hasTstr()) {
        paramCodedOutputStreamMicro.writeInt32(3, getTstr());
      }
      if (hasLstr()) {
        paramCodedOutputStreamMicro.writeInt32(4, getLstr());
      }
    }
  }
  
  public static final class SmsSubTermDate
    extends MessageMicro
  {
    public static final int BUFFER_FIELD_NUMBER = 5;
    public static final int EXPRESSION_FIELD_NUMBER = 1;
    public static final int ORDER_FIELD_NUMBER = 2;
    public static final int SAMPLE_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 4;
    private boolean a;
    private String b = "";
    private boolean c;
    private TaResponse.SmsOrder d = null;
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private int j = 0;
    private int k = -1;
    
    public static SmsSubTermDate parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SmsSubTermDate().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SmsSubTermDate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SmsSubTermDate)new SmsSubTermDate().mergeFrom(paramArrayOfByte);
    }
    
    public final SmsSubTermDate clear()
    {
      clearExpression();
      clearOrder();
      clearSample();
      clearType();
      clearBuffer();
      this.k = -1;
      return this;
    }
    
    public SmsSubTermDate clearBuffer()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public SmsSubTermDate clearExpression()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public SmsSubTermDate clearOrder()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public SmsSubTermDate clearSample()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public SmsSubTermDate clearType()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public int getBuffer()
    {
      return this.j;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public String getExpression()
    {
      return this.b;
    }
    
    public TaResponse.SmsOrder getOrder()
    {
      return this.d;
    }
    
    public String getSample()
    {
      return this.f;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasExpression()) {
        n = 0 + CodedOutputStreamMicro.computeStringSize(1, getExpression());
      }
      int m = n;
      if (hasOrder()) {
        m = n + CodedOutputStreamMicro.computeMessageSize(2, getOrder());
      }
      n = m;
      if (hasSample()) {
        n = m + CodedOutputStreamMicro.computeStringSize(3, getSample());
      }
      m = n;
      if (hasType()) {
        m = n + CodedOutputStreamMicro.computeStringSize(4, getType());
      }
      n = m;
      if (hasBuffer()) {
        n = m + CodedOutputStreamMicro.computeInt32Size(5, getBuffer());
      }
      this.k = n;
      return n;
    }
    
    public String getType()
    {
      return this.h;
    }
    
    public boolean hasBuffer()
    {
      return this.i;
    }
    
    public boolean hasExpression()
    {
      return this.a;
    }
    
    public boolean hasOrder()
    {
      return this.c;
    }
    
    public boolean hasSample()
    {
      return this.e;
    }
    
    public boolean hasType()
    {
      return this.g;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SmsSubTermDate mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setExpression(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          TaResponse.SmsOrder localSmsOrder = new TaResponse.SmsOrder();
          paramCodedInputStreamMicro.readMessage(localSmsOrder);
          setOrder(localSmsOrder);
          break;
        case 26: 
          setSample(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setType(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setBuffer(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public SmsSubTermDate setBuffer(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public SmsSubTermDate setExpression(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public SmsSubTermDate setOrder(TaResponse.SmsOrder paramSmsOrder)
    {
      if (paramSmsOrder == null) {
        return clearOrder();
      }
      this.c = true;
      this.d = paramSmsOrder;
      return this;
    }
    
    public SmsSubTermDate setSample(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public SmsSubTermDate setType(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasExpression()) {
        paramCodedOutputStreamMicro.writeString(1, getExpression());
      }
      if (hasOrder()) {
        paramCodedOutputStreamMicro.writeMessage(2, getOrder());
      }
      if (hasSample()) {
        paramCodedOutputStreamMicro.writeString(3, getSample());
      }
      if (hasType()) {
        paramCodedOutputStreamMicro.writeString(4, getType());
      }
      if (hasBuffer()) {
        paramCodedOutputStreamMicro.writeInt32(5, getBuffer());
      }
    }
  }
  
  public static final class SmsTermData
    extends MessageMicro
  {
    public static final int COMPANY_FIELD_NUMBER = 1;
    public static final int PATTERN_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private List<TaResponse.SmsSubTermDate> c = Collections.emptyList();
    private int d = -1;
    
    public static SmsTermData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SmsTermData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SmsTermData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SmsTermData)new SmsTermData().mergeFrom(paramArrayOfByte);
    }
    
    public SmsTermData addPattern(TaResponse.SmsSubTermDate paramSmsSubTermDate)
    {
      if (paramSmsSubTermDate == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramSmsSubTermDate);
      return this;
    }
    
    public final SmsTermData clear()
    {
      clearCompany();
      clearPattern();
      this.d = -1;
      return this;
    }
    
    public SmsTermData clearCompany()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public SmsTermData clearPattern()
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
    
    public String getCompany()
    {
      return this.b;
    }
    
    public TaResponse.SmsSubTermDate getPattern(int paramInt)
    {
      return (TaResponse.SmsSubTermDate)this.c.get(paramInt);
    }
    
    public int getPatternCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.SmsSubTermDate> getPatternList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasCompany()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCompany());
      }
      Iterator localIterator = getPatternList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.SmsSubTermDate)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasCompany()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SmsTermData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setCompany(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          TaResponse.SmsSubTermDate localSmsSubTermDate = new TaResponse.SmsSubTermDate();
          paramCodedInputStreamMicro.readMessage(localSmsSubTermDate);
          addPattern(localSmsSubTermDate);
        }
      }
    }
    
    public SmsTermData setCompany(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public SmsTermData setPattern(int paramInt, TaResponse.SmsSubTermDate paramSmsSubTermDate)
    {
      if (paramSmsSubTermDate == null) {
        return this;
      }
      this.c.set(paramInt, paramSmsSubTermDate);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasCompany()) {
        paramCodedOutputStreamMicro.writeString(1, getCompany());
      }
      Iterator localIterator = getPatternList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.SmsSubTermDate)localIterator.next());
      }
    }
  }
  
  public static final class SmsUploadInfo
    extends MessageMicro
  {
    public static final int SMS_ID_FIELD_NUMBER = 1;
    public static final int SMS_UPLOAD_CNT_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private long d = 0L;
    private int e = -1;
    
    public static SmsUploadInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new SmsUploadInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static SmsUploadInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (SmsUploadInfo)new SmsUploadInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final SmsUploadInfo clear()
    {
      clearSmsId();
      clearSmsUploadCnt();
      this.e = -1;
      return this;
    }
    
    public SmsUploadInfo clearSmsId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public SmsUploadInfo clearSmsUploadCnt()
    {
      this.c = false;
      this.d = 0L;
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
      if (hasSmsId()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSmsId());
      }
      int j = i;
      if (hasSmsUploadCnt()) {
        j = i + CodedOutputStreamMicro.computeInt64Size(2, getSmsUploadCnt());
      }
      this.e = j;
      return j;
    }
    
    public String getSmsId()
    {
      return this.b;
    }
    
    public long getSmsUploadCnt()
    {
      return this.d;
    }
    
    public boolean hasSmsId()
    {
      return this.a;
    }
    
    public boolean hasSmsUploadCnt()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public SmsUploadInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setSmsId(paramCodedInputStreamMicro.readString());
          break;
        case 16: 
          setSmsUploadCnt(paramCodedInputStreamMicro.readInt64());
        }
      }
    }
    
    public SmsUploadInfo setSmsId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public SmsUploadInfo setSmsUploadCnt(long paramLong)
    {
      this.c = true;
      this.d = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasSmsId()) {
        paramCodedOutputStreamMicro.writeString(1, getSmsId());
      }
      if (hasSmsUploadCnt()) {
        paramCodedOutputStreamMicro.writeInt64(2, getSmsUploadCnt());
      }
    }
  }
  
  public static final class Station
    extends MessageMicro
  {
    public static final int EXT_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static Station parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Station().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Station parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Station)new Station().mergeFrom(paramArrayOfByte);
    }
    
    public final Station clear()
    {
      clearName();
      clearExt();
      this.e = -1;
      return this;
    }
    
    public Station clearExt()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Station clearName()
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
    
    public String getExt()
    {
      return this.d;
    }
    
    public String getName()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasName()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
      }
      int j = i;
      if (hasExt()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getExt());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasExt()
    {
      return this.c;
    }
    
    public boolean hasName()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Station mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setName(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setExt(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Station setExt(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Station setName(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStreamMicro.writeString(1, getName());
      }
      if (hasExt()) {
        paramCodedOutputStreamMicro.writeString(2, getExt());
      }
    }
  }
  
  public static final class TaContent
    extends MessageMicro
  {
    public static final int BASE_MAP_LIST_FIELD_NUMBER = 21;
    public static final int CALENDAR_UPLOAD_INFO_FIELD_NUMBER = 23;
    public static final int CONTROL_DATA_FIELD_NUMBER = 30;
    public static final int DRIVER_PAGE_INFO_FIELD_NUMBER = 24;
    public static final int EDIT_INFO_FIELD_NUMBER = 2;
    public static final int FLIGHT_DATA_FIELD_NUMBER = 10;
    public static final int FLIGHT_DETAIL_FIELD_NUMBER = 12;
    public static final int FLIGHT_LIST_FIELD_NUMBER = 9;
    public static final int FLIGHT_SUG_DATA_FIELD_NUMBER = 11;
    public static final int JUMP_URL_FIELD_NUMBER = 27;
    public static final int MAIN_LIST_FIELD_NUMBER = 1;
    public static final int MAP_SHOW_FIELD_NUMBER = 16;
    public static final int NEAR_LIST_FIELD_NUMBER = 15;
    public static final int ORDER_SETS_FIELD_NUMBER = 8;
    public static final int PAGE_CONTENT_FIELD_NUMBER = 28;
    public static final int POINT_SUG_FIELD_NUMBER = 31;
    public static final int POI_FIELD_NUMBER = 3;
    public static final int REC_POI_FIELD_NUMBER = 4;
    public static final int REMIND_CONTENT_FIELD_NUMBER = 25;
    public static final int REMIND_SUB_CONTENT_FIELD_NUMBER = 26;
    public static final int SHARE_LINK_INFO_FIELD_NUMBER = 20;
    public static final int SHARE_TRIP_INFO_FIELD_NUMBER = 18;
    public static final int SMS_CONFIG_DATA_FIELD_NUMBER = 22;
    public static final int SMS_UPLOAD_INFO_FIELD_NUMBER = 37;
    public static final int SUG_TRIP_TYPE_FIELD_NUMBER = 39;
    public static final int TRAIN_CITY_INFO_FIELD_NUMBER = 13;
    public static final int TRAIN_DETAIL_CONTENT_FIELD_NUMBER = 34;
    public static final int TRAIN_DETAIL_INFO_FIELD_NUMBER = 35;
    public static final int TRAIN_LIST_FIELD_NUMBER = 14;
    public static final int TRAIN_NO_FIELD_NUMBER = 36;
    public static final int TRAIN_STOP_INFO_FIELD_NUMBER = 17;
    public static final int TRAVEL_MOD_SUG_FIELD_NUMBER = 32;
    public static final int TRIP_FIELD_NUMBER = 38;
    public static final int TRIP_TITLE_SUG_FIELD_NUMBER = 33;
    public static final int TRIP_UPDATE_INFO_FIELD_NUMBER = 7;
    public static final int UI_DATA_FIELD_NUMBER = 29;
    public static final int UPDATE_RC_INFO_FIELD_NUMBER = 6;
    public static final int UPDATE_REMIND_INFO_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 19;
    private List<TaResponse.TrainStopData> A = Collections.emptyList();
    private boolean B;
    private TaResponse.ShareTripInfo C = null;
    private boolean D;
    private long E = 0L;
    private boolean F;
    private TaResponse.ShareLinkInfo G = null;
    private boolean H;
    private TaResponse.BaseMapList I = null;
    private boolean J;
    private String K = "";
    private boolean L;
    private TaResponse.CalendarUploadInfo M = null;
    private List<TaResponse.DriverPageInfo> N = Collections.emptyList();
    private boolean O;
    private String P = "";
    private boolean Q;
    private String R = "";
    private boolean S;
    private String T = "";
    private boolean U;
    private TaResponse.PageContent V = null;
    private boolean W;
    private TaResponse.UiData X = null;
    private boolean Y;
    private TaResponse.ControlData Z = null;
    private boolean a;
    private List<TaResponse.AddPagePointSug> aa = Collections.emptyList();
    private List<TaResponse.AddPageTravelModSug> ab = Collections.emptyList();
    private List<TaResponse.AddPageTripTitleSug> ac = Collections.emptyList();
    private boolean ad;
    private String ae = "";
    private List<TaResponse.TrainDetailInfo> af = Collections.emptyList();
    private boolean ag;
    private String ah = "";
    private boolean ai;
    private TaResponse.SmsUploadInfo aj = null;
    private boolean ak;
    private TaResponse.MLTrip al = null;
    private boolean am;
    private int an = 0;
    private int ao = -1;
    private TaResponse.ML b = null;
    private boolean c;
    private TaResponse.UpdateInfo d = null;
    private List<TaResponse.TaPOI> e = Collections.emptyList();
    private List<TaResponse.RecPOI> f = Collections.emptyList();
    private boolean g;
    private TaResponse.UpdateRemindInfo h = null;
    private boolean i;
    private TaResponse.UpdateRCInfo j = null;
    private boolean k;
    private TaResponse.IsTripUpdate l = null;
    private List<TaResponse.OrderSet> m = Collections.emptyList();
    private List<TaResponse.FlightConfigData> n = Collections.emptyList();
    private boolean o;
    private TaResponse.FlightCheckData p = null;
    private boolean q;
    private TaResponse.FlightSugData r = null;
    private List<TaResponse.FlightNoDetailData> s = Collections.emptyList();
    private boolean t;
    private TaResponse.TrainCityInfo u = null;
    private List<TaResponse.TrainList> v = Collections.emptyList();
    private boolean w;
    private TaResponse.NearMainList x = null;
    private boolean y;
    private TaResponse.MapShowButton z = null;
    
    public static TaContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TaContent().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TaContent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TaContent)new TaContent().mergeFrom(paramArrayOfByte);
    }
    
    public TaContent addDriverPageInfo(TaResponse.DriverPageInfo paramDriverPageInfo)
    {
      if (paramDriverPageInfo == null) {
        return this;
      }
      if (this.N.isEmpty()) {
        this.N = new ArrayList();
      }
      this.N.add(paramDriverPageInfo);
      return this;
    }
    
    public TaContent addFlightDetail(TaResponse.FlightNoDetailData paramFlightNoDetailData)
    {
      if (paramFlightNoDetailData == null) {
        return this;
      }
      if (this.s.isEmpty()) {
        this.s = new ArrayList();
      }
      this.s.add(paramFlightNoDetailData);
      return this;
    }
    
    public TaContent addFlightList(TaResponse.FlightConfigData paramFlightConfigData)
    {
      if (paramFlightConfigData == null) {
        return this;
      }
      if (this.n.isEmpty()) {
        this.n = new ArrayList();
      }
      this.n.add(paramFlightConfigData);
      return this;
    }
    
    public TaContent addOrderSets(TaResponse.OrderSet paramOrderSet)
    {
      if (paramOrderSet == null) {
        return this;
      }
      if (this.m.isEmpty()) {
        this.m = new ArrayList();
      }
      this.m.add(paramOrderSet);
      return this;
    }
    
    public TaContent addPoi(TaResponse.TaPOI paramTaPOI)
    {
      if (paramTaPOI == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramTaPOI);
      return this;
    }
    
    public TaContent addPointSug(TaResponse.AddPagePointSug paramAddPagePointSug)
    {
      if (paramAddPagePointSug == null) {
        return this;
      }
      if (this.aa.isEmpty()) {
        this.aa = new ArrayList();
      }
      this.aa.add(paramAddPagePointSug);
      return this;
    }
    
    public TaContent addRecPoi(TaResponse.RecPOI paramRecPOI)
    {
      if (paramRecPOI == null) {
        return this;
      }
      if (this.f.isEmpty()) {
        this.f = new ArrayList();
      }
      this.f.add(paramRecPOI);
      return this;
    }
    
    public TaContent addTrainDetailInfo(TaResponse.TrainDetailInfo paramTrainDetailInfo)
    {
      if (paramTrainDetailInfo == null) {
        return this;
      }
      if (this.af.isEmpty()) {
        this.af = new ArrayList();
      }
      this.af.add(paramTrainDetailInfo);
      return this;
    }
    
    public TaContent addTrainList(TaResponse.TrainList paramTrainList)
    {
      if (paramTrainList == null) {
        return this;
      }
      if (this.v.isEmpty()) {
        this.v = new ArrayList();
      }
      this.v.add(paramTrainList);
      return this;
    }
    
    public TaContent addTrainStopInfo(TaResponse.TrainStopData paramTrainStopData)
    {
      if (paramTrainStopData == null) {
        return this;
      }
      if (this.A.isEmpty()) {
        this.A = new ArrayList();
      }
      this.A.add(paramTrainStopData);
      return this;
    }
    
    public TaContent addTravelModSug(TaResponse.AddPageTravelModSug paramAddPageTravelModSug)
    {
      if (paramAddPageTravelModSug == null) {
        return this;
      }
      if (this.ab.isEmpty()) {
        this.ab = new ArrayList();
      }
      this.ab.add(paramAddPageTravelModSug);
      return this;
    }
    
    public TaContent addTripTitleSug(TaResponse.AddPageTripTitleSug paramAddPageTripTitleSug)
    {
      if (paramAddPageTripTitleSug == null) {
        return this;
      }
      if (this.ac.isEmpty()) {
        this.ac = new ArrayList();
      }
      this.ac.add(paramAddPageTripTitleSug);
      return this;
    }
    
    public final TaContent clear()
    {
      clearMainList();
      clearEditInfo();
      clearPoi();
      clearRecPoi();
      clearUpdateRemindInfo();
      clearUpdateRcInfo();
      clearTripUpdateInfo();
      clearOrderSets();
      clearFlightList();
      clearFlightData();
      clearFlightSugData();
      clearFlightDetail();
      clearTrainCityInfo();
      clearTrainList();
      clearNearList();
      clearMapShow();
      clearTrainStopInfo();
      clearShareTripInfo();
      clearVersion();
      clearShareLinkInfo();
      clearBaseMapList();
      clearSmsConfigData();
      clearCalendarUploadInfo();
      clearDriverPageInfo();
      clearRemindContent();
      clearRemindSubContent();
      clearJumpUrl();
      clearPageContent();
      clearUiData();
      clearControlData();
      clearPointSug();
      clearTravelModSug();
      clearTripTitleSug();
      clearTrainDetailContent();
      clearTrainDetailInfo();
      clearTrainNo();
      clearSmsUploadInfo();
      clearTrip();
      clearSugTripType();
      this.ao = -1;
      return this;
    }
    
    public TaContent clearBaseMapList()
    {
      this.H = false;
      this.I = null;
      return this;
    }
    
    public TaContent clearCalendarUploadInfo()
    {
      this.L = false;
      this.M = null;
      return this;
    }
    
    public TaContent clearControlData()
    {
      this.Y = false;
      this.Z = null;
      return this;
    }
    
    public TaContent clearDriverPageInfo()
    {
      this.N = Collections.emptyList();
      return this;
    }
    
    public TaContent clearEditInfo()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public TaContent clearFlightData()
    {
      this.o = false;
      this.p = null;
      return this;
    }
    
    public TaContent clearFlightDetail()
    {
      this.s = Collections.emptyList();
      return this;
    }
    
    public TaContent clearFlightList()
    {
      this.n = Collections.emptyList();
      return this;
    }
    
    public TaContent clearFlightSugData()
    {
      this.q = false;
      this.r = null;
      return this;
    }
    
    public TaContent clearJumpUrl()
    {
      this.S = false;
      this.T = "";
      return this;
    }
    
    public TaContent clearMainList()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public TaContent clearMapShow()
    {
      this.y = false;
      this.z = null;
      return this;
    }
    
    public TaContent clearNearList()
    {
      this.w = false;
      this.x = null;
      return this;
    }
    
    public TaContent clearOrderSets()
    {
      this.m = Collections.emptyList();
      return this;
    }
    
    public TaContent clearPageContent()
    {
      this.U = false;
      this.V = null;
      return this;
    }
    
    public TaContent clearPoi()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public TaContent clearPointSug()
    {
      this.aa = Collections.emptyList();
      return this;
    }
    
    public TaContent clearRecPoi()
    {
      this.f = Collections.emptyList();
      return this;
    }
    
    public TaContent clearRemindContent()
    {
      this.O = false;
      this.P = "";
      return this;
    }
    
    public TaContent clearRemindSubContent()
    {
      this.Q = false;
      this.R = "";
      return this;
    }
    
    public TaContent clearShareLinkInfo()
    {
      this.F = false;
      this.G = null;
      return this;
    }
    
    public TaContent clearShareTripInfo()
    {
      this.B = false;
      this.C = null;
      return this;
    }
    
    public TaContent clearSmsConfigData()
    {
      this.J = false;
      this.K = "";
      return this;
    }
    
    public TaContent clearSmsUploadInfo()
    {
      this.ai = false;
      this.aj = null;
      return this;
    }
    
    public TaContent clearSugTripType()
    {
      this.am = false;
      this.an = 0;
      return this;
    }
    
    public TaContent clearTrainCityInfo()
    {
      this.t = false;
      this.u = null;
      return this;
    }
    
    public TaContent clearTrainDetailContent()
    {
      this.ad = false;
      this.ae = "";
      return this;
    }
    
    public TaContent clearTrainDetailInfo()
    {
      this.af = Collections.emptyList();
      return this;
    }
    
    public TaContent clearTrainList()
    {
      this.v = Collections.emptyList();
      return this;
    }
    
    public TaContent clearTrainNo()
    {
      this.ag = false;
      this.ah = "";
      return this;
    }
    
    public TaContent clearTrainStopInfo()
    {
      this.A = Collections.emptyList();
      return this;
    }
    
    public TaContent clearTravelModSug()
    {
      this.ab = Collections.emptyList();
      return this;
    }
    
    public TaContent clearTrip()
    {
      this.ak = false;
      this.al = null;
      return this;
    }
    
    public TaContent clearTripTitleSug()
    {
      this.ac = Collections.emptyList();
      return this;
    }
    
    public TaContent clearTripUpdateInfo()
    {
      this.k = false;
      this.l = null;
      return this;
    }
    
    public TaContent clearUiData()
    {
      this.W = false;
      this.X = null;
      return this;
    }
    
    public TaContent clearUpdateRcInfo()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public TaContent clearUpdateRemindInfo()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public TaContent clearVersion()
    {
      this.D = false;
      this.E = 0L;
      return this;
    }
    
    public TaResponse.BaseMapList getBaseMapList()
    {
      return this.I;
    }
    
    public int getCachedSize()
    {
      if (this.ao < 0) {
        getSerializedSize();
      }
      return this.ao;
    }
    
    public TaResponse.CalendarUploadInfo getCalendarUploadInfo()
    {
      return this.M;
    }
    
    public TaResponse.ControlData getControlData()
    {
      return this.Z;
    }
    
    public TaResponse.DriverPageInfo getDriverPageInfo(int paramInt)
    {
      return (TaResponse.DriverPageInfo)this.N.get(paramInt);
    }
    
    public int getDriverPageInfoCount()
    {
      return this.N.size();
    }
    
    public List<TaResponse.DriverPageInfo> getDriverPageInfoList()
    {
      return this.N;
    }
    
    public TaResponse.UpdateInfo getEditInfo()
    {
      return this.d;
    }
    
    public TaResponse.FlightCheckData getFlightData()
    {
      return this.p;
    }
    
    public TaResponse.FlightNoDetailData getFlightDetail(int paramInt)
    {
      return (TaResponse.FlightNoDetailData)this.s.get(paramInt);
    }
    
    public int getFlightDetailCount()
    {
      return this.s.size();
    }
    
    public List<TaResponse.FlightNoDetailData> getFlightDetailList()
    {
      return this.s;
    }
    
    public TaResponse.FlightConfigData getFlightList(int paramInt)
    {
      return (TaResponse.FlightConfigData)this.n.get(paramInt);
    }
    
    public int getFlightListCount()
    {
      return this.n.size();
    }
    
    public List<TaResponse.FlightConfigData> getFlightListList()
    {
      return this.n;
    }
    
    public TaResponse.FlightSugData getFlightSugData()
    {
      return this.r;
    }
    
    public String getJumpUrl()
    {
      return this.T;
    }
    
    public TaResponse.ML getMainList()
    {
      return this.b;
    }
    
    public TaResponse.MapShowButton getMapShow()
    {
      return this.z;
    }
    
    public TaResponse.NearMainList getNearList()
    {
      return this.x;
    }
    
    public TaResponse.OrderSet getOrderSets(int paramInt)
    {
      return (TaResponse.OrderSet)this.m.get(paramInt);
    }
    
    public int getOrderSetsCount()
    {
      return this.m.size();
    }
    
    public List<TaResponse.OrderSet> getOrderSetsList()
    {
      return this.m;
    }
    
    public TaResponse.PageContent getPageContent()
    {
      return this.V;
    }
    
    public TaResponse.TaPOI getPoi(int paramInt)
    {
      return (TaResponse.TaPOI)this.e.get(paramInt);
    }
    
    public int getPoiCount()
    {
      return this.e.size();
    }
    
    public List<TaResponse.TaPOI> getPoiList()
    {
      return this.e;
    }
    
    public TaResponse.AddPagePointSug getPointSug(int paramInt)
    {
      return (TaResponse.AddPagePointSug)this.aa.get(paramInt);
    }
    
    public int getPointSugCount()
    {
      return this.aa.size();
    }
    
    public List<TaResponse.AddPagePointSug> getPointSugList()
    {
      return this.aa;
    }
    
    public TaResponse.RecPOI getRecPoi(int paramInt)
    {
      return (TaResponse.RecPOI)this.f.get(paramInt);
    }
    
    public int getRecPoiCount()
    {
      return this.f.size();
    }
    
    public List<TaResponse.RecPOI> getRecPoiList()
    {
      return this.f;
    }
    
    public String getRemindContent()
    {
      return this.P;
    }
    
    public String getRemindSubContent()
    {
      return this.R;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasMainList()) {
        i1 = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMainList());
      }
      int i2 = i1;
      if (hasEditInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(2, getEditInfo());
      }
      Iterator localIterator = getPoiList().iterator();
      while (localIterator.hasNext()) {
        i2 = CodedOutputStreamMicro.computeMessageSize(3, (TaResponse.TaPOI)localIterator.next()) + i2;
      }
      localIterator = getRecPoiList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(4, (TaResponse.RecPOI)localIterator.next());
      }
      i1 = i2;
      if (hasUpdateRemindInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(5, getUpdateRemindInfo());
      }
      i2 = i1;
      if (hasUpdateRcInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(6, getUpdateRcInfo());
      }
      i1 = i2;
      if (hasTripUpdateInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(7, getTripUpdateInfo());
      }
      localIterator = getOrderSetsList().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(8, (TaResponse.OrderSet)localIterator.next());
      }
      localIterator = getFlightListList().iterator();
      i2 = i1;
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(9, (TaResponse.FlightConfigData)localIterator.next());
      }
      i1 = i2;
      if (hasFlightData()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(10, getFlightData());
      }
      i2 = i1;
      if (hasFlightSugData()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(11, getFlightSugData());
      }
      localIterator = getFlightDetailList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(12, (TaResponse.FlightNoDetailData)localIterator.next());
      }
      i1 = i2;
      if (hasTrainCityInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(13, getTrainCityInfo());
      }
      localIterator = getTrainListList().iterator();
      i2 = i1;
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(14, (TaResponse.TrainList)localIterator.next());
      }
      i1 = i2;
      if (hasNearList()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(15, getNearList());
      }
      i2 = i1;
      if (hasMapShow()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(16, getMapShow());
      }
      localIterator = getTrainStopInfoList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(17, (TaResponse.TrainStopData)localIterator.next());
      }
      i1 = i2;
      if (hasShareTripInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(18, getShareTripInfo());
      }
      i2 = i1;
      if (hasVersion()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(19, getVersion());
      }
      i1 = i2;
      if (hasShareLinkInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(20, getShareLinkInfo());
      }
      i2 = i1;
      if (hasBaseMapList()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(21, getBaseMapList());
      }
      i1 = i2;
      if (hasSmsConfigData()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(22, getSmsConfigData());
      }
      i2 = i1;
      if (hasCalendarUploadInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(23, getCalendarUploadInfo());
      }
      localIterator = getDriverPageInfoList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(24, (TaResponse.DriverPageInfo)localIterator.next());
      }
      i1 = i2;
      if (hasRemindContent()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(25, getRemindContent());
      }
      i2 = i1;
      if (hasRemindSubContent()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(26, getRemindSubContent());
      }
      i1 = i2;
      if (hasJumpUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(27, getJumpUrl());
      }
      i2 = i1;
      if (hasPageContent()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(28, getPageContent());
      }
      i1 = i2;
      if (hasUiData()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(29, getUiData());
      }
      i2 = i1;
      if (hasControlData()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(30, getControlData());
      }
      localIterator = getPointSugList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(31, (TaResponse.AddPagePointSug)localIterator.next());
      }
      localIterator = getTravelModSugList().iterator();
      i1 = i2;
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(32, (TaResponse.AddPageTravelModSug)localIterator.next());
      }
      localIterator = getTripTitleSugList().iterator();
      while (localIterator.hasNext()) {
        i1 += CodedOutputStreamMicro.computeMessageSize(33, (TaResponse.AddPageTripTitleSug)localIterator.next());
      }
      i2 = i1;
      if (hasTrainDetailContent()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(34, getTrainDetailContent());
      }
      localIterator = getTrainDetailInfoList().iterator();
      while (localIterator.hasNext()) {
        i2 += CodedOutputStreamMicro.computeMessageSize(35, (TaResponse.TrainDetailInfo)localIterator.next());
      }
      i1 = i2;
      if (hasTrainNo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(36, getTrainNo());
      }
      i2 = i1;
      if (hasSmsUploadInfo()) {
        i2 = i1 + CodedOutputStreamMicro.computeMessageSize(37, getSmsUploadInfo());
      }
      i1 = i2;
      if (hasTrip()) {
        i1 = i2 + CodedOutputStreamMicro.computeMessageSize(38, getTrip());
      }
      i2 = i1;
      if (hasSugTripType()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(39, getSugTripType());
      }
      this.ao = i2;
      return i2;
    }
    
    public TaResponse.ShareLinkInfo getShareLinkInfo()
    {
      return this.G;
    }
    
    public TaResponse.ShareTripInfo getShareTripInfo()
    {
      return this.C;
    }
    
    public String getSmsConfigData()
    {
      return this.K;
    }
    
    public TaResponse.SmsUploadInfo getSmsUploadInfo()
    {
      return this.aj;
    }
    
    public int getSugTripType()
    {
      return this.an;
    }
    
    public TaResponse.TrainCityInfo getTrainCityInfo()
    {
      return this.u;
    }
    
    public String getTrainDetailContent()
    {
      return this.ae;
    }
    
    public TaResponse.TrainDetailInfo getTrainDetailInfo(int paramInt)
    {
      return (TaResponse.TrainDetailInfo)this.af.get(paramInt);
    }
    
    public int getTrainDetailInfoCount()
    {
      return this.af.size();
    }
    
    public List<TaResponse.TrainDetailInfo> getTrainDetailInfoList()
    {
      return this.af;
    }
    
    public TaResponse.TrainList getTrainList(int paramInt)
    {
      return (TaResponse.TrainList)this.v.get(paramInt);
    }
    
    public int getTrainListCount()
    {
      return this.v.size();
    }
    
    public List<TaResponse.TrainList> getTrainListList()
    {
      return this.v;
    }
    
    public String getTrainNo()
    {
      return this.ah;
    }
    
    public TaResponse.TrainStopData getTrainStopInfo(int paramInt)
    {
      return (TaResponse.TrainStopData)this.A.get(paramInt);
    }
    
    public int getTrainStopInfoCount()
    {
      return this.A.size();
    }
    
    public List<TaResponse.TrainStopData> getTrainStopInfoList()
    {
      return this.A;
    }
    
    public TaResponse.AddPageTravelModSug getTravelModSug(int paramInt)
    {
      return (TaResponse.AddPageTravelModSug)this.ab.get(paramInt);
    }
    
    public int getTravelModSugCount()
    {
      return this.ab.size();
    }
    
    public List<TaResponse.AddPageTravelModSug> getTravelModSugList()
    {
      return this.ab;
    }
    
    public TaResponse.MLTrip getTrip()
    {
      return this.al;
    }
    
    public TaResponse.AddPageTripTitleSug getTripTitleSug(int paramInt)
    {
      return (TaResponse.AddPageTripTitleSug)this.ac.get(paramInt);
    }
    
    public int getTripTitleSugCount()
    {
      return this.ac.size();
    }
    
    public List<TaResponse.AddPageTripTitleSug> getTripTitleSugList()
    {
      return this.ac;
    }
    
    public TaResponse.IsTripUpdate getTripUpdateInfo()
    {
      return this.l;
    }
    
    public TaResponse.UiData getUiData()
    {
      return this.X;
    }
    
    public TaResponse.UpdateRCInfo getUpdateRcInfo()
    {
      return this.j;
    }
    
    public TaResponse.UpdateRemindInfo getUpdateRemindInfo()
    {
      return this.h;
    }
    
    public long getVersion()
    {
      return this.E;
    }
    
    public boolean hasBaseMapList()
    {
      return this.H;
    }
    
    public boolean hasCalendarUploadInfo()
    {
      return this.L;
    }
    
    public boolean hasControlData()
    {
      return this.Y;
    }
    
    public boolean hasEditInfo()
    {
      return this.c;
    }
    
    public boolean hasFlightData()
    {
      return this.o;
    }
    
    public boolean hasFlightSugData()
    {
      return this.q;
    }
    
    public boolean hasJumpUrl()
    {
      return this.S;
    }
    
    public boolean hasMainList()
    {
      return this.a;
    }
    
    public boolean hasMapShow()
    {
      return this.y;
    }
    
    public boolean hasNearList()
    {
      return this.w;
    }
    
    public boolean hasPageContent()
    {
      return this.U;
    }
    
    public boolean hasRemindContent()
    {
      return this.O;
    }
    
    public boolean hasRemindSubContent()
    {
      return this.Q;
    }
    
    public boolean hasShareLinkInfo()
    {
      return this.F;
    }
    
    public boolean hasShareTripInfo()
    {
      return this.B;
    }
    
    public boolean hasSmsConfigData()
    {
      return this.J;
    }
    
    public boolean hasSmsUploadInfo()
    {
      return this.ai;
    }
    
    public boolean hasSugTripType()
    {
      return this.am;
    }
    
    public boolean hasTrainCityInfo()
    {
      return this.t;
    }
    
    public boolean hasTrainDetailContent()
    {
      return this.ad;
    }
    
    public boolean hasTrainNo()
    {
      return this.ag;
    }
    
    public boolean hasTrip()
    {
      return this.ak;
    }
    
    public boolean hasTripUpdateInfo()
    {
      return this.k;
    }
    
    public boolean hasUiData()
    {
      return this.W;
    }
    
    public boolean hasUpdateRcInfo()
    {
      return this.i;
    }
    
    public boolean hasUpdateRemindInfo()
    {
      return this.g;
    }
    
    public boolean hasVersion()
    {
      return this.D;
    }
    
    public final boolean isInitialized()
    {
      if ((hasMainList()) && (!getMainList().isInitialized())) {
        return false;
      }
      if ((hasEditInfo()) && (!getEditInfo().isInitialized())) {
        return false;
      }
      Iterator localIterator = getPoiList().iterator();
      while (localIterator.hasNext()) {
        if (!((TaResponse.TaPOI)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      localIterator = getRecPoiList().iterator();
      while (localIterator.hasNext()) {
        if (!((TaResponse.RecPOI)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      if ((hasUpdateRemindInfo()) && (!getUpdateRemindInfo().isInitialized())) {
        return false;
      }
      if ((hasUpdateRcInfo()) && (!getUpdateRcInfo().isInitialized())) {
        return false;
      }
      if ((hasTripUpdateInfo()) && (!getTripUpdateInfo().isInitialized())) {
        return false;
      }
      if ((hasBaseMapList()) && (!getBaseMapList().isInitialized())) {
        return false;
      }
      return (!hasTrip()) || (getTrip().isInitialized());
    }
    
    public TaContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new TaResponse.ML();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setMainList((TaResponse.ML)localObject);
          break;
        case 18: 
          localObject = new TaResponse.UpdateInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setEditInfo((TaResponse.UpdateInfo)localObject);
          break;
        case 26: 
          localObject = new TaResponse.TaPOI();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addPoi((TaResponse.TaPOI)localObject);
          break;
        case 34: 
          localObject = new TaResponse.RecPOI();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addRecPoi((TaResponse.RecPOI)localObject);
          break;
        case 42: 
          localObject = new TaResponse.UpdateRemindInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUpdateRemindInfo((TaResponse.UpdateRemindInfo)localObject);
          break;
        case 50: 
          localObject = new TaResponse.UpdateRCInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUpdateRcInfo((TaResponse.UpdateRCInfo)localObject);
          break;
        case 58: 
          localObject = new TaResponse.IsTripUpdate();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTripUpdateInfo((TaResponse.IsTripUpdate)localObject);
          break;
        case 66: 
          localObject = new TaResponse.OrderSet();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addOrderSets((TaResponse.OrderSet)localObject);
          break;
        case 74: 
          localObject = new TaResponse.FlightConfigData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addFlightList((TaResponse.FlightConfigData)localObject);
          break;
        case 82: 
          localObject = new TaResponse.FlightCheckData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setFlightData((TaResponse.FlightCheckData)localObject);
          break;
        case 90: 
          localObject = new TaResponse.FlightSugData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setFlightSugData((TaResponse.FlightSugData)localObject);
          break;
        case 98: 
          localObject = new TaResponse.FlightNoDetailData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addFlightDetail((TaResponse.FlightNoDetailData)localObject);
          break;
        case 106: 
          localObject = new TaResponse.TrainCityInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTrainCityInfo((TaResponse.TrainCityInfo)localObject);
          break;
        case 114: 
          localObject = new TaResponse.TrainList();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTrainList((TaResponse.TrainList)localObject);
          break;
        case 122: 
          localObject = new TaResponse.NearMainList();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setNearList((TaResponse.NearMainList)localObject);
          break;
        case 130: 
          localObject = new TaResponse.MapShowButton();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setMapShow((TaResponse.MapShowButton)localObject);
          break;
        case 138: 
          localObject = new TaResponse.TrainStopData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTrainStopInfo((TaResponse.TrainStopData)localObject);
          break;
        case 146: 
          localObject = new TaResponse.ShareTripInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setShareTripInfo((TaResponse.ShareTripInfo)localObject);
          break;
        case 152: 
          setVersion(paramCodedInputStreamMicro.readInt64());
          break;
        case 162: 
          localObject = new TaResponse.ShareLinkInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setShareLinkInfo((TaResponse.ShareLinkInfo)localObject);
          break;
        case 170: 
          localObject = new TaResponse.BaseMapList();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setBaseMapList((TaResponse.BaseMapList)localObject);
          break;
        case 178: 
          setSmsConfigData(paramCodedInputStreamMicro.readString());
          break;
        case 186: 
          localObject = new TaResponse.CalendarUploadInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCalendarUploadInfo((TaResponse.CalendarUploadInfo)localObject);
          break;
        case 194: 
          localObject = new TaResponse.DriverPageInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addDriverPageInfo((TaResponse.DriverPageInfo)localObject);
          break;
        case 202: 
          setRemindContent(paramCodedInputStreamMicro.readString());
          break;
        case 210: 
          setRemindSubContent(paramCodedInputStreamMicro.readString());
          break;
        case 218: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 226: 
          localObject = new TaResponse.PageContent();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setPageContent((TaResponse.PageContent)localObject);
          break;
        case 234: 
          localObject = new TaResponse.UiData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setUiData((TaResponse.UiData)localObject);
          break;
        case 242: 
          localObject = new TaResponse.ControlData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setControlData((TaResponse.ControlData)localObject);
          break;
        case 250: 
          localObject = new TaResponse.AddPagePointSug();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addPointSug((TaResponse.AddPagePointSug)localObject);
          break;
        case 258: 
          localObject = new TaResponse.AddPageTravelModSug();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTravelModSug((TaResponse.AddPageTravelModSug)localObject);
          break;
        case 266: 
          localObject = new TaResponse.AddPageTripTitleSug();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTripTitleSug((TaResponse.AddPageTripTitleSug)localObject);
          break;
        case 274: 
          setTrainDetailContent(paramCodedInputStreamMicro.readString());
          break;
        case 282: 
          localObject = new TaResponse.TrainDetailInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addTrainDetailInfo((TaResponse.TrainDetailInfo)localObject);
          break;
        case 290: 
          setTrainNo(paramCodedInputStreamMicro.readString());
          break;
        case 298: 
          localObject = new TaResponse.SmsUploadInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setSmsUploadInfo((TaResponse.SmsUploadInfo)localObject);
          break;
        case 306: 
          localObject = new TaResponse.MLTrip();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTrip((TaResponse.MLTrip)localObject);
          break;
        case 312: 
          setSugTripType(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public TaContent setBaseMapList(TaResponse.BaseMapList paramBaseMapList)
    {
      if (paramBaseMapList == null) {
        return clearBaseMapList();
      }
      this.H = true;
      this.I = paramBaseMapList;
      return this;
    }
    
    public TaContent setCalendarUploadInfo(TaResponse.CalendarUploadInfo paramCalendarUploadInfo)
    {
      if (paramCalendarUploadInfo == null) {
        return clearCalendarUploadInfo();
      }
      this.L = true;
      this.M = paramCalendarUploadInfo;
      return this;
    }
    
    public TaContent setControlData(TaResponse.ControlData paramControlData)
    {
      if (paramControlData == null) {
        return clearControlData();
      }
      this.Y = true;
      this.Z = paramControlData;
      return this;
    }
    
    public TaContent setDriverPageInfo(int paramInt, TaResponse.DriverPageInfo paramDriverPageInfo)
    {
      if (paramDriverPageInfo == null) {
        return this;
      }
      this.N.set(paramInt, paramDriverPageInfo);
      return this;
    }
    
    public TaContent setEditInfo(TaResponse.UpdateInfo paramUpdateInfo)
    {
      if (paramUpdateInfo == null) {
        return clearEditInfo();
      }
      this.c = true;
      this.d = paramUpdateInfo;
      return this;
    }
    
    public TaContent setFlightData(TaResponse.FlightCheckData paramFlightCheckData)
    {
      if (paramFlightCheckData == null) {
        return clearFlightData();
      }
      this.o = true;
      this.p = paramFlightCheckData;
      return this;
    }
    
    public TaContent setFlightDetail(int paramInt, TaResponse.FlightNoDetailData paramFlightNoDetailData)
    {
      if (paramFlightNoDetailData == null) {
        return this;
      }
      this.s.set(paramInt, paramFlightNoDetailData);
      return this;
    }
    
    public TaContent setFlightList(int paramInt, TaResponse.FlightConfigData paramFlightConfigData)
    {
      if (paramFlightConfigData == null) {
        return this;
      }
      this.n.set(paramInt, paramFlightConfigData);
      return this;
    }
    
    public TaContent setFlightSugData(TaResponse.FlightSugData paramFlightSugData)
    {
      if (paramFlightSugData == null) {
        return clearFlightSugData();
      }
      this.q = true;
      this.r = paramFlightSugData;
      return this;
    }
    
    public TaContent setJumpUrl(String paramString)
    {
      this.S = true;
      this.T = paramString;
      return this;
    }
    
    public TaContent setMainList(TaResponse.ML paramML)
    {
      if (paramML == null) {
        return clearMainList();
      }
      this.a = true;
      this.b = paramML;
      return this;
    }
    
    public TaContent setMapShow(TaResponse.MapShowButton paramMapShowButton)
    {
      if (paramMapShowButton == null) {
        return clearMapShow();
      }
      this.y = true;
      this.z = paramMapShowButton;
      return this;
    }
    
    public TaContent setNearList(TaResponse.NearMainList paramNearMainList)
    {
      if (paramNearMainList == null) {
        return clearNearList();
      }
      this.w = true;
      this.x = paramNearMainList;
      return this;
    }
    
    public TaContent setOrderSets(int paramInt, TaResponse.OrderSet paramOrderSet)
    {
      if (paramOrderSet == null) {
        return this;
      }
      this.m.set(paramInt, paramOrderSet);
      return this;
    }
    
    public TaContent setPageContent(TaResponse.PageContent paramPageContent)
    {
      if (paramPageContent == null) {
        return clearPageContent();
      }
      this.U = true;
      this.V = paramPageContent;
      return this;
    }
    
    public TaContent setPoi(int paramInt, TaResponse.TaPOI paramTaPOI)
    {
      if (paramTaPOI == null) {
        return this;
      }
      this.e.set(paramInt, paramTaPOI);
      return this;
    }
    
    public TaContent setPointSug(int paramInt, TaResponse.AddPagePointSug paramAddPagePointSug)
    {
      if (paramAddPagePointSug == null) {
        return this;
      }
      this.aa.set(paramInt, paramAddPagePointSug);
      return this;
    }
    
    public TaContent setRecPoi(int paramInt, TaResponse.RecPOI paramRecPOI)
    {
      if (paramRecPOI == null) {
        return this;
      }
      this.f.set(paramInt, paramRecPOI);
      return this;
    }
    
    public TaContent setRemindContent(String paramString)
    {
      this.O = true;
      this.P = paramString;
      return this;
    }
    
    public TaContent setRemindSubContent(String paramString)
    {
      this.Q = true;
      this.R = paramString;
      return this;
    }
    
    public TaContent setShareLinkInfo(TaResponse.ShareLinkInfo paramShareLinkInfo)
    {
      if (paramShareLinkInfo == null) {
        return clearShareLinkInfo();
      }
      this.F = true;
      this.G = paramShareLinkInfo;
      return this;
    }
    
    public TaContent setShareTripInfo(TaResponse.ShareTripInfo paramShareTripInfo)
    {
      if (paramShareTripInfo == null) {
        return clearShareTripInfo();
      }
      this.B = true;
      this.C = paramShareTripInfo;
      return this;
    }
    
    public TaContent setSmsConfigData(String paramString)
    {
      this.J = true;
      this.K = paramString;
      return this;
    }
    
    public TaContent setSmsUploadInfo(TaResponse.SmsUploadInfo paramSmsUploadInfo)
    {
      if (paramSmsUploadInfo == null) {
        return clearSmsUploadInfo();
      }
      this.ai = true;
      this.aj = paramSmsUploadInfo;
      return this;
    }
    
    public TaContent setSugTripType(int paramInt)
    {
      this.am = true;
      this.an = paramInt;
      return this;
    }
    
    public TaContent setTrainCityInfo(TaResponse.TrainCityInfo paramTrainCityInfo)
    {
      if (paramTrainCityInfo == null) {
        return clearTrainCityInfo();
      }
      this.t = true;
      this.u = paramTrainCityInfo;
      return this;
    }
    
    public TaContent setTrainDetailContent(String paramString)
    {
      this.ad = true;
      this.ae = paramString;
      return this;
    }
    
    public TaContent setTrainDetailInfo(int paramInt, TaResponse.TrainDetailInfo paramTrainDetailInfo)
    {
      if (paramTrainDetailInfo == null) {
        return this;
      }
      this.af.set(paramInt, paramTrainDetailInfo);
      return this;
    }
    
    public TaContent setTrainList(int paramInt, TaResponse.TrainList paramTrainList)
    {
      if (paramTrainList == null) {
        return this;
      }
      this.v.set(paramInt, paramTrainList);
      return this;
    }
    
    public TaContent setTrainNo(String paramString)
    {
      this.ag = true;
      this.ah = paramString;
      return this;
    }
    
    public TaContent setTrainStopInfo(int paramInt, TaResponse.TrainStopData paramTrainStopData)
    {
      if (paramTrainStopData == null) {
        return this;
      }
      this.A.set(paramInt, paramTrainStopData);
      return this;
    }
    
    public TaContent setTravelModSug(int paramInt, TaResponse.AddPageTravelModSug paramAddPageTravelModSug)
    {
      if (paramAddPageTravelModSug == null) {
        return this;
      }
      this.ab.set(paramInt, paramAddPageTravelModSug);
      return this;
    }
    
    public TaContent setTrip(TaResponse.MLTrip paramMLTrip)
    {
      if (paramMLTrip == null) {
        return clearTrip();
      }
      this.ak = true;
      this.al = paramMLTrip;
      return this;
    }
    
    public TaContent setTripTitleSug(int paramInt, TaResponse.AddPageTripTitleSug paramAddPageTripTitleSug)
    {
      if (paramAddPageTripTitleSug == null) {
        return this;
      }
      this.ac.set(paramInt, paramAddPageTripTitleSug);
      return this;
    }
    
    public TaContent setTripUpdateInfo(TaResponse.IsTripUpdate paramIsTripUpdate)
    {
      if (paramIsTripUpdate == null) {
        return clearTripUpdateInfo();
      }
      this.k = true;
      this.l = paramIsTripUpdate;
      return this;
    }
    
    public TaContent setUiData(TaResponse.UiData paramUiData)
    {
      if (paramUiData == null) {
        return clearUiData();
      }
      this.W = true;
      this.X = paramUiData;
      return this;
    }
    
    public TaContent setUpdateRcInfo(TaResponse.UpdateRCInfo paramUpdateRCInfo)
    {
      if (paramUpdateRCInfo == null) {
        return clearUpdateRcInfo();
      }
      this.i = true;
      this.j = paramUpdateRCInfo;
      return this;
    }
    
    public TaContent setUpdateRemindInfo(TaResponse.UpdateRemindInfo paramUpdateRemindInfo)
    {
      if (paramUpdateRemindInfo == null) {
        return clearUpdateRemindInfo();
      }
      this.g = true;
      this.h = paramUpdateRemindInfo;
      return this;
    }
    
    public TaContent setVersion(long paramLong)
    {
      this.D = true;
      this.E = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasMainList()) {
        paramCodedOutputStreamMicro.writeMessage(1, getMainList());
      }
      if (hasEditInfo()) {
        paramCodedOutputStreamMicro.writeMessage(2, getEditInfo());
      }
      Iterator localIterator = getPoiList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (TaResponse.TaPOI)localIterator.next());
      }
      localIterator = getRecPoiList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(4, (TaResponse.RecPOI)localIterator.next());
      }
      if (hasUpdateRemindInfo()) {
        paramCodedOutputStreamMicro.writeMessage(5, getUpdateRemindInfo());
      }
      if (hasUpdateRcInfo()) {
        paramCodedOutputStreamMicro.writeMessage(6, getUpdateRcInfo());
      }
      if (hasTripUpdateInfo()) {
        paramCodedOutputStreamMicro.writeMessage(7, getTripUpdateInfo());
      }
      localIterator = getOrderSetsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(8, (TaResponse.OrderSet)localIterator.next());
      }
      localIterator = getFlightListList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(9, (TaResponse.FlightConfigData)localIterator.next());
      }
      if (hasFlightData()) {
        paramCodedOutputStreamMicro.writeMessage(10, getFlightData());
      }
      if (hasFlightSugData()) {
        paramCodedOutputStreamMicro.writeMessage(11, getFlightSugData());
      }
      localIterator = getFlightDetailList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(12, (TaResponse.FlightNoDetailData)localIterator.next());
      }
      if (hasTrainCityInfo()) {
        paramCodedOutputStreamMicro.writeMessage(13, getTrainCityInfo());
      }
      localIterator = getTrainListList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(14, (TaResponse.TrainList)localIterator.next());
      }
      if (hasNearList()) {
        paramCodedOutputStreamMicro.writeMessage(15, getNearList());
      }
      if (hasMapShow()) {
        paramCodedOutputStreamMicro.writeMessage(16, getMapShow());
      }
      localIterator = getTrainStopInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(17, (TaResponse.TrainStopData)localIterator.next());
      }
      if (hasShareTripInfo()) {
        paramCodedOutputStreamMicro.writeMessage(18, getShareTripInfo());
      }
      if (hasVersion()) {
        paramCodedOutputStreamMicro.writeInt64(19, getVersion());
      }
      if (hasShareLinkInfo()) {
        paramCodedOutputStreamMicro.writeMessage(20, getShareLinkInfo());
      }
      if (hasBaseMapList()) {
        paramCodedOutputStreamMicro.writeMessage(21, getBaseMapList());
      }
      if (hasSmsConfigData()) {
        paramCodedOutputStreamMicro.writeString(22, getSmsConfigData());
      }
      if (hasCalendarUploadInfo()) {
        paramCodedOutputStreamMicro.writeMessage(23, getCalendarUploadInfo());
      }
      localIterator = getDriverPageInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(24, (TaResponse.DriverPageInfo)localIterator.next());
      }
      if (hasRemindContent()) {
        paramCodedOutputStreamMicro.writeString(25, getRemindContent());
      }
      if (hasRemindSubContent()) {
        paramCodedOutputStreamMicro.writeString(26, getRemindSubContent());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(27, getJumpUrl());
      }
      if (hasPageContent()) {
        paramCodedOutputStreamMicro.writeMessage(28, getPageContent());
      }
      if (hasUiData()) {
        paramCodedOutputStreamMicro.writeMessage(29, getUiData());
      }
      if (hasControlData()) {
        paramCodedOutputStreamMicro.writeMessage(30, getControlData());
      }
      localIterator = getPointSugList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(31, (TaResponse.AddPagePointSug)localIterator.next());
      }
      localIterator = getTravelModSugList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(32, (TaResponse.AddPageTravelModSug)localIterator.next());
      }
      localIterator = getTripTitleSugList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(33, (TaResponse.AddPageTripTitleSug)localIterator.next());
      }
      if (hasTrainDetailContent()) {
        paramCodedOutputStreamMicro.writeString(34, getTrainDetailContent());
      }
      localIterator = getTrainDetailInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(35, (TaResponse.TrainDetailInfo)localIterator.next());
      }
      if (hasTrainNo()) {
        paramCodedOutputStreamMicro.writeString(36, getTrainNo());
      }
      if (hasSmsUploadInfo()) {
        paramCodedOutputStreamMicro.writeMessage(37, getSmsUploadInfo());
      }
      if (hasTrip()) {
        paramCodedOutputStreamMicro.writeMessage(38, getTrip());
      }
      if (hasSugTripType()) {
        paramCodedOutputStreamMicro.writeInt32(39, getSugTripType());
      }
    }
  }
  
  public static final class TaPOI
    extends MessageMicro
  {
    public static final int DETAIL_URL_FIELD_NUMBER = 10;
    public static final int END_CONTENT_FIELD_NUMBER = 8;
    public static final int END_TIME_FIELD_NUMBER = 6;
    public static final int EXT_INFO_FIELD_NUMBER = 13;
    public static final int EXT_TITLE_FIELD_NUMBER = 12;
    public static final int INFO_FIELD_NUMBER = 2;
    public static final int JUMP_URL_FIELD_NUMBER = 9;
    public static final int REMARK_FIELD_NUMBER = 11;
    public static final int START_CONTENT_FIELD_NUMBER = 7;
    public static final int START_TIME_FIELD_NUMBER = 5;
    public static final int SUG_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 4;
    public static final int TRIP_ID_FIELD_NUMBER = 1;
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
    private boolean s;
    private String t = "";
    private boolean u;
    private String v = "";
    private boolean w;
    private String x = "";
    private List<TaResponse.TaPOITemp> y = Collections.emptyList();
    private int z = -1;
    
    public static TaPOI parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TaPOI().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TaPOI parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TaPOI)new TaPOI().mergeFrom(paramArrayOfByte);
    }
    
    public TaPOI addExtInfo(TaResponse.TaPOITemp paramTaPOITemp)
    {
      if (paramTaPOITemp == null) {
        return this;
      }
      if (this.y.isEmpty()) {
        this.y = new ArrayList();
      }
      this.y.add(paramTaPOITemp);
      return this;
    }
    
    public final TaPOI clear()
    {
      clearTripId();
      clearInfo();
      clearSug();
      clearTitle();
      clearStartTime();
      clearEndTime();
      clearStartContent();
      clearEndContent();
      clearJumpUrl();
      clearDetailUrl();
      clearRemark();
      clearExtTitle();
      clearExtInfo();
      this.z = -1;
      return this;
    }
    
    public TaPOI clearDetailUrl()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public TaPOI clearEndContent()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public TaPOI clearEndTime()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public TaPOI clearExtInfo()
    {
      this.y = Collections.emptyList();
      return this;
    }
    
    public TaPOI clearExtTitle()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public TaPOI clearInfo()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public TaPOI clearJumpUrl()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public TaPOI clearRemark()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public TaPOI clearStartContent()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public TaPOI clearStartTime()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public TaPOI clearSug()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public TaPOI clearTitle()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public TaPOI clearTripId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.z < 0) {
        getSerializedSize();
      }
      return this.z;
    }
    
    public String getDetailUrl()
    {
      return this.t;
    }
    
    public String getEndContent()
    {
      return this.p;
    }
    
    public String getEndTime()
    {
      return this.l;
    }
    
    public TaResponse.TaPOITemp getExtInfo(int paramInt)
    {
      return (TaResponse.TaPOITemp)this.y.get(paramInt);
    }
    
    public int getExtInfoCount()
    {
      return this.y.size();
    }
    
    public List<TaResponse.TaPOITemp> getExtInfoList()
    {
      return this.y;
    }
    
    public String getExtTitle()
    {
      return this.x;
    }
    
    public String getInfo()
    {
      return this.d;
    }
    
    public String getJumpUrl()
    {
      return this.r;
    }
    
    public String getRemark()
    {
      return this.v;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasTripId()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTripId());
      }
      int i1 = i2;
      if (hasInfo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getInfo());
      }
      i2 = i1;
      if (hasSug()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getSug());
      }
      i1 = i2;
      if (hasTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getTitle());
      }
      i2 = i1;
      if (hasStartTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getStartTime());
      }
      i1 = i2;
      if (hasEndTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getEndTime());
      }
      i2 = i1;
      if (hasStartContent()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getStartContent());
      }
      i1 = i2;
      if (hasEndContent()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getEndContent());
      }
      i2 = i1;
      if (hasJumpUrl()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getJumpUrl());
      }
      i1 = i2;
      if (hasDetailUrl()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getDetailUrl());
      }
      i2 = i1;
      if (hasRemark()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getRemark());
      }
      i1 = i2;
      if (hasExtTitle()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getExtTitle());
      }
      Iterator localIterator = getExtInfoList().iterator();
      while (localIterator.hasNext()) {
        i1 = CodedOutputStreamMicro.computeMessageSize(13, (TaResponse.TaPOITemp)localIterator.next()) + i1;
      }
      this.z = i1;
      return i1;
    }
    
    public String getStartContent()
    {
      return this.n;
    }
    
    public String getStartTime()
    {
      return this.j;
    }
    
    public String getSug()
    {
      return this.f;
    }
    
    public String getTitle()
    {
      return this.h;
    }
    
    public String getTripId()
    {
      return this.b;
    }
    
    public boolean hasDetailUrl()
    {
      return this.s;
    }
    
    public boolean hasEndContent()
    {
      return this.o;
    }
    
    public boolean hasEndTime()
    {
      return this.k;
    }
    
    public boolean hasExtTitle()
    {
      return this.w;
    }
    
    public boolean hasInfo()
    {
      return this.c;
    }
    
    public boolean hasJumpUrl()
    {
      return this.q;
    }
    
    public boolean hasRemark()
    {
      return this.u;
    }
    
    public boolean hasStartContent()
    {
      return this.m;
    }
    
    public boolean hasStartTime()
    {
      return this.i;
    }
    
    public boolean hasSug()
    {
      return this.e;
    }
    
    public boolean hasTitle()
    {
      return this.g;
    }
    
    public boolean hasTripId()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e)) {
        return false;
      }
      return true;
    }
    
    public TaPOI mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTripId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setInfo(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setSug(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setStartTime(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setEndTime(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setStartContent(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setEndContent(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setJumpUrl(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setDetailUrl(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setRemark(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setExtTitle(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          TaResponse.TaPOITemp localTaPOITemp = new TaResponse.TaPOITemp();
          paramCodedInputStreamMicro.readMessage(localTaPOITemp);
          addExtInfo(localTaPOITemp);
        }
      }
    }
    
    public TaPOI setDetailUrl(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public TaPOI setEndContent(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public TaPOI setEndTime(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public TaPOI setExtInfo(int paramInt, TaResponse.TaPOITemp paramTaPOITemp)
    {
      if (paramTaPOITemp == null) {
        return this;
      }
      this.y.set(paramInt, paramTaPOITemp);
      return this;
    }
    
    public TaPOI setExtTitle(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public TaPOI setInfo(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public TaPOI setJumpUrl(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public TaPOI setRemark(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public TaPOI setStartContent(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public TaPOI setStartTime(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public TaPOI setSug(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public TaPOI setTitle(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public TaPOI setTripId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTripId()) {
        paramCodedOutputStreamMicro.writeString(1, getTripId());
      }
      if (hasInfo()) {
        paramCodedOutputStreamMicro.writeString(2, getInfo());
      }
      if (hasSug()) {
        paramCodedOutputStreamMicro.writeString(3, getSug());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(4, getTitle());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeString(5, getStartTime());
      }
      if (hasEndTime()) {
        paramCodedOutputStreamMicro.writeString(6, getEndTime());
      }
      if (hasStartContent()) {
        paramCodedOutputStreamMicro.writeString(7, getStartContent());
      }
      if (hasEndContent()) {
        paramCodedOutputStreamMicro.writeString(8, getEndContent());
      }
      if (hasJumpUrl()) {
        paramCodedOutputStreamMicro.writeString(9, getJumpUrl());
      }
      if (hasDetailUrl()) {
        paramCodedOutputStreamMicro.writeString(10, getDetailUrl());
      }
      if (hasRemark()) {
        paramCodedOutputStreamMicro.writeString(11, getRemark());
      }
      if (hasExtTitle()) {
        paramCodedOutputStreamMicro.writeString(12, getExtTitle());
      }
      Iterator localIterator = getExtInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(13, (TaResponse.TaPOITemp)localIterator.next());
      }
    }
  }
  
  public static final class TaPOITemp
    extends MessageMicro
  {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static TaPOITemp parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TaPOITemp().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TaPOITemp parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TaPOITemp)new TaPOITemp().mergeFrom(paramArrayOfByte);
    }
    
    public final TaPOITemp clear()
    {
      clearTitle();
      clearContent();
      this.e = -1;
      return this;
    }
    
    public TaPOITemp clearContent()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public TaPOITemp clearTitle()
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
    
    public TaPOITemp mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
    
    public TaPOITemp setContent(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public TaPOITemp setTitle(String paramString)
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
  
  public static final class TaResult
    extends MessageMicro
  {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static TaResult parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TaResult().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TaResult parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TaResult)new TaResult().mergeFrom(paramArrayOfByte);
    }
    
    public final TaResult clear()
    {
      clearError();
      clearMsg();
      this.e = -1;
      return this;
    }
    
    public TaResult clearError()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public TaResult clearMsg()
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
    
    public int getError()
    {
      return this.b;
    }
    
    public String getMsg()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasError()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
      }
      int j = i;
      if (hasMsg()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getMsg());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasError()
    {
      return this.a;
    }
    
    public boolean hasMsg()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while (!this.c) {
        return false;
      }
      return true;
    }
    
    public TaResult mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setError(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          setMsg(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public TaResult setError(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public TaResult setMsg(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasError()) {
        paramCodedOutputStreamMicro.writeInt32(1, getError());
      }
      if (hasMsg()) {
        paramCodedOutputStreamMicro.writeString(2, getMsg());
      }
    }
  }
  
  public static final class TrainCityInfo
    extends MessageMicro
  {
    public static final int TRAIN_INFO_FIELD_NUMBER = 1;
    public static final int VERSION_FIELD_NUMBER = 2;
    private List<TaResponse.TrainDetail> a = Collections.emptyList();
    private boolean b;
    private long c = 0L;
    private int d = -1;
    
    public static TrainCityInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TrainCityInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TrainCityInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TrainCityInfo)new TrainCityInfo().mergeFrom(paramArrayOfByte);
    }
    
    public TrainCityInfo addTrainInfo(TaResponse.TrainDetail paramTrainDetail)
    {
      if (paramTrainDetail == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramTrainDetail);
      return this;
    }
    
    public final TrainCityInfo clear()
    {
      clearTrainInfo();
      clearVersion();
      this.d = -1;
      return this;
    }
    
    public TrainCityInfo clearTrainInfo()
    {
      this.a = Collections.emptyList();
      return this;
    }
    
    public TrainCityInfo clearVersion()
    {
      this.b = false;
      this.c = 0L;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public int getSerializedSize()
    {
      Iterator localIterator = getTrainInfoList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (TaResponse.TrainDetail)localIterator.next()) + i) {}
      int j = i;
      if (hasVersion()) {
        j = i + CodedOutputStreamMicro.computeInt64Size(2, getVersion());
      }
      this.d = j;
      return j;
    }
    
    public TaResponse.TrainDetail getTrainInfo(int paramInt)
    {
      return (TaResponse.TrainDetail)this.a.get(paramInt);
    }
    
    public int getTrainInfoCount()
    {
      return this.a.size();
    }
    
    public List<TaResponse.TrainDetail> getTrainInfoList()
    {
      return this.a;
    }
    
    public long getVersion()
    {
      return this.c;
    }
    
    public boolean hasVersion()
    {
      return this.b;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public TrainCityInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.TrainDetail localTrainDetail = new TaResponse.TrainDetail();
          paramCodedInputStreamMicro.readMessage(localTrainDetail);
          addTrainInfo(localTrainDetail);
          break;
        case 16: 
          setVersion(paramCodedInputStreamMicro.readInt64());
        }
      }
    }
    
    public TrainCityInfo setTrainInfo(int paramInt, TaResponse.TrainDetail paramTrainDetail)
    {
      if (paramTrainDetail == null) {
        return this;
      }
      this.a.set(paramInt, paramTrainDetail);
      return this;
    }
    
    public TrainCityInfo setVersion(long paramLong)
    {
      this.b = true;
      this.c = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getTrainInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (TaResponse.TrainDetail)localIterator.next());
      }
      if (hasVersion()) {
        paramCodedOutputStreamMicro.writeInt64(2, getVersion());
      }
    }
  }
  
  public static final class TrainDetail
    extends MessageMicro
  {
    public static final int CITY_INFO_FIELD_NUMBER = 2;
    public static final int SHORT_TITLE_FIELD_NUMBER = 3;
    public static final int SHOW_TYPE_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<TaResponse.CityInfo> c = Collections.emptyList();
    private boolean d;
    private String e = "";
    private boolean f;
    private int g = 0;
    private int h = -1;
    
    public static TrainDetail parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TrainDetail().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TrainDetail parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TrainDetail)new TrainDetail().mergeFrom(paramArrayOfByte);
    }
    
    public TrainDetail addCityInfo(TaResponse.CityInfo paramCityInfo)
    {
      if (paramCityInfo == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramCityInfo);
      return this;
    }
    
    public final TrainDetail clear()
    {
      clearTitle();
      clearCityInfo();
      clearShortTitle();
      clearShowType();
      this.h = -1;
      return this;
    }
    
    public TrainDetail clearCityInfo()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public TrainDetail clearShortTitle()
    {
      this.d = false;
      this.e = "";
      return this;
    }
    
    public TrainDetail clearShowType()
    {
      this.f = false;
      this.g = 0;
      return this;
    }
    
    public TrainDetail clearTitle()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.h < 0) {
        getSerializedSize();
      }
      return this.h;
    }
    
    public TaResponse.CityInfo getCityInfo(int paramInt)
    {
      return (TaResponse.CityInfo)this.c.get(paramInt);
    }
    
    public int getCityInfoCount()
    {
      return this.c.size();
    }
    
    public List<TaResponse.CityInfo> getCityInfoList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasTitle()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
      }
      Iterator localIterator = getCityInfoList().iterator();
      for (int j = i; localIterator.hasNext(); j = CodedOutputStreamMicro.computeMessageSize(2, (TaResponse.CityInfo)localIterator.next()) + j) {}
      i = j;
      if (hasShortTitle()) {
        i = j + CodedOutputStreamMicro.computeStringSize(3, getShortTitle());
      }
      j = i;
      if (hasShowType()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(4, getShowType());
      }
      this.h = j;
      return j;
    }
    
    public String getShortTitle()
    {
      return this.e;
    }
    
    public int getShowType()
    {
      return this.g;
    }
    
    public String getTitle()
    {
      return this.b;
    }
    
    public boolean hasShortTitle()
    {
      return this.d;
    }
    
    public boolean hasShowType()
    {
      return this.f;
    }
    
    public boolean hasTitle()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public TrainDetail mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.CityInfo localCityInfo = new TaResponse.CityInfo();
          paramCodedInputStreamMicro.readMessage(localCityInfo);
          addCityInfo(localCityInfo);
          break;
        case 26: 
          setShortTitle(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setShowType(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public TrainDetail setCityInfo(int paramInt, TaResponse.CityInfo paramCityInfo)
    {
      if (paramCityInfo == null) {
        return this;
      }
      this.c.set(paramInt, paramCityInfo);
      return this;
    }
    
    public TrainDetail setShortTitle(String paramString)
    {
      this.d = true;
      this.e = paramString;
      return this;
    }
    
    public TrainDetail setShowType(int paramInt)
    {
      this.f = true;
      this.g = paramInt;
      return this;
    }
    
    public TrainDetail setTitle(String paramString)
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
      Iterator localIterator = getCityInfoList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (TaResponse.CityInfo)localIterator.next());
      }
      if (hasShortTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getShortTitle());
      }
      if (hasShowType()) {
        paramCodedOutputStreamMicro.writeInt32(4, getShowType());
      }
    }
  }
  
  public static final class TrainDetailInfo
    extends MessageMicro
  {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static TrainDetailInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TrainDetailInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TrainDetailInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TrainDetailInfo)new TrainDetailInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final TrainDetailInfo clear()
    {
      clearTitle();
      clearContent();
      this.e = -1;
      return this;
    }
    
    public TrainDetailInfo clearContent()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public TrainDetailInfo clearTitle()
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
    
    public TrainDetailInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
    
    public TrainDetailInfo setContent(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public TrainDetailInfo setTitle(String paramString)
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
  
  public static final class TrainList
    extends MessageMicro
  {
    public static final int DAY_FIELD_NUMBER = 6;
    public static final int FROM_CITY_ID_FIELD_NUMBER = 9;
    public static final int FROM_CITY_NAME_FIELD_NUMBER = 8;
    public static final int FROM_STATION_FIELD_NUMBER = 1;
    public static final int FROM_TIME_FIELD_NUMBER = 4;
    public static final int TO_CITY_ID_FIELD_NUMBER = 11;
    public static final int TO_CITY_NAME_FIELD_NUMBER = 10;
    public static final int TO_STATION_FIELD_NUMBER = 2;
    public static final int TO_TIME_FIELD_NUMBER = 5;
    public static final int TRAIN_NUMBER_FIELD_NUMBER = 3;
    public static final int USE_TIME_FIELD_NUMBER = 7;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private long h = 0L;
    private boolean i;
    private long j = 0L;
    private boolean k;
    private int l = 0;
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
    private int w = -1;
    
    public static TrainList parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TrainList().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TrainList parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TrainList)new TrainList().mergeFrom(paramArrayOfByte);
    }
    
    public final TrainList clear()
    {
      clearFromStation();
      clearToStation();
      clearTrainNumber();
      clearFromTime();
      clearToTime();
      clearDay();
      clearUseTime();
      clearFromCityName();
      clearFromCityId();
      clearToCityName();
      clearToCityId();
      this.w = -1;
      return this;
    }
    
    public TrainList clearDay()
    {
      this.k = false;
      this.l = 0;
      return this;
    }
    
    public TrainList clearFromCityId()
    {
      this.q = false;
      this.r = "";
      return this;
    }
    
    public TrainList clearFromCityName()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public TrainList clearFromStation()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public TrainList clearFromTime()
    {
      this.g = false;
      this.h = 0L;
      return this;
    }
    
    public TrainList clearToCityId()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public TrainList clearToCityName()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public TrainList clearToStation()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public TrainList clearToTime()
    {
      this.i = false;
      this.j = 0L;
      return this;
    }
    
    public TrainList clearTrainNumber()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public TrainList clearUseTime()
    {
      this.m = false;
      this.n = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.w < 0) {
        getSerializedSize();
      }
      return this.w;
    }
    
    public int getDay()
    {
      return this.l;
    }
    
    public String getFromCityId()
    {
      return this.r;
    }
    
    public String getFromCityName()
    {
      return this.p;
    }
    
    public String getFromStation()
    {
      return this.b;
    }
    
    public long getFromTime()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasFromStation()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getFromStation());
      }
      int i1 = i2;
      if (hasToStation()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getToStation());
      }
      i2 = i1;
      if (hasTrainNumber()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getTrainNumber());
      }
      i1 = i2;
      if (hasFromTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(4, getFromTime());
      }
      i2 = i1;
      if (hasToTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(5, getToTime());
      }
      i1 = i2;
      if (hasDay()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(6, getDay());
      }
      i2 = i1;
      if (hasUseTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(7, getUseTime());
      }
      i1 = i2;
      if (hasFromCityName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getFromCityName());
      }
      i2 = i1;
      if (hasFromCityId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(9, getFromCityId());
      }
      i1 = i2;
      if (hasToCityName()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getToCityName());
      }
      i2 = i1;
      if (hasToCityId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getToCityId());
      }
      this.w = i2;
      return i2;
    }
    
    public String getToCityId()
    {
      return this.v;
    }
    
    public String getToCityName()
    {
      return this.t;
    }
    
    public String getToStation()
    {
      return this.d;
    }
    
    public long getToTime()
    {
      return this.j;
    }
    
    public String getTrainNumber()
    {
      return this.f;
    }
    
    public int getUseTime()
    {
      return this.n;
    }
    
    public boolean hasDay()
    {
      return this.k;
    }
    
    public boolean hasFromCityId()
    {
      return this.q;
    }
    
    public boolean hasFromCityName()
    {
      return this.o;
    }
    
    public boolean hasFromStation()
    {
      return this.a;
    }
    
    public boolean hasFromTime()
    {
      return this.g;
    }
    
    public boolean hasToCityId()
    {
      return this.u;
    }
    
    public boolean hasToCityName()
    {
      return this.s;
    }
    
    public boolean hasToStation()
    {
      return this.c;
    }
    
    public boolean hasToTime()
    {
      return this.i;
    }
    
    public boolean hasTrainNumber()
    {
      return this.e;
    }
    
    public boolean hasUseTime()
    {
      return this.m;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public TrainList mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setFromStation(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setToStation(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTrainNumber(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setFromTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 40: 
          setToTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 48: 
          setDay(paramCodedInputStreamMicro.readInt32());
          break;
        case 56: 
          setUseTime(paramCodedInputStreamMicro.readInt32());
          break;
        case 66: 
          setFromCityName(paramCodedInputStreamMicro.readString());
          break;
        case 74: 
          setFromCityId(paramCodedInputStreamMicro.readString());
          break;
        case 82: 
          setToCityName(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setToCityId(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public TrainList setDay(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public TrainList setFromCityId(String paramString)
    {
      this.q = true;
      this.r = paramString;
      return this;
    }
    
    public TrainList setFromCityName(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public TrainList setFromStation(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public TrainList setFromTime(long paramLong)
    {
      this.g = true;
      this.h = paramLong;
      return this;
    }
    
    public TrainList setToCityId(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public TrainList setToCityName(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public TrainList setToStation(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public TrainList setToTime(long paramLong)
    {
      this.i = true;
      this.j = paramLong;
      return this;
    }
    
    public TrainList setTrainNumber(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public TrainList setUseTime(int paramInt)
    {
      this.m = true;
      this.n = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasFromStation()) {
        paramCodedOutputStreamMicro.writeString(1, getFromStation());
      }
      if (hasToStation()) {
        paramCodedOutputStreamMicro.writeString(2, getToStation());
      }
      if (hasTrainNumber()) {
        paramCodedOutputStreamMicro.writeString(3, getTrainNumber());
      }
      if (hasFromTime()) {
        paramCodedOutputStreamMicro.writeInt64(4, getFromTime());
      }
      if (hasToTime()) {
        paramCodedOutputStreamMicro.writeInt64(5, getToTime());
      }
      if (hasDay()) {
        paramCodedOutputStreamMicro.writeInt32(6, getDay());
      }
      if (hasUseTime()) {
        paramCodedOutputStreamMicro.writeInt32(7, getUseTime());
      }
      if (hasFromCityName()) {
        paramCodedOutputStreamMicro.writeString(8, getFromCityName());
      }
      if (hasFromCityId()) {
        paramCodedOutputStreamMicro.writeString(9, getFromCityId());
      }
      if (hasToCityName()) {
        paramCodedOutputStreamMicro.writeString(10, getToCityName());
      }
      if (hasToCityId()) {
        paramCodedOutputStreamMicro.writeString(11, getToCityId());
      }
    }
  }
  
  public static final class TrainStopData
    extends MessageMicro
  {
    public static final int ARRIVE_TIME_FIELD_NUMBER = 5;
    public static final int ARR_CONTENT_FIELD_NUMBER = 13;
    public static final int DEP_CONTENT_FIELD_NUMBER = 14;
    public static final int IS_ARR_LOC_FIELD_NUMBER = 12;
    public static final int IS_CUR_LOC_FIELD_NUMBER = 10;
    public static final int IS_DEP_LOC_FIELD_NUMBER = 11;
    public static final int IS_SHOW_FIELD_NUMBER = 9;
    public static final int KM_FIELD_NUMBER = 8;
    public static final int START_TIME_FIELD_NUMBER = 4;
    public static final int STATION_ID_FIELD_NUMBER = 1;
    public static final int STATION_NAME_FIELD_NUMBER = 3;
    public static final int STATION_NO_FIELD_NUMBER = 2;
    public static final int STOP_TIME_FIELD_NUMBER = 6;
    public static final int SUB_TRAIN_NUM_FIELD_NUMBER = 7;
    private boolean A;
    private String B = "";
    private int C = -1;
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
    private int r = 0;
    private boolean s;
    private String t = "";
    private boolean u;
    private String v = "";
    private boolean w;
    private String x = "";
    private boolean y;
    private String z = "";
    
    public static TrainStopData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TrainStopData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TrainStopData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TrainStopData)new TrainStopData().mergeFrom(paramArrayOfByte);
    }
    
    public final TrainStopData clear()
    {
      clearStationId();
      clearStationNo();
      clearStationName();
      clearStartTime();
      clearArriveTime();
      clearStopTime();
      clearSubTrainNum();
      clearKm();
      clearIsShow();
      clearIsCurLoc();
      clearIsDepLoc();
      clearIsArrLoc();
      clearArrContent();
      clearDepContent();
      this.C = -1;
      return this;
    }
    
    public TrainStopData clearArrContent()
    {
      this.y = false;
      this.z = "";
      return this;
    }
    
    public TrainStopData clearArriveTime()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public TrainStopData clearDepContent()
    {
      this.A = false;
      this.B = "";
      return this;
    }
    
    public TrainStopData clearIsArrLoc()
    {
      this.w = false;
      this.x = "";
      return this;
    }
    
    public TrainStopData clearIsCurLoc()
    {
      this.s = false;
      this.t = "";
      return this;
    }
    
    public TrainStopData clearIsDepLoc()
    {
      this.u = false;
      this.v = "";
      return this;
    }
    
    public TrainStopData clearIsShow()
    {
      this.q = false;
      this.r = 0;
      return this;
    }
    
    public TrainStopData clearKm()
    {
      this.o = false;
      this.p = "";
      return this;
    }
    
    public TrainStopData clearStartTime()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public TrainStopData clearStationId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public TrainStopData clearStationName()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public TrainStopData clearStationNo()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public TrainStopData clearStopTime()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public TrainStopData clearSubTrainNum()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public String getArrContent()
    {
      return this.z;
    }
    
    public String getArriveTime()
    {
      return this.j;
    }
    
    public int getCachedSize()
    {
      if (this.C < 0) {
        getSerializedSize();
      }
      return this.C;
    }
    
    public String getDepContent()
    {
      return this.B;
    }
    
    public String getIsArrLoc()
    {
      return this.x;
    }
    
    public String getIsCurLoc()
    {
      return this.t;
    }
    
    public String getIsDepLoc()
    {
      return this.v;
    }
    
    public int getIsShow()
    {
      return this.r;
    }
    
    public String getKm()
    {
      return this.p;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasStationId()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getStationId());
      }
      int i1 = i2;
      if (hasStationNo()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getStationNo());
      }
      i2 = i1;
      if (hasStationName()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getStationName());
      }
      i1 = i2;
      if (hasStartTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(4, getStartTime());
      }
      i2 = i1;
      if (hasArriveTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(5, getArriveTime());
      }
      i1 = i2;
      if (hasStopTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(6, getStopTime());
      }
      i2 = i1;
      if (hasSubTrainNum()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getSubTrainNum());
      }
      i1 = i2;
      if (hasKm()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(8, getKm());
      }
      i2 = i1;
      if (hasIsShow()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(9, getIsShow());
      }
      i1 = i2;
      if (hasIsCurLoc()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(10, getIsCurLoc());
      }
      i2 = i1;
      if (hasIsDepLoc()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(11, getIsDepLoc());
      }
      i1 = i2;
      if (hasIsArrLoc()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(12, getIsArrLoc());
      }
      i2 = i1;
      if (hasArrContent()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(13, getArrContent());
      }
      i1 = i2;
      if (hasDepContent()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(14, getDepContent());
      }
      this.C = i1;
      return i1;
    }
    
    public String getStartTime()
    {
      return this.h;
    }
    
    public String getStationId()
    {
      return this.b;
    }
    
    public String getStationName()
    {
      return this.f;
    }
    
    public String getStationNo()
    {
      return this.d;
    }
    
    public String getStopTime()
    {
      return this.l;
    }
    
    public String getSubTrainNum()
    {
      return this.n;
    }
    
    public boolean hasArrContent()
    {
      return this.y;
    }
    
    public boolean hasArriveTime()
    {
      return this.i;
    }
    
    public boolean hasDepContent()
    {
      return this.A;
    }
    
    public boolean hasIsArrLoc()
    {
      return this.w;
    }
    
    public boolean hasIsCurLoc()
    {
      return this.s;
    }
    
    public boolean hasIsDepLoc()
    {
      return this.u;
    }
    
    public boolean hasIsShow()
    {
      return this.q;
    }
    
    public boolean hasKm()
    {
      return this.o;
    }
    
    public boolean hasStartTime()
    {
      return this.g;
    }
    
    public boolean hasStationId()
    {
      return this.a;
    }
    
    public boolean hasStationName()
    {
      return this.e;
    }
    
    public boolean hasStationNo()
    {
      return this.c;
    }
    
    public boolean hasStopTime()
    {
      return this.k;
    }
    
    public boolean hasSubTrainNum()
    {
      return this.m;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public TrainStopData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setStationId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setStationNo(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setStationName(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setStartTime(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setArriveTime(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setStopTime(paramCodedInputStreamMicro.readString());
          break;
        case 58: 
          setSubTrainNum(paramCodedInputStreamMicro.readString());
          break;
        case 66: 
          setKm(paramCodedInputStreamMicro.readString());
          break;
        case 72: 
          setIsShow(paramCodedInputStreamMicro.readInt32());
          break;
        case 82: 
          setIsCurLoc(paramCodedInputStreamMicro.readString());
          break;
        case 90: 
          setIsDepLoc(paramCodedInputStreamMicro.readString());
          break;
        case 98: 
          setIsArrLoc(paramCodedInputStreamMicro.readString());
          break;
        case 106: 
          setArrContent(paramCodedInputStreamMicro.readString());
          break;
        case 114: 
          setDepContent(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public TrainStopData setArrContent(String paramString)
    {
      this.y = true;
      this.z = paramString;
      return this;
    }
    
    public TrainStopData setArriveTime(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public TrainStopData setDepContent(String paramString)
    {
      this.A = true;
      this.B = paramString;
      return this;
    }
    
    public TrainStopData setIsArrLoc(String paramString)
    {
      this.w = true;
      this.x = paramString;
      return this;
    }
    
    public TrainStopData setIsCurLoc(String paramString)
    {
      this.s = true;
      this.t = paramString;
      return this;
    }
    
    public TrainStopData setIsDepLoc(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public TrainStopData setIsShow(int paramInt)
    {
      this.q = true;
      this.r = paramInt;
      return this;
    }
    
    public TrainStopData setKm(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public TrainStopData setStartTime(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public TrainStopData setStationId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public TrainStopData setStationName(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public TrainStopData setStationNo(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public TrainStopData setStopTime(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public TrainStopData setSubTrainNum(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasStationId()) {
        paramCodedOutputStreamMicro.writeString(1, getStationId());
      }
      if (hasStationNo()) {
        paramCodedOutputStreamMicro.writeString(2, getStationNo());
      }
      if (hasStationName()) {
        paramCodedOutputStreamMicro.writeString(3, getStationName());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeString(4, getStartTime());
      }
      if (hasArriveTime()) {
        paramCodedOutputStreamMicro.writeString(5, getArriveTime());
      }
      if (hasStopTime()) {
        paramCodedOutputStreamMicro.writeString(6, getStopTime());
      }
      if (hasSubTrainNum()) {
        paramCodedOutputStreamMicro.writeString(7, getSubTrainNum());
      }
      if (hasKm()) {
        paramCodedOutputStreamMicro.writeString(8, getKm());
      }
      if (hasIsShow()) {
        paramCodedOutputStreamMicro.writeInt32(9, getIsShow());
      }
      if (hasIsCurLoc()) {
        paramCodedOutputStreamMicro.writeString(10, getIsCurLoc());
      }
      if (hasIsDepLoc()) {
        paramCodedOutputStreamMicro.writeString(11, getIsDepLoc());
      }
      if (hasIsArrLoc()) {
        paramCodedOutputStreamMicro.writeString(12, getIsArrLoc());
      }
      if (hasArrContent()) {
        paramCodedOutputStreamMicro.writeString(13, getArrContent());
      }
      if (hasDepContent()) {
        paramCodedOutputStreamMicro.writeString(14, getDepContent());
      }
    }
  }
  
  public static final class Transport
    extends MessageMicro
  {
    public static final int SMS_PHONE_FIELD_NUMBER = 6;
    public static final int TRANSPORT_ICON_FIELD_NUMBER = 1;
    public static final int TRANSPORT_LINK_FIELD_NUMBER = 4;
    public static final int TRANSPORT_TEXT_FIELD_NUMBER = 2;
    public static final int TRANSPORT_TIME_FIELD_NUMBER = 3;
    public static final int TRANSPORT_TYPE_FIELD_NUMBER = 5;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private int j = 0;
    private boolean k;
    private String l = "";
    private int m = -1;
    
    public static Transport parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Transport().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Transport parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Transport)new Transport().mergeFrom(paramArrayOfByte);
    }
    
    public final Transport clear()
    {
      clearTransportIcon();
      clearTransportText();
      clearTransportTime();
      clearTransportLink();
      clearTransportType();
      clearSmsPhone();
      this.m = -1;
      return this;
    }
    
    public Transport clearSmsPhone()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public Transport clearTransportIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Transport clearTransportLink()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public Transport clearTransportText()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Transport clearTransportTime()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Transport clearTransportType()
    {
      this.i = false;
      this.j = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasTransportIcon()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTransportIcon());
      }
      int n = i1;
      if (hasTransportText()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getTransportText());
      }
      i1 = n;
      if (hasTransportTime()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getTransportTime());
      }
      n = i1;
      if (hasTransportLink()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getTransportLink());
      }
      i1 = n;
      if (hasTransportType()) {
        i1 = n + CodedOutputStreamMicro.computeInt32Size(5, getTransportType());
      }
      n = i1;
      if (hasSmsPhone()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getSmsPhone());
      }
      this.m = n;
      return n;
    }
    
    public String getSmsPhone()
    {
      return this.l;
    }
    
    public String getTransportIcon()
    {
      return this.b;
    }
    
    public String getTransportLink()
    {
      return this.h;
    }
    
    public String getTransportText()
    {
      return this.d;
    }
    
    public String getTransportTime()
    {
      return this.f;
    }
    
    public int getTransportType()
    {
      return this.j;
    }
    
    public boolean hasSmsPhone()
    {
      return this.k;
    }
    
    public boolean hasTransportIcon()
    {
      return this.a;
    }
    
    public boolean hasTransportLink()
    {
      return this.g;
    }
    
    public boolean hasTransportText()
    {
      return this.c;
    }
    
    public boolean hasTransportTime()
    {
      return this.e;
    }
    
    public boolean hasTransportType()
    {
      return this.i;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Transport mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTransportIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTransportText(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTransportTime(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setTransportLink(paramCodedInputStreamMicro.readString());
          break;
        case 40: 
          setTransportType(paramCodedInputStreamMicro.readInt32());
          break;
        case 50: 
          setSmsPhone(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public Transport setSmsPhone(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public Transport setTransportIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Transport setTransportLink(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public Transport setTransportText(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Transport setTransportTime(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Transport setTransportType(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTransportIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getTransportIcon());
      }
      if (hasTransportText()) {
        paramCodedOutputStreamMicro.writeString(2, getTransportText());
      }
      if (hasTransportTime()) {
        paramCodedOutputStreamMicro.writeString(3, getTransportTime());
      }
      if (hasTransportLink()) {
        paramCodedOutputStreamMicro.writeString(4, getTransportLink());
      }
      if (hasTransportType()) {
        paramCodedOutputStreamMicro.writeInt32(5, getTransportType());
      }
      if (hasSmsPhone()) {
        paramCodedOutputStreamMicro.writeString(6, getSmsPhone());
      }
    }
  }
  
  public static final class TripCardInfo
    extends MessageMicro
  {
    public static final int CARD_ARRAY_FIELD_NUMBER = 3;
    public static final int CARD_INFO_FIELD_NUMBER = 2;
    public static final int CONTROL_INFO_FIELD_NUMBER = 1;
    private boolean a;
    private TaResponse.ControlInfo b = null;
    private boolean c;
    private TaResponse.CardInfo d = null;
    private List<TaResponse.CardInfo> e = Collections.emptyList();
    private int f = -1;
    
    public static TripCardInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TripCardInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TripCardInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TripCardInfo)new TripCardInfo().mergeFrom(paramArrayOfByte);
    }
    
    public TripCardInfo addCardArray(TaResponse.CardInfo paramCardInfo)
    {
      if (paramCardInfo == null) {
        return this;
      }
      if (this.e.isEmpty()) {
        this.e = new ArrayList();
      }
      this.e.add(paramCardInfo);
      return this;
    }
    
    public final TripCardInfo clear()
    {
      clearControlInfo();
      clearCardInfo();
      clearCardArray();
      this.f = -1;
      return this;
    }
    
    public TripCardInfo clearCardArray()
    {
      this.e = Collections.emptyList();
      return this;
    }
    
    public TripCardInfo clearCardInfo()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public TripCardInfo clearControlInfo()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.f < 0) {
        getSerializedSize();
      }
      return this.f;
    }
    
    public TaResponse.CardInfo getCardArray(int paramInt)
    {
      return (TaResponse.CardInfo)this.e.get(paramInt);
    }
    
    public int getCardArrayCount()
    {
      return this.e.size();
    }
    
    public List<TaResponse.CardInfo> getCardArrayList()
    {
      return this.e;
    }
    
    public TaResponse.CardInfo getCardInfo()
    {
      return this.d;
    }
    
    public TaResponse.ControlInfo getControlInfo()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasControlInfo()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getControlInfo());
      }
      int j = i;
      if (hasCardInfo()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getCardInfo());
      }
      Iterator localIterator = getCardArrayList().iterator();
      while (localIterator.hasNext()) {
        j = CodedOutputStreamMicro.computeMessageSize(3, (TaResponse.CardInfo)localIterator.next()) + j;
      }
      this.f = j;
      return j;
    }
    
    public boolean hasCardInfo()
    {
      return this.c;
    }
    
    public boolean hasControlInfo()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public TripCardInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new TaResponse.ControlInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setControlInfo((TaResponse.ControlInfo)localObject);
          break;
        case 18: 
          localObject = new TaResponse.CardInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setCardInfo((TaResponse.CardInfo)localObject);
          break;
        case 26: 
          localObject = new TaResponse.CardInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addCardArray((TaResponse.CardInfo)localObject);
        }
      }
    }
    
    public TripCardInfo setCardArray(int paramInt, TaResponse.CardInfo paramCardInfo)
    {
      if (paramCardInfo == null) {
        return this;
      }
      this.e.set(paramInt, paramCardInfo);
      return this;
    }
    
    public TripCardInfo setCardInfo(TaResponse.CardInfo paramCardInfo)
    {
      if (paramCardInfo == null) {
        return clearCardInfo();
      }
      this.c = true;
      this.d = paramCardInfo;
      return this;
    }
    
    public TripCardInfo setControlInfo(TaResponse.ControlInfo paramControlInfo)
    {
      if (paramControlInfo == null) {
        return clearControlInfo();
      }
      this.a = true;
      this.b = paramControlInfo;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasControlInfo()) {
        paramCodedOutputStreamMicro.writeMessage(1, getControlInfo());
      }
      if (hasCardInfo()) {
        paramCodedOutputStreamMicro.writeMessage(2, getCardInfo());
      }
      Iterator localIterator = getCardArrayList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(3, (TaResponse.CardInfo)localIterator.next());
      }
    }
  }
  
  public static final class TripExt
    extends MessageMicro
  {
    public static final int TRIP_EXT_ELEMS_FIELD_NUMBER = 1;
    private List<TaResponse.TripExtElem> a = Collections.emptyList();
    private int b = -1;
    
    public static TripExt parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TripExt().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TripExt parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TripExt)new TripExt().mergeFrom(paramArrayOfByte);
    }
    
    public TripExt addTripExtElems(TaResponse.TripExtElem paramTripExtElem)
    {
      if (paramTripExtElem == null) {
        return this;
      }
      if (this.a.isEmpty()) {
        this.a = new ArrayList();
      }
      this.a.add(paramTripExtElem);
      return this;
    }
    
    public final TripExt clear()
    {
      clearTripExtElems();
      this.b = -1;
      return this;
    }
    
    public TripExt clearTripExtElems()
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
    
    public int getSerializedSize()
    {
      Iterator localIterator = getTripExtElemsList().iterator();
      for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (TaResponse.TripExtElem)localIterator.next()) + i) {}
      this.b = i;
      return i;
    }
    
    public TaResponse.TripExtElem getTripExtElems(int paramInt)
    {
      return (TaResponse.TripExtElem)this.a.get(paramInt);
    }
    
    public int getTripExtElemsCount()
    {
      return this.a.size();
    }
    
    public List<TaResponse.TripExtElem> getTripExtElemsList()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public TripExt mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          TaResponse.TripExtElem localTripExtElem = new TaResponse.TripExtElem();
          paramCodedInputStreamMicro.readMessage(localTripExtElem);
          addTripExtElems(localTripExtElem);
        }
      }
    }
    
    public TripExt setTripExtElems(int paramInt, TaResponse.TripExtElem paramTripExtElem)
    {
      if (paramTripExtElem == null) {
        return this;
      }
      this.a.set(paramInt, paramTripExtElem);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      Iterator localIterator = getTripExtElemsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(1, (TaResponse.TripExtElem)localIterator.next());
      }
    }
  }
  
  public static final class TripExtElem
    extends MessageMicro
  {
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int SUBTITLE_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private int g = -1;
    
    public static TripExtElem parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new TripExtElem().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static TripExtElem parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (TripExtElem)new TripExtElem().mergeFrom(paramArrayOfByte);
    }
    
    public final TripExtElem clear()
    {
      clearIcon();
      clearTitle();
      clearSubtitle();
      this.g = -1;
      return this;
    }
    
    public TripExtElem clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public TripExtElem clearSubtitle()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public TripExtElem clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.g < 0) {
        getSerializedSize();
      }
      return this.g;
    }
    
    public String getIcon()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasIcon()) {
        j = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
      }
      int i = j;
      if (hasTitle()) {
        i = j + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      j = i;
      if (hasSubtitle()) {
        j = i + CodedOutputStreamMicro.computeStringSize(3, getSubtitle());
      }
      this.g = j;
      return j;
    }
    
    public String getSubtitle()
    {
      return this.f;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasSubtitle()
    {
      return this.e;
    }
    
    public boolean hasTitle()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public TripExtElem mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setSubtitle(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public TripExtElem setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public TripExtElem setSubtitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public TripExtElem setTitle(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasIcon()) {
        paramCodedOutputStreamMicro.writeString(1, getIcon());
      }
      if (hasTitle()) {
        paramCodedOutputStreamMicro.writeString(2, getTitle());
      }
      if (hasSubtitle()) {
        paramCodedOutputStreamMicro.writeString(3, getSubtitle());
      }
    }
  }
  
  public static final class UiData
    extends MessageMicro
  {
    public static final int DRIVER_PAGE_CARD_FIELD_NUMBER = 3;
    public static final int MAP_PAGE_BUBBLE_FIELD_NUMBER = 1;
    public static final int TRIP_PAGE_FIELD_NUMBER = 2;
    private boolean a;
    private TaResponse.TripCardInfo b = null;
    private boolean c;
    private TaResponse.TripCardInfo d = null;
    private boolean e;
    private TaResponse.DriverPageCardInfo f = null;
    private int g = -1;
    
    public static UiData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new UiData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static UiData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (UiData)new UiData().mergeFrom(paramArrayOfByte);
    }
    
    public final UiData clear()
    {
      clearMapPageBubble();
      clearTripPage();
      clearDriverPageCard();
      this.g = -1;
      return this;
    }
    
    public UiData clearDriverPageCard()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public UiData clearMapPageBubble()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public UiData clearTripPage()
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
    
    public TaResponse.DriverPageCardInfo getDriverPageCard()
    {
      return this.f;
    }
    
    public TaResponse.TripCardInfo getMapPageBubble()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasMapPageBubble()) {
        j = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMapPageBubble());
      }
      int i = j;
      if (hasTripPage()) {
        i = j + CodedOutputStreamMicro.computeMessageSize(2, getTripPage());
      }
      j = i;
      if (hasDriverPageCard()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(3, getDriverPageCard());
      }
      this.g = j;
      return j;
    }
    
    public TaResponse.TripCardInfo getTripPage()
    {
      return this.d;
    }
    
    public boolean hasDriverPageCard()
    {
      return this.e;
    }
    
    public boolean hasMapPageBubble()
    {
      return this.a;
    }
    
    public boolean hasTripPage()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public UiData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new TaResponse.TripCardInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setMapPageBubble((TaResponse.TripCardInfo)localObject);
          break;
        case 18: 
          localObject = new TaResponse.TripCardInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setTripPage((TaResponse.TripCardInfo)localObject);
          break;
        case 26: 
          localObject = new TaResponse.DriverPageCardInfo();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setDriverPageCard((TaResponse.DriverPageCardInfo)localObject);
        }
      }
    }
    
    public UiData setDriverPageCard(TaResponse.DriverPageCardInfo paramDriverPageCardInfo)
    {
      if (paramDriverPageCardInfo == null) {
        return clearDriverPageCard();
      }
      this.e = true;
      this.f = paramDriverPageCardInfo;
      return this;
    }
    
    public UiData setMapPageBubble(TaResponse.TripCardInfo paramTripCardInfo)
    {
      if (paramTripCardInfo == null) {
        return clearMapPageBubble();
      }
      this.a = true;
      this.b = paramTripCardInfo;
      return this;
    }
    
    public UiData setTripPage(TaResponse.TripCardInfo paramTripCardInfo)
    {
      if (paramTripCardInfo == null) {
        return clearTripPage();
      }
      this.c = true;
      this.d = paramTripCardInfo;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasMapPageBubble()) {
        paramCodedOutputStreamMicro.writeMessage(1, getMapPageBubble());
      }
      if (hasTripPage()) {
        paramCodedOutputStreamMicro.writeMessage(2, getTripPage());
      }
      if (hasDriverPageCard()) {
        paramCodedOutputStreamMicro.writeMessage(3, getDriverPageCard());
      }
    }
  }
  
  public static final class UpdateInfo
    extends MessageMicro
  {
    public static final int SUB_TRIP_ID_FIELD_NUMBER = 2;
    public static final int SUG_BLACK_ID_FIELD_NUMBER = 6;
    public static final int SUG_POINT_UID_FIELD_NUMBER = 5;
    public static final int TIPS_CONTENT_FIELD_NUMBER = 3;
    public static final int TIPS_TYPE_FIELD_NUMBER = 4;
    public static final int TRIP_ID_FIELD_NUMBER = 1;
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
    private String l = "";
    private int m = -1;
    
    public static UpdateInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new UpdateInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static UpdateInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (UpdateInfo)new UpdateInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final UpdateInfo clear()
    {
      clearTripId();
      clearSubTripId();
      clearTipsContent();
      clearTipsType();
      clearSugPointUid();
      clearSugBlackId();
      this.m = -1;
      return this;
    }
    
    public UpdateInfo clearSubTripId()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public UpdateInfo clearSugBlackId()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public UpdateInfo clearSugPointUid()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public UpdateInfo clearTipsContent()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public UpdateInfo clearTipsType()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public UpdateInfo clearTripId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasTripId()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getTripId());
      }
      int n = i1;
      if (hasSubTripId()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getSubTripId());
      }
      i1 = n;
      if (hasTipsContent()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getTipsContent());
      }
      n = i1;
      if (hasTipsType()) {
        n = i1 + CodedOutputStreamMicro.computeInt32Size(4, getTipsType());
      }
      i1 = n;
      if (hasSugPointUid()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getSugPointUid());
      }
      n = i1;
      if (hasSugBlackId()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getSugBlackId());
      }
      this.m = n;
      return n;
    }
    
    public String getSubTripId()
    {
      return this.d;
    }
    
    public String getSugBlackId()
    {
      return this.l;
    }
    
    public String getSugPointUid()
    {
      return this.j;
    }
    
    public String getTipsContent()
    {
      return this.f;
    }
    
    public int getTipsType()
    {
      return this.h;
    }
    
    public String getTripId()
    {
      return this.b;
    }
    
    public boolean hasSubTripId()
    {
      return this.c;
    }
    
    public boolean hasSugBlackId()
    {
      return this.k;
    }
    
    public boolean hasSugPointUid()
    {
      return this.i;
    }
    
    public boolean hasTipsContent()
    {
      return this.e;
    }
    
    public boolean hasTipsType()
    {
      return this.g;
    }
    
    public boolean hasTripId()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return this.a;
    }
    
    public UpdateInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTripId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setSubTripId(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setTipsContent(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setTipsType(paramCodedInputStreamMicro.readInt32());
          break;
        case 42: 
          setSugPointUid(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setSugBlackId(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public UpdateInfo setSubTripId(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public UpdateInfo setSugBlackId(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public UpdateInfo setSugPointUid(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public UpdateInfo setTipsContent(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public UpdateInfo setTipsType(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public UpdateInfo setTripId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTripId()) {
        paramCodedOutputStreamMicro.writeString(1, getTripId());
      }
      if (hasSubTripId()) {
        paramCodedOutputStreamMicro.writeString(2, getSubTripId());
      }
      if (hasTipsContent()) {
        paramCodedOutputStreamMicro.writeString(3, getTipsContent());
      }
      if (hasTipsType()) {
        paramCodedOutputStreamMicro.writeInt32(4, getTipsType());
      }
      if (hasSugPointUid()) {
        paramCodedOutputStreamMicro.writeString(5, getSugPointUid());
      }
      if (hasSugBlackId()) {
        paramCodedOutputStreamMicro.writeString(6, getSugBlackId());
      }
    }
  }
  
  public static final class UpdateRCInfo
    extends MessageMicro
  {
    public static final int ORDER_AUTO_REMIND_FIELD_NUMBER = 3;
    public static final int PUSH_REMIND_FIELD_NUMBER = 2;
    public static final int REMIND_TIME_FIELD_NUMBER = 4;
    public static final int SMS_PHONE_FIELD_NUMBER = 5;
    public static final int SMS_REMIND_FIELD_NUMBER = 1;
    private boolean a;
    private long b = 0L;
    private boolean c;
    private long d = 0L;
    private boolean e;
    private long f = 0L;
    private boolean g;
    private long h = 0L;
    private boolean i;
    private String j = "";
    private int k = -1;
    
    public static UpdateRCInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new UpdateRCInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static UpdateRCInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (UpdateRCInfo)new UpdateRCInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final UpdateRCInfo clear()
    {
      clearSmsRemind();
      clearPushRemind();
      clearOrderAutoRemind();
      clearRemindTime();
      clearSmsPhone();
      this.k = -1;
      return this;
    }
    
    public UpdateRCInfo clearOrderAutoRemind()
    {
      this.e = false;
      this.f = 0L;
      return this;
    }
    
    public UpdateRCInfo clearPushRemind()
    {
      this.c = false;
      this.d = 0L;
      return this;
    }
    
    public UpdateRCInfo clearRemindTime()
    {
      this.g = false;
      this.h = 0L;
      return this;
    }
    
    public UpdateRCInfo clearSmsPhone()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public UpdateRCInfo clearSmsRemind()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public long getOrderAutoRemind()
    {
      return this.f;
    }
    
    public long getPushRemind()
    {
      return this.d;
    }
    
    public long getRemindTime()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasSmsRemind()) {
        n = 0 + CodedOutputStreamMicro.computeInt64Size(1, getSmsRemind());
      }
      int m = n;
      if (hasPushRemind()) {
        m = n + CodedOutputStreamMicro.computeInt64Size(2, getPushRemind());
      }
      n = m;
      if (hasOrderAutoRemind()) {
        n = m + CodedOutputStreamMicro.computeInt64Size(3, getOrderAutoRemind());
      }
      m = n;
      if (hasRemindTime()) {
        m = n + CodedOutputStreamMicro.computeInt64Size(4, getRemindTime());
      }
      n = m;
      if (hasSmsPhone()) {
        n = m + CodedOutputStreamMicro.computeStringSize(5, getSmsPhone());
      }
      this.k = n;
      return n;
    }
    
    public String getSmsPhone()
    {
      return this.j;
    }
    
    public long getSmsRemind()
    {
      return this.b;
    }
    
    public boolean hasOrderAutoRemind()
    {
      return this.e;
    }
    
    public boolean hasPushRemind()
    {
      return this.c;
    }
    
    public boolean hasRemindTime()
    {
      return this.g;
    }
    
    public boolean hasSmsPhone()
    {
      return this.i;
    }
    
    public boolean hasSmsRemind()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g) || (!this.i)) {
        return false;
      }
      return true;
    }
    
    public UpdateRCInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        case 8: 
          setSmsRemind(paramCodedInputStreamMicro.readInt64());
          break;
        case 16: 
          setPushRemind(paramCodedInputStreamMicro.readInt64());
          break;
        case 24: 
          setOrderAutoRemind(paramCodedInputStreamMicro.readInt64());
          break;
        case 32: 
          setRemindTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 42: 
          setSmsPhone(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public UpdateRCInfo setOrderAutoRemind(long paramLong)
    {
      this.e = true;
      this.f = paramLong;
      return this;
    }
    
    public UpdateRCInfo setPushRemind(long paramLong)
    {
      this.c = true;
      this.d = paramLong;
      return this;
    }
    
    public UpdateRCInfo setRemindTime(long paramLong)
    {
      this.g = true;
      this.h = paramLong;
      return this;
    }
    
    public UpdateRCInfo setSmsPhone(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public UpdateRCInfo setSmsRemind(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasSmsRemind()) {
        paramCodedOutputStreamMicro.writeInt64(1, getSmsRemind());
      }
      if (hasPushRemind()) {
        paramCodedOutputStreamMicro.writeInt64(2, getPushRemind());
      }
      if (hasOrderAutoRemind()) {
        paramCodedOutputStreamMicro.writeInt64(3, getOrderAutoRemind());
      }
      if (hasRemindTime()) {
        paramCodedOutputStreamMicro.writeInt64(4, getRemindTime());
      }
      if (hasSmsPhone()) {
        paramCodedOutputStreamMicro.writeString(5, getSmsPhone());
      }
    }
  }
  
  public static final class UpdateRemindInfo
    extends MessageMicro
  {
    public static final int BDUID_FIELD_NUMBER = 2;
    public static final int TRIP_ID_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static UpdateRemindInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new UpdateRemindInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static UpdateRemindInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (UpdateRemindInfo)new UpdateRemindInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final UpdateRemindInfo clear()
    {
      clearTripId();
      clearBduid();
      this.e = -1;
      return this;
    }
    
    public UpdateRemindInfo clearBduid()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public UpdateRemindInfo clearTripId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public String getBduid()
    {
      return this.d;
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
      if (hasTripId()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTripId());
      }
      int j = i;
      if (hasBduid()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getBduid());
      }
      this.e = j;
      return j;
    }
    
    public String getTripId()
    {
      return this.b;
    }
    
    public boolean hasBduid()
    {
      return this.c;
    }
    
    public boolean hasTripId()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while (!this.c) {
        return false;
      }
      return true;
    }
    
    public UpdateRemindInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTripId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setBduid(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public UpdateRemindInfo setBduid(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public UpdateRemindInfo setTripId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTripId()) {
        paramCodedOutputStreamMicro.writeString(1, getTripId());
      }
      if (hasBduid()) {
        paramCodedOutputStreamMicro.writeString(2, getBduid());
      }
    }
  }
  
  public static final class VersionInfo
    extends MessageMicro
  {
    public static final int AIRPORT_DATA_VERSION_FIELD_NUMBER = 2;
    public static final int SMS_DATA_VERSION_FIELD_NUMBER = 3;
    public static final int TRAIN_CITYINFO_VERSION_FIELD_NUMBER = 1;
    private boolean a;
    private long b = 0L;
    private boolean c;
    private long d = 0L;
    private boolean e;
    private long f = 0L;
    private int g = -1;
    
    public static VersionInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new VersionInfo().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static VersionInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (VersionInfo)new VersionInfo().mergeFrom(paramArrayOfByte);
    }
    
    public final VersionInfo clear()
    {
      clearTrainCityinfoVersion();
      clearAirportDataVersion();
      clearSmsDataVersion();
      this.g = -1;
      return this;
    }
    
    public VersionInfo clearAirportDataVersion()
    {
      this.c = false;
      this.d = 0L;
      return this;
    }
    
    public VersionInfo clearSmsDataVersion()
    {
      this.e = false;
      this.f = 0L;
      return this;
    }
    
    public VersionInfo clearTrainCityinfoVersion()
    {
      this.a = false;
      this.b = 0L;
      return this;
    }
    
    public long getAirportDataVersion()
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
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasTrainCityinfoVersion()) {
        j = 0 + CodedOutputStreamMicro.computeInt64Size(1, getTrainCityinfoVersion());
      }
      int i = j;
      if (hasAirportDataVersion()) {
        i = j + CodedOutputStreamMicro.computeInt64Size(2, getAirportDataVersion());
      }
      j = i;
      if (hasSmsDataVersion()) {
        j = i + CodedOutputStreamMicro.computeInt64Size(3, getSmsDataVersion());
      }
      this.g = j;
      return j;
    }
    
    public long getSmsDataVersion()
    {
      return this.f;
    }
    
    public long getTrainCityinfoVersion()
    {
      return this.b;
    }
    
    public boolean hasAirportDataVersion()
    {
      return this.c;
    }
    
    public boolean hasSmsDataVersion()
    {
      return this.e;
    }
    
    public boolean hasTrainCityinfoVersion()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public VersionInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setTrainCityinfoVersion(paramCodedInputStreamMicro.readInt64());
          break;
        case 16: 
          setAirportDataVersion(paramCodedInputStreamMicro.readInt64());
          break;
        case 24: 
          setSmsDataVersion(paramCodedInputStreamMicro.readInt64());
        }
      }
    }
    
    public VersionInfo setAirportDataVersion(long paramLong)
    {
      this.c = true;
      this.d = paramLong;
      return this;
    }
    
    public VersionInfo setSmsDataVersion(long paramLong)
    {
      this.e = true;
      this.f = paramLong;
      return this;
    }
    
    public VersionInfo setTrainCityinfoVersion(long paramLong)
    {
      this.a = true;
      this.b = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasTrainCityinfoVersion()) {
        paramCodedOutputStreamMicro.writeInt64(1, getTrainCityinfoVersion());
      }
      if (hasAirportDataVersion()) {
        paramCodedOutputStreamMicro.writeInt64(2, getAirportDataVersion());
      }
      if (hasSmsDataVersion()) {
        paramCodedOutputStreamMicro.writeInt64(3, getSmsDataVersion());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/TaResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */