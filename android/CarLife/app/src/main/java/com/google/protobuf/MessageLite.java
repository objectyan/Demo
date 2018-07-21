package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface MessageLite
{
  public abstract MessageLite getDefaultInstanceForType();
  
  public abstract int getSerializedSize();
  
  public abstract boolean isInitialized();
  
  public abstract Builder newBuilderForType();
  
  public abstract Builder toBuilder();
  
  public abstract byte[] toByteArray();
  
  public abstract ByteString toByteString();
  
  public abstract void writeDelimitedTo(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract void writeTo(CodedOutputStream paramCodedOutputStream)
    throws IOException;
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
  
  public static abstract interface Builder
    extends Cloneable
  {
    public abstract MessageLite build();
    
    public abstract MessageLite buildPartial();
    
    public abstract Builder clear();
    
    public abstract Builder clone();
    
    public abstract MessageLite getDefaultInstanceForType();
    
    public abstract boolean isInitialized();
    
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
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/MessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */