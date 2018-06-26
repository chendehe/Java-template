package com.chendehe.template.java.jdk8;

import com.chendehe.template.java.jdk8.entity.Student;
import com.chendehe.template.java.jdk8.entity.StudentComparator;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用测试类、配合Lambda
 */
public class MethodReference {

  public static void main(String[] args) {
    Student student1 = new Student("zhangsan", 60);
    Student student3 = new Student("wangwu", 80);
    Student student2 = new Student("lisi", 70);
    Student student4 = new Student("zhaoliu", 90);
    List<Student> students = Arrays.asList(student1, student2, student3, student4);
    //无参构造器
    Supplier<Student> supplier = Student::new;
    //静态方法
    students.sort(Student::compareStudentByScore);
    //特定类的任意对象方法引用
    students.sort(new StudentComparator()::compareStudentByScore);
    //特定对象的方法引用
    students.sort(Student::compareByScore);
  }

}
