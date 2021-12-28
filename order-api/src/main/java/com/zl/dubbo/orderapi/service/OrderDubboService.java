package com.zl.dubbo.orderapi.service;

import com.zl.dubbo.orderapi.model.RpcResult;

/**
 *
 * @author zl
 * @date 2021/12/20
 */
public interface OrderDubboService {
    RpcResult<String> getHelloWord();
}
