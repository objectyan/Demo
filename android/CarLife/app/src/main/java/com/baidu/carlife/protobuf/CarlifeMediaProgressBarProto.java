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
import java.util.List;

public final class CarlifeMediaProgressBarProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeMediaProgressBar_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeMediaProgressBar_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeMediaProgressBarProto.access$702(paramAnonymousFileDescriptor);
        CarlifeMediaProgressBarProto.access$002((Descriptors.Descriptor)CarlifeMediaProgressBarProto.getDescriptor().getMessageTypes().get(0));
        CarlifeMediaProgressBarProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeMediaProgressBarProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaProgressBar_descriptor, new String[] { "ProgressBar" }, CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.class, CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\"CarlifeMediaProgressBarProto.proto\022\032com.baidu.carlife.protobuf\".\n\027CarlifeMediaProgressBar\022\023\n\013progressBar\030\001 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeMediaProgressBar
    extends GeneratedMessage
  {
    public static final int PROGRESSBAR_FIELD_NUMBER = 1;
    private static final CarlifeMediaProgressBar defaultInstance = new CarlifeMediaProgressBar();
    private boolean hasProgressBar;
    private int memoizedSerializedSize = -1;
    private int progressBar_ = 0;
    
    static
    {
      CarlifeMediaProgressBarProto.getDescriptor();
      CarlifeMediaProgressBarProto.internalForceInit();
    }
    
    public static CarlifeMediaProgressBar getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeMediaProgressBarProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaProgressBar_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeMediaProgressBar paramCarlifeMediaProgressBar)
    {
      return newBuilder().mergeFrom(paramCarlifeMediaProgressBar);
    }
    
    public static CarlifeMediaProgressBar parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeMediaProgressBar parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeMediaProgressBar getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getProgressBar()
    {
      return this.progressBar_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasProgressBar()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getProgressBar());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasProgressBar()
    {
      return this.hasProgressBar;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeMediaProgressBarProto.internal_static_com_baidu_carlife_protobuf_CarlifeMediaProgressBar_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasProgressBar;
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
      if (hasProgressBar()) {
        paramCodedOutputStream.writeInt32(1, getProgressBar());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeMediaProgressBarProto.CarlifeMediaProgressBar result;
      
      private CarlifeMediaProgressBarProto.CarlifeMediaProgressBar buildParsed()
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
        localBuilder.result = new CarlifeMediaProgressBarProto.CarlifeMediaProgressBar(null);
        return localBuilder;
      }
      
      public CarlifeMediaProgressBarProto.CarlifeMediaProgressBar build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeMediaProgressBarProto.CarlifeMediaProgressBar buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeMediaProgressBarProto.CarlifeMediaProgressBar localCarlifeMediaProgressBar = this.result;
        this.result = null;
        return localCarlifeMediaProgressBar;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeMediaProgressBarProto.CarlifeMediaProgressBar(null);
        return this;
      }
      
      public Builder clearProgressBar()
      {
        CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.access$502(this.result, false);
        CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeMediaProgressBarProto.CarlifeMediaProgressBar getDefaultInstanceForType()
      {
        return CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.getDescriptor();
      }
      
      public int getProgressBar()
      {
        return this.result.getProgressBar();
      }
      
      public boolean hasProgressBar()
      {
        return this.result.hasProgressBar();
      }
      
      protected CarlifeMediaProgressBarProto.CarlifeMediaProgressBar internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeMediaProgressBarProto.CarlifeMediaProgressBar paramCarlifeMediaProgressBar)
      {
        if (paramCarlifeMediaProgressBar == CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeMediaProgressBar.hasProgressBar()) {
          setProgressBar(paramCarlifeMediaProgressBar.getProgressBar());
        }
        mergeUnknownFields(paramCarlifeMediaProgressBar.getUnknownFields());
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
            setProgressBar(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeMediaProgressBarProto.CarlifeMediaProgressBar)) {
          return mergeFrom((CarlifeMediaProgressBarProto.CarlifeMediaProgressBar)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setProgressBar(int paramInt)
      {
        CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.access$502(this.result, true);
        CarlifeMediaProgressBarProto.CarlifeMediaProgressBar.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeMediaProgressBarProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */