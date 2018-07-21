package com.google.protobuf;

public final class RpcUtil
{
  private static <Type extends Message> Type copyAsType(Type paramType, Message paramMessage)
  {
    return paramType.newBuilderForType().mergeFrom(paramMessage).build();
  }
  
  public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> paramRpcCallback, Class<Type> paramClass, final Type paramType)
  {
    new RpcCallback()
    {
      public void run(Message paramAnonymousMessage)
      {
        try
        {
          Message localMessage = (Message)this.val$originalClass.cast(paramAnonymousMessage);
          paramAnonymousMessage = localMessage;
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            paramAnonymousMessage = RpcUtil.copyAsType(paramType, paramAnonymousMessage);
          }
        }
        paramRpcCallback.run(paramAnonymousMessage);
      }
    };
  }
  
  public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(RpcCallback<ParameterType> paramRpcCallback)
  {
    new RpcCallback()
    {
      private boolean alreadyCalled = false;
      
      public void run(ParameterType paramAnonymousParameterType)
      {
        try
        {
          if (this.alreadyCalled) {
            throw new RpcUtil.AlreadyCalledException();
          }
        }
        finally {}
        this.alreadyCalled = true;
        this.val$originalCallback.run(paramAnonymousParameterType);
      }
    };
  }
  
  public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> paramRpcCallback)
  {
    return paramRpcCallback;
  }
  
  public static final class AlreadyCalledException
    extends RuntimeException
  {
    private static final long serialVersionUID = 5469741279507848266L;
    
    public AlreadyCalledException()
    {
      super();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/RpcUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */