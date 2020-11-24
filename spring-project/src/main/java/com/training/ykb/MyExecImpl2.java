package com.training.ykb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("exec_v2")
public class MyExecImpl2 implements IExecute {

    @Override
    public String execute(final String strParam) {
        return "Merhaba " + strParam;
    }

}
