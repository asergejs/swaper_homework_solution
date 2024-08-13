package com.github.asergejs.payloads

import groovy.json.JsonGenerator

abstract class RequestBuilder {

    abstract Map populateDefaultValues(Map customValues = [:])

    private Map payloadValues = [:]

    RequestBuilder withDefaultParams() {
        this.payloadValues = populateDefaultValues([:])
        return this
    }

    RequestBuilder withCustomParams(Map customValues) {
        this.payloadValues = populateDefaultValues(customValues)
        return this
    }

    String build() {
        return new JsonGenerator.Options()
                .disableUnicodeEscaping()
                .build()
                .toJson(payloadValues)
    }

}
