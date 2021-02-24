package com.company.second.chain;

import com.company.second.Request;

public class DefaultOrderExecutor implements Order {
    @Override
    public void toString(Request request) {
        System.out.println(request.getName() +
                "<" + request.getAddress() + ">: " + request.getOrder() + "\n");
    }
}
