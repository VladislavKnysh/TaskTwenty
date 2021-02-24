package com.company.first.chain.methods;

import com.company.first.Request;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class PizzaOrderHandler {
    private PizzaOrderHandler nextHandler = null;
    abstract public void handleRequest(Request request);

    protected void next(Request request){
        if (Objects.nonNull(nextHandler)){
            nextHandler.handleRequest(request);
        }
    }
}
