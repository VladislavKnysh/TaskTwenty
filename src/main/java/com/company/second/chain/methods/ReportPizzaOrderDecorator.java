package com.company.second.chain.methods;

import com.company.second.chain.Order;
import com.company.second.exception.ReportFailException;
import com.company.second.Request;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@RequiredArgsConstructor
public class ReportPizzaOrderDecorator implements Order {
    int orderNumber= 0;
    private final Order order;

    private void execute(Request request) {
        String orderPattern = "(?:"+(request.getName() +
                "<" + request.getAddress() + ">: " + request.getOrder() + ")");
        boolean found = false;
        try {
            List<String> lines = Files.readAllLines((new File("Order.txt").toPath()));

            for (String line : lines) {
                orderNumber++;
                Pattern pattern = Pattern.compile(orderPattern);
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    found = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!found) {
            throw new ReportFailException("There is no such registered orders");
        }
    }

    @Override
    public void toString(Request request) {
        execute(request);
        System.out.printf("Pizza will be ready in %d minutes!\n", (orderNumber * 15));
        order.toString(request);
    }
}
