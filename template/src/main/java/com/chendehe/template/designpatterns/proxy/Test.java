package com.chendehe.template.designpatterns.proxy;

import com.chendehe.template.designpatterns.proxy.dynamiccglib.CGLibProxy;
import com.chendehe.template.designpatterns.proxy.entity.IPersonDao;
import com.chendehe.template.designpatterns.proxy.entity.PersonDao;
import com.chendehe.template.designpatterns.proxy.dynamicjdk.ProxyHandler;
import com.chendehe.template.designpatterns.proxy.simple.PersonDaoProxy;

public class Test {

  public static void main(String[] args) {
    //静态代理
    PersonDaoProxy proxy = new PersonDaoProxy(new PersonDao());
    proxy.save();
    //JDK动态代理
    IPersonDao ipersonDao = new ProxyHandler(new PersonDao()).proxy();
    ipersonDao.save();
    //CGLib动态代理
    PersonDao personDao = new CGLibProxy().proxy(PersonDao.class);
    personDao.save();
  }
}
