package com.google.protobuf;

public abstract interface RpcController
{
  public abstract String errorText();
  
  public abstract boolean failed();
  
  public abstract boolean isCanceled();
  
  public abstract void notifyOnCancel(RpcCallback<Object> paramRpcCallback);
  
  public abstract void reset();
  
  public abstract void setFailed(String paramString);
  
  public abstract void startCancel();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/RpcController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */