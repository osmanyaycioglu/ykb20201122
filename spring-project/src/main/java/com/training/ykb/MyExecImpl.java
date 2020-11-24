package com.training.ykb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("exec_v1")
// @Scope("prototype")
public class MyExecImpl implements IExecute {

    private final List<Integer> list  = Collections.synchronizedList(new ArrayList<>());
    private final List<Integer> list2 = new Vector<>();

    @Override
    public String execute(final String strParam) {
        return "Hello " + strParam;
    }

}
