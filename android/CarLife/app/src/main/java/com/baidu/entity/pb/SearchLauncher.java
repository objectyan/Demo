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

public final class SearchLauncher
  extends MessageMicro
{
  public static final int CONTENT_FIELD_NUMBER = 2;
  public static final int OPTION_FIELD_NUMBER = 1;
  private boolean a;
  private Option b = null;
  private List<Content> c = Collections.emptyList();
  private int d = -1;
  
  public static SearchLauncher parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new SearchLauncher().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static SearchLauncher parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (SearchLauncher)new SearchLauncher().mergeFrom(paramArrayOfByte);
  }
  
  public SearchLauncher addContent(Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(paramContent);
    return this;
  }
  
  public final SearchLauncher clear()
  {
    clearOption();
    clearContent();
    this.d = -1;
    return this;
  }
  
  public SearchLauncher clearContent()
  {
    this.c = Collections.emptyList();
    return this;
  }
  
  public SearchLauncher clearOption()
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
  
  public Content getContent(int paramInt)
  {
    return (Content)this.c.get(paramInt);
  }
  
  public int getContentCount()
  {
    return this.c.size();
  }
  
  public List<Content> getContentList()
  {
    return this.c;
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
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      i = CodedOutputStreamMicro.computeMessageSize(2, (Content)localIterator.next()) + i;
    }
    this.d = i;
    return i;
  }
  
  public boolean hasOption()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public SearchLauncher mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        localObject = new Content();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addContent((Content)localObject);
      }
    }
  }
  
  public SearchLauncher setContent(int paramInt, Content paramContent)
  {
    if (paramContent == null) {
      return this;
    }
    this.c.set(paramInt, paramContent);
    return this;
  }
  
  public SearchLauncher setOption(Option paramOption)
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
    Iterator localIterator = getContentList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(2, (Content)localIterator.next());
    }
  }
  
  public static final class Content
    extends MessageMicro
  {
    public static final int ACTION_FIELD_NUMBER = 1;
    public static final int EXT_PARAM_FIELD_NUMBER = 2;
    private boolean a;
    private ExtParam b = null;
    private boolean c;
    private String d = "";
    private int e = -1;
    
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
    
    public final Content clear()
    {
      clearExtParam();
      clearAction();
      this.e = -1;
      return this;
    }
    
    public Content clearAction()
    {
      this.c = false;
      this.d = "";
      return this;
    }
    
    public Content clearExtParam()
    {
      this.a = false;
      this.b = null;
      return this;
    }
    
    public String getAction()
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
    
    public ExtParam getExtParam()
    {
      return this.b;
    }
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasAction()) {
        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAction());
      }
      int j = i;
      if (hasExtParam()) {
        j = i + CodedOutputStreamMicro.computeMessageSize(2, getExtParam());
      }
      this.e = j;
      return j;
    }
    
    public boolean hasAction()
    {
      return this.c;
    }
    
    public boolean hasExtParam()
    {
      return this.a;
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
        int i = paramCodedInputStreamMicro.readTag();
        switch (i)
        {
        default: 
          if (parseUnknownField(paramCodedInputStreamMicro, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          setAction(paramCodedInputStreamMicro.readString());
          break;
        case 18: 
          ExtParam localExtParam = new ExtParam();
          paramCodedInputStreamMicro.readMessage(localExtParam);
          setExtParam(localExtParam);
        }
      }
    }
    
    public Content setAction(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public Content setExtParam(ExtParam paramExtParam)
    {
      if (paramExtParam == null) {
        return clearExtParam();
      }
      this.a = true;
      this.b = paramExtParam;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasAction()) {
        paramCodedOutputStreamMicro.writeString(1, getAction());
      }
      if (hasExtParam()) {
        paramCodedOutputStreamMicro.writeMessage(2, getExtParam());
      }
    }
    
    public static final class ExtParam
      extends MessageMicro
    {
      public static final int BROWSER_FIELD_NUMBER = 2;
      public static final int JUMPTO_FIELD_NUMBER = 1;
      private boolean a;
      private Jumpto b = null;
      private boolean c;
      private Browser d = null;
      private int e = -1;
      
      public static ExtParam parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
        throws IOException
      {
        return new ExtParam().mergeFrom(paramCodedInputStreamMicro);
      }
      
      public static ExtParam parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferMicroException
      {
        return (ExtParam)new ExtParam().mergeFrom(paramArrayOfByte);
      }
      
      public final ExtParam clear()
      {
        clearJumpto();
        clearBrowser();
        this.e = -1;
        return this;
      }
      
      public ExtParam clearBrowser()
      {
        this.c = false;
        this.d = null;
        return this;
      }
      
      public ExtParam clearJumpto()
      {
        this.a = false;
        this.b = null;
        return this;
      }
      
      public Browser getBrowser()
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
      
      public Jumpto getJumpto()
      {
        return this.b;
      }
      
      public int getSerializedSize()
      {
        int i = 0;
        if (hasJumpto()) {
          i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getJumpto());
        }
        int j = i;
        if (hasBrowser()) {
          j = i + CodedOutputStreamMicro.computeMessageSize(2, getBrowser());
        }
        this.e = j;
        return j;
      }
      
      public boolean hasBrowser()
      {
        return this.c;
      }
      
      public boolean hasJumpto()
      {
        return this.a;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public ExtParam mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
            localObject = new Jumpto();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setJumpto((Jumpto)localObject);
            break;
          case 18: 
            localObject = new Browser();
            paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
            setBrowser((Browser)localObject);
          }
        }
      }
      
      public ExtParam setBrowser(Browser paramBrowser)
      {
        if (paramBrowser == null) {
          return clearBrowser();
        }
        this.c = true;
        this.d = paramBrowser;
        return this;
      }
      
      public ExtParam setJumpto(Jumpto paramJumpto)
      {
        if (paramJumpto == null) {
          return clearJumpto();
        }
        this.a = true;
        this.b = paramJumpto;
        return this;
      }
      
      public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
        throws IOException
      {
        if (hasJumpto()) {
          paramCodedOutputStreamMicro.writeMessage(1, getJumpto());
        }
        if (hasBrowser()) {
          paramCodedOutputStreamMicro.writeMessage(2, getBrowser());
        }
      }
      
      public static final class Browser
        extends MessageMicro
      {
        public static final int URL_FIELD_NUMBER = 1;
        private boolean a;
        private String b = "";
        private int c = -1;
        
        public static Browser parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Browser().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Browser parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Browser)new Browser().mergeFrom(paramArrayOfByte);
        }
        
        public final Browser clear()
        {
          clearUrl();
          this.c = -1;
          return this;
        }
        
        public Browser clearUrl()
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
          if (hasUrl()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
          }
          this.c = i;
          return i;
        }
        
        public String getUrl()
        {
          return this.b;
        }
        
        public boolean hasUrl()
        {
          return this.a;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Browser mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setUrl(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Browser setUrl(String paramString)
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
        }
      }
      
      public static final class Jumpto
        extends MessageMicro
      {
        public static final int CF_TAG_FIELD_NUMBER = 1;
        public static final int PARAMS_FIELD_NUMBER = 2;
        private boolean a;
        private String b = "";
        private boolean c;
        private String d = "";
        private int e = -1;
        
        public static Jumpto parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
          throws IOException
        {
          return new Jumpto().mergeFrom(paramCodedInputStreamMicro);
        }
        
        public static Jumpto parseFrom(byte[] paramArrayOfByte)
          throws InvalidProtocolBufferMicroException
        {
          return (Jumpto)new Jumpto().mergeFrom(paramArrayOfByte);
        }
        
        public final Jumpto clear()
        {
          clearCfTag();
          clearParams();
          this.e = -1;
          return this;
        }
        
        public Jumpto clearCfTag()
        {
          this.a = false;
          this.b = "";
          return this;
        }
        
        public Jumpto clearParams()
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
        
        public String getCfTag()
        {
          return this.b;
        }
        
        public String getParams()
        {
          return this.d;
        }
        
        public int getSerializedSize()
        {
          int i = 0;
          if (hasCfTag()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCfTag());
          }
          int j = i;
          if (hasParams()) {
            j = i + CodedOutputStreamMicro.computeStringSize(2, getParams());
          }
          this.e = j;
          return j;
        }
        
        public boolean hasCfTag()
        {
          return this.a;
        }
        
        public boolean hasParams()
        {
          return this.c;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
        
        public Jumpto mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
              setCfTag(paramCodedInputStreamMicro.readString());
              break;
            case 18: 
              setParams(paramCodedInputStreamMicro.readString());
            }
          }
        }
        
        public Jumpto setCfTag(String paramString)
        {
          this.a = true;
          this.b = paramString;
          return this;
        }
        
        public Jumpto setParams(String paramString)
        {
          this.c = true;
          this.d = paramString;
          return this;
        }
        
        public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
          throws IOException
        {
          if (hasCfTag()) {
            paramCodedOutputStreamMicro.writeString(1, getCfTag());
          }
          if (hasParams()) {
            paramCodedOutputStreamMicro.writeString(2, getParams());
          }
        }
      }
    }
  }
  
  public static final class Option
    extends MessageMicro
  {
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int VERSION_FIELD_NUMBER = 2;
    private boolean a;
    private int b = 0;
    private boolean c;
    private int d = 0;
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
      clearError();
      clearVersion();
      this.e = -1;
      return this;
    }
    
    public Option clearError()
    {
      this.a = false;
      this.b = 0;
      return this;
    }
    
    public Option clearVersion()
    {
      this.c = false;
      this.d = 0;
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
    
    public int getSerializedSize()
    {
      int i = 0;
      if (hasError()) {
        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
      }
      int j = i;
      if (hasVersion()) {
        j = i + CodedOutputStreamMicro.computeInt32Size(2, getVersion());
      }
      this.e = j;
      return j;
    }
    
    public int getVersion()
    {
      return this.d;
    }
    
    public boolean hasError()
    {
      return this.a;
    }
    
    public boolean hasVersion()
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
          setError(paramCodedInputStreamMicro.readInt32());
          break;
        case 16: 
          setVersion(paramCodedInputStreamMicro.readInt32());
        }
      }
    }
    
    public Option setError(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public Option setVersion(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
      throws IOException
    {
      if (hasError()) {
        paramCodedOutputStreamMicro.writeInt32(1, getError());
      }
      if (hasVersion()) {
        paramCodedOutputStreamMicro.writeInt32(2, getVersion());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/SearchLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */