package com.yoon.eiheihei.hessian.impl;

import com.yoon.eiheihei.hessian.HessianService;

/**
 * Hessian服务的实现类
 *
 * @author yinkai
 */
public class HessianServiceImpl implements HessianService {
    @Override
    public String sayHello(String str) {
        return "This is Hello words from HESSIAN Server." + str;
    }
}
