package com.chendehe.template.java.jdk8;

import java.util.Arrays;

/**
 * Lambda测试类
 */
public class LambdaTest {

  public static void main(String[] args) {
    Arrays.asList("p", "k", "u", "f", "o", "r", "k").forEach(System.out::print);
  }
}
