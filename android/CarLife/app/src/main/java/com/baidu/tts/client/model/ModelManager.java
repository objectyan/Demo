package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.d.b;
import com.baidu.tts.f.g;
import com.baidu.tts.l.a;
import java.util.Set;

public class ModelManager
{
  private a a;
  
  public ModelManager(Context paramContext)
  {
    this.a = new a(paramContext);
  }
  
  private Conditions a()
  {
    Conditions localConditions = new Conditions();
    LibEngineParams localLibEngineParams = getEngineParams();
    localConditions.setVersion(localLibEngineParams.getVersion());
    localConditions.setDomains(localLibEngineParams.getDomain());
    localConditions.setLanguages(localLibEngineParams.getLanguage());
    localConditions.setQualitys(localLibEngineParams.getQuality());
    return localConditions;
  }
  
  private Conditions a(AvailableConditions paramAvailableConditions)
  {
    Conditions localConditions = a();
    if ((localConditions != null) && (paramAvailableConditions != null))
    {
      localConditions.setSpeakers(paramAvailableConditions.getSpeakers());
      localConditions.setGenders(paramAvailableConditions.getGenders());
    }
    return localConditions;
  }
  
  public DownloadHandler download(String paramString, OnDownloadListener paramOnDownloadListener)
  {
    b localb = new b();
    localb.a(paramString);
    localb.a(paramOnDownloadListener);
    return this.a.a(localb);
  }
  
  public LibEngineParams getEngineParams()
  {
    return this.a.a();
  }
  
  public BasicHandler<ModelFileBags> getLocalModelFileInfos(Set<String> paramSet)
  {
    return this.a.b(paramSet);
  }
  
  public BasicHandler<ModelBags> getLocalModels(Conditions paramConditions)
  {
    return this.a.a(paramConditions, false);
  }
  
  public BasicHandler<ModelBags> getLocalModelsAvailable(AvailableConditions paramAvailableConditions)
  {
    paramAvailableConditions = a(paramAvailableConditions);
    return this.a.a(paramAvailableConditions, true);
  }
  
  public BasicHandler<ModelBags> getServerDefaultModels()
  {
    return this.a.b();
  }
  
  public BasicHandler<ModelFileBags> getServerModelFileInfos(Set<String> paramSet)
  {
    return this.a.a(paramSet);
  }
  
  public BasicHandler<ModelBags> getServerModels(Conditions paramConditions)
  {
    return this.a.a(paramConditions);
  }
  
  public BasicHandler<ModelBags> getServerModelsAvailable(AvailableConditions paramAvailableConditions)
  {
    return getServerModels(a(paramAvailableConditions));
  }
  
  public String getSpeechModelFileAbsPath(String paramString)
  {
    return this.a.a(g.s.b(), paramString);
  }
  
  public String getTextModelFileAbsPath(String paramString)
  {
    return this.a.a(g.r.b(), paramString);
  }
  
  public boolean isModelFileValid(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public boolean isModelValid(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public int stop()
  {
    this.a.c();
    return 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/ModelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */