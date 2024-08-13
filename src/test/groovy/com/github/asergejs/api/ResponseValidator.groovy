package com.github.asergejs.api

import io.restassured.response.Response

class ResponseValidator {

    private final int DEFAULT_STATUS_CODE = 200

    void validateResponse(Response response, expectedStatusCode = DEFAULT_STATUS_CODE) {
        if(response.statusCode() == expectedStatusCode) {
            return
        }
        throw new AssertionError("Expected status code to be $expectedStatusCode but was ${response.statusCode()}")
    }

}
