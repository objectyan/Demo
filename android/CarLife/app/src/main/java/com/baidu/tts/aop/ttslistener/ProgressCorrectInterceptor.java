package com.baidu.tts.aop.ttslistener;

import android.text.TextUtils;
import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.m.h;
import com.baidu.tts.m.i;
import java.lang.reflect.Method;
import java.util.List;

public class ProgressCorrectInterceptor
  extends AInterceptor
{
  protected Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = (h)paramArrayOfObject[0];
    int j;
    int k;
    if (paramObject != null)
    {
      paramMethod = ((h)paramObject).e().b();
      if (!TextUtils.isEmpty(paramMethod))
      {
        j = paramMethod.length();
        k = ((h)paramObject).c();
        if (k <= j) {
          break label109;
        }
      }
    }
    label109:
    for (int i = k - j;; i = 0)
    {
      LoggerProxy.d("ProgressCorrectInterceptor", "prefixLength=" + j + "--progress=" + k);
      paramObject = (h)((h)paramObject).B();
      ((h)paramObject).d(i);
      paramArrayOfObject[0] = paramObject;
      return AInterceptorHandler.DEFAULT;
    }
  }
  
  protected void a()
  {
    this.a.add("onSynthesizeDataArrived");
    this.a.add("onPlayProgressUpdate");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/aop/ttslistener/ProgressCorrectInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */