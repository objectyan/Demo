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

public final class FavoriteInfo
  extends MessageMicro
{
  public static final int DATA_FIELD_NUMBER = 3;
  public static final int ERROR_FIELD_NUMBER = 1;
  public static final int MSG_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private boolean c;
  private String d = "";
  private List<Data> e = Collections.emptyList();
  private int f = -1;
  
  public static FavoriteInfo parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new FavoriteInfo().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static FavoriteInfo parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (FavoriteInfo)new FavoriteInfo().mergeFrom(paramArrayOfByte);
  }
  
  public FavoriteInfo addData(Data paramData)
  {
    if (paramData == null) {
      return this;
    }
    if (this.e.isEmpty()) {
      this.e = new ArrayList();
    }
    this.e.add(paramData);
    return this;
  }
  
  public final FavoriteInfo clear()
  {
    clearError();
    clearMsg();
    clearData();
    this.f = -1;
    return this;
  }
  
  public FavoriteInfo clearData()
  {
    this.e = Collections.emptyList();
    return this;
  }
  
  public FavoriteInfo clearError()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public FavoriteInfo clearMsg()
  {
    this.c = false;
    this.d = "";
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.f < 0) {
      getSerializedSize();
    }
    return this.f;
  }
  
  public Data getData(int paramInt)
  {
    return (Data)this.e.get(paramInt);
  }
  
  public int getDataCount()
  {
    return this.e.size();
  }
  
  public List<Data> getDataList()
  {
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
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      j = CodedOutputStreamMicro.computeMessageSize(3, (Data)localIterator.next()) + j;
    }
    this.f = j;
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
    return true;
  }
  
  public FavoriteInfo mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        break;
      case 26: 
        Data localData = new Data();
        paramCodedInputStreamMicro.readMessage(localData);
        addData(localData);
      }
    }
  }
  
  public FavoriteInfo setData(int paramInt, Data paramData)
  {
    if (paramData == null) {
      return this;
    }
    this.e.set(paramInt, paramData);
    return this;
  }
  
  public FavoriteInfo setError(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public FavoriteInfo setMsg(String paramString)
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
    Iterator localIterator = getDataList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(3, (Data)localIterator.next());
    }
  }
  
  public static final class Data
    extends MessageMicro
  {
    public static final int DETAILS_FIELD_NUMBER = 2;
    public static final int SUBKEY_FIELD_NUMBER = 1;
    private boolean a;
    private String b = "";
    private List<Details> c = Collections.emptyList();
    private int d = -1;
    
    public static Data parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
      throws IOException
    {
      return new Data().mergeFrom(paramCodedInputStreamMicro);
    }
    
    public static Data parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferMicroException
    {
      return (Data)new Data().mergeFrom(paramArrayOfByte);
    }
    
    public Data addDetails(Details paramDetails)
    {
      if (paramDetails == null) {
        return this;
      }
      if (this.c.isEmpty()) {
        this.c = new ArrayList();
      }
      this.c.add(paramDetails);
      return this;
    }
    
    public final Data clear()
    {
      clearSubkey();
      clearDetails();
      this.d = -1;
      return this;
    }
    
    public Data clearDetails()
    {
      this.c = Collections.emptyList();
      return this;
    }
    
    public Data clearSubkey()
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
    
    public Details getDetails(int paramInt)
    {
      return (Details)this.c.get(paramInt);
    }
    
    public int getDetailsCount()
    {
      return this.c.size();
    }
    
    public List<Details> getDetailsList()
    {
      return this.c;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasSubkey()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSubkey());
      }
      Iterator localIterator = getDetailsList().iterator();
      while (localIterator.hasNext()) {
        i = CodedOutputStreamMicro.computeMessageSize(2, (Details)localIterator.next()) + i;
      }
      this.d = i;
      return i;
    }
    
    public String getSubkey()
    {
      return this.b;
    }
    
    public boolean hasSubkey()
    {
      return this.a;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
    
    public Data mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
          setSubkey(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          Details localDetails = new Details();
          paramCodedInputStreamMicro.readMessage(localDetails);
          addDetails(localDetails);
        }
      }
    }
    
    public Data setDetails(int paramInt, Details paramDetails)
    {
      if (paramDetails == null) {
        return this;
      }
      this.c.set(paramInt, paramDetails);
      return this;
    }
    
    public Data setSubkey(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasSubkey()) {
        paramCodedOutputStreamMicro.writeString(1, getSubkey());
      }
      Iterator localIterator = getDetailsList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStreamMicro.writeMessage(2, (Details)localIterator.next());
      }
    }
    
    public static final class Details
      extends MessageMicro
    {
      public static final int CTIME_FIELD_NUMBER = 4;
      public static final int DO_COUNT_FIELD_NUMBER = 3;
      public static final int IF_DO_FIELD_NUMBER = 2;
      public static final int THEME_ID_FIELD_NUMBER = 1;
      public static final int ZHIDAHAO_FOLLOW_FIELD_NUMBER = 5;
      private boolean a;
      private String b = "";
      private boolean c;
      private String d = "";
      private boolean e;
      private String f = "";
      private boolean g;
      private String h = "";
      private boolean i;
      private ZhidahaoFollow j = null;
      private int k = -1;
      
      public static Details parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new Details().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static Details parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (Details)new Details().mergeFrom(paramArrayOfByte);
      }
      
      public final Details clear()
      {
        clearThemeId();
        clearIfDo();
        clearDoCount();
        clearCtime();
        clearZhidahaoFollow();
        this.k = -1;
        return this;
      }
      
      public Details clearCtime()
      {
        this.g = false;
        this.h = "";
        return this;
      }
      
      public Details clearDoCount()
      {
        this.e = false;
        this.f = "";
        return this;
      }
      
      public Details clearIfDo()
      {
        this.c = false;
        this.d = "";
        return this;
      }
      
      public Details clearThemeId()
      {
        this.a = false;
        this.b = "";
        return this;
      }
      
      public Details clearZhidahaoFollow()
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
      
      public String getCtime()
      {
        return this.h;
      }
      
      public String getDoCount()
      {
        return this.f;
      }
      
      public String getIfDo()
      {
        return this.d;
      }
      
      public int getSerializedSize()
      {
        int n = 0;
        if (hasThemeId()) {
          n = 0 + CodedOutputStreamMicro.computeStringSize(1, getThemeId());
        }
        int m = n;
        if (hasIfDo()) {
          m = n + CodedOutputStreamMicro.computeStringSize(2, getIfDo());
        }
        n = m;
        if (hasDoCount()) {
          n = m + CodedOutputStreamMicro.computeStringSize(3, getDoCount());
        }
        m = n;
        if (hasCtime()) {
          m = n + CodedOutputStreamMicro.computeStringSize(4, getCtime());
        }
        n = m;
        if (hasZhidahaoFollow()) {
          n = m + CodedOutputStreamMicro.computeMessageSize(5, getZhidahaoFollow());
        }
        this.k = n;
        return n;
      }
      
      public String getThemeId()
      {
        return this.b;
      }
      
      public ZhidahaoFollow getZhidahaoFollow()
      {
        return this.j;
      }
      
      public boolean hasCtime()
      {
        return this.g;
      }
      
      public boolean hasDoCount()
      {
        return this.e;
      }
      
      public boolean hasIfDo()
      {
        return this.c;
      }
      
      public boolean hasThemeId()
      {
        return this.a;
      }
      
      public boolean hasZhidahaoFollow()
      {
        return this.i;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Details mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            setThemeId(paramCodedInputStreamMicro.readString());
            break;
          case 18: 
            setIfDo(paramCodedInputStreamMicro.readString());
            break;
          case 26: 
            setDoCount(paramCodedInputStreamMicro.readString());
            break;
          case 34: 
            setCtime(paramCodedInputStreamMicro.readString());
            break;
          case 42: 
            ZhidahaoFollow localZhidahaoFollow = new ZhidahaoFollow();
            paramCodedInputStreamMicro.readMessage(localZhidahaoFollow);
            setZhidahaoFollow(localZhidahaoFollow);
          }
        }
      }
      
      public Details setCtime(String paramString)
      {
        this.g = true;
        this.h = paramString;
        return this;
      }
      
      public Details setDoCount(String paramString)
      {
        this.e = true;
        this.f = paramString;
        return this;
      }
      
      public Details setIfDo(String paramString)
      {
        this.c = true;
        this.d = paramString;
        return this;
      }
      
      public Details setThemeId(String paramString)
      {
        this.a = true;
        this.b = paramString;
        return this;
      }
      
      public Details setZhidahaoFollow(ZhidahaoFollow paramZhidahaoFollow)
      {
        if (paramZhidahaoFollow == null) {
          return clearZhidahaoFollow();
        }
        this.i = true;
        this.j = paramZhidahaoFollow;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasThemeId()) {
          paramCodedOutputStreamMicro.writeString(1, getThemeId());
        }
        if (hasIfDo()) {
          paramCodedOutputStreamMicro.writeString(2, getIfDo());
        }
        if (hasDoCount()) {
          paramCodedOutputStreamMicro.writeString(3, getDoCount());
        }
        if (hasCtime()) {
          paramCodedOutputStreamMicro.writeString(4, getCtime());
        }
        if (hasZhidahaoFollow()) {
          paramCodedOutputStreamMicro.writeMessage(5, getZhidahaoFollow());
        }
      }
      
      public static final class ZhidahaoFollow
        extends MessageMicro
      {
        public static final int LOGO_URL_FIELD_NUMBER = 3;
        public static final int MSGDATA_FIELD_NUMBER = 5;
        public static final int NEWNUM_FIELD_NUMBER = 4;
        public static final int SCREEN_NAME_FIELD_NUMBER = 2;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private boolean e;
        private int f = 0;
        private List<Msgdata> g = Collections.emptyList();
        private int h = -1;
        
        public static ZhidahaoFollow parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new ZhidahaoFollow().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static ZhidahaoFollow parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (ZhidahaoFollow)new ZhidahaoFollow().mergeFrom(paramArrayOfByte);
        }
        
        public ZhidahaoFollow addMsgdata(Msgdata paramMsgdata)
        {
          if (paramMsgdata == null) {
            return this;
          }
          if (this.g.isEmpty()) {
            this.g = new ArrayList();
          }
          this.g.add(paramMsgdata);
          return this;
        }
        
        public final ZhidahaoFollow clear()
        {
          clearScreenName();
          clearLogoUrl();
          clearNewnum();
          clearMsgdata();
          this.h = -1;
          return this;
        }
        
        public ZhidahaoFollow clearLogoUrl()
        {
          this.c = false;
          this.d = "";
          return this;
        }
        
        public ZhidahaoFollow clearMsgdata()
        {
          this.g = Collections.emptyList();
          return this;
        }
        
        public ZhidahaoFollow clearNewnum()
        {
          this.e = false;
          this.f = 0;
          return this;
        }
        
        public ZhidahaoFollow clearScreenName()
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
        
        public String getLogoUrl()
        {
          return this.d;
        }
        
        public Msgdata getMsgdata(int paramInt)
        {
          return (Msgdata)this.g.get(paramInt);
        }
        
        public int getMsgdataCount()
        {
          return this.g.size();
        }
        
        public List<Msgdata> getMsgdataList()
        {
          return this.g;
        }
        
        public int getNewnum()
        {
          return this.f;
        }
        
        public String getScreenName()
        {
          return this.b;
        }
        
        public int getSerializedSize()
        {
          int j = 0;
          if (hasScreenName()) {
            j = 0 + CodedOutputStreamMicro.computeStringSize(2, getScreenName());
          }
          int i = j;
          if (hasLogoUrl()) {
            i = j + CodedOutputStreamMicro.computeStringSize(3, getLogoUrl());
          }
          j = i;
          if (hasNewnum()) {
            j = i + CodedOutputStreamMicro.computeInt32Size(4, getNewnum());
          }
          Iterator localIterator = getMsgdataList().iterator();
          while (localIterator.hasNext()) {
            j = CodedOutputStreamMicro.computeMessageSize(5, (Msgdata)localIterator.next()) + j;
          }
          this.h = j;
          return j;
        }
        
        public boolean hasLogoUrl()
        {
          return this.c;
        }
        
        public boolean hasNewnum()
        {
          return this.e;
        }
        
        public boolean hasScreenName()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public ZhidahaoFollow mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            case 18: 
              setScreenName(paramCodedInputStreamMicro.readString());
              break;
            case 26: 
              setLogoUrl(paramCodedInputStreamMicro.readString());
              break;
            case 32: 
              setNewnum(paramCodedInputStreamMicro.readInt32());
              break;
            case 42: 
              Msgdata localMsgdata = new Msgdata();
              paramCodedInputStreamMicro.readMessage(localMsgdata);
              addMsgdata(localMsgdata);
            }
          }
        }
        
        public ZhidahaoFollow setLogoUrl(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public ZhidahaoFollow setMsgdata(int paramInt, Msgdata paramMsgdata)
        {
          if (paramMsgdata == null) {
            return this;
          }
          this.g.set(paramInt, paramMsgdata);
          return this;
        }
        
        public ZhidahaoFollow setNewnum(int paramInt)
        {
          this.e = true;
          this.f = paramInt;
          return this;
        }
        
        public ZhidahaoFollow setScreenName(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasScreenName()) {
            paramCodedOutputStreamMicro.writeString(2, getScreenName());
          }
          if (hasLogoUrl()) {
            paramCodedOutputStreamMicro.writeString(3, getLogoUrl());
          }
          if (hasNewnum()) {
            paramCodedOutputStreamMicro.writeInt32(4, getNewnum());
          }
          Iterator localIterator = getMsgdataList().iterator();
          while (localIterator.hasNext()) {
            paramCodedOutputStreamMicro.writeMessage(5, (Msgdata)localIterator.next());
          }
        }
        
        public static final class Msgdata
          extends MessageMicro
        {
          public static final int CONTENTURL_FIELD_NUMBER = 2;
          public static final int TIMESTR_FIELD_NUMBER = 3;
          public static final int TITLE_FIELD_NUMBER = 1;
          private boolean a;
          private String b = "";
          private boolean c;
          private String d = "";
          private boolean e;
          private String f = "";
          private int g = -1;
          
          public static Msgdata parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
            throws IOException
          {
            return new Msgdata().mergeFrom(paramCodedInputStreamMicro);
          }
          
          public static Msgdata parseFrom(byte[] paramArrayOfByte)
            throws InvalidProtocolBufferMicroException
          {
            return (Msgdata)new Msgdata().mergeFrom(paramArrayOfByte);
          }
          
          public final Msgdata clear()
          {
            clearTitle();
            clearContenturl();
            clearTimestr();
            this.g = -1;
            return this;
          }
          
          public Msgdata clearContenturl()
          {
            this.c = false;
            this.d = "";
            return this;
          }
          
          public Msgdata clearTimestr()
          {
            this.e = false;
            this.f = "";
            return this;
          }
          
          public Msgdata clearTitle()
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
          
          public String getContenturl()
          {
            return this.d;
          }
          
          public int getSerializedSize()
          {
            int j = 0;
            if (hasTitle()) {
              j = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            int i = j;
            if (hasContenturl()) {
              i = j + CodedOutputStreamMicro.computeStringSize(2, getContenturl());
            }
            j = i;
            if (hasTimestr()) {
              j = i + CodedOutputStreamMicro.computeStringSize(3, getTimestr());
            }
            this.g = j;
            return j;
          }
          
          public String getTimestr()
          {
            return this.f;
          }
          
          public String getTitle()
          {
            return this.b;
          }
          
          public boolean hasContenturl()
          {
            return this.c;
          }
          
          public boolean hasTimestr()
          {
            return this.e;
          }
          
          public boolean hasTitle()
          {
            return this.a;
          }
          
          public final boolean isInitialized()
          {
            return true;
          }
          
          public Msgdata mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
                setContenturl(paramCodedInputStreamMicro.readString());
                break;
              case 26: 
                setTimestr(paramCodedInputStreamMicro.readString());
              }
            }
          }
          
          public Msgdata setContenturl(String paramString)
          {
            this.c = true;
            this.d = paramString;
            return this;
          }
          
          public Msgdata setTimestr(String paramString)
          {
            this.e = true;
            this.f = paramString;
            return this;
          }
          
          public Msgdata setTitle(String paramString)
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
            if (hasContenturl()) {
              paramCodedOutputStreamMicro.writeString(2, getContenturl());
            }
            if (hasTimestr()) {
              paramCodedOutputStreamMicro.writeString(3, getTimestr());
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/FavoriteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */