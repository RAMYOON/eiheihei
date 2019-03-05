package com.yoon.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.yoon.eiheihei.hessian.HessianService;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Hessian客户端测试
 *
 * @author yinkai
 */
public class HessianBasicClient {

    @Test
    public void basicHello() {
        try {
            String url = "http://localhost:8080/eiheihei/hessian";
            HessianProxyFactory factory = new HessianProxyFactory();
            factory.setOverloadEnabled(true);
            HessianService basic = (HessianService) factory.create(HessianService.class, url);
            System.out.println(basic.sayHello("alsdjfl;asdjf"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
