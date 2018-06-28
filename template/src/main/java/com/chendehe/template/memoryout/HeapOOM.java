package com.chendehe.template.memoryout;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出
 * 启动参数：-Xms100m -Xmx100m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:\CODE\log\java_heapdump.hprof
 */
public class HeapOOM {
  private static class OOMObject {

  }

  public static void main(String[] args) throws Exception {
    List<OOMObject> list = new ArrayList<>();

    while (true) {
      list.add(new OOMObject());
    }
  }
}
