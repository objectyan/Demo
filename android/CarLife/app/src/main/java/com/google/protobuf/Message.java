package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public abstract interface Message
  extends MessageLite
{
  public abstract boolean equals(Object paramObject);
  
  public abstract Map<Descriptors.FieldDescriptor, Object> getAllFields();
  
  public abstract Message getDefaultInstanceForType();
  
  public abstract Descriptors.Descriptor getDescriptorForType();
  
  public abstract Object getField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt);
  
  public abstract int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract UnknownFieldSet getUnknownFields();
  
  public abstract boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor);
  
  public abstract int hashCode();
  
  public abstract Builder newBuilderForType();
  
  public abstract Builder toBuilder();
  
  public abstract String toString();
  
  public static abstract interface Builder
    extends MessageLite.Builder
  {
    public abstract Builder addRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject);
    
    public abstract Message build();
    
    public abstract Message buildPartial();
    
    public abstract Builder clear();
    
    public abstract Builder clearField(Descriptors.FieldDescriptor paramFieldDescriptor);
    
    public abstract Builder clone();
    
    public abstract Map<Descriptors.FieldDescriptor, Object> getAllFields();
    
    public abstract Message getDefaultInstanceForType();
    
    public abstract Descriptors.Descriptor getDescriptorForType();
    
    public abstract Object getField(Descriptors.FieldDescriptor paramFieldDescriptor);
    
    public abstract Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt);
    
    public abstract int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor);
    
    public abstract UnknownFieldSet getUnknownFields();
    
    public abstract boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor);
    
    public abstract Builder mergeDelimitedFrom(InputStream paramInputStream)
      throws IOException;
    
    public abstract Builder mergeDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException;
    
    public abstract Builder mergeFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException;
    
    public abstract Builder mergeFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException;
    
    public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream)
      throws IOException;
    
    public abstract Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException;
    
    public abstract Builder mergeFrom(Message paramMessage);
    
    public abstract Builder mergeFrom(InputStream paramInputStream)
      throws IOException;
    
    public abstract Builder mergeFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException;
    
    public abstract Builder mergeFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException;
    
    public abstract Builder mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws InvalidProtocolBufferException;
    
    public abstract Builder mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException;
    
    public abstract Builder mergeFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException;
    
    public abstract Builder mergeUnknownFields(UnknownFieldSet paramUnknownFieldSet);
    
    public abstract Builder newBuilderForField(Descriptors.FieldDescriptor paramFieldDescriptor);
    
    public abstract Builder setField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject);
    
    public abstract Builder setRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt, Object paramObject);
    
    public abstract Builder setUnknownFields(UnknownFieldSet paramUnknownFieldSet);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */