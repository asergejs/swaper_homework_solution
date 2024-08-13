package com.github.asergejs.api

import com.github.asergejs.context.SessionContext
import io.restassured.builder.RequestSpecBuilder
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

import static io.restassured.RestAssured.given

class ApiConfiguration {

    private final String BASE_URI = "https://swaper.com"
    private final String CONTENT_TYPE = "application/json;charset=UTF-8"
    private final String ACCEPT = "application/json, text/plain, */*"

    protected ResponseValidator responseValidator = new ResponseValidator()

    RequestSpecification publicSpec() {
        return given(new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(CONTENT_TYPE)
                .setAccept(ACCEPT)
                .build())
    }

    RequestSpecification authorizedSpec() {
        return publicSpec()
                .header('X-XSRF-TOKEN', SessionContext.csrfToken)
                .header('Cookie', "JSESSIONID=${SessionContext.sessionId}")
    }

    static void saveSession(Response response) {
        SessionContext.csrfToken = response.getHeader('_csrf')
        SessionContext.sessionId = response.getSessionId()
    }
}
