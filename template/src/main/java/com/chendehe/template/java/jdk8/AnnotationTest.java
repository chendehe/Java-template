package com.chendehe.template.java.jdk8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 重复注解、注解扩展
 */
public class AnnotationTest {
  @Authority(role = "Admin")
  @Authority(role = "Manager")
  public void doSomeThing() {
  }

  public static class Holder<@NonEmpty T> extends @NonEmpty Object {
    public void method() throws @NonEmpty Exception {
    }
  }
}

/**
 * 重复注解
 */
@Repeatable(Authorities.class)
@interface Authority {
  String role();
}

@interface Authorities {
  Authority[] value();
}

/**
 * 注解扩展
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@interface NonEmpty {
}
