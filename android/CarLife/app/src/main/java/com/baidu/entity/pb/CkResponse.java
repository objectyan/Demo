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

public final class CkResponse
  extends MessageMicro
{
  public static final int DATA_CONTENT_FIELD_NUMBER = 2;
  public static final int DATA_RESULT_FIELD_NUMBER = 1;
  private boolean a;
  private CKResult b = null;
  private boolean c;
  private CKContent d = null;
  private int e = -1;
  
  public static CkResponse parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new CkResponse().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static CkResponse parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (CkResponse)new CkResponse().mergeFrom(paramArrayOfByte);
  }
  
  public final CkResponse clear()
  {
    clearDataResult();
    clearDataContent();
    this.e = -1;
    return this;
  }
  
  public CkResponse clearDataContent()
  {
    this.c = false;
    this.d = null;
    return this;
  }
  
  public CkResponse clearDataResult()
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
  
  public CKContent getDataContent()
  {
    return this.d;
  }
  
  public CKResult getDataResult()
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
  
  public CkResponse mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new CKResult();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setDataResult((CKResult)localObject);
        break;
      case 18: 
        localObject = new CKContent();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setDataContent((CKContent)localObject);
      }
    }
  }
  
  public CkResponse setDataContent(CKContent paramCKContent)
  {
    if (paramCKContent == null) {
      return clearDataContent();
    }
    this.c = true;
    this.d = paramCKContent;
    return this;
  }
  
  public CkResponse setDataResult(CKResult paramCKResult)
  {
    if (paramCKResult == null) {
      return clearDataResult();
    }
    this.a = true;
    this.b = paramCKResult;
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
  
  public static final class ADData
    extends MessageMicro
  {
    public static final int AD_ID_FIELD_NUMBER = 1;
    public static final int MATERIALS_FIELD_NUMBER = 2;
    private boolean a;
    private String b = "";
    private List<CkResponse.MaterialData> c = Collections.emptyList();
    private int d = -1;
    
    public static ADData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ADData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ADData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ADData)new ADData().mergeFrom(paramArrayOfByte);
    }
    
    public ADData addMaterials(CkResponse.MaterialData paramMaterialData)
    {
      if (paramMaterialData == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramMaterialData);
      return this;
    }
    
    public final ADData clear()
    {
      clearAdId();
      clearMaterials();
      this.d = -1;
      return this;
    }
    
    public ADData clearAdId()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public ADData clearMaterials()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public String getAdId()
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
    
    public CkResponse.MaterialData getMaterials(int paramInt)
    {
      return (CkResponse.MaterialData)this.c.get(paramInt);
    }
    
    public int getMaterialsCount()
    {
      return this.c.size();
    }
    
    public List<CkResponse.MaterialData> getMaterialsList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasAdId()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAdId());
      }
      Iterator localIterator = getMaterialsList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (CkResponse.MaterialData)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public boolean hasAdId()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {
        return false;
      }
      Iterator localIterator = getMaterialsList().iterator();
      while (localIterator.hasNext()) {
        if (!((CkResponse.MaterialData)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public ADData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setAdId(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          CkResponse.MaterialData localMaterialData = new CkResponse.MaterialData();
          paramCodedInputStreamMicro.readMessage(localMaterialData);
          addMaterials(localMaterialData);
        }
      }
    }
    
    public ADData setAdId(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public ADData setMaterials(int paramInt, CkResponse.MaterialData paramMaterialData)
    {
      if (paramMaterialData == null) {
        return this;
      }
      this.c.set(paramInt, paramMaterialData);
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAdId()) {
        paramCodedOutputStreamMicro.writeString(1, getAdId());
      }
      Iterator localIterator = getMaterialsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (CkResponse.MaterialData)localIterator.next());
      }
    }
  }
  
  public static final class ActionData
    extends MessageMicro
  {
    public static final int ACTION_BACKUP_FIELD_NUMBER = 1;
    public static final int ACTION_NONET_FIELD_NUMBER = 2;
    public static final int ACTION_SCHEME_FIELD_NUMBER = 3;
    public static final int ACTION_TYPE_FIELD_NUMBER = 4;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static ActionData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ActionData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ActionData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ActionData)new ActionData().mergeFrom(paramArrayOfByte);
    }
    
    public final ActionData clear()
    {
      clearActionBackup();
      clearActionNonet();
      clearActionScheme();
      clearActionType();
      this.i = -1;
      return this;
    }
    
    public ActionData clearActionBackup()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public ActionData clearActionNonet()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public ActionData clearActionScheme()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public ActionData clearActionType()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public String getActionBackup()
    {
      return this.b;
    }
    
    public String getActionNonet()
    {
      return this.d;
    }
    
    public String getActionScheme()
    {
      return this.f;
    }
    
    public String getActionType()
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
      if (hasActionBackup()) {
        k = 0 + CodedOutputStreamMicro.computeStringSize(1, getActionBackup());
      }
      int j = k;
      if (hasActionNonet()) {
        j = k + CodedOutputStreamMicro.computeStringSize(2, getActionNonet());
      }
      k = j;
      if (hasActionScheme()) {
        k = j + CodedOutputStreamMicro.computeStringSize(3, getActionScheme());
      }
      j = k;
      if (hasActionType()) {
        j = k + CodedOutputStreamMicro.computeStringSize(4, getActionType());
      }
      this.i = j;
      return j;
    }
    
    public boolean hasActionBackup()
    {
      return this.a;
    }
    
    public boolean hasActionNonet()
    {
      return this.c;
    }
    
    public boolean hasActionScheme()
    {
      return this.e;
    }
    
    public boolean hasActionType()
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
    
    public ActionData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setActionBackup(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setActionNonet(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setActionScheme(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setActionType(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ActionData setActionBackup(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public ActionData setActionNonet(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public ActionData setActionScheme(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public ActionData setActionType(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasActionBackup()) {
        paramCodedOutputStreamMicro.writeString(1, getActionBackup());
      }
      if (hasActionNonet()) {
        paramCodedOutputStreamMicro.writeString(2, getActionNonet());
      }
      if (hasActionScheme()) {
        paramCodedOutputStreamMicro.writeString(3, getActionScheme());
      }
      if (hasActionType()) {
        paramCodedOutputStreamMicro.writeString(4, getActionType());
      }
    }
  }
  
  public static final class CKContent
    extends MessageMicro
  {
    public static final int DATA_FIELD_NUMBER = 2;
    public static final int DATA_TYPE_FIELD_NUMBER = 1;
    private boolean a;
    private int b = 0;
    private boolean c;
    private CkResponse.CKContentData d = null;
    private int e = -1;
    
    public static CKContent parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CKContent().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CKContent parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CKContent)new CKContent().mergeFrom(paramArrayOfByte);
    }
    
    public final CKContent clear()
    {
      clearDataType();
      clearData();
      this.e = -1;
      return this;
    }
    
    public CKContent clearData()
    {
      this.c = false;
      this.d = null;
      return this;
    }
    
    public CKContent clearDataType()
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
    
    public CkResponse.CKContentData getData()
    {
      return this.d;
    }
    
    public int getDataType()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasDataType()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDataType());
      }
      int j = i;
      if (hasData()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getData());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasData()
    {
      return this.c;
    }
    
    public boolean hasDataType()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!getData().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public CKContent mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setDataType(paramCodedInputStreamMicro.readInt32());
          break;
        case 18: 
          CkResponse.CKContentData localCKContentData = new CkResponse.CKContentData();
          paramCodedInputStreamMicro.readMessage(localCKContentData);
          setData(localCKContentData);
        }
      }
    }
    
    public CKContent setData(CkResponse.CKContentData paramCKContentData)
    {
      if (paramCKContentData == null) {
        return clearData();
      }
      this.c = true;
      this.d = paramCKContentData;
      return this;
    }
    
    public CKContent setDataType(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasDataType()) {
        paramCodedOutputStreamMicro.writeInt32(1, getDataType());
      }
      if (hasData()) {
        paramCodedOutputStreamMicro.writeMessage(2, getData());
      }
    }
  }
  
  public static final class CKContentData
    extends MessageMicro
  {
    public static final int ADS_FIELD_NUMBER = 2;
    public static final int VER_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<CkResponse.ADData> c = Collections.emptyList();
    private int d = -1;
    
    public static CKContentData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CKContentData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CKContentData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CKContentData)new CKContentData().mergeFrom(paramArrayOfByte);
    }
    
    public CKContentData addAds(CkResponse.ADData paramADData)
    {
      if (paramADData == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramADData);
      return this;
    }
    
    public final CKContentData clear()
    {
      clearVer();
      clearAds();
      this.d = -1;
      return this;
    }
    
    public CKContentData clearAds()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public CKContentData clearVer()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public CkResponse.ADData getAds(int paramInt)
    {
      return (CkResponse.ADData)this.c.get(paramInt);
    }
    
    public int getAdsCount()
    {
      return this.c.size();
    }
    
    public List<CkResponse.ADData> getAdsList()
    {
      return this.c;
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
      int i = 0;
      if (hasVer()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getVer());
      }
      Iterator localIterator = getAdsList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (CkResponse.ADData)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public String getVer()
    {
      return this.b;
    }
    
    public boolean hasVer()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {
        return false;
      }
      Iterator localIterator = getAdsList().iterator();
      while (localIterator.hasNext()) {
        if (!((CkResponse.ADData)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public CKContentData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setVer(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          CkResponse.ADData localADData = new CkResponse.ADData();
          paramCodedInputStreamMicro.readMessage(localADData);
          addAds(localADData);
        }
      }
    }
    
    public CKContentData setAds(int paramInt, CkResponse.ADData paramADData)
    {
      if (paramADData == null) {
        return this;
      }
      this.c.set(paramInt, paramADData);
      return this;
    }
    
    public CKContentData setVer(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasVer()) {
        paramCodedOutputStreamMicro.writeString(1, getVer());
      }
      Iterator localIterator = getAdsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (CkResponse.ADData)localIterator.next());
      }
    }
  }
  
  public static final class CKResult
    extends MessageMicro
  {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static CKResult parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new CKResult().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static CKResult parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (CKResult)new CKResult().mergeFrom(paramArrayOfByte);
    }
    
    public final CKResult clear()
    {
      clearError();
      clearMsg();
      this.e = -1;
      return this;
    }
    
    public CKResult clearError()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public CKResult clearMsg()
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
    
    public CKResult mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
    
    public CKResult setError(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public CKResult setMsg(String paramString)
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
  
  public static final class MaterialData
    extends MessageMicro
  {
    public static final int ACTION_FIELD_NUMBER = 3;
    public static final int MATERIAL_ID_FIELD_NUMBER = 1;
    public static final int PRIORITY_FIELD_NUMBER = 2;
    public static final int RULE_FIELD_NUMBER = 5;
    public static final int SHOW_RES_FIELD_NUMBER = 4;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private CkResponse.ActionData f = null;
    private boolean g;
    private CkResponse.ResData h = null;
    private boolean i;
    private CkResponse.RuleData j = null;
    private int k = -1;
    
    public static MaterialData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new MaterialData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static MaterialData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (MaterialData)new MaterialData().mergeFrom(paramArrayOfByte);
    }
    
    public final MaterialData clear()
    {
      clearMaterialId();
      clearPriority();
      clearAction();
      clearShowRes();
      clearRule();
      this.k = -1;
      return this;
    }
    
    public MaterialData clearAction()
    {
      this.e = false;
      this.f = null;
      return this;
    }
    
    public MaterialData clearMaterialId()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public MaterialData clearPriority()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public MaterialData clearRule()
    {
      this.i = false;
      this.j = null;
      return this;
    }
    
    public MaterialData clearShowRes()
    {
      this.g = false;
      this.h = null;
      return this;
    }
    
    public CkResponse.ActionData getAction()
    {
      return this.f;
    }
    
    public int getCachedSize()
    {
      if (this.k < 0) {
        getSerializedSize();
      }
      return this.k;
    }
    
    public int getMaterialId()
    {
      return this.b;
    }
    
    public int getPriority()
    {
      return this.d;
    }
    
    public CkResponse.RuleData getRule()
    {
      return this.j;
    }
    
    public int getSerializedSize()
    {
      int n = 0;
      if (hasMaterialId()) {
        n = 0 + CodedOutputStreamMicro.computeInt32Size(1, getMaterialId());
      }
      int m = n;
      if (hasPriority()) {
        m = n + CodedOutputStreamMicro.computeInt32Size(2, getPriority());
      }
      n = m;
      if (hasAction()) {
        n = m + CodedOutputStreamMicro.computeMessageSize(3, getAction());
      }
      m = n;
      if (hasShowRes()) {
        m = n + CodedOutputStreamMicro.computeMessageSize(4, getShowRes());
      }
      n = m;
      if (hasRule()) {
        n = m + CodedOutputStreamMicro.computeMessageSize(5, getRule());
      }
      this.k = n;
      return n;
    }
    
    public CkResponse.ResData getShowRes()
    {
      return this.h;
    }
    
    public boolean hasAction()
    {
      return this.e;
    }
    
    public boolean hasMaterialId()
    {
      return this.a;
    }
    
    public boolean hasPriority()
    {
      return this.c;
    }
    
    public boolean hasRule()
    {
      return this.i;
    }
    
    public boolean hasShowRes()
    {
      return this.g;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e) || (!this.g) || (!this.i) || (!getAction().isInitialized()) || (!getRule().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public MaterialData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        case 8: 
          setMaterialId(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setPriority(paramCodedInputStreamMicro.readInt32());
          break;
        case 26: 
          localObject = new CkResponse.ActionData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setAction((CkResponse.ActionData)localObject);
          break;
        case 34: 
          localObject = new CkResponse.ResData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setShowRes((CkResponse.ResData)localObject);
          break;
        case 42: 
          localObject = new CkResponse.RuleData();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setRule((CkResponse.RuleData)localObject);
        }
      }
    }
    
    public MaterialData setAction(CkResponse.ActionData paramActionData)
    {
      if (paramActionData == null) {
        return clearAction();
      }
      this.e = true;
      this.f = paramActionData;
      return this;
    }
    
    public MaterialData setMaterialId(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public MaterialData setPriority(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public MaterialData setRule(CkResponse.RuleData paramRuleData)
    {
      if (paramRuleData == null) {
        return clearRule();
      }
      this.i = true;
      this.j = paramRuleData;
      return this;
    }
    
    public MaterialData setShowRes(CkResponse.ResData paramResData)
    {
      if (paramResData == null) {
        return clearShowRes();
      }
      this.g = true;
      this.h = paramResData;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasMaterialId()) {
        paramCodedOutputStreamMicro.writeInt32(1, getMaterialId());
      }
      if (hasPriority()) {
        paramCodedOutputStreamMicro.writeInt32(2, getPriority());
      }
      if (hasAction()) {
        paramCodedOutputStreamMicro.writeMessage(3, getAction());
      }
      if (hasShowRes()) {
        paramCodedOutputStreamMicro.writeMessage(4, getShowRes());
      }
      if (hasRule()) {
        paramCodedOutputStreamMicro.writeMessage(5, getRule());
      }
    }
  }
  
  public static final class ResData
    extends MessageMicro
  {
    public static final int ACTIVITY_CONTENT_FIELD_NUMBER = 4;
    public static final int ICON_FIELD_NUMBER = 1;
    public static final int IMG_FIELD_NUMBER = 5;
    public static final int SHOW_TIME_FIELD_NUMBER = 6;
    public static final int SUB_TITLE_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 2;
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
    
    public static ResData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new ResData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static ResData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (ResData)new ResData().mergeFrom(paramArrayOfByte);
    }
    
    public final ResData clear()
    {
      clearIcon();
      clearTitle();
      clearSubTitle();
      clearActivityContent();
      clearImg();
      clearShowTime();
      this.m = -1;
      return this;
    }
    
    public ResData clearActivityContent()
    {
      this.g = false;
      this.h = "";
      return this;
    }
    
    public ResData clearIcon()
    {
      this.a = false;
      this.b = "";
      return this;
    }
    
    public ResData clearImg()
    {
      this.i = false;
      this.j = "";
      return this;
    }
    
    public ResData clearShowTime()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public ResData clearSubTitle()
    {
      this.e = false;
      this.f = "";
      return this;
    }
    
    public ResData clearTitle()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public String getActivityContent()
    {
      return this.h;
    }
    
    public int getCachedSize()
    {
      if (this.m < 0) {
        getSerializedSize();
      }
      return this.m;
    }
    
    public String getIcon()
    {
      return this.b;
    }
    
    public String getImg()
    {
      return this.j;
    }
    
    public int getSerializedSize()
    {
      int i1 = 0;
      if (hasIcon()) {
        i1 = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
      }
      int n = i1;
      if (hasTitle()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(2, getTitle());
      }
      i1 = n;
      if (hasSubTitle()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(3, getSubTitle());
      }
      n = i1;
      if (hasActivityContent()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(4, getActivityContent());
      }
      i1 = n;
      if (hasImg()) {
        i1 = n + CodedOutputStreamMicro.computeStringSize(5, getImg());
      }
      n = i1;
      if (hasShowTime()) {
        n = i1 + CodedOutputStreamMicro.computeStringSize(6, getShowTime());
      }
      this.m = n;
      return n;
    }
    
    public String getShowTime()
    {
      return this.l;
    }
    
    public String getSubTitle()
    {
      return this.f;
    }
    
    public String getTitle()
    {
      return this.d;
    }
    
    public boolean hasActivityContent()
    {
      return this.g;
    }
    
    public boolean hasIcon()
    {
      return this.a;
    }
    
    public boolean hasImg()
    {
      return this.i;
    }
    
    public boolean hasShowTime()
    {
      return this.k;
    }
    
    public boolean hasSubTitle()
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
    
    public ResData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setIcon(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setTitle(paramCodedInputStreamMicro.readString());
          break;
        case 26: 
          setSubTitle(paramCodedInputStreamMicro.readString());
          break;
        case 34: 
          setActivityContent(paramCodedInputStreamMicro.readString());
          break;
        case 42: 
          setImg(paramCodedInputStreamMicro.readString());
          break;
        case 50: 
          setShowTime(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public ResData setActivityContent(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public ResData setIcon(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public ResData setImg(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public ResData setShowTime(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public ResData setSubTitle(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public ResData setTitle(String paramString)
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
      if (hasSubTitle()) {
        paramCodedOutputStreamMicro.writeString(3, getSubTitle());
      }
      if (hasActivityContent()) {
        paramCodedOutputStreamMicro.writeString(4, getActivityContent());
      }
      if (hasImg()) {
        paramCodedOutputStreamMicro.writeString(5, getImg());
      }
      if (hasShowTime()) {
        paramCodedOutputStreamMicro.writeString(6, getShowTime());
      }
    }
  }
  
  public static final class RuleData
    extends MessageMicro
  {
    public static final int DISAPPEAR_FIELD_NUMBER = 1;
    public static final int EXPIRE_FIELD_NUMBER = 2;
    private boolean a;
    private CkResponse.RuleDisappear b = null;
    private boolean c;
    private CkResponse.RuleExpire d = null;
    private int e = -1;
    
    public static RuleData parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new RuleData().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static RuleData parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (RuleData)new RuleData().mergeFrom(paramArrayOfByte);
    }
    
    public final RuleData clear()
    {
      clearDisappear();
      clearExpire();
      this.e = -1;
      return this;
    }
    
    public RuleData clearDisappear()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public RuleData clearExpire()
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
    
    public CkResponse.RuleDisappear getDisappear()
    {
      return this.b;
    }
    
    public CkResponse.RuleExpire getExpire()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasDisappear()) {
        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDisappear());
      }
      int j = i;
      if (hasExpire()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getExpire());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasDisappear()
    {
      return this.a;
    }
    
    public boolean hasExpire()
    {
      return this.c;
    }
    
    public final boolean isInitialized()
    {
      if ((hasDisappear()) && (!getDisappear().isInitialized())) {}
      while ((hasExpire()) && (!getExpire().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public RuleData mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          localObject = new CkResponse.RuleDisappear();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setDisappear((CkResponse.RuleDisappear)localObject);
          break;
        case 18: 
          localObject = new CkResponse.RuleExpire();
          paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
          setExpire((CkResponse.RuleExpire)localObject);
        }
      }
    }
    
    public RuleData setDisappear(CkResponse.RuleDisappear paramRuleDisappear)
    {
      if (paramRuleDisappear == null) {
        return clearDisappear();
      }
      this.a = true;
      this.b = paramRuleDisappear;
      return this;
    }
    
    public RuleData setExpire(CkResponse.RuleExpire paramRuleExpire)
    {
      if (paramRuleExpire == null) {
        return clearExpire();
      }
      this.c = true;
      this.d = paramRuleExpire;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasDisappear()) {
        paramCodedOutputStreamMicro.writeMessage(1, getDisappear());
      }
      if (hasExpire()) {
        paramCodedOutputStreamMicro.writeMessage(2, getExpire());
      }
    }
  }
  
  public static final class RuleDisappear
    extends MessageMicro
  {
    public static final int CLICK_NUM_FIELD_NUMBER = 2;
    public static final int PERIOD_FIELD_NUMBER = 1;
    public static final int SHOW_NUM_FIELD_NUMBER = 3;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private int g = -1;
    
    public static RuleDisappear parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new RuleDisappear().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static RuleDisappear parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (RuleDisappear)new RuleDisappear().mergeFrom(paramArrayOfByte);
    }
    
    public final RuleDisappear clear()
    {
      clearPeriod();
      clearClickNum();
      clearShowNum();
      this.g = -1;
      return this;
    }
    
    public RuleDisappear clearClickNum()
    {
      this.c = false;
      this.d = 0;
      return this;
    }
    
    public RuleDisappear clearPeriod()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public RuleDisappear clearShowNum()
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
    
    public int getClickNum()
    {
      return this.d;
    }
    
    public int getPeriod()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int j = 0;
      if (hasPeriod()) {
        j = 0 + CodedOutputStreamMicro.computeInt32Size(1, getPeriod());
      }
      int i = j;
      if (hasClickNum()) {
        i = j + CodedOutputStreamMicro.computeInt32Size(2, getClickNum());
      }
      j = i;
      if (hasShowNum()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(3, getShowNum());
      }
      this.g = j;
      return j;
    }
    
    public int getShowNum()
    {
      return this.f;
    }
    
    public boolean hasClickNum()
    {
      return this.c;
    }
    
    public boolean hasPeriod()
    {
      return this.a;
    }
    
    public boolean hasShowNum()
    {
      return this.e;
    }
    
    public final boolean isInitialized()
    {
      if (!this.a) {}
      while ((!this.c) || (!this.e)) {
        return false;
      }
      return true;
    }
    
    public RuleDisappear mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setPeriod(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setClickNum(paramCodedInputStreamMicro.readInt32());
          break;
        case 24: 
          setShowNum(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public RuleDisappear setClickNum(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public RuleDisappear setPeriod(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public RuleDisappear setShowNum(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasPeriod()) {
        paramCodedOutputStreamMicro.writeInt32(1, getPeriod());
      }
      if (hasClickNum()) {
        paramCodedOutputStreamMicro.writeInt32(2, getClickNum());
      }
      if (hasShowNum()) {
        paramCodedOutputStreamMicro.writeInt32(3, getShowNum());
      }
    }
  }
  
  public static final class RuleExpire
    extends MessageMicro
  {
    public static final int END_TIME_FIELD_NUMBER = 2;
    public static final int START_TIME_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static RuleExpire parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new RuleExpire().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static RuleExpire parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (RuleExpire)new RuleExpire().mergeFrom(paramArrayOfByte);
    }
    
    public final RuleExpire clear()
    {
      clearStartTime();
      clearEndTime();
      this.e = -1;
      return this;
    }
    
    public RuleExpire clearEndTime()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public RuleExpire clearStartTime()
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
    
    public String getEndTime()
    {
      return this.d;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasStartTime()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStartTime());
      }
      int j = i;
      if (hasEndTime()) {
        j = i + CodedOutputStreamMicro.computeStringSize(2, getEndTime());
      }
      this.e = j;
      return j;
    }
    
    public String getStartTime()
    {
      return this.b;
    }
    
    public boolean hasEndTime()
    {
      return this.c;
    }
    
    public boolean hasStartTime()
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
    
    public RuleExpire mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setStartTime(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          setEndTime(paramCodedInputStreamMicro.readString());
        }
      }
    }
    
    public RuleExpire setEndTime(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public RuleExpire setStartTime(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasStartTime()) {
        paramCodedOutputStreamMicro.writeString(1, getStartTime());
      }
      if (hasEndTime()) {
        paramCodedOutputStreamMicro.writeString(2, getEndTime());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/CkResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */