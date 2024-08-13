package com.github.asergejs.api

class AuthorizationApi extends ApiConfiguration {

    void logIn(String payload) {
        def response = publicSpec()
                .body(payload)
                .post("/rest/public/login")
        responseValidator.validateResponse(response)
        saveSession(response)
    }

}
