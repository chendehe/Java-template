package com.chendehe.template.java.jdk8;

import com.chendehe.template.java.jdk8.entity.Student;
import java.util.Optional;

/**
 * Optional测试类
 */
public class OptionalTest {

  public static void main(String[] args) {
    Student s = new Student();
    s.setName("sdad");
    System.out.println(getName(s));
  }

  public static String getName(Student u) {
    return Optional.ofNullable(u)
        .map(Student::getName)
        .orElse("Unknown");
  }
}
