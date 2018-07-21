package com.baidu.mapframework.nirvana.annotation.a;

import com.baidu.mapframework.nirvana.annotation.GetParam;
import com.baidu.mapframework.nirvana.annotation.POST;
import com.baidu.mapframework.nirvana.annotation.PostParam;
import com.baidu.mapframework.nirvana.annotation.RegisterRequest;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

public class j
  extends AbstractProcessor
{
  private Filer a;
  private Messager b;
  
  public Set<String> a()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.add(POST.class.getCanonicalName());
    localLinkedHashSet.add(RegisterRequest.class.getCanonicalName());
    localLinkedHashSet.add(GetParam.class.getCanonicalName());
    localLinkedHashSet.add(PostParam.class.getCanonicalName());
    return localLinkedHashSet;
  }
  
  public void a(ProcessingEnvironment paramProcessingEnvironment)
  {
    try
    {
      super.init(paramProcessingEnvironment);
      this.a = paramProcessingEnvironment.getFiler();
      this.b = paramProcessingEnvironment.getMessager();
      return;
    }
    finally
    {
      paramProcessingEnvironment = finally;
      throw paramProcessingEnvironment;
    }
  }
  
  public boolean a(Set<? extends TypeElement> paramSet, RoundEnvironment paramRoundEnvironment)
  {
    paramSet = paramRoundEnvironment.getElementsAnnotatedWith(RegisterRequest.class).iterator();
    while (paramSet.hasNext()) {
      new g((Element)paramSet.next(), this.b, this.a).a();
    }
    return true;
  }
  
  public SourceVersion b()
  {
    return SourceVersion.RELEASE_7;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */