package com.zl.dubbo.controller;

import com.zl.dubbo.orderapi.model.RpcResult;
import com.zl.dubbo.orderapi.service.OrderDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zl
 * @date 2021/12/20
 */
@RestController()
@RequestMapping("/consumer")
public class ConsumerController {
    @DubboReference
    OrderDubboService orderDubboService;

    @GetMapping("getOrder")
    public RpcResult getOrder() {
        return orderDubboService.getHelloWord();
    }
}
