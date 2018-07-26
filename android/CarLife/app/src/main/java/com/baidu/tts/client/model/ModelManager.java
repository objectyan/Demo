package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.p229d.C5061b;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p241l.C5120a;
import java.util.Set;

public class ModelManager {
    /* renamed from: a */
    private C5120a f20884a;

    public ModelManager(Context context) {
        this.f20884a = new C5120a(context);
    }

    public BasicHandler<ModelBags> getServerModels(Conditions conditions) {
        return this.f20884a.m17358a(conditions);
    }

    public BasicHandler<ModelBags> getLocalModels(Conditions conditions) {
        return this.f20884a.m17359a(conditions, false);
    }

    public LibEngineParams getEngineParams() {
        return this.f20884a.m17362a();
    }

    public BasicHandler<ModelBags> getServerModelsAvailable(AvailableConditions conditions) {
        return getServerModels(m17041a(conditions));
    }

    public BasicHandler<ModelBags> getLocalModelsAvailable(AvailableConditions conditions) {
        return this.f20884a.m17359a(m17041a(conditions), true);
    }

    /* renamed from: a */
    private Conditions m17041a(AvailableConditions availableConditions) {
        Conditions a = m17040a();
        if (!(a == null || availableConditions == null)) {
            a.setSpeakers(availableConditions.getSpeakers());
            a.setGenders(availableConditions.getGenders());
        }
        return a;
    }

    /* renamed from: a */
    private Conditions m17040a() {
        Conditions conditions = new Conditions();
        LibEngineParams engineParams = getEngineParams();
        conditions.setVersion(engineParams.getVersion());
        conditions.setDomains(engineParams.getDomain());
        conditions.setLanguages(engineParams.getLanguage());
        conditions.setQualitys(engineParams.getQuality());
        return conditions;
    }

    public boolean isModelFileValid(String fileId) {
        return this.f20884a.m17365a(fileId);
    }

    public boolean isModelValid(String modelId) {
        return this.f20884a.m17368b(modelId);
    }

    public String getTextModelFileAbsPath(String modelId) {
        return this.f20884a.m17363a(C5089g.TEXT_DATA_ID.m17274b(), modelId);
    }

    public String getSpeechModelFileAbsPath(String modelId) {
        return this.f20884a.m17363a(C5089g.SPEECH_DATA_ID.m17274b(), modelId);
    }

    public BasicHandler<ModelFileBags> getServerModelFileInfos(Set<String> fileIds) {
        return this.f20884a.m17360a((Set) fileIds);
    }

    public BasicHandler<ModelFileBags> getLocalModelFileInfos(Set<String> fileIds) {
        return this.f20884a.m17367b((Set) fileIds);
    }

    public BasicHandler<ModelBags> getServerDefaultModels() {
        return this.f20884a.m17366b();
    }

    public DownloadHandler download(String modelId, OnDownloadListener listener) {
        C5061b c5061b = new C5061b();
        c5061b.m17167a(modelId);
        c5061b.m17166a(listener);
        return this.f20884a.m17361a(c5061b);
    }

    public int stop() {
        this.f20884a.m17369c();
        return 0;
    }
}
