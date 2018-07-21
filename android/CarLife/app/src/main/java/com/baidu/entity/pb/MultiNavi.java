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

public final class MultiNavi
  extends MessageMicro
{
  public static final int MULTIANVISTREAM_FIELD_NUMBER = 3;
  public static final int POS_INFO_FIELD_NUMBER = 4;
  public static final int RETURNED_VERSION_FIELD_NUMBER = 7;
  public static final int TRAFFICPOISSTREAM_FIELD_NUMBER = 2;
  public static final int TRAFFIC_FC_POIS_FIELD_NUMBER = 5;
  public static final int UIIRETURNTYPE_FIELD_NUMBER = 1;
  public static final int WALKINF_FIELD_NUMBER = 6;
  private boolean a;
  private int b = 0;
  private boolean c;
  private ByteStringMicro d = ByteStringMicro.EMPTY;
  private boolean e;
  private ByteStringMicro f = ByteStringMicro.EMPTY;
  private List<Position_Info> g = Collections.emptyList();
  private boolean h;
  private TrafficFCPois i = null;
  private boolean j;
  private walk_info_t k = null;
  private boolean l;
  private int m = 0;
  private int n = -1;
  
  public static MultiNavi parseFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    return new MultiNavi().mergeFrom(paramCodedInputStreamMicro);
  }
  
  public static MultiNavi parseFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return (MultiNavi)new MultiNavi().mergeFrom(paramArrayOfByte);
  }
  
  public MultiNavi addPosInfo(Position_Info paramPosition_Info)
  {
    if (paramPosition_Info == null) {
      return this;
    }
    if (this.g.isEmpty()) {
      this.g = new ArrayList();
    }
    this.g.add(paramPosition_Info);
    return this;
  }
  
  public final MultiNavi clear()
  {
    clearUiiReturnType();
    clearTrafficPoisStream();
    clearMultianviStream();
    clearPosInfo();
    clearTrafficFcPois();
    clearWalkinf();
    clearReturnedVersion();
    this.n = -1;
    return this;
  }
  
  public MultiNavi clearMultianviStream()
  {
    this.e = false;
    this.f = ByteStringMicro.EMPTY;
    return this;
  }
  
  public MultiNavi clearPosInfo()
  {
    this.g = Collections.emptyList();
    return this;
  }
  
  public MultiNavi clearReturnedVersion()
  {
    this.l = false;
    this.m = 0;
    return this;
  }
  
  public MultiNavi clearTrafficFcPois()
  {
    this.h = false;
    this.i = null;
    return this;
  }
  
  public MultiNavi clearTrafficPoisStream()
  {
    this.c = false;
    this.d = ByteStringMicro.EMPTY;
    return this;
  }
  
  public MultiNavi clearUiiReturnType()
  {
    this.a = false;
    this.b = 0;
    return this;
  }
  
  public MultiNavi clearWalkinf()
  {
    this.j = false;
    this.k = null;
    return this;
  }
  
  public int getCachedSize()
  {
    if (this.n < 0) {
      getSerializedSize();
    }
    return this.n;
  }
  
  public ByteStringMicro getMultianviStream()
  {
    return this.f;
  }
  
  public Position_Info getPosInfo(int paramInt)
  {
    return (Position_Info)this.g.get(paramInt);
  }
  
  public int getPosInfoCount()
  {
    return this.g.size();
  }
  
  public List<Position_Info> getPosInfoList()
  {
    return this.g;
  }
  
  public int getReturnedVersion()
  {
    return this.m;
  }
  
  public int getSerializedSize()
  {
    int i2 = 0;
    if (hasUiiReturnType()) {
      i2 = 0 + CodedOutputStreamMicro.computeInt32Size(1, getUiiReturnType());
    }
    int i1 = i2;
    if (hasTrafficPoisStream()) {
      i1 = i2 + CodedOutputStreamMicro.computeBytesSize(2, getTrafficPoisStream());
    }
    i2 = i1;
    if (hasMultianviStream()) {
      i2 = i1 + CodedOutputStreamMicro.computeBytesSize(3, getMultianviStream());
    }
    Iterator localIterator = getPosInfoList().iterator();
    while (localIterator.hasNext()) {
      i2 = CodedOutputStreamMicro.computeMessageSize(4, (Position_Info)localIterator.next()) + i2;
    }
    i1 = i2;
    if (hasTrafficFcPois()) {
      i1 = i2 + CodedOutputStreamMicro.computeMessageSize(5, getTrafficFcPois());
    }
    i2 = i1;
    if (hasWalkinf()) {
      i2 = i1 + CodedOutputStreamMicro.computeMessageSize(6, getWalkinf());
    }
    i1 = i2;
    if (hasReturnedVersion()) {
      i1 = i2 + CodedOutputStreamMicro.computeInt32Size(7, getReturnedVersion());
    }
    this.n = i1;
    return i1;
  }
  
  public TrafficFCPois getTrafficFcPois()
  {
    return this.i;
  }
  
  public ByteStringMicro getTrafficPoisStream()
  {
    return this.d;
  }
  
  public int getUiiReturnType()
  {
    return this.b;
  }
  
  public walk_info_t getWalkinf()
  {
    return this.k;
  }
  
  public boolean hasMultianviStream()
  {
    return this.e;
  }
  
  public boolean hasReturnedVersion()
  {
    return this.l;
  }
  
  public boolean hasTrafficFcPois()
  {
    return this.h;
  }
  
  public boolean hasTrafficPoisStream()
  {
    return this.c;
  }
  
  public boolean hasUiiReturnType()
  {
    return this.a;
  }
  
  public boolean hasWalkinf()
  {
    return this.j;
  }
  
  public final boolean isInitialized()
  {
    return (!hasWalkinf()) || (getWalkinf().isInitialized());
  }
  
  public MultiNavi mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
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
      case 8: 
        setUiiReturnType(paramCodedInputStreamMicro.readInt32());
        break;
      case 18: 
        setTrafficPoisStream(paramCodedInputStreamMicro.readBytes());
        break;
      case 26: 
        setMultianviStream(paramCodedInputStreamMicro.readBytes());
        break;
      case 34: 
        localObject = new Position_Info();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        addPosInfo((Position_Info)localObject);
        break;
      case 42: 
        localObject = new TrafficFCPois();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setTrafficFcPois((TrafficFCPois)localObject);
        break;
      case 50: 
        localObject = new walk_info_t();
        paramCodedInputStreamMicro.readMessage((MessageMicro)localObject);
        setWalkinf((walk_info_t)localObject);
        break;
      case 56: 
        setReturnedVersion(paramCodedInputStreamMicro.readInt32());
      }
    }
  }
  
  public MultiNavi setMultianviStream(ByteStringMicro paramByteStringMicro)
  {
    this.e = true;
    this.f = paramByteStringMicro;
    return this;
  }
  
  public MultiNavi setPosInfo(int paramInt, Position_Info paramPosition_Info)
  {
    if (paramPosition_Info == null) {
      return this;
    }
    this.g.set(paramInt, paramPosition_Info);
    return this;
  }
  
  public MultiNavi setReturnedVersion(int paramInt)
  {
    this.l = true;
    this.m = paramInt;
    return this;
  }
  
  public MultiNavi setTrafficFcPois(TrafficFCPois paramTrafficFCPois)
  {
    if (paramTrafficFCPois == null) {
      return clearTrafficFcPois();
    }
    this.h = true;
    this.i = paramTrafficFCPois;
    return this;
  }
  
  public MultiNavi setTrafficPoisStream(ByteStringMicro paramByteStringMicro)
  {
    this.c = true;
    this.d = paramByteStringMicro;
    return this;
  }
  
  public MultiNavi setUiiReturnType(int paramInt)
  {
    this.a = true;
    this.b = paramInt;
    return this;
  }
  
  public MultiNavi setWalkinf(walk_info_t paramwalk_info_t)
  {
    if (paramwalk_info_t == null) {
      return clearWalkinf();
    }
    this.j = true;
    this.k = paramwalk_info_t;
    return this;
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    if (hasUiiReturnType()) {
      paramCodedOutputStreamMicro.writeInt32(1, getUiiReturnType());
    }
    if (hasTrafficPoisStream()) {
      paramCodedOutputStreamMicro.writeBytes(2, getTrafficPoisStream());
    }
    if (hasMultianviStream()) {
      paramCodedOutputStreamMicro.writeBytes(3, getMultianviStream());
    }
    Iterator localIterator = getPosInfoList().iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStreamMicro.writeMessage(4, (Position_Info)localIterator.next());
    }
    if (hasTrafficFcPois()) {
      paramCodedOutputStreamMicro.writeMessage(5, getTrafficFcPois());
    }
    if (hasWalkinf()) {
      paramCodedOutputStreamMicro.writeMessage(6, getWalkinf());
    }
    if (hasReturnedVersion()) {
      paramCodedOutputStreamMicro.writeInt32(7, getReturnedVersion());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/entity/pb/MultiNavi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */