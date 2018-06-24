package com.chendehe.template.designpatterns.proxy.dynamiccglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor {

  @SuppressWarnings("unchecked")
  public <T> T proxy(Class<T> cls) {
    return (T) Enhancer.create(cls, this);
  }

  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

    System.out.println("开始CGLib");
    Object result = proxy.invokeSuper(obj, args);
    System.out.println("结束CGLib");
    return result;
  }
}
