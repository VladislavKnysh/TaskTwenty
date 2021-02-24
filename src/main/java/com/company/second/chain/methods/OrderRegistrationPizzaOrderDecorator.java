package com.company.second.chain.methods;

import com.company.second.chain.Order;
import com.company.second.exception.RegistrationFailException;
import com.company.second.Request;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
@RequiredArgsConstructor
public class OrderRegistrationPizzaOrderDecorator implements Order {
    private final Order order;

    private void execute(Request request) {
        String order = (request.getName() +
                "<" + request.getAddress() + ">: " + request.getOrder() + "\n");
        try {
            Files.write((new File("Order.txt").toPath()),
                    order.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RegistrationFailException("Failed to register the order");
        }

    }

    @Override
    public void toString(Request request) {
        execute(request);
        System.out.println("Register your order...");
        order.toString(request);
    }
}
