package com.company.first.chain.methods;

import com.company.first.Request;
import com.company.first.exception.RequestDenialException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRequestPizzaOrderHandler extends PizzaOrderHandler {

    public CheckRequestPizzaOrderHandler(PizzaOrderHandler nextHandler) {
        super(nextHandler);
    }

    public void handleRequest(Request request) {
        checkRequest(request);
        if (!findInMenu(request.getOrder())) {
            throw new RequestDenialException("We have no such thing in our menu.");
        }

        next(request);
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


}
