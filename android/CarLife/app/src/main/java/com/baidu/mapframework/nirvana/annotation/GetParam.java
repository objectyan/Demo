package com.baidu.mapframework.nirvana.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.PARAMETER})
public @interface GetParam
{
  String optional() default "";
  
  String value();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/GetParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */