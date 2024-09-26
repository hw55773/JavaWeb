package com.whkxdk.anonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//注解什么时候生效
@Target(ElementType.METHOD)//注解的作用范围
public @interface Myanonation {
}
