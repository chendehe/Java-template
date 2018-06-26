package com.chendehe.template.java.jdk8;

/**
 * 可在接口中定义 default 和 static 方法，子类可以继承这些方法.
 */
public interface DefaultFunctionInterface {

  default String defaultFunction() {
    return "default function";
  }

  static String staticFunction() {
    return "static function";
  }
}
