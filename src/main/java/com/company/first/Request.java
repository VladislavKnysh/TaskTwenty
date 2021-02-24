package com.company.first;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    private String name;
    private String address;
    private String order;
}
