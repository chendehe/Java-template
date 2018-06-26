package com.chendehe.template.pool.object;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

//链接工厂，池子的一些方法由我们实现
public class ConnectionFactory extends BasePooledObjectFactory<Connection> {

  // 创建对象
  @Override
  public Connection create() throws Exception {
    System.out.println("工厂创建了对象");
    return new Connection();
  }

  // 包装对象
  @Override
  public PooledObject<Connection> wrap(Connection arg0) {
    System.out.println("工厂包装对象");
    return new DefaultPooledObject<Connection>(arg0);
  }

  // 在获取对象返回之前可以进行的操作
  @Override
  public void activateObject(PooledObject<Connection> p) throws Exception {
    p.getObject().open();
    super.activateObject(p);
  }

  // 在归还对象之前可以进行的操作
  @Override
  public void passivateObject(PooledObject<Connection> p) throws Exception {
    p.getObject().close();
    super.passivateObject(p);
  }
}  