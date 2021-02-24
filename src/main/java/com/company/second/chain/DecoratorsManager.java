package com.company.second.chain;

import com.company.second.Request;
import com.company.second.chain.methods.CheckingRequestPizzaOrderDecorator;
import com.company.second.chain.methods.OrderRegistrationPizzaOrderDecorator;
import com.company.second.chain.methods.ReportPizzaOrderDecorator;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DecoratorsManager {
    private Request request;

    public void makeOrder(){
        Order order = new DefaultOrderExecutor();
        order = new ReportPizzaOrderDecorator(order);
        order = new OrderRegistrationPizzaOrderDecorator(order);
        order = new CheckingRequestPizzaOrderDecorator(order);
        order.toString(request);
        }

}
