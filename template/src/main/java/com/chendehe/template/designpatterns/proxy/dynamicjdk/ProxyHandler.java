package com.chendehe.template.designpatterns.proxy.dynamicjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

  private Object target;

  public ProxyHandler(Object target) {
    this.target = target;
  }

  @SuppressWarnings("unchecked")
  public <T> T proxy() {
    return (T) Proxy.newProxyInstance(
        target.getClass().getClassLoader(),
        target.getClass().getInterfaces(),
        this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("开始");
    Object object = method.invoke(target, args);
    System.out.println("结束");
    return object;
  }
}
