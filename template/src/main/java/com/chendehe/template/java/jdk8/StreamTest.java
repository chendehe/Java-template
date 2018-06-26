package com.chendehe.template.java.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream测试类
 */
public class StreamTest {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("p", "fds", "o", "aaa", "k");

    List<String> result = list.stream()
        //.parallel()
        .filter(e -> e.length() >= 3)
        .map(e -> e.charAt(0))
        //.peek(System.out :: println)
        //.sorted()
        //.peek(e -> System.out.println("++++" + e))
        .map(e -> String.valueOf(e))
        .collect(Collectors.toList());
    System.out.println("----------------------------");
    System.out.println(result);
  }
}
