package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ModelFileBags {
    /* renamed from: a */
    private TtsError f20865a;
    /* renamed from: b */
    private List<ModelFileInfo> f20866b;

    public List<ModelFileInfo> getModelFileInfos() {
        return this.f20866b;
    }

    public TtsError getTtsError() {
        return this.f20865a;
    }

    public void setTtsError(TtsError ttsError) {
        this.f20865a = ttsError;
    }

    public void setModelFileInfos(List<ModelFileInfo> modelFileInfos) {
        this.f20866b = modelFileInfos;
    }

    public void addFileInfo(ModelFileInfo fileInfo) {
        if (this.f20866b == null) {
            this.f20866b = new ArrayList();
        }
        this.f20866b.add(fileInfo);
    }

    public void setList(List<Map<String, String>> list) {
        if (list != null && !list.isEmpty()) {
            List arrayList = new ArrayList();
            for (Map map : list) {
                ModelFileInfo modelFileInfo = new ModelFileInfo();
                modelFileInfo.setMap(map);
                arrayList.add(modelFileInfo);
            }
            this.f20866b = arrayList;
        }
    }

    public void generateAbsPath(Context context) {
        if (this.f20866b != null) {
            for (ModelFileInfo generateAbsPath : this.f20866b) {
                generateAbsPath.generateAbsPath(context);
            }
        }
    }

    public ModelFileInfo getModelFileInfo(int index) {
        if (this.f20866b != null) {
            return (ModelFileInfo) this.f20866b.get(index);
        }
        return null;
    }

    public String getUrl(int index) {
        ModelFileInfo modelFileInfo = getModelFileInfo(index);
        if (modelFileInfo != null) {
            return modelFileInfo.getUrl();
        }
        return null;
    }

    public boolean isEmpty() {
        return DataTool.isListEmpty(this.f20866b);
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        if (!isEmpty()) {
            for (ModelFileInfo toJson : this.f20866b) {
                jSONArray.put(toJson.toJson());
            }
        }
        return jSONArray;
    }

    public void parseJson(JSONArray ja) {
        int length = ja.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = ja.optJSONObject(i);
            ModelFileInfo modelFileInfo = new ModelFileInfo();
            modelFileInfo.parseJson(optJSONObject);
            addFileInfo(modelFileInfo);
        }
    }
}
