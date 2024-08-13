package com.github.asergejs.api

import static com.github.asergejs.api.JsonParser.parseResponse

class ClientBalanceApi extends ApiConfiguration {

    def fetchAccountEntries(String payload) {
        def response = authorizedSpec()
                .body(payload)
                .post("/rest/public/profile/account-entries")
        responseValidator.validateResponse(response)
        return parseResponse(response)
    }

}
