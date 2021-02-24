package com.company.second;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    private String name;
    private String address;
    private String order;


}
