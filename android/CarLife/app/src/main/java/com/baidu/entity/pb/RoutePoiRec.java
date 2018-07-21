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

public final class RoutePoiRec
  extends MessageMicro
{
  public static final int RECOMMDATA_FIELD_NUMBER = 1;
  private List<RouteItem> a = Collections.emptyList();
  private int b = -1;
  
  public static RoutePoiRec parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new RoutePoiRec().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static RoutePoiRec parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (RoutePoiRec)new RoutePoiRec().mergeFrom(paramArrayOfByte);
  }
  
  public RoutePoiRec addRecommdata(RouteItem paramRouteItem)
  {
    if (paramRouteItem == null) {
      return this;
    }
    if (this.a.isEmpty()) {
      this.a = new ArrayList();
    }
    this.a.add(paramRouteItem);
    return this;
  }
  
  public final RoutePoiRec clear()
  {
    clearRecommdata();
    this.b = -1;
    return this;
  }
  
  public RoutePoiRec clearRecommdata()
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
  
  public RouteItem getRecommdata(int paramInt)
  {
    return (RouteItem)this.a.get(paramInt);
  }
  
  public int getRecommdataCount()
  {
    return this.a.size();
  }
  
  public List<RouteItem> getRecommdataList()
  {
    return this.a;
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = getRecommdataList().iterator();
    for (int i = 0; localIterator.hasNext(); i = CodedOutputStreamMicro.computeMessageSize(1, (RouteItem)localIterator.next()) + i) {}
    this.b = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public RoutePoiRec mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        RouteItem localRouteItem = new RouteItem();
        paramCodedInputStreamMicro.readMessage(localRouteItem);
        addRecommdata(localRouteItem);
      }
    }
  }
  
  public RoutePoiRec setRecommdata(int paramInt, RouteItem paramRouteItem)
  {
    if (paramRouteItem == null) {
      return this;
    }
    this.a.set(paramInt, paramRouteItem);
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    Iterator localIterator = getRecommdataList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(1, (RouteItem)localIterator.next());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/RoutePoiRec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */