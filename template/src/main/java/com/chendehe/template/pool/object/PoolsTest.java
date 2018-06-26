package com.chendehe.template.pool.object;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

//测试
public class PoolsTest {

  public static void main(String[] args) {
    // 池子配置文件
    GenericObjectPoolConfig config = new GenericObjectPoolConfig();
    config.setMaxTotal(50);// 整个池最大值
    config.setMaxIdle(8);// 最大空闲
    config.setMinIdle(0);// 最小空闲
    config.setMaxWaitMillis(2000);// 最大等待时间，-1表示一直等
    config.setBlockWhenExhausted(true);// 当对象池没有空闲对象时，新的获取对象的请求是否阻塞。true阻塞。默认值是true
    config.setTestOnBorrow(false);// 在从对象池获取对象时是否检测对象有效，true是；默认值是false
    config.setTestOnReturn(false);// 在向对象池中归还对象时是否检测对象有效，true是，默认值是false
    config.setTestWhileIdle(false);// 在检测空闲对象线程检测到对象不需要移除时，是否检测对象的有效性。true是，默认值是false
    config.setMinEvictableIdleTimeMillis(10 * 60000L); // 可发呆的时间,10mins
    config.setTestWhileIdle(false); // 发呆过长移除的时候是否test一下先

    GenericObjectPool<Connection> pool = new GenericObjectPool<>(new ConnectionFactory(), config);

    // 线程池测试
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    for (int i = 0; i < 15; i++) {
      final int index = i;
      cachedThreadPool.execute(new Runnable() {
        public void run() {
          Connection connection = null;
          try {
            connection = pool.borrowObject();
            System.out.println("第" + index + "次获取到了连接对象---------" + connection);
            System.err.println("当前线程池活跃对象数：" + pool.getNumActive());
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            pool.returnObject(connection);
          }
        }
      });
    }
    cachedThreadPool.shutdown();
    try {
      while (!cachedThreadPool.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
        System.out.println("5秒没有执行完，强制关闭线程池");
        cachedThreadPool.shutdownNow();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}  