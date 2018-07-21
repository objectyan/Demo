package org.intellij.lang.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jetbrains.annotations.NonNls;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
public @interface Flow
{
  @NonNls
  public static final String DEFAULT_SOURCE = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";
  @NonNls
  public static final String DEFAULT_TARGET = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";
  @NonNls
  public static final String RETURN_METHOD_TARGET = "The return value of this method";
  @NonNls
  public static final String THIS_SOURCE = "this";
  @NonNls
  public static final String THIS_TARGET = "this";
  
  String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";
  
  boolean sourceIsContainer() default false;
  
  String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";
  
  boolean targetIsContainer() default false;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/intellij/lang/annotations/Flow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */