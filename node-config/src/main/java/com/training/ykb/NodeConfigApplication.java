package com.training.ykb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
//@EnableScheduling
//@EnableAsync
public class NodeConfigApplication {

    //    @Async
    //    public Future<String> name() {
    //        return null;
    //    }
    //    
    //    @Scheduled(fixedDelay = 10_000)
    //    public void sch() {
    //        System.out.println("klsdjfl");
    //    }

    public static void main(final String[] args) {
        SpringApplication.run(NodeConfigApplication.class,
                              args);
    }

}
