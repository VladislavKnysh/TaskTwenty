package com.company.second.chain.methods;


import com.company.second.Request;
import com.company.second.chain.Order;
import com.company.second.exception.RequestDenialException;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class CheckingRequestPizzaOrderDecorator implements Order {
    private final Order order;


    private void execute(Request request) {
        checkRequest(request);
        if (!findInMenu(request.getOrder())) {
            throw new RequestDenialException("We have no such thing in our menu.");
        }
        new CheckingRequestPizzaOrderDecorator(order);

    }

    private void checkRequest(Request request) {
        if (!Objects.nonNull(request.getAddress())) {
            throw new RequestDenialException("There is no address in request.");
        }
        if (!Objects.nonNull(request.getOrder())) {
            throw new RequestDenialException("There is no order in request.");
        }
        if (!Objects.nonNull(request.getName())) {
            throw new RequestDenialException("There is no name in request.");
        }
    }

    private boolean findInMenu(String s) {
        try {
            List<String> lines = Files.readAllLines((new File("Menu.txt")).toPath());

            for (String line : lines) {

                Pattern pattern = Pattern.compile(s);
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {

                    return true;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void toString(Request request) {
        execute(request);
        System.out.println("Checking your order...");
        order.toString(request);
    }
}
