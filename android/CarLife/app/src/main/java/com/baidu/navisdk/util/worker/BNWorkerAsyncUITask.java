package com.baidu.navisdk.util.worker;

public abstract class BNWorkerAsyncUITask<Params, Progress, Result> {
    public abstract Result doInBackground(Params... paramsArr);

    public void onPostExecute(Result result) {
    }
}
