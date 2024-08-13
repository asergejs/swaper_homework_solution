package com.github.asergejs.steps

import com.github.asergejs.api.AuthorizationApi
import io.cucumber.java.en.Given

import static groovy.json.JsonOutput.toJson

class AuthorizationSteps {

    private AuthorizationApi authorizationApi

    AuthorizationSteps(AuthorizationApi authorizationApi) {
        this.authorizationApi = authorizationApi
    }

    @Given("^client logs in with username: (.*) u and password: (.*)?")
    void loginWithCredentials(String username, String password) {
       String payload = toJson([name : username, password : password])
       authorizationApi.logIn(payload)
    }


}
