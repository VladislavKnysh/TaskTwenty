package com.company.first.chain;

import com.company.first.Request;
import com.company.first.chain.methods.CheckRequestPizzaOrderHandler;
import com.company.first.chain.methods.OrderRegistrationPizzaOrderHandler;
import com.company.first.chain.methods.PizzaOrderHandler;
import com.company.first.chain.methods.ReportPizzaOrderHandler;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ChainManager {
    private Request request;

    public void makeOrder(){
        PizzaOrderHandler stepThree = new ReportPizzaOrderHandler();
        PizzaOrderHandler stepTwo = new OrderRegistrationPizzaOrderHandler(stepThree);
        PizzaOrderHandler stepOne =new CheckRequestPizzaOrderHandler(stepTwo);


        stepOne.handleRequest(request);
    }


}
