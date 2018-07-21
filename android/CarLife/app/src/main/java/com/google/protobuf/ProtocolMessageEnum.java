package com.google.protobuf;

public abstract interface ProtocolMessageEnum
  extends Internal.EnumLite
{
  public abstract Descriptors.EnumDescriptor getDescriptorForType();
  
  public abstract int getNumber();
  
  public abstract Descriptors.EnumValueDescriptor getValueDescriptor();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/ProtocolMessageEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */