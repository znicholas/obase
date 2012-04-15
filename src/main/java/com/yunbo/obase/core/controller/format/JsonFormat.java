package com.yunbo.obase.core.controller.format;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang.ObjectUtils.Null;

@Target(value = { ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonFormat {
	public Class<?> contentType();
	public Class<?> targetType() default Null.class;
}
