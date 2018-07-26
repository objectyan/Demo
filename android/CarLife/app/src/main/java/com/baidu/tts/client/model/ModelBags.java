package com.baidu.tts.client.model;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ModelBags {
    /* renamed from: a */
    private TtsError f20863a;
    /* renamed from: b */
    private List<ModelInfo> f20864b;

    public TtsError getTtsError() {
        return this.f20863a;
    }

    public void setTtsError(TtsError ttsError) {
        this.f20863a = ttsError;
    }

    public List<ModelInfo> getModelInfos() {
        return this.f20864b;
    }

    public void setModelInfos(List<ModelInfo> modelInfos) {
        this.f20864b = modelInfos;
    }

    public void addModelInfo(ModelInfo modelInfo) {
        if (this.f20864b == null) {
            this.f20864b = new ArrayList();
        }
        this.f20864b.add(modelInfo);
    }

    public void setList(List<Map<String, String>> list) {
        if (list != null) {
            List arrayList = new ArrayList();
            for (Map map : list) {
                ModelInfo modelInfo = new ModelInfo();
                modelInfo.setMap(map);
                arrayList.add(modelInfo);
            }
            this.f20864b = arrayList;
        }
    }

    public boolean isEmpty() {
        return DataTool.isListEmpty(this.f20864b);
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        if (!isEmpty()) {
            for (ModelInfo toJson : this.f20864b) {
                jSONArray.put(toJson.toJson());
            }
        }
        return jSONArray;
    }

    public void parseJson(JSONArray ja) {
        int length = ja.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = ja.optJSONObject(i);
            ModelInfo modelInfo = new ModelInfo();
            modelInfo.parseJson(optJSONObject);
            addModelInfo(modelInfo);
        }
    }
}
