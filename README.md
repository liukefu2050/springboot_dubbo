# springboot_dubbo
springboot dubbo 实现简易微服务，相对于springcloud 要简单很多

适用于项目类需求

#### dubbo 接口
```java
package com.xs.dubbo.orderapi.service;

import com.xs.dubbo.orderapi.model.RpcResult;

public interface OrderDubboService {
    RpcResult<String> getHelloWord();
}

```

#### dubbo 接口provider
```java
package com.xs.dubbo.service;

import com.xs.dubbo.orderapi.model.RpcResult;
import com.xs.dubbo.orderapi.service.OrderDubboService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService()
public class OrderDubboSericeImpl implements OrderDubboService {

    @Override
    public RpcResult<String> getHelloWord() {
        return RpcResult.success("hello world");
    }
}

```

#### dubbo 接口使用

```java
package com.xs.dubbo.controller;

import com.xs.dubbo.orderapi.model.RpcResult;
import com.xs.dubbo.orderapi.service.OrderDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


```

### dubbo 配置相关

#### Consumer 配置
```
# dubbo 相关配置
dubbo:
  application:
    name: order-consumer
  registry:
    address: zookeeper://192.168.29.12:2181

```

#### Provider 配置
    
```
# dubbo 相关配置(dubbo 的配置不再以 Spring 开头)
dubbo:
  application:
    # 应用名称
    name: order-provider
  scan:
    # 接口实现者（服务实现）包
     base-packages: com.xs.dubbo.service
  # 注册中心信息
  registry:
    address: zookeeper://192.168.29.12:2181
  protocol:
    # 协议名称
    name: dubbo
    # 协议端口
    port: 20880
```    
