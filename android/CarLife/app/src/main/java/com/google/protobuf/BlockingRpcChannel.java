package com.google.protobuf;

public abstract interface BlockingRpcChannel
{
  public abstract Message callBlockingMethod(Descriptors.MethodDescriptor paramMethodDescriptor, RpcController paramRpcController, Message paramMessage1, Message paramMessage2)
    throws ServiceException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/BlockingRpcChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */