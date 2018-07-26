package com.baidu.navi.utils.http;

import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONObject;

public abstract class BaseTask {
    protected BaseHttpClient mHttpClient = new BaseHttpClient();
    protected ReqParams mReqParams = new ReqParams();
    protected JsonRspHandler mRspHandler;
    private TaskCallback mTaskCallback;
    protected Thread mThread;

    /* renamed from: com.baidu.navi.utils.http.BaseTask$1 */
    class C39841 extends JsonRspHandler {
        C39841() {
        }

        public void onSuccess(Object obj) {
            JSONResult jssonResult = BaseTask.this.parseBaseTaskJsonReslut((JSONObject) obj);
            if (jssonResult == null) {
                onFailure(new Throwable("get json result fail"));
            } else if (jssonResult.error != 0) {
                onFailure(new Throwable("the query result is error for the value of error is not equal 0"));
            } else if (jssonResult.data == null) {
                onFailure(new Throwable("can not get the data object"));
            } else {
                Object dataObj = BaseTask.this.parseData(jssonResult.data);
                if (dataObj == null) {
                    onFailure(new Throwable("parse json data fail"));
                } else if (BaseTask.this.mTaskCallback != null) {
                    BaseTask.this.mTaskCallback.onSuccess(dataObj);
                }
            }
        }

        public void onFailure(Throwable e) {
            if (BaseTask.this.mTaskCallback != null) {
                BaseTask.this.mTaskCallback.onFailure(e);
            }
        }

        public void onFinish() {
            if (BaseTask.this.mTaskCallback != null) {
                BaseTask.this.mTaskCallback.onFinish();
            }
        }
    }

    public class JSONResult {
        public Object data;
        public int error;
    }

    public interface TaskCallback<T> {
        void onFailure(Throwable th);

        void onFinish();

        void onSuccess(T t);
    }

    protected abstract String getServerUrl();

    protected abstract JSONResult parseBaseTaskJsonReslut(JSONObject jSONObject);

    protected abstract Object parseData(Object obj);

    public BaseTask() {
        this.mReqParams.putSimpleValue(new BaseParamBean().toValuePair());
        this.mHttpClient.addGZIPSupport();
        this.mRspHandler = new C39841();
    }

    public void setResponseCharset(String charset) {
        this.mRspHandler.setCharset(charset);
    }

    public void execute() {
        this.mThread = new Thread(getClass().getSimpleName()) {
            public void run() {
                if (NaviAccountUtils.getInstance().isLogin()) {
                    BaseTask.this.mReqParams.putSimpleValue("BDUSS", NaviAccountUtils.getInstance().syncGetBduss());
                } else {
                    LogUtil.m15791e("BDUSS", "has not login");
                }
                BaseTask.this.mHttpClient.post(BaseTask.this.getServerUrl(), BaseTask.this.mReqParams, BaseTask.this.mRspHandler);
            }
        };
        this.mThread.start();
    }

    protected void addNamePair(String name, String value) {
        if (this.mReqParams != null) {
            this.mReqParams.putSimpleValue(name, value);
        }
    }

    public void setTaskCallBack(TaskCallback callback) {
        this.mTaskCallback = callback;
    }

    public JsonRspHandler getRspHandler() {
        return this.mRspHandler;
    }

    public void stop() {
        if (this.mRspHandler != null) {
            this.mRspHandler.stop();
        }
        if (this.mThread != null) {
            this.mThread.interrupt();
        }
    }
}
