package com.github.asergejs.api

import groovy.json.JsonSlurper
import io.restassured.response.Response

class JsonParser {

    static def parseResponse(Response response) {
        return new JsonSlurper().parseText(response.asString())
    }

}
