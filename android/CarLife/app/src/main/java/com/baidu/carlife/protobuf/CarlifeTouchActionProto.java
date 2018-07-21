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

public final class CarlifeTouchActionProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeTouchAction_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeTouchAction_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTouchActionProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeTouchActionProto.access$002((Descriptors.Descriptor)CarlifeTouchActionProto.getDescriptor().getMessageTypes().get(0));
        CarlifeTouchActionProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTouchActionProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchAction_descriptor, new String[] { "Action", "X", "Y" }, CarlifeTouchActionProto.CarlifeTouchAction.class, CarlifeTouchActionProto.CarlifeTouchAction.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\035CarlifeTouchActionProto.proto\022\032com.baidu.carlife.protobuf\":\n\022CarlifeTouchAction\022\016\n\006action\030\001 \002(\005\022\t\n\001x\030\002 \002(\005\022\t\n\001y\030\003 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTouchAction
    extends GeneratedMessage
  {
    public static final int ACTION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 2;
    public static final int Y_FIELD_NUMBER = 3;
    private static final CarlifeTouchAction defaultInstance = new CarlifeTouchAction();
    private int action_ = 0;
    private boolean hasAction;
    private boolean hasX;
    private boolean hasY;
    private int memoizedSerializedSize = -1;
    private int x_ = 0;
    private int y_ = 0;
    
    static
    {
      CarlifeTouchActionProto.getDescriptor();
      CarlifeTouchActionProto.internalForceInit();
    }
    
    public static CarlifeTouchAction getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTouchActionProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchAction_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTouchAction paramCarlifeTouchAction)
    {
      return newBuilder().mergeFrom(paramCarlifeTouchAction);
    }
    
    public static CarlifeTouchAction parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTouchAction parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchAction parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTouchAction parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchAction parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTouchAction parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTouchAction parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTouchAction parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchAction parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTouchAction parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public int getAction()
    {
      return this.action_;
    }
    
    public CarlifeTouchAction getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasAction()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getAction());
      }
      i = j;
      if (hasX()) {
        i = j + CodedOutputStream.computeInt32Size(2, getX());
      }
      j = i;
      if (hasY()) {
        j = i + CodedOutputStream.computeInt32Size(3, getY());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getX()
    {
      return this.x_;
    }
    
    public int getY()
    {
      return this.y_;
    }
    
    public boolean hasAction()
    {
      return this.hasAction;
    }
    
    public boolean hasX()
    {
      return this.hasX;
    }
    
    public boolean hasY()
    {
      return this.hasY;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTouchActionProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchAction_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasAction) {}
      while ((!this.hasX) || (!this.hasY)) {
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
      if (hasAction()) {
        paramCodedOutputStream.writeInt32(1, getAction());
      }
      if (hasX()) {
        paramCodedOutputStream.writeInt32(2, getX());
      }
      if (hasY()) {
        paramCodedOutputStream.writeInt32(3, getY());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTouchActionProto.CarlifeTouchAction result;
      
      private CarlifeTouchActionProto.CarlifeTouchAction buildParsed()
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
        localBuilder.result = new CarlifeTouchActionProto.CarlifeTouchAction(null);
        return localBuilder;
      }
      
      public CarlifeTouchActionProto.CarlifeTouchAction build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTouchActionProto.CarlifeTouchAction buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTouchActionProto.CarlifeTouchAction localCarlifeTouchAction = this.result;
        this.result = null;
        return localCarlifeTouchAction;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTouchActionProto.CarlifeTouchAction(null);
        return this;
      }
      
      public Builder clearAction()
      {
        CarlifeTouchActionProto.CarlifeTouchAction.access$502(this.result, false);
        CarlifeTouchActionProto.CarlifeTouchAction.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearX()
      {
        CarlifeTouchActionProto.CarlifeTouchAction.access$702(this.result, false);
        CarlifeTouchActionProto.CarlifeTouchAction.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearY()
      {
        CarlifeTouchActionProto.CarlifeTouchAction.access$902(this.result, false);
        CarlifeTouchActionProto.CarlifeTouchAction.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public int getAction()
      {
        return this.result.getAction();
      }
      
      public CarlifeTouchActionProto.CarlifeTouchAction getDefaultInstanceForType()
      {
        return CarlifeTouchActionProto.CarlifeTouchAction.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTouchActionProto.CarlifeTouchAction.getDescriptor();
      }
      
      public int getX()
      {
        return this.result.getX();
      }
      
      public int getY()
      {
        return this.result.getY();
      }
      
      public boolean hasAction()
      {
        return this.result.hasAction();
      }
      
      public boolean hasX()
      {
        return this.result.hasX();
      }
      
      public boolean hasY()
      {
        return this.result.hasY();
      }
      
      protected CarlifeTouchActionProto.CarlifeTouchAction internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTouchActionProto.CarlifeTouchAction paramCarlifeTouchAction)
      {
        if (paramCarlifeTouchAction == CarlifeTouchActionProto.CarlifeTouchAction.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTouchAction.hasAction()) {
          setAction(paramCarlifeTouchAction.getAction());
        }
        if (paramCarlifeTouchAction.hasX()) {
          setX(paramCarlifeTouchAction.getX());
        }
        if (paramCarlifeTouchAction.hasY()) {
          setY(paramCarlifeTouchAction.getY());
        }
        mergeUnknownFields(paramCarlifeTouchAction.getUnknownFields());
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
            setAction(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setX(paramCodedInputStream.readInt32());
            break;
          case 24: 
            setY(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTouchActionProto.CarlifeTouchAction)) {
          return mergeFrom((CarlifeTouchActionProto.CarlifeTouchAction)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAction(int paramInt)
      {
        CarlifeTouchActionProto.CarlifeTouchAction.access$502(this.result, true);
        CarlifeTouchActionProto.CarlifeTouchAction.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setX(int paramInt)
      {
        CarlifeTouchActionProto.CarlifeTouchAction.access$702(this.result, true);
        CarlifeTouchActionProto.CarlifeTouchAction.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setY(int paramInt)
      {
        CarlifeTouchActionProto.CarlifeTouchAction.access$902(this.result, true);
        CarlifeTouchActionProto.CarlifeTouchAction.access$1002(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTouchActionProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */