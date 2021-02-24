package com.company.third;

import com.company.third.dto.CreateUserRequest;
import com.company.third.dto.StatusResponse;
import com.company.third.dto.UserResponse;
import com.company.third.facade.JsonHttpFacade;

public class Main {
    public static void main(String[] args) {
        JsonHttpFacade jsonHttp = new JsonHttpFacade();

        UserResponse resp = jsonHttp.get("http://example.com/users", UserResponse.class);

        CreateUserRequest req = new CreateUserRequest(
                "examplelogin",
                "examplepass"
        );

        StatusResponse resp2 = jsonHttp.post(
                "http://example.com/register",
                req,
                StatusResponse.class
        );
    }
}
