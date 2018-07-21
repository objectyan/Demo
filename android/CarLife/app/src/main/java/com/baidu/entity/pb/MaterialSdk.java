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

public final class MaterialSdk
  extends MessageMicro
{
  public static final int DATA_CONTENT_FIELD_NUMBER = 2;
  public static final int DATA_RESULT_FIELD_NUMBER = 1;
  private boolean a;
  private MaterialResult b = null;
  private boolean c;
  private MaterialContent d = null;
  private int e = -1;
  
  public static MaterialSdk parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new MaterialSdk().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static MaterialSdk parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (MaterialSdk)new MaterialSdk().mergeFrom(paramArrayOfByte);
  }
  
  public final MaterialSdk clear()
  {
    clearDataResult();
    clearDataContent();
    this.e = -1;
    return this;
  }
  
  public MaterialSdk clearDataContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public MaterialSdk clearDataResult()
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
  
  public MaterialContent getDataContent()
  {
    return this.d;
  }
  
  public MaterialResult getDataResult()
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
  
  public MaterialSdk mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new MaterialResult();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setDataResult((MaterialResult)localObject);
        break;
      case 18: 
        localObject = new MaterialContent();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setDataContent((MaterialContent)localObject);
      }
    }
  }
  
  public MaterialSdk setDataContent(MaterialContent paramMaterialContent)
  {
    if (paramMaterialContent == null) {
      return clearDataContent();
    }
    this.c = true;
    this.d = paramMaterialContent;
    return this;
  }
  
  public MaterialSdk setDataResult(MaterialResult paramMaterialResult)
  {
    if (paramMaterialResult == null) {
      return clearDataResult();
    }
    this.a = true;
    this.b = paramMaterialResult;
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
  
  public static final class Basic
    extends MessageMicro
  {
    public static final int DATA_TYPE_FIELD_NUMBER = 2;
    public static final int VER_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private int e = -1;
    
    public static Basic parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Basic().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Basic parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Basic)new Basic().mergeFrom(paramArrayOfByte);
    }
    
    public final Basic clear()
    {
      clearVer();
      clearDataType();
      this.e = -1;
      return this;
    }
    
    public Basic clearDataType()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public Basic clearVer()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public int getCachedSize()
    {
      if (this.e < 0) {
        getSerializedSize();
      }
      return this.e;
    }
    
    public int getDataType()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasVer()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getVer());
      }
      int j = i;
      if (hasDataType()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(2, getDataType());
      }
      this.e = j;
      return j;
    }
    
    public int getVer()
    {
      return this.b;
    }
    
    public boolean hasDataType()
    {
      return this.c;
    }
    
    public boolean hasVer()
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
    
    public Basic mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setVer(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setDataType(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Basic setDataType(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public Basic setVer(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasVer()) {
        paramCodedOutputStreamMicro.writeInt32(1, getVer());
      }
      if (hasDataType()) {
        paramCodedOutputStreamMicro.writeInt32(2, getDataType());
      }
    }
  }
  
  public static final class Material
    extends MessageMicro
  {
    public static final int ACTION_FIELD_NUMBER = 8;
    public static final int CONTAINER_ID_FIELD_NUMBER = 1;
    public static final int CONTENT_FIELD_NUMBER = 7;
    public static final int END_TIME_FIELD_NUMBER = 6;
    public static final int GF_LATITUDE_FIELD_NUMBER = 10;
    public static final int GF_LONGITUDE_FIELD_NUMBER = 9;
    public static final int GF_RADIUS_FIELD_NUMBER = 11;
    public static final int MATERIAL_ID_FIELD_NUMBER = 3;
    public static final int PKG_ID_FIELD_NUMBER = 2;
    public static final int PRIORITY_FIELD_NUMBER = 4;
    public static final int START_TIME_FIELD_NUMBER = 5;
    private boolean a;
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
    private long l = 0L;
    private boolean m;
    private String n = "";
    private boolean o;
    private int p = 0;
    private boolean q;
    private double r = 0.0D;
    private boolean s;
    private double t = 0.0D;
    private boolean u;
    private int v = 0;
    private int w = -1;
    
    public static Material parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Material().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Material parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Material)new Material().mergeFrom(paramArrayOfByte);
    }
    
    public final Material clear()
    {
      clearContainerId();
      clearPkgId();
      clearMaterialId();
      clearPriority();
      clearStartTime();
      clearEndTime();
      clearContent();
      clearAction();
      clearGfLongitude();
      clearGfLatitude();
      clearGfRadius();
      this.w = -1;
      return this;
    }
    
    public Material clearAction()
    {
      this.o = false;
      this.p = 0;
      return this;
    }
    
    public Material clearContainerId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public Material clearContent()
    {
      this.m = false;
      this.n = "";
      return this;
    }
    
    public Material clearEndTime()
    {
      this.k = false;
      this.l = 0L;
      return this;
    }
    
    public Material clearGfLatitude()
    {
      this.s = false;
      this.t = 0.0D;
      return this;
    }
    
    public Material clearGfLongitude()
    {
      this.q = false;
      this.r = 0.0D;
      return this;
    }
    
    public Material clearGfRadius()
    {
      this.u = false;
      this.v = 0;
      return this;
    }
    
    public Material clearMaterialId()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public Material clearPkgId()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Material clearPriority()
    {
      this.g = false;
      this.h = 0;
      return this;
    }
    
    public Material clearStartTime()
    {
      this.i = false;
      this.j = 0L;
      return this;
    }
    
    public int getAction()
    {
      return this.p;
    }
    
    public int getCachedSize()
    {
      if (this.w < 0) {
        getSerializedSize();
      }
      return this.w;
    }
    
    public String getContainerId()
    {
      return this.b;
    }
    
    public String getContent()
    {
      return this.n;
    }
    
    public long getEndTime()
    {
      return this.l;
    }
    
    public double getGfLatitude()
    {
      return this.t;
    }
    
    public double getGfLongitude()
    {
      return this.r;
    }
    
    public int getGfRadius()
    {
      return this.v;
    }
    
    public String getMaterialId()
    {
      return this.f;
    }
    
    public String getPkgId()
    {
      return this.d;
    }
    
    public int getPriority()
    {
      return this.h;
    }
    
    public int getSerializedSize()
    {
      int i2 = 0;
      if (hasContainerId()) {
        i2 = 0 + CodedOutputStreamMicro.computeStringSize(1, getContainerId());
      }
      int i1 = i2;
      if (hasPkgId()) {
        i1 = i2 + CodedOutputStreamMicro.computeStringSize(2, getPkgId());
      }
      i2 = i1;
      if (hasMaterialId()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(3, getMaterialId());
      }
      i1 = i2;
      if (hasPriority()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(4, getPriority());
      }
      i2 = i1;
      if (hasStartTime()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt64Size(5, getStartTime());
      }
      i1 = i2;
      if (hasEndTime()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt64Size(6, getEndTime());
      }
      i2 = i1;
      if (hasContent()) {
        i2 = i1 + CodedOutputStreamMicro.computeStringSize(7, getContent());
      }
      i1 = i2;
      if (hasAction()) {
        i1 = i2 + CodedOutputStreamMicro.computeInt32Size(8, getAction());
      }
      i2 = i1;
      if (hasGfLongitude()) {
        i2 = i1 + CodedOutputStreamMicro.computeDoubleSize(9, getGfLongitude());
      }
      i1 = i2;
      if (hasGfLatitude()) {
        i1 = i2 + CodedOutputStreamMicro.computeDoubleSize(10, getGfLatitude());
      }
      i2 = i1;
      if (hasGfRadius()) {
        i2 = i1 + CodedOutputStreamMicro.computeInt32Size(11, getGfRadius());
      }
      this.w = i2;
      return i2;
    }
    
    public long getStartTime()
    {
      return this.j;
    }
    
    public boolean hasAction()
    {
      return this.o;
    }
    
    public boolean hasContainerId()
    {
      return this.a;
    }
    
    public boolean hasContent()
    {
      return this.m;
    }
    
    public boolean hasEndTime()
    {
      return this.k;
    }
    
    public boolean hasGfLatitude()
    {
      return this.s;
    }
    
    public boolean hasGfLongitude()
    {
      return this.q;
    }
    
    public boolean hasGfRadius()
    {
      return this.u;
    }
    
    public boolean hasMaterialId()
    {
      return this.e;
    }
    
    public boolean hasPkgId()
    {
      return this.c;
    }
    
    public boolean hasPriority()
    {
      return this.g;
    }
    
    public boolean hasStartTime()
    {
      return this.i;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g) || (!this.i) || (!this.k) || (!this.m)) {
        return false;
      }
      return true;
    }
    
    public Material mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setContainerId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setPkgId(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setMaterialId(paramCodedInputStreamMicro.readString());
          break;
        case 32: 
          setPriority(paramCodedInputStreamMicro.readInt32());
          break;
        case 40: 
          setStartTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 48: 
          setEndTime(paramCodedInputStreamMicro.readInt64());
          break;
        case 58: 
          setContent(paramCodedInputStreamMicro.readString());
          break;
        case 64: 
          setAction(paramCodedInputStreamMicro.readInt32());
          break;
        case 73: 
          setGfLongitude(paramCodedInputStreamMicro.readDouble());
          break;
        case 81: 
          setGfLatitude(paramCodedInputStreamMicro.readDouble());
          break;
        case 88: 
          setGfRadius(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Material setAction(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public Material setContainerId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public Material setContent(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public Material setEndTime(long paramLong)
    {
      this.k = true;
      this.l = paramLong;
      return this;
    }
    
    public Material setGfLatitude(double paramDouble)
    {
      this.s = true;
      this.t = paramDouble;
      return this;
    }
    
    public Material setGfLongitude(double paramDouble)
    {
      this.q = true;
      this.r = paramDouble;
      return this;
    }
    
    public Material setGfRadius(int paramInt)
    {
      this.u = true;
      this.v = paramInt;
      return this;
    }
    
    public Material setMaterialId(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public Material setPkgId(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Material setPriority(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public Material setStartTime(long paramLong)
    {
      this.i = true;
      this.j = paramLong;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasContainerId()) {
        paramCodedOutputStreamMicro.writeString(1, getContainerId());
      }
      if (hasPkgId()) {
        paramCodedOutputStreamMicro.writeString(2, getPkgId());
      }
      if (hasMaterialId()) {
        paramCodedOutputStreamMicro.writeString(3, getMaterialId());
      }
      if (hasPriority()) {
        paramCodedOutputStreamMicro.writeInt32(4, getPriority());
      }
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeInt64(5, getStartTime());
      }
      if (hasEndTime()) {
        paramCodedOutputStreamMicro.writeInt64(6, getEndTime());
      }
      if (hasContent()) {
        paramCodedOutputStreamMicro.writeString(7, getContent());
      }
      if (hasAction()) {
        paramCodedOutputStreamMicro.writeInt32(8, getAction());
      }
      if (hasGfLongitude()) {
        paramCodedOutputStreamMicro.writeDouble(9, getGfLongitude());
      }
      if (hasGfLatitude()) {
        paramCodedOutputStreamMicro.writeDouble(10, getGfLatitude());
      }
      if (hasGfRadius()) {
        paramCodedOutputStreamMicro.writeInt32(11, getGfRadius());
      }
    }
  }
  
  public static final class MaterialContent
    extends MessageMicro
  {
    public static final int BASIC_FIELD_NUMBER = 1;
    public static final int LIST_FIELD_NUMBER = 2;
    private boolean a;
    private MaterialSdk.Basic b = null;
    private List<MaterialSdk.Material> c = Collections.emptyList();
    private int d = -1;
    
    public static MaterialContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MaterialContent().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MaterialContent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MaterialContent)new MaterialContent().mergeFrom(paramArrayOfByte);
    }
    
    public MaterialContent addList(MaterialSdk.Material paramMaterial)
    {
      if (paramMaterial == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramMaterial);
      return this;
    }
    
    public final MaterialContent clear()
    {
      clearBasic();
      clearList();
      this.d = -1;
      return this;
    }
    
    public MaterialContent clearBasic()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public MaterialContent clearList()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public MaterialSdk.Basic getBasic()
    {
      return this.b;
    }
    
    public int getCachedSize()
    {
      if (this.d < 0) {
        getSerializedSize();
      }
      return this.d;
    }
    
    public MaterialSdk.Material getList(int paramInt)
    {
      return (MaterialSdk.Material)this.c.get(paramInt);
    }
    
    public int getListCount()
    {
      return this.c.size();
    }
    
    public List<MaterialSdk.Material> getListList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasBasic()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getBasic());
      }
      Iterator localIterator = getListList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (MaterialSdk.Material)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasBasic()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {
        return false;
      }
      if (!getBasic().isInitialized()) {
        return false;
      }
      Iterator localIterator = getListList().iterator();
      while (localIterator.hasNext()) {
        if (!((MaterialSdk.Material)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public MaterialContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new MaterialSdk.Basic();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setBasic((MaterialSdk.Basic)localObject);
          break;
        case 18: 
          localObject = new MaterialSdk.Material();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          addList((MaterialSdk.Material)localObject);
        }
      }
    }
    
    public MaterialContent setBasic(MaterialSdk.Basic paramBasic)
    {
      if (paramBasic == null) {
        return clearBasic();
      }
      this.a = true;
      this.b = paramBasic;
      return this;
    }
    
    public MaterialContent setList(int paramInt, MaterialSdk.Material paramMaterial)
    {
      if (paramMaterial == null) {
        return this;
      }
      this.c.set(paramInt, paramMaterial);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasBasic()) {
        paramCodedOutputStreamMicro.writeMessage(1, getBasic());
      }
      Iterator localIterator = getListList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (MaterialSdk.Material)localIterator.next());
      }
    }
  }
  
  public static final class MaterialResult
    extends MessageMicro
  {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static MaterialResult parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MaterialResult().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MaterialResult parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MaterialResult)new MaterialResult().mergeFrom(paramArrayOfByte);
    }
    
    public final MaterialResult clear()
    {
      clearError();
      clearMsg();
      this.e = -1;
      return this;
    }
    
    public MaterialResult clearError()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public MaterialResult clearMsg()
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
    
    public MaterialResult mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
    
    public MaterialResult setError(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public MaterialResult setMsg(String paramString)
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
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/MaterialSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */