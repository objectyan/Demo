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

public final class walk_info_t
  extends MessageMicro
{
  public static final int DIST_FIELD_NUMBER = 1;
  public static final int PT_FIELD_NUMBER = 2;
  private boolean a;
  private int b = 0;
  private List<Integer> c = Collections.emptyList();
  private int d = -1;
  
  public static walk_info_t parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new walk_info_t().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static walk_info_t parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (walk_info_t)new walk_info_t().mergeFrom(paramArrayOfByte);
  }
  
  public walk_info_t addPt(int paramInt)
  {
    if (this.c.isEmpty()) {
      this.c = new ArrayList();
    }
    this.c.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public final walk_info_t clear()
  {
    clearDist();
    clearPt();
    this.d = -1;
    return this;
  }
  
  public walk_info_t clearDist()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public walk_info_t clearPt()
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
  
  public int getDist()
  {
    return this.b;
  }
  
  public int getPt(int paramInt)
  {
    return ((Integer)this.c.get(paramInt)).intValue();
  }
  
  public int getPtCount()
  {
    return this.c.size();
  }
  
  public List<Integer> getPtList()
  {
    return this.c;
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    if (hasDist()) {}
    for (int i = CodedOutputStreamMicro.computeInt32Size(1, getDist()) + 0;; i = 0)
    {
      Iterator localIterator = getPtList().iterator();
      while (localIterator.hasNext()) {
        j += CodedOutputStreamMicro.computeSInt32SizeNoTag(((Integer)localIterator.next()).intValue());
      }
      i = i + j + getPtList().size() * 1;
      this.d = i;
      return i;
    }
  }
  
  public boolean hasDist()
  {
    return this.a;
  }
  
  public final boolean isInitialized()
  {
    return this.a;
  }
  
  public walk_info_t mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
        setDist(paramCodedInputStreamMicro.readInt32());
        break;
      case 16: 
        addPt(paramCodedInputStreamMicro.readSInt32());
      }
    }
  }
  
  public walk_info_t setDist(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public walk_info_t setPt(int paramInt1, int paramInt2)
  {
    this.c.set(paramInt1, Integer.valueOf(paramInt2));
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasDist()) {
      paramCodedOutputStreamMicro.writeInt32(1, getDist());
    }
    Iterator localIterator = getPtList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeSInt32(2, ((Integer)localIterator.next()).intValue());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/entity/pb/walk_info_t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */