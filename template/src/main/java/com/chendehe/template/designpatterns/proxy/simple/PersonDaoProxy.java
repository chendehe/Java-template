package com.chendehe.template.designpatterns.proxy.simple;

import com.chendehe.template.designpatterns.proxy.entity.IPersonDao;

/**
 * 代理对象,静态代理
 */
public class PersonDaoProxy implements IPersonDao {
  //接收保存目标对象
  private IPersonDao target;

  public PersonDaoProxy(IPersonDao target) {
    this.target = target;
  }

  @Override
  public void save() {
    System.out.println("开始事务...");
    target.save();//执行目标对象的方法
    System.out.println("提交事务...");
  }
}