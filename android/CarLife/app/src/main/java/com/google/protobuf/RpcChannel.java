package com.google.protobuf;

public abstract interface RpcChannel
{
  public abstract void callMethod(Descriptors.MethodDescriptor paramMethodDescriptor, RpcController paramRpcController, Message paramMessage1, Message paramMessage2, RpcCallback<Message> paramRpcCallback);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/RpcChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */