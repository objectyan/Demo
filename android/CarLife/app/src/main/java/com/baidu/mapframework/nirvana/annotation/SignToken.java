package com.baidu.mapframework.nirvana.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface SignToken {

    public enum SignTokenType {
        NONE,
        MAP_PHPUI,
        MAP_UGC,
        POI_LIKE,
        FILE_UPLOAD
    }

    SignTokenType value() default SignTokenType.MAP_PHPUI;
}
