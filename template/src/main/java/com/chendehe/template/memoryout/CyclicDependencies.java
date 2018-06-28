package com.chendehe.template.memoryout;

import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/kl28978113/article/details/53817827
 * 1、定义静态变量HashMap
 * 2、分段循环创建对象，并加入HashMap
 * 启动参数：-Xms512m -Xmx512m -XX:-UseGCOverheadLimit -XX:MaxPermSize=50m
 */
public class CyclicDependencies {
  //声明缓存对象
  private static final Map<String, TestMemory> map = new HashMap<>();

  public static void main(String args[]) {
    try {
      Thread.sleep(10000);//给打开visualvm时间
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //循环添加对象到缓存
    for (int i = 0; i < 1000000; i++) {
      TestMemory t = new TestMemory();
      map.put("key" + i, t);
    }
    System.out.println("first");
    //为dump出堆提供时间
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < 1000000; i++) {
      TestMemory t = new TestMemory();
      map.put("key" + i, t);
    }
    System.out.println("second");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < 3000000; i++) {
      TestMemory t = new TestMemory();
      map.put("key" + i, t);
    }
    System.out.println("third");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < 4000000; i++) {
      TestMemory t = new TestMemory();
      map.put("key" + i, t);
    }
    System.out.println("forth");
    try {
      Thread.sleep(Integer.MAX_VALUE);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("qqqq");
  }

  private static class TestMemory {
  }
}