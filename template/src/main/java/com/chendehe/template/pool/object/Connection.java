package com.chendehe.template.pool.object;

public class Connection {

  public Connection() {
    System.out.println("创建了连接对象");
  }

  public void open() {
    System.out.println("打开了数据库连接");
  }

  public void close() {
    System.out.println("关闭了数据库连接");
  }
}  