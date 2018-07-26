package com.baidu.tts.client.model;

import com.baidu.navi.track.database.DataService;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p241l.C5120a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class RecordData {
    /* renamed from: a */
    ExecutorService f20889a = Executors.newSingleThreadExecutor();
    /* renamed from: b */
    private C5120a f20890b;

    public class InsertData implements Callable<Integer> {
        /* renamed from: a */
        final /* synthetic */ RecordData f20885a;
        /* renamed from: b */
        private JSONObject f20886b;
        /* renamed from: c */
        private String f20887c;
        /* renamed from: d */
        private String f20888d;

        public InsertData(RecordData recordData, JSONObject jsonObject, String uuid, String columnName) {
            this.f20885a = recordData;
            this.f20886b = jsonObject;
            this.f20887c = uuid;
            this.f20888d = columnName;
        }

        public Integer call() throws Exception {
            if (this.f20886b == null && this.f20888d == null) {
                this.f20885a.f20890b.m17370c(this.f20887c);
            } else {
                this.f20885a.f20890b.m17364a(this.f20887c, this.f20888d, this.f20886b.toString());
            }
            return Integer.valueOf(0);
        }
    }

    public RecordData(C5120a modelMediator) {
        this.f20890b = modelMediator;
    }

    public void setStartInfo(String uuid, String modeId, String startTime) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DataService.EXTRA_START_TIME, startTime);
            jSONObject.put("modeId", modeId);
            LoggerProxy.m17001d("RecordData", " StartInfo json= " + jSONObject.toString());
            this.f20889a.submit(new InsertData(this, null, uuid, null));
            this.f20889a.submit(new InsertData(this, jSONObject, uuid, "startInfo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setEndInfo(String uuid, String modeId, int result, String endTime) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("modeId", modeId);
            jSONObject.put("result", result);
            jSONObject.put("endTime", endTime);
            LoggerProxy.m17001d("RecordData", "EndInfo json= " + jSONObject.toString());
            this.f20889a.submit(new InsertData(this, jSONObject, uuid, "endInfo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
