package com.chendehe.template.designpatterns.proxy.entity;

public class PersonDao implements IPersonDao {
  @Override
  public void save() {
    System.out.println("----已经保存人员数据!----");
  }
}
