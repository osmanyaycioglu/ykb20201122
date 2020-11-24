package com.training.ykb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MySpringBean {

    @Autowired
    @Qualifier("exec_v4")
    private IExecute       exe;

    private final IExecute exe2;

    private IExecute       exec3;


    @Autowired
    public MySpringBean(@Qualifier("exec_v4") final IExecute exe2) {
        this.exe2 = exe2;
    }

    @Autowired
    public void methodWire(@Qualifier("exec_v4") final IExecute exec3) {
        this.exec3 = exec3;
    }

    @PostConstruct
    public void init() {
        this.exe.execute("test");
    }

    @PreDestroy
    public void destroy() {

    }

    public String yap() {
        String executeLoc = this.exe.execute("osman");
        System.out.println(executeLoc);
        return executeLoc;
    }

}
