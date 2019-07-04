package com.kinsey.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dong_gui on 2019-06-24.
 */
@FeignClient(value = "provider-service", path = "/provider")
public interface ProviderClient {

    @GetMapping("/test")
    ApiErrorResponse test(@RequestParam("name") String name);
}
