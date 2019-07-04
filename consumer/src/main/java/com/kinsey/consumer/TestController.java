package com.kinsey.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dong_gui on 2019-06-24.
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestController {

    private ProviderClient providerClient;

    private DiscoveryClient discoveryClient;

    @GetMapping
    public String test(@RequestParam("name") String name) {
        try {
            providerClient.test(name);
        } catch (Exception e) {
            log.error("", e);
        }
        return null;
    }

    @RequestMapping("/services")
    public List<ServiceInstance> services() {
        return discoveryClient.getInstances("provider-service");
    }

}
