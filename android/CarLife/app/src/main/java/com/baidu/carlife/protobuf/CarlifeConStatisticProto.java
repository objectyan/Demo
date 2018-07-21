package com.baidu.carlife.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CarlifeConStatisticProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeConnectStatistics_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeConnectStatistics_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeConStatisticProto.access$1602(paramAnonymousFileDescriptor);
        CarlifeConStatisticProto.access$002((Descriptors.Descriptor)CarlifeConStatisticProto.getDescriptor().getMessageTypes().get(0));
        CarlifeConStatisticProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeConStatisticProto.internal_static_com_baidu_carlife_protobuf_CarlifeConnectStatistics_descriptor, new String[] { "Contotal", "Consuccess", "Confailed", "Contime", "Nerrorcount", "ErrorType" }, CarlifeConStatisticProto.CarlifeConnectStatistics.class, CarlifeConStatisticProto.CarlifeConnectStatistics.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n$proto/CarlifeConStatisticProto.proto\022\032com.baidu.carlife.protobuf\"\001\n\030CarlifeConnectStatistics\022\020\n\bcontotal\030\001 \002(\005\022\022\n\nconsuccess\030\002 \002(\005\022\021\n\tconfailed\030\003 \002(\005\022\017\n\007contime\030\004 \002(\005\022\023\n\013nerrorcount\030\005 \002(\005\022\022\n\nerror_type\030\006 \003(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeConnectStatistics
    extends GeneratedMessage
  {
    public static final int CONFAILED_FIELD_NUMBER = 3;
    public static final int CONSUCCESS_FIELD_NUMBER = 2;
    public static final int CONTIME_FIELD_NUMBER = 4;
    public static final int CONTOTAL_FIELD_NUMBER = 1;
    public static final int ERROR_TYPE_FIELD_NUMBER = 6;
    public static final int NERRORCOUNT_FIELD_NUMBER = 5;
    private static final CarlifeConnectStatistics defaultInstance = new CarlifeConnectStatistics();
    private int confailed_ = 0;
    private int consuccess_ = 0;
    private int contime_ = 0;
    private int contotal_ = 0;
    private List<String> errorType_ = Collections.emptyList();
    private boolean hasConfailed;
    private boolean hasConsuccess;
    private boolean hasContime;
    private boolean hasContotal;
    private boolean hasNerrorcount;
    private int memoizedSerializedSize = -1;
    private int nerrorcount_ = 0;
    
    static
    {
      CarlifeConStatisticProto.getDescriptor();
      CarlifeConStatisticProto.internalForceInit();
    }
    
    public static CarlifeConnectStatistics getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeConStatisticProto.internal_static_com_baidu_carlife_protobuf_CarlifeConnectStatistics_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeConnectStatistics paramCarlifeConnectStatistics)
    {
      return newBuilder().mergeFrom(paramCarlifeConnectStatistics);
    }
    
    public static CarlifeConnectStatistics parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeConnectStatistics parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getConfailed()
    {
      return this.confailed_;
    }
    
    public int getConsuccess()
    {
      return this.consuccess_;
    }
    
    public int getContime()
    {
      return this.contime_;
    }
    
    public int getContotal()
    {
      return this.contotal_;
    }
    
    public CarlifeConnectStatistics getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getErrorType(int paramInt)
    {
      return (String)this.errorType_.get(paramInt);
    }
    
    public int getErrorTypeCount()
    {
      return this.errorType_.size();
    }
    
    public List<String> getErrorTypeList()
    {
      return this.errorType_;
    }
    
    public int getNerrorcount()
    {
      return this.nerrorcount_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasContotal()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getContotal());
      }
      i = j;
      if (hasConsuccess()) {
        i = j + CodedOutputStream.computeInt32Size(2, getConsuccess());
      }
      j = i;
      if (hasConfailed()) {
        j = i + CodedOutputStream.computeInt32Size(3, getConfailed());
      }
      i = j;
      if (hasContime()) {
        i = j + CodedOutputStream.computeInt32Size(4, getContime());
      }
      j = i;
      if (hasNerrorcount()) {
        j = i + CodedOutputStream.computeInt32Size(5, getNerrorcount());
      }
      i = 0;
      Iterator localIterator = getErrorTypeList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeStringSizeNoTag((String)localIterator.next());
      }
      i = j + i + getErrorTypeList().size() * 1 + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasConfailed()
    {
      return this.hasConfailed;
    }
    
    public boolean hasConsuccess()
    {
      return this.hasConsuccess;
    }
    
    public boolean hasContime()
    {
      return this.hasContime;
    }
    
    public boolean hasContotal()
    {
      return this.hasContotal;
    }
    
    public boolean hasNerrorcount()
    {
      return this.hasNerrorcount;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeConStatisticProto.internal_static_com_baidu_carlife_protobuf_CarlifeConnectStatistics_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasContotal) {}
      while ((!this.hasConsuccess) || (!this.hasConfailed) || (!this.hasContime) || (!this.hasNerrorcount)) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasContotal()) {
        paramCodedOutputStream.writeInt32(1, getContotal());
      }
      if (hasConsuccess()) {
        paramCodedOutputStream.writeInt32(2, getConsuccess());
      }
      if (hasConfailed()) {
        paramCodedOutputStream.writeInt32(3, getConfailed());
      }
      if (hasContime()) {
        paramCodedOutputStream.writeInt32(4, getContime());
      }
      if (hasNerrorcount()) {
        paramCodedOutputStream.writeInt32(5, getNerrorcount());
      }
      Iterator localIterator = getErrorTypeList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeString(6, (String)localIterator.next());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeConStatisticProto.CarlifeConnectStatistics result;
      
      private CarlifeConStatisticProto.CarlifeConnectStatistics buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new CarlifeConStatisticProto.CarlifeConnectStatistics(null);
        return localBuilder;
      }
      
      public Builder addAllErrorType(Iterable<? extends String> paramIterable)
      {
        if (this.result.errorType_.isEmpty()) {
          CarlifeConStatisticProto.CarlifeConnectStatistics.access$502(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.errorType_);
        return this;
      }
      
      public Builder addErrorType(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        if (this.result.errorType_.isEmpty()) {
          CarlifeConStatisticProto.CarlifeConnectStatistics.access$502(this.result, new ArrayList());
        }
        this.result.errorType_.add(paramString);
        return this;
      }
      
      public CarlifeConStatisticProto.CarlifeConnectStatistics build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeConStatisticProto.CarlifeConnectStatistics buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.errorType_ != Collections.EMPTY_LIST) {
          CarlifeConStatisticProto.CarlifeConnectStatistics.access$502(this.result, Collections.unmodifiableList(this.result.errorType_));
        }
        CarlifeConStatisticProto.CarlifeConnectStatistics localCarlifeConnectStatistics = this.result;
        this.result = null;
        return localCarlifeConnectStatistics;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeConStatisticProto.CarlifeConnectStatistics(null);
        return this;
      }
      
      public Builder clearConfailed()
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1002(this.result, false);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1102(this.result, 0);
        return this;
      }
      
      public Builder clearConsuccess()
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$802(this.result, false);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$902(this.result, 0);
        return this;
      }
      
      public Builder clearContime()
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1202(this.result, false);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1302(this.result, 0);
        return this;
      }
      
      public Builder clearContotal()
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$602(this.result, false);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$702(this.result, 0);
        return this;
      }
      
      public Builder clearErrorType()
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$502(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearNerrorcount()
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1402(this.result, false);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1502(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getConfailed()
      {
        return this.result.getConfailed();
      }
      
      public int getConsuccess()
      {
        return this.result.getConsuccess();
      }
      
      public int getContime()
      {
        return this.result.getContime();
      }
      
      public int getContotal()
      {
        return this.result.getContotal();
      }
      
      public CarlifeConStatisticProto.CarlifeConnectStatistics getDefaultInstanceForType()
      {
        return CarlifeConStatisticProto.CarlifeConnectStatistics.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeConStatisticProto.CarlifeConnectStatistics.getDescriptor();
      }
      
      public String getErrorType(int paramInt)
      {
        return this.result.getErrorType(paramInt);
      }
      
      public int getErrorTypeCount()
      {
        return this.result.getErrorTypeCount();
      }
      
      public List<String> getErrorTypeList()
      {
        return Collections.unmodifiableList(this.result.errorType_);
      }
      
      public int getNerrorcount()
      {
        return this.result.getNerrorcount();
      }
      
      public boolean hasConfailed()
      {
        return this.result.hasConfailed();
      }
      
      public boolean hasConsuccess()
      {
        return this.result.hasConsuccess();
      }
      
      public boolean hasContime()
      {
        return this.result.hasContime();
      }
      
      public boolean hasContotal()
      {
        return this.result.hasContotal();
      }
      
      public boolean hasNerrorcount()
      {
        return this.result.hasNerrorcount();
      }
      
      protected CarlifeConStatisticProto.CarlifeConnectStatistics internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeConStatisticProto.CarlifeConnectStatistics paramCarlifeConnectStatistics)
      {
        if (paramCarlifeConnectStatistics == CarlifeConStatisticProto.CarlifeConnectStatistics.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeConnectStatistics.hasContotal()) {
          setContotal(paramCarlifeConnectStatistics.getContotal());
        }
        if (paramCarlifeConnectStatistics.hasConsuccess()) {
          setConsuccess(paramCarlifeConnectStatistics.getConsuccess());
        }
        if (paramCarlifeConnectStatistics.hasConfailed()) {
          setConfailed(paramCarlifeConnectStatistics.getConfailed());
        }
        if (paramCarlifeConnectStatistics.hasContime()) {
          setContime(paramCarlifeConnectStatistics.getContime());
        }
        if (paramCarlifeConnectStatistics.hasNerrorcount()) {
          setNerrorcount(paramCarlifeConnectStatistics.getNerrorcount());
        }
        if (!paramCarlifeConnectStatistics.errorType_.isEmpty())
        {
          if (this.result.errorType_.isEmpty()) {
            CarlifeConStatisticProto.CarlifeConnectStatistics.access$502(this.result, new ArrayList());
          }
          this.result.errorType_.addAll(paramCarlifeConnectStatistics.errorType_);
        }
        mergeUnknownFields(paramCarlifeConnectStatistics.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 8: 
            setContotal(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setConsuccess(paramCodedInputStream.readInt32());
            break;
          case 24: 
            setConfailed(paramCodedInputStream.readInt32());
            break;
          case 32: 
            setContime(paramCodedInputStream.readInt32());
            break;
          case 40: 
            setNerrorcount(paramCodedInputStream.readInt32());
            break;
          case 50: 
            addErrorType(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeConStatisticProto.CarlifeConnectStatistics)) {
          return mergeFrom((CarlifeConStatisticProto.CarlifeConnectStatistics)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setConfailed(int paramInt)
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1002(this.result, true);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1102(this.result, paramInt);
        return this;
      }
      
      public Builder setConsuccess(int paramInt)
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$802(this.result, true);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$902(this.result, paramInt);
        return this;
      }
      
      public Builder setContime(int paramInt)
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1202(this.result, true);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1302(this.result, paramInt);
        return this;
      }
      
      public Builder setContotal(int paramInt)
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$602(this.result, true);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$702(this.result, paramInt);
        return this;
      }
      
      public Builder setErrorType(int paramInt, String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.result.errorType_.set(paramInt, paramString);
        return this;
      }
      
      public Builder setNerrorcount(int paramInt)
      {
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1402(this.result, true);
        CarlifeConStatisticProto.CarlifeConnectStatistics.access$1502(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeConStatisticProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */