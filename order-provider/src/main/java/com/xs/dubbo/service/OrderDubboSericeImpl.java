package com.xs.dubbo.service;

import com.xs.dubbo.orderapi.model.RpcResult;
import com.xs.dubbo.orderapi.service.OrderDubboService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 *
 * @author zl
 * @date 2021/12/20
 */
@DubboService()
public class OrderDubboSericeImpl implements OrderDubboService {

    @Override
    public RpcResult<String> getHelloWord() {
        return RpcResult.success("hello world");
    }
}
