package com.baidu.tts.l.a;

import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.LibEngineParams;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.l.a;
import java.util.Set;
import java.util.concurrent.FutureTask;

public class h
{
  private a a;
  
  public h(a parama)
  {
    this.a = parama;
  }
  
  public BasicHandler<ModelBags> a(Conditions paramConditions)
  {
    paramConditions = new BasicHandler(new FutureTask(new g(paramConditions)));
    paramConditions.start();
    return paramConditions;
  }
  
  public BasicHandler<ModelBags> a(Conditions paramConditions, boolean paramBoolean)
  {
    paramConditions = new BasicHandler(new FutureTask(new c(this.a.e(), paramConditions, this.a, paramBoolean)));
    paramConditions.start();
    return paramConditions;
  }
  
  public BasicHandler<ModelFileBags> a(Set<String> paramSet)
  {
    paramSet = new BasicHandler(new FutureTask(new f(paramSet)));
    paramSet.start();
    return paramSet;
  }
  
  public LibEngineParams a()
  {
    return new LibEngineParams(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
  }
  
  public BasicHandler<ModelBags> b()
  {
    BasicHandler localBasicHandler = new BasicHandler(new FutureTask(new e()));
    localBasicHandler.start();
    return localBasicHandler;
  }
  
  public BasicHandler<ModelFileBags> b(Set<String> paramSet)
  {
    paramSet = new BasicHandler(new FutureTask(new b(this.a.e(), paramSet)));
    paramSet.start();
    return paramSet;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/l/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */