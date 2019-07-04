package com.kinsey.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by dong_gui on 2019-06-24.
 */
@RestController
@RequestMapping("/provider")
public class NameController {

    @GetMapping("/test")
    public Mono<String> test(/*@RequestParam("name") String name*/) throws InterruptedException {
       /* if (name.startsWith("s")) {
            throw new ServerErrorException("异常");
        }*/
       Thread.sleep(500);
        return Mono.just("hello " + "11");
    }
}
