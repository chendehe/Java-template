package com.chendehe.template.java.jdk8.entity;

public class Student {
  private String name;
  private int score;

  public Student() {
    System.out.println("new Student");
  }

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public static int compareStudentByScore(Student student1, Student student2) {
    return student1.getScore() - student2.getScore();
  }

  public int compareByScore(Student student) {
    return this.getScore() - student.getScore();
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", score=" + score +
        '}';
  }
}