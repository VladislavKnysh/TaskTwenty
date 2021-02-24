package com.company.first.chain.methods;

import com.company.first.Request;
import com.company.first.exception.RegistrationFailException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class OrderRegistrationPizzaOrderHandler extends PizzaOrderHandler {

    public OrderRegistrationPizzaOrderHandler(PizzaOrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        String order = (request.getName() +
                "<" + request.getAddress() + ">: " + request.getOrder() + "\n");
        try {
            Files.write((new File("Order.txt").toPath()),
                    order.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RegistrationFailException("Failed to register the order");
        }
        next(request);
    }
}
