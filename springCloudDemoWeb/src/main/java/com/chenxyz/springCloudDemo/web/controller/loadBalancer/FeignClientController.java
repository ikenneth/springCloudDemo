package com.chenxyz.springCloudDemo.web.controller.loadBalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenxyz on 2018/6/10.
 */
@RestController
@RequestMapping("/loadBalancer/feign")
public class FeignClientController {

    @Autowired
    EurekaFeignClent eurekaFeignClent;

    @Autowired
    AnnotationFeignClient annotationFeignClient;

    @Autowired
    PropertiesFeignClient propertiesFeignClient;

    @RequestMapping("/eureka/querySMS")
    public String eurekas() {
        return eurekaFeignClent.queryAll();
    }

    @RequestMapping("/annotation/querySMS")
    public String annotation() {
        return annotationFeignClient.queryAll();
    }

    @RequestMapping("/properties/querySMS")
    public String properties() {
        return propertiesFeignClient.queryAll();
    }

}

@FeignClient(name = "sms-service")
interface EurekaFeignClent {
    @RequestMapping(value="/sms", method = RequestMethod.GET)
    public String queryAll();
}

@FeignClient(name = "annotation-sms-service")
interface AnnotationFeignClient {
    @RequestMapping(value="/sms", method = RequestMethod.GET)
    public String queryAll();
}

@FeignClient(name = "properties-sms-service")
interface PropertiesFeignClient {
    @RequestMapping(value="/sms", method = RequestMethod.GET)
    public String queryAll();
}
