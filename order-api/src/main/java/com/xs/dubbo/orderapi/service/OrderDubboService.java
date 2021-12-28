package com.xs.dubbo.orderapi.service;

import com.xs.dubbo.orderapi.model.RpcResult;

public interface OrderDubboService {
    RpcResult<String> getHelloWord();
}
