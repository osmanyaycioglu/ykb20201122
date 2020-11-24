package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyConfiguration {


    @Autowired
    private Environment env;

    @Value("${exec.type}")
    private int         execType;

    @Bean
    @Qualifier("exec_v3")
    public IExecute executeCreateV3() {
        String propertyLoc = this.env.getProperty("exec.type");
        int type = Integer.parseInt(propertyLoc);
        switch (type) {
            case 1:
                return new MyExecImpl();
            case 2:
                return new MyExecImpl2();
            default:
                return new MyExecImpl();
        }
    }

    @Bean
    @Qualifier("exec_v4")
    public IExecute executeCreateV4() {
        switch (this.execType) {
            case 1:
                return new MyExecImpl();
            case 2:
                return new MyExecImpl2();
            default:
                return new MyExecImpl();
        }
    }

}
