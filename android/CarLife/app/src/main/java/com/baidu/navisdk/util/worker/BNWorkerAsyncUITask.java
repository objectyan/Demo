package com.baidu.navisdk.util.worker;

public abstract class BNWorkerAsyncUITask<Params, Progress, Result>
{
  public abstract Result doInBackground(Params... paramVarArgs);
  
  public void onPostExecute(Result paramResult) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/worker/BNWorkerAsyncUITask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */