package org.intellij.lang.annotations;

import java.lang.annotation.Annotation;

@Pattern("(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*")
public @interface PrintFormat {}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/org/intellij/lang/annotations/PrintFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */