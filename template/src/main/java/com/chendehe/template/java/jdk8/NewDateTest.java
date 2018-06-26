package com.chendehe.template.java.jdk8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class NewDateTest {

  public static void main(String[] args) {
    // 取当前日期：
    LocalDate today = LocalDate.now(); // -> 2014-12-24
    // 根据年月日取日期，12月就是12：
    LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25
    // 根据字符串取：
    // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
    LocalDate endOfFeb = LocalDate.parse("2014-02-28");
    // 无效日期无法通过：DateTimeParseException: Invalid date
    LocalDate.parse("2014-02-29");

    // 取本月第1天：
    LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
    // 取本月第2天：
    LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2014-12-02
    // 取本月最后一天，再也不用计算是28，29，30还是31：
    LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
    // 取下一天：
    LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01
    // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
    LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05
  }
}
