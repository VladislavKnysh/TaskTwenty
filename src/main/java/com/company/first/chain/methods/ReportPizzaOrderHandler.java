package com.company.first.chain.methods;

import com.company.first.Request;
import com.company.first.exception.ReportFailException;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class ReportPizzaOrderHandler extends PizzaOrderHandler {


    @Override
    public void handleRequest(Request request) {
        searchInOrderList(request);
    }

    private void searchInOrderList(Request request) {
        String orderPattern = "(?:"+(request.getName() +
                "<" + request.getAddress() + ">: " + request.getOrder() + ")");
        int orderNumber = 0;
        boolean found = false;
        try {
            List<String> lines = Files.readAllLines((new File("Order.txt").toPath()));

            for (String line : lines) {
                orderNumber++;
                Pattern pattern = Pattern.compile(orderPattern);
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    System.out.printf("Pizza will be ready in %d minutes!\n", (orderNumber * 15));
                    found = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!found) {
            throw new ReportFailException("There is no such registered orders");
        }
        next(request);
    }
}
